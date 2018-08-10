package com.foo.test.drools;

import com.alibaba.fastjson.JSON;
import com.foo.domain.user.Product;
import com.foo.service.drools.SimpleService;
import com.foo.service.drools.StateFulService;
import com.foo.test.drools.domain.Fire;
import com.foo.test.drools.domain.Room;
import com.foo.test.drools.domain.Sprinkler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangwang
 * 10:59 2018/4/26
 */
public class StatefulDroolsTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testProxy() throws Throwable {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/stateful-drools.xml");
        StateFulService stateFulService = (StateFulService)ac.getBean("stateFulService");


        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};

        Map<String,Room> name2room = new HashMap<>();

        for( String name: names ){

            Room room = new Room(name);

            name2room.put( name, room );

            stateFulService.CalculateDiscount(room);

            Sprinkler sprinkler = new Sprinkler(room);

            stateFulService.CalculateDiscount(sprinkler);
        }

        Fire kitchenFire = new Fire( name2room.get( "kitchen" ) );

        Fire officeFire = new Fire( name2room.get( "office" ) );

        stateFulService.CalculateDiscount(kitchenFire);

        stateFulService.CalculateDiscount(officeFire);


    }
}  