package com.foo.service.springExtendPoint;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 不建议使用InitializingBean和DisposableBean的接口，因为它将你的代码紧耦合到 Spring 代码中。
 * 一个更好的做法应该是在bean的配置文件属性指定 init-method和destroy-method。
 * @author jiangwang
 * 10:18 2018/5/4
 */
public class LifecycleBean implements InitializingBean, DisposableBean
{
    @SuppressWarnings("unused")
    private String    lifeCycleBeanName;
    
    public void setLifeCycleBeanName(String lifeCycleBeanName)
    {
        System.out.println("Enter LifecycleBean.setLifeCycleBeanName(), lifeCycleBeanName = " + lifeCycleBeanName);
        this.lifeCycleBeanName = lifeCycleBeanName;
    }

    @Override
    public void destroy() throws Exception
    {
        System.out.println("Enter LifecycleBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("Enter LifecycleBean.afterPropertiesSet()");
    }
    
    public void beanStart()
    {
        System.out.println("Enter LifecycleBean.beanStart()");
    }
    
    public void beanEnd()
    {
        System.out.println("Enter LifecycleBean.beanEnd()");
    }
}