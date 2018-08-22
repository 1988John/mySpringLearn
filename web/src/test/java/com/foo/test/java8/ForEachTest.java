package com.foo.test.java8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author jiangwang3
 * @date 2018/8/21.
 */
public class ForEachTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Larry");
        names.add("Steve");
        names.add("James");
        names.add("Conan");
        names.add("Ellen");

        forEach1(names);

        forEach2(names);

        forEach3(names);

        forEach4(names);

    }

    private static void forEach1(List<String> names){
        System.out.println("=========1111111==========");
        names.forEach(new Consumer<String>() {
            public void accept(String name) {
                System.out.println(name);
            }
        });
    }

    private static void forEach2(List<String> names){
        System.out.println("========222222==========");
        Consumer<String> consumerNames = name -> {
            System.out.println(name);
        };
        names.forEach(consumerNames);
    }

    private static void forEach3(List<String> names){
        System.out.println("========333333==========");
        names.forEach(name -> System.out.println(name));
    }

    private static void forEach4(List<String> names){
        System.out.println("========444444==========");
        names.forEach(System.out::println);
        names.forEach(PrintUtils::log);
    }

}
