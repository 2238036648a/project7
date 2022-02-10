package com.mr.mr_admin.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailDto {
    private String odId;

    private String omId;

    private String odName;

    private String odCode;

    private String pdId;

    private BigDecimal odPrice;

    private Byte pdNumber;

    private BigDecimal odTotalprice;

    private BigDecimal odCouponprice;

    private String cpId;

    private Date createTime;

    private String userId;

    public String getOdId() {
        return odId;
    }

    public void setOdId(String odId) {
        this.odId = odId == null ? null : odId.trim();
    }

    public String getOmId() {
        return omId;
    }

    public void setOmId(String omId) {
        this.omId = omId == null ? null : omId.trim();
    }

    public String getOdName() {
        return odName;
    }

    public void setOdName(String odName) {
        this.odName = odName == null ? null : odName.trim();
    }

    public String getOdCode() {
        return odCode;
    }

    public void setOdCode(String odCode) {
        this.odCode = odCode == null ? null : odCode.trim();
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId == null ? null : pdId.trim();
    }

    public BigDecimal getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(BigDecimal odPrice) {
        this.odPrice = odPrice;
    }

    public Byte getPdNumber() {
        return pdNumber;
    }

    public void setPdNumber(Byte pdNumber) {
        this.pdNumber = pdNumber;
    }

    public BigDecimal getOdTotalprice() {
        return odTotalprice;
    }

    public void setOdTotalprice(BigDecimal odTotalprice) {
        this.odTotalprice = odTotalprice;
    }

    public BigDecimal getOdCouponprice() {
        return odCouponprice;
    }

    public void setOdCouponprice(BigDecimal odCouponprice) {
        this.odCouponprice = odCouponprice;
    }

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId == null ? null : cpId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}