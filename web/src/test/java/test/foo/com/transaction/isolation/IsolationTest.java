package test.foo.com.transaction.isolation;

import com.foo.service.transaction.isolation.IsolationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Description: 事物 隔离级别测试
 * Created by jiangwang3 on 2018/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public class IsolationTest {
    @Resource
    private IsolationService isolationService;

    @Test
    public void readUncommittedTest(){
        isolationService.readUncommitted("foo");
    }
}
