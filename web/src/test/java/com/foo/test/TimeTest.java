package com.foo.test;


import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author jiangwang
 * @date 2020-12-21 10:58
 */
public class TimeTest {
    public static void main(String[] args) {
        long time = 154800000;
        printTime(time);


        String periodBegin = "19:00:00";
        String periodEnd = "17:00:00";
        long beginValue = 0;
        long endValue = 0;
        //时间段参数转换
        if (StringUtils.isNotEmpty(periodBegin)) {
            beginValue = parseTimePeriod(periodBegin);
            System.out.println("第一次转换beginValue==>" + beginValue);
            printTime(beginValue);
        }
        if (StringUtils.isNotEmpty(periodEnd)) {
            endValue = parseTimePeriod(periodEnd);
            System.out.println("第一次转换endValue==>" + endValue);
            printTime(endValue);
        }

        if (endValue < beginValue) {
            endValue = endValue + TimeUnit.DAYS.toMillis(1L);
            System.out.println("结束小于开始，endValue==>" + endValue);
            printTime(endValue);
        }

    }

    private static void printTime(long time) {
        DateTimeFormatter LONG_DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String print = LONG_DATE_FORMAT.withZoneUTC().print(time);
        System.out.println("time==" + time + "result==" + print);
    }

    private static long parseTimePeriod(String timePeriod) {
        if (StringUtils.isBlank(timePeriod)) {
            return 0L;
        }

        DateTimeFormatter LONG_DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        return LONG_DATE_FORMAT.withZoneUTC().parseDateTime("1970-01-01 " + timePeriod)
                .getMillis();
    }
}
