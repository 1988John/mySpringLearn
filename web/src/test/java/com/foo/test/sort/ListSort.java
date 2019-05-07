package com.foo.test.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 * @author fooisart
 * @date 11:05 06-05-2019
 */
public class ListSort {
    public static void main(String[] args) {
        Man man1 = new Man(20, "bob");
        Man man2 = new Man(30, "tom");
        Man man3 = new Man(10, "Jerry");

        List<Man> manList = new ArrayList<>();
        manList.add(man1);
        manList.add(man2);
        manList.add(man3);

        System.out.println(JSON.toJSON(manList));

        manList = manList.stream().sorted(Comparator.comparing(Man::getAge).reversed()).collect(Collectors.toList());

        System.out.println(JSON.toJSON(manList));
    }
}
