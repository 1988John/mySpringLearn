package com.foo.test.thread.model;

/**
 * @author jiangwang
 * @date 2021-02-25 21:45
 */
public class ThreadUser {
    private String name;
    private Integer age;

    public ThreadUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ThreadUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
