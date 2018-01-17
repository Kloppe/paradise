/*-
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package com.github.houbb.paradise.common.util.path;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Adam Gibson
 * @author houbinbin 删除 .tar .tar.gz .tgz .gz 的支持
 */
public class ArchiveUtils {


    /**
     * Extracts files to the specified destination
     * @param file the file to extract to
     * @param dest the destination directory
     * @throws IOException if any
     */
    public static void unzipFileTo(String file, String dest) throws IOException {
        File target = new File(file);
        if (!target.exists())
            throw new IllegalArgumentException("Archive doesnt exist");
        FileInputStream fin = new FileInputStream(target);
        int BUFFER = 2048;
        byte data[] = new byte[BUFFER];

        if (file.endsWith(".zip") || file.endsWith(".jar")) {
            //getFromOrigin the zip file content
            ZipInputStream zis = new ZipInputStream(fin);
            //getFromOrigin the zipped file list entry
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {
                String fileName = ze.getName();

                File newFile = new File(dest + File.separator + fileName);

                if (ze.isDirectory()) {
                    newFile.mkdirs();
                    zis.closeEntry();
                    ze = zis.getNextEntry();
                    continue;
                }

//                log.debug("file unzip : " + newFile.getAbsoluteFile());

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder


                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(data)) > 0) {
                    fos.write(data, 0, len);
                }

                fos.flush();
                fos.close();
                zis.closeEntry();
                ze = zis.getNextEntry();
            }

            zis.close();


        }

    }


}
