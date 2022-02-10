package com.mr.mr_common.vo;

public class CommonResult<T> {

    private int errCode = 0;

    private String errMassage;

    private T data;
    //页数
    private int count;

    public CommonResult(int errCode, String errMassage, T data, int count) {
        this.errCode = errCode;
        this.errMassage = errMassage;
        this.data = data;
        this.count = count;
    }


    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMassage() {
        return errMassage;
    }

    public void setErrMassage(String errMassage) {
        this.errMassage = errMassage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CommonResult() {

    }

}
