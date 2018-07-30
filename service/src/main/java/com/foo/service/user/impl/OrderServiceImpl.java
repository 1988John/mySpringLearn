package com.foo.service.user.impl;

import com.foo.service.annotation.Authority;
import com.foo.service.user.OrderService;
import org.springframework.stereotype.Service;

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
}
