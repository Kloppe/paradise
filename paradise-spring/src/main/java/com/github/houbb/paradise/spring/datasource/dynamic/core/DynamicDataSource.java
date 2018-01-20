package com.github.houbb.paradise.spring.datasource.dynamic.core;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * 动态数据源
 * @author houbinbin
 * @version 1.1.3
 * @since 1.1.3, 2018/01/19
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSource();
    }

}
