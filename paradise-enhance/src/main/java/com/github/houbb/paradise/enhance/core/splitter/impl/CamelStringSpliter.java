package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.util.StringUtil;

import java.util.List;

public class CamelStringSpliter extends AbstractStringSplitter {

    public CamelStringSpliter(String string) {
        super(string);
    }


    @Override
    public List<String> split() {
        String underline = StringUtil.camelToUnderline(string);
        return new UnderlineStringSplitter(underline).split();
    }

    public static void main(String[] args) {

    }

}
