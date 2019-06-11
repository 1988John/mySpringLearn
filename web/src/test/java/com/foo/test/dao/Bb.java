package com.foo.test.dao;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author fooisart
 * @date 13:56 31-05-2019
 */
public class Bb {
    private int id;

    private String name;

    private long version;

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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
