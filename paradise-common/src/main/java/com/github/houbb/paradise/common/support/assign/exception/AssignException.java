package com.github.houbb.paradise.common.support.assign.exception;

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
