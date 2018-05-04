package test.foo.com.zookeeper.publishAndSubscribe;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;  
import org.apache.zookeeper.Watcher;  
import org.apache.zookeeper.ZooDefs.Ids;  
import org.apache.zookeeper.ZooKeeper;  
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class Provider {

    public static void main(String[] args) throws Exception {
        Watcher watcher = new Watcher() {
            @Override  
            public void process(WatchedEvent event) {  
                System.out.println("触发了" + event.getPath() + "的" + event.getType() + "事件！");                  
            }  
        };  
          
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, watcher);
        Stat stat = zk.exists("/message", watcher);
        if (stat == null) {             //假如节点不存在，则先创建节点  
            zk.create("/message", "hello".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }  
          
        //向该节点发送消息  
        zk.setData("/message", "hello world".getBytes(), -1);  
          
          
        zk.close();  
    }  
}  