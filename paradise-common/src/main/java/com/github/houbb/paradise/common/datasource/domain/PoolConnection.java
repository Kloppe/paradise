/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.domain;

import com.github.houbb.paradise.common.annotation.dev.API;

import java.sql.Connection;

/**
 * <p> 线程池数据库连接 </p>
 *
 * <pre> Created: 2018/6/27 上午10:18  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5, 2018-06-27 10:19:38
 */
@API(status = API.Status.EXPERIMENTAL)
public class PoolConnection implements AutoCloseable {

    /**
     * 数据库链接信息
     */
    private Connection connection;
    /**
     * 是否正在使用
     */
    private boolean isBusy;

    public PoolConnection(Connection connection) {
        this(connection, false);
    }

    public PoolConnection(Connection connection, boolean isBusy) {
        this.connection = connection;
        this.isBusy = isBusy;
    }

    @Override
    public void close() throws Exception {
        this.isBusy = false;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
