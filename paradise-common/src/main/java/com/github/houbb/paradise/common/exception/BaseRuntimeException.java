package com.github.houbb.paradise.common.exception;


import com.github.houbb.paradise.common.support.rspcode.RspCode;

/**
 * 基础运行时异常
 *
 * @author bbhou
 * @version 1.0.0
 */
public class BaseRuntimeException extends Exception {

    /**
     * 响应吗
     */
    private final RspCode rspCode;

    public BaseRuntimeException(RspCode rspCode) {
        this.rspCode = rspCode;
    }

    public BaseRuntimeException(RspCode rspCode, Throwable throwable) {
        super(throwable);
        this.rspCode = rspCode;
    }

    /**
     * 获取错误编码+信息
     * @return error info
     */
    public String getCodeMsg() {
        return String.format("%s(%s)", this.rspCode.getMsg(),this.rspCode.getCode());
    }

    @Override
    public String toString() {
        return "BaseRuntimeException{" +
                "rspCode=" + rspCode +
                '}';
    }
}
