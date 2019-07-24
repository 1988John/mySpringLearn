package com.foo.web.controller;

import java.util.Arrays;

/**
 * @author fooisart
 * @date 16:43 27-06-2019
 */
public class oo {
    public static void main(String[] args) {
        String str = "a|b";
        String[] split = str.split("\\|");
        System.out.println(Arrays.toString(split));


    }


    static class T {
        String name;
        int age;

        public T(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "T{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
