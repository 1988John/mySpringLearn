package com.foo.test.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示线程池基本操作
 * @author Fooisart
 * Created on 21:46 14-01-2019
 */
public class ScheduleExecutorServiceDemo {
    public static void main(String[] args) {
        //1，线程池创建
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        Executors.newWorkStealingPool();
        //2，新建任务
        Runnable task = () ->
            System.out.println("The schedule task is executing!");
        //3，提交任务到线程池
        service.schedule(task,20, TimeUnit.SECONDS);
        //4，线程池关闭
        service.shutdown();
    }
}