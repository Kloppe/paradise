package com.github.houbb.paradise.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Class 工具类
 *
 * @version 1.1.0
 * @author bbhou
 */
public class ClassUtil {

    /**
     * 获取对应类的默认变量名：
     * 1. 首字母小写
     * String=》string
     * @param className 类名称
     * @return 类的默认变量名
     */
    public static String getClassVar(final String className) {
        String classVar = className.substring(0, 1).toLowerCase() + className.substring(1);
        return classVar;
    }

    private static final String TYPE = "TYPE";

    private ClassUtil() {
    }


    /**
     * 是否为字符串
     *
     * @param object 对象
     * @return {@code true} 是
     */
    public static Boolean isString(Object object) {
        return object instanceof String;
    }

    /**
     * 是否为集合
     *
     * @param object    对象
     * @return  {@code true} 是
     */
    public static Boolean isCollection(Object object) {
        return object instanceof Collection;
    }

    /**
     * 是否为Map
     *
     * @param object 对象
     * @return  {@code true} 是
     */
    public static Boolean isMap(Object object) {
        return object instanceof Map;
    }

    /**
     * 是否为数组
     *
     * @param object
     * @return
     */
    public static Boolean isArray(Object object) {
        return object.getClass().isArray();
    }

    /**
     * 是否为Java8大基本类型
     * - 基本类型是 CLASS 的子集
     *
     * @param object 实体类
     * @return  {@code true} 是
     */
    public static Boolean isPrimitive(Object object) {
        try {
            return ((Class) object.getClass().getField(TYPE).get(null)).isPrimitive();
        } catch (IllegalAccessException | NoSuchFieldException e) {
//            log.error("判断是否为基本类型，出现错误:{}, exception:{}", object.toString(), e);
            return false;
        }
    }

    /**
     * 是否为私有方法
     * @param clazz 类
     * @return {@code true} 是
     */
    public static Boolean isPrimitive(Class clazz) {
        try {
            return ((Class) clazz.getField(TYPE).get(null)).isPrimitive();
        } catch (IllegalAccessException | NoSuchFieldException e) {
//            log.error("判断是否为基本类型，出现错误:{}, exception:{}", clazz.toString(), e);
            return false;
        }
    }


    /**
     * 判断字段field,声明了clazz注解
     *
     * @param field 字段
     * @param clazz 注解
     * @return 是否声明了
     */
    public static boolean isAnnotationPresent(Field field, Class<? extends Annotation> clazz) {
        return field.isAnnotationPresent(clazz);
    }

    /**
     * 判断字段field,未声明clazz注解
     *
     * @param field 字段
     * @param clazz 注解
     * @return 是否未声明
     */
    public static boolean isNotAnnotationPresent(Field field, Class<? extends Annotation> clazz) {
        return !isAnnotationPresent(field, clazz);
    }

    /**
     * 判断字段为字符串类型
     *
     * @param field 字段
     * @return {@code true} 是
     */
    public static Boolean isString(Field field) {
        return field.getType() == String.class;
    }

    /**
     * 判断字段是否不为字符串类型
     * @param field 字段
     * @return  {@code true} 是
     */
    public static Boolean isNotString(Field field) {
        return !isString(field);
    }

}
