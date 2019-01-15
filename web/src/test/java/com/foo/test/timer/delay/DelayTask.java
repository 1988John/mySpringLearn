package com.foo.test.timer.delay;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayTask implements Delayed {

    private Date startDate  = new Date();

    public DelayTask(Long delayMillions) {
        this.startDate.setTime(new Date().getTime() + delayMillions);
    }

    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS)
                - o.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }
}