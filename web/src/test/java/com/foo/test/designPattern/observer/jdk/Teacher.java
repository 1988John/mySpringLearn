package com.foo.test.designPattern.observer.jdk;

import java.util.Observable;

/**
 * Description:
 * Created by jiangwang3 on 2018/5/8.
 */
public class Teacher extends Observable{
    //布置作业的状态信息字符串
    private String info;

    public void setHomework(String info) {

        this.info=info;
        System.out.println("布置的作业是"+info);

        setChanged();
        notifyObservers();
    }

    public String getInfo() {
        return info;
    }
}
