package com.foo.test.state.post;

/**
 * @author fooisart
 * @date 14:45 23-05-2019
 */
public class Package {
    private PackageState state = new OrderedState();

    public void previousState(){
        state.prev(this);
    }

    public void nextState(){
        state.next(this);
    }

    public void printStatus(){
        state.printStatus();
    }

    public PackageState getState() {
        return state;
    }

    public void setState(PackageState state) {
        this.state = state;
    }
}
