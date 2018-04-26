package com.foo.service.user;

import com.foo.dao.user.UserDao;
import com.foo.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/20.
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public int insert(String name){
        User user = new User();
        user.setName(name);
        return userDao.insertEntry(user);
    }

    public int selectCount(){
        return userDao.selectCount();
    }

    public User selectUserByName(String name){
        User user = new User();
        user.setName(name);
        return userDao.selectEntryByName(user);
    }
}
