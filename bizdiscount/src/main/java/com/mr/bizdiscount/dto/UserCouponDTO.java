package com.mr.bizdiscount.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserCouponDTO implements Serializable {

    private String ucId;

    private String ucCode;

    private String picUrl;

    private String cpId;

    private String userId;

    private Integer status;

    private String orderId;

    private Date createTime;

    @Override
    public String toString() {
        return "UserCouponVO{" +
                "ucId='" + ucId + '\'' +
                ", ucCode='" + ucCode + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", cpId='" + cpId + '\'' +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                ", orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
