package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.constant.CommonConstant;
import com.github.houbb.paradise.common.util.StringUtil;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *  下划线字符串分隔符
 * @author houbinbin
 */
public class UnderlineStringSplitter extends AbstractStringSplitter {
    /**    
     *  下划线字符串分隔符    
     *    
     * @param string 串    
     */    
    public UnderlineStringSplitter(String string) {
        super(string);
    }

    /**    
     * 新的实例    
     *    
     * @param string 串    
     * @return com.github.houbb.paradise.enhance.core.splitter.impl.UnderlineStringSplitter    
     */    
    public static UnderlineStringSplitter newInstance(String string) {
        return new UnderlineStringSplitter(string);
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

        List<String> stringList = new LinkedList<>();
        String[] strings = string.split(CommonConstant.UNDERLINE);

        for(String string : strings) {
            stringList.add(string.trim());
        }

        return stringList;
    }

}
