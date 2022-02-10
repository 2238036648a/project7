package com.mr.mr_admin.controller;

import com.mr.mr_admin.feign.IBizDiscountService;
import com.mr.mr_admin.feign.IProductService;
import com.mr.mr_admin.service.IOrderService;
import com.mr.mr_admin.vo.ProductVO;
import com.mr.mr_admin.vo.UserCouponVo;
//import com.mr.pdm.service.Teat1;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IBizDiscountService iBizDiscountService;

  /* @Reference(version = "1.1.0")
    private Teat1 productService;


    @RequestMapping("list1")
    public String list1(){
        return productService.aa();
    }
*/

   @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("coupon/list1");
        CommonResult result  = iProductService.findProductTypeList();

        modelAndView.addObject("data",result);

        System.out.println("!!!!!!!!!!!!!!!"+modelAndView);
        return modelAndView;
    }



    @RequestMapping("detail")
    public ModelAndView toProductInfo(String pdId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("coupon/Product_Detailed");
        CommonResult result  = iProductService.findProductById(pdId);
        modelAndView.addObject("data",result);
        System.out.println("!!!!!!!!!!!!!!!"+modelAndView);
        return modelAndView;
    }

    @RequestMapping("/order/info")
    public ModelAndView toOrderInfo(Integer num,String pdId,@AuthenticationPrincipal UserDetails userDetails){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/orders");
        CommonResult result  = iOrderService.toOrderInfo(num,pdId,userDetails);
        CommonResult resultAddr  = iOrderService.toAddr(userDetails);
        CommonResult result1  = iProductService.findProductByIda(pdId,num);

        modelAndView.addObject("data",result);
        modelAndView.addObject("addr",resultAddr);
        modelAndView.addObject("product",result1);

        System.out.println("!!!!!!!!!!!!!!!"+result);
        Map<String, Object> map = new HashMap<>();
        map.put("reducePrice",0);
        map.put("realPrice",333);
        modelAndView.addObject("priceInfo",map);
        return modelAndView;
    }


    @RequestMapping("jian")
    @ResponseBody
    public CommonResult increasePd(String pdId, String cpId, BigDecimal productTotalPrice, BigDecimal reducePrice, BigDecimal realPrice, Integer num, @AuthenticationPrincipal UserDetails userDetails){
        // @PostMapping("jian")
//    public CommonResult increasePd(@RequestBody Map params){

        CommonResult Addresult  = iOrderService.addData(pdId,cpId,productTotalPrice,reducePrice,realPrice,num,userDetails);

        return CommonResultUtils.getResult(Addresult);
    }

    @RequestMapping("group-buy")
    public ModelAndView toPay(String pdName,Integer num,BigDecimal pdPrice,String cpId,@AuthenticationPrincipal UserDetails userDetails,BigDecimal realPrice){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pay/group_buy");

        ProductVO productVO = new ProductVO();
        productVO.setBuyNum(num);
        productVO.setPdName(pdName);
        productVO.setPdPrice(pdPrice);
        productVO.setTotalPrice(realPrice);
        UserCouponVo userCouponVo = new UserCouponVo();
        userCouponVo.setCpId(cpId);

        modelAndView.addObject("productBuy",productVO);
        modelAndView.addObject("userCoupon",userCouponVo);
        return modelAndView;
    }

    @RequestMapping("quxiao-buy")
    @ResponseBody
    public CommonResult quxiao(String cpId,@AuthenticationPrincipal UserDetails userDetails){

        CommonResult recoverresult  = iOrderService.recoverUserCoupon(cpId,userDetails);

        return CommonResultUtils.getResult(recoverresult);
    }
}
