package com.foo.test.base;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fooisart
 * @date 09:41 24-07-2019
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        Integer a = hashMap.get("a");
        System.out.println(a);

        Hashtable<String, Integer> hashTable = new Hashtable<>();
        hashTable.put("bb", 2);
        Integer bb = hashTable.get("bb");
        System.out.println(bb);

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("cc", 3);
        concurrentHashMap.mappingCount();
        concurrentHashMap.remove("cc");
        Integer cc = concurrentHashMap.get("cc");
        concurrentHashMap.size();
        System.out.println(cc);

        int temp = 0;
        int i = 9991;
        if ((temp = i) == 0) {

        } else {
            System.out.println(temp);
        }
    }

}
