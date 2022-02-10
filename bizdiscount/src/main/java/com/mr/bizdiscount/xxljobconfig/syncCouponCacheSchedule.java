package com.mr.bizdiscount.xxljobconfig;

import com.alibaba.fastjson.JSONObject;
import com.mr.bizdiscount.dto.CouponDto;
import com.mr.bizdiscount.redis.RedisUtils;
import com.mr.bizdiscount.service.ICouponService;
import com.mr.bizdiscount.vo.CouponVO;
import com.mr.mr_common.common.CommonConstants;
import com.mr.mr_common.vo.CommonResult;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class syncCouponCacheSchedule {

    @Autowired
    private ICouponService iCouponService;

    @Autowired
    private RedisUtils redisUtils;

   // @Scheduled(cron ="0 0/1 * * * ?")
   //@XxlJob("demoJobHandler1")
  /* public ReturnT<String> execute(String s) throws Exception {
       XxlJobLogger.log("XXL-JOB, Hello World111111111.");
       System.out.println("=====hello world11111111=====");
       return ReturnT.SUCCESS;

   }*/

   @XxlJob("demoJobHandler1")
    public ReturnT<String> testSchedule(String s) throws Exception {
       log.info("开启进行同步数据任务操作");
       //获取redis数据
       String key = CommonConstants.COUPON_REDIS_KEY;
       CommonResult reData = redisUtils.getHashAllValue(key);
       Map redisData = (Map) reData.getData();

       //获取mysql数据
       CouponVO couponVO = new CouponVO();
       couponVO.setCpStatus(CommonConstants.OPEN_STATUS);
       CommonResult result = iCouponService.findListByCondition(couponVO);
       List<CouponDto> sqlData = (List<CouponDto>) result.getData();
       Object data = result.getData();

       if (null == redisData || null == sqlData || redisData.size() == 0) {
         log.info("数据为空");
           return ReturnT.FAIL;
       }
       //3.判断条数是否一致
       if (redisData.size() != sqlData.size()) {
           //需同步
           syncCouponRedisData(key, sqlData);
           log.info("同步结束 数据条数不一致 进行同步");
           //return false;
           return ReturnT.FAIL;
       }

       //4.判断id是否一致
       boolean status = false;
       for (CouponDto coupon : sqlData) {
           //判断redis中是否包含对应的key 如果包含说明不一致
           if (!redisData.containsKey(coupon.getCpId())) {
               status = true;
               break;
           }
       }
       if (status == true) {
           syncCouponRedisData(key,sqlData);
           log.info("结束同步 数据不一致 进行同步  ####");
           return ReturnT.FAIL;
       }

       //5.判断具体内容是否一致
        Map singleData = null;
        boolean contentStatus = false;
        for (CouponDto coupon:sqlData) {
//            JSON.parseObject(JSON.toJSONString(redisData,CouponDto.class);

            singleData = (Map) redisData.get(coupon.getCpId());
            if(null == singleData || null == coupon.getCpVersion() ||
                    !singleData.get("cpVersion").equals(coupon.getCpVersion()) || !coupon.equals(singleData)){
                contentStatus = true;
                break;

            }
        }
           if(contentStatus){
               syncCouponRedisData(key,sqlData);
               log.info("同步结束 数据内容发生修改进行同步");
               // return false;
               return ReturnT.FAIL;
           }
        log.info("同步结束 不需要进行同步数据");
       // return false;
       return ReturnT.SUCCESS;
    }


    protected void syncCouponRedisData(String key,List<CouponDto> params){
        //删除原有的key
        redisUtils.delHAashEntry(key);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //新增key
       Map linkedHashMap = new LinkedHashMap();
        for(CouponDto data : params){

            Map map = JSONObject.parseObject(JSONObject.toJSONString(data), Map.class);
            linkedHashMap.put(data.getCpId(),map);
        }
        redisUtils.setMapValue(key,linkedHashMap);
    }
}
