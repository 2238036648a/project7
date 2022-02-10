package com.mr.pdm.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductVO extends ProductStorageVO implements Serializable {
    private String pdId;

    private String pdName;

    private String pdCode;

    private String pdPicUrl;

    private BigDecimal pdPrice;

    private Boolean pdStatus;

    private String pdTypeId;

    private Date createTime;

    private  String pdTypeName;

    private Integer num;

}