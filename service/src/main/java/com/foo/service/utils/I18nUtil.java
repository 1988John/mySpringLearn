package com.foo.service.utils;

import com.foo.service.tx.ApplicationContextHelper;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
 
/**
 * 多语言查询value工具类
 * 
 * @author jiangwang
 * @date 2022-03-11
 *
 */
public class I18nUtil {
 
    private static final MessageSource messageSource;
 
    static {
        messageSource = ApplicationContextHelper.getBean(MessageSource.class);
    }
    /**
     * 根据code获取内容
     *
     * @author jiangwang
     * @date 2022/3/11 4:51 PM
     */
    public static String getMessage(String code){
        return messageSource.getMessage(code,null,"",LocaleContextHolder.getLocale());
    }

}