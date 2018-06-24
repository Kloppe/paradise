/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.enhance.servlet.xss;

import java.util.regex.Pattern;

/**
 * <p> WAF 工具类 </p>
 *
 * <pre> Created: 2018/6/7 下午8:00  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.4
 * @since JDK 1.7
 */
public class WafUtil {

    private static final Pattern SCRIPT_REG_PATTERN = Pattern.compile("<script>(.*?)</script>", 2);
    private static final Pattern SCRIPT_END_PATTERN = Pattern.compile("</script>", 2);
    private static final Pattern SCRIPT_PATTERN     = Pattern.compile("<script(.*?)>", 42);
    private static final Pattern EVAL_PATTERN       = Pattern.compile("eval\\((.*?)\\)", 42);
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("expression\\((.*?)\\)", 42);
    private static final Pattern JAVASCRIPT_PATTERN = Pattern.compile("javascript:", 2);
    private static final Pattern VBSCRIPT_PATTERN = Pattern.compile("vbscript:", 2);
    private static final Pattern ONLOAD_PATTERN = Pattern.compile("onload(.*?)=", 42);

    public static String stripXSS(String value) {
        String rlt = null;
        if (null != value) {
            rlt = value.replaceAll("", "");
            rlt = SCRIPT_REG_PATTERN.matcher(rlt).replaceAll("");
            rlt = SCRIPT_END_PATTERN.matcher(rlt).replaceAll("");
            rlt = SCRIPT_PATTERN.matcher(rlt).replaceAll("");
            rlt = EVAL_PATTERN.matcher(rlt).replaceAll("");
            rlt = EXPRESSION_PATTERN.matcher(rlt).replaceAll("");
            rlt = JAVASCRIPT_PATTERN.matcher(rlt).replaceAll("");
            rlt = VBSCRIPT_PATTERN.matcher(rlt).replaceAll("");
            rlt = ONLOAD_PATTERN.matcher(rlt).replaceAll("");
        }

        return rlt;
    }

    public static String stripSqlInjection(String value) {
        return null == value ? null : value.replaceAll("('.+--)|(--)|(%7C)", "");
    }

    public static String stripSqlXSS(String value) {
        return stripXSS(stripSqlInjection(value));
    }

}
