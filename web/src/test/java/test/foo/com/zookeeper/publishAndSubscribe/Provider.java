package test.foo.com.zookeeper.publishAndSubscribe;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;  
import org.apache.zookeeper.Watcher;  
import org.apache.zookeeper.ZooDefs.Ids;  
import org.apache.zookeeper.ZooKeeper;  
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class Provider {
    private static CountDownLatch latch =  new CountDownLatch(1);
    public static void main(String[] args) throws Exception {

        Watcher watcher = new Watcher() {  
            @Override  
            public void process(WatchedEvent event) {  
                System.out.println("触发了" + event.getPath() + "的" + event.getType() + "事件！");                  
            }  
        };  
          
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 20, watcher);
//        CountDownLatch connectedLatch = new CountDownLatch(1);
//        if (ZooKeeper.States.CONNECTING == zk.getState()) {
//            try {
//                connectedLatch.await();
//            } catch (InterruptedException e) {
//                throw new IllegalStateException(e);
//            }
//        }
        Stat stat = zk.exists("/message3", watcher);
        if (stat == null) {             //假如节点不存在，则先创建节点  
            zk.create("/message3", "hello".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }  
          
        //向该节点发送消息  
        zk.setData("/message", "hello world".getBytes(), -1);  
          
          
        zk.close();  
    }  
}  