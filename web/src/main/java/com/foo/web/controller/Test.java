package com.foo.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author jiangwang
 * @date 2020-08-15 18:18
 */
public class Test {
    public static final DateTimeFormatter LONG_DATE_FORMAT = DateTimeFormat
            .forPattern("yyyyMMdd HH:mm:ss");

    public static void main(String[] args) {
        String dateStr = "2020-08-06 12:01:07";

        System.out.println(toLong(dateStr));
    }
    public static long toLong(String dateStr) {
        if (StringUtils.isNotEmpty(dateStr)) {
            try {
                DateTime dateTime = DateTime.parse(dateStr, LONG_DATE_FORMAT);
                if (dateTime != null) {
                    return dateTime.getMillis();
                }
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
}
