package com.foo.test.designPattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Description:
 * Created by jiangwang3 on 2018/5/8.
 */
public class Student implements Observer{
//    private Observable ob;
    private String name;

    public Student(String name) {
//        this.ob = ob;
        this.name=name;
//        ob.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        Teacher t=(Teacher)o;
        System.out.println(name+"得到作业信息:"+t.getInfo());
    }
}
