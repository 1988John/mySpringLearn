package com.foo.test.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fooisart
 * @date 15:28 12-03-2019
 */
public class MainTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("MainTest.class");
        logger.info("test");
    }
}
