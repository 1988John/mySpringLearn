package com.foo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foo.domain.user.User;
import com.foo.service.annotation.PrintTime;
import com.foo.service.user.OrderService;

/**
 * @author jiangwang
 * @date  2018/5/14
 */
//@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource private OrderService orderService;

    @RequestMapping(value = "/value", method={RequestMethod.GET})
    public  String value(String myValue){
        return myValue;
    }

    @RequestMapping(value = "/domain", method={RequestMethod.GET})
    public  String domain(User user){
        System.out.println();
        return user.toString();
    }

    @RequestMapping(value = "/list0", method={RequestMethod.GET})
    public  String list0(List<Long> contentIds){
        return contentIds.toString();
    }

    @RequestMapping(value = "/list1", method={RequestMethod.GET})
    public  String list1(@RequestParam(value = "contentIds") List<Long> contentIds){
        return contentIds.toString();
    }

    @RequestMapping(value = "/list", method={RequestMethod.GET})
    public  String list(@RequestParam(value = "contentIds[]") List<Long> contentIds){
        return contentIds.toString();
    }

    @RequestMapping(value = "/controllerAspect", method={RequestMethod.GET})
    @PrintTime
    public  String name(@NotBlank(message = "name null") String name){
        logger.info("Controller层----测试切面");
        return "controllerAspect";
    }

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

    public List<String> getUserNames(List<User> users) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                names.add(users.get(i).getName() + " " + users.get(i).getSurname());
            }
        }
        return names;
    }


}
