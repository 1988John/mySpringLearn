package com.foo.service.tx;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.ac = applicationContext;
    }

    /**
     * 获取对应Class的Bean
     *
     * @author jiangwang
     * @date 2022/3/16 8:42 PM
     */
    public static <T> T getBean(Class<T> className) {
        return ac.getBean(className);
    }

}
