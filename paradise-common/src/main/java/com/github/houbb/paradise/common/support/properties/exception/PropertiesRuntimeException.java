/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.support.properties.exception;

import com.github.houbb.paradise.common.annotation.dev.API;

/**
 * <p> 配置文件运行时异常 </p>
 *
 * <pre> Created: 2018/6/27 下午2:52  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@API(status = API.Status.EXPERIMENTAL)
public class PropertiesRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -8064702867809258308L;

    public PropertiesRuntimeException() {
    }

    public PropertiesRuntimeException(String message) {
        super(message);
    }

    public PropertiesRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesRuntimeException(Throwable cause) {
        super(cause);
    }

    public PropertiesRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
