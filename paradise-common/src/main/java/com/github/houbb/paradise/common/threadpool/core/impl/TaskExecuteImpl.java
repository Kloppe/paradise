/*
 * Copyright (c)  2018. houbinbin Inc.
 * paradise All rights reserved.
 */

package com.github.houbb.paradise.common.threadpool.core.impl;

import com.github.houbb.paradise.common.threadpool.core.TaskExecute;
import com.github.houbb.paradise.common.threadpool.util.ThreadUtil;
import com.github.houbb.paradise.common.util.CollectionUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p> 线程执行实现 </p>
 *
 * <pre> Created: 2018/8/16 下午9:52  </pre>
 * <pre> Project: paradise  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class TaskExecuteImpl<T> implements TaskExecute<T> {

    /**
     * 待执行的任务列表
     */
    private final List<Future<T>> futureTasks = new ArrayList<>();

    /**
     * 任务执行服务
     */
    private ExecutorService executorService;

    @Override
    public List<T> execute(Collection<Callable<T>> tasks) throws Exception {

        if(CollectionUtil.isEmpty(tasks)) {
            return Collections.emptyList();
        }

        if(tasks.size() <= 1) {
            T result = tasks.iterator().next().call();
            return Collections.singletonList(result);
        }

        int bestThreadNum = ThreadUtil.bestThreadNum();
        executorService = Executors.newFixedThreadPool(bestThreadNum);

        for(Callable<T> callable : tasks) {
            Future<T> tFuture = executorService.submit(callable);
            futureTasks.add(tFuture);
        }

        return getTaskResult();
    }


    /**
     * 获取返回结果
     * @return 执行结果
     * @throws ExecutionException if any
     * @throws InterruptedException if any
     */
    private List<T> getTaskResult() throws ExecutionException, InterruptedException {
        List<T> resultList = new ArrayList<>();

        for(Future<T> tFuture : futureTasks) {
            T result = tFuture.get();
            resultList.add(result);
        }
        executorService.shutdown();
        return resultList;
    }

}
