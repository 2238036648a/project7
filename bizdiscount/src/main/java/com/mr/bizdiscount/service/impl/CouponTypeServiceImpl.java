package com.mr.bizdiscount.service.impl;


import com.mr.bizdiscount.dto.CouponDto;
import com.mr.bizdiscount.mapper.CouponMapper;
import com.mr.bizdiscount.mapper.CouponTypeMapper;
import com.mr.bizdiscount.service.ICouponService;
import com.mr.bizdiscount.service.ICouponTypeService;
import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CouponServiceImpl
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2020/7/22
 * @Version V1.0
 **/
@Service
public class CouponTypeServiceImpl implements ICouponTypeService {
    @Resource
    private CouponTypeMapper couponTypeMapper;

    @Override
    public CommonResult couponTypelist() {

       List<CouponDto> couponlist = couponTypeMapper.couponTypelist();
       if (couponlist==null){
           return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                   ErrorEnum.USER_CHECK.getErrMassage());
       }
        CommonResult result = CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.USER_CHECK.getErrMassage(), couponlist);

        return result;
    }
}
