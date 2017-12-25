package com.github.houbb.paradise.enhance.core.xpath.exception;

/**
 * xpath 异常
 * @author bbhou
 */
public class XPathRuntimeException extends RuntimeException {

    public XPathRuntimeException() {
    }

    public XPathRuntimeException(String message) {
        super(message);
    }

    public XPathRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public XPathRuntimeException(Throwable cause) {
        super(cause);
    }

    public XPathRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
