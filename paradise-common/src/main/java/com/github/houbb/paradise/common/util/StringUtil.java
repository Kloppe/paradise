package com.github.houbb.paradise.common.util;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串工具类
 * @version 1.1.0
 * @author bbhou
 */
public class StringUtil {

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * 是否为空
     * @param string 字符串
     * @return {@code true} 为空
     */
    public static boolean isEmpty(final String string) {
        return null == string || EMPTY.equals(string);
    }

    /**
     * 是否为非空
     * @param string 字符串
     * @return {@code true} 为非空
     */
    public static boolean isNotEmpty(final String string) {
        return !isEmpty(string);
    }

    /**
     * 是否为空
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isBlank(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /**
     * 是否不为空
     * @param str 字符串
     * @return 是否不为空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 对字符串列表每条字符串执行trim()操作。
     * 1. 空直接返回空列表
     * @param stringList 原始的列表
     * @return trim 的字符串列表
     */
    public static List<String> trimList(final List<String> stringList) {
        if(CollectionUtil.isEmpty(stringList)) {
            return CollectionUtil.EMPTY_LIST;
        }

        List<String> resultList = new LinkedList<>();
        for(String original : stringList) {
            resultList.add(original.trim());
        }

        return resultList;
    }

    /**
     * 根据任意多的空格进行分割字符串。
     * 1. 入参为空,则返回空字符串数组
     * @return 割字符串数组
     */
    public static String[] splitByAnyBlank(final String string) {
        if(StringUtil.isEmpty(string)) {
            return new String[0];
        }

        final String pattern = "\\s+";
        return string.split(pattern);
    }


    /**
     * 获取的驼峰写法。
     * 1.这是 mybatis-gen 源码
     * @param inputString 输入字符串
     * @param firstCharacterUppercase 首字母是否大写。
     * @return  驼峰写法
     */
    public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            switch (c) {
                case '_':
                case '-':
                case '@':
                case '$':
                case '#':
                case ' ':
                case '/':
                case '&':
                    if (sb.length() > 0) {
                        nextUpperCase = true;
                    }
                    break;

                default:
                    if (nextUpperCase) {
                        sb.append(Character.toUpperCase(c));
                        nextUpperCase = false;
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
                    break;
            }
        }

        if (firstCharacterUppercase) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }

    /**
     * 首字母小写
     * @param str 字符串
     * @return 首字母小写字符串
     */
    public static String firstToLowerCase(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 首字母大写
     * @param str 字符串
     * @return 首字母大写结果
     */
    public static String firstToUpperCase(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 默认为 “”
     * 1. 如果为 null TO ""
     * 2. 返回本身
     * @param string 字符串
     * @return 非 null 的字符串
     */
    public static String defaultEmpty(final String string) {
        if(isEmpty(string)) {
            return EMPTY;
        }
        return string;
    }

}
