/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (c) 2012-2018. houbinbin Inc.
 * lombok-ex All rights reserved.
 */

package com.github.houbb.paradise.common.util.id;

import com.github.houbb.paradise.common.util.id.support.Sequence;

import java.util.UUID;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/15 下午3:41  </pre>
 * <pre> Project: lombok-ex  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public final class IdWorker {

    /**
     * 主机和进程的机器码
     */
    private static final Sequence WORKER = new Sequence();

    /**
     * 雪花算法
     * @return id
     */
    public static long nextId() {
        return WORKER.nextId();
    }

    /**
     * 32 为随机数
     * @return 随机数
     */
    public static String uuid32() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
