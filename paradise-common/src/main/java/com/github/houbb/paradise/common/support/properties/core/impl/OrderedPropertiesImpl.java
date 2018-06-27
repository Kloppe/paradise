/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.support.properties.core.impl;

import com.github.houbb.paradise.common.annotation.dev.API;
import com.github.houbb.paradise.common.support.properties.core.IProperties;
import com.github.houbb.paradise.common.support.properties.domain.OrderedProperties;
import com.github.houbb.paradise.common.support.properties.exception.PropertiesRuntimeException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * <p> 有序的属性 </p>
 *
 * <pre> Created: 2018/6/27 下午2:38  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5, 2018-06-27 14:40:04
 */
@API(status = API.Status.EXPERIMENTAL)
public class OrderedPropertiesImpl implements IProperties {

    /**
     * 配置文件路径
     */
    private final String propertiesPath;

    /**
     * 文件编码
     */
    private final String charset;

    /**
     * 有序属性
     */
    private final Properties orderedProperties = new OrderedProperties();

    public OrderedPropertiesImpl(String propertiesPath, String charset) {
        this.propertiesPath = propertiesPath;
        this.charset = charset;
        initProperties();
    }


    /**
     * 初始化属性
     */
    private void initProperties() {
        try (InputStream inputStream = getInputStream(propertiesPath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset)) {
            orderedProperties.load(inputStreamReader);
        } catch (IOException e) {
            throw new PropertiesRuntimeException(e);
        }
    }

    @Override
    public String get(String key) {
        return orderedProperties.getProperty(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return orderedProperties.getProperty(key, defaultValue);
    }

    @Override
    public synchronized String set(String key, String value) {
        try (OutputStream outputStream = new FileOutputStream(propertiesPath)) {
            orderedProperties.setProperty(key, value);
            orderedProperties.store(outputStream, null);
            return value;
        } catch (IOException e) {
            throw new PropertiesRuntimeException(e);
        }
    }

    /**
     * 获取文件对应输入流
     *
     * @param filePath 文件路径
     * @return 文件输入流信息
     */
    private InputStream getInputStream(final String filePath) {
        InputStream inputStream;

        try {
            inputStream = new URL(filePath).openStream();
        } catch (MalformedURLException localMalformedURLException) {
            try {
                inputStream = new FileInputStream(filePath);
            } catch (Exception localException2) {
                ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
                if (localClassLoader == null) {
                    localClassLoader = OrderedPropertiesImpl.class.getClassLoader();
                }
                inputStream = localClassLoader.getResourceAsStream(filePath);
                if (inputStream == null) {
                    throw new PropertiesRuntimeException("Could not find file: " + filePath);
                }
            }
        } catch (IOException localIOException1) {
            throw new PropertiesRuntimeException(localIOException1);
        }

        return inputStream;
    }
}
