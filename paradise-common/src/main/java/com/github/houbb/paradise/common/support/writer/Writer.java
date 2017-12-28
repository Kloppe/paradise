package com.github.houbb.paradise.common.support.writer;

/**
 * 写作者
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/29
 */
public interface Writer<V, T> {


    /**
     * 将指定的值写入到目标对象中
     * @param value 值
     * @param target 对象
     */
    void write(V value, T target);

}
