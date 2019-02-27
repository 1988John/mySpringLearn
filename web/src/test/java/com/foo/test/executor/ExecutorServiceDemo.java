package com.foo.test.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 演示线程池基本操作
 * @author Fooisart
 * Created on 2018-12-11
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        //1，线程池创建
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Executors.newWorkStealingPool();
        //2，新建任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("The real task is executing!");
            }
        };
        //3，提交任务到线程池
        executor.submit(task);
        //4，线程池关闭
        executor.shutdown();
    }
}