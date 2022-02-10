/*
package com.mr.mr_admin.service.impl;

import com.mr.mr_admin.feign.IBizDiscountService;
import com.mr.mr_admin.mapper.ICouponMapper;
import com.mr.mr_admin.redis.RedisUtils;
import com.mr.mr_admin.service.IcouponService;
import com.mr.mr_admin.vo.CouponVO;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class IcouponServiceImpl1 implements IcouponService {

    @Autowired
    private RedisUtils redisUtils;
    @Resource
    private IBizDiscountService iBizDiscountService;
    @Override
    public CommonResult findListByCondition() {

        if(redisUtils.getHashKeyValue("coupon_data", "result").getData() != null){
            Object data = redisUtils.getHashKeyValue("coupon_data","result").getData();
            return CommonResultUtils.getResult(data);
        }else{
            CouponVO couponVO = new CouponVO();
            couponVO.setCpStatus(0);
            CommonResult findListByCondition = iBizDiscountService.findListByCondition(couponVO);
            redisUtils.expire("coupon_data",60*60, TimeUnit.SECONDS);
            redisUtils.setHashKeyValue("coupon_data","result",findListByCondition.getData());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object data = redisUtils.getHashKeyValue("coupon_data", "result").getData();
            return CommonResultUtils.getResult(data);
        }

    }
}
*/
