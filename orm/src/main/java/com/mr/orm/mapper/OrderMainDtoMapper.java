package com.mr.orm.mapper;

import com.mr.mr_common.dto.OrderMainDto;

public interface OrderMainDtoMapper {
    int deleteByPrimaryKey(String omId);

    int insert(OrderMainDto record);

    int insertSelective(OrderMainDto record);

    OrderMainDto selectByPrimaryKey(String omId);

    int updateByPrimaryKeySelective(OrderMainDto record);

    int updateByPrimaryKey(OrderMainDto record);
}