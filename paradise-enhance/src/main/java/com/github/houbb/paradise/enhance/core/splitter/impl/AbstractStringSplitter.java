package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.enhance.core.splitter.Splitter;

public abstract class AbstractStringSplitter implements Splitter {

    /**
     * 待分隔的字符串
     */
    protected String string;

    public AbstractStringSplitter(String string) {
        this.string = string;
    }

}
