/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.exception;

import com.github.houbb.paradise.common.annotation.dev.API;

/**
 * <p> DataSource 运行时异常 </p>
 *
 * <pre> Created: 2018/6/27 下午4:27  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5
 */
@API(status = API.Status.EXPERIMENTAL)
public class DataSourceException extends RuntimeException {

    private static final long serialVersionUID = -2141831129909316958L;

    public DataSourceException() {
    }

    public DataSourceException(String message) {
        super(message);
    }

    public DataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSourceException(Throwable cause) {
        super(cause);
    }

    public DataSourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
