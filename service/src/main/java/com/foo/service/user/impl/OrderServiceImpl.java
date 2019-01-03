package com.foo.service.user.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.foo.service.annotation.Authority;
import com.foo.service.user.OrderService;

/**
 * @author jiangwang3
 * @date 2018/7/30.
 */
@Lazy
@Service
public class OrderServiceImpl implements OrderService{

    @Override
    @Authority(role = "foo")
    public String getOrder() {
        return null;
    }
}
