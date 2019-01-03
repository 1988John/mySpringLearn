package com.foo.test.interview;

/**
 * 要求输出：
 *      a=1,b=2
 *      a=2,b=1
 *
 * @author jiangwang
 * Created on 02-01-2019
 */
public class RefParemater {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println("a=" + a + ",b="+b);
        swap(a, b);
        System.out.println("a=" + a + ",b="+b);
    }
    private static void swap(Integer numa, Integer numb){

    }

}
