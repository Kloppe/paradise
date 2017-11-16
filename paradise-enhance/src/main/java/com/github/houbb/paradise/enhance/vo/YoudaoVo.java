package com.github.houbb.paradise.enhance.vo;

import java.util.List;

/**
 * Created by pc-06 on 2017/4/13.
 * 有道词典值传入对象
 */
public class YoudaoVo {

    private List<String> translation;

    private String query;

    private int errorCode;

    private List<OptionVo> web;

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<OptionVo> getWeb() {
        return web;
    }

    public void setWeb(List<OptionVo> web) {
        this.web = web;
    }
}

//{"translation":["我爱中国"],"query":"I love China","errorCode":0,"web":[{"value":["我爱中国","我爱我中华","中国心"],"key":"I love China"},{"value":["我热爱中国"],"key":"I deeply love China"},{"value":["我爱我中华","我爱你中国","中国我爱你"],"key":"I LOVE YOU CHINA"}]}
