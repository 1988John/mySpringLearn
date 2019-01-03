package com.foo.service.processor;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;

import com.foo.service.annotation.Authority;

/**
 * 权限注解解析器
 *
 * @author jiangwang
 * @date 20:13 2018/7/30
 */
@Aspect
//@Component
public class AuthorityProcessor implements Ordered{

    private int order = LOWEST_PRECEDENCE - 1000; // 指定执行顺序

    @Pointcut("@annotation(com.foo.service.annotation.Authority)")
    public void authorityPoint() {
    }

    @Around("authorityPoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable{

        Method method = getMethod(jp);

        Authority authority = AnnotationUtils.findAnnotation(method, Authority.class);

        if (authority.role().equals("foo")){
            return jp.proceed();
        }

        return null;
    }

    private Method getMethod(ProceedingJoinPoint jp) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        return methodSignature.getMethod();
    }
    @Override
    public int getOrder() {
        return order;
    }
}
