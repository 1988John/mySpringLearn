package com.foo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fooisart
 * @date  2019/2/21
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/get", method={RequestMethod.GET})
    public  String get(int age,String name){
        return name + age;
    }

    @RequestMapping(value = "/post", method={RequestMethod.POST})
    public  String post(int age,String name){
        return name + age;
    }

    @RequestMapping(value = "/postRP", method={RequestMethod.POST})
    public  String postRequestParam(@RequestParam(value = "age") int age,
                                    @RequestParam(value = "name") String name){
        return name + age;
    }

    @RequestMapping(value = "/postRBSignal", method={RequestMethod.POST})
    public  String postRequestBodySignal(@RequestBody String name1,@RequestBody User user){
        return name1;
    }

    @RequestMapping(value = "/postRB", method={RequestMethod.POST})
    public  String postRequestBody(@RequestBody String age, String name){
        logger.error("age==>{}",age);
        logger.error("name==>{}",name);
        return name + age;
    }

    @RequestMapping(value = "/postMA", method={RequestMethod.POST})
    public  String postModeAttribute(@ModelAttribute int age,@ModelAttribute String name){
        return name + age;
    }

    @RequestMapping(value = "/getByObject", method={RequestMethod.GET})
    public  String getByObject(User user){
        return user.toString();
    }

    @RequestMapping(value = "/postByObject", method={RequestMethod.POST})
    public  String postByObject(User user){
        return user.toString();
    }

    @RequestMapping(value = "/postRPByObject", method={RequestMethod.POST})
    public  String postRequestParamByObject(@RequestParam(value = "user") User user){
        return user.toString();
    }

    @RequestMapping(value = "/postRBByObject", method={RequestMethod.POST})
    public  String postRequestBodyByObject(@RequestBody User user){
        return user.toString();
    }

    @RequestMapping(value = "/postMAByObject", method={RequestMethod.POST})
    public  String postModeAttributeByObject(@ModelAttribute User user){
        return user.toString();
    }
}
