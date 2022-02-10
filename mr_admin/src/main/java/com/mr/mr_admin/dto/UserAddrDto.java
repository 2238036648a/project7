package com.mr.mr_admin.dto;

public class UserAddrDto {
    private String addrId;

    private String umId;

    private Integer shengId;

    private Integer shiId;

    private Integer xianId;

    private String street;

    private String umTelephone;

    private String consignee;

    private String sheng;

    private String shi;

    private String xian;

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId == null ? null : addrId.trim();
    }

    public String getUmId() {
        return umId;
    }

    public void setUmId(String umId) {
        this.umId = umId == null ? null : umId.trim();
    }

    public Integer getShengId() {
        return shengId;
    }

    public void setShengId(Integer shengId) {
        this.shengId = shengId;
    }

    public Integer getShiId() {
        return shiId;
    }

    public void setShiId(Integer shiId) {
        this.shiId = shiId;
    }

    public Integer getXianId() {
        return xianId;
    }

    public void setXianId(Integer xianId) {
        this.xianId = xianId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getUmTelephone() {
        return umTelephone;
    }

    public void setUmTelephone(String umTelephone) {
        this.umTelephone = umTelephone == null ? null : umTelephone.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }
}