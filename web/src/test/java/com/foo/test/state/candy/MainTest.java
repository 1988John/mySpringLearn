package com.foo.test.state.candy;

/**
 * @author fooisart
 * @date 15:58 23-05-2019
 */
public class MainTest {
    public static void main(String[] args) {
        CandyMachine machine = new CandyMachine(6);

        machine.printState();

        machine.insertCoin();
        machine.printState();

        machine.turnCrank();
        machine.printState();

        machine.insertCoin();
        machine.printState();

        machine.turnCrank();
        machine.printState();
    }
}
