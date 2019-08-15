package com.foo.test.volatileTest;

/**
 * @author fooisart
 * @date 15:16 09-08-2019
 */
public class VolatileTest {
    private static volatile int COUNTER = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int threadValue = COUNTER;
            while (threadValue < 5) {
                if (threadValue != COUNTER) {
                    System.out.println("Got Change for COUNTER :" + COUNTER + "");
                    threadValue = COUNTER;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int threadValue = COUNTER;
            while (COUNTER < 5) {
                System.out.println("Incrementing COUNTER to : " + (threadValue + 1) + "" );
                COUNTER = ++ threadValue;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
