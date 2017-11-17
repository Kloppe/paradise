package com.github.houbb.paradise.common.support.assign.core.impl;



import com.github.houbb.paradise.common.support.assign.core.Assign;
import com.github.houbb.paradise.common.support.assign.core.ExplicitAssign;
import com.github.houbb.paradise.common.support.assign.core.SelectiveAssign;
import com.github.houbb.paradise.common.support.assign.exception.AssignException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 抽象实现
 * @author bbhou
 * @version 1.1.2
 */
public class AbstractAssign implements Assign, ExplicitAssign, SelectiveAssign {

    @Override
    public void assign(Object example, Object target) throws AssignException {

    }

    @Override
    public void assignExplicitCondition(Object example, Object target, String... fieldName) throws AssignException {

    }

    @Override
    public void assignExplicitCondition(Object example, Object target, List<String> fieldNameList) throws AssignException {

    }

    @Override
    public void assignExplicitUnless(Object example, Object target, String... fieldName) throws AssignException {

    }

    @Override
    public void assignExplicitUnless(Object example, Object target, List<String> fieldNameList) throws AssignException {

    }

    @Override
    public void assignExampleSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException {

    }

    @Override
    public void assignTargetSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException {

    }
}
