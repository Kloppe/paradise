package com.github.houbb.paradise.enhance.core.connector.impl;

import com.github.houbb.paradise.common.util.CollectionUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.enhance.constant.translator.GoogleLanguageEnum;
import com.github.houbb.paradise.enhance.core.connector.Connector;
import com.github.houbb.paradise.enhance.core.splitter.impl.UnderlineStringSplitter;
import com.github.houbb.paradise.enhance.core.translator.impl.GoogleTranslator;

import java.util.List;

public class StringConnector implements Connector<String> {

    /**
     * 待连接的字符串列表
     */
    private List<String> stringList;

    /**
     * 分隔符
     */
    private String separator;

    public StringConnector(List<String> stringList, String separator) {
        this.stringList = stringList;
        this.separator = separator;
    }

    @Override
    public String connect() {
        if(CollectionUtil.isEmpty(stringList)) {
            return StringUtil.EMPTY;
        }

        String[] strings = CollectionUtil.listToArray(stringList);
        return StringUtil.join(strings, separator, 0, strings.length);
    }

}
