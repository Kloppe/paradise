package com.github.houbb.paradise.enhance.core.xpath.annotation;

import java.lang.annotation.*;

/**
 * xpath 注解
 * 1. 根据 xpath 语法对 xml 与 bean 之间进行转换。
 * @author bbhou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface XPath {

    /**
     * xpath 路径
     * @return xpath
     */
    String value();

    /**
     * 是否可重复
     * 1. 如果可重复，则进行可重复的处理(转为列表)
     * 2. 请将可重复的节点元素设置为 {@link java.util.List}，在 list 中放置元素设置好对应的 xpath 属性。
     *
     * @return {@code true} 是
     */
    boolean isRepeatable() default false;

}
