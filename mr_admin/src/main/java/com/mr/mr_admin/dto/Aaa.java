package com.mr.mr_admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Aaa implements Serializable {
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

    @Override
    public String toString() {
        return "Aaa{" +
                "umId='" + umId + '\'' +
                ", umAccount='" + umAccount + '\'' +
                ", umPassword='" + umPassword + '\'' +
                ", umStatus=" + umStatus +
                ", cpName='" + cpName + '\'' +
                ", cpCode='" + cpCode + '\'' +
                ", cpPicUrl='" + cpPicUrl + '\'' +
                ", cpAhieve=" + cpAhieve +
                ", cpReduce=" + cpReduce +
                ", cpStorage=" + cpStorage +
                ", cpStatus=" + cpStatus +
                ", cpTypeName='" + cpTypeName + '\'' +
                '}';
    }



}
