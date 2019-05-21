package com.foo.test.currentproblem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDataFormat 线程不安全
 * @author fooisart
 * @date 18:46 20-05-2019
 */
public class SimpleDateFormatProblem {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.format(new Date());
    }
}
