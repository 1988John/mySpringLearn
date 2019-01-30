package com.foo.test.base.java8;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author Fooisart
 * @date 17:51 17-01-2019
 */
public class ConsumerDemo {
    public static void main1(String[] args) {
        String str = "abc";

        doSomething(str, new Consumer<String>() {
            @Override
            public void accept(String s) {
                doAccept(s);
            }
        });

        doSomething(str, ConsumerDemo -> doAccept(str));

        doSomething(str, ConsumerDemo::doAccept);

        doSomething("abc", getConsumer());
    }

    public static void doSomething(String t, Consumer<String> consumer) {
        consumer.accept(t);
    }

    public static void doAccept(String str){
        System.out.println(str.toUpperCase());
    }

    public static Consumer<String> getConsumer(){
        String str = "fdsfdsf";
        return s -> doAccept(s);
    }

    public static void main(String[] args) {
        long time = 1538055640000L;
        int delay = (int) TimeUnit.MILLISECONDS.toMinutes(
                System.currentTimeMillis() - time);
        System.out.println(delay);

        System.out.println(renderLatency(delay));

    }

    public static String renderLatency(long time) {
        String latency = "";
        long now = System.currentTimeMillis();
        if (time <= 0 || time >= now) {
            return "0分钟";
        }
        long minutes = (now - time) / TimeUnit.MINUTES.toMillis(1);
        long hours = minutes / TimeUnit.HOURS.toMinutes(1);
        if (hours > 0) {
            latency = hours + "小时";
        }
        latency = latency + (minutes % TimeUnit.HOURS.toMinutes(1)) + "分钟";
        return latency;
    }
}
