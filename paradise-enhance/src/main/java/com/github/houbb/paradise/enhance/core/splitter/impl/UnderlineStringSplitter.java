package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.constant.CommonConstant;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.enhance.constant.translator.GoogleLanguageEnum;
import com.github.houbb.paradise.enhance.core.connector.impl.StringConnector;
import com.github.houbb.paradise.enhance.core.translator.impl.GoogleTranslator;

import java.util.LinkedList;
import java.util.List;

public class UnderlineStringSplitter extends AbstractStringSplitter {
    public UnderlineStringSplitter(String string) {
        super(string);
    }

    @Override
    public List<String> split() {
        if(StringUtil.isEmpty(string)) {
            return null;
        }

        List<String> stringList = new LinkedList<>();
        String[] strings = string.split(CommonConstant.UNDERLINE);

        for(String string : strings) {
            stringList.add(string.trim());
        }

        return stringList;
    }

}
