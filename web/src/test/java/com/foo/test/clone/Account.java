package com.foo.test.clone;

/**
 * @author jiangwang3
 * @date 2018/9/20.
 */
public class Account implements Cloneable{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    protected Account clone() {
        Account account = null;
        try {
            account = (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return account;
    }
}
