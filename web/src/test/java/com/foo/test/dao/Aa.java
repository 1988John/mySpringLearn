package com.foo.test.dao;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author fooisart
 * @date 13:56 31-05-2019
 */
public class Aa {
    private int id;

    private String name;

    private byte[] version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getVersion() {
        return version;
    }

    public void setVersion(byte[] version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Aa{" +
                "id=" + id +
                ", version=" + bytesToLong(version) +
                '}';
    }

    public  long bytesToLong(byte[] input) {
        // 将byte[] 封装为 ByteBuffer
        ByteBuffer buffer = ByteBuffer.wrap(input,0,8);
        return buffer.getLong();
    }
}
