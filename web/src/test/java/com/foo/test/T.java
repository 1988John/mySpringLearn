package com.foo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * @author fooisart
 * @date 18:29 11-06-2019
 */
public class T {
    private static final String DEDUCT_LOG = "扣除用户[%d]所有[%d]豆[%d]钻";
    private static final String CREATE_REFUND_LOG = "[%d]创建了热线退款单[%d]";
    private static final String RESUBMIT_WARN = "用户[%d]在[%s]已经提交过退款单";
    private static final String WITHOUT_FUND_WARN = "用户[%d]在[%s]无可退金额";

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("a",1);
        map.put("b",1);
        map.put("c",1);
        map.put("d",1);
        map.put("e",1);
        Set<String> keySet = map.keySet();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("a",1);
        map1.put("b",1);
        map1.put("d",1);
        Set<String> keySet1 = map1.keySet();

        Set<String> differenceSet = Sets.difference(keySet, keySet1);
        System.out.println(differenceSet);
        System.out.println(differenceSet.contains("c"));
    }
}
