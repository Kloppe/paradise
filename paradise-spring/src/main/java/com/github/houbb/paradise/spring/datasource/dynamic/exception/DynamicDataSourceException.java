/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.spring.datasource.dynamic.exception;

/**
 * <p> 动态数据源异常 </p>
 *
 * <pre> Created: 2018/8/6 下午11:22  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class DynamicDataSourceException extends RuntimeException {

    private static final long serialVersionUID = -6680798128095524322L;

    public DynamicDataSourceException() {
    }

    public DynamicDataSourceException(String message) {
        super(message);
    }

    public DynamicDataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DynamicDataSourceException(Throwable cause) {
        super(cause);
    }

    public DynamicDataSourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
