package com.github.houbb.paradise.common.support.assigner.core;

import com.github.houbb.paradise.common.support.assigner.exception.AssignException;

/**
 * 赋值者
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public interface Assigner {

    /**
     * 【常规赋值】对象赋值
     * 1.将 example 与 target 中名称属性一致的值赋给 target。
     * @param example 赋值模板
     * @param target 目标对象
     */
    void assign(Object example, Object target) throws AssignException;

}
