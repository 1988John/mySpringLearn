package com.foo.test.base.generics;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Fooisart
 * @date 11:18 28-01-2019
 */
public abstract class Fruit {
    protected List<Long> abstractParentList() {
        return null;
    }

    protected Supplier<Long> abstractParentSupplier() {
        return null;
    }
}
