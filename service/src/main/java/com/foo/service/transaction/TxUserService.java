package com.foo.service.transaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiangwang3
 * @date 2018/8/10.
 */
public interface TxUserService {

    void insert(String name);
}
