/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.enhance.util;

import com.alibaba.fastjson.JSON;
import com.github.houbb.paradise.common.annotation.dev.Beta;
import com.github.houbb.paradise.common.exception.BussinessException;
import com.github.houbb.paradise.common.support.rspcode.impl.CommonRspCode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


/**
 * Http 工具类
 * @version 1.1.4
 * @since 1.1.4, 2018-06-24 09:11:16
 * @author houbinbin
 */
public class HttpUtil {

    /**
     * 渲染json对象
     * @param response 响应
     * @param jsonObject json 对象
     */
    @Beta
    public static void renderJson(HttpServletResponse response, Object jsonObject) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(jsonObject));
        } catch (IOException e) {
            throw new BussinessException(CommonRspCode.EXCEPTION);
        }
    }

}
