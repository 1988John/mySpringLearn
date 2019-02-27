package com.foo.test.disruptor.test;


import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件事件
     * 它的参数会通过事件传递给消费者
     *
     * @param bb data
     */
    public void onData(ByteBuffer bb) {
        //可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
        long sequence = ringBuffer.next();
        try {
            //用上面的索引取出一个空的事件用于填充
            LongEvent event = ringBuffer.getPreallocated(sequence);// for the sequence
            event.setValue(bb.getLong(0));
        } finally {
            //发布事件，写入ringbuffer
            System.out.println(Thread.currentThread().getName() + "生产序列==>"+sequence);
            ringBuffer.publish(sequence);
        }
    }

}