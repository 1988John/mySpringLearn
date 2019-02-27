package com.foo.test.disruptor.signal;

import com.foo.test.disruptor.signal.TradeTransaction;
import com.lmax.disruptor.EventHandler;

public class TradeTransactionJMSNotifyHandler implements EventHandler<TradeTransaction> {
  
    @Override  
    public void onEvent(TradeTransaction event, long sequence,  
            boolean endOfBatch) throws Exception {  
        //do send jms message
        System.out.println("do send jms message ==>"+event.getId());
    }  
}  