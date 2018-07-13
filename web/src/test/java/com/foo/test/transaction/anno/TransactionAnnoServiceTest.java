package com.foo.test.transaction.anno;

import com.foo.service.transaction.propagation.TransactionAnnoService;
import com.foo.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 * @author jiangwang3
 * @date 2018/7/10.
 */
public class TransactionAnnoServiceTest extends BaseTest{
    @Resource
    private TransactionAnnoService transactionAnnoService;

    @Test
    public void AnnoTest(){
        transactionAnnoService.defaultExecute();
    }


}
