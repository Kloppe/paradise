package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.constant.CommonConstant;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.enhance.core.splitter.Splitter;

/**
 * splitter 工厂
 */
public class SplitterFactory {

    public static Splitter newSplitter(final String name) {
        if(StringUtil.isEmpty(name)) {
            return null;
        }

        if(name.contains(CommonConstant.UNDERLINE)) {
            return new UnderlineStringSplitter(name);
        }

        return new CamelStringSplitter(name);
    }

}