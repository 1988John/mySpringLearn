package com.foo.service.aop;

import org.springframework.stereotype.Service;

import com.foo.service.annotation.PrintTime;

/**
 * @author jiangwang3
 * @date 2018/7/13.
 */
@Service
public class StaticDemoService {

    @PrintTime
    public static void operateOrder(){
//    public void operateOrder(){
        System.out.println("abcde");
    }

    @PrintTime
    public void operateOrderNotStatic(){
        System.out.println("absadfsdcde");
    }
}
