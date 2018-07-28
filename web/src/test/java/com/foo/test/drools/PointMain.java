//package com.foo.test.drools;
//
//import com.foo.test.drools.domain.PointDomain;
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
///**
// * @author jiangwang3
// * @date 2018/7/25.
// */
//public class PointMain {
//
//    public static void main(String[] args) {
//        try {
//
//            System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
//            KieServices kieServices = KieServices.Factory.get(); // 通过这个静态方法去获取一个实例
//            KieContainer kieContainer = kieServices.getKieClasspathContainer();// 默认去读取配置文件
//            KieSession kieSession = kieContainer.newKieSession("all-rules");// 根据这个名词去获取kieSession
//
//            final PointDomain pointDomain = new PointDomain();
//            pointDomain.setUserName("hello kity");
//            pointDomain.setBackMondy(100d);
//            pointDomain.setBuyMoney(500d);
//            pointDomain.setBackNums(1);
//            pointDomain.setBuyNums(5);
//            pointDomain.setBillThisMonth(5);
//            pointDomain.setBirthDay(true);
//            pointDomain.setPoint(0L);
//
//            kieSession.insert(pointDomain);
//
//            kieSession.fireAllRules();
//
//            kieSession.dispose();// 关闭session
//
//            System.out.println("执行完毕BillThisMonth："+pointDomain.getBillThisMonth());
//            System.out.println("执行完毕BuyMoney："+pointDomain.getBuyMoney());
//            System.out.println("执行完毕BuyNums："+pointDomain.getBuyNums());
//
//            System.out.println("执行完毕规则引擎决定发送积分："+pointDomain.getPoint());
//
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
//    }
//
//}
