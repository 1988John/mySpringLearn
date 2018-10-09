package com.foo.service.user.impl;

import com.foo.dao.user.UserDao;
import com.foo.domain.user.User;
import com.foo.service.annotation.PrintTime;
import com.foo.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiangwang
 * @date 11:34 2018/5/14
 */
@Service
public class UserServiceImpl implements UserService{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private UserDao userDao;

    @Override
    public int insert(String name){
        User user = new User();
        user.setName(name);
        return userDao.insertEntry(user);
    }

    @Override
    public User queryByName(String name){
        User user = new User();
        user.setName(name);
        return userDao.selectEntryByName(user);
    }

    public int selectCount(){
        return userDao.selectCount();
    }

    public void addUser(){
        logger.info("UserServiceImpl-addUser:添加一个用户");
    }

    @PrintTime
    public String serviceAspect(){
        logger.info("Service层---测试切面");
        return "serviceAspect";
    }
}
