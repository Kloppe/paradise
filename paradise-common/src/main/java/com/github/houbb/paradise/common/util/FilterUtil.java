package com.github.houbb.paradise.common.util;

/**
 * 2017/11/14
 * 过滤工具类
 * @author houbinbin
 * @version 1.1.1
 */
public class FilterUtil {


    /**
     * 是否排除
     *
     * 2. 指定了包含/过滤的内容
     * 2.1 都没指定 所有 class-1;
     * 2.2 只有包含 所有 class-1 and   include
     * 2.3 只有排除 所有 class-1 and ！exclude
     * 2.4 二者都有 所有 class-1 and include and ！exclude  只有当include and !include 才满足条件。
     * @param name 带判断的东西
     * @param includeRegex 包含正则
     * @param excludeRegex 排除正则
     * @return
     */
    public static boolean isExclude(final String name, final String includeRegex, final String excludeRegex) {

        if(StringUtil.isEmpty(includeRegex)
                && StringUtil.isEmpty(excludeRegex)) {
            return false;
        }

        if(StringUtil.isEmpty(includeRegex)
                && StringUtil.isNotEmpty(excludeRegex)) {

            return name.matches(name);
        }
        if(StringUtil.isNotEmpty(includeRegex)
                && StringUtil.isEmpty(excludeRegex)) {
            return !name.matches(name);
        }

        if(StringUtil.isNotEmpty(includeRegex)
                && StringUtil.isNotEmpty(excludeRegex)) {
            return !name.matches(includeRegex) || name.matches(excludeRegex);
        }

        return false;
    }

}
