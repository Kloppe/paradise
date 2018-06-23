package com.github.houbb.paradise.common.support.validator.exception;

/**
 * 校验时异常
 * @author houbinbin
 */
public class ValidException extends Exception {

    private static final long serialVersionUID = 6121408169904773529L;

    public ValidException() {
    }

    public ValidException(String message) {
        super(message);
    }

    public ValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidException(Throwable cause) {
        super(cause);
    }

    public ValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
