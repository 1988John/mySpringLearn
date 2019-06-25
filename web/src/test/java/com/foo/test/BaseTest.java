package com.foo.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.base.Splitter;

/**
 * @author jiangwang3
 * @date 2018/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public abstract class BaseTest {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String args[])
    {
        boolean range = isCurrentTimeBetweenVipIvrTimeRange();
        System.out.println(range);
    }
    protected static boolean isCurrentTimeBetweenVipIvrTimeRange() {
        String timeStr = "10:00-22:00";
        List<String> range = Splitter.on("-").splitToList(timeStr);
        int start = getMinute(range.get(0));
        int end = getMinute(range.get(1));

        int nowMinute = DateTime.now().getMinuteOfDay();
        return (nowMinute >= start && nowMinute <= end);
    }
    private static int getMinute(String str) {
        List<String> timeList = Splitter.on(":").splitToList(str);
        int hour = NumberUtils.toInt(timeList.get(0), 0);
        int minute = NumberUtils.toInt(timeList.get(1), 0);
        return (int) TimeUnit.HOURS.toMinutes(hour) + minute;
    }

}
