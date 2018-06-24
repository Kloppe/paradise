/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.exception;

import com.github.houbb.paradise.common.support.rspcode.RspCode;

/**
 * <p> 参数校验异常 </p>
 *
 * <pre> Created: 2018/6/7 下午5:35  </pre>
 * <pre> Project: iter-blog  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class ParamValidException extends RuntimeException {

    private static final long serialVersionUID = -2917169857736197893L;

    private final RspCode rspCode;

    public ParamValidException(RspCode rspCode) {
        this.rspCode = rspCode;
    }

    public ParamValidException(String message, RspCode rspCode) {
        super(message);
        this.rspCode = rspCode;
    }

    public ParamValidException(String message, Throwable cause, RspCode rspCode) {
        super(message, cause);
        this.rspCode = rspCode;
    }

    public ParamValidException(Throwable cause, RspCode rspCode) {
        super(cause);
        this.rspCode = rspCode;
    }

    public ParamValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, RspCode rspCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.rspCode = rspCode;
    }
}
