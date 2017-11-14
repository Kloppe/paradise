package com.github.houbb.paradise.response.code.util;

import com.github.houbb.paradise.response.code.core.RspCode;
import com.github.houbb.paradise.response.code.core.impl.CommonRspCode;

/**
 * 响应码-工具类
 * @author bbhou
 * @version 1.0.0
 */
public final class RspCodeUtil {

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


    private RspCodeUtil(){}

}
