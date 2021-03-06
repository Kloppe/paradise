package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.constant.CommonConstant;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.enhance.core.splitter.Splitter;

/**
 * splitter 工厂
 * @author houbinbin
 */
public final class SplitterFactory {

    private SplitterFactory(){}

    /**    
     * 新的分离器    
     *    
     * @param name name    
     * @return com.github.houbb.paradise.enhance.core.splitter.Splitter    
     */    
    public static Splitter newSplitter(final String name) {
        if(StringUtil.isEmpty(name)) {
            return EmptySplitter.newInstance(name);
        }

        if(name.contains(CommonConstant.UNDERLINE)) {
            return UnderlineStringSplitter.newInstance(name);
        }

        // 不包含小写字母
        if(!StringUtil.containsLowercase(name)) {
            return UppercaseStringSplitter.newInstance(name);
        }

        return CamelStringSplitter.newInstance(name);
    }

}
