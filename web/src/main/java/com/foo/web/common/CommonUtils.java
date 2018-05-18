package com.foo.web.common;

import com.alibaba.fastjson.JSON;
import com.foo.domain.user.User;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValues;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangwang
 * @date 16:35 2018/5/18
 */

public class CommonUtils
{
    /**
     * <p>复制source中的属性值到target对象中
     *
     * <p>使用Spring的BeanWrapper机制实现POJO的属性注入，优点是无需关心类型转换
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Map<?, ?> source, Object target) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(target);
        beanWrapper.setAutoGrowNestedPaths(true);
        PropertyValues propertyValues = new MutablePropertyValues(source);
        beanWrapper.setPropertyValues(propertyValues, true );
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("id","123");
        map.put("name","foo");
        User user = new User();
        copyProperties(map,user);
        System.out.println(JSON.toJSONString(user));
    }

}
