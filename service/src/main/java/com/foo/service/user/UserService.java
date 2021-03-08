package com.foo.service.user;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.foo.dao.user.UserDao;
import com.foo.domain.user.User;
import com.foo.service.annotation.PrintTime;

/**
 * @author jiangwang
 * @date 11:34 2018/5/14
 */
//@Service
public class UserService implements InitializingBean {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private UserDao userDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("执行-InitializingBean-UserService");
    }

    public int insert(String name){
        User user = new User();
        user.setName(name);
        return userDao.insertEntry(user);
    }

    public int selectCount(){
        return userDao.selectCount();
    }

    public void addUser(){
        logger.info("UserService-addUser:添加一个用户");
    }

    public User selectUserByName(String name){
        User user = new User();
        user.setName(name);
        return userDao.selectEntryByName(user);
    }

    @PrintTime
    public String serviceAspect(){
        logger.info("Service层---测试切面");
        return "serviceAspect";
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
