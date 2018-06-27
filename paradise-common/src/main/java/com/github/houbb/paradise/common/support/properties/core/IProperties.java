/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.support.properties.core;

import com.github.houbb.paradise.common.annotation.dev.API;

/**
 * <p> 属性接口 </p>
 *
 * <pre> Created: 2018/6/27 下午2:33  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@API(status = API.Status.EXPERIMENTAL)
public interface IProperties {

    /**
     * 获取属性
     * @param key key
     * @return 属性
     */
    String get(String key);

    /**
     * 获取属性
     * @param key key
     * @param defaultValue 默认属性
     * @return 属性
     */
    String get(String key, String defaultValue);

    /**
     * 设置属性
     * @param key key
     * @param value 值
     * @return 设置的值
     */
    String set(String key, String value);

}
