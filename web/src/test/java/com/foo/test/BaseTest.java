package com.foo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jiangwang3
 * @date 2018/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public abstract class BaseTest {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 4);
        map.put("b", 40);
        map.put("c", 14);
        map.put("d", 24);
        map.put("e", 48);
        map.put("f", 4);

        Map<String, Integer> okMap = map.entrySet().stream().filter(entry -> ok(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        int c = okMap.values().stream()
                .min(Comparator.naturalOrder()).orElse(-1);

        List<String> result = okMap.entrySet().stream()
                .filter(entry -> entry.getValue() == c)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static boolean ok(String key) {
        return true;
    }

}
