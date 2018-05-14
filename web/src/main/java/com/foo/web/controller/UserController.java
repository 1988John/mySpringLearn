package com.foo.web.controller;

import com.foo.service.annotation.PrintTime;
import com.foo.service.user.UserService;
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
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/serviceAspect", method={RequestMethod.GET})
    public  String serviceAspect(){

        return userService.serviceAspect();
    }

    @RequestMapping(value = "/controllerAspect", method={RequestMethod.GET})
    @PrintTime
    public  String name(){

        return "controllerAspect";
    }

    /**
     * 此处之前返回Integer 报错。原因：将对象转为json，spring默认使用fastjson。
     * 解决方法：添加fastjson包即可
     * @author jiangwang
     * 21:52 2018/4/23
     */
    @RequestMapping(value = "/getCount", method={RequestMethod.GET})
    public  Integer getLeastLeasePrice(){

        return userService.selectCount();
    }
}
