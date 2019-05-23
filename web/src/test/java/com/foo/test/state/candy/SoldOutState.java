package com.foo.test.state.candy;

/**
 * @author fooisart
 * @date 15:17 23-05-2019
 */
public class SoldOutState implements State{
    private CandyMachine mCandyMachine;

    public SoldOutState(CandyMachine mCandyMachine) {
        this.mCandyMachine = mCandyMachine;
    }

    @Override
    public void insertCoin() {

    }

    @Override
    public void returnCoin() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }

    @Override
    public void printState() {

    }
}
