package com.foo.service.observer.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener  implements ApplicationListener {
    
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof MyEvent){
            System.out.println("into My Listener");
            MyEvent myEvent=(MyEvent)event;
            myEvent.print();
        }
    }
}