package com.github.houbb.paradise.common.support.generator.exception;

/**
 * 生成者接口定义
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public class GeneratorException extends Exception {

    public GeneratorException() {
    }

    public GeneratorException(String message) {
        super(message);
    }

    public GeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneratorException(Throwable cause) {
        super(cause);
    }

    public GeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
