package com.foo.test.disruptor.mine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.dsl.Disruptor;

/**
 * @author Fooisart
 * @date 15:34 26-02-2019
 */
public class MsgEventMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        int bufferSize = 4;
        Disruptor<MsgEvent> disruptor = new Disruptor<>(new MsgEventFactory(), bufferSize, executor);
        disruptor.handleEventsWith(new MsgEventHandler());
        //启动
        disruptor.start();
        new MsgEventProducer(disruptor.getRingBuffer()).produce();
        disruptor.shutdown();
        executor.shutdown();
    }
}
