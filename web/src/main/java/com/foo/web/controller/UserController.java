package com.foo.web.controller;

import com.foo.domain.user.User;
import com.foo.service.annotation.Authority;
import com.foo.service.annotation.PrintTime;
import com.foo.service.user.OrderService;
import com.foo.service.user.UserService;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jiangwang
 * @date  2018/5/14
 */
@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/controllerAspect", method={RequestMethod.GET})
    @PrintTime
    public  String name(@NotBlank(message = "name null") String name){
//        publisher.pushListener("我来了！");
        logger.info("Controller层----测试切面");
        return "controllerAspect";
    }

    /**
     * 此处之前返回Integer 报错。原因：将对象转为json，spring默认使用jackson。
     * 解决方法：添加jackson包即可
     * @author jiangwang
     * 21:52 2018/4/23
     */
//    @RequestMapping(value = "/getCount", method={RequestMethod.GET})
//    public  Integer getLeastLeasePrice(){
//
//        return userService.selectCount();
//    }

    @RequestMapping(value = "/showUser", method={RequestMethod.GET})
    public String showUser(User user){
        orderService.getOrder();
        return user.toString();
    }

    @RequestMapping(value = "/sleep", method={RequestMethod.GET})
    public String sleep(int time,boolean interrupt){
        try {
            if (interrupt){
                Thread.interrupted();
            }
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "abc";
    }


}
