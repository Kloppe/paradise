package com.github.houbb.paradise.common.support.validator.core.impl;

import com.github.houbb.paradise.common.support.validator.annotation.Valid;
import com.github.houbb.paradise.common.support.validator.constant.ValidConstant;
import com.github.houbb.paradise.common.support.validator.core.ValidService;
import com.github.houbb.paradise.common.support.validator.exception.ValidException;
import com.github.houbb.paradise.common.util.*;
import com.github.houbb.paradise.common.util.reflection.ReflectionUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

/**
 * 校验实现
 *
 * 1. 规范错误提示！
 * 2. 尽可能的详细规范。知道错误的原因。加上校验的类型，字段名称。
 *
 * @author houbinbin
 * @version 1.1.2
 * @since 1.1.2
 */
public class ValidServiceImpl implements ValidService {

    private static final ValidServiceImpl INSTANCE = new ValidServiceImpl();

    public static ValidServiceImpl getInstance() {
        return INSTANCE;
    }


    @Override
    public void valid(Object object) throws ValidException {
        ArgUtil.notNull(object, "object");


        List<Field> fieldList = ReflectionUtil.getAllFieldsList(object.getClass());
        if (CollectionUtil.isEmpty(fieldList)) {
            return;
        }

        for (Field field : fieldList) {

            if (ClassUtil.isNotAnnotationPresent(field, Valid.class)) {
                continue;
            }

            field.setAccessible(true);
            String fieldName = field.getName();
            Valid valid = field.getAnnotation(Valid.class);

            try {
                // 是否不为null
                notNullCheck(valid, object, field);

                // 是否不为空
                notEmptyCheck(valid, object, field);

                // 是数字
                isNumberCheck(valid, object, field);

                // 满足正则表达式
                matchesRegexCheck(valid, object, field);

                // 满足范围
                inRangeCheck(valid, object, field);

                // restriction 满足当前值在指定的范围内
                restrictionCheck(valid, object, field);

                // 至少有一个不为空
                atLeastOneCheck(valid, object, field);

            } catch (IllegalAccessException e) {
                throw new ValidException(fieldName + "非法访问", e);
            } catch (NoSuchFieldException e) {
                throw new ValidException(fieldName + "没有对应字段", e);
            }

        }
    }


    /**
     * 获取错误信息
     *
     * @return 返回错误信息
     */
    private String errMsgCheck(final Valid valid, final Field field) {
        final String format = "<%s>: %s";
        String filedName = field.getName();
        String errMsg = valid.errMsg();
        return String.format(format, filedName, errMsg);
    }

    /**
     * 校验不为NULL
     *
     * @param valid  注解
     * @param object 校验对象
     * @param field  字段
     */
    private void notNullCheck(Valid valid, Object object, Field field) throws IllegalAccessException {
        boolean notNull = valid.notNull();
        if (notNull) {
            Object fieldValue = field.get(object);
            if (ObjectUtil.isNull(fieldValue)) {
                throw new IllegalArgumentException(errMsgCheck(valid, field));
            }
        }
    }


    /**
     * 校验不为空
     * @param valid 注解
     * @param object    待校验的对象
     * @param field 字段
     * @throws IllegalAccessException   if any
     */
    private void notEmptyCheck(Valid valid, Object object, Field field) throws IllegalAccessException {
        boolean notEmpty = valid.notEmpty();
        if (notEmpty) {
            Object fieldValue = field.get(object);
            if (ObjectUtil.isEmpty(fieldValue)) {
                throw new IllegalArgumentException(errMsgCheck(valid, field));
            }
        }
    }


    /**
     * 满足为数字
     * @param valid 注解
     * @param object    待校验的对象
     * @param field 字段
     * @throws ValidException   if any
     * @throws IllegalAccessException   if any
     */
    private void isNumberCheck(Valid valid, Object object, Field field) throws IllegalAccessException, ValidException {
        boolean isNumber = valid.isNumber();
        if (isNumber) {
            if (ClassUtil.isNotString(field)) {
                throw new ValidException(buildValidExMsg(field, ValidConstant.FIELD_IS_NOT_STRING_TYPE));
            }

            String fieldValue = (String) field.get(object);
            if (ArgUtil.isNotNumber(fieldValue)) {
                throw new IllegalArgumentException(errMsgCheck(valid, field));
            }
        }
    }

    /**
     * 满足正则表达式
     * @param valid 注解
     * @param object    待校验的对象
     * @param field 字段
     * @throws ValidException   if any
     * @throws IllegalAccessException   if any
     */
    private void matchesRegexCheck(Valid valid, Object object, Field field) throws IllegalAccessException, ValidException {
        String regex = valid.matchRegex();
        if (StringUtil.isNotEmpty(regex)) {
            if (ClassUtil.isNotString(field)) {
                throw new ValidException(buildValidExMsg(field, ValidConstant.FIELD_IS_NOT_STRING_TYPE));
            }

            String fieldValue = (String) field.get(object);
            if (ArgUtil.isNotMatchesRegex(fieldValue, regex)) {
                throw new IllegalArgumentException(errMsgCheck(valid, field));
            }
        }
    }


