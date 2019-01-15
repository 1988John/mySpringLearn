package com.foo.test.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行
 * 每天中午12点都执行一次
 *
 * @author Fooisart
 * Created on 21:46 14-01-2019
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);//控制小时
        calendar.set(Calendar.MINUTE, 0);//控制分钟
        calendar.set(Calendar.SECOND, 0);//控制秒
        Date time = calendar.getTime();//执行任务时间为12:00:00

        //每天定时12:00执行操作，每隔2秒执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "执行任务。。。");
            }
        }, time, 1000 * 2);
    }
}