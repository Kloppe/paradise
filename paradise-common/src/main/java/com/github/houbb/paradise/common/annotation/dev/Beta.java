/*
 * Copyright (c)  2018. houbinbin Inc.
 * jca All rights reserved.
 */

package com.github.houbb.paradise.common.annotation.dev;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> 相对稳定的 </p>
 *
 * 1. 想法和验证相对成熟。后期更多的是完善
 *
 * <pre> Created: 2018/6/23 上午6:49  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Beta {
}
