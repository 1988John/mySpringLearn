package com.foo.test.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author jiangwang
 * @date 2021-03-15 17:30
 */
public class Noticer implements Callback {
    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        System.out.println("callback执行，metadata==>" + metadata + ",e:" + exception);

    }
}
