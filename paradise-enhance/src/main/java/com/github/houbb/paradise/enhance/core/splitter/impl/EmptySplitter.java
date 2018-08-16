/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.enhance.core.splitter.impl;

import java.util.Collections;
import java.util.List;

/**
 *  空符串分隔符
 * @author houbinbin
 */
public class EmptySplitter extends AbstractStringSplitter {
    /**
     *  下划线字符串分隔符
     *
     * @param string 串
     */
    public EmptySplitter(String string) {
        super(string);
    }

    /**    
     * 新的实例    
     *    
     * @param string 串    
     * @return com.github.houbb.paradise.enhance.core.splitter.impl.UnderlineStringSplitter    
     */    
    public static EmptySplitter newInstance(String string) {
        return new EmptySplitter(string);
    }

    /**    
     * 分裂    
     *    
     * @return java.util.List    
     */    
    @Override
    public List<String> split() {
        return Collections.emptyList();
    }

}
