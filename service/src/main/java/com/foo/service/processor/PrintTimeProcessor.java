package com.foo.service.processor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jiangwang
 * @date 11:28 2018/5/14
 */
@Aspect
@Component
public class PrintTimeProcessor implements Ordered{

    private int order = LOWEST_PRECEDENCE - 1000; // 指定执行顺序

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.foo.service.annotation.PrintTime)")
    public void printTimePoint() {
    }

    @Around("printTimePoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable{
        System.out.println();

        LOGGER.error("开始运行程序。。。Start==>{}",new Date());

        Object proceed = jp.proceed();

        LOGGER.error("结束啦，运行结束==>{}",new Date());

        System.out.println();

        return proceed;
    }
    @Override
    public int getOrder() {
        return order;
    }
}
