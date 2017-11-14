package com.github.houbb.paradise.common.support.impl;

import com.github.houbb.paradise.common.support.Builder;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
     * @param object
     * @return
     */
    public static String reflectionToString(Object object) {
        Class clazz = object.getClass();

        String entityName = clazz.getSimpleName();
        Field fields[] = clazz.getDeclaredFields();

        StringBuilder stringBuilder = new StringBuilder(String.format("%s{", entityName));

        for(int i = 0; i < fields.length-1; i++) {
            Field field = fields[i];
            stringBuilder.append(buildFieldValue(object, field)).append(",");
        }

        stringBuilder.append(buildFieldValue(object, fields[fields.length-1]));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    /**
     * build "field=fieldValue"
     * TODO: 特殊值的处理
     * 1. 对于数组的处理
     * 2. 对于集合的处理
     * @param object
     * @param field
     * @return
     */
    private static String buildFieldValue(Object object, Field field) {
        final String format = isType(field, String.class) ? "%s='%s'" : "%s=%s";
        StringBuilder stringBuilder = new StringBuilder();
        Method getMethod = getGetMethod(object.getClass(), field);
        try {
            Object fieldValue = getMethod.invoke(object);

            if(null == fieldValue) {
                stringBuilder = new StringBuilder(String.format("%s=null", field.getName()));
            } else {
                stringBuilder = new StringBuilder(String.format(format, field.getName(), fieldValue));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    /**
     * get the Get() of current field;
     * @param clazz
     * @param field
     * @return
     */
    private static Method getGetMethod(Class clazz, Field field) {
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
        } catch (IntrospectionException e) {
            e.printStackTrace();
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
