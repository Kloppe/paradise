/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.support.factory.impl;

import com.github.houbb.paradise.common.annotation.dev.API;
import com.github.houbb.paradise.common.datasource.support.factory.IConnectionFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p> 数据驱动连接工厂类 </p>
 *
 * <pre> Created: 2018/6/27 下午4:42  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5
 */
@API(status = API.Status.EXPERIMENTAL)
public class DriverConnectionFactory implements IConnectionFactory {

    /**
     * 数据库驱动信息
     */
    private Driver driver;

    /**
     * 数据连接信息
     */
    private String url;

    /**
     * 数据库配置信息
     */
    private Properties properties;

    public DriverConnectionFactory(Driver driver, String url, Properties properties) {
        this.driver = driver;
        this.url = url;
        this.properties = properties;
    }

    @Override
    public Connection createConnection() throws SQLException {
        return driver.connect(url, properties);
    }

}
