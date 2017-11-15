package com.github.houbb.paradise.common.support.filter;

/**
 * 2017/11/14
 *
 * 过滤器接口定义
 * @author houbinbin
 * @version 1.1.1
 * @see com.github.houbb.paradise.common.util.FilterUtil 工具类
 */
public interface Filter {

    /**
     * 是否包含
     * @return  {@code true} 是
     */
    boolean include();

    /**
     * 是否不包含
     * @return  {@code true} 是
     */
    boolean exclude();

}
