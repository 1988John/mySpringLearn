package com.foo.test.disruptor.signal;

import java.util.UUID;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class TradeTransactionInDBHandler implements EventHandler<TradeTransaction>,WorkHandler<TradeTransaction> {
  
    @Override  
    public void onEvent(TradeTransaction event, long sequence,  
            boolean endOfBatch) throws Exception {  
        this.onEvent(event);  
    }  
  
    @Override  
    public void onEvent(TradeTransaction event) throws Exception {  
        //这里做具体的消费逻辑  
        System.out.println("InDBHandler==> " + event.getId());
    }  
}  
