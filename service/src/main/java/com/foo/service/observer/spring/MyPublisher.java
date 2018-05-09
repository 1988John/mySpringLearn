package com.foo.service.observer.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

public class MyPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public void publishEvent(ApplicationEvent event){
        System.out.println("into My Publisher's method");
        applicationContext.publishEvent(event);
    }
}