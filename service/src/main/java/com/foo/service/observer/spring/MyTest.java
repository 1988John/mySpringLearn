package com.foo.service.observer.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/application-database.xml");
        MyPublisher myPublisher =(MyPublisher) context.getBean("myPublisher");
        myPublisher.publishEvent(new MyEvent("1"));
    }
}