package com.foo.test.producerAndConsumer.wait;

import com.foo.test.producerAndConsumer.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class WaitProducerAndConsumer implements ProducerAndConsumer{
    private List<String> productQueue = new ArrayList<>();
    private int PRODUCT_MAX_SIZE = 10;

    public void produce(){
        synchronized (productQueue){
            if (productQueue.size() == PRODUCT_MAX_SIZE){
                try {
                    productQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生成==>"+Thread.currentThread().getName());
            productQueue.add(Thread.currentThread().getName());
            productQueue.notifyAll();
        }
    }

    public void consume(){
        synchronized (productQueue){
            if (productQueue.size() <= 0){
                try {
                    productQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费==>"+productQueue.get(0));
            productQueue.remove(0);
            productQueue.notifyAll();
        }
    }

}
