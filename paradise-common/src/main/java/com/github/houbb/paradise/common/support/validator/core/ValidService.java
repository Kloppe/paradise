package com.github.houbb.paradise.common.support.validator.core;

import com.github.houbb.paradise.common.support.validator.exception.ValidException;

/**
 * 校验接口
 * @author houbinbin
 * @version 1.1.2
 * @since 1.1.2
 */
public interface ValidService {

    /**
     * 对参数进行参数校验
     * @param object 入参
     * @throws IllegalAccessException 访问权限异常
     * @throws ValidException if any
     */
    void valid(Object object) throws ValidException, IllegalAccessException;

}
