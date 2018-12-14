package com.foo.test.lambda;

/**
 * @author jiangwang
 * Created on 14-12-2018
 */
@FunctionalInterface
public interface Executor {
    void execute(Person p);
}
