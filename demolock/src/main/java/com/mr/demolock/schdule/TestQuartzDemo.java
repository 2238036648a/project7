package com.mr.demolock.schdule;

import com.mr.demolock.common.CommonConstants;
import com.mr.demolock.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TestQuartzDemo {

    public static void main(String[] args) {
         //singleThred();
        duplicationThred();
    }


    public static void singleThred(){
        long startTime = System.currentTimeMillis();
        for(int i=0; i<10000000; i++ ){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
    }

    public static void duplicationThred(){
        Thread t1 = new Thread(new Demo());
        Thread t2 = new Thread(new Demo());
       /* Thread t3 = new Thread(new Demo());
        Thread t4 = new Thread(new Demo());
        Thread t5 = new Thread(new Demo());
        Thread t6 = new Thread(new Demo());*/

        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
      /*  t3.start();
        t4.start();
        t5.start();
        t6.start();*/

        try {
            t1.join();
            t2.join();
           /* t3.join();
            t4.join();
            t5.join();
            t6.join();*/
            long endTime = System.currentTimeMillis();
            System.out.println("开始时间"+startTime);
            System.out.println("结束时间"+endTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }










    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

/*    @Value("${demo}")
    private static String demo;

    @Autowired
    private RedisUtils redisUtils;

    @Scheduled(cron = "0/10 * * * * ?")
    public void test(){
        System.out.println("********"+demo+":"+System.currentTimeMillis());
    }


    @Scheduled(cron = "0/10 * * * * ?")
    public void test1(){
        String key="aaa";
        String value= System.currentTimeMillis()+"";
        System.out.println("此时的value值:"+value);
        redisUtils.setKey(key,value);
        Object value1 = redisUtils.getKey(key);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理完成 此时value的值是"+value1);
    }*/

    @Scheduled(cron = "0/10 * * * * ?")
    public void test1(){
        //1.去获取锁 如果锁不存在则设置锁进入 存在则进行下一步判断
        //1.1value需注意 此时需要有一个辨识
        //不存在则true 存在则false
        String value="aaa";
         //Boolean isLock = redisTemplate.opsForValue().setIfAbsent(CommonConstants.TEST_KEY, value);
        //redis2.6之前不允许同时设置CommonConstants.TEST_KEY, value和过期时间
       // final Boolean isLock = redisTemplate.opsForValue().setIfAbsent(CommonConstants.TEST_KEY, value,3000,TimeUnit.MICROSECONDS);
        Boolean isLock = redisUtils.setKeyLock(CommonConstants.TEST_KEY, value, TimeUnit.MILLISECONDS, 3000);

        System.out.println(isLock);
        //获取到锁 进行下一步处理
        try {
            if(isLock){
                redisTemplate.expire(CommonConstants.TEST_KEY,6000, TimeUnit.MILLISECONDS);
                System.out.println("AAA开始处理业务");
                String key="tempKey";
                String value1= System.currentTimeMillis()+"";
                redisUtils.setKey(key,value1);

                    Thread.sleep(5000);
                    Object key1 = redisUtils.getKey(key);
                    System.out.println("AAA处理业务结束 此时value的值是"+key1);

                System.out.println("AAA处理业务结束");
            }else {
                //获取锁失败 等待下次的处理
                System.out.println("未获取到锁  结束该次定时任务！！！！！！！！！！！！！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
           redisUtils.closeLock(CommonConstants.TEST_KEY,value,isLock);
            System.out.println("删除");
        }
    }

    public static class Demo implements Runnable{

        @Override
        public void run() {
            for(int i=0; i< 10000000; i++){
                System.out.println("!!!!!!!!!!!!!!!!!!!!");
                try {
                    //假设执行的任务
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
