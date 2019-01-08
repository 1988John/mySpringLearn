package com.foo.test.base;

import org.apache.commons.lang3.EnumUtils;

import com.foo.test.City;

/**
 * @author Fooisart
 * Created on 07-01-2019
 */
public class EnumTest {
    public static void main(String[] args) {
        City bj = EnumUtils.getEnum(City.class, "aa");
        System.out.println(bj);
    }
}
