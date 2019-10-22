package com.foo.test.drools.domain;

/**
 * @author jiangwang3
 * @date 2018/7/25.
 */
public class Car {
    private Person person;

    private int discount;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "person=" + person +
                ", discount=" + discount +
                '}';
    }
}
