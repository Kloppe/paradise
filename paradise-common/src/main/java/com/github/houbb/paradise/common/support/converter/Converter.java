package com.github.houbb.paradise.common.support.converter;

/**
 * 转换者
 * @param <T> 转换目标
 * @param <R> 转换结果
 */
public interface Converter<T, R> {

    /**
     * 对目标元素进行转换
     * @param target 目标元素
     * @return 转换的结果
     */
    R convert(T target);

}
