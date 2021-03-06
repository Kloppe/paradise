package com.github.houbb.paradise.common.util.path;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Simple utility class used to getConnection access to files at the classpath, or packed into jar.
 * Based on Spring ClassPathResource implementation + jar internals access implemented.
 *
 *
 * 使用方式：String path = new ClassPathResource("resourceName").getFile().getAbsolutePath();
 *
 * @author raver119@gmail.com
 * @author houbinbin 调整
 */
public class ClassPathResource {

    /**
     * 资源文件名称
     */
    private String resourceName;

    /**
     * Builds new ClassPathResource object
     *
     * @param resourceName String name of resource, to be retrieved
     */
    public ClassPathResource(String resourceName) {
        if (resourceName == null) {
            throw new IllegalStateException("Resource name can't be null");
        }

        this.resourceName = resourceName;
    }

    /**
     *  Returns URL of the requested resource
     *
     * @return URL of the resource, if it's available in current Jar
     */
    private URL getUrl() {
        ClassLoader loader = null;
        try {
            loader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            // do nothing
        }

        if (loader == null) {
            loader = ClassPathResource.class.getClassLoader();
        }

        URL url = loader.getResource(this.resourceName);
        if (url == null) {
            // try to check for mis-used starting slash
            // TODO: see TODO below
            if (this.resourceName.startsWith("/")) {
                url = loader.getResource(this.resourceName.replaceFirst("[\\\\/]", ""));
                if (url != null)
                    return url;
            } else {
                // try to add slash, to make clear it's not an issue
                // TODO: change this mechanic to actual path purifier
                url = loader.getResource("/" + this.resourceName);
                if (url != null)
                    return url;
            }
            throw new IllegalStateException("Resource '" + this.resourceName + "' cannot be found.");
        }
        return url;
    }

    /**
     * Returns requested ClassPathResource as File object
     *
     * Please note: if this method called from compiled jar, temporary file or dir will be created to provide File access
     *
     * @return File requested at constructor call
     * @throws FileNotFoundException if any
     */
    public File getFile() throws FileNotFoundException {
        return getFile(null);
    }

    /**
     * Returns requested ClassPathResource as File object
     *
     * Please note: if this method called from compiled jar, temporary file or dir will be created to provide File access
     *
     * @param suffix suffix of temporary file (if null suffix == "file" or "dir")
     * @return File requested at constructor call
     * @throws FileNotFoundException if any
     */
    public File getFile(String suffix) throws FileNotFoundException {
        URL url = this.getUrl();

        if (isJarURL(url)) {
            /*
                This is actually request for file, that's packed into jar. Probably the current one, but that doesn't matters.
             */
            try {
                GetStreamFromZip getStreamFromZip = new GetStreamFromZip(url, resourceName).invoke();
                ZipEntry entry = getStreamFromZip.getEntry();
                InputStream stream = getStreamFromZip.getStream();
                ZipFile zipFile = getStreamFromZip.getZipFile();
                url = getStreamFromZip.getUrl();

                if (entry.isDirectory() || stream == null) {
                    zipFile.close();

                    File dir = new File(System.getProperty("java.io.tmpdir"),
                            "datavec_temp" + System.nanoTime() + (suffix != null ? suffix : "dir"));
                    if (dir.mkdir()) {
                        dir.deleteOnExit();
                    }
                    ArchiveUtils.unzipFileTo(url.getFile(), dir.getAbsolutePath());
                    return new File(dir, this.resourceName);
                }

                long size = entry.getSize();
                File file = File.createTempFile("datavec_temp", (suffix != null ? suffix : "file"));
                file.deleteOnExit();

                try(FileOutputStream outputStream = new FileOutputStream(file);) {
                    byte[] array = new byte[1024];
                    int rd = 0;
                    long bytesRead = 0;
                    do {
                        rd = stream.read(array);
                        outputStream.write(array, 0, rd);
                        bytesRead += rd;
                    } while (bytesRead < size);

                    outputStream.flush();
                }

                stream.close();
                zipFile.close();

                return file;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            /*
                It's something in the actual underlying filesystem, so we can just go for it
             */

            try {
                URI uri = new URI(url.toString().replaceAll(" ", "%20"));
                return new File(uri.getSchemeSpecificPart());
            } catch (URISyntaxException e) {
                return new File(url.getFile());
            }
        }
    }

    /**
     * Checks, if proposed URL is packed into archive.
     *
     * @param url URL to be checked
     * @return True, if URL is archive entry, False otherwise
     */
    private boolean isJarURL(URL url) {
        String protocol = url.getProtocol();
        return "jar".equals(protocol) || "zip".equals(protocol) || "wsjar".equals(protocol)
                || "code-source".equals(protocol) && url.getPath().contains("!/");
    }



    /**
     * Returns requested ClassPathResource as InputStream object
     *
     * @return File requested at constructor call
     * @throws FileNotFoundException if any
     */
    public InputStream getInputStream() throws FileNotFoundException {
        URL url = this.getUrl();
        if (isJarURL(url)) {
            try {
                GetStreamFromZip getStreamFromZip = new GetStreamFromZip(url, resourceName).invoke();
                return getStreamFromZip.getStream();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            File srcFile = this.getFile();
            return new FileInputStream(srcFile);
        }
    }

    private class GetStreamFromZip {
        private URL url;
        private ZipFile zipFile;
        private ZipEntry entry;
        private InputStream stream;
        private String resourceName;

        public GetStreamFromZip(URL url, String resourceName) {
            this.url = url;
            this.resourceName = resourceName;
        }

        public URL getUrl() {
            return url;
        }

        public ZipFile getZipFile() {
            return zipFile;
        }

        public ZipEntry getEntry() {
            return entry;
        }

        public InputStream getStream() {
            return stream;
        }

        public GetStreamFromZip invoke() throws IOException {
            url = extractActualUrl(url);

            zipFile = new ZipFile(url.getFile());
            entry = zipFile.getEntry(this.resourceName);
            if (entry == null) {
                if (this.resourceName.startsWith("/")) {
                    entry = zipFile.getEntry(this.resourceName.replaceFirst("/", ""));
                    if (entry == null) {
                        throw new FileNotFoundException("Resource " + this.resourceName + " not found");
                    }
                } else
                    throw new FileNotFoundException("Resource " + this.resourceName + " not found");
            }

            stream = zipFile.getInputStream(entry);
            return this;
        }

        /**
         * Extracts parent Jar URL from original ClassPath entry URL.
         *
         * @param jarUrl Original URL of the resource
         * @return URL of the Jar file, containing requested resource
         * @throws MalformedURLException if any
         */
        private URL extractActualUrl(URL jarUrl) throws MalformedURLException {
            String urlFile = jarUrl.getFile();
            int separatorIndex = urlFile.indexOf("!/");
            if (separatorIndex != -1) {
                String jarFile = urlFile.substring(0, separatorIndex);

                try {
                    return new URL(jarFile);
                } catch (MalformedURLException var5) {
                    if (!jarFile.startsWith("/")) {
                        jarFile = "/" + jarFile;
                    }

                    return new URL("file:" + jarFile);
                }
            } else {
                return jarUrl;
            }
        }
    }

}
