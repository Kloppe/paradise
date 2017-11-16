package com.github.houbb.paradise.enhance.vo;

import java.util.List;

/**
 * Created by pc-06 on 2017/4/13.
 * 值传输对象
 */
public class OptionVo {

    private String key;

    private List<String> value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }
}
