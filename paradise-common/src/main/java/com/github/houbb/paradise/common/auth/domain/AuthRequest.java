/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.auth.domain;


import com.github.houbb.paradise.common.auth.ICredence;

/**
 * <p> Auth Request </p>
 *
 * <pre> Created: 2018/6/8 下午6:43  </pre>
 * <pre> Project: iter-blog  </pre>
 *
 * @author houbinbin
 * @version 1.1.4
 * @since JDK 1.7
 */
public class AuthRequest implements ICredence {

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    @Override
    public String getName() {
        return username;
    }

    @Override
    public String getSecret() {
        return password;
    }

}
