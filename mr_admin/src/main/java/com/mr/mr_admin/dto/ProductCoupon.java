package com.mr.mr_admin.dto;

import lombok.Data;

@Data
public class ProductCoupon {

    private String pcId;

    private String PtId;

    private String cpId;

    @Override
    public String toString() {
        return "ProductCoupon{" +
                "pcId='" + pcId + '\'' +
                ", PtId='" + PtId + '\'' +
                ", cpId='" + cpId + '\'' +
                '}';
    }
}
