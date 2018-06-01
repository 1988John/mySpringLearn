package com.foo.test;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

/**
 * @author jiangwang3
 * @date 2018/5/24.
 */
public class TestT {

    public <T> T getValue() {
        return (T) new Object();
    }

    public static void main(String[] args) {
        TestT testT = new TestT();
        Integer value = testT.<Integer>getValue();
        System.out.println(value);

        ImmutableMap.<String, String>builder();
    }
}
