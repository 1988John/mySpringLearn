package com.foo.test.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        List<Future<Integer>> results = new ArrayList<Future<Integer>>();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 30; i ++){
            MyTask thisTask = new MyTask(i);
            results.add(executor.submit(thisTask));
        }
        executor.shutdown();

        System.out.println("Successfully distribute all the tasks!");
        System.out.println("Waiting for the results!");
        for (Future<Integer> result: results){
            try {
                System.out.println("Result: " + result.get(random.nextInt(500) , TimeUnit.MILLISECONDS));
            } catch (Exception e) {
                System.out.println("Result Timeout, drop result of this task");
            }
        }
    }
}