package com.foo.test.groupby;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author fooisart
 * @date 16:29 24-04-2019
 */
public class Main {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(2,"苹果",new BigDecimal("1.35"),20);
        Apple apple121 = new Apple(3,"苹果",new BigDecimal("1.35"),null);
        Apple apple2 =  new Apple(4,"香蕉",new BigDecimal("2.89"),null);
        Apple apple21 =  new Apple(5,"香蕉",new BigDecimal("2.89"),10);
        Apple apple3 =  new Apple(6,"荔枝",new BigDecimal("9.99"),40);
        Apple apple31 =  new Apple(7,"荔枝",new BigDecimal("9.99"),40);

        list.add(apple1);
        list.add(apple12);
        list.add(apple2);
        list.add(apple3);
        list.add(apple121);
        list.add(apple21);
        list.add(apple31);

        Map<Integer, List<Apple>> groupBy = list.stream().collect(Collectors.groupingBy(apple -> {
            if (apple.getNum() == null) {
                return -2;
            } else {
                if (apple.getId() > 0 && apple.getId() <=3){
                    return 1;
                } else if (apple.getId() > 3 && apple.getId() <=6) {
                    return 2;
                }
                return -1;
            }
        }));

        System.out.println("groupBy:"+JSONObject.toJSONString(groupBy));

//        List<Apple> apples = groupBy.get(1);
//        apples.removeIf(apple -> apple.getName().equals("苹果1"));
//
//        System.err.println("groupBy:"+JSONObject.toJSONString(groupBy));
    }
}
