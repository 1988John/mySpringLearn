package com.foo.service.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author jiangwang3
 * @date 2018/6/1.
 */
@Component
public class FreshListener implements ApplicationListener<ContextRefreshedEvent>{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println();
        //业务代码
        logger.error("将有权限人员放入缓存。。。。");
        System.out.println();
    }
}
