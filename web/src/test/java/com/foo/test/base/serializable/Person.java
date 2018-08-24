package com.foo.test.base.serializable;
 
/**
 * Created by liuyazhou on 2016/9/27.
 */
public class Person {
 
    private String id;
    private String name;
    private Integer num;
 
    public Person() {
    }
 
    public Person(String id, String name, Integer num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Integer getNum() {
        return num;
    }
 
    public void setNum(Integer num) {
        this.num = num;
    }
}
