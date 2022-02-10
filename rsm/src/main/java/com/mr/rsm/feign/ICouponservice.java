package com.mr.rsm.feign;

import com.mr.mr_common.vo.CommonResult;
import com.mr.rsm.vo.CouponVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bizdiscount")
public interface ICouponservice {
    @PostMapping("/coupon/list")
    public CommonResult couponList();
//
       @GetMapping("/coupon/type/list")
        CommonResult couponListByType();

    @PostMapping("/coupon/info")
    CommonResult addCouponInfo(@SpringQueryMap CouponVO couponvo);

    @PutMapping("/coupon/update")
    CommonResult updateCouponInfo(@SpringQueryMap CouponVO couponvo);
}
