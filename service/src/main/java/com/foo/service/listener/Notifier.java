package com.foo.service.listener;

import com.alibaba.fastjson.JSON;
import com.foo.service.transaction.TxUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;


@Component
public class Notifier {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TxUserService txUserService;

    @Async
    @EventListener
    public void onApplicationEvent(MyEvent event) {
        logger.error("EventListener注解，监听事件，开始：{}", new Date());
        txUserService.insert(event.getName());
        logger.error("EventListener注解，监听事件，结束：{}", new Date());
    }

}