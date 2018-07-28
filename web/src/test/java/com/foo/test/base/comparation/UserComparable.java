package com.foo.test.base.comparation;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author jiangwang3
 * @date 2018/7/19.
 */
public class UserComparable implements Comparable<UserComparable>{
    private Date birth;
    private String name;

    @Override
    public int compareTo(UserComparable o) {
        return Long.compare(this.birth.getTime(),o.birth.getTime());
    }

    public UserComparable(Date birth, String name) {
        this.birth = birth;
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<UserComparable> useList = new ArrayList<>();

        UserComparable use1 = new UserComparable(new Date(130,2,2),"foo");
        UserComparable use2 = new UserComparable(new Date(112,4,2),"Jw");
        UserComparable use3 = new UserComparable(new Date(120,4,1),"do");

        useList.add(use1);
        useList.add(use2);
        useList.add(use3);

        Collections.sort(useList);

        Collections.reverse(useList);

        System.out.println(JSON.toJSONString(useList));
    }
}
