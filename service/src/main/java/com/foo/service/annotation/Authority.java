package com.foo.service.annotation;

import java.lang.annotation.*;

/**
 * 权限控制注解
 *
 * @author jiangwang3
 * @date 2018/7/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Authority {
    String role() default "";
}
