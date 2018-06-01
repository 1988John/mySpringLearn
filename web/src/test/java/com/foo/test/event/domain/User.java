package com.foo.test.event.domain;

public class User {

    private String username;

    private String password;

    private String sms;

    public User(String username, String password, String sms) {
        this.username = username;
        this.password = password;
        this.sms = sms;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
}