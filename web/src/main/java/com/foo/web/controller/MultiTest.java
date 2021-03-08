package com.foo.web.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwang
 * @date 2021-03-05 19:51
 */
public class MultiTest {
    public static void main(String[] args) {
        String s1 = "12";
//        System.out.println(s1.charAt(0));
        System.out.println(multi("12", "12"));

    }
    public static int multi(String s1, String s2) {
        int len = Integer.max(s1.length(), s2.length());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int num1 = s1.charAt(i);
            int num2 = s2.charAt(i);
            list.add(num1 * num2);
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) * ((int)Math.pow(10, i));
        }
        return result;
    }
}
