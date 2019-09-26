package com.foo.test.drools;

import com.foo.domain.user.Product;
import com.foo.service.drools.ProductServiceImpl;
import com.foo.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author jiangwang3
 * @date 2018/7/27.
 */
public class DroolsTest extends BaseTest{

    @Resource
    private ProductServiceImpl productServiceImpl;

    @Test
    public void testStart(){

        Product product = new Product();
        product.setType("gold");

        productServiceImpl.CalculateDiscount(product);

        logger.error("The discount is {}",product.getDiscount());
    }

}
