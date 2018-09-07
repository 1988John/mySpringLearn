package com.foo.test.producerAndConsumer.wait;

import com.foo.test.producerAndConsumer.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class WaitLockProducerAndConsumer implements ProducerAndConsumer{
    private List<String> productQueue = new ArrayList<>();
    private int PRODUCT_MAX_SIZE = 10;

    private final Lock lock = new ReentrantLock();
//    private final Lock consumerLock = new ReentrantLock();

    private final Condition empty = lock.newCondition();
    private final Condition full = lock.newCondition();

    public void produce(){
        try {
            lock.lock();
            if (productQueue.size() == PRODUCT_MAX_SIZE){
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生成==>"+Thread.currentThread().getName());
            productQueue.add(Thread.currentThread().getName());
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume(){
        try {
            lock.lock();
            if (productQueue.size() <= 0){
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费==>"+productQueue.get(0));
            productQueue.remove(0);
            full.signal();
        } finally {
            lock.unlock();
        }
    }

}
