//package com.foo.test.drools.spring.service;
//
//import com.foo.test.drools.spring.domain.Fare;
//import com.foo.test.drools.spring.domain.TaxiRide;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TaxiFareCalculatorService {
//
//    @Autowired
//    private KieContainer kieContainer;
//
//    public Long calculateFare(TaxiRide taxiRide, Fare rideFare) {
//        KieSession kieSession = kieContainer.newKieSession();
//        kieSession.setGlobal("rideFare", rideFare);
//        kieSession.insert(taxiRide);
//        kieSession.fireAllRules();
//        kieSession.dispose();
//        return rideFare.getRideFare();
//    }
//}