package com.mr.bizdiscount.service;

import com.mr.bizdiscount.vo.CouponVO;
import com.mr.mr_common.vo.CommonResult;

public interface ICouponService {
    CommonResult couponlist();

    CommonResult couponInfo(CouponVO couponVO);

    CommonResult updatecouponInfo(CouponVO couponVO);

    CommonResult findListByCondition(CouponVO couponVO);


    CommonResult findListByConditionCpId(CouponVO couponVO);
}
