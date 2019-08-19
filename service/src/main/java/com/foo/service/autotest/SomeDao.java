package com.foo.service.autotest;

import org.springframework.stereotype.Repository;

/**
 * @author fooisart
 * @date 15:18 15-08-2019
 */
@Repository
public class SomeDao {
    public String getName() {
        return "fooisart from dao";
    }
}
