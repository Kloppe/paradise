/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.support.factory;

import com.github.houbb.paradise.common.annotation.dev.API;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p> 数据库连接工厂 </p>
 *
 * <pre> Created: 2018/6/27 下午4:31  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5
 */
@API(status = API.Status.EXPERIMENTAL)
public interface IConnectionFactory {

    /**
     * Create a new {@link Connection} in an
     * implementation specific fashion.
     *
     * @return a new {@link Connection}
     * @throws SQLException if a database error occurs creating the connection
     */
    Connection createConnection() throws SQLException;

}
