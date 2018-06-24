package com.github.houbb.paradise.common.dto;


import com.github.houbb.paradise.common.annotation.dev.Beta;
import com.github.houbb.paradise.common.support.builder.impl.ToStringBuilder;

import java.io.Serializable;

/**
 * 通用数据传入类
 * @author bbhou
 * @version 1.1.0
 */
@Beta
public class CommonDto implements Serializable {

    private static final long serialVersionUID = 599516317416740653L;

    @Override
    public String toString() {
        try {
            return ToStringBuilder.reflectionToString(this);
        } catch (Exception var2) {
            //ignore error, use super.toString() instead.
            return super.toString();
        }
    }

}
