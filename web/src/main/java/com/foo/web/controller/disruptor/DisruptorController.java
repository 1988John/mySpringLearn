package com.foo.web.controller.disruptor;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foo.service.disruptor.DisruptorService;

/**
 * @author Fooisart
 * @date 19:46 05-03-2019
 */
@RestController
@RequestMapping(value = "/disruptor")
public class DisruptorController {
    @Resource
    private DisruptorService disruptorService;
    @RequestMapping("/produce")
    public void produce(long value){
        disruptorService.produceEvent(value);
    }
}
