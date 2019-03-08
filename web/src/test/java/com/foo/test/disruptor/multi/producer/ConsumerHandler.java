package com.foo.test.disruptor.multi.producer;

import java.util.concurrent.atomic.AtomicInteger;

import com.lmax.disruptor.WorkHandler;

public class ConsumerHandler implements WorkHandler<Order> {

    private String consumerId;

    private static AtomicInteger count = new AtomicInteger(0);

    public ConsumerHandler(String consumerId){
        this.consumerId = consumerId;
    }
    @Override
    public void onEvent(Order order) {
        System.out.println("当前消费者："+this.consumerId+"，消费信息："+order.getId());
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
}