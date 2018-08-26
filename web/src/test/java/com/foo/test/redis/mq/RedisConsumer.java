package com.foo.test.redis.mq;

import java.util.List;
import redis.clients.jedis.Jedis;
 
public class RedisConsumer {
 
    /** 
     * jedis操作List 
     */  
    public static void main(String[] args){
 
       ScheduleMQ mq = new ScheduleMQ();
       mq.start();
    }   
 
}
