package com.github.houbb.paradise.common.dto;

import com.github.houbb.paradise.common.support.impl.ToStringBuilder;

import java.io.Serializable;

/**
 * 通用数据传入类
 * @author bbhou
 * @version 1.1.0
 */
public class CommonDto implements Serializable {

    @Override
    public String toString() {
        try {
            return ToStringBuilder.reflectionToString(this);
        } catch (Exception var2) {
            var2.printStackTrace();
            return super.toString();
        }
    }

}
