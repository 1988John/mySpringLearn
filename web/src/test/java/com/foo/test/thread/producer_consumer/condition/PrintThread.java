package com.foo.test.thread.producer_consumer.condition;

import java.util.Map;

public class PrintThread implements Runnable{
        private ConditionTest conditionTest;

        public PrintThread(ConditionTest conditionTest) {
            this.conditionTest = conditionTest;
        }

        @Override
        public void run() {
            while (true) {
                String currentName = Thread.currentThread().getName();
                Map<String, String> currentAndNextNameMap = conditionTest.getCurrentAndNextNameMap();
                conditionTest.print(currentName, currentAndNextNameMap.get(currentName));
            }
        }
    }