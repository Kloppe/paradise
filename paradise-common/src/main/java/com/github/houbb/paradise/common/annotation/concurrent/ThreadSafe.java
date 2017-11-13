package com.github.houbb.paradise.common.annotation.concurrent;

import java.lang.annotation.*;

/**
 * 线程安全
 * Created by bbhou on 2017/10/16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface ThreadSafe {
}
