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
public class EvolvedFreshListener implements ApplicationListener<ContextRefreshedEvent>{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null){
//            System.out.println();
//            logger.error("进化版====初始化项目。。。。");
//            System.out.println();
        }

    }
}
