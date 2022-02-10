package com.mr.mr_admin.dto;

public class ProductTypeDto {
    private String pdTypeId;

    private String pdTypeName;

    private String pdTypeCode;

    public String getPdTypeId() {
        return pdTypeId;
    }

    public void setPdTypeId(String pdTypeId) {
        this.pdTypeId = pdTypeId == null ? null : pdTypeId.trim();
    }

    public String getPdTypeName() {
        return pdTypeName;
    }

    public void setPdTypeName(String pdTypeName) {
        this.pdTypeName = pdTypeName == null ? null : pdTypeName.trim();
    }

    public String getPdTypeCode() {
        return pdTypeCode;
    }

    public void setPdTypeCode(String pdTypeCode) {
        this.pdTypeCode = pdTypeCode == null ? null : pdTypeCode.trim();
    }

    @Override
    public String toString() {
        return "ProductTypeDto{" +
                "pdTypeId='" + pdTypeId + '\'' +
                ", pdTypeName='" + pdTypeName + '\'' +
                ", pdTypeCode='" + pdTypeCode + '\'' +
                '}';
    }
}