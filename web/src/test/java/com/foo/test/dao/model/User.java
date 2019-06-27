package com.foo.test.dao.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fooisart
 * @date 18:27 25-06-2019
 */
public class User {
    private int id;

    private String name;

    private int age;

    private int addressId;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("a", "aa");
        map.put("a", 22);
        System.out.println(map);
    }
}
