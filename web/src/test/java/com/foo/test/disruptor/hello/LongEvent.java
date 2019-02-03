package com.foo.test.disruptor.hello;
/*
 * To get started with the Disruptor we are going to consider very simple and contrived example,
 * one that will pass a single long value from a producer to a consumer, where the consumer will simply print out the value.
 * Firstly we will define the Event that will carry the data.
 * 
 * @author Fooisart
 * @date 16:48 2019/2/2
 */
public class LongEvent {
    private long value;
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value; 
    } 
} 