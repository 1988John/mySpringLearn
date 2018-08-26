package com.foo.test.redis.mq;

import com.foo.common.utils.RedisUtil;
import redis.clients.jedis.Jedis;
 
public class RedisProducer {
    private static RedisUtil redisUtil = new RedisUtil();
 
    /** 
     * jedis操作List 
     */  
    public static void main(String[] args){
 
        Jedis jedis = redisUtil.getJedis();
        for(int i = 0;i<50;i++) {
            jedis.lpush("informList","value_" + i);  
        }
        jedis.close();
    }
 
}
