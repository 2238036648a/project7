package com.mr.mr_admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@ApiModel("CouponDto")
public class CouponDto {

    @ApiModelProperty(name="cpId",value = "aaa",required = true)
    private String cpId;

    @ApiModelProperty(name="cpName",required = false)
    private String cpName;

    @ApiModelProperty(name="cpCode",required = false)
    private String cpCode;

    @ApiModelProperty(name="cpPicUrl",required = false)
    private String cpPicUrl;

    @ApiModelProperty(name="cpAhieve",required = false)
    private BigDecimal cpAhieve;

    @ApiModelProperty(name="cpReduce",required = false)
    private BigDecimal cpReduce;

    @ApiModelProperty(name="cpStorage",required = false)
    private Integer cpStorage;

    @ApiModelProperty(name="cpStatus",required = false)
    private Integer cpStatus;

    @ApiModelProperty(name="cpTypeId",required = false)
    private String cpTypeId;

    @ApiModelProperty(name="createTime",required = false)
    private Date createTime;

    @ApiModelProperty(name="typeName",required = false)
    private String typeName;

    @ApiModelProperty(name="typeCode",required = false)
    private String typeCode;

    @ApiModelProperty(name="cpVersion",required = false)
    private Integer cpVersion;

    public Integer getCpVersion() {
        return cpVersion;
    }

    public void setCpVersion(Integer cpVersion) {
        this.cpVersion = cpVersion;
    }

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

    @Override
    public String toString() {
        return "CouponDto{" +
                "cpId='" + cpId + '\'' +
                ", cpName='" + cpName + '\'' +
                ", cpCode='" + cpCode + '\'' +
                ", cpPicUrl='" + cpPicUrl + '\'' +
                ", cpAhieve=" + cpAhieve +
                ", cpReduce=" + cpReduce +
                ", cpStorage=" + cpStorage +
                ", cpStatus=" + cpStatus +
                ", cpTypeId='" + cpTypeId + '\'' +
                ", createTime=" + createTime +
                ", typeName='" + typeName + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", cpVersion=" + cpVersion +
                '}';
    }
}