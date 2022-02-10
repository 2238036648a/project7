package com.mr.mr_admin.service;

import com.mr.mr_common.vo.CommonResult;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;

public interface IOrderService {

   CommonResult recoverUserCoupon(String cpId, UserDetails userDetails);

    CommonResult toOrderInfo(Integer num, String pdId, UserDetails userDetails);

    CommonResult toAddr(UserDetails userDetails);

     CommonResult addData(String pdId, String cpId, BigDecimal totalPrice, BigDecimal reducePrice, BigDecimal realPrice, Integer num, UserDetails userDetails);
}
