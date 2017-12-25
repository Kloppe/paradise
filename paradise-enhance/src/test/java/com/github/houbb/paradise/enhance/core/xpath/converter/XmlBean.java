package com.github.houbb.paradise.enhance.core.xpath.converter;

import com.github.houbb.paradise.enhance.core.xpath.annotation.XPath;

public class XmlBean {

    @XPath("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "XmlBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
