package com.github.houbb.paradise.common.support.builder;

/**
 * 构建者模式接口
 *
 * @author bbhou
 * @version 1.1.0
 */
public interface Builder<T> {

    /**
     * 构建
     * @return 返回的对象
     */
    T build();

}
