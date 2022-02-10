package com.mr.mr_admin.mapper;

import com.mr.mr_admin.dto.UserAddrDto;

import java.util.List;

public interface UserAddrDtoMapper {
    int deleteByPrimaryKey(String addrId);

    int insert(UserAddrDto record);

    int insertSelective(UserAddrDto record);

    UserAddrDto selectByPrimaryKey(String addrId);

    int updateByPrimaryKeySelective(UserAddrDto record);

    int updateByPrimaryKey(UserAddrDto record);

    List<UserAddrDto> list(String username);

    String getShengAddr(Integer shengId);

    String getShiAddr(Integer shiId);

    String getXianAddr(Integer xianId);
}