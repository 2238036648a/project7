package com.mr.mr_admin.swagger21.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class UserEntity {

    @ApiModelProperty(value = "id",required = false) //用于实体属性，标注该属性的说明，require 为false时不会在页面上进行展示该属性
    private String id;

    @ApiModelProperty(value = "姓名", example = "姓名111",required = false) //用于实体属性，标注该属性的说明，require 为false
    private  String name;

    public UserEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserEntity() {

    }
}
