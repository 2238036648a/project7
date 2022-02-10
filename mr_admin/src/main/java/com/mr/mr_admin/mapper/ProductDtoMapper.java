package com.mr.mr_admin.mapper;

import com.mr.mr_admin.dto.ProductDto;
import com.mr.mr_admin.vo.ProductCouponVo;

import java.util.List;

public interface ProductDtoMapper {


    List<ProductDto> list();

    List<ProductCouponVo> findProductCoupon(String pdId);

    List<ProductDto> findList(String pdId);


}