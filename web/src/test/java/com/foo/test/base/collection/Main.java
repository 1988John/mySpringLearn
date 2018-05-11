package com.foo.test.base.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by jiangwang3 on 2018/5/11.
 */
public class Main {
    public static void main(String[] args) {
        Map<String,?> readAbleMap = new HashMap<>();
        putValue((Map<String, Object>)readAbleMap);
//        for (Map.Entry<String, ?> entry : readAbleMap.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println("key:"+key+",value:"+value);
//        }
        Object a = readAbleMap.get("a");
    }
    private static void putValue(Map<String,Object> map){
        map.put("a",2);
    }
}
