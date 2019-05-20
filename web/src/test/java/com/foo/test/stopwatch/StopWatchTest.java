package com.foo.test.stopwatch;

import com.ecyrd.speed4j.StopWatch;

/**
 * @author fooisart
 * @date 14:52 09-05-2019
 */
public class StopWatchTest {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        long elapsedTime = stopWatch.getElapsedTime();
        long timeMicros = stopWatch.getTimeMicros();
    }
}
