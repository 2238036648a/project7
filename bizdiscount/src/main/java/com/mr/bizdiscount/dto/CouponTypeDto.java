package com.mr.bizdiscount.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CouponTypeDto {

    private String cpTypeId;

    private String typeName;

    private String typeCode;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCpTypeId() {
        return cpTypeId;
    }

    public void setCpTypeId(String cpTypeId) {
        this.cpTypeId = cpTypeId;
    }
}