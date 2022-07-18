package com.foo.service.tx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 权限相关配置
 */
@Configuration
public class BeanConfig {

    @Bean
    public SessionLocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

}

