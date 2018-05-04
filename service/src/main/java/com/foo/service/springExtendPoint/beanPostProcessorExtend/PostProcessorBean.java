package com.foo.service.springExtendPoint.beanPostProcessorExtend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 五月的仓颉 http://www.cnblogs.com/xrq730/p/5721366.html
 */
public class PostProcessorBean implements BeanPostProcessor
{
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("Enter ProcessorBean.postProcessAfterInitialization()\n");
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("Enter ProcessorBean.postProcessBeforeInitialization()");
        return bean;
    }
}