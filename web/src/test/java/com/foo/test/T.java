package com.foo.test;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_HYPHEN;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
        String value = "mysql_id";
//        String to = UPPER_UNDERSCORE.to(UPPER_CAMEL, value);
        System.out.println(value.replace("_", ""));


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        map.forEach((k, v) -> map.put(k.toUpperCase(), map.remove(k)));
        System.out.println(map);
    }

}
