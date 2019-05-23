package com.foo.test.state.candy;

/**
 * @author fooisart
 * @date 15:11 23-05-2019
 */
public interface State {
    void insertCoin();

    void returnCoin();

    void turnCrank();

    void dispense();

    void printState();
}
