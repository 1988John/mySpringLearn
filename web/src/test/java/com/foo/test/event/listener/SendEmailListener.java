package com.foo.test.event.listener;

import com.foo.test.event.domain.User;
import com.foo.test.event.event.SendEmailEvent;
import com.foo.test.event.event.UserEvent;

public class SendEmailListener implements UserListener {

    @Override
    public void onRegister(UserEvent event) {

        if (event instanceof SendEmailEvent) {

            Object source = event.getSource();

            User user = (User) source;

            System.out.println("send email to " + user.getEmail());
        }
    }
}