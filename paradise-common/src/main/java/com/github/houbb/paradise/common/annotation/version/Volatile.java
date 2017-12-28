package com.github.houbb.paradise.common.annotation.version;

import java.lang.annotation.*;

/**
 * 标识当前方法，类，等相对不稳定。以后可能会对其进行调整修改。
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Inherited
public @interface Volatile {
}
