package com.foo.service.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void printTime() {
        logger.error("CurrentTime:" + System.currentTimeMillis());
    }
    
}