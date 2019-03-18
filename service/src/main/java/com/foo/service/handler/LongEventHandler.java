package com.foo.service.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.foo.domain.event.LongEvent;
import com.lmax.disruptor.EventHandler;

/*
 * Once we have the event defined we need to create a consumer that will handle these events.
 * In our case all we want to do is print the value out the the console.
 *
 * @author Fooisart
 * @date 16:56 2019/2/2
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) {
//        System.out.println(Thread.currentThread().getName() + " : consume1: "+sequence+"\n");
        logger.info(Thread.currentThread().getName() + " : consume1: "+sequence+"\n");
    }
}