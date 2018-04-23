package test.foo.com.dao;

import com.foo.dao.user.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public class UserDaoTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private UserDao userDao;

    @Test
    public void test(){
//        int count = userDao.selectCount();
//        logger.error("结果：{}",count);
    }
}

