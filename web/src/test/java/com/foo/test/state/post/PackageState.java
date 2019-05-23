package com.foo.test.state.post;

/**
 * @author fooisart
 * @date 14:45 23-05-2019
 */
public interface PackageState {
    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
