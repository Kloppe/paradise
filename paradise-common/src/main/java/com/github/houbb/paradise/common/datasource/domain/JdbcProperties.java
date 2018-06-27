/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.domain;

/**
 * <p> 数据库链接属性</p>
 *
 * <pre> Created: 2018/6/27 上午10:18  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5, 2018-06-27 10:19:38
 * @since JDK 1.7
 */
public class JdbcProperties {

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * URL 信息
     */
    private String url;

    /**
     * 数据库驱动
     */
    private String driver;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "JdbcProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
