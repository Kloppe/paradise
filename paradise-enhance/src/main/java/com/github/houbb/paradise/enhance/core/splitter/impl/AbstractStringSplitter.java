package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.enhance.core.splitter.Splitter;

/**
 *  抽象的字符串分离器
 *
 * @author houbinbin
 */
public abstract class AbstractStringSplitter implements Splitter {

    /**
     * 待分隔的字符串
     */
    protected String string;

    /**
     *  抽象的字符串分离器
     *
     * @param string 串
     */
    public AbstractStringSplitter(String string) {
        this.string = string;
    }

}
