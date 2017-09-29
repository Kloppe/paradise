package com.ryo.paradise.core.annotation;

import java.lang.annotation.*;

/**
 * 当工具类添加此注解。将其 constructor 默认 private{};
 * Created by bbhou on 2017/9/29.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Util {

}
