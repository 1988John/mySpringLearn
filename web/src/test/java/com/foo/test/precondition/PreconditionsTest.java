package com.foo.test.precondition;

import com.foo.test.base.comparation.User;
import com.google.common.base.Preconditions;

/**
 * @author Fooisart
 * @date 11:04 06-03-2019
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        User user = null;
        User user1 = Preconditions.checkNotNull(user, "不为空");
    }
}
