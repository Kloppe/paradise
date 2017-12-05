package com.github.houbb.paradise.common.support.parser.core;

/**
 * 2017/12/4
 *
 * 可以参考 spring-expression 实现自己的简单的 el
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public interface Parser<T> {


    /**
     * 将对象的值进行转换
     * @param object 待转换的对象
     * @return  转换的结果
     */
    T parse(final Object object);

}
