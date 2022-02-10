package com.mr.bizdiscount.controller;

import com.mr.bizdiscount.service.ICouponTypeService;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class CouponTypeController {
    @Autowired
    private ICouponTypeService iCouponTypeService;

    @GetMapping("type/list")
    public CommonResult couponlist(){
        CommonResult commonResult = iCouponTypeService.couponTypelist();
        return commonResult;
    }
}
