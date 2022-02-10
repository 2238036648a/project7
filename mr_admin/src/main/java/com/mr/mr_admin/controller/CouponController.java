package com.mr.mr_admin.controller;

import com.mr.mr_admin.service.IcouponService;
import com.mr.mr_admin.vo.CouponVO;
import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("coupon")
@Api(value = "测试优惠券",tags = {"测试优惠券接口操作"})
public class CouponController {



    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "ab";
        String s = string2 +"c";
        System.out.println("1111"+string1.equals(s));
        int i = get();
        System.out.println(i);

    }
    public static int get(){
        int i=0;
        try {
            String[] arrays = new String[0];
            String str = arrays[1];
            return ++i;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("shuzuyuejie");
            return ++i;
        }catch (Exception e){
            System.out.println("yic ");
            return ++i;
        }finally {
            ++i;
        }

/*
        Integer a= 200;

        Integer b= 200;
        System.out.println(a==b);

        String str = "abc";
        String str1 = "abc";
        String str3 = new String("abc");
        System.out.println(str == str1);
        System.out.println(str == str3);

        StringBuffer abc = new StringBuffer("abc");
        StringBuffer abc1 = new StringBuffer("abc");
        System.out.println(abc == abc1);
        System.out.println(abc.equals(abc1));
        System.out.println(str.equals(abc));*/
//                publie elass Test
//                pubiiestatic void main(stringLlargs》(
//                Integer B 200;
//        LntCgerb= 200:
//        SystemerH.println(ai b':
//        String strl= "abe":
//        String str2.= "abc":
//        String str3= new String《"abc):
//        Sy stem.err.println (strl=- str2:
//        Systenerr.println(strl str3》;
//        StringBuffer sb1= new StringBuffer("abe7';
//                StringBuffer sb2= new StringBuffer("abc");
//        System.err. println(sblsb2):
//        Sy stcm.err.println(sbl.equa1s(sb2))E
//        System. err. println(str1.equals(sb1)
    }



      /*  int count = 1;
        for(int i = 1; i <= 5; i++)count += i;
        System.out.println(count);*/
           /* 1 2
              2 4
               3 7
                 4 11
                  5  16*/






    @Autowired
    private IcouponService icouponService;

    @GetMapping("list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView couponPage(@AuthenticationPrincipal  @ApiParam(name="用户对象11",value="传入json格式",required=true) UserDetails userDetails) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("coupon/shop_cart");
       CommonResult result = icouponService.findListByCondition();
        System.out.println(result);
       mav.addObject("list1",result);
        return mav;
    }


    @PostMapping("userCoupon")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CommonResult getUserCoupon(@RequestBody  @ApiParam(name="用户对象",value="传入json格式",required=true) CouponVO couponVO, @AuthenticationPrincipal UserDetails userDetails) {

        if(null ==couponVO || StringUtils.isEmpty(couponVO.getCpId())){
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(),ErrorEnum.USER_CHECK.getErrMassage());
        }

        CommonResult result = icouponService.getUserCoupon(couponVO,userDetails);
        return CommonResultUtils.getResult(result);
    }

}
