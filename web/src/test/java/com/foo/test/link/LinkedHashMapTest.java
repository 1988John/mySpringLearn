package com.foo.test.link;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fooisart
 * @date 20:57 21-08-2019
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(3,11);
        map.put(1,12);
        map.put(5,23);
        map.put(2,22);

        map.put(3, 26);
        map.get(5);

        map.size();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
