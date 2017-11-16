package com.github.houbb.paradise.enhance.core.translator;

/**
 * todo:    接口的重新定义
 */
public interface TranslatorOld {

    /**
     * http请求的类型(如"text/html" , "text/plain")
     * @param type 请求的类型
     */
    public void setContentType(String type) ;

    /**
     * 翻译语言(自动识别源语言)
     * @param text 翻译的内容
     * @param targetLang 目标语言
     * @return 目标语言内容
     */
    public String translate(final String text, final String targetLang) throws Exception ;

    /**
     * 翻译语言(自动识别源语言)
     * @param texts 翻译的内容数组
     * @param targetLang 目标语言
     * @return 目标语言内容
     */
    public String[] translate(final String[] texts, final String targetLang) throws Exception ;

    /**
     * 翻译语言
     * @param text 翻译的内容
     * @param srcLang 源语言
     * @param targetLang 目标语言
     * @return 目标语言内容
     */
    public String translate(final String text, final String srcLang, final String targetLang) throws Exception ;

    /**
     * 翻译语言
     * @param texts 翻译的内容数组
     * @param srcLang 源语言
     * @param targetLang 目标语言
     * @return 目标语言内容
     */
    public String[] translate(final String[] texts, final String srcLang, final String targetLang) throws Exception ;

}
