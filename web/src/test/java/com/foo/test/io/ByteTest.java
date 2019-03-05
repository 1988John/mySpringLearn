package com.foo.test.io;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.foo.domain.user.User;

/**
 * @author Fooisart
 * @date 10:04 05-03-2019
 */
public class ByteTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("aab");
        User user2 = new User();
        user2.setName("ccc");
        List<User> list = Arrays.asList(user1,user2);
        System.out.println(list);
        String collect = list.stream().map(User::getName).collect(Collectors.joining());
        System.out.println(collect);
    }
}
