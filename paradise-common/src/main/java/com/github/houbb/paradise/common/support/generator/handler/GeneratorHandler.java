package com.github.houbb.paradise.common.support.generator.handler;

import com.github.houbb.paradise.common.support.generator.exception.GeneratorException;

/**
 * 生成处理
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public interface GeneratorHandler {

    /**
     * 处理
     * @throws GeneratorException 生成异常
     */
    void handle(final String content) throws GeneratorException;

}
