package com.mr.mr_common.commonenum;

public enum OperationUnit {

    STUDENT_UNIT("STUDENT"),
    USER_UNIT("USER"),
    SYSTEM_UNIT("SYSTEM"),
    ORDER_UNIT("ORDER");

    private String operateUnit;

    OperationUnit(String operateUnit) {
        this.operateUnit = operateUnit;
    }


    public String getOperateUnit(){
        return this.operateUnit;
    }
}
