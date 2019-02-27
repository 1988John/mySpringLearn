package com.foo.test.disruptor.mine;

import com.lmax.disruptor.EventFactory;

/**
 * @author Fooisart
 * @date 15:31 26-02-2019
 */
public class MsgEventFactory implements EventFactory<MsgEvent> {
    @Override
    public MsgEvent newInstance() {
        return new MsgEvent();
    }
}
