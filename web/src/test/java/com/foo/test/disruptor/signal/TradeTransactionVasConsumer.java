package com.foo.test.disruptor.signal;

import com.lmax.disruptor.EventHandler;

public class TradeTransactionVasConsumer implements EventHandler<TradeTransaction> {
  
    @Override  
    public void onEvent(TradeTransaction event, long sequence,  
            boolean endOfBatch) throws Exception {  
        //do something....
        System.out.println("TradeTransactionVasConsumer==>"+event.getId());
    }  
      
}  