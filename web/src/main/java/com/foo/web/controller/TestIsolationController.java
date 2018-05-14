package com.foo.web.controller;

import com.alibaba.fastjson.JSON;
import com.foo.service.transaction.isolation.IsolationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/18.
 */
//@RestController
@RequestMapping(value = {"/isolation"})
public class TestIsolationController {
    @Resource
    private IsolationService isolationService;


    /**
     * 默认 repeatableRead
     * @author jiangwang
     * 17:22 2018/4/18
     */
    @RequestMapping(value = "/defaultLevel", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public Object defaultLevel(String name){
        return JSON.toJSON(isolationService.defaultLevel(name));
    }

    /**
     * 脏读 不可重复读 幻读
     * @author jiangwang
     * 17:22 2018/4/18
     */
    @RequestMapping(value = "/readUncommitted", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public Object readUncommitted(String name){
        return JSON.toJSON(isolationService.readUncommitted(name));
    }

    /**
     * 不可重复读 幻读
     * @author jiangwang
     * 17:23 2018/4/18
     */
    @RequestMapping(value = "/readCommitted", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public Object readCommitted(String name, Long second){
        return JSON.toJSON(isolationService.readCommitted(name,second));
    }

    /**
     * 幻读
     * @author jiangwang
     * 17:23 2018/4/18
     */
    @RequestMapping(value = "/repeatableRead", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public Object repeatableRead(String name, Long second){
        return JSON.toJSON(isolationService.repeatableRead(name,second));
    }

    /**
     * 幻读
     * @author jiangwang
     * 17:23 2018/4/18
     */
    @RequestMapping(value = "/phantomRead", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public Object phantomRead(Long second){
        return JSON.toJSON(isolationService.phantom(second));
    }

    /**
     * 全部避免
     * @author jiangwang
     * 17:24 2018/4/18
     */
    @RequestMapping(value = "/serializable", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public Object serializable(Long second){
        return JSON.toJSON(isolationService.serializable(second));
    }

    @RequestMapping(value = "/insert", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public Object insert(String name, Long second){
        isolationService.insert(name,second);
        return JSON.toJSON("su");
    }

}
