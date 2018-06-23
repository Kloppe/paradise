package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.util.StringUtil;

import java.util.List;

/**
 *  骆驼串拆分器
 * @author houbinbin
 */
public class CamelStringSplitter extends AbstractStringSplitter {

    /**    
     *  骆驼串拆分器    
     *    
     * @param string 串    
     */    
    public CamelStringSplitter(String string) {
        super(string);
    }


    /**    
     * 新的实例    
     *    
     * @param string 串    
     * @return com.github.houbb.paradise.enhance.core.splitter.impl.CamelStringSplitter    
     */    
    public static CamelStringSplitter newInstance(String string) {
        return new CamelStringSplitter(string);
    }

    /**    
     * 分裂    
     *    
     * @return java.util.List    
     */    
    @Override
    public List<String> split() {
        String underline = StringUtil.camelToUnderline(string);
        return new UnderlineStringSplitter(underline).split();
    }

}
