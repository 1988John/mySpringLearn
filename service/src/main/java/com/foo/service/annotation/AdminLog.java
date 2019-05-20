package com.foo.service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fooisart
 * @date 10:37 14-05-2019
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface AdminLog {
    /**
     *
     */
    long appId() default 0;
    /**
     * 日志模块类型,调用方自定义。便于后期各个业务系统日志分类。
     *
     * 建议业务系统自定义枚举类型
     */
    int bizType() default 0;
    /**
     * 描述
     */
    String desc() default "";
    /**
     * 操作类型,如创建、删除、修改、查看,调用方自定义,调用方自定义
     */
    String bizKey() default "";

    /**
     * sorucePage
     */
    String sourcePage() default "";
}
