package com.foo.service.transaction.isolation;

import com.alibaba.fastjson.JSON;
import com.foo.domain.user.User;
import com.foo.service.user.UserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/18.
 */
//@Service
public class IsolationService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @Resource
    private SqlSessionTemplate sqlTemplate;

    /**
     * @author jiangwang
     * 14:48 2018/4/18
     */
    @Transactional
    public User defaultLevel(String name){
        return userService.selectUserByName(name);
    }

    /**
     * @author jiangwang
     * 14:48 2018/4/18
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public User readUncommitted(String name){
        return userService.selectUserByName(name);
    }

    /**
     * @author jiangwang
     * 14:48 2018/4/18
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User readCommitted(String name, Long second){
        return read(name,second);
    }

    /**
     * @author jiangwang
     * 14:48 2018/4/18
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User repeatableRead(String pin, Long second){
        return read(pin,second);
    }

    /**
     * @author jiangwang
     * 14:48 2018/4/18
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int phantom(Long second){
        return phantomRead(second);
    }

    /**
     * @author jiangwang
     * 14:48 2018/4/18
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int serializable(Long second){
        return phantomRead(second);
    }

    /**
     * @author jiangwang
     * 14:48 2018/4/18
     */
    public void insert(String pin, Long second){
        insertEntry(pin,second);
    }

    /**
     * @author jiangwang
     * 16:02 2018/4/18
     */
    private User read(String name, Long second){
        User user1 = userService.selectUserByName(name);
        SqlSessionUtils.getSqlSession(sqlTemplate.getSqlSessionFactory()).clearCache();
        logger.error("第一次读取：{}",JSON.toJSONString(user1));
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user2 = userService.selectUserByName(name);
        logger.error("第二次读取：{}",JSON.toJSONString(user2));
        return user2;
    }

    private int phantomRead(Long second){
        int count1 = userService.selectCount();
        SqlSessionUtils.getSqlSession(sqlTemplate.getSqlSessionFactory()).clearCache();
        logger.error("第一次读取,总条数：{}",JSON.toJSONString(count1));
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count2 = userService.selectCount();
        logger.error("第二次读取，总条数：{}",JSON.toJSONString(count2));
        return count2;
    }


    /**
     * @author jiangwang
     * 16:02 2018/4/18
     */
    private void insertEntry(String name, Long second){
        userService.insert(name);
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Assert.notNull(null, "'annotationType' must not be null");
    }

}
