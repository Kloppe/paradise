package com.github.houbb.paradise.response.code.core.impl;

import com.github.houbb.paradise.response.code.core.RspCode;

/**
 * 通用响应码
 * Created by bbhou on 2017/9/30.
 * @author bbhou
 * @version 1.0.0
 */
public enum CommonRspCode implements RspCode {
    /**
     * 最常见的错误大类
     */
    SUCCESS("0000", "成功"),
    EXCEPTION("0001", "异常"),
    FAIL("0002", "失败"),


    /**
     * error code about redis lock
     */
    REDIS_LOCK_SET_FAIL("1000", "redis lock set failed!"),
    REDIS_LOCK_GET_KEY_FAIL("1001", "redis lock get key failed!"),
    REDIS_LOCK_DEL_FAIL("1002", "redis lock delete by key failed!"),
    ;


    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 错误备注
     */
    private String remark;


    CommonRspCode(String code, String msg) {
        this(code, msg, "");
    }

    CommonRspCode(String code, String msg, String remark) {
        this.code = code;
        this.msg = msg;
        this.remark = remark;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String getRemark() {
        return remark;
    }

}
