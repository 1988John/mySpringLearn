package com.foo.test;

import java.nio.ByteBuffer;

import com.alibaba.fastjson.JSON;

/**
 * @author fooisart
 * @date 15:48 13-06-2019
 */
public class T {
    public static void main(String[] args) throws Exception{
        byte[] bytes = {0, 0, 0, 0, 0, 85, 62, -123};
        Object o = bytes;
        Long version = ByteBuffer.wrap((byte[]) o, 0, 8).getLong();
        System.out.println(version);

        throw new Exception();
    }
}
