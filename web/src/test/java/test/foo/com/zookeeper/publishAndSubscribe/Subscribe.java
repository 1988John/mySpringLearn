package test.foo.com.zookeeper.publishAndSubscribe;

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

    public static void main(String[] args) {
        try {
            String path  ="/zookeeper";
            zk =  new ZooKeeper("127.0.0.1:2181",SESSION_TIMEOUT,new Subscribe());
            latch.await();
            System.out.println("zk connection");
            byte[]  temp = zk.getData(path,true,stat);
            System.out.println("init data :pulish node data"+new String(temp));
            int i=0;
            while(true){
                Thread.sleep(Integer.MAX_VALUE);
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
            if(Event.EventType.None == event.getType() && event.getPath() == null){
                latch.countDown();
            }else if(event.getType()  == Event.EventType.NodeDataChanged){
                //Clinet需要去拉取最新的数据信息
                try {
                    byte[] newByte = zk.getData(event.getPath(),true,stat);
                    System.out.println("path:"+event.getPath()+"\tdata has changed.\t new Data :"+ new String(newByte));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}