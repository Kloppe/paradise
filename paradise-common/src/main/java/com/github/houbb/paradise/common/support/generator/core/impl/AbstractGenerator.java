package com.github.houbb.paradise.common.support.generator.core.impl;

import com.github.houbb.paradise.common.support.generator.core.Generator;
import com.github.houbb.paradise.common.support.generator.handler.GeneratorHandler;

import java.nio.charset.Charset;

/**
 * 抽象生成者
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public abstract class AbstractGenerator implements Generator {

    /**
     * 文件路径
     */
    protected String filePath;

    /**
     * 文件编码
     * 默认 UTF-8
     */
    protected Charset charset;

    /**
     * 对于文件的处理
     */
    protected GeneratorHandler generatorHandler;


}
