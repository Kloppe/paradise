/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.core.impl;

import com.github.houbb.paradise.common.annotation.dev.API;
import com.github.houbb.paradise.common.datasource.constant.DatasourceConstant;
import com.github.houbb.paradise.common.datasource.core.IDataSource;
import com.github.houbb.paradise.common.datasource.domain.DataSourceConfig;
import com.github.houbb.paradise.common.datasource.domain.PoolConnection;
import com.github.houbb.paradise.common.datasource.exception.DataSourceException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p> 基本的数据库信息链接 </p>
 *
 * <pre> Created: 2018/6/27 下午2:26  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5
 */
@API(status = API.Status.EXPERIMENTAL)
public class BasicDataSource implements IDataSource {

    /**
     * 连接信息
     */
    private List<PoolConnection> poolConnections = new CopyOnWriteArrayList<>();

    /**
     * 数据源配置
     */
    private final DataSourceConfig config;

    public BasicDataSource(DataSourceConfig config) {
        this.config = config;
        checkConfig();
        registerDriver();
        createConnections(config.getInitSize());
    }

    /**
     * fast-fail
     */
    private void checkConfig() {

    }

    /**
     * 注册数据库驱动信息
     */
    private void registerDriver() {
        try {
            Driver driver = (Driver) Class.forName(config.getDriver()).newInstance();
            DriverManager.registerDriver(driver);
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public Connection getConnection() {
        if(poolConnections.isEmpty()) {
            throw new DataSourceException("连接池信息为空");
        }
        return getActiveConnection();
    }

    /**
     * 获取活跃的数据库链接信息
     * @return 数据库链接
     */
    private synchronized Connection getActiveConnection() {
        while (true) {
            for(PoolConnection poolConnection : poolConnections) {
                if(!poolConnection.isBusy()) {
                    //1. 验证是否失效
                    validConnection(poolConnection);
                    poolConnection.setBusy(true);
                    return poolConnection.getConnection();
                }
            }

            //创建新的数组
            createConnections(DatasourceConstant.Config.DEFAULT_STEP);
        }
    }

    /**
     * 创建连接信息
     * @param size 大小
     */
    private synchronized void createConnections(int size) {
        try {
            if(size + poolConnections.size() > config.getMaxSize()) {
                return;
            }

            for(int i = 0 ; i < size; i++) {
                Connection connection = DriverManager.getConnection(config.getUrl(),
                        config.getUsername(), config.getPassword());
                PoolConnection poolConnection = new PoolConnection(connection, false);
                poolConnections.add(poolConnection);
            }
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    /**
     * 校验链接
     * @param poolConnection 链接信息
     */
    private void validConnection(PoolConnection poolConnection) {
        try {
            Connection connection = poolConnection.getConnection();
            if(connection.isValid(0)) {
                poolConnection.setConnection(DriverManager.getConnection(config.getUrl(),
                        config.getUsername(), config.getPassword()));
            }
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

}
