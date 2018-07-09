package com.foo.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeHandlerAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Pointcut("execution(* com.foo.service.user.*.*(..))")
    public void printTimePoint() {
    }

    @Around("printTimePoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable{

        logger.error("start-currentTime:" + new Date());
        //执行业务逻辑
        Object proceed = jp.proceed();

        logger.error("over-currentTime:" + new Date());

        return proceed;
    }
}