package com.foo.test.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * @author fooisart
 * @date 10:51 21-05-2019
 */
public class ListStreamTest {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(123L);
        list.add(456L);
        Long sum = list.stream().flatMapToLong(LongStream::of).sum();
        System.out.println(sum);
    }
}
