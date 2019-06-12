package com.foo.test;

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
        System.out.println(String.format(DEDUCT_LOG, 1L, 2, 3));
    }
}
