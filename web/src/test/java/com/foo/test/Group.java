package com.foo.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author fooisart
 * @date 10:30 21-11-2019
 */
public class Group {
    private int id;
    private float num;
    private String name;

    public static void main(String[] args) {
        Group g1 = new Group(211, 1.1f, "f1");
        Group g2 = new Group(22, 0.1f,"f2");
        Group g3 = new Group(3,4.1f, "f3");
        Group g4 = new Group(42,2.1f, "f4");
        Group g5 = new Group(5, 3.1f,"f5");
        List<Group> list = new ArrayList<>();
        list.add(g1);list.add(g2);list.add(g3);list.add(g4);list.add(g5);
        list.sort(Comparator.comparing(o -> dynamicGet(o, "num")).reversed());
        System.out.println(list);
    }

    private static <T> T dynamicGet(Object listingLogDO, String propertyName) {
        try {
            Field field = listingLogDO.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            return (T) field.get(listingLogDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Group(int id, float num, String name) {
        this.id = id;
        this.num = num;
        this.name = name;
    }

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

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
