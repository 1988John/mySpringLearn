package com.foo.service.disruptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.foo.domain.user.User;

/**
 * @author Fooisart
 * @date 14:22 28-02-2019
 */
@Service
public class DisruptorService implements ApplicationListener<ContextRefreshedEvent> {
    private volatile boolean initialized = false;

    @Override
    public synchronized void onApplicationEvent(ContextRefreshedEvent event) {
        if (!initialized) {
            //contextRefreshed(event.getApplicationContext());
            initialized = true;
        }
    }

    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("aa"),new User("bb"),new User("cc"));
        StringBuilder sb = new StringBuilder();
        list.forEach(user -> sb.append(user.getName()));
        System.out.println(sb);
    }
}
