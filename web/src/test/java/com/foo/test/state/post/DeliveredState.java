package com.foo.test.state.post;

/**
 * @author fooisart
 * @date 14:48 23-05-2019
 */
public class DeliveredState implements PackageState{
    @Override
    public void next(Package pkg) {
        pkg.setState(new ReceivedState());
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("package delivered to post office, not received yet.");
    }
}
