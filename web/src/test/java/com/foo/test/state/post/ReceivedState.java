package com.foo.test.state.post;

/**
 * @author fooisart
 * @date 14:49 23-05-2019
 */
public class ReceivedState implements PackageState {
    @Override
    public void next(Package pkg) {
        System.out.println("this package is already received by a client.");
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("package received by a client.");
    }
}
