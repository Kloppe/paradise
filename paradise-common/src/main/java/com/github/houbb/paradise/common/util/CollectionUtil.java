package com.github.houbb.paradise.common.util;

import java.util.*;

/**
 * Created by bbhou on 2017/7/31.
 */
public class CollectionUtil {

    public static List EMPTY_LIST = Collections.EMPTY_LIST;

    public static boolean isEmpty(Collection collection) {
        return null == collection
                || collection.size() == 0;
    }

}
