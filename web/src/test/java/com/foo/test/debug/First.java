package com.foo.test.debug;

import java.util.function.Function;

/**
 * @author fooisart
 * @date 16:50 29-07-2019
 */
public class First {
    public static void main(String[] args) {
        String hello = "hello lambda :";
        Function<String, Void> func = (name) -> {
            System.out.println(hello + name);
            return null;
        };
        func.apply("fooisart");
    }
}
