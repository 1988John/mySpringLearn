package com.foo.test.event.service;

import com.foo.test.event.domain.User;
import com.foo.test.event.event.SendSmsEvent;
import com.foo.test.event.event.UserEvent;
import com.foo.test.event.listener.UserListener;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<UserListener> listenerList = new ArrayList<>();

    //当用户注册的时候，触发发送短信事件
    public void register(User user){

        System.out.println("name= " + user.getUsername() + " ,password= " + user.getPassword() + " ,注册成功");

        publishEvent(new SendSmsEvent(user));

    }

    public void publishEvent(UserEvent event){

        for(UserListener listener : listenerList){
            listener.onRegister(event);
        }

    }

    public void addListeners(UserListener listener){
        this.listenerList.add(listener);
    }

}