package test.foo.com.autoBox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiangwang on 4/26/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public class NumberTest {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Test
    public void autoBoxTest(){
        Integer integer1 = new Integer(2);
        Integer integer2 = new Integer(2);
        LOGGER.error("结果,{}",integer1 == integer2);
    }
}
