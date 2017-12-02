package com.github.houbb.paradise.common.support.validator.annotation;

import com.github.houbb.paradise.common.support.validator.constant.ValidConstant;

import java.lang.annotation.*;

/**
 * @author houbinbin
 * @on 16/12/16
 * 参数校验,主要用于入参,出参校验。
 * 注意:
 * 1.只有notNull() notEmpty() 进行空校验。 如果这两项没指定,后面的不会进行空校验。
 * 例如: 不指定空校验。null 对于 isNumber() 是通过的!
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface Valid {

    /**
     * 错误信息
     * @return 默认使用 {@link ValidConstant#CHECK_ERROR_INFO}
     */
    String errMsg() default ValidConstant.CHECK_ERROR_INFO;

    /**
     * 是否可以为 null
     * @return 默认为不可以为null
     */
    boolean notNull() default true;

    /**
     * 是否可以为 空
     * 1.String.isEmpty()
     * 2.Collections.isEmpty()
     * 等加以判断。此条件比 notNull() 要苛刻。
     * @return 默认可以为空
     */
    boolean notEmpty() default false;


    /**
     * 是否为数字
     * @return 默认为false 不进行校验
     */
    boolean isNumber() default false;

    /**
     * 匹配正则表达式
     * @return 默认为 null 不进行正则匹配
     */
    String matchRegex() default "";

    /**
     * 在指定数字范围内。类似数学中的集合。
     * 使用: "[1,2]" 或者 "(1,2)"
     * 1.~ 代表无穷。左边代表无穷小,右边代表无穷大。 可放宽限制, 不填也代表无穷。
     * 2. 左边的值必须≤右边的值。否则抛出异常。值必须以","分割。否则抛出异常。
     * 2. 左边不是无穷小,则需要≥最小值。
     * @return 默认不校验
     */
    String inRange() default "";


    /**
     * 最少有一个值不为空
     * 1. 当前字段，和数组指定的字段中，至少有一个不为空。
     * 2. 如果此字段指定列表为空，则不进行校验。
     * 3. 如果指定字段，则对指定的字段和当前字段进行校验。
     * @return
     */
    String[] atLeastOne() default {};


    /**
     * 当前字段的值必须在指定的数据中任选其一
     * 1. 如果当前数组为空，则不进行校验
     * eg: 指定市场只能是 4/9
     * @return
     */
    String[] restriction() default {};



}
