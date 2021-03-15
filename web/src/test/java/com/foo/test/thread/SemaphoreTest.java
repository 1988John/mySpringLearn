package com.foo.test.thread;

import java.util.concurrent.Semaphore;

/**
 * @author jiangwang
 * @date 2021-03-12 17:34
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4, true);
        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "占领了");
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, i + "").start();
        }
    }
}
