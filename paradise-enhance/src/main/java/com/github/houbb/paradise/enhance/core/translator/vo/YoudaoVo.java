package com.github.houbb.paradise.enhance.core.translator.vo;

import com.github.houbb.paradise.enhance.vo.OptionVo;

import java.util.List;

/**
 * Created by pc-06 on 2017/4/13.
 * 有道词典值传入对象
 * @version 1.1.4
 * @since 1.1.4
 */
public class YoudaoVo {

    /**    
     * 翻译    
     */    
    private List<String> translation;

    /**    
     * 询问    
     */    
    private String query;

    /**    
     * 错误代码    
     */    
    private int errorCode;

    /**    
     * 卷筒纸    
     */    
    private List<OptionVo> web;

    /**    
     * 得到翻译    
     *    
     * @return java.util.List    
     */    
    public List<String> getTranslation() {
        return translation;
    }

    /**    
     * 设置翻译    
     *    
     * @param translation 翻译    
     */    
    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    /**    
     * 得到查询    
     *    
     * @return java.lang.String    
     */    
    public String getQuery() {
        return query;
    }

    /**    
     * 设置查询    
     *    
     * @param query 询问    
     */    
    public void setQuery(String query) {
        this.query = query;
    }

    /**    
     * 得到错误代码    
     *    
     * @return int    
     */    
    public int getErrorCode() {
        return errorCode;
    }

    /**    
     * 设置错误代码    
     *    
     * @param errorCode 错误代码    
     */    
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**    
     * 得到网络    
     *    
     * @return java.util.List    
     */    
    public List<OptionVo> getWeb() {
        return web;
    }

    /**    
     * 设置网络    
     *    
     * @param web 卷筒纸    
     */    
    public void setWeb(List<OptionVo> web) {
        this.web = web;
    }
}
