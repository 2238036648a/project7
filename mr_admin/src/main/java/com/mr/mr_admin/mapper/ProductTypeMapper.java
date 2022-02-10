package com.mr.mr_admin.mapper;

import com.mr.mr_admin.dto.ProductTypeDto;

import java.util.List;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(String pdTypeId);

    int insert(ProductTypeDto record);

    int insertSelective(ProductTypeDto record);

    ProductTypeDto selectByPrimaryKey(String pdTypeId);

    int updateByPrimaryKeySelective(ProductTypeDto record);

    int updateByPrimaryKey(ProductTypeDto record);

    List<ProductTypeDto> list();
}