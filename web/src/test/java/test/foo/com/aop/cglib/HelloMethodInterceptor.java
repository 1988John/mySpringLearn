package test.foo.com.aop.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/25.
 */
public class HelloMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before......");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("after......");
        return o1;
    }
}
