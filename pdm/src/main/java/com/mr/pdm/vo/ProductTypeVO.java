package com.mr.pdm.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ProductTypeVO implements Serializable {
    private String pdTypeId;

    private String pdTypeName;

    private String pdTypeCode;

    private Set<ProductVO> productSet;
    @Override
    public String toString() {
        return "ProductTypeDto{" +
                "pdTypeId='" + pdTypeId + '\'' +
                ", pdTypeName='" + pdTypeName + '\'' +
                ", pdTypeCode='" + pdTypeCode + '\'' +
                ", productSet='" + productSet + '\'' +
                '}';
    }
}