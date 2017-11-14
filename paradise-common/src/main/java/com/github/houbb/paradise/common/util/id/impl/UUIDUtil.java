package com.github.houbb.paradise.common.util.id.impl;

import com.github.houbb.paradise.common.util.id.Id;

import java.util.UUID;

/**
 * UUID 工具类
 * @author bbhou
 * @version 1.1.0
 */
public class UUIDUtil implements Id {

    private static final UUIDUtil INSTANCE = new UUIDUtil();

    @Override
    public String genId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成唯一标识
     * @return  唯一标识
     */
    public static String getId() {
        return INSTANCE.genId();
    }

}
