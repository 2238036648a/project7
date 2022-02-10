package com.mr.bizdiscount.mapper;


import com.mr.bizdiscount.dto.CouponDto;
import com.mr.bizdiscount.vo.CouponVO;

import java.util.List;

public interface CouponMapper {
    List<CouponDto> couponlist();

    void insertSelective(CouponVO couponVO);
    int updateByPrimaryKeySelective(CouponVO record);

    int updateByPrimaryKey(CouponVO record);
    int updatecouponInfo(CouponVO couponVO);

    List<CouponDto> findListByCondition(CouponVO couponVO);

    List<CouponDto> findListByConditionCpId(CouponVO couponVO);
}
