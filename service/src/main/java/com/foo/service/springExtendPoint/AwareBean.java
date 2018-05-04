package com.foo.service.springExtendPoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 五月的仓颉 http://www.cnblogs.com/xrq730/p/5721366.html
 */
public class AwareBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware
{
    private String  beanName;
    
    private ApplicationContext applicationContext;
    
    private BeanFactory beanFactory;
    
    public void setBeanName(String beanName)
    {
        System.out.println("Enter AwareBean.setBeanName(), beanName = " + beanName + "\n");
        this.beanName = beanName;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println("Enter AwareBean.setApplicationContext(), applicationContext = " + applicationContext + "\n");
        this.applicationContext = applicationContext;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        System.out.println("Enter AwareBean.setBeanFactory(), beanfactory = " + beanFactory + "\n");
        this.beanFactory = beanFactory;
    }
}