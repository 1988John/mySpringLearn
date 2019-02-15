package com.foo.service.user.impl;

import org.springframework.stereotype.Service;

import com.foo.service.annotation.Authority;
import com.foo.service.user.OrderService;

/**
 * @author jiangwang3
 * @date 2018/7/30.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Override
    @Authority(role = "foo")
    public String getOrder() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(4);
    }
}
