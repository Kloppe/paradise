/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.constant;

import com.github.houbb.paradise.common.annotation.dev.API;

/**
 * <p> 数据库信息常量 </p>
 *
 * <pre> Created: 2018/6/27 上午11:06  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5, 2018-06-27 11:25:21
 */
@API(status = API.Status.EXPERIMENTAL)
public final class DatasourceConstant {

    private DatasourceConstant(){}

    /** 数据库地址 */
    public final static String JDBC_URL = "jdbc.url";

    /** 数据库驱动器 */
    public final static String JDBC_DRIVER = "jdbc.driver";

    /** 数据库用户名 */
    public final static String JDBC_USERNAME = "jdbc.username";

    /** 数据库密码 */
    public final static String JDBC_PASSWORD = "jdbc.password";

}
