/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.exception;

import com.github.houbb.paradise.common.support.rspcode.RspCode;

/**
 * <p> 业务异常 </p>
 *
 * <pre> Created: 2018/6/7 下午5:35  </pre>
 * <pre> Project: iter-blog  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class BussinessException extends RuntimeException {

    private static final long serialVersionUID = -2917169857736197893L;

    private final RspCode rspCode;

    public BussinessException(RspCode rspCode) {
        this.rspCode = rspCode;
    }

    public BussinessException(String message, RspCode rspCode) {
        super(message);
        this.rspCode = rspCode;
    }

    public BussinessException(String message, Throwable cause, RspCode rspCode) {
        super(message, cause);
        this.rspCode = rspCode;
    }

    public BussinessException(Throwable cause, RspCode rspCode) {
        super(cause);
        this.rspCode = rspCode;
    }

    public BussinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, RspCode rspCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.rspCode = rspCode;
    }

}
