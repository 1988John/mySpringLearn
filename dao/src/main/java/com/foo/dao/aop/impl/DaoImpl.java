package com.foo.dao.aop.impl;

import com.foo.dao.aop.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoImpl implements Dao {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String myName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    @Override
    public void select() {
        logger.error("Enter DaoImpl.select()");
    }

    @Override
    public void insert() {
        logger.error("Enter DaoImpl.insert()");
    }
    
}