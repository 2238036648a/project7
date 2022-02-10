package com.mr.mr_admin.feign;

import com.mr.mr_common.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("pdm")
public interface IProductService {

    @PostMapping("/product/list/")
    public CommonResult findProductTypeList();

    @GetMapping("/product/detail/")
    public CommonResult findProductById(@RequestParam("pdId") String pdId);



    @GetMapping("/product/detail/num/")
    CommonResult findProductByIda(@RequestParam("pdId")String pdId, @RequestParam("num")Integer num);
}
