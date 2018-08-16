/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.util.StringUtil;

import java.util.Collections;
import java.util.List;

/**
 *  大写字符串分隔符
 * @author houbinbin
 */
public class UppercaseStringSplitter extends AbstractStringSplitter {
    /**
     *  下划线字符串分隔符
     *
     * @param string 串
     */
    public UppercaseStringSplitter(String string) {
        super(string);
    }

    /**    
     * 新的实例    
     *    
     * @param string 串    
     * @return com.github.houbb.paradise.enhance.core.splitter.impl.UnderlineStringSplitter    
     */    
    public static UppercaseStringSplitter newInstance(String string) {
        return new UppercaseStringSplitter(string);
    }

    /**    
     * 分裂    
     *    
     * @return java.util.List    
     */    
    @Override
    public List<String> split() {
        if(StringUtil.isEmpty(string)) {
            return Collections.emptyList();
        }

        return Collections.singletonList(string);
    }

}
