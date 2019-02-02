package com.foo.test.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Fooisart
 * @date 11:20 02-02-2019
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/resources/spring/spring-test");

    }
}
