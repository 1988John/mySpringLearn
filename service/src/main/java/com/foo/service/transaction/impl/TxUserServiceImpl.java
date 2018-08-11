package com.foo.service.transaction.impl;

import com.alibaba.fastjson.JSON;
import com.foo.dao.user.UserDao;
import com.foo.domain.user.User;
import com.foo.service.transaction.TxUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jiangwang3
 * @date 2018/8/10.
 */
@Service
public class TxUserServiceImpl implements TxUserService{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserDao userDao;

//    @Transactional
    public void insert(String name){
        User user = new User();
        user.setName(name);

        int i = userDao.insertEntry(user);
        logger.error("插入用户：{},结果：{}", JSON.toJSONString(user),i);

//        throw new RuntimeException();
    }
}
