package com.foo.test.thread.producer_consumer.condition;

/**
 * @author jiangwang
 * @date 2021-03-03 18:46
 */
public class ProduceCondition implements Runnable{
    private ResourceCondition resource;

    public ProduceCondition(ResourceCondition resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.increase();
        }
    }
}
