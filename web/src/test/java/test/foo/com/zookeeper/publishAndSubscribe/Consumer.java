package test.foo.com.zookeeper.publishAndSubscribe;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;  
import org.apache.zookeeper.Watcher;  
import org.apache.zookeeper.Watcher.Event.EventType;  
import org.apache.zookeeper.ZooKeeper;  
  
public class Consumer implements Watcher{  
    ZooKeeper zk;  
    String hostPort;  
    String znode;  
      
    public Consumer(String hostPort,String znode) throws Exception{  
        this.hostPort = hostPort;  
        this.znode = znode;  
          
        zk = new ZooKeeper(hostPort, 3000, this);  
        //第一次获取节点消息，同时添加watcher  
        System.out.println("消息内容：" + new String(zk.getData(znode, true, null)));  
    }  
      
    @Override  
    public void process(WatchedEvent event) {  
        if (event.getType() == EventType.NodeDataChanged) {  
            try {  
                //当节点消息变化时，触发该操作：获取变化后的消息，同时再添加watcher  
                System.out.println("你有新的消息:" + new String(zk.getData("/message", true, null)));  
                  
            } catch (KeeperException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
      
    public static void main(String[] args) throws Exception {  
        new Consumer("127.0.0.1:2181","/message");
  
        System.in.read();  
    }  
  
  
      
}  