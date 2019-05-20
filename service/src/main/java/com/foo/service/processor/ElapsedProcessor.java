package com.foo.service.processor;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.ecyrd.speed4j.StopWatch;
import com.ecyrd.speed4j.StopWatchFactory;
import com.ecyrd.speed4j.log.Slf4jLog;

/**
 * @author jiangwang
 * @date 11:28 2018/5/14
 */
@Aspect
@Component
public class ElapsedProcessor implements Ordered{

    private int order = LOWEST_PRECEDENCE - 1000; // 指定执行顺序

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Pointcut("@within(com.foo.service.annotation.Elapsed) || @annotation(com.foo.service.annotation.Elapsed)")
    private void elapsedPoint() {
    }

    @Around("elapsedPoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable{
        String key = getMethodFullName(jp);

        StopWatch watcher = new StopWatchFactory(new Slf4jLog()).getStopWatch();
        Object proceed = jp.proceed();
        LOGGER.info(key + "，watcher,运行时间==>{}",watcher.getElapsedTime());

        return proceed;
    }
    /**
     * 获取方法全称
     * @return java.lang.Class#methodName
     * @author fooisart
     * @date 13:51 2019/5/9
     */
    private String getMethodFullName(JoinPoint jp) {
        MethodSignature msig = (MethodSignature)jp.getSignature();
        Method method = msig.getMethod();
        return method.getDeclaringClass().getName() + "#" + method.getName();
    }

    @Override
    public int getOrder() {
        return order;
    }
}
