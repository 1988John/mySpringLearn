package com.foo.test.disruptor.mine;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @author Fooisart
 * @date 15:32 26-02-2019
 */
public class MsgEventHandler implements EventHandler<MsgEvent>,WorkHandler<MsgEvent> {
    @Override
    public void onEvent(MsgEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("进入MsgEventHandler");
        System.out.println(event.getMsg());
    }

    @Override
    public void onEvent(MsgEvent event) throws Exception {

    }
}
