package com.mr.mr_admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
@ApiModel
public class UserDto implements Serializable {

    @ApiModelProperty(name = "umId")
    private String umId;

    @ApiModelProperty(name = "umAccount")
    private String umAccount;

    @ApiModelProperty(name = "umPassword")
    private String umPassword;

    @ApiModelProperty(name = "umPhone")
    private String umPhone;

    @ApiModelProperty(name = "umStatus")
    private Byte umStatus;

    @ApiModelProperty(name = "umPhint")
    private Byte umPhint;

    @ApiModelProperty(name = "umRemark")
    private String umRemark;

    @ApiModelProperty(name = "umTelphone")
    private String umTelphone;

    @ApiModelProperty(name = "umNickname")
    private String umNickname;

    @ApiModelProperty(name = "umBalance")
    private BigDecimal umBalance;

    //用户优惠券信息
    private List<Map> ucCode;

    private Set<UserCouponDTO> userCouponDto;

    private Set<CouponDto> couponDto;


    public Set<CouponDto> getCouponDto() {
        return couponDto;
    }

    public void setCouponDto(Set<CouponDto> couponDto) {
        this.couponDto = couponDto;
    }

    public Set<UserCouponDTO> getUserCouponDto() {
        return userCouponDto;
    }

    public void setUserCouponDto(Set<UserCouponDTO> userDto) {
        this.userCouponDto = userDto;
    }

    public List<Map> getUcCode() {
        return ucCode;
    }

    public void setUcCode(List<Map> ucCode) {
        this.ucCode = ucCode;
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

    public String getUmPhone() {
        return umPhone;
    }

    public void setUmPhone(String umPhone) {
        this.umPhone = umPhone;
    }

    public Byte getUmStatus() {
        return umStatus;
    }

    public void setUmStatus(Byte umStatus) {
        this.umStatus = umStatus;
    }

    public Byte getUmPhint() {
        return umPhint;
    }

    public void setUmPhint(Byte umPhint) {
        this.umPhint = umPhint;
    }

    public String getUmRemark() {
        return umRemark;
    }

    public void setUmRemark(String umRemark) {
        this.umRemark = umRemark;
    }

    public String getUmTelphone() {
        return umTelphone;
    }

    public void setUmTelphone(String umTelphone) {
        this.umTelphone = umTelphone;
    }

    public String getUmNickname() {
        return umNickname;
    }

    public void setUmNickname(String umNickname) {
        this.umNickname = umNickname;
    }

    public BigDecimal getUmBalance() {
        return umBalance;
    }

    public void setUmBalance(BigDecimal umBalance) {
        this.umBalance = umBalance;
    }
}
