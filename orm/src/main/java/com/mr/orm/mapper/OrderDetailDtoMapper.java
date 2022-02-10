package com.mr.orm.mapper;


import com.mr.mr_common.dto.OrderDetailDto;

public interface OrderDetailDtoMapper {
    int deleteByPrimaryKey(String odId);

    int insert(OrderDetailDto record);

    int insertSelective(OrderDetailDto record);

    OrderDetailDto selectByPrimaryKey(String odId);

    int updateByPrimaryKeySelective(OrderDetailDto record);

    int updateByPrimaryKey(OrderDetailDto record);
}