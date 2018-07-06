package com.foo.test.event.listener;

import com.foo.test.event.event.UserEvent;

import java.util.EventListener;
/**
 * @author jiangwang
 * @date 21:37 2018/6/1
 */
public interface UserListener extends EventListener {
    void onRegister(UserEvent event);
}