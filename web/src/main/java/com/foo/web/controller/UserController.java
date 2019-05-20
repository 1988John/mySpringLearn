package com.foo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foo.domain.user.User;
import com.foo.service.annotation.AdminLog;
import com.foo.service.annotation.Elapsed;
import com.foo.service.user.OrderService;
import com.foo.service.user.Vo;

/**
 * @author jiangwang
 * @date  2018/5/14
 */
@RestController
@RequestMapping(value = "/user")
@Validated
//@Elapsed
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource private OrderService orderService;

//    @AdminLog(bizKey = "#vo.name + '_' + #vo.age", desc = "#vo.id")
    @RequestMapping(value = "/value", method={RequestMethod.GET})
    public  String value(Vo vo){
        logger.info("进入get请求。。。");
        List<Integer> ids = new ArrayList<>();
        ids.add(123);ids.add(789);ids.add(654);
        vo.setIds(ids);
        orderService.spel(vo);
        return vo.toString();
    }

    @RequestMapping(value = "/post", method={RequestMethod.POST})
    public  String value1(@RequestBody List<Long> ids){
        logger.info("进入post请求。。");
        return ids.get(0).toString();
    }

    @Elapsed
    public void test() throws InterruptedException {
        Thread.sleep(1000L);
        logger.info("进入了test方法");
    }

    @RequestMapping(value = "/domain", method={RequestMethod.GET})
    public  String domain(User user){
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
    @Elapsed
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


}
