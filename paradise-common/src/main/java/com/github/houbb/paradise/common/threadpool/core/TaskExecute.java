/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.threadpool.core;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p> 线程执行接口 </p>
 *
 * <pre> Created: 2018/8/16 下午9:50  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public interface TaskExecute<T> {

    /**
     * 执行任务
     * @param tasks 任务列表
     * @return 任务的执行结果
     * @throws Exception if any
     */
    List<T> execute(Collection<Callable<T>> tasks) throws Exception;

}
