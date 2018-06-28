/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.datasource.domain;

import com.github.houbb.paradise.common.annotation.dev.API;

/**
 * <p> 数据库链接信息配置 </p>
 *
 * <pre> Created: 2018/6/27 上午10:18  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.5
 * @since 1.1.5, 2018-06-27 10:19:38
 */
@API(status = API.Status.EXPERIMENTAL)
public class DataSourceConfig {

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

    /**
     * 初始线程数
     */
    private int initSize;

    /**
     * 最大线程数
     */
    private int maxSize;

    /**
     * 配置获取连接等待超时的时间
     */
    private long maxWait;

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

    public int getInitSize() {
        return initSize;
    }

    public void setInitSize(int initSize) {
        this.initSize = initSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

}
