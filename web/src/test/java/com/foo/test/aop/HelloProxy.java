package com.foo.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jiangwang
 * @date 2021-03-14 15:10
 */
public class HelloProxy implements InvocationHandler {
    private Object proxied;

    public HelloProxy(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("hello proxy");
        return method.invoke(proxied, args);
    }

    public static void main(String[] args) {
        Hello hello = (Hello)Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class},
                new HelloProxy(new HelloImpl()));
        System.out.println(hello.getClass());
        hello.hi("world");
    }
}
