package com.foo.test.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Fooisart
 * @date 16:12 02-03-2019
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("runing my task!");
            }
        });
        service.shutdown();
    }
}
