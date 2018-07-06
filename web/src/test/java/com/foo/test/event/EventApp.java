package com.foo.test.event;

import com.foo.test.event.domain.User;
import com.foo.test.event.listener.SendSmsListener;
import com.foo.test.event.service.UserService;
/**
 * @author jiangwang
 * @date 21:35 2018/6/1
 */
public class EventApp {
    public static void main(String[] args) {

        UserService service = new UserService();

        service.addListeners(new SendSmsListener());

        //添加其他监听器 ...
        User user = new User("foo", "123456", "注册成功啦！！");

        service.register(user);
    }
}