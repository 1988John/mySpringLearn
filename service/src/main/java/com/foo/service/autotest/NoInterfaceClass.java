package com.foo.service.autotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fooisart
 * @date 15:18 15-08-2019
 */
@Service
public class NoInterfaceClass {
    @Autowired
    private SomeDao dao;

    public String getName() {
        return dao.getName();
    }
}
