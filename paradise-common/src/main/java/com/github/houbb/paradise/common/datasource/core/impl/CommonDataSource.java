/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.core.impl;

import com.github.houbb.paradise.common.annotation.dev.API;
import com.github.houbb.paradise.common.datasource.core.IDataSource;
import com.github.houbb.paradise.common.datasource.domain.JdbcProperties;
import com.github.houbb.paradise.common.exception.DatabaseException;
import com.github.houbb.paradise.common.support.rspcode.impl.CommonRspCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * <p> 基本的数据库信息链接 </p>
 *
 * <pre> Created: 2018/6/27 下午2:26  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@API(status = API.Status.EXPERIMENTAL)
public class CommonDataSource implements IDataSource {

    /**
     * jdbc 属性
     */
    private final JdbcProperties jdbcProperties;

    /**
     * 数据库链接信息
     */
    private Connection connection;

    public CommonDataSource(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

    @Override
    public Connection get() {
        try {
            Class.forName(jdbcProperties.getDriver());
            return DriverManager.getConnection(jdbcProperties.getUrl(),
                    jdbcProperties.getUsername(), jdbcProperties.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            throw new DatabaseException(e, CommonRspCode.DATABASE_EX);
        }
    }

    @Override
    public void close() throws Exception {
        if(connection != null) {
            connection.close();
        }
    }

}
