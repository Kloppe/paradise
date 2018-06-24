package com.github.houbb.paradise.enhance.core.generator.util;


import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;


/**
 * 代码生成工具类 模板不依赖于LOG 使用System.out.println();
 * @author houbinbin
 * @since 1.1.2
 * @version 1.1.2, 2017/12/28
 */
public final class GeneratorUtil {

    private static Log log = LogFactory.getLog(GeneratorUtil.class);

    /**    
     *  有用的发电机    
     */    
    private GeneratorUtil(){}

    /**
     * 创建文件夹
     * @param dirPath dir path
     */
    public static void makeDirectory(String dirPath) {
        File tempFile = new File(dirPath);
        if (!tempFile.exists()) {
            log.debug("Create target directory path is: {}", dirPath);
            try {
                boolean result = tempFile.mkdirs();
                if(!result) {
                    log.error("创建文件夹失败");
                }
            } catch (Exception e) {
                log.error("创建文件夹失败", e);
            }
        }
    }


    /**
     * 根据模板创建文件
     * @param root 属性根
     * @param fileName 文件名
     * @param template 模板
     * @throws Exception 异常
     */
    public static void buildTemplate(Map root, String fileName, Template template) throws Exception {
        File file = new File(fileName);
        String fileAbsolutePath = file.getAbsolutePath();
        log.info("开始创建模板文件: {}", fileAbsolutePath);
        OutputStream outputStream = new FileOutputStream(fileAbsolutePath);
        Writer out = new OutputStreamWriter(outputStream, "UTF-8");
        template.process(root, out);
        log.info("创建模板文件完成");
    }


    /**
     * 命令行获取输入
     * @param prompt 格式
     * @return 字符串结果
     */
    public static String readDataFromConsole(String prompt) {
        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("Console is not available!");
        }
        return console.readLine(prompt);
    }
}
