package com.mr.mr_admin.mapper;

import com.mr.mr_admin.dto.UserDto;

public interface UserMapper {
    UserDto FindUserByName(UserDto user);

    UserDto userInfoFindUserByName(UserDto user);

    UserDto findCouponByUser(String username);
}
