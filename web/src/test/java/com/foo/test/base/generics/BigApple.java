package com.foo.test.base.generics;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Fooisart
 * @date 11:19 28-01-2019
 */
public class BigApple extends Apple  {

    public void test(){

        setList(abstractParentList());

        setList(commonParentList());

        setSupplier(abstractParentSupplier());

    }

    public void setList(List<Long> val) {
    }

    public void setSupplier(Supplier<Long> val) {
    }

}
