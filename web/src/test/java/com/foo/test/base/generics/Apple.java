package com.foo.test.base.generics;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Fooisart
 * @date 11:19 28-01-2019
 */
public class Apple extends Fruit {

    protected List<Long> commonParentList() {
        setSupplier1(abstractParentSupplier());
        return null;
    }

    public void setSupplier1(Supplier<Long> val) {
    }

}
