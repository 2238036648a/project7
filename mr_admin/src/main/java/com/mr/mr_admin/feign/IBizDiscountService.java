package com.mr.mr_admin.feign;

import com.mr.mr_admin.vo.CouponVO;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "bizdiscount")
public interface IBizDiscountService {

    @PostMapping("/coupon/list/condition")
    CommonResult findListByCondition(@SpringQueryMap CouponVO couponvo);

    @PostMapping("/coupon/list/")
    CommonResult findList();

    @PutMapping("/coupon/update")
    CommonResult updatecouponInfo(@SpringQueryMap CouponVO couponvo);

    @PostMapping("/coupon/list/conditionCpId")
    CommonResult findListByConditionCpId(@SpringQueryMap CouponVO couponVO);
}


