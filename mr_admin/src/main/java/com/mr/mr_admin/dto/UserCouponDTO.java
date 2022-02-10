package com.mr.mr_admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

    private Set<CouponDto> couponDto;

    @Override
    public String toString() {
        return "UserCouponDTO{" +
                "ucId='" + ucId + '\'' +
                ", ucCode='" + ucCode + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", cpId='" + cpId + '\'' +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                ", orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", couponDto=" + couponDto +
                '}';
    }
}
