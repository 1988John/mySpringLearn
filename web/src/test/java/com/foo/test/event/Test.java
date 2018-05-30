package com.foo.test.event;

import com.foo.test.event.domain.User;
import com.foo.test.event.listener.SendEmailListener;
import com.foo.test.event.service.UserService;

public class Test {

    public static void main(String[] args) {

        UserService service = new UserService();

        service.addListeners(new SendEmailListener());

        //添加其他监听器 ...

        User user = new User("zhangsan", "123456", "zhangsan@huawei.com");

        service.register(user);
    }
}