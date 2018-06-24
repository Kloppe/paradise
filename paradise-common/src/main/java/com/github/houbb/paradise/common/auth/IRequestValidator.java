/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.auth;

/**
 * <p> 请求验证接口 </p>
 *
 * <pre> Created: 2018/6/8 下午6:33  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.4
 * @since JDK 1.7
 */
public interface IRequestValidator {

    /**
     * 校验
     * @param credence 验证值s
     */
    void valid(ICredence credence);

}
