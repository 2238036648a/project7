package com.mr.mr_common.commonenum;

public enum ErrorEnum {
    SUCCESS_RESTUL(0,""),
    USER_CHECK(300,"user failure"),
    DB_CHECKED_ERROR(301,"未查询到相关数据"),
    USER_CHECKED_ERROR(302,"未查询到相关用户信息"),
    USER_REDIS_KEEY(302,"");

    ErrorEnum(int errCode, String errMassage) {
        this.errCode = errCode;
        this.errMassage = errMassage;
    }

    private int errCode;

    private String errMassage;

    public String getErrMassage() {
        return errMassage;
    }

    public int getErrCode() {
        return errCode;
    }
}
