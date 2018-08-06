package com.github.houbb.paradise.spring.datasource.dynamic.annotation;

import com.github.houbb.paradise.common.annotation.dev.API;

import java.lang.annotation.*;

/**
 *
 * 数据源注解
 * @author houbinbin
 * @version 1.1.3
 * @since 1.1.3, 2018/01/19
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@API(status = API.Status.MAINTAINED)
public @interface DataSource {

    /**
     * 指定一个数据源的值
     * @return 数据源名称
     */
    String value() default "";

}
