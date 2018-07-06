package com.foo.service.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void printTimeBefore() {
        System.out.println();
        logger.error("before-currentTime:" + System.currentTimeMillis());
    }

    public void printTimeAfter() {
        logger.error("after-currentTime:" + System.currentTimeMillis());
        System.out.println();
    }
    
}