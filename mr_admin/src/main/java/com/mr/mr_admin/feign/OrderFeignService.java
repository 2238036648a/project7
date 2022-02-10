package com.mr.mr_admin.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("orm")
public interface OrderFeignService {
   // List<OrderDetailDto> addData(String pdId, Integer num, UserDetails userDetails);
}
