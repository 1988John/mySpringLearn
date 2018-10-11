package com.foo.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.foo.domain.user.User;
import com.foo.service.annotation.Authority;
import com.foo.service.user.OrderService;
import com.foo.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jiangwang3
 * @date 2018/7/30.
 */
@Service
public class OrderServiceImpl implements OrderService{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource private UserService userService;

    @Override
    @Authority(role = "foo")
    public String getOrder() {
        return null;
    }

    @Override
    @Transactional
    public boolean operate(String name) {
        userService.insert(name);

//        throw new RuntimeException();

        User user = userService.queryByName(name);
        logger.error("搜索结果==》{}",JSON.toJSONString(user));

        return false;
    }
}
