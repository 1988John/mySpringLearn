package com.foo.test.aop.aspect;

import com.foo.service.user.UserService;
import com.foo.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author jiangwang3
 * @date 2018/7/4.
 */
public class TimeHandlerAspect extends BaseTest{

    @Resource
    private UserService userService;

    @Test
    public void testProxy() throws Throwable {
//        userService.addUser();
    }
}
