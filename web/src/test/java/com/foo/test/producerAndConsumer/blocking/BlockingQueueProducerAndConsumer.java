package com.foo.test.producerAndConsumer.blocking;

import com.foo.test.producerAndConsumer.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class BlockingQueueProducerAndConsumer implements ProducerAndConsumer {
    private int PRODUCT_MAX_SIZE = 10;

    private BlockingQueue<String> productQueue = new LinkedBlockingQueue<>(PRODUCT_MAX_SIZE);

    public void produce() {
        if (productQueue.size() == PRODUCT_MAX_SIZE) {
            System.out.println("队列已经满了。。。。。");
        }

        System.out.println("生成==>" + Thread.currentThread().getName());

        try {
            productQueue.put(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {
        if (productQueue.size() <= 0) {
            System.out.println("队列为空。。。。");
        }
        System.out.println("消费==>" + productQueue.peek());
        try {
            productQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
