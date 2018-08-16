package com.github.houbb.paradise.common.threadpool.core.impl;

import com.github.houbb.paradise.common.threadpool.core.TaskExecute;
import com.github.houbb.paradise.common.util.DateUtil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
* TaskExecuteImpl Tester.
*
* @author houbinbin
* @since 08/16/2018
* @version 1.0
*/
public class TaskExecuteImplTest {

    /**
    *
    * Method: execute(Collection<Callable<T>> tasks)
    *
    */
    @Test
    public void executeEmptyTest() throws Exception {
        TaskExecute taskExecute = new TaskExecuteImpl();
        List collection = taskExecute.execute(Collections.emptyList());
        Assert.assertTrue(collection.isEmpty());
    }

    /**
     *
     * Method: execute(Collection<Callable<T>> tasks)
     *
     */
    @Test
    public void executeOneTest() throws Exception {
        TaskExecute<String> taskExecute = new TaskExecuteImpl<>();
        List<String> collection = taskExecute.execute(Collections.singletonList(new MyTask("one")));
        Assert.assertEquals("callable-one", collection.iterator().next());
    }

    /**
     *
     * Method: execute(Collection<Callable<T>> tasks)
     *
     */
    @Test
    public void executeTenTest() throws Exception {
        TaskExecute<String> taskExecute = new TaskExecuteImpl<>();

        Collection<Callable<String>> collections = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            collections.add(new MyTask(String.valueOf(i)));
        }
        System.out.println(DateUtil.getSimpleDateStr());

        List<String> results = taskExecute.execute(collections);
        for(String string : results) {
            System.out.println(string);
        }
        System.out.println(DateUtil.getSimpleDateStr());
    }

    class MyTask implements Callable<String> {

        private final String taskName;

        public MyTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            return "callable-"+taskName;
        }

    }
}
