package com.foo.test.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.util.Util;

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
        System.out.println(Thread.currentThread().getName() + " : consume: "+longEvent.getValue()+"\n");
    }

    public static void main(String[] args) {
        int indexShift = Util.log2(8);
        System.out.println(indexShift);

        System.out.println(8 >>> indexShift);
    }
}