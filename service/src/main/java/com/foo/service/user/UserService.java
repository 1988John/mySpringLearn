package com.foo.service.user;

import com.foo.domain.user.User;

/**
 * @author jiangwang
 * @date 11:34 2018/5/14
 */
//@Service
public interface UserService {
    int insert(String name);

    User queryByName(String name);
}
