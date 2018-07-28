//package com.foo.test.drools;
//
//import com.foo.dao.aop.Dao;
//import com.foo.domain.user.Product;
//import com.foo.service.drools.SimpleService;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * @author jiangwang
// * 10:59 2018/4/26
// */
//public class SpringDroolsTest {
//
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Test
//    public void testProxy() throws Throwable {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/simple-drools.xml");
//        SimpleService simpleService = (SimpleService)ac.getBean("simpleService");
//
//
//        Product product = new Product();
//        product.setType("gold");
//
//        simpleService.CalculateDiscount(product);
//
//        logger.error("The discount is {}",product.getDiscount());
//    }
//}  