package com.foo.test.disruptor.hello;

import java.nio.ByteBuffer;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
/*
 * With version 3.0 of the Disruptor a richer Lambda-style API was added to help developers by encapsulating this complexity within the Ring Buffer,
 * so post-3.0 the preferred approach for publishing messages is via the Event Publisher/Event Translator portion of the API. E.g.
 *
 * @author Fooisart
 * @date 17:00 2019/2/2
 */
public class LongEventProducerWithTranslator {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    //一个translator可以看做一个事件初始化器，publicEvent方法会调用它
    //填充Event
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
            new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
                public void translateTo(LongEvent event, long sequence, ByteBuffer bb) { 
                    event.setValue(bb.getLong(0)); 
                } 
            };

    public void onData(ByteBuffer bb) {
        ringBuffer.publishEvent(TRANSLATOR, bb); 
    } 
} 