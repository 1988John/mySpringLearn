package com.foo.test.base;

/**
 * @author Fooisart
 * Created on 07-01-2019
 */
public class EnumTest {
    public static void main(String[] args) {
        FeedbackOrderTransferTarget bj = FeedbackOrderTransferTarget.getTargetByAlias("photoAudit");
        System.out.println(bj);

    }
}
