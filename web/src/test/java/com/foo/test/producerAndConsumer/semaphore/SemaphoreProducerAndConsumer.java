package com.foo.test.producerAndConsumer.semaphore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class SemaphoreProducerAndConsumer {
    private static int PRODUCER_MAX_NUMBER = 3;
    private static int CONSUMER_MAX_NUMBER = 5;
    private static int PRODUCT_SIZE = 7;

    private Semaphore producerSemaphore = new Semaphore(PRODUCT_SIZE);
        private Semaphore consumerSemaphore = new Semaphore(CONSUMER_MAX_NUMBER);

    private List<Integer> productQueue = Collections.synchronizedList(new ArrayList<>());

    class Producer implements Runnable{
        @Override
        public void run() {
            try {
                producerSemaphore.acquire();
                productQueue.add(producerSemaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                producerSemaphore.release();
            }

        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                consumerSemaphore.acquire();
                System.out.println(productQueue.get(0));
                productQueue.remove(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                consumerSemaphore.release();
            }
        }
    }
}
