package com.foo.service.processor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiangwang
 * @date 11:28 2018/5/14
 */
@Aspect
public class PrintTimeProcessor {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.foo.service.annotation.PrintTime)")
    public void printTimePoint() {
    }

    @Around("printTimePoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable{
        LOGGER.error("开始运行程序。。。Start==>");

        Object proceed = jp.proceed();

        LOGGER.error("结束啦，运行结束==>");

        return proceed;
    }
}
