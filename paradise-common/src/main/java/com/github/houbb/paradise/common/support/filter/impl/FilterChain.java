package com.github.houbb.paradise.common.support.filter.impl;



import com.github.houbb.paradise.common.support.filter.Filter;

import java.util.LinkedList;
import java.util.List;

/**
 * 过滤器责任链
 *
 * @author bbhou
 * @version 1.1.1
 * @since 1.1.1
 */
public class FilterChain implements Filter {

    /**
     * 用于存放有优先级的限制条件
     */
    private List<Filter> filterList = new LinkedList<>();

    /**
     * 添加一个限制者
     * @param filter 过滤器
     * @return 责任链
     */
    public FilterChain addFilter(Filter filter) {
        filterList.add(filter);
        return this;
    }

    /**
     * 移除一个限制者
     * @param index 下标
     * @return 责任链
     */
    public FilterChain removeFilter(int index) {
        filterList.remove(index);
        return this;
    }

    /**
     * 全为真则为真
     * @return {@code true} 是否包含
     */
    @Override
    public boolean include() {
        boolean result = true;

        for(Filter filter : filterList) {
            if(!filter.include()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean exclude() {
        return !include();
    }
}
