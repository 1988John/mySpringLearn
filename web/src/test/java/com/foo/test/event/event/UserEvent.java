package com.foo.test.event.event;

import java.util.EventObject;
/**
 * @author jiangwang
 * @date 21:39 2018/6/1
 */
public class UserEvent extends EventObject {
    public UserEvent(Object source){
        super(source);
    }
}