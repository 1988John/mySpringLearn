package com.foo.service.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    // 事件发布方法
    public void pushListener(String msg) {
        applicationContext.publishEvent(new MyEvent(this, msg));
    }

}