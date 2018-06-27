package com.github.houbb.paradise.common.util.reflection;

import com.github.houbb.paradise.common.annotation.dev.API;
import com.github.houbb.paradise.common.util.ArgUtil;
import com.github.houbb.paradise.common.util.CollectionUtil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 反射工具类
 * @author bbhou
 * @since 1.1.2
 */
public final class ReflectionUtil {

    private ReflectionUtil(){}

    /**
     * 获取类对应的所有字段列表
     * @param cls 类
     * @return field list
     */
    public static List<Field> getAllFieldsList(Class<?> cls) {
        ArgUtil.notNull(cls, "cls can't not be null!");

        List<Field> allFields = new LinkedList<>();
        for(Class currentClass = cls; currentClass != null; currentClass = currentClass.getSuperclass()) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            int length = declaredFields.length;

            for(int i = 0; i < length; i++) {
                Field field = declaredFields[i];
                allFields.add(field);
            }
        }

        return allFields;
    }

    /**
     * 获取列表字段对应的类型
     * @param field 字段
     * @return 返回对应的 class 类型
     */
    public static Class getListType(Field field) {
        ParameterizedType listGenericType = (ParameterizedType) field.getGenericType();
        Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
        return (Class) listActualTypeArguments[0];
    }

    /**
     * 获取所有字段的 read 方法列表
     * @param clazz 类信息
     * @return 方法列表
     * @since 1.1.4
     */
    @API(status = API.Status.EXPERIMENTAL)
    public static List<Method> getAllFieldsReadMethods(final Class clazz) throws IntrospectionException {
        List<Field> fieldList = getAllFieldsList(clazz);
        if(CollectionUtil.isEmpty(fieldList)) {
            return Collections.emptyList();
        }

        List<Method> methods = new ArrayList<>();
        for(Field field : fieldList) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            //获得get方法
            Method getMethod = pd.getReadMethod();
            methods.add(getMethod);
        }
        return methods;
    }

}
