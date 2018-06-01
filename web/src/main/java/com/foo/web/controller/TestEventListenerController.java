package com.foo.web.controller;

import com.foo.service.listener.MyTestEventPubLisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/event")
public class TestEventListenerController {

    @Autowired
    private MyTestEventPubLisher publisher;

    @RequestMapping(value = "/test" )
    public void testPublishEvent(){
        publisher.pushListener("我来了！");
    }
}