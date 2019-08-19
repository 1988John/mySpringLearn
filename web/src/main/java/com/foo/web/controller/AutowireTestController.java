package com.foo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foo.service.autotest.NoInterfaceClass;

/**
 * @author fooisart
 * @date 15:10 15-08-2019
 */
@RestController
@RequestMapping(value = "/auto")
public class AutowireTestController {
    @Autowired
    private NoInterfaceClass noInterfaceClass;

    @RequestMapping(value = "/test", method={RequestMethod.GET})
    public String test(){
        return noInterfaceClass.getName();
    }
}
