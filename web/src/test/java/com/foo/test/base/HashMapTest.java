package com.foo.test.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiangwang
 * @date 2021-02-21 20:54
 */
public class HashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
        map1.put("1", "1");
        map1.put("2", "2");
        map1.size();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1,2);
        Integer t2 = treeMap.get(1);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);

        Map<String, String> linkedHashMap = new LinkedHashMap<>(9);

        linkedHashMap.put("化学","93");
        linkedHashMap.put("数学","98");
        linkedHashMap.put("生物","92");
        linkedHashMap.put("英语","97");
        linkedHashMap.put("物理","94");
        linkedHashMap.put("历史","96");
        linkedHashMap.put("语文","99");
        linkedHashMap.put("地理","95");

        for (Map.Entry entry : linkedHashMap.entrySet())
        {
            System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
        }


        LRULinkedHashMap<String,Integer> map = new LRULinkedHashMap<>(6);
        map.put("111",111);
        map.put("222",222);
        map.put("333",333);
        map.put("444",444);
        map.put("555",555);
        map.get("333");

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println(entry.getKey()+ "=="+ entry.getValue());

        }

    }
}
