package com.github.houbb.paradise.enhance.core.generator.core.impl;

import com.github.houbb.paradise.common.util.CollectionUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.enhance.constant.translator.GoogleLanguageEnum;
import com.github.houbb.paradise.enhance.core.generator.model.OrderedProperties;
import com.github.houbb.paradise.enhance.core.translator.Translator;
import com.github.houbb.paradise.enhance.core.translator.impl.GoogleTranslator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/5/2 下午6:20  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class I18NGenerator {

    /**
     * 是否 overwrite 当文件存在时
     */
    private boolean isOverwriteWhenExists;

    /**
     * 基础路径
     */
    private File file;

    private Properties properties;

    /**
     * 指定的语言
     */
    private List<String> languages = new LinkedList<>();


    public I18NGenerator file(final String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8")) {
            this.file = new File(filePath);
            properties = new OrderedProperties();
            properties.load(inputStreamReader);
        } catch (IOException e) {
        }
        return this;
    }

    public I18NGenerator isOverwriteWhenExists(final boolean isOverwriteWhenExists) {
        this.isOverwriteWhenExists = isOverwriteWhenExists;
        return this;
    }

    /**
     * 语言
     * @param languages
     * @return
     */
    public I18NGenerator languages(String... languages) {
        this.languages = Arrays.asList(languages);

        return this;
    }

    /**
     * 默认的语言
     */
    private void defaultLanguages() {
        for (GoogleLanguageEnum entry : GoogleLanguageEnum.values()) {
            String type = entry.langInfo();
            if(StringUtil.isEmpty(type.trim())) {
                continue;
            }
            if(type.startsWith("zh")) {
                continue;
            }
            this.languages.add(type);
        }
    }

    /**
     * 生成
     */
    public void gen() throws Exception {
        if(CollectionUtil.isEmpty(this.languages)) {
            defaultLanguages();
        }
        this.properties.keys();

        for(String language : this.languages) {

            List<String> list = new LinkedList<>();
            for (String key : properties.stringPropertyNames()) {
                //1. gen file
                final String value = properties.getProperty(key);
                Translator<String> translate = new GoogleTranslator(value, GoogleLanguageEnum.ENGLISH.langInfo(), language);
                list.add(String.format("%s=%s", key, translate.translate()));
            }

            genFile(language, list);
        }
    }


    private void genFile(String language, List<String> stringList) {
        final String fullName = this.file.getName();
        String fileName = fullName.substring(0, fullName.lastIndexOf("."));
        String dir = this.file.getParentFile().getPath()+"/";
        String resultPath = dir + fileName + "_"+language+".properties";
        File file  = new File(resultPath);
        if(file.exists()) {
            file.delete();
        }

        try {
            file.createNewFile();
            Files.write(file.toPath(), stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        final String path = "/Users/houbinbin/code/_github/word-checker/src/main/resources/i18n/WordCheckerMessages.properties";
        new I18NGenerator().file(path).gen();
    }


}
