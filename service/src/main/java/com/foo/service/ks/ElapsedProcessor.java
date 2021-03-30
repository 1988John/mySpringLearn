package com.foo.service.ks;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


/**
 * 监控接口运行时间
 *
 * @author fooisart
 * @date 14:58 2019/5/9
 */
@Aspect
@Component
public class ElapsedProcessor implements Ordered {

    private static final int MILL = 1000;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@within(Elapsed) || @annotation(Elapsed)")
    public void elapsedPoint() {
    }

    @Around("elapsedPoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable {
        String methodName = getMethodFullName(jp);
        Method method = MethodUtils.getMethodFromJoinPoint(jp);
        Elapsed elapsed = AnnotationUtils.findAnnotation(method, Elapsed.class);
        if (elapsed == null) {
            // 找不到方法上的, 找类上的
            elapsed = AnnotationUtils.findAnnotation(method.getDeclaringClass(), Elapsed.class);
        }
        StopWatch watcher = new StopWatch();
        watcher.start();
        //执行业务逻辑
        Object proceed = jp.proceed();
        watcher.stop();
        if (elapsed != null && watcher.getTotalTimeMillis() > elapsed.threshold()) {
            logger.info("ElapsedProcessor-methodName==>[{}],{}", methodName, watcher.prettyPrint());
        }

        return proceed;
    }
    /**
     * 获取方法全称
     * @return java.lang.Class#methodName
     * @author fooisart
     * @date 13:51 2019/5/9
     */
    private String getMethodFullName(JoinPoint jp) {
        MethodSignature msig = (MethodSignature) jp.getSignature();
        Method method = msig.getMethod();
        return method.getDeclaringClass().getName() + "#" + method.getName();
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE - MILL; // 指定执行顺序
    }
}
