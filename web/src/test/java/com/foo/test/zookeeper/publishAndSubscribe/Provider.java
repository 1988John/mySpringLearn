package com.foo.test.zookeeper.publishAndSubscribe;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;  
import org.apache.zookeeper.Watcher;  
import org.apache.zookeeper.ZooDefs.Ids;  
import org.apache.zookeeper.ZooKeeper;  
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class Provider {

    private static final String PATH = "/path1";
    private static final String CONTENT = "contentfdsfsad1111";
    private static final String CONNECT_STRING = "127.0.0.1:2181";
    private static final int SESSION_TIMEOUT = 5000;

    public static void main(String[] args) throws Exception {
        Watcher watcher = new Watcher() {
            @Override  
            public void process(WatchedEvent event) {  
                System.out.println("触发了" + event.getPath() + "的" + event.getType() + "事件！");                  
            }  
        };  
          
        ZooKeeper zk = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, watcher);


        //为某一个节点设置监听



        Stat stat = zk.exists(PATH, watcher);
        if (stat == null) {             //假如节点不存在，则先创建节点  
            zk.create(PATH, CONTENT.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }else {
            //向该节点发送消息
            zk.setData(PATH, CONTENT.getBytes(), -1);
        }
          
        zk.close();
    }  
}  