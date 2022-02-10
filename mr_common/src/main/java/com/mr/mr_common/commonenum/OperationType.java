package com.mr.mr_common.commonenum;

public enum OperationType {
    GETTYPE("GET"),
    POSTTYPE("POST"),
    DELETETYPE("DELETE"),
    PUTTYPE("PUT")
    ;

    private String operateType;

    public String getOperateType() {
        return operateType;
    }

    OperationType(String operateType) {
        this.operateType = operateType;
    }
}
