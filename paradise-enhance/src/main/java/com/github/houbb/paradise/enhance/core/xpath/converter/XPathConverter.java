package com.github.houbb.paradise.enhance.core.xpath.converter;

/**
 * xpath 转换
 * @author bbhou
 * @version 1.1.2
 */
public interface XPathConverter {

    /**
     * 元素转换
     * @param xml xml 报文
     * @param tClass 待转换的类
     * @param <T> 对象
     * @return 转换的对象
     */
    <T> T convert(final String xml, final Class<T> tClass);

}
