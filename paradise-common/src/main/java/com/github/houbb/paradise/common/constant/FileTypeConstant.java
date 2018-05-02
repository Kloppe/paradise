package com.github.houbb.paradise.common.constant;

/**
 * 文件类型
 * @author bbhou
 * @version 1.1.4
 * @since 1.1.4, 2018/01/29
 */
public final class FileTypeConstant {

    private FileTypeConstant(){}

    /**
     * 文件类型过滤
     */
    public static class Glob {
        private Glob(){}

        /**
         * 所有文件类型
         */
        public static final String ALL = "*.*";
    }

    /**
     * 压缩文件
     */
    public static class Compress {
        private Compress(){}

        public static final String ZIP = ".zip";
        public static final String RAR = ".rar";
        public static final String JAR = ".jar";
    }

    /**
     * 图片
     */
    public static class Image {
        private Image(){}

        public static final String PNG = ".png";
        public static final String JPG = ".jpg";
    }

}
