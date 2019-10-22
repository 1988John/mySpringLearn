package com.foo.test.drools;

import org.kie.api.KieServices;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.foo.test.drools.domain.Person;

public class Test {
    static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();

        KieContainer kc = ks.getKieClasspathContainer();

        return kc.newKieSession("simpleRuleKSession");
    }

    public static void main(String[] args) {
        KieSession ks = getSession();
        ks.addEventListener(new RuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent objectInsertedEvent) {
//                System.out.println("插入");
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent objectUpdatedEvent) {
//                System.out.println("更新");
            }

            @Override
            public void objectDeleted(ObjectDeletedEvent objectDeletedEvent) {
//                System.out.println("删除");
            }
        });

        Person p1 = new Person("白展堂", 68);
        Person p2 = new Person("李大嘴", 32);
        Person p3 = new Person("佟湘玉", 18);
        Person p4 = new Person("郭芙蓉", 8);

        ks.insert(p1);
        ks.insert(p2);
        ks.insert(p3);
        ks.insert(p4);

        int count = ks.fireAllRules();
        System.out.println("1-总执行了" + count + "条规则");
        System.out.println("2-总执行了" + ks.fireAllRules() + "条规则");
        ks.dispose();
    }
}