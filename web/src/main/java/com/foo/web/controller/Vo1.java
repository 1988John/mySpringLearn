package com.foo.web.controller;

/**
 * @author Fooisart
 * @date 14:16 27-03-2019
 */
public class Vo1 {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vo1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
