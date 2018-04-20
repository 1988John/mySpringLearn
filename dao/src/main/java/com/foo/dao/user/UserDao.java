package com.foo.dao.user;

import com.foo.dao.repository.MyBatisRepository;
import com.foo.domain.user.User;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/20.
 */
@MyBatisRepository
public interface UserDao {
    int insertEntry(User user);
    User selectEntryByName(String name);
    int selectCount();
}
