package com.foo.test.state.post;

/**
 * @author fooisart
 * @date 14:46 23-05-2019
 */
public class OrderedState implements PackageState{
    @Override
    public void next(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(Package pkg) {
        System.out.println("the package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("package ordered,not delivered to the office yet.");
    }
}
