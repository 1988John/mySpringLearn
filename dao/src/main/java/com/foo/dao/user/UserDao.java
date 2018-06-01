package com.foo.dao.user;

import com.foo.domain.user.User;

/**
 * @author jiangwang
 * @date 16:31 2018/5/24
 */
public interface UserDao {
    int insertEntry(User user);
    User selectEntryByName(User user);
    int selectCount();
}
