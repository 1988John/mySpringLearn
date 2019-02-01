package com.foo.test.log4j2;

import org.junit.Test;

import com.foo.test.BaseTest;

/**
 * @author Fooisart
 * @date 14:03 31-01-2019
 */
public class StartTest extends BaseTest {
    @Test
    public void test(){
        logger.info("abc");
    }
}
