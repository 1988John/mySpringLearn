package com.foo.test.zookeeper.publishAndSubscribe;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 利用zk来模拟发布订阅模式
 * Created by peirong.wpr on 2017/4/5.
 */
public class Publish implements Watcher{
    private static CountDownLatch latch =  new CountDownLatch(1);
    private final static Integer  SESSION_TIMEOUT = 5000;

    public static void main(String[] args) {
        try {
            String path  ="/jiangwang";
            ZooKeeper zk =  new ZooKeeper("127.0.0.1:2181",SESSION_TIMEOUT,new Publish());
            latch.await();
            System.out.println("zk connection");
            Stat stat = zk.exists(path, new Publish());
            if (stat == null) {             //假如节点不存在，则先创建节点
                zk.create(path, "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            byte[]  temp = zk.getData(path,true,stat);
            System.out.println("init data :pulish node data"+new String(temp));
            int i=0;
            while(true){
                System.out.println( "publish new Data:"+i);
                zk.setData(path,String.valueOf(i).getBytes(),-1);
                Thread.sleep(5000L);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()){
            System.out.println("receive watched event:"+event);
            System.out.println(event.getState());
            latch.countDown();
        }
    }
}