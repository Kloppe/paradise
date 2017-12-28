package com.github.houbb.paradise.common.support.assigner.exception;

/**
 * 赋值异常
 * @author bbhou
 * @version 1.1.2
 * @since 1.1.2
 */
public class AssignException extends Exception {

    public AssignException() {
    }

    public AssignException(String message) {
        super(message);
    }

    public AssignException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssignException(Throwable cause) {
        super(cause);
    }

    public AssignException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
