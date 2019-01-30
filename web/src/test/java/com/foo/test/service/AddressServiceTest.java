package com.foo.test.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.foo.domain.user.Address;
import com.foo.service.user.AddressService;
import com.foo.test.BaseTest;

/**
 * @author Fooisart
 * @date 11:06 30-01-2019
 */
public class AddressServiceTest extends BaseTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void getAddressById() {
        Address address = addressService.getAddressById(1);
        logger.error("结果==》{}",JSON.toJSON(address));
    }
}