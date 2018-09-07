package com.foo.test.producerAndConsumer;

import com.foo.test.producerAndConsumer.ProducerAndConsumer;
import com.foo.test.producerAndConsumer.blocking.BlockingQueueProducerAndConsumer;
import com.foo.test.producerAndConsumer.wait.WaitLockProducerAndConsumer;

/**
 * @author jiangwang3
 * @date 2018/9/7.
 */
public class Main {
    public static void main(String[] args) {
//        ProducerAndConsumer producerAndConsumer = new WaitProducerAndConsumer();
//        ProducerAndConsumer producerAndConsumer = new WaitLockProducerAndConsumer();
        ProducerAndConsumer producerAndConsumer = new BlockingQueueProducerAndConsumer();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    producerAndConsumer.produce();
                }
            }, "生产者--" + i).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    producerAndConsumer.consume();
                }
            }, "消费者" + i).start();
        }

    }
}
