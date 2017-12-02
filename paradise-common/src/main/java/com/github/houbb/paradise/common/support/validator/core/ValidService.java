package com.github.houbb.paradise.common.support.validator.core;

import com.github.houbb.paradise.common.support.validator.exception.ValidException;

public interface ValidService {

    /**
     * 对参数进行参数校验
     * @param object 入参
     */
    void valid(Object object) throws ValidException, IllegalAccessException;

}
