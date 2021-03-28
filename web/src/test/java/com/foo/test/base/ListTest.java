package com.foo.test.base;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jiangwang
 * @date 2021-03-23 13:49
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.get(1);
    }
}