    /**
     * 满足范围
     *
     * @param valid 注解
     * @param object    待校验的对象
     * @param field 字段
     */
    private void inRangeCheck(Valid valid, Object object, Field field) throws ValidException, IllegalAccessException {
        String inRange = valid.inRange();
        Object fieldValue = field.get(object);
        if (StringUtil.isNotEmpty(inRange)
                && null != fieldValue) {
            inRangeFieldTypeVerify(field);
            //校验范围输入值校验
            if (ArgUtil.isNotMatchesRegex(inRange, ValidConstant.IN_RANGE_REGEX)) {
                throw new ValidException(buildValidExMsg(field, ValidConstant.ILLEGAL_IN_RANGE_VALUE));
            }


            String[] strings = inRange.split(",");
            String leftStr = strings[0].substring(0, 1);   //左边范围符号
            String rightStr = strings[1].substring(strings[1].length() - 1, strings[1].length()); //右边范围符号
            String oneNumStr = strings[0].substring(1, strings[0].length());   //左边数字
            String twoNumStr = strings[1].substring(0, strings[1].length() - 1); //右边数字

            double doubleVal = Double.parseDouble(fieldValue.toString());

            //1.左边值范围校验
            if (!ValidConstant.INFINITY_FLAG.equals(leftStr)) {
                double oneNum = Double.parseDouble(oneNumStr);
                if (ValidConstant.GREATER_THAN.equals(leftStr)) {
                    if (doubleVal <= oneNum) {
                        throw new IllegalArgumentException(errMsgCheck(valid, field));
                    }
                } else if (ValidConstant.EQUAL_GREATER_THAN.equals(leftStr)) {
                    if (doubleVal < oneNum) {
                        throw new IllegalArgumentException(errMsgCheck(valid, field));
                    }
                }
            }

            //2.右边值范围校验
            if (!ValidConstant.INFINITY_FLAG.equals(rightStr)) {
                double twoNum = Double.parseDouble(twoNumStr);
                if (ValidConstant.LESS_THAN.equals(rightStr)) {
                    if (doubleVal >= twoNum) {
                        throw new IllegalArgumentException(errMsgCheck(valid, field));
                    }
                } else if (ValidConstant.EQUAL_LESS_THAN.equals(rightStr)) {
                    if (doubleVal > twoNum) {
                        throw new IllegalArgumentException(errMsgCheck(valid, field));
                    }
                }
            }

        }
    }

    /**
     * 字段类型校验
     *
     * @param field 字段
     */
    private void inRangeFieldTypeVerify(Field field) throws ValidException {
        if (field.getType() == Integer.class ||
                field.getType() == Long.class ||
                field.getType() == Short.class ||
                field.getType() == Double.class ||
                field.getType() == Float.class ||
                field.getType() == BigDecimal.class ||
                field.getType() == String.class) {
            return;
        }

        throw new ValidException(buildValidExMsg(field, ValidConstant.FIELD_IS_NOT_NUMBER_TYPE));
    }


    /**
     * 检验当前值在指定某些值内
     *
     * @param valid 注解
     * @param object    待校验的对象
     * @param field 字段
     * @throws IllegalAccessException   if any
     */
    private void restrictionCheck(Valid valid, Object object, Field field) throws IllegalAccessException, ValidException {
        String[] restrictionArray = valid.restriction();
        if (ArrayUtil.isNotEmpty(restrictionArray)) {
            String fieldValueStr = String.valueOf(field.get(object));
            if (ArrayUtil.notContains(restrictionArray, fieldValueStr)) {
                throw new ValidException(errMsgCheck(valid, field));
            }
        }
    }

    /**
     * 至少有一个不为空
     * 1. 这里的进行更严格的校验(not empty)
     * @param valid 注解
     * @param object    待校验的对象
     * @param field 字段
     * @throws IllegalAccessException   if any
     * @throws NoSuchFieldException if any
     */
    private void atLeastOneCheck(Valid valid, Object object, Field field) throws IllegalAccessException, NoSuchFieldException, ValidException {
        String[] fieldNameArray = valid.restriction();

        //1. 当指定的集合不为空
        //2. 当指定的字段或者当前字段全部为空
        if (ArrayUtil.isNotEmpty(fieldNameArray)) {
            boolean isAtLeastOneNotEmpty = isAtLeastOneNotEmpty(fieldNameArray, object, field);
            if(!isAtLeastOneNotEmpty) { //不满足
                throw new ValidException(errMsgCheck(valid, field));
            }
        }

    }

    /**
     * 至少有一个不为空
     * @param fieldNameArray    字段名称
     * @param object    对象
     * @param currentField  当前字段
     * @return 是否至少一个不为空
     * @throws IllegalAccessException if any
     * @throws NoSuchFieldException if any
     */
    private boolean isAtLeastOneNotEmpty(String[] fieldNameArray, Object object, Field currentField) throws IllegalAccessException, NoSuchFieldException {
        String currentFieldValueStr = String.valueOf(currentField.get(object));
        if (StringUtil.isNotEmpty(currentFieldValueStr)) {
            return true;
        }

        Class clazz = object.getClass();
        for (String fieldName : fieldNameArray) {
            Field field = clazz.getField(fieldName);
            String fieldValueStr = String.valueOf(field.get(object));
            if(StringUtil.isNotEmpty(fieldValueStr)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 构建校验异常信息
     * @param field    字段
     * @param errorMsg 错误信息
     * @return 完整的错误信息
     */
    private String buildValidExMsg(Field field, final String errorMsg) {
        String fieldName = field.getName();
        String format = "<%s>: %s";
        return String.format(format, fieldName, errorMsg);
    }
}
