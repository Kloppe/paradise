package com.github.houbb.paradise.common.support.generator.core.impl;

import com.github.houbb.paradise.common.support.generator.exception.GeneratorException;
import com.github.houbb.paradise.common.support.generator.handler.GeneratorHandler;
import com.github.houbb.paradise.common.util.CollectionUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 每一行的文本处理生成
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public class EachLineGenerator extends AbstractGenerator {

    public EachLineGenerator(String filePath, GeneratorHandler generatorHandler) {
        this(filePath, StandardCharsets.UTF_8, generatorHandler);
    }

    public EachLineGenerator(String filePath, Charset charset, GeneratorHandler generatorHandler) {
        this.filePath = filePath;
        this.charset = charset;
        this.generatorHandler = generatorHandler;
    }

    @Override
    public void generate() throws GeneratorException {
        Path path = Paths.get(filePath);
        try {
            List<String> stringList = Files.readAllLines(path, charset);
            if(CollectionUtil.isEmpty(stringList)) {
                return;
            }

            for(String string : stringList) {
                generatorHandler.handle(string);
            }
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }


}
