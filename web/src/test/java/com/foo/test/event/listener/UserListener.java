package com.foo.test.event.listener;

import com.foo.test.event.event.UserEvent;

import java.util.EventListener;

public interface UserListener extends EventListener {

    public void onRegister(UserEvent event);

}