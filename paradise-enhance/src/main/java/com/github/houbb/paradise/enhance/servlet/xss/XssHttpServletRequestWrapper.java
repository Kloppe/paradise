/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.enhance.servlet.xss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/7 下午8:00  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.1.4
 * @since JDK 1.7
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private boolean filterXSS;
    private boolean filterSQL;

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        this(request, true, true);
    }

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean filterXSS, boolean filterSQL) {
        super(request);
        this.filterXSS = true;
        this.filterSQL = true;
        this.filterXSS = filterXSS;
        this.filterSQL = filterSQL;
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        } else {
            int count = values.length;
            String[] encodedValues = new String[count];

            for(int i = 0; i < count; ++i) {
                encodedValues[i] = this.filterParamString(values[i]);
            }

            return encodedValues;
        }
    }

    public Map getParameterMap() {
        Map<String, String[]> primary = super.getParameterMap();
        Map<String, String[]> result = new HashMap(primary.size());
        Iterator i$ = primary.entrySet().iterator();

        while(i$.hasNext()) {
            Map.Entry<String, String[]> entry = (Map.Entry)i$.next();
            result.put(entry.getKey(), this.filterEntryString((String[])entry.getValue()));
        }

        return result;
    }

    protected String[] filterEntryString(String[] rawValue) {
        for(int i = 0; i < rawValue.length; ++i) {
            rawValue[i] = this.filterParamString(rawValue[i]);
        }

        return rawValue;
    }

    @Override
    public String getParameter(String parameter) {
        return this.filterParamString(super.getParameter(parameter));
    }

    @Override
    public String getHeader(String name) {
        return this.filterParamString(super.getHeader(name));
    }

    @Override
    public Cookie[] getCookies() {
        Cookie[] existingCookies = super.getCookies();
        if (existingCookies != null) {
            Cookie[] arr$ = existingCookies;
            int len$ = existingCookies.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Cookie cookie = arr$[i$];
                cookie.setValue(this.filterParamString(cookie.getValue()));
            }
        }

        return existingCookies;
    }

    protected String filterParamString(String rawValue) {
        if (null == rawValue) {
            return null;
        } else {
            String tmpStr = rawValue;
            if (this.filterXSS) {
                tmpStr = WafUtil.stripXSS(rawValue);
            }

            if (this.filterSQL) {
                tmpStr = WafUtil.stripSqlInjection(tmpStr);
            }

            return tmpStr;
        }
    }
}
