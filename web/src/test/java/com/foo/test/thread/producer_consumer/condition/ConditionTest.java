package com.foo.test.thread.producer_consumer.condition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangwang
 * @date 2021-03-13 18:33
 */
public class ConditionTest {
    private Lock lock = new ReentrantLock();
    private Map<String, Condition> conditionMap = new HashMap<>();
    private Map<String, Integer> numMap = new HashMap<>();
    private Map<String, String> currentAndNextNameMap = new HashMap<>();
    private List<String> threadNames = new ArrayList<>();

    public void print(String str, String next) {
        lock.lock();
        try {
            while (numMap.get(str) <= 0) {
                conditionMap.get(str).await();
            }
            numMap.put(next, 1);
            numMap.put(str, 0);
            System.out.println(str);
            conditionMap.get(next).signal();
        } catch (InterruptedException e) {
            //打印异常
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        List<String> threadNameList = new ArrayList<>();
        threadNameList.add("A");
        threadNameList.add("B");
        threadNameList.add("C");
        conditionTest.setThreadNames(threadNameList);

        for (int i = 0; i < threadNameList.size(); i++) {
            new Thread(new PrintThread(conditionTest), threadNameList.get(i)).start();
        }

    }

    public Map<String, Condition> getConditionMap() {
        return conditionMap;
    }

    private void buildParamMap() {
        for (int i = 0; i < threadNames.size(); i++) {
            conditionMap.put(threadNames.get(i), lock.newCondition());
            numMap.put(threadNames.get(i), i == 0 ? 1 : 0);
            if (i == threadNames.size() - 1) {
                currentAndNextNameMap.put(threadNames.get(i), threadNames.get(0));
            } else {
                currentAndNextNameMap.put(threadNames.get(i), threadNames.get(i + 1));
            }
        }
    }

    public void setThreadNames(List<String> threadNames) {
        this.threadNames = threadNames;
        buildParamMap();
    }

    public Map<String, String> getCurrentAndNextNameMap() {
        return currentAndNextNameMap;
    }

}
