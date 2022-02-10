package com.mr.mr_common.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMainDto {
    private String omId;

    private String omName;

    private String omCode;

    private String omAddress;

    private BigDecimal omTotalprice;

    private Date createTime;

    public String getOmId() {
        return omId;
    }

    public void setOmId(String omId) {
        this.omId = omId == null ? null : omId.trim();
    }

    public String getOmName() {
        return omName;
    }

    public void setOmName(String omName) {
        this.omName = omName == null ? null : omName.trim();
    }

    public String getOmCode() {
        return omCode;
    }

    public void setOmCode(String omCode) {
        this.omCode = omCode == null ? null : omCode.trim();
    }

    public String getOmAddress() {
        return omAddress;
    }

    public void setOmAddress(String omAddress) {
        this.omAddress = omAddress == null ? null : omAddress.trim();
    }

    public BigDecimal getOmTotalprice() {
        return omTotalprice;
    }

    public void setOmTotalprice(BigDecimal omTotalprice) {
        this.omTotalprice = omTotalprice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}