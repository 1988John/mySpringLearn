package com.foo.test.clone;

/**
 * @author jiangwang3
 * @date 2018/9/20.
 */
public class User implements Cloneable{
    private int age;
    private String name;

    private Account account;

    public User(int age, String name, Account account) {
        this.age = age;
        this.name = name;
        this.account = account;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    protected User clone() {
        User user = null;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        user.account = this.account.clone();
        return user;
    }
}
