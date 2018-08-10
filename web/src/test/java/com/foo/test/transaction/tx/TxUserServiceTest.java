package com.foo.test.transaction.tx;

import com.foo.service.transaction.TxUserService;
import com.foo.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author jiangwang3
 * @date 2018/8/10.
 */
public class TxUserServiceTest extends BaseTest{
    @Resource
    private TxUserService txUserService;
    @Test
    public void insert() throws Exception {
        txUserService.insert("foo");
    }

}