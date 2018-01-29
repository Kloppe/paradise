package com.github.houbb.paradise.spring.datasource.dynamic.core;

/**
 *
 * 动态数据源
 * @author houbinbin
 * @version 1.1.3
 * @since 1.1.3, 2018/01/19
 */
public final class DynamicDataSourceHolder  {

    private DynamicDataSourceHolder(){}

    /**
     * 保证线程间互不干涉
     */
    private static final ThreadLocal<String> context = new ThreadLocal<>();

    /**
     * 设置数据源类型
     * @param datasource  数据库类型
     */
    public static void setDataSource(String datasource) {
        context.set(datasource);
    }

    /**
     * 获取数据源类型
     * @return 数据源类型
     */
    public static String getDataSource() {
        return context.get();
    }

    /**
     * 清空数据源
     */
    public static void clearDataSource() {
        context.remove();
    }

}
