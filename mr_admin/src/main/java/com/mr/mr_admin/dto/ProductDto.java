package com.mr.mr_admin.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDto {
    private String pdId;

    private String pdName;

    private String pdCode;

    private String pdPicUrl;

    private BigDecimal pdPrice;

    private Boolean pdStatus;

    private String pdTypeId;

    private Date createTime;

    private String pdTypeName;

    private String pdTypeCode;

    @Override
    public String toString() {
        return "ProductDto{" +
                "pdId='" + pdId + '\'' +
                ", pdName='" + pdName + '\'' +
                ", pdCode='" + pdCode + '\'' +
                ", pdPicUrl='" + pdPicUrl + '\'' +
                ", pdPrice=" + pdPrice +
                ", pdStatus=" + pdStatus +
                ", pdTypeId='" + pdTypeId + '\'' +
                ", createTime=" + createTime +
                ", pdTypeName='" + pdTypeName + '\'' +
                ", pdTypeCode='" + pdTypeCode + '\'' +
                '}';
    }
}