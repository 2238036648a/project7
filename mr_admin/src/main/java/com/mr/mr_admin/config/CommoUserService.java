package com.mr.mr_admin.config;

import com.mr.mr_admin.dto.UserDto;
import com.mr.mr_admin.redis.RedisUtils;
import com.mr.mr_admin.dto.RoleDto;
import com.mr.mr_admin.mapper.RoleMapper;
import com.mr.mr_admin.mapper.UserMapper;
import com.mr.mr_common.common.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommoUserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDto user = new UserDto();
        user.setUmAccount(s);
        UserDto  userDto = userMapper.FindUserByName(user);
        //将用户信息放入redis缓存中
        redisUtils.setHashKeyValue(CommonConstants.USER_REDIS_KEY,user.getUmAccount(),userDto);
        List<RoleDto> roleList = roleMapper.findRoleByUser(user);

        List<GrantedAuthority> GrantedAuthorities = new ArrayList<>();

        for (RoleDto role: roleList) {
            GrantedAuthorities.add(new SimpleGrantedAuthority(role.getRlName()));
        }
        return new UserDetailsTool(userDto,GrantedAuthorities);
    }
}
