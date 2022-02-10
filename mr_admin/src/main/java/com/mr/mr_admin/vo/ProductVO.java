package com.mr.mr_admin.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class ProductVO  extends TempVo{
    private String pdId;

    private String pdName;

    private String pdCode;

    private String pdPicUrl;

    private BigDecimal pdPrice;

    private Boolean pdStatus;

    private String pdTypeId;

    private Date createTime;

}