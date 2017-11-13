package com.github.houbb.paradise.common.util.id.impl;

import com.github.houbb.paradise.common.util.id.Id;

import java.util.UUID;

public class UUIDUtil implements Id {

    private static final UUIDUtil INSTANCE = new UUIDUtil();

    @Override
    public String genId() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成唯一标识
     * @return
     */
    public static String getId() {
        return INSTANCE.genId().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtil.getId());
    }

}
