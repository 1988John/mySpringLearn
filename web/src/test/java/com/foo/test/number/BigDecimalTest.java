package com.foo.test.number;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author fooisart
 * @date 15:54 17-05-2019
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        Long l = 12345670L;
        BigDecimal a = new BigDecimal(l);
        System.out.println(a.divide(new BigDecimal(100)).setScale(2, RoundingMode.DOWN));
    }
}
