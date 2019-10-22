//package com.foo.test.kie;
//
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
//import com.foo.test.drools.domain.Car;
//import com.foo.test.drools.domain.Person;
//
///**
// * @author jiangwang3
// * @date 2018/7/25.
// */
//public class Main {
//
//    public static void main(String[] args) {
//        KieServices kieServices = KieServices.Factory.get(); // 通过这个静态方法去获取一个实例
//        KieContainer kieContainer = kieServices.getKieClasspathContainer();// 默认去读取配置文件
//        KieSession kieSession = kieContainer.newKieSession("all-rules");// 根据这个名词去获取kieSession
//
//        Person p1 = new Person();
//        p1.setAge(20);
//        Car c1 = new Car();
//        c1.setPerson(p1);
//
//        Person p2 = new Person();
//        p2.setAge(70);
//        Car c2 = new Car();
//        c2.setPerson(p2);
//
//        kieSession.insert(c1); // 将c1实例放入到session中,
//        kieSession.insert(c2);
//
//        int count = kieSession.fireAllRules();// 开始执行规则,并获取执行了多少条规则
//
//        kieSession.dispose();// 关闭session
//
//        System.out.println("Fire " + count + " rule(s)!");
//        System.out.println("The discount of c1 is " + c1.getDiscount() + "%");
//        System.out.println("The discount of c2 is " + c2.getDiscount() + "%");
//    }
//}
