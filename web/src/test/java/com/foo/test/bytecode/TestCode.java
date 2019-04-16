package com.foo.test.bytecode;

public class TestCode {
    public int foo() {
        int x;
        try {
            x = 5;
            return x;
        } catch (Exception e) {
            x = 20;
            return x;
        } finally {
            x = 30;
        }
    }
}