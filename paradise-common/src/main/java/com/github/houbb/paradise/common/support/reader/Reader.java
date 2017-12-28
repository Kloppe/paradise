package com.github.houbb.paradise.common.support.reader;

/**
 * 阅读者
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/29
 */
public interface Reader<S, R> {

    /**
     * 对指定的资源进行读取，并返回对应的资源结果
     * @param source 读取的资源
     * @return 待反馈的结果
     */
    R read(S source);

}
