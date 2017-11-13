package com.github.houbb.paradise.common.support;

/**
 * 构建者模式接口
 */
public interface Builder<T> {

    /**
     * 构建
     * @return 返回的对象
     */
    T build();

}
