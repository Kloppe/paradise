package com.github.houbb.paradise.common.util.reflection;

import com.github.houbb.paradise.common.util.ArgUtil;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * 反射工具类
 * @author bbhou
 * @since 1.1.2
 */
public class ReflectionUtil {

    /**
     * 获取类对应的所有字段列表
     * @param cls 类
     * @return
     */
    public static List<Field> getAllFieldsList(Class<?> cls) {
        ArgUtil.notNull(cls, "cls can't not be null!");

        List<Field> allFields = new LinkedList<>();
        for(Class currentClass = cls; currentClass != null; currentClass = currentClass.getSuperclass()) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            int len$ = declaredFields.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Field field = declaredFields[i$];
                allFields.add(field);
            }
        }

        return allFields;
    }

}
