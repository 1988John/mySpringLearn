package com.foo.test.base;

import java.util.Arrays;
import java.util.List;

/**
 * @author jiangwang
 * @date 2021-02-28 07:51
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "abc";
        str.indexOf(1);


        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);


        List<String> names = Arrays.asList("张三", "李四", "王老五", "李三", "刘老四", "王小二", "张四", "张五六七");

        String maxLenStartWithZ = names.stream()
                .parallel()
                .filter(name -> name.startsWith("张"))
                .mapToInt(String::length)
                .max()
                .toString();
    }
}
