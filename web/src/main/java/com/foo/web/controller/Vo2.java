package com.foo.web.controller;

/**
 * @author Fooisart
 * @date 14:16 27-03-2019
 */
public class Vo2 {
    private int id;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Vo2{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
