package com.foo.service.disruptor;

import java.util.concurrent.ThreadFactory;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.foo.domain.event.LongEvent;
import com.foo.service.handler.LongEventHandler;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * @author Fooisart
 * @date 14:22 28-02-2019
 */
@Service
public class DisruptorService implements ApplicationListener<ContextRefreshedEvent> {
    private volatile boolean initialized = false;
    private static final int BUFFER_SIZE = 4;
    RingBuffer<LongEvent> ringBuffer;

    @Override
    public synchronized void onApplicationEvent(ContextRefreshedEvent event) {
        if (!initialized) {
            ThreadFactory threadFactory = Thread::new;
            WaitStrategy waitStrategy = new BlockingWaitStrategy();

            Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new,BUFFER_SIZE,threadFactory,
                    ProducerType.SINGLE,waitStrategy);
            disruptor.handleEventsWith(new LongEventHandler());
            disruptor.start();
            ringBuffer = disruptor.getRingBuffer();
            //保证初始化一次
            initialized = true;
        }
    }
    public void produceEvent(Long value){
        long sequence = ringBuffer.next();
        try {
            LongEvent event = ringBuffer.get(sequence);
            event.setValue(value);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
