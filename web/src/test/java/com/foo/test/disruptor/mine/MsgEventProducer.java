package com.foo.test.disruptor.mine;

import com.lmax.disruptor.RingBuffer;

/**
 * @author Fooisart
 * @date 15:38 26-02-2019
 */
public class MsgEventProducer {
    private RingBuffer<MsgEvent> ringBuffer;

    public MsgEventProducer(RingBuffer<MsgEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void produce(){
        long next = ringBuffer.next();
        try {
            MsgEvent msgEvent = ringBuffer.getPreallocated(next);
            msgEvent.setMsg("abd"+Math.random());
        } finally {
            ringBuffer.publish(next);
        }

    }
}
