package com.mr.bizdiscount.controller;

import com.mr.bizdiscount.service.ICouponService;
import com.mr.bizdiscount.vo.CouponVO;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName CouponController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2020/7/22
 * @Version V1.0
 **/
@RestController
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    private ICouponService couponService;

    @PostMapping("list")
    public CommonResult couponlist(){
        CommonResult commonResult = couponService.couponlist();
        return commonResult;
    }

    @PostMapping("list/condition")
    public CommonResult findListByCondition(CouponVO couponVO){
        CommonResult commonResult = couponService.findListByCondition(couponVO);
        return commonResult;
    }


    @PostMapping("list/conditionCpId")
    public CommonResult findListByConditionCpId(CouponVO couponVO){
        CommonResult commonResult = couponService.findListByConditionCpId(couponVO);
        return commonResult;
    }

    @PostMapping("info")
    public CommonResult couponInfo(CouponVO couponVO){
        return couponService.couponInfo(couponVO);
    }

    @PutMapping("update")
    public CommonResult updatecouponInfo(CouponVO couponVO){
        return couponService.updatecouponInfo(couponVO);
    }


}
