package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.util.StringUtil;

import java.util.List;

public class CamelStringSplitter extends AbstractStringSplitter {

    public CamelStringSplitter(String string) {
        super(string);
    }


    public static CamelStringSplitter newInstance(String string) {
        return new CamelStringSplitter(string);
    }

    @Override
    public List<String> split() {
        String underline = StringUtil.camelToUnderline(string);
        return new UnderlineStringSplitter(underline).split();
    }

}
