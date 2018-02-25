package com.github.houbb.paradise.common.exception;

/**
 * paradise common 异常
 * @author bbhou
 * @version 1.1.4, 2018/02/25
 */
public class ParadiseCommonRuntimeException extends RuntimeException {

    public ParadiseCommonRuntimeException() {
    }

    public ParadiseCommonRuntimeException(String message) {
        super(message);
    }

    public ParadiseCommonRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParadiseCommonRuntimeException(Throwable cause) {
        super(cause);
    }

    public ParadiseCommonRuntimeException(String message, Throwable cause,
                                          boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
