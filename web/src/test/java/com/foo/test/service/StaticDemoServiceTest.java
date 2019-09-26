//package com.foo.test.service;
//
//import com.foo.service.aop.StaticDemoService;
//import com.foo.test.BaseTest;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//
//import static org.junit.Assert.*;
//
///**
// * @author jiangwang3
// * @date 2018/7/13.
// */
//public class StaticDemoServiceTest extends BaseTest{
//    @Resource
//    private StaticDemoService staticDemoService;
//
//    @Test
//    public void operateOrder() throws Exception {
//        staticDemoService.operateOrder();
//    }
//
//    @Test
//    public void operateOrderNotStatic() throws Exception {
//        staticDemoService.operateOrderNotStatic();
//    }
//
//}