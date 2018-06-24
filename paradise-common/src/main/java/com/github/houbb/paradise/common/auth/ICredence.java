/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.auth;

/**
 * <p> 约束接口 </p>
 *
 * <pre> Created: 2018/6/8 下午6:33  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.4
 * @since JDK 1.7
 */
public interface ICredence {

    /**
     * 获取验证名称
     * @return 名称
     */
    String getName();

    /**
     * 获取验证密码
     * @return 密码
     */
    String getSecret();

}
