package com.github.houbb.paradise.common.annotation.concurrent;

import java.lang.annotation.*;

/**
 * 不可变类
 *
 * @author bbhou
 * @version 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface Immutable {
}
