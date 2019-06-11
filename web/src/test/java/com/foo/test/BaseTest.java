package com.foo.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jiangwang3
 * @date 2018/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public abstract class BaseTest {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        System.out.println("end=" + new Date().getTime());
        long beginTime = new Date().getTime() - 7 * 86400000L;
        System.out.println("begin=" + beginTime);
        System.out.println(getTableName(beginTime));
    }

    private static String getTableName(long classifyTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        return dateFormat.format(new Date(classifyTime));
    }

}
