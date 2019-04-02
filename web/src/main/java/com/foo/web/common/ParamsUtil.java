package com.foo.web.common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/**
 * Description:参数校验工具
 * Created by jiangwang3 on 2018/1/11.
 */
public class ParamsUtil {
    private static Logger logger = LoggerFactory.getLogger(ParamsUtil.class);
    /**
     * 校验必填参数是否为null
     * @author jiangwang
     * @return true:有为空的值 false：全部不为空
     * 14:20 2018/1/11
     */
    public static boolean checkNullParams(Object... params){
        if (params == null)
            return true;

        for (Object param:params){
            if (param == null)
                return true;

            if (param instanceof String && StringUtils.isBlank(param.toString()))
                return true;

        }
        return false;
    }

    /**
     * 将javabean转为map
     * @author jiangwang
     * 19:16 2018/1/11
     */
    public static Map<String, Object> objectParseMap(Object obj) {

        if (obj == null)
            return null;

        Map<String, Object> map = new HashMap<>();

        Field[] fields = obj.getClass().getDeclaredFields();// 获取f对象对应类中的所有属性域
        for (Field field : fields) {
            String varName = field.getName();
            try {
                ReflectionUtils.makeAccessible(field);
                Object value = field.get(obj);//获取变量对应的值
                if (value != null)
                    map.put(varName, value);

            } catch (Exception ex) {
                logger.error("javabean转map报错：{}",ex);
            }
        }
        return map;
    }

}
