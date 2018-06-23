package com.github.houbb.paradise.enhance.core.generator.model;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/**
 * JDK 自带的 properties 继承自 Hashtable<Object,Object>() 所以保存后的顺序是未知的。
 * 1. 此类用于解决乱序问题
 *
 * @author bbhou
 * @date 2017/8/30
 */
public class OrderedProperties extends Properties {

    private static final long serialVersionUID = 2947634825630441807L;

    private final LinkedHashSet<Object> keys = new LinkedHashSet<>();

    @Override
    public Enumeration<Object> keys() {
        return Collections.enumeration(keys);
    }

    @Override
    public Object put(Object key, Object value) {
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
