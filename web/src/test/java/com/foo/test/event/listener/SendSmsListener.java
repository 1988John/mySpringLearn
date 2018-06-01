package com.foo.test.event.listener;

import com.foo.test.event.domain.User;
import com.foo.test.event.event.SendSmsEvent;
import com.foo.test.event.event.UserEvent;
import com.foo.test.event.listener.UserListener;

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