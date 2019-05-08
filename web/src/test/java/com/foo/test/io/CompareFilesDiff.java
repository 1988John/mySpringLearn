package com.foo.test.io;

import static com.foo.test.io.FileUtil.readCsv;

import java.util.List;

/**
 * @author fooisart
 * @date 19:59 07-05-2019
 */
public class CompareFilesDiff {
    public static void main(String[] args) throws Exception {
        String test = "/Users/fooisart/Desktop/test";
        String online = "/Users/fooisart/Desktop/online";
        List<String> testList = readCsv(test);
        System.out.println(testList);

        List<String> onlineList = readCsv(online);
        System.out.println(onlineList);

//        testList.removeAll(onlineList);
//        System.out.println("testList.removeAll(onlineList)==>:" + testList);

        onlineList.removeAll(testList);
        System.out.println("onlineList.removeAll(testList)==>:" + onlineList);
    }
}
