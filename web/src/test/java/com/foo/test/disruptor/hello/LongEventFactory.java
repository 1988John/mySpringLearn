package com.foo.test.disruptor.hello;

import com.lmax.disruptor.EventFactory;

/*
 * In order to allow the Disruptor to preallocate these events for us,
 * we need to an EventFactory that will perform the construction
 *
 * @author Fooisart
 * @date 16:51 2019/2/2
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override 
    public LongEvent newInstance() {
        return new LongEvent(); 
    } 
} 