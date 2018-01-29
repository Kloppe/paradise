package com.github.houbb.paradise.common.support.assigner.core.impl;



import com.github.houbb.paradise.common.support.assigner.core.Assigner;
import com.github.houbb.paradise.common.support.assigner.core.ExplicitAssigner;
import com.github.houbb.paradise.common.support.assigner.core.SelectiveAssigner;
import com.github.houbb.paradise.common.support.assigner.exception.AssignException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 抽象实现
 * @author bbhou
 * @version 1.1.2
 * @since 1.1.2
 */
public class AbstractAssigner implements Assigner, ExplicitAssigner, SelectiveAssigner {

    @Override
    public void assign(Object example, Object target) throws AssignException {
        //do nothing
    }

    @Override
    public void assignExplicitCondition(Object example, Object target, String... fieldName) throws AssignException {
        //do nothing
    }

    @Override
    public void assignExplicitCondition(Object example, Object target, List<String> fieldNameList) throws AssignException {
        //do nothing
    }

    @Override
    public void assignExplicitUnless(Object example, Object target, String... fieldName) throws AssignException {
        //do nothing
    }

    @Override
    public void assignExplicitUnless(Object example, Object target, List<String> fieldNameList) throws AssignException {
        //do nothing
    }

    @Override
    public void assignExampleSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException {
        //do nothing
    }

    @Override
    public void assignTargetSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException {
        //do nothing
    }
}
