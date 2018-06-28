/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.core;

import com.github.houbb.paradise.common.annotation.dev.API;

import java.sql.Connection;

/**
 * <p> 数据库访问接口 </p>
 *
 * https://www.cnblogs.com/Nastuki77/p/9027178.html
 *
 * <pre> Created: 2018/6/27 上午11:14  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5, 2018-06-27 11:16:58
 */
@API(status = API.Status.EXPERIMENTAL)
public interface IDataSource {

    /**
     * 获取当前连接信息
     *
     * @return 连接信息
     */
    Connection getConnection();

}
