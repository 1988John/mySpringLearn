package com.foo.test.designPattern.observer.spring;

import org.springframework.context.ApplicationEvent;


public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
        System.out.println("my Event");
    }
    public void print(){
        System.out.println("hello spring event[MyEvent]");
    }
}