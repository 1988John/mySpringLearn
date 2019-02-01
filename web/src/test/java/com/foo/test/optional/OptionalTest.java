package com.foo.test.optional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Fooisart
 * @date 10:53 01-02-2019
 */
public class OptionalTest {
    public static void main(String[] args) {

//        Optional<String> gender = Optional.of("MALE");
//        String answer1 = "Yes";
//        String answer2 = null;
//
//        System.out.println("Non-Empty Optional:" + gender);
//        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
//        System.out.println("Empty Optional: " + Optional.empty());
//
//        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
//        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        Map<String, String> map = null;
        Object a = Optional.ofNullable(map).orElse(new HashMap<>()).get("a");
        System.out.println((List<String>)a);

    }
}
