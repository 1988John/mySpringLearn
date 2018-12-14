package com.foo.test.lambda;

@FunctionalInterface
public interface Converter<F,T> {
    T converter(F f);
}