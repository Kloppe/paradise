package com.github.houbb.paradise.common.util;


import com.github.houbb.paradise.common.support.rspcode.RspCode;
import com.github.houbb.paradise.common.support.rspcode.impl.CommonRspCode;

/**
 * 响应码-工具类
 * @author bbhou
 * @version 1.1.1
 */
public final class RspCodeUtil {

    private RspCodeUtil(){}

    /**
     * 成功对应的响应码
     */
    public static final String SUCCESS_CODE = CommonRspCode.SUCCESS.getCode();

    /**
     * 是否为成功
     * @param rspCode 对应的响应吗
     * @return {true} 成功; {false} 失败
     */
    public static boolean isSuccess(RspCode rspCode) {
        return SUCCESS_CODE.equals(rspCode.getCode());
    }

}
