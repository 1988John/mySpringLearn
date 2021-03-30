package com.foo.service.ks;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.ClassUtils;

/**
 * @author fooisart
 * @date 18:16 30-05-2019
 */
public class MethodUtils {
    /**
     * 获取方法
     * @author fooisart
     * @date 14:12 2019/5/20
     */
    public static Method getMethodFromJoinPoint(ProceedingJoinPoint jp) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        //如果是jdk proxy，上面的method是接口中的方法定义。需要下面这句话，获取真正的方法实现
        return ClassUtils.getMostSpecificMethod(method, jp.getTarget().getClass());
    }
}
