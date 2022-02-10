package com.mr.mr_admin.redis;

import com.mr.mr_admin.redis.RedisUtils;
import com.mr.mr_admin.vo.CouponVO;
import com.mr.mr_common.vo.CommonResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void getvalue(){
        CouponVO couponVO = new CouponVO();
        couponVO.setCpName("32323");
        couponVO.setCreateTime(new Date());
        String key = UUID.randomUUID().toString();
        redisUtils.setKeyValue(key,couponVO);
       // redisUtils.setKeyValue(UUID.randomUUID().toString(), JSON.toJSONString(couponVO));

        System.out.println(couponVO);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CommonResult keyValue = redisUtils.getKeyValue(key);
        System.out.println("开始获取data数据-----------------------------------");
        System.out.println(keyValue.getData());
        System.out.println("结束获取data数据-----------------------------------");
    }




    @Test
    public void getHashvalue() {
        CouponVO couponVO = new CouponVO();
        couponVO.setCpName("111");
        couponVO.setCreateTime(new Date());

        CouponVO couponVO1 = new CouponVO();
        couponVO1.setCpName("222");
        couponVO1.setCreateTime(new Date());

        CouponVO couponVO2 = new CouponVO();
        couponVO2.setCpName("333");
        couponVO2.setCreateTime(new Date());
        String key = UUID.randomUUID().toString();
        redisUtils.setHashKeyValue(key,"111",couponVO);
        redisUtils.setHashKeyValue(key,"222",couponVO1);
        redisUtils.setHashKeyValue(key,"333",couponVO2);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hash类型的值---------------------------");
        System.out.println(redisUtils.getHashKeyValue(key,"111").getData());
        System.out.println(redisUtils.getHashKeyValue(key,"222").getData());
        System.out.println(redisUtils.getHashAllValue(key).getData());
    }


    @Test
    public void getExpireHashvalue() throws InterruptedException{
        CouponVO couponVO = new CouponVO();
        couponVO.setCpName("111");
        couponVO.setCreateTime(new Date());

        CouponVO couponVO1 = new CouponVO();
        couponVO1.setCpName("222");
        couponVO1.setCreateTime(new Date());

        CouponVO couponVO2 = new CouponVO();
        couponVO2.setCpName("333");
        couponVO2.setCreateTime(new Date());
        String key = UUID.randomUUID().toString();
        redisUtils.setHashExpireKeyValue(key,"111",couponVO);
        redisUtils.setHashExpireKeyValue(key,"222",couponVO1);
        redisUtils.setHashExpireKeyValue(key,"333",couponVO2);


        System.out.println("hash类型的值---------------------------");
        Thread.sleep(3000);
        System.out.println("过期时间--------------------"+redisUtils.getExpire(key,TimeUnit.MILLISECONDS));
        System.out.println("11111111111111111111"+redisUtils.getHashAllValue(key).getData());
        Thread.sleep(10000);
        System.out.println("2222222222222222222"+redisUtils.getHashAllValue(key).getData());
    }
}
