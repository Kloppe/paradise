package com.github.houbb.paradise.enhance.core.generator.core;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateExceptionHandler;

import java.util.Locale;

/**
 * FTL模板生成的抽象类。
 * @author houbinbin
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public abstract class AbstractFTLGenerator {

    /**
     * template 模板配置
     */
    private Configuration configuration = null;


    /**
     * 目标路径
     */
    private String targetPath;

    /**
     * FTL 文件存储的根路径
     */
    private String ftlBasePackagePath;

    /**    
     * 获取配置    
     *    
     * @return freemarker.template.Configuration    
     */    
    public Configuration getConfiguration() {
        return configuration;
    }

    /**    
     * 获得目标路径    
     *    
     * @return java.lang.String    
     */    
    public String getTargetPath() {
        return targetPath;
    }


    /**    
     *  抽象的发电机    
     *    
     * @param targetPath 目标路径    
     */    
    public AbstractFTLGenerator(String targetPath) {
        init();
        this.targetPath = targetPath;
    }

    /**    
     *  抽象的发电机    
     *    
     * @param configuration 组态    
     * @param targetPath 目标路径    
     */    
    public AbstractFTLGenerator(Configuration configuration, String targetPath) {
        init();
        this.configuration = configuration;
        this.targetPath = targetPath;
    }


    /**
     * 初始化
     */
    public void init() {
        if(null == configuration) {
            configuration = new Configuration();
            configuration.setEncoding(Locale.getDefault(),"UTF-8");
            // 设置对象的包装器
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            // 设置异常处理器//这样的话就可以${a.b.c.d}即使没有属性也不会出错
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            configuration.setClassForTemplateLoading(this.getClass(), ftlBasePackagePath);
        }
    }

}
