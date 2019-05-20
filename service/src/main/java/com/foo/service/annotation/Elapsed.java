package com.foo.service.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * Created by jiangwang3 on 2018/5/9.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface Elapsed {
}
