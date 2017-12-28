package com.github.houbb.paradise.common.support.generator.core.impl;

import com.github.houbb.paradise.common.support.generator.exception.GeneratorException;
import com.github.houbb.paradise.common.support.generator.handler.GeneratorHandler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件内容生成者
 * @author bbhou
 * @version 1.1.2
 * @since 1.1.2
 */
public class FileContentGenerator extends AbstractGenerator  {

    public FileContentGenerator(String filePath, GeneratorHandler generatorHandler) {
        this(filePath, StandardCharsets.UTF_8, generatorHandler);
    }

    public FileContentGenerator(String filePath, Charset charset, GeneratorHandler generatorHandler) {
        this.filePath = filePath;
        this.charset = charset;
        this.generatorHandler = generatorHandler;
    }

    @Override
    public void generate() throws GeneratorException {
        Path path = Paths.get(filePath);
        try {
            byte[] bytes = Files.readAllBytes(path);
            String string = new String(bytes);
            generatorHandler.handle(string);
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

}
