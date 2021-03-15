package com.foo.test.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jiangwang
 * @date 2021-02-22 09:54
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(1);
//        executorService.submit()
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;

        BlockingQueue<Runnable> queue = tpe.getQueue();
        tpe.getActiveCount();
        tpe.getCompletedTaskCount();


        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
//        executorService.submit();
//        executorService.execute();

    }
}
