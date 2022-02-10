package com.mr.demolock.redis;


import com.mr.demolock.common.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加
     *
     * @param key
     * @return
     */

   public void setKey(String key,Object value){
       redisTemplate.opsForValue().set(key,value);
   }

    public Object getKey(String key){
        Object o = redisTemplate.opsForValue().get(key);
        return o;
    }

    /**
     * 分布式锁
     * param 通过connection去操作Redis
     * @return
     */
    public Boolean setKeyLock(String key,String value,TimeUnit unit,long time){
       //获取connection对象
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        Boolean isLock = connection.set(key.getBytes(), value.getBytes(), Expiration.from(time, unit), RedisStringCommands.SetOption.ifAbsent());
        return isLock;
    }

    public void closeLock(String key,String value,Boolean isLock){
        //判断isLock是否为true
        if(isLock){
            String key1 = (String) getKey(key);
            if (!StringUtils.isEmpty(key1)&&key1.equals(value)){
                redisTemplate.delete(key);
            }
        }
    }
}
