package com.github.houbb.paradise.common.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Object 工具类
 *
 * @author bbhou
 * @version 1.1.0
 */
public class ObjectUtil {

    private ObjectUtil() {
    }

    /**
     * 判断两个对象是否为同一对象
     * instanceof
     * isInstance
     * isAssignableFrom
     *
     * @param one 第一个元素
     * @param two 第二个元素
     * @return  是否为同一对象
     */
    public static Boolean isSameType(Object one, Object two) {
        Class clazzOne = one.getClass();

        if (clazzOne.isInstance(two)) {
            return true;
        }

        return false;
    }

    /**
     * 不是同一个类型
     *
     * @param one 第一个元素
     * @param two 第二个元素
     * @return  是否为不同对象
     */
    public static Boolean isNotSameType(Object one, Object two) {
        return !isSameType(one, two);
    }


    /**
     * 判断当前对象是否为空
     * - 对象为空
     * - 空字符串
     * - 空集合/map
     * - 空数组
     * - 自定义空类型
     *
     * @param object 对象
     * @return  是否为空
     */
    public static Boolean isNull(Object object) {
        if (null == object) {
            return true;
        }
//        if(object instanceof IsNull) {
//            IsNull isNull = (IsNull)object;
//            return isNull.isNull();
//        }

        return false;
    }

    /**
     * 判断对象是否非null
     *
     * @param object 元素
     * @return {@code true} 非空
     */
    public static Boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * 判断内容是否为空
     * - 空字符串
     * - 空集合/map
     * - 空数组
     * - 自定义空类型
     *
     * @param object 对象
     * @return  是否为空
     */
    public static Boolean isEmpty(Object object) {
        if (isNull(object)) {
            return true;
        }

        if (object instanceof String) {
            String string = (String) object;
            return StringUtil.isEmpty(string);
        }
        if (object instanceof Collection) {
            Collection collection = (Collection) object;
            return CollectionUtil.isEmpty(collection);
        }
        if (object instanceof Map) {
            Map map = (Map) object;
            return MapUtil.isEmpty(map);
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }

        return false;
    }

    /**
     * 判断对象是否非空
     *
     * @param object 对象
     * @return  是否非空
     */
    public static Boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }


    /**
     * 判断两个对象是否相同
     * 1.如果不是同一种类型,则直接返回false
     *
     * @param except 期望值
     * @param real 实际值
     * @return 两个对象是否相同
     */
    public static boolean isEquals(Object except, Object real) {
        //1. 不是同一种类型
        if (isNotSameType(except, real)) {
            return false;
        }

        //2. 基本类型
        if (ClassUtil.isPrimitive(except) && ClassUtil.isPrimitive(real)) {
            if (except != real) {
                return false;
            }
        }

        //3. 数组
        if (ClassUtil.isArray(except) && ClassUtil.isArray(real)) {
            Object[] exceptArray = (Object[]) except;
            Object[] realArray = (Object[]) real;
            return Arrays.equals(exceptArray, realArray);
        }

        //3. Collection
//        if(ClassUtil.isCollection(except) && ClassUtil.isCollection(real)) {
//            Collection exceptCollection = (Collection)except;
//            Collection realCollection = (Collection)real;
//            return CollectionUtil.isEqualCollection(exceptCollection, realCollection);
//        }

        //4. map
        if (ClassUtil.isMap(except) && ClassUtil.isMap(real)) {
            Map exceptMap = (Map) except;
            Map realMap = (Map) real;
            return exceptMap.equals(realMap);
        }

        return except.equals(real);
    }

    /**
     * 判断两个对象是否不相同
     * 1.如果不是同一种类型,则返回true
     *
     * @param except 期望值
     * @param real 实际值
     * @return 两个对象是否不同
     */
    public static Boolean isNotEquals(Object except, Object real) {
        return !isEquals(except, real);
    }

}
