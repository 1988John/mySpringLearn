package com.foo.test.state.candy;

/**
 * @author fooisart
 * @date 15:13 23-05-2019
 */
public class HasCoin implements State{
    private CandyMachine mCandyMachine;

    public HasCoin(CandyMachine mCandyMachine) {
        this.mCandyMachine = mCandyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you cant insert another coin!");
    }

    @Override
    public void returnCoin() {
        System.out.println("coin return!");
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
