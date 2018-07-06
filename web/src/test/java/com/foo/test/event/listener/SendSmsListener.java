package com.foo.test.event.listener;

import com.foo.test.event.domain.User;
import com.foo.test.event.event.SendSmsEvent;
import com.foo.test.event.event.UserEvent;
import com.foo.test.event.listener.UserListener;
/**
 * @author jiangwang
 * @date 21:38 2018/6/1
 */
public class SendSmsListener implements UserListener {
    @Override
    public void onRegister(UserEvent event) {
        if (event instanceof SendSmsEvent) {
            Object source = event.getSource();
            User user = (User) source;
            System.out.println("send sms to " + user.getUsername());
        }
    }
}