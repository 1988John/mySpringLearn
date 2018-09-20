package com.foo.test.clone;

import com.alibaba.fastjson.JSON;

/**
 * @author jiangwang3
 * @date 2018/9/20.
 */
public class Main {

    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setId(123L);
        User user1 = new User(10,"foo",account1);

        User clone = user1.clone();
        clone.setAge(18);
        clone.setName("jw");
        clone.getAccount().setId(999L);

        System.out.println("user1:{}" + JSON.toJSONString(user1));
        System.out.println("clone:{}" + JSON.toJSONString(clone));
    }
}
