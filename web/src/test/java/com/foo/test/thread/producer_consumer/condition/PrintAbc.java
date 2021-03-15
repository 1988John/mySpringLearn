package com.foo.test.thread.producer_consumer.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiangwang
 * @date 2021-03-14 11:43
 */
public class PrintAbc {
    public static void main(String[] args) {
        single();
    }
    /**
     * 线程池：单个线程打印
     *
     * @date 2021/3/14 11:45
     */
    private static void single() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> System.out.println("A"));
            executorService.submit(() -> System.out.println("B"));
            executorService.submit(() -> System.out.println("C"));
        }
        executorService.shutdown();
    }
}
