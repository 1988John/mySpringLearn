package com.foo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fooisart
 * @date 16:09 29-04-2019
 */
@RestController
@RequestMapping(value = "/elk")
public class ElkController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/who", method={RequestMethod.GET})
    public  String value(String name){
        logger.info("能不能别逗我了：" + name);
        return "logback-log-name:" + name;
    }
}
