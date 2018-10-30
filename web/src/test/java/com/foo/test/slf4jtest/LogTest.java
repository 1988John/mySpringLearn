package com.foo.test.slf4jtest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiangwang3
 * @date 2018/10/18.
 */
public class LogTest {
    @Test
    public void test(){
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("foo is art！");
    }
}
