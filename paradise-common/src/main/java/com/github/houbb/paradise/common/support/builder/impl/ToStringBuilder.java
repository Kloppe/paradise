package com.github.houbb.paradise.common.support.builder.impl;


import com.github.houbb.paradise.common.exception.ParadiseCommonRuntimeException;
import com.github.houbb.paradise.common.support.builder.Builder;
import com.github.houbb.paradise.common.util.reflection.ReflectionUtil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * toString() 构建
 *
 * @author bbhou
 * @version 1.1.0
 */
public class ToStringBuilder implements Builder<String> {

    private final Object object;

    public ToStringBuilder(Object object) {
        this.object = object;
    }

    @Override
    public String build() {
        return reflectionToString(object);
    }

    /**
     * 反射生成对应的字符串
     * @param object 对象
     * @return toString() 内容
     */
    public static String reflectionToString(Object object) {
        Class clazz = object.getClass();

        String entityName = clazz.getSimpleName();
        List<Field> fieldList= ReflectionUtil.getAllFieldsList(clazz);

        StringBuilder stringBuilder = new StringBuilder(String.format("%s{", entityName));

        for(int i = 0; i < fieldList.size()-1; i++) {
            Field field = fieldList.get(i);
            stringBuilder.append(buildFieldValue(object, field)).append(",");
        }

        stringBuilder.append(buildFieldValue(object, fieldList.get(fieldList.size()-1)));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    /**
     * build "field=fieldValue"
     * TODO: 特殊值的处理
     * 1. 对于数组的处理
     * 2. 对于集合的处理
     * @param object 对象
     * @param field 字段
     * @return 构建后的 String
     */
    private static String buildFieldValue(Object object, Field field) {
        final String format = isType(field, String.class) ? "%s='%s'" : "%s=%s";
        StringBuilder stringBuilder;
        Method getMethod = getGetMethod(object.getClass(), field);
        try {
            Object fieldValue = getMethod.invoke(object);

            if(null == fieldValue) {
                stringBuilder = new StringBuilder(String.format("%s=null", field.getName()));
            } else {
                stringBuilder = new StringBuilder(String.format(format, field.getName(), fieldValue));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ParadiseCommonRuntimeException(e);
        }

        return stringBuilder.toString();
    }

    /**
     * getConnection the Get() of current field;
     * @param clazz 类信息
     * @param field 字段信息
     * @return 方法
     */
    private static Method getGetMethod(Class clazz, Field field) {
        PropertyDescriptor propertyDescriptor;
        try {
            propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
        } catch (IntrospectionException e) {
            throw new ParadiseCommonRuntimeException(e);
        }

        return propertyDescriptor.getReadMethod();
    }

    /**
     * adjust just field is the type of
     * @param field 字段
     * @param classType 类型
     * @return {@code true} 是
     */
    private static Boolean isType(Field field, Class classType) {
        return field.getType().equals(classType);
    }

}
