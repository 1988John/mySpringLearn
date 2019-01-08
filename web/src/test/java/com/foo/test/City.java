package com.foo.test;

/**
 * @author Fooisart
 * Created on 07-01-2019
 */
public enum  City {
    BJ("beijing",100),
    SH("beijing",120),
    TJ("beijing",130);

    private String name;
    private int area;

    City(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
