/*
package com.mr.pdm.cotroller;

import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import com.mr.pdm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("list")
    @ResponseBody
    public CommonResult findProductByTypeList(){
        CommonResult list = productService.findProductByTypeList();
        return CommonResultUtils.getResult(list.getData());
    }


    @RequestMapping("detail")
    @ResponseBody
    public CommonResult findProductById(String pdId){
        CommonResult list = productService.findProductById(pdId);
      return list;
    }

    @RequestMapping("detail/num")
    @ResponseBody
    public CommonResult findProductByIdList(String pdId,Integer num){
        CommonResult list = productService.findProductByIdList(pdId,num);
        return list;
    }

}
*/
