/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.support.properties.domain;

import com.github.houbb.paradise.common.annotation.dev.API;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/**
 * <p> 有序的属性 </p>
 * JDK 自带的 properties 继承自 Hashtable() 所以保存后的顺序是未知的。
 * 1. 用于保证修改之后属性是有顺序的
 *
 * <pre> Created: 2018/6/27 下午2:29  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@API(status = API.Status.EXPERIMENTAL)
public class OrderedProperties extends Properties {

    private static final long serialVersionUID = -8184261504630657063L;

    private final LinkedHashSet<Object> keys = new LinkedHashSet<>();

    @Override
    public Enumeration<Object> keys() {
        return Collections.enumeration(keys);
    }

    @Override
    public synchronized Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }

    @Override
    public Set<Object> keySet() {
        return keys;
    }

    @Override
    public Set<String> stringPropertyNames() {
        Set<String> set = new LinkedHashSet<>();

        for (Object key : this.keys) {
            set.add((String) key);
        }

        return set;
    }

}
