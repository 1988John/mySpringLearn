package com.foo.test.disruptor.signal;

import java.util.Random;
import java.util.UUID;

import com.lmax.disruptor.EventTranslator;

class TradeTransactionEventTranslator implements EventTranslator<TradeTransaction> {
    private Random random=new Random();
    @Override  
    public void translateTo(TradeTransaction event, long sequence) {
        event.setId(UUID.randomUUID().toString());//简单生成下ID
        event.setPrice(random.nextDouble()*9999);
    }

}