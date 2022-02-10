package com.mr.mr_admin.service;

import com.mr.mr_admin.dto.ProductDto;
import com.mr.mr_admin.dto.ProductTypeDto;
import com.mr.mr_admin.vo.CouponVO;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.security.core.userdetails.UserDetails;

public interface IcouponService {


    CommonResult findListByCondition();

    CommonResult getUserCoupon(CouponVO couponVO, UserDetails userDetails);

    CommonResult list(ProductTypeDto productTypeDto);

    CommonResult list1(ProductDto productDto);

}
