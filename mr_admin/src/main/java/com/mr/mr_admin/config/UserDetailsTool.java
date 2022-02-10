package com.mr.mr_admin.config;

import com.mr.mr_admin.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//UserDetails通过用户名来加载用户
public class UserDetailsTool implements UserDetails {



    private UserDto userDto;

    private List<GrantedAuthority> roleList;

    public UserDetailsTool(UserDto userDto, List<GrantedAuthority> roleList) {
        this.userDto = userDto;
        this.roleList = roleList;
    }

    public UserDetailsTool() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleList;

      /*  return roleList.stream() //stream() − 为集合创建串行流
                .map(role->new SimpleGrantedAuthority(role.getRlId()+":"+role.getRlName()+":"+role.getRlCode()))
                .collect(Collectors.toList());*/
    }




    @Override
    public String getPassword() {
        return userDto.getUmPassword();
    }

    @Override
    public String getUsername() {
        return userDto.getUmAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userDto.getUmStatus()==0?true:false;//判断账号是否可以用
    }
}
