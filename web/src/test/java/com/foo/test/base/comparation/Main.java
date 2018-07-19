package com.foo.test.base.comparation;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jiangwang3
 * @date 2018/7/19.
 */
public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(19,"foo"));
        users.add(new User(49,"jw"));
        users.add(new User(1,"ab"));
        users.add(new User(34,"jack"));

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });

//        Collections.sort(users);

        System.out.println(JSON.toJSONString(users));
    }
}
