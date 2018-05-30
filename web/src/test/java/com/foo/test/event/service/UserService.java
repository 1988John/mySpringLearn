package com.foo.test.event.service;

import com.foo.test.event.domain.User;
import com.foo.test.event.event.UserEvent;
import com.foo.test.event.listener.UserListener;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<UserListener> listeneres = new ArrayList<UserListener>();

    //当用户注册的时候，触发发送邮件事件
    public void register(User user){

        System.out.println("save " + user.getUsername() + " : " + user.getPassword() + " to database");

        UserEvent event = new UserEvent(user);

        publishEvent(event);

    }

    public void publishEvent(UserEvent event){

        for(UserListener listener : listeneres){
            listener.onRegister(event);
        }

    }

    public void addListeners(UserListener listener){
        this.listeneres.add(listener);
    }

}