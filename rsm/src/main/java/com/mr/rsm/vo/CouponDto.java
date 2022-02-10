package com.mr.rsm.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CouponDto {
    private String cpId;

    private String cpName;

    private String cpCode;

    private String cpPicUrl;

    private BigDecimal cpAhieve;

    private BigDecimal cpReduce;

    private Byte cpStorage;

    private Integer cpStatus;

    private String cpTypeId;

    private Date createTime;

    private String typeName;

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getCpPicUrl() {
        return cpPicUrl;
    }

    public void setCpPicUrl(String cpPicUrl) {
        this.cpPicUrl = cpPicUrl;
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

    public Byte getCpStorage() {
        return cpStorage;
    }

    public void setCpStorage(Byte cpStorage) {
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
        this.cpTypeId = cpTypeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}