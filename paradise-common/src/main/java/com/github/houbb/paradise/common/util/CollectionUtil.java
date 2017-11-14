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

}
