package com.foo.test.base;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K,V> extends LinkedHashMap {

    //缓冲容量
    private int capacity;

    public LRULinkedHashMap(int capacity){
        super(16,0.75f,true);
        this.capacity = capacity;
    }

	//重写removeEldestEntry 返回值代表是否需要删除最老的节点的判断
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        boolean sign = size() > capacity;
        if(sign){
            System.out.println("要删除地是："+eldest);
        }
        return sign;
    }
}