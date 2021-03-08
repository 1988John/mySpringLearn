package com.foo.test.thread.producer_consumer.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangwang
 * @date 2021-03-03 18:47
 */
public class ResourceCondition {
    private Lock lock = new ReentrantLock();
    private Condition consumeCondition = lock.newCondition();
    private Condition produceCondition = lock.newCondition();
    private int number = 0;

    public void increase() {
        lock.lock();
        try {
            while (number > 0) {
                produceCondition.await();
            }
            number ++;
            System.out.println("生产后" + Thread.currentThread() + ":" + number);
            consumeCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrease() {
        lock.lock();
        try {
            while (number == 0) {
                consumeCondition.await();
            }
            number --;
            System.out.println("消费后" + Thread.currentThread() + ":" + number);
            produceCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ResourceCondition resource = new ResourceCondition();
        new Thread(new ProduceCondition(resource)).start();
        new Thread(new ProduceCondition(resource)).start();
        new Thread(new ConsumeCondition(resource)).start();
        new Thread(new ConsumeCondition(resource)).start();
        new Thread(new ConsumeCondition(resource)).start();

    }
}
