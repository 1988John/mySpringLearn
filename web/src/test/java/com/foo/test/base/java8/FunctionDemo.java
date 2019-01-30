package com.foo.test.base.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by fan on 2016/11/4.
 */
public class FunctionDemo {
    //API which accepts an implementation of

    //Function interface

    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function){

        int newValue = function.apply(valueToBeOperated);

        /*
         * Do some operations using the new value.
         */

        System.out.println(newValue);

        Object o = null;
        Long l = 1L;
        o = l;

        List<Long>  listLong = new ArrayList<>();
        List<?> listObject = new ArrayList<>();
        listObject = listLong;

    }

    public static void main(String[] args) {

        int incr = 20;  int myNumber = 10;

        modifyTheValue(myNumber, val-> val + incr);

        myNumber = 15;  modifyTheValue(myNumber, val-> val * 10);

        modifyTheValue(myNumber, val-> val - 100);

        modifyTheValue(myNumber, setFunction());

    }

    public static Function<Integer, Integer> setFunction(){
        return
                val-> "somestring".length() + val - 100;
    }
}