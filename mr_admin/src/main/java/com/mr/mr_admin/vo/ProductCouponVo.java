package com.mr.mr_admin.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductCouponVo extends ProductStorageVO{

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

    private String pcId;

    private String ptId;

    private String cpId;

    @Override
    public String toString() {
        return "ProductCouponVo{" +
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
                ", pcId='" + pcId + '\'' +
                ", ptId='" + ptId + '\'' +
                ", cpId='" + cpId + '\'' +
                '}';
    }
}
