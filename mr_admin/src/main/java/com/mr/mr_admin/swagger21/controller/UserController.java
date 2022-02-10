package com.mr.mr_admin.swagger21.controller;

import com.mr.mr_admin.swagger21.entity.UserEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(value = "测试接口1",tags = {"测试接口操作"})
@RestController
@RequestMapping("user1")
public class UserController {

    @ApiImplicitParam(name = "id",value = "测试参数id",required = true,dataType = "String")
    @PostMapping("ss")
    public Object ss(String id){
        return id;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "测试两个参数id2",required = true,dataType = "String"),
            @ApiImplicitParam(name = "name",value = "测试两个参数name2",required = true,dataType = "String")
    })
    @PostMapping("ss1")
    public Object test2(String id,String name){
        return null;
    }

    @ApiOperation("更改用户信息")
    @PostMapping("/object")
    public UserEntity updateUserInfo(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) UserEntity user){
        user.setId("aaa");
        user.setName("aaa1");
        return user;
    }
}
