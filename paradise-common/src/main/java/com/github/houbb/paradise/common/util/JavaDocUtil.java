package com.github.houbb.paradise.common.util;

import com.github.houbb.paradise.common.constant.JavaDocConstant;

/**
 * java 文档工具类
 * @author bbhou
 * @version 1.1.4
 * @since 1.1.4, 2018/01/29
 */
public final class JavaDocUtil {

    private JavaDocUtil(){}

    public static String buildComment(final String comment) {
        final String commentFormat = "%s\n%s\n%s";
        return String.format(commentFormat, JavaDocConstant.COMMENT_PREFIX, comment, JavaDocConstant.COMMENT_SUFFIX);
    }

}
