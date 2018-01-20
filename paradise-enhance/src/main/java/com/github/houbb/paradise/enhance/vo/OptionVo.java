package com.github.houbb.paradise.enhance.vo;

import java.util.List;

/**
 * Created by pc-06 on 2017/4/13.
 * 值传输对象
 */
public class OptionVo {

    /**    
     * 键    
     */    
    private String key;

    /**    
     * 值    
     */    
    private List<String> value;

    /**    
     * 得到钥匙    
     *    
     * @return java.lang.String    
     */    
    public String getKey() {
        return key;
    }

    /**    
     * 设置键    
     *    
     * @param key 键    
     */    
    public void setKey(String key) {
        this.key = key;
    }

    /**    
     * 得到价值    
     *    
     * @return java.util.List    
     */    
    public List<String> getValue() {
        return value;
    }

    /**    
     * 设定值    
     *    
     * @param value 值    
     */    
    public void setValue(List<String> value) {
        this.value = value;
    }
}
