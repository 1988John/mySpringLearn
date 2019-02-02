package com.foo.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * @author Fooisart
 * @date 11:37 02-02-2019
 */
@Service
public class Foo {

    @PostConstruct
    public void post() {
        System.out.println("i am foo");
    }
}
