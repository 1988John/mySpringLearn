package com.foo.test.service;

import com.foo.service.user.OrderService;
import com.foo.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author jiangwang3
 * @date 2018/10/9.
 */
public class OrderServiceTest extends BaseTest{

    @Resource private OrderService orderService;

    @Test
    public void getOrder() throws Exception {
    }

    @Test
    public void operate() throws Exception {
        String name = "foo1234511";
        orderService.operate(name);
    }

}