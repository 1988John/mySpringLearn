package com.foo.service.transaction;

import com.foo.domain.user.User;

/**
 * @author jiangwang3
 * @date 2018/8/10.
 */
public interface TxOtherUserService {

    void insert(String name);

    int update(User user);
}
