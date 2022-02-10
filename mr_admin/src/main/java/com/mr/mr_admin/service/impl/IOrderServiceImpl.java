package com.mr.mr_admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mr.mr_admin.dto.OrderDetailDto;
import com.mr.mr_admin.dto.UserAddrDto;
import com.mr.mr_admin.dto.UserCouponDTO;
import com.mr.mr_admin.dto.UserDto;
import com.mr.mr_admin.mapper.ProductDtoMapper;
import com.mr.mr_admin.redis.RedisUtils;
import com.mr.mr_admin.mapper.Aaa;
import com.mr.mr_admin.mapper.UserAddrDtoMapper;
import com.mr.mr_admin.mapper.UserMapper;
import com.mr.mr_admin.mq.product.ProducerTool;
import com.mr.mr_admin.redis.SnowFlakeTool;
import com.mr.mr_admin.service.IOrderService;
import com.mr.mr_admin.vo.ProductCouponVo;
import com.mr.mr_admin.vo.UserCouponVo;
import com.mr.mr_common.common.CommonConstants;
import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.dto.OrderMainDto;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private RedisUtils redisUtils;

    @Resource
    private UserMapper userMapper;


    @Autowired
    private ProducerTool producerTool;


    @Resource
    private ProductDtoMapper productDtoMapper;

    @Resource
    private UserAddrDtoMapper addrDtoMapper;
    @Resource
    private Aaa aa;



    @Override
    public CommonResult addData(String pdId,String cpId,BigDecimal totalPrice, BigDecimal reducePrice, BigDecimal realPrice,Integer num, UserDetails userDetails) {
        if(null == userDetails || StringUtils.isEmpty(userDetails.getUsername())){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
        }

        //获取用户
        CommonResult userResult = redisUtils.getHashKeyValue(CommonConstants.USER_REDIS_KEY, userDetails.getUsername());
        if(null == pdId || StringUtils.isEmpty(pdId)){
            return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.DB_CHECKED_ERROR.getErrMassage());
        }
        //查询商品
        List<ProductCouponVo> product1 = productDtoMapper.findProductCoupon(pdId);

        if(null == product1 || StringUtils.isEmpty(num)){
            return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.DB_CHECKED_ERROR.getErrMassage());
        }



        for (ProductCouponVo productVo:product1) {
            //库存不足 或者 购买数量小于1 通知用户下单失败
            if(null == productVo.getPdStorage() || StringUtils.isEmpty(num) || productVo.getPdStorage() < num){
                return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),
                        ("库存不足或参数为空"));
            }
            //如果库存允许 进行下一步 通过mq对商品库存进行更新
            if(productVo.getPdStorage() > num){

                Map<String,Object> params = new HashMap<>();
                params.put("pdId",pdId);
                params.put("buyNum",num);
                producerTool.testSendMessage(CommonConstants.PRODUCT_STORAGE,CommonConstants.PRODUCT_STORAGE_TAGS, JSONObject.toJSONString(params));

            }
        }
        //新增订单主表数据
        String orderMainId = UUID.randomUUID().toString().replace("-", "");
        String orderName = "vvvvvvvvvvv";
        SnowFlakeTool snowFlakeTool = new SnowFlakeTool(1, 1, 1);
        String orderCode = CommonConstants.ORDER_DETAIL_ODCODE + snowFlakeTool.nextId();

        //创建主表数据
        OrderMainDto orderMainDto = new OrderMainDto();
        orderMainDto.setOmId(orderMainId);
        orderMainDto.setOmCode(orderCode);
        orderMainDto.setOmName(orderName);
        //拆分订单 创建子表信息
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        UserDto user = (UserDto) userResult.getData();
        orderDetailDto.setUserId(user.getUmId());
        orderDetailDto.setOdId(UUID.randomUUID().toString());
        orderDetailDto.setCpId(cpId);
        orderDetailDto.setPdId(pdId);
        int num1 = num.intValue();
        orderDetailDto.setPdNumber((byte) num1);
        orderDetailDto.setOdPrice(realPrice);
        orderDetailDto.setOdTotalprice(totalPrice);
        orderDetailDto.setOdCouponprice(reducePrice);
        orderDetailDto.setOdName(orderName);
        orderDetailDto.setOdCode(orderCode);
        orderDetailDto.setCreateTime(new Date());

        HashMap<Object, Object> map = new HashMap<>();
        map.put("orderDetail",orderDetailDto);
        map.put("orderMainDetail",orderMainDto);
        producerTool.testSendMessage(CommonConstants.ORDER_DETAIL_TOPIC,CommonConstants.ORDER_DETAIL_TAGS, JSON.toJSONString(map));

        if(null == cpId || StringUtils.isEmpty(cpId)){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
        }

        HashMap<Object, Object> map1 = new HashMap<>();
        UserCouponDTO userCouponDTO = new UserCouponDTO();
        userCouponDTO.setCpId(cpId);
        map1.put("deleteUserCoupon",userCouponDTO);
        producerTool.testSendMessage(CommonConstants.DELETE_TOPIC_USERCOUPON,CommonConstants.DELETE_TAGS_USERCOUPON, JSON.toJSONString(map1));

        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),ErrorEnum.SUCCESS_RESTUL.getErrMassage(),map);
    }


    @Override
    public CommonResult recoverUserCoupon(String cpId, UserDetails userDetails) {
        if(null == userDetails || StringUtils.isEmpty(userDetails.getUsername())){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
        }

        //获取用户
        CommonResult userResult = redisUtils.getHashKeyValue(CommonConstants.USER_REDIS_KEY, userDetails.getUsername());
        if(null == cpId || StringUtils.isEmpty(cpId)){
            return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.DB_CHECKED_ERROR.getErrMassage());
        }
        HashMap<Object, Object> map1 = new HashMap<>();
        UserCouponDTO userCouponDTO = new UserCouponDTO();
        userCouponDTO.setCpId(cpId);
        map1.put("recoverUserCoupon",userCouponDTO);
        producerTool.testSendMessage(CommonConstants.RECOVER_TOPIC_USERCOUPON,CommonConstants.RECOVER_TAGS_USERCOUPON, JSON.toJSONString(map1));


        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),ErrorEnum.SUCCESS_RESTUL.getErrMassage(),map1);
    }

    @Override
    public CommonResult toOrderInfo(Integer num,String pdId, UserDetails userDetails) {

        Map<String, Object> map = new HashMap<>();
        List list = new ArrayList<>();

        //通过用户查询优惠券
        if(null == userDetails || StringUtils.isEmpty(userDetails.getUsername())){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
        }

        CommonResult userResult = redisUtils.getHashKeyValue(CommonConstants.USER_REDIS_KEY, userDetails.getUsername());
        UserDto user = (UserDto) userResult.getData();

        if(null == user || StringUtils.isEmpty(user.getUmAccount())){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),
                    ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
        }
        List<UserCouponVo> userCoupon = aa.findUser(user.getUmAccount());

        //通过商品id查询商品信息及对应优惠券
        if(StringUtils.isEmpty(pdId)){
            return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),ErrorEnum.DB_CHECKED_ERROR.getErrMassage());
        }
        List<ProductCouponVo> proList =  productDtoMapper.findProductCoupon(pdId);



        if(StringUtils.isEmpty(proList)){
            for (UserCouponVo pc:userCoupon) {
                pc.setIsAvilable(0);
                pc.setMsg("商品没有适用的优惠券");
            }
        }


        BigDecimal num1 = new BigDecimal(num.toString());
        BigDecimal totalPrice = null;
        //循环判断优惠券类型是否一致
        //定义一个状态值
        int status = 1;
       /* String msg = "该商品不能使用"+userCoupon.get(0).getCpTypeName()+"的优惠券";*/
        String msg = "";
        if(null != proList&& proList.size()>0) {
            //循环判断是否满足要求
            for (UserCouponVo pc : userCoupon) {
                for (ProductCouponVo productDto1 : proList) {
                    if (productDto1 != null && productDto1.getCpId().equals(pc.getCpTypeId())) {
                        //类型一致
                        status = 0;
                    }
                }

                //判断金额是否可以用
                if (status == 0) {
                    //满足满减金额 -1 getCpAhieve小于totalPrice
                    if (pc.getCpAhieve().compareTo(proList.get(0).getPdPrice().multiply(num1)) == 1) {
                        status = 1;
                        msg = "未达到使用最低金额";
                    }
                }

                if(status != 0){
                    pc.setIsAvilable(status);
                    pc.setMsg(msg);
                }else{
                    pc.setIsAvilable(status);
                    pc.setTotalPrice(proList.get(0).getPdPrice().multiply(num1));
                    pc.setMsg("该优惠券可以使用");
                }
                pc.setStatus(status);
                pc.setMsg(msg);
                msg = "该商品不能使用"+pc.getCpTypeName()+"的优惠券";
            }
        }

        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),ErrorEnum.SUCCESS_RESTUL.getErrMassage(),userCoupon.size(),userCoupon);
    }

    @Override
    public CommonResult toAddr(UserDetails userDetails) {
        UserDto user = null;
        if(null != userDetails.getUsername() && !userDetails.getUsername().equals("")){
            CommonResult userResult = redisUtils.getHashKeyValue(CommonConstants.USER_REDIS_KEY, userDetails.getUsername());
             user = (UserDto) userResult.getData();

            if(null == user){
                return CommonResultUtils.getResult(ErrorEnum.USER_CHECKED_ERROR.getErrCode(),
                        ErrorEnum.USER_CHECKED_ERROR.getErrMassage());
            }
        }


      List<UserAddrDto> list =  addrDtoMapper.list(user.getUmId());
      if(null == list || list.size() == 0){
          return CommonResultUtils.getResult(ErrorEnum.DB_CHECKED_ERROR.getErrCode(),ErrorEnum.DB_CHECKED_ERROR.getErrMassage());
      }

        for (int i = 0; i < list.size(); i++) {
            String shengAddr = addrDtoMapper.getShengAddr(list.get(i).getShengId());
            String shiAddr = addrDtoMapper.getShiAddr(list.get(i).getShiId());
            String xianAddr = addrDtoMapper.getXianAddr(list.get(i).getXianId());
            list.get(i).setSheng(shengAddr);
            list.get(i).setShi(shiAddr);
            list.get(i).setXian(xianAddr);
        }
        return CommonResultUtils.getResult(list);
    }




}
