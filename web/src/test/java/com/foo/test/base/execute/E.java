package com.foo.test.base.execute;

public class E {
    public static void main(String[] args) {
        System.out.println("E main");
        A a = new B();
        System.out.println("-------------AB可爱分割线-------------");
        B b = new B();

        System.out.println("\n---------小可爱分割线-----------\n");

        A a1 = new B(1);
        System.out.println("-------------AB可爱分割线-------------");
        B b1 = new B(2);
    }
}