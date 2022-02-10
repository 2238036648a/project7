package com.mr.mr_admin.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserCouponVo implements Serializable {

    private String cpId;

    private String cpTypeId;

    private String umId;

    private String umAccount;

    private String umPassword;

    private Integer umStatus;

    private String cpName;

    private String cpCode;

    private String cpPicUrl;

    private BigDecimal cpAhieve;

    private BigDecimal cpReduce;

    private Integer cpStorage;

    private Integer cpStatus;

    private String cpTypeName;

    private  Integer isAvilable;

    private String msg;

    private Integer status;

    private BigDecimal totalPrice;


    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getCpTypeId() {
        return cpTypeId;
    }

    public void setCpTypeId(String cpTypeId) {
        this.cpTypeId = cpTypeId;
    }

    public String getUmId() {
        return umId;
    }

    public void setUmId(String umId) {
        this.umId = umId;
    }

    public String getUmAccount() {
        return umAccount;
    }

    public void setUmAccount(String umAccount) {
        this.umAccount = umAccount;
    }

    public String getUmPassword() {
        return umPassword;
    }

    public void setUmPassword(String umPassword) {
        this.umPassword = umPassword;
    }

    public Integer getUmStatus() {
        return umStatus;
    }

    public void setUmStatus(Integer umStatus) {
        this.umStatus = umStatus;
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

    public String getCpTypeName() {
        return cpTypeName;
    }

    public void setCpTypeName(String cpTypeName) {
        this.cpTypeName = cpTypeName;
    }

    public Integer getIsAvilable() {
        return isAvilable;
    }

    public void setIsAvilable(Integer isAvilable) {
        this.isAvilable = isAvilable;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
