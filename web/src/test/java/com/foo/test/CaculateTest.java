package com.foo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fooisart
 * @date 15:51 30-11-2019
 */
public class CaculateTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<String> list1 = list;
        for (int i = 0; i < list1.size(); i++) {
            list1.set(i, "aa");
        }
        System.out.println(list);
    }
}
