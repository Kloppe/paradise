/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.auth.domain;

/**
 * <p> Request Subject </p>
 *
 * <pre> Created: 2018/6/7 下午7:28  </pre>
 * <pre> Project: iter-blog  </pre>
 *
 * @author houbinbin
 * @version 1.1.4
 * @since 1.1.4, 2018-06-24 09:23:53
 * @since JDK 1.7
 */
public class RequestSubject {

    /**
     * 用户标识
     */
    private Long id;

    /**
     * 用户名称
     */
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
