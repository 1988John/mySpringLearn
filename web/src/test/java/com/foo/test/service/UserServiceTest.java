package com.foo.test.service;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.foo.domain.user.Address;
import com.foo.domain.user.User;
import com.foo.service.user.AddressService;
import com.foo.service.user.UserService;
import com.foo.test.BaseTest;
import com.github.phantomthief.model.builder.context.impl.SimpleBuildContext;
import com.github.phantomthief.model.builder.impl.SimpleModelBuilder;
import com.google.common.collect.Maps;

/**
 * @author Fooisart
 * @date 10:56 30-01-2019
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Test
    public void selectUserByName() {
        User lisan = userService.selectUserByName("lisan");
        logger.error("结果：==》{}",JSON.toJSON(lisan));

        List<User> users = userService.queryAll();
        logger.error("结果：==》{}",JSON.toJSON(users));
    }

    @Test
    public void test(){
        List<User> userList = userService.queryAll();
        SimpleModelBuilder<SimpleBuildContext> modelBuilder = new SimpleModelBuilder<>();
        SimpleBuildContext buildContext = new SimpleBuildContext();  // 声明一个构建上下文，所有构建的结果都会存入这个上下文对象中

        Class<User> clazz = User.class;
        modelBuilder.valueFromSelf(clazz,  User::getId)
                .lazyBuild(clazz, addressService::getAddressByIds, "addressMap")
        ;

        modelBuilder.buildMulti(userList, buildContext); // 执行构建操作

        Map<Integer, User> userMap = buildContext.getData(User.class); // 从User.class的value命名空间获得数据
        logger.error("结果user：==》{}",JSON.toJSON(userMap));

        Map<Integer, Address> addressMap = buildContext.getData("addressMap"); // 从addressMap的value命名空间获得数据
        logger.error("结果address：==》{}",JSON.toJSON(addressMap));
    }

    public static void main(String[] args) {
        Map<String, Map<String, String>> valuesMap = new HashMap<>();

        Map<String,String> map1 = Maps.newHashMap();
        map1.put("child-key-1","child-value-1");
        map1.put("child-key-2","child-value-11");
        map1.put("child-key-3","child-value-2");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("child-key-2","child-value-2");

        valuesMap.put("key1",map1);
        valuesMap.put("key2",map2);

        Set<String> result = valuesMap.values().stream().flatMap(map -> map.values().stream())
                .collect(toSet());
        System.out.println(JSON.toJSON(result));
    }
}