package com.github.houbb.paradise.common.annotation.concurrent;

import java.lang.annotation.*;

/**
 * 不可变类
 * Created by bbhou on 2017/10/16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface Immutable {
}
