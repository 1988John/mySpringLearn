package com.foo.test.disruptor.park;

import java.util.concurrent.CountDownLatch;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

public class InParkingDataEventPublisher implements Runnable {
    Disruptor<InParkingDataEvent> disruptor;
    private CountDownLatch latch;
    //private static int LOOP=10000;//模拟一万车辆入场
    private static int LOOP = 10;//模拟10车辆入场


    public InParkingDataEventPublisher(CountDownLatch latch, Disruptor<InParkingDataEvent> disruptor) {
        this.disruptor = disruptor;
        this.latch = latch;
    }

    @Override
    public void run() {
        InParkingDataEventTranslator tradeTransloator = new InParkingDataEventTranslator();
        for (int i = 0; i < LOOP; i++) {

            disruptor.publishEvent(tradeTransloator);
            try {
                Thread.currentThread().sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        latch.countDown();
        System.out.println("生产者写完" + LOOP + "个消息");
    }

}

class InParkingDataEventTranslator implements EventTranslator<InParkingDataEvent> {

    @Override
    public void translateTo(InParkingDataEvent event, long sequence) {
        this.generateTradeTransaction(event);
    }

    private InParkingDataEvent generateTradeTransaction(InParkingDataEvent event) {
        int num = (int) (Math.random() * 8000);
        num = num + 1000;
        event.setCarLicense("京Z" + num);
        System.out.println("Thread Id " + Thread.currentThread().getId() + " 写完一个event");
        return event;
    }
}