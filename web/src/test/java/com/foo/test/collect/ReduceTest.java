package com.foo.test.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author fooisart
 * @date 18:40 21-05-2019
 */
public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);
        Integer integer = list.stream().reduce((sum, item) -> sum + item).orElse(0);
        System.out.println(integer);
    }
}
