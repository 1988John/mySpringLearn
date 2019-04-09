package com.foo.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.foo.web.Birthday;
import com.google.common.collect.Maps;

import net.sf.cglib.beans.BeanMap;

/**
 * @author Fooisart
 * @date 14:47 27-03-2019
 */
public class ObjectTransferUtils {
    /**
     * 对象==>map
     * @author Fooisart
     * @date 14:44 2019/3/27
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Birthday birthday = new Birthday();
        birthday.setName("jw");
        birthday.setDate(new Date());

        Map<String, Object> map = beanToMap(birthday);
        System.out.println(map);

        System.out.println(BeanUtils.describe(birthday));
    }
}
