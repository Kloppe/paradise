package com.github.houbb.paradise.spring.datasource.dynamic.interceptor;

import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.github.houbb.paradise.common.util.ObjectUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.spring.datasource.dynamic.annotation.DataSource;
import com.github.houbb.paradise.spring.datasource.dynamic.core.DynamicDataSourceHolder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 2018/1/19
 *
 * @author houbinbin
 * @version 1.1.3
 * @since 1.1.3, 2018/01/19
 */
public class DynamicDataSourceInterceptor implements MethodInterceptor {

    private Log log = LogFactory.getLog(DynamicDataSourceInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = getTargetMethod(invocation);

        //1. 当前方法是否有注解
        boolean methodFlag = method.isAnnotationPresent(DataSource.class);
        if(methodFlag) {
            DataSource datasource = method.getAnnotation(DataSource.class);
            setDataSource(datasource);

        } else {
            //2. 当前类是否有注解
            Class clazz = getClass(invocation);
            if(clazz.isAnnotationPresent(DataSource.class)) {
                DataSource datasource = (DataSource) clazz.getAnnotation(DataSource.class);
                setDataSource(datasource);
            }
        }

        Object result = invocation.proceed();
        DynamicDataSourceHolder.clearDataSource();  //clear what we set;
        return result;
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
     * 获取方法。
     * (1) 直接用最简单的getMethod() 只能获取super的声明。
     * (2) 此处是根据aop 直接切取得,不应该出现方法不存在的情况。
     * @param invocation
     * @return
     */
    private Method getTargetMethod(MethodInvocation invocation) {
        Method method = null;
        try {
//            method = methodInvocation.getThis().getClass().getMethod(methodInvocation.getMethod().getName(), methodInvocation.getMethod().getParameterTypes());
            method = invocation.getThis().getClass().getMethod(invocation.getMethod().getName(), invocation.getMethod().getParameterTypes());
        } catch (NoSuchMethodException e) {
            log.error("getTargetMethod meet ex: {}", e, e);
        }
        return method;
    }

    private Class getClass(MethodInvocation invocation) {
        return invocation.getThis().getClass();
    }

}
