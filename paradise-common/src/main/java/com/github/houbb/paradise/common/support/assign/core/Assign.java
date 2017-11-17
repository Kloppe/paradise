package com.github.houbb.paradise.common.support.assign.core;

import com.github.houbb.paradise.common.support.assign.exception.AssignException;

import java.lang.reflect.InvocationTargetException;

public interface Assign {

    /**
     * 【常规赋值】对象赋值
     * 1.将 example 与 target 中名称属性一致的值赋给 target。
     * @param example 赋值模板
     * @param target 目标对象
     */
    void assign(Object example, Object target) throws AssignException;




}
