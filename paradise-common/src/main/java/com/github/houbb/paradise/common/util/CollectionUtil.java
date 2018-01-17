package com.github.houbb.paradise.common.util;

import java.util.*;

/**
 * 集合工具类
 *
 * @author bbhou
 * @version 1.1.0
 */
public class CollectionUtil {


    public static List EMPTY_LIST = Collections.EMPTY_LIST;

    /**
     * 是否为空
     * @param collection    集合
     * @return {@code true} 是
     */
    public static boolean isEmpty(Collection collection) {
        return null == collection
                || collection.size() == 0;
    }

    /**
     * 是否不为空
     * @param collection    集合
     * @return  {@code true} 是
     * @since 1.1.2
     */
    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    /**
     * 根据数组返回对应列表
     * @param array string array
     * @return string list
     */
    public static List<String> arrayToList(String[] array) {
        if(ArrayUtil.isEmpty(array)) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(array);
    }


    /**
     * 列表转数组
     * @param stringList string list
     * @return string array
     */
    public static String[] listToArray(List<String> stringList) {
        String[] strings = new String[stringList.size()];
        return stringList.toArray(strings);
    }

}
