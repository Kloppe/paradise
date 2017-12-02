package com.github.houbb.paradise.common.support.validator.constant;

/**
 * @author houbinbin
 * @on 16/12/16
 */
public class ValidConstant {

    private ValidConstant(){}

    /**
     * 参数校验,默认报错信息
     */
    public static final String CHECK_ERROR_INFO = "参数校验不合法";

    /**
     * 字段不是字符串信息提醒
     */
    public static final String FIELD_IS_NOT_STRING_TYPE = "当前字段不是字符串类型";

    /**
     * 字段不是数字类型信息提醒
     */
    public static final String FIELD_IS_NOT_NUMBER_TYPE = "当前字段不是数字类型";

    /**
     * 范围值指定错误说明
     */
    public static final String ILLEGAL_IN_RANGE_VALUE = "范围值指定错误";


    /**
     * 范围值满足的正则表达式
     * 范围直接转化为double,转化失败,则证明输入有问题。
     * 匹配如下
     * 1.左边可为[(, 右边可]), 中间必须有逗号。逗号左右两边可为数字,或者~
     */
    public static final String IN_RANGE_REGEX = "^[\\[\\(]{1}[-\\.0-9~]{1,},[-\\.0-9~]{1,}[\\]\\)]{1}$";

    /**
     * 左边下标
     */
    public static final Integer LEFT_SIDE_INDEX = 0;

    /**
     * 右边下标
     */
    public static final Integer RIGHT_SIDE_INDEX = 1;

    /**
     * 无穷标志
     */
    public static final String INFINITY_FLAG = "~";

    /**
     * 大于
     */
    public static final String GREATER_THAN = "(";
    /**
     * 大于等于
     */
    public static final String EQUAL_GREATER_THAN = "[";
    /**
     * 小于
     */
    public static final String LESS_THAN = ")";
    /**
     * 小于等于
     */
    public static final String EQUAL_LESS_THAN = "]";

}
