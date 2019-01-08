package com.foo.test.base.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * @author jiangwang
 * Created on 07-01-2019
 */
public class GroupingBy {
    public static void main(String[] args) {
        List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple", 6),
                new Fruit("apple", 6),
                new Fruit("banana", 7), new Fruit("banana", 8),
                new Fruit("banana", 9), new Fruit("grape",8));

        Map<String, List<Fruit>> groupMap =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName));

        System.out.println(groupMap);

    }
}
