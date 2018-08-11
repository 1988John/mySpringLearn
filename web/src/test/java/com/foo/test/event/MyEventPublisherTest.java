package com.foo.test.event;

import com.foo.service.listener.MyEventPublisher;
import com.foo.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author jiangwang3
 * @date 2018/8/11.
 */
public class MyEventPublisherTest extends BaseTest{

    @Resource
    private MyEventPublisher myEventPublisher;

    @Test
    public void listenerTest(){
        myEventPublisher.pushListener("hsdfasdfads24");
    }

}