package com.foo.test.redis.mq;

import com.foo.common.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

class ScheduleMQ extends Thread {

    @Override
    public void run() {
        while(true) {
            RedisUtil redisUtil = new RedisUtil();
            Jedis jedis = redisUtil.getJedis();
            //阻塞式brpop，List中无数据时阻塞
            //参数0表示一直阻塞下去，直到List出现数据
            List<String> list = jedis.brpop(0, "informList");
            for(String s : list) {
                System.out.println(s);
            }
            jedis.close();
 
        }
    }
}
