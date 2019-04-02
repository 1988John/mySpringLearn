package com.foo.web.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/**
 * 测试模拟工具类
 *
 * @author jiangwang3
 * @date 2018/8/2.
 */
public class MockUtils {

    private static final Logger logger = LoggerFactory.getLogger(MockUtils.class);

    /**
     * 模拟数据
     *
     * @param type             原对象类型
     * @param ignoreProperties 忽略的字段
     */
    public static <T> T mockData(Class<T> type, String... ignoreProperties) {
        T source = null;
        try {
            source = type.newInstance();
            // 获取f对象对应类中的所有属性域
            Field[] fields = source.getClass().getDeclaredFields();
            for (Field field : fields) {
                List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);
                ReflectionUtils.makeAccessible(field);
                //获取变量对应的值
                Object value = field.get(source);
                if (ParamsUtil.checkNullParams(value) && (ignoreList == null || !ignoreList.contains(field.getName()))) {
                    if (generateData(field.getType()) == null) {
                        Object instance = mockData(field.getType());
                        field.set(source, instance);
                    } else {
                        field.set(source, generateData(field.getType()));
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("mock test data:", ex);
        }

        return source;
    }

    /**
     * 根据类型生成数据
     *
     * @author jiangwang
     * @date 10:24 2018/8/3
     */
    private static Object generateData(Class<?> type) {

        if (type.getName().equals("java.lang.Integer")) {
            return (new Random()).nextInt(128);
        }
        if (type.getName().equals("java.lang.Long") ||
                type.getName().equals("long")) {
            return RandomUtils.nextLong(100, 10000);
        }
        if (type.getName().equals("java.util.Date")) {
            return new Date();
        }
        if (type.getName().equals("java.lang.String")) {
            return RandomStringUtils.randomAlphanumeric(6);
        }
        if (type.getName().equals("java.lang.Byte")) {
            return (byte) 0;
        }

        return null;
    }

}
