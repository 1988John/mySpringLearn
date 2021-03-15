package com.foo.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author jiangwang
 * @date 2021-03-14 11:55
 */
public class SemaphorePrintAbc {
    private List<String> threadNames;
    private List<Semaphore> semaphoreList = new ArrayList<>();

    public SemaphorePrintAbc(List<String> threadNames) throws InterruptedException {
        this.threadNames = threadNames;
        for (int i = 0; i < threadNames.size(); i++) {
            Semaphore semaphore = new Semaphore(1);
            this.semaphoreList.add(semaphore);
            if (i > 0) {
                semaphore.acquire();
            }
        }
    }

    public void print(int semaphoreIndex) throws InterruptedException {
        semaphoreList.get(semaphoreIndex).acquire();
        int nextIndex = semaphoreIndex + 1;
        if (semaphoreIndex == threadNames.size() - 1) {
            nextIndex = 0;
        }
        System.out.println(threadNames.get(semaphoreIndex));
        semaphoreList.get(nextIndex).release();


    }

    public static void main(String[] args) throws InterruptedException {
        List<String> threadNames = new ArrayList<>();
        threadNames.add("A");
        threadNames.add("B");
        threadNames.add("C");
        SemaphorePrintAbc semaphorePrintAbc = new SemaphorePrintAbc(threadNames);
        for (int i = 0; i < threadNames.size(); i++) {
            String currentName = threadNames.get(i);
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    try {
                        semaphorePrintAbc.print(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, currentName).start();
        }
    }
}
