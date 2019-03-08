package com.foo.test.disruptor.workpool;

import java.util.UUID;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class TradeHandler implements WorkHandler<Trade> {
      
    @Override
    public void onEvent(Trade event) throws Exception {  
        event.setId(UUID.randomUUID().toString());
        System.out.println(event.getId());  
    }  
}