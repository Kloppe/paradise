package com.github.houbb.paradise.common.util;

import com.github.houbb.paradise.common.constant.JavaDocConstant;

public class JavaDocUtil {

    public static String buildComment(final String comment) {
        final String commentFormat = "%s\n%s\n%s";
        return String.format(commentFormat, JavaDocConstant.COMMENT_PREFIX, comment, JavaDocConstant.COMMENT_SUFFIX);
    }

    public static void main(String[] args) {
        System.out.println(buildComment("hell wol"));
    }

}
