package com.github.houbb.paradise.enhance.core.connector.impl;

import com.github.houbb.paradise.common.util.CollectionUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.enhance.core.connector.Connector;

import java.util.List;

/**
 *  串连接器
 */
public class StringConnector implements Connector<String> {

    /**
     * 待连接的字符串列表
     */
    private List<String> stringList;

    /**
     * 分隔符
     */
    private String separator;

    /**    
     *  串连接器    
     *    
     * @param stringList 字符串列表    
     * @param separator 分隔器    
     */    
    public StringConnector(List<String> stringList, String separator) {
        this.stringList = stringList;
        this.separator = separator;
    }

    /**    
     * 新的实例    
     *    
     * @param stringList 字符串列表    
     * @param separator 分隔器    
     * @return com.github.houbb.paradise.enhance.core.connector.impl.StringConnector    
     */    
    public static StringConnector newInstance(List<String> stringList, String separator) {
        return new StringConnector(stringList, separator);
    }

    /**    
     * 连    
     *    
     * @return java.lang.String    
     */    
    @Override
    public String connect() {
        if(CollectionUtil.isEmpty(stringList)) {
            return StringUtil.EMPTY;
        }

        String[] strings = CollectionUtil.listToArray(stringList);
        return StringUtil.join(strings, separator, 0, strings.length);
    }

}
