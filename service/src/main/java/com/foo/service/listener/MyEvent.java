package com.foo.service.listener;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name ;

    MyEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}