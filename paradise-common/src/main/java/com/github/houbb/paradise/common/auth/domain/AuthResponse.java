/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.auth.domain;

import java.io.Serializable;



/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/8 下午6:43  </pre>
 * <pre> Project: iter-blog  </pre>
 *
 * @author houbinbin
 * @version 1.1.4
 * @since JDK 1.7
 */
public class AuthResponse implements Serializable {

    private static final long serialVersionUID = -1909739170808571778L;

    /**
     * jwt token
     */
    private final String token;

    /**
     * 用于客户端混淆md5加密
     */
    private final String randomKey;

    public AuthResponse(String token, String randomKey) {
        this.token = token;
        this.randomKey = randomKey;
    }

    public String getToken() {
        return token;
    }

    public String getRandomKey() {
        return randomKey;
    }
}
