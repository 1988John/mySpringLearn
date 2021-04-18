package com.foo.test.base.execute;

/**
 * @author jiangwang
 * @date 2021-04-13 14:53
 */
public class B extends A {
    static {
        System.out.println("B constructor before static");
    }
    public B (){
        System.out.println("B constructor");
    }

    public B(int b){
        System.out.println("B constructor ,num:"+b);
    }

    static {
        System.out.println("B constructor after static");
    }
}
