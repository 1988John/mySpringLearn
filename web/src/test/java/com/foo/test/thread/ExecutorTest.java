package com.foo.test.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import com.foo.test.thread.model.EventLoggingTask;
import com.foo.test.thread.model.FactorialTask;

/**
 * @author jiangwang
 * @date 2021-02-22 09:54
 */
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.submit(new EventLoggingTask());

        String str = "abc";
        Future<String> runnableFuture = executorService.submit(new EventLoggingTask(), str);
//        System.out.println(runnableFuture.get());
        runnableFuture.cancel(false);
        System.out.println("取消-" + runnableFuture.isCancelled());

        Future<Integer> future = executorService.submit(new FactorialTask(5));
        System.out.println(future.get());

//        executorService.execute();

//        executorService.submit()
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;
        executorService.shutdown();


    }
}
