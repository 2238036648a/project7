package com.mr.mr_admin.mapper;

import com.mr.mr_admin.dto.RoleDto;
import com.mr.mr_admin.dto.UserDto;

import java.util.List;

public interface RoleMapper {
    List<RoleDto> findRoleByUser(UserDto user);
}
