package com.foo.test.disruptor.hello;

import com.lmax.disruptor.EventHandler;

/*
 * Once we have the event defined we need to create a consumer that will handle these events.
 * In our case all we want to do is print the value out the the console.
 *
 * @author Fooisart
 * @date 16:56 2019/2/2
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override 
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) {
        System.out.println("consume: "+longEvent.getValue());
        System.out.println();
    } 
} 