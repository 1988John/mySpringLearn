package com.foo.service.ks;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 监控接口运行时间
 *
 * @author fooisart
 * @date 14:48 2019/5/9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Elapsed {
    /**
     * 打印时间阈值(ms)。超过阈值则打印，默认为200
     */
    int threshold() default 200;
}
