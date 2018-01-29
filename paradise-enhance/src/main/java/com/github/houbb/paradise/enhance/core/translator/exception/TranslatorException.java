package com.github.houbb.paradise.enhance.core.translator.exception;

/**
 * 转换异常
 * @author bbhou
 * @version 1.1.4
 * @since 1.1.4
 */
public class TranslatorException extends Exception {

    public TranslatorException() {
    }

    public TranslatorException(String message) {
        super(message);
    }

    public TranslatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TranslatorException(Throwable cause) {
        super(cause);
    }

    public TranslatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
