package com.foo.test.zookeeper.publishAndSubscribe;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by peirong.wpr on 2017/4/5.
 */
public class Subscribe  implements Watcher {
    private static CountDownLatch latch =  new CountDownLatch(1);
    private static Stat stat = new Stat();
    private static ZooKeeper zk =null;
    private final static Integer  SESSION_TIMEOUT = 5000;
    private static final String PATH = "/path1";
    private static final String CONNECT_STRING = "127.0.0.1:2181";

    public static void main(String[] args) {
        try {
            zk =  new ZooKeeper(CONNECT_STRING,SESSION_TIMEOUT,new Subscribe());
            latch.await();
            System.out.println("zk connection");
            byte[]  temp = zk.getData(PATH,true,stat);
            System.out.println("init data :publish node data"+new String(temp));
            int i=0;
            while(true){
                Thread.sleep(Integer.MAX_VALUE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()){
            if(Event.EventType.None == event.getType() && event.getPath() == null){
                latch.countDown();
            }else if(event.getType()  == Event.EventType.NodeDataChanged){
                //Clinet需要去拉取最新的数据信息
                try {
                    byte[] newByte = zk.getData(event.getPath(),true,stat);
                    System.out.println("path:"+event.getPath()+"\tdata has changed.\t new Data :"+ new String(newByte));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}