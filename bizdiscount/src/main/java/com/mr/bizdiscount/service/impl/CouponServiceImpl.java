package com.mr.bizdiscount.service.impl;


import com.mr.bizdiscount.dto.CouponDto;
import com.mr.bizdiscount.mapper.CouponMapper;
import com.mr.bizdiscount.service.ICouponService;
import com.mr.bizdiscount.vo.CouponVO;
import com.mr.mr_common.common.CommonConstants;
import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CouponServiceImpl
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2020/7/22
 * @Version V1.0
 **/
@Service
public class CouponServiceImpl implements ICouponService{











    @Resource
    private CouponMapper couponMapper;
   /* public static class runA implements Runnable{

        @Override
        public void run() {

        }*/
   // }
    @Override
    public CommonResult couponlist()  {

        List<CouponDto> couponlist = couponMapper.couponlist();




        if (couponlist==null){
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                    ErrorEnum.USER_CHECK.getErrMassage());
        }
        CommonResult result = CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.USER_CHECK.getErrMassage(), couponlist.size(), couponlist);

        return result;
    }

   /* @Override
    public CommonResult couponlist() {

       List<CouponDto> couponlist = couponMapper.couponlist();
       if (couponlist==null){
           return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                   ErrorEnum.USER_CHECK.getErrMassage());
       }
        CommonResult result = CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.USER_CHECK.getErrMassage(), couponlist.size(), couponlist);

        return result;
    }*/

    @Override
    public CommonResult couponInfo(CouponVO couponVO) {
        if (null == couponVO) {
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage());
        }
        couponVO.setCpId(UUID.randomUUID().toString().replace("-", ""));
        couponVO.setCpCode(CommonConstants.COUPON_CODE_PREFIX + System.currentTimeMillis());
        couponVO.setCreateTime(new Date());
        couponMapper.insertSelective(couponVO);

        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.SUCCESS_RESTUL.getErrMassage());
    }

    @Override
    public CommonResult updatecouponInfo(CouponVO couponVO) {
        if (null == couponVO) {
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage());
        }
            couponMapper.updatecouponInfo(couponVO);


        //couponMapper.updateByPrimaryKeySelective(couponVO);
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.SUCCESS_RESTUL.getErrMassage());
    }

    @Override
    public CommonResult findListByCondition(CouponVO couponVO) {

        if (null == couponVO) {
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage());
        }
        List<CouponDto> couponlist = couponMapper.findListByCondition(couponVO);
        //couponMapper.updateByPrimaryKeySelective(couponVO);
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.SUCCESS_RESTUL.getErrMassage(),couponlist.size(),couponlist);
    }

    @Override
    public CommonResult findListByConditionCpId(CouponVO couponVO) {
        if (null == couponVO) {
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage());
        }
        List<CouponDto> couponlist = couponMapper.findListByConditionCpId(couponVO);
        //couponMapper.updateByPrimaryKeySelective(couponVO);
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.SUCCESS_RESTUL.getErrMassage(),couponlist.size(),couponlist);
    }
}
