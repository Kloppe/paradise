package com.github.houbb.paradise.common.vo;

/**
 *
 * @author houbinbin
 */
public class OptionVo {

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OptionVo{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
