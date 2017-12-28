package com.github.houbb.paradise.common.support.generator.core;

import com.github.houbb.paradise.common.support.generator.exception.GeneratorException;

/**
 * 生成者接口定义
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public interface Generator {

    /**
     * 生成
     * @throws GeneratorException 生成时遇到的异常
     */
    void generate() throws GeneratorException;

}
