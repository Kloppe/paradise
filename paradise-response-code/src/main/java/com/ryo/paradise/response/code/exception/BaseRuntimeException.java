package com.ryo.paradise.response.code.exception;

import com.ryo.paradise.response.code.core.RspCode;

/**
 * 基础运行时异常
 *
 * Created by bbhou on 2017/9/30.
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
     * @return
     */
    public String getCodeMsg() {
        return String.format("%s(%s)", this.rspCode.getMsg(),this.rspCode.getCode());
    }

    /**
     * 异常转化为 rsp
     */
//    public void exceptionToResponse(BlogBaseResponse blogBaseResponse) {
//        blogBaseResponse.setRspCodeAndException(rspCode, this);
//    }


    @Override
    public String toString() {
        return "BaseRuntimeException{" +
                "rspCode=" + rspCode +
                '}';
    }
}
