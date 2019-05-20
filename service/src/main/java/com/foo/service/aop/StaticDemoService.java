package com.foo.service.aop;

import com.foo.service.annotation.Elapsed;

/**
 * @author jiangwang3
 * @date 2018/7/13.
 */
//@Service
public class StaticDemoService {

    @Elapsed
    public static void operateOrder(){
//    public void operateOrder(){
        System.out.println("abcde");
    }

    @Elapsed
    public void operateOrderNotStatic(){
        System.out.println("absadfsdcde");
    }
}
