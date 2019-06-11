package com.foo.test.service;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.foo.test.BaseTest;

/**
 * @author jiangwang3
 * @date 2018/7/13.
 */
public class StaticDemoServiceTest extends BaseTest{
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("a","b");
        map.put("c","d");
        map.put("d", new Date());
        adjustToMysqlData(map);
        System.out.println(map);

        List<String> parameters = new ArrayList<>();
        List<String> values = new ArrayList<>();
        map.forEach((key,value) -> buildParameters(parameters, values, value.toString()));
        System.out.println(parameters);
        System.out.println(values);
    }

    private static boolean buildParameters(List<String> parameters, List<String> values, String parameter) {
        System.out.println(parameter);
        parameters.add(LOWER_CAMEL.to(LOWER_UNDERSCORE, parameter));
        values.add(":" + parameter);
        return true;
    }

    private static void adjustToMysqlData(Map<String, Object> map) {
        map.forEach((key, value) -> {
            //Date ==> Long
            if (value instanceof Date) {
                map.put(key,  ((Date) value).getTime());
            }

        });
    }
}