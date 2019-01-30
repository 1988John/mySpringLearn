package com.foo.test.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * @author Fooisart
 * @date 17:39 30-01-2019
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a","b","c","a");

        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));

        List<String> a = list.stream().filter((item) -> item.equals("a")).collect(Collectors.toList());
        System.out.println(JSON.toJSON(a));

        List<String> a1 = list.stream().map((item) -> item.equals("a") ? "x" : item).collect(Collectors.toList());
        System.out.println(JSON.toJSON(a1));

        List<String> collect1 = list.stream().flatMap((item) -> Stream.of(item + item)).collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect1));
    }
}
