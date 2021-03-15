package com.foo.test.aop;

/**
 * @author jiangwang
 * @date 2021-03-14 15:10
 */
public class HelloImpl implements Hello{
    @Override
    public void hi(String msg) {
        System.out.println("hello-" + msg);
    }
}
