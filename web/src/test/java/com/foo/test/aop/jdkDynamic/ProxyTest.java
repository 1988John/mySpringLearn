package com.foo.test.aop.jdkDynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 动态代理测试类 
 * @author zyb 
 * @since 2012-8-9 
 * 
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public class ProxyTest {  

//    @Test
//    public void testProxy() throws Throwable {
//        // 实例化目标对象
//        UserServiceImpl userService = new UserServiceImpl();
//
//        // 实例化InvocationHandler
//        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
//
//        // 根据目标对象生成代理对象
//        UserServiceImpl proxy = (UserServiceImpl) invocationHandler.getProxy();
//
//        // 调用代理对象的方法
//        proxy.add();
//
//    }

    public static void main(String[] args) {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();

        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        invocationHandler.setTarget(userService);

        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.add();
    }
}  