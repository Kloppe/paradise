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
public interface DatasourceConstant {

    /**
     * 配置信息
     */
    interface Config {
        /**
         * 默认的增长速度
         */
        int DEFAULT_STEP = 1;
    }

    /**
     * 属性 key
     */
    interface PropertiesKey {
        /**
         * 用户名称
         */
        String USER = "user";
        /**
         * 密码
         */
        String PASSWORD = "password";
    }

}
