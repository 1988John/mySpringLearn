package test.foo.com.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public class CglibProxyTest {

    @Test
    public void testProxy() throws Throwable {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);//继承被代理类
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloService helloService = (HelloService)enhancer.create();//生成代理类对象
        helloService.sayHello();
          
    }  
}  