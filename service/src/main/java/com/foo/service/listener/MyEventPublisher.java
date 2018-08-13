package com.foo.service.listener;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class MyEventPublisher {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ApplicationContext applicationContext;

    // 事件发布方法
    @Transactional
    public void pushListener(String msg) {
        logger.error("发布事件，开始：{}", new Date());
        applicationContext.publishEvent(new MyEvent(this, msg));
        logger.error("发布事件，结束：{}", new Date());

    }

}