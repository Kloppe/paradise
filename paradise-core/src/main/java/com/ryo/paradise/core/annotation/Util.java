package com.ryo.paradise.core.annotation;

import java.lang.annotation.*;

/**
 * 当工具类添加此注解。
 * 1. 将其 constructor 默认 private{};
 * 2. 将当前类设置为 final;
 * Created by bbhou on 2017/9/29.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Inherited
public @interface Util {
}
