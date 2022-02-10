package com.mr.rsm.controller;

import com.mr.mr_common.vo.CommonResult;
import com.mr.rsm.feign.ICouponservice;
import com.mr.rsm.vo.CouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CouponController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2020/7/22
 * @Version V1.0
 **/
@Controller
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private ICouponservice iCouponservice;

    @RequestMapping("page")
    public String couponPage(){
        return "/coupon/list";
    }

    @RequestMapping("add/page")
    public String add(){
        return "/coupon/add";
    }

    @GetMapping("/type/list")
    @ResponseBody
    public CommonResult findCouponTypelist(){
        return iCouponservice.couponListByType();
    }

    @PostMapping("list")
    @ResponseBody
    public CommonResult findCouponlist(){

        return iCouponservice.couponList();
    }

    @PostMapping("info")
    @ResponseBody
    public CommonResult addCouponInfo(@RequestBody CouponVO couponvo){

        return iCouponservice.addCouponInfo(couponvo);
    }

    @PutMapping("update")
    @ResponseBody
    public CommonResult updateCouponInfo(@RequestBody CouponVO couponvo){

        System.out.println(couponvo);
        return iCouponservice.updateCouponInfo(couponvo);
    }
}
