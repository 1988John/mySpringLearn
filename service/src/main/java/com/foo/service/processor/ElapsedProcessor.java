package com.foo.service.processor;

import com.foo.service.annotation.Elapsed;
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
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * 监控接口运行时间
 *
 * @author jiangwang
 * @time 2021-12-29 16:42
 */
@Aspect
@Component
public class ElapsedProcessor implements Ordered {

    private static final int MILL = 1000;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@within(com.foo.service.annotation.Elapsed) || @annotation(com.foo.service.annotation.Elapsed)")
    public void elapsedPoint() {
    }

    @Around("elapsedPoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable {
        logger.info("start to enter ElapsedProcessor--- ");
        String methodName = getMethodFullName(jp);
        Method method = getMethodFromJoinPoint(jp);
        Elapsed elapsed = AnnotationUtils.findAnnotation(method, Elapsed.class);
        if (elapsed == null) {
            // 找不到方法上的, 找类上的
            elapsed = AnnotationUtils.findAnnotation(method.getDeclaringClass(), Elapsed.class);
        }
        long start = System.currentTimeMillis();

        //执行业务逻辑
        Object proceed = jp.proceed();

        long spendTime = System.currentTimeMillis() - start;


        return proceed;
    }
    /**
     * 获取方法全称
     * @return java.lang.Class#methodName
     * @author jiangwang
     * @date 2021/12/30 3:39 PM
     */
    private String getMethodFullName(JoinPoint jp) {
        MethodSignature msig = (MethodSignature) jp.getSignature();
        Method method = msig.getMethod();
        return method.getDeclaringClass().getName() + "#" + method.getName();
    }

    /**
     * 获取方法
     *
     * @author jiangwang
     * @date 2021/12/30 3:39 PM
     */
    private Method getMethodFromJoinPoint(ProceedingJoinPoint jp) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        //如果是jdk proxy，上面的method是接口中的方法定义。需要下面这句话，获取真正的方法实现
        return ClassUtils.getMostSpecificMethod(method, jp.getTarget().getClass());
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE - MILL; // 指定执行顺序
    }
}
