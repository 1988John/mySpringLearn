package com.foo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Fooisart
 * @date 16:56 19-03-2019
 */
public class Test {
    public static void main(String[] args) {
        String s = "你好，若你在使用快手的过程中遇到了问题，可以前往“快手客服”官方账号（快手ID：40300103）进行咨询<br/><a href=%s> 立即前往 </a>";
        String format = String.format(s, "https//baidu.com");
        System.out.println(format);
    }
}
