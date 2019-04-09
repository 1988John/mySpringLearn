package com.foo.test.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.alibaba.fastjson.JSON;
import com.foo.web.Birthday;

/**
 * @author Fooisart
 * @date 11:44 02-04-2019
 */
public class ListCompare {
    public static void main(String[] args) {
        Birthday b1 = new Birthday();
        b1.setDate(new Date(2019,1,1));
        b1.setName("jw");

        Birthday b2 = new Birthday();
        b2.setDate(new Date(2019,2,1));
        b2.setName("foo");

        Birthday b3 = new Birthday();
        b3.setDate(new Date(2029,2,1));
        b3.setName("isr");

        List<Birthday> list = new ArrayList<>();
        list.add(b1);list.add(b2);list.add(b3);
        Optional<Birthday> max = list.stream().max(Comparator.comparing(Birthday::getDate));
//        list.sort(Comparator.comparing(Birthday::getDate).reversed());
        System.out.println(JSON.toJSON(max));
    }
}
