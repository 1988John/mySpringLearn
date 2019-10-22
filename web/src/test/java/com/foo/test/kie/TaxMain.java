//package com.foo.test.kie;
//
//import java.math.BigDecimal;
//
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
//import com.foo.test.drools.domain.ItemCity;
//
//
///**
// * @author jiangwang3
// * @date 2018/7/25.
// */
//public class TaxMain {
//
//    public static void main(String[] args) {
//        try {
//
//            KieServices kieServices = KieServices.Factory.get(); // 通过这个静态方法去获取一个实例
//            KieContainer kieContainer = kieServices.getKieClasspathContainer();// 默认去读取配置文件
//            KieSession kieSession = kieContainer.newKieSession("all-rules");// 根据这个名词去获取kieSession
//
//            ItemCity item1 = new ItemCity();
//            item1.setPurchaseCity(ItemCity.City.PUNE);
//            item1.setTypeofItem(ItemCity.Type.MEDICINES);
//            item1.setSellPrice(new BigDecimal(10));
//            kieSession.insert(item1);
//
//            ItemCity item2 = new ItemCity();
//            item2.setPurchaseCity(ItemCity.City.PUNE);
//            item2.setTypeofItem(ItemCity.Type.GROCERIES);
//            item2.setSellPrice(new BigDecimal(10));
//            kieSession.insert(item2);
//
//            ItemCity item3 = new ItemCity();
//            item3.setPurchaseCity(ItemCity.City.NAGPUR);
//            item3.setTypeofItem(ItemCity.Type.MEDICINES);
//            item3.setSellPrice(new BigDecimal(10));
//            kieSession.insert(item3);
//
//            ItemCity item4 = new ItemCity();
//            item4.setPurchaseCity(ItemCity.City.NAGPUR);
//            item4.setTypeofItem(ItemCity.Type.GROCERIES);
//            item4.setSellPrice(new BigDecimal(10));
//            kieSession.insert(item4);
//
//            kieSession.fireAllRules();
//
//            kieSession.dispose();// 关闭session
//
//            System.out.println(item1.getPurchaseCity().toString() + " "
//                    + item1.getLocalTax().intValue());
//
//            System.out.println(item2.getPurchaseCity().toString() + " "
//                    + item2.getLocalTax().intValue());
//
//            System.out.println(item3.getPurchaseCity().toString() + " "
//                    + item3.getLocalTax().intValue());
//
//            System.out.println(item4.getPurchaseCity().toString() + " "
//                    + item4.getLocalTax().intValue());
//
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
//    }
//
//}
