package com.foo.test.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.sun.istack.internal.Nullable;

/**
 * @author fooisart
 * @date 09:56 07-05-2019
 */
public class MapBaseTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,21);
        System.out.println(map);
        Map<Integer,Integer> map1 = new HashMap<>();
//        map1.put(3,3);
//        map1.put(4,4);
//        map1.put(1,5);
        System.out.println(map1);

        map1.forEach((key,value) -> map.merge(key, value,(v1,v2) -> v1 + v2));
//        map.putAll(map1);
        System.out.println(map);
    }
}
