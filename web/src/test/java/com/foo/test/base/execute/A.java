package com.foo.test.base.execute;

/**
 * @author jiangwang
 * @date 2021-04-13 14:52
 */
public class A {
    static {
        System.out.println("A constructor before static");
    }

    public A(){
        System.out.println("A constructor");
    }


    public A(int a){
        System.out.println("A constructor ,num:"+a);
    }

    static {
        System.out.println("A constructor after static");
    }
}
