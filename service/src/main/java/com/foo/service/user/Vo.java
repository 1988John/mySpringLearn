package com.foo.service.user;

import java.util.List;

/**
 * @author fooisart
 * @date 10:24 20-05-2019
 */
public class Vo {
    private long id;
    private String name;
    private int age;
    private List<Integer> ids;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ids=" + ids +
                '}';
    }
}
