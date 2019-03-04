package com.foo.test.disruptor.test;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.foo.domain.event.LongEvent;
import com.foo.service.handler.LongEventHandler;
import com.foo.service.handler.LongEventHandler2;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class LongEventMain {

    public static void main(String[] args) throws InterruptedException {
        // Executor that will be used to construct new threads for consumers 
        Executor executor = Executors.newFixedThreadPool(10);

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 8;

        // Construct the Disruptor 
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent:: new, bufferSize, executor);

        // Connect the handler 
        disruptor.handleEventsWith(new LongEventHandler(),new LongEventHandler2());

        // Start the Disruptor, starts all threads running 
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing. 
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();


        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            producer.onData(bb);
            Thread.sleep(1000);
        }

//        for (int n = 0;n<5;n++){
//            LongEventProducer producer = new LongEventProducer(ringBuffer);
//
//            ByteBuffer bb = ByteBuffer.allocate(8);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (long l = 0; l<3; l++) {
//                        bb.putLong(0, l);
//                        producer.onData(bb);
//                    }
//                }
//            }).start();
//        }



    }
} 