package com.foo.test.java8;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jiangwang3
 * @date 2018/8/21.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Stream.generate(() -> 2).limit(10).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
    }
}
