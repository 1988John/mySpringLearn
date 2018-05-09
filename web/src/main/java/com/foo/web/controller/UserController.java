package com.foo.web.controller;

import com.foo.service.annotation.PrintTime;
import com.foo.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/23.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * todo 此处若返回Integer 则报错 待研究
     * @author jiangwang
     * 21:52 2018/4/23
     */
    @RequestMapping(value = "/getCount", method={RequestMethod.GET})
    public  Integer getLeastLeasePrice(){

        return userService.selectCount();
    }

    @RequestMapping
    @PrintTime
    public  String name(){

        return "foo";
    }
}
