package com.foo.service.user.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.foo.service.annotation.Authority;
import com.foo.service.user.OrderService;

/**
 * @author jiangwang3
 * @date 2018/7/30.
 */
@Lazy
@Service
public class OrderServiceImpl implements OrderService, InitializingBean, ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void init() {
        logger.info("执行-PostConstruct-OrderServiceImpl");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            logger.info("根容器-执行-onApplicationEvent-OrderServiceImpl");
        }


    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("执行-InitializingBean-OrderServiceImpl");
    }

    @Override
    @Authority(role = "foo")
    public String getOrder() {
        return null;
    }
}
