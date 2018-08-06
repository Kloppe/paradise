/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.spring.datasource.dynamic.aspect;

import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.github.houbb.paradise.common.annotation.dev.API;
import com.github.houbb.paradise.common.util.ObjectUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.spring.datasource.dynamic.annotation.DataSource;
import com.github.houbb.paradise.spring.datasource.dynamic.core.DynamicDataSourceHolder;
import com.github.houbb.paradise.spring.datasource.dynamic.exception.DynamicDataSourceException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p> 动态数据源 aop 切面</p>
 *
 * <pre> Created: 2018/8/6 下午11:18  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Component
@Aspect
@API(status = API.Status.EXPERIMENTAL)
public class DynamicDataSourceAspect {

    private Log log = LogFactory.getLog(DynamicDataSourceAspect.class);

    @Pointcut("@annotation(com.github.houbb.paradise.spring.datasource.dynamic.annotation.DataSource)")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Method method = getCurrentMethod(point);

        //1. 当前方法是否有注解
        boolean methodFlag = method.isAnnotationPresent(DataSource.class);
        if(methodFlag) {
            DataSource datasource = method.getAnnotation(DataSource.class);
            setDataSource(datasource);
        } else {
            //2. 当前类是否有注解
            Class clazz = getClass(point);
            if(clazz.isAnnotationPresent(DataSource.class)) {
                //IDEA BUG
                DataSource datasource = (DataSource) clazz.getAnnotation(DataSource.class);
                setDataSource(datasource);
            }
        }

        Object result = point.proceed();
        DynamicDataSourceHolder.clearDataSource();
        return result;
    }

    private Class getClass(ProceedingJoinPoint point) {
        return point.getTarget().getClass();
    }

    /**
     * 设置数据源的值
     * @param dataSource 数据源注解
     */
    private void setDataSource(DataSource dataSource) {
        if(ObjectUtil.isNull(dataSource)) {
            return;
        }
        String value = dataSource.value();
        if(StringUtil.isNotEmpty(value)) {
            DynamicDataSourceHolder.setDataSource(value);
            log.debug("Set datasource with value: {}", value);
        }
    }

    /**
     * 获取当前代理的方法
     * @param point 切面
     * @return 方法
     */
    private Method getCurrentMethod(ProceedingJoinPoint point) {
        try {
            Signature sig = point.getSignature();
            MethodSignature msig = (MethodSignature) sig;
            Object target = point.getTarget();
            return target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new DynamicDataSourceException(e);
        }
    }

}
