/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.support.factory.impl;

import com.github.houbb.paradise.common.annotation.dev.API;
import com.github.houbb.paradise.common.datasource.support.factory.IConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
public class DefaultConnectionFactory implements IConnectionFactory {

    /**
     * 数据连接信息
     */
    private final String url;

    /**
     * 数据库配置信息
     */
    private final String username;

    /**
     * 数据库配置信息
     */
    private final String password;

    public DefaultConnectionFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
