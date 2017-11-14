package com.github.houbb.paradise.common.annotation.concurrent;

import java.lang.annotation.*;

/**
 * 线程不安全
 *
 * @author bbhou
 * @version 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface NotThreadSafe {
}
