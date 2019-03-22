package com.foo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Fooisart
 * @date 16:56 19-03-2019
 */
public class Test {
    public static void main(String[] args) {
        Map<String,List<String>> map = Maps.newHashMap();
        List<String> ids = map.computeIfAbsent("aa", list -> new ArrayList<>());
        List<String> stringList = map.get("aa");
        System.out.println(map.get("aa"));
        System.out.println(ids);
    }
}
