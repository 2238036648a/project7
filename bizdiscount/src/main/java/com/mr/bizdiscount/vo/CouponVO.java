package com.mr.bizdiscount.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponVO implements Serializable {
    private String cpId;

    private String cpName;

    private String cpCode;

    private String cpPicUrl;

    private BigDecimal cpAhieve;

    private BigDecimal cpReduce;

    private Integer cpStorage;

    private Integer cpStatus;

    private String cpTypeId;

    private Date createTime;

    private Integer cpVersion;

    public Integer getCpVersion() {
        return cpVersion;
    }

    public void setCpVersion(Integer cpVersion) {
        this.cpVersion = cpVersion;
    }
    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId == null ? null : cpId.trim();
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName == null ? null : cpName.trim();
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode == null ? null : cpCode.trim();
    }

    public String getCpPicUrl() {
        return cpPicUrl;
    }

    public void setCpPicUrl(String cpPicUrl) {
        this.cpPicUrl = cpPicUrl == null ? null : cpPicUrl.trim();
    }

    public BigDecimal getCpAhieve() {
        return cpAhieve;
    }

    public void setCpAhieve(BigDecimal cpAhieve) {
        this.cpAhieve = cpAhieve;
    }

    public BigDecimal getCpReduce() {
        return cpReduce;
    }

    public void setCpReduce(BigDecimal cpReduce) {
        this.cpReduce = cpReduce;
    }

    public Integer getCpStorage() {
        return cpStorage;
    }

    public void setCpStorage(Integer cpStorage) {
        this.cpStorage = cpStorage;
    }

    public Integer getCpStatus() {
        return cpStatus;
    }

    public void setCpStatus(Integer cpStatus) {
        this.cpStatus = cpStatus;
    }

    public String getCpTypeId() {
        return cpTypeId;
    }

    public void setCpTypeId(String cpTypeId) {
        this.cpTypeId = cpTypeId == null ? null : cpTypeId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}