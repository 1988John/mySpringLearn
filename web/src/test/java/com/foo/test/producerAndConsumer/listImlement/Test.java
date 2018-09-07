package com.foo.test.producerAndConsumer.listImlement;

public class Test {
    public static void main(String[] args)
    {
        Storage storage=new Storage();

        for(int i=1;i<6;i++)
        {
            int finalI = i;
            new Thread(()-> storage.produce(String.format("生成者%d:", finalI))).start();
        }

        for(int i=1;i<4;i++)
        {
            int finalI = i;
            new Thread(()-> storage.consume(String.format("消费者%d:", finalI))).start();
        }
    }
}