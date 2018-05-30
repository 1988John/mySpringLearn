package com.foo.test.event.event;

import java.util.EventObject;

public class UserEvent extends EventObject {

    public UserEvent(Object source){
        super(source);
    }
}