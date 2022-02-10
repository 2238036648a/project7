package com.mr.mr_admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mr.mr_admin.dto.ProductDto;
import com.mr.mr_admin.dto.ProductTypeDto;
import com.mr.mr_admin.mapper.ProductDtoMapper;
import com.mr.mr_admin.mapper.ProductTypeMapper;
import com.mr.mr_admin.redis.RedisUtils;
import com.mr.mr_admin.dto.UserCouponDTO;
import com.mr.mr_admin.dto.UserDto;
import com.mr.mr_admin.feign.IBizDiscountService;
import com.mr.mr_admin.mq.product.ProducerTool;
import com.mr.mr_admin.redis.SnowFlakeTool;
import com.mr.mr_admin.service.IcouponService;
import com.mr.mr_admin.vo.CouponVO;
import com.mr.mr_common.common.CommonConstants;
import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class IcouponServiceImpl implements IcouponService {

    @Autowired
    private RedisUtils redisUtils;
    @Resource
    private IBizDiscountService iBizDiscountService;

   @Autowired
   private ProducerTool producerTool;

   @Resource
   private ProductTypeMapper productTypeMapper;

   @Resource
   private ProductDtoMapper productDtoMapper;
   //-------------------------------查询状态为0 的数据
    @Override
    public CommonResult findListByCondition() {


       List<Map> recData = new ArrayList<>();
        String key = CommonConstants.COUPON_REDIS_KEY;
        Boolean keyExists = redisUtils.keyExists(key);

        if (keyExists) {
            //key存在直接在redis获取值
            CommonResult result = redisUtils.getHashAllValue(key);
            Map<String,Map> data = (Map<String, Map>) result.getData();

            for (Map data1:data.values()) {
                recData.add(data1);
            }
            if (recData == null || recData.size() == 0) {
                recData = syncCouponListData(key);
            }
        }
        if (!keyExists) {
            recData = syncCouponListData(key);
        }
        return CommonResultUtils.getResult(recData);
    }

    @Override
    public CommonResult getUserCoupon(CouponVO couponVO, UserDetails userDetails) {
        //1.判断数据库是否有剩余
        CommonResult result = iBizDiscountService.findListByConditionCpId(couponVO);
        List<Map> data = (List<Map>) result.getData();

        if(data.size() == 0 || null == data){
            return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),ErrorEnum.DB_CHECKED_ERROR.getErrMassage());
        }

        if((Integer)data.get(0).get("cpStorage") <= 0){
            return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),ErrorEnum.DB_CHECKED_ERROR.getErrMassage());
        }
        //2.通过雪花算法生成券码
        SnowFlakeTool snowFlakeTool = new SnowFlakeTool(1, 1, 1);
        long userCode = snowFlakeTool.nextId();
        //3.获取用户信息
        if(null == userDetails || StringUtils.isEmpty( userDetails.getUsername())){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
        }
        CommonResult userResult = redisUtils.getHashKeyValue(CommonConstants.USER_REDIS_KEY, userDetails.getUsername());

        UserDto user = (UserDto) userResult.getData();
        if(null == user){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
        }

        //绑定券码和用户
        UserCouponDTO uc = new UserCouponDTO();
        uc.setUcId(UUID.randomUUID().toString());
        uc.setUcCode(userCode + "");
        uc.setCpId(couponVO.getCpId());
        uc.setUserId(user.getUmId());
        uc.setStatus(CommonConstants.OPEN_STATUS);
        uc.setCreateTime(new Date());

        //获取缓存优惠券信息   从redis中获取
        List<Map> ucCode = user.getUcCode();
        if(null == ucCode || ucCode.size() == 0){
            ucCode  = new ArrayList<>();
            ucCode.add(JSONObject.parseObject(JSONObject.toJSONString(uc), Map.class));
        }else{
            ucCode.add(JSONObject.parseObject(JSONObject.toJSONString(uc), Map.class));
        }
        user.setUcCode(ucCode);
        //存到 redis中
        redisUtils.setHashKeyValue(CommonConstants.USER_REDIS_KEY,user.getUmAccount(),user);


        //发送mq请求 通知下游系统去执行  写入到数据库
        // bizdiscount  接受信息并写入到数据库
        Map<String,Object> params = new HashMap<>();
        CouponVO coupon = new CouponVO();
        coupon.setCpId((String) data.get(0).get("cpId"));
        coupon.setCpStorage(((Integer) data.get(0).get("cpStorage")) - 1);
        coupon.setCpVersion(((Integer) data.get(0).get("cpVersion")) + 1);
        params.put("uc",uc);
        params.put("coupon",coupon);
        producerTool.testSendMessage(CommonConstants.PRODUCER_TOPIC_USERCOUPON,CommonConstants.PRODUCER_TAGS_USERCOUPON,
                JSONObject.toJSONString(params));
      //  iBizDiscountService.updatecouponInfo(coupon);
        //更新redis数据
        CommonResult cpResult = redisUtils.getHashKeyValue(CommonConstants.COUPON_REDIS_KEY, (String) data.get(0).get("cpId"));
        Map conponMap = (Map) cpResult.getData();
        System.out.println(conponMap.get("cpStorage"));
       int cpstorage  = (Integer) conponMap.get("cpStorage")-1;
        conponMap.put("cpStorage",cpstorage);
        redisUtils.setHashKeyValue(CommonConstants.COUPON_REDIS_KEY, (String) data.get(0).get("cpId"),conponMap);



        //4. 并绑定券码
/*        UserCouponDTO uc = new UserCouponDTO();
        uc.setUcId(UUID.randomUUID().toString().replace("-",""));
        uc.setUcCode(userCode+"");
        uc.setUserId(user.getUmId());
        uc.setCpId(couponVO.getCpId());
        uc.setStatus(CommonConstants.OPEN_STATUS);
        uc.setCreateTime(new Date());

        //5.写入数据信息到数据库中
        int intStau = userCouponMapper.insertInfo(uc);
        //6.更新coupon表中库存信息
        CouponVO couponVO1 = new CouponVO();
        couponVO1.setCpId((String) data.get(0).get("cpId"));
        couponVO1.setCpStorage((Integer) data.get(0).get("cpStorage")-1);

         ;*/
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),ErrorEnum.SUCCESS_RESTUL.getErrMassage());
    }

    @Override
    public CommonResult list(ProductTypeDto productTypeDto) {
        List<ProductTypeDto> list = productTypeMapper.list();
        return CommonResultUtils.getResult(list);
    }

    @Override
    public CommonResult list1(ProductDto productDto) {
        List<ProductDto> list1 = productDtoMapper.list();
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),ErrorEnum.SUCCESS_RESTUL.getErrMassage(),list1);
    }


    /**
     * 没有数据时同步数据
     *
     * @param
     * @return
     */

    protected List<Map> syncCouponListData(String key) {
        CouponVO couponVO = new CouponVO();
        couponVO.setCpStatus(CommonConstants.OPEN_STATUS);
        CommonResult result = iBizDiscountService.findListByCondition(couponVO);
        List<Map> data = (List<Map>) result.getData();
        //redisUtils.expire("coupon_data",60*60, TimeUnit.SECONDS);

        for (Map data1 : data) {
            redisUtils.setHashKeyValue(key, (String) data1.get("cpId"), data1);
        }
        //返回数据
        return data;
    }

}
