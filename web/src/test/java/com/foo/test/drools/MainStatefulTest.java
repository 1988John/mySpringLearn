package com.foo.test.drools;

import com.alibaba.fastjson.JSON;
import com.foo.test.drools.domain.Fire;
import com.foo.test.drools.domain.Room;
import com.foo.test.drools.domain.Sprinkler;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangwang3
 * @date 2018/7/31.
 */
public class MainStatefulTest {

    public static void main(String[] args) {
        StatefulKnowledgeSession ksession = getStatefulSession();
        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};

        Map<String,Room> name2room = new HashMap<>();

        for( String name: names ){

            Room room = new Room( name );
            name2room.put( name, room );
            ksession.insert( room );

            Sprinkler sprinkler = new Sprinkler( room );
            System.out.println(JSON.toJSONString(sprinkler));
            ksession.insert( sprinkler );
        }

        ksession.fireAllRules();

        System.err.println("==========1-over============");

        Fire kitchenFire = new Fire( name2room.get( "kitchen" ) );
        Fire officeFire = new Fire( name2room.get( "office" ) );

        FactHandle kitchenFireHandle = ksession.insert( kitchenFire );
        FactHandle officeFireHandle = ksession.insert( officeFire );
//
//        ksession.fireAllRules();
//        System.err.println("==========2-over============");
//
//
//        ksession.retract( kitchenFireHandle );
//        ksession.retract( officeFireHandle );
//
//        ksession.fireAllRules();
//        System.err.println("==========3-over============");
    }

    private static StatefulKnowledgeSession getStatefulSession() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        kbuilder.add( ResourceFactory.newClassPathResource( "rules/fireAlarm.drl", MainStatefulTest.class ),

                ResourceType.DRL );

        if ( kbuilder.hasErrors() ) {

            System.err.println( kbuilder.getErrors().toString() );

        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();

        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

        return kbase.newStatefulKnowledgeSession();
    }
}
