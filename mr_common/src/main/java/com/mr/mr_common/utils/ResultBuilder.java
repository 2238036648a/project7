package com.mr.mr_common.utils;


import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.vo.CommonResult;

public class ResultBuilder<T> {


    private int errCode = ErrorEnum.SUCCESS_RESTUL.getErrCode();

    private String errMassage = ErrorEnum.SUCCESS_RESTUL.getErrMassage();

    private T data;

    private int count = 0;

    public ResultBuilder setErrCode(int errCode1) {
        if(errCode == 0){
            return this;
         }else{
            this.errCode = errCode;
        }
       return  this;
    }
    public ResultBuilder setCount(int count) {
        if(count == 0){
            return this;
        }else{
            this.count = count;
        }
        return  this;
    }
    public ResultBuilder setErrMassage(String errMassage) {
        if(null != errMassage && errMassage.equals("")){
            return this;
        }else{
            this.errMassage = errMassage;
        }
       return  this;
    }

    public ResultBuilder setData(T data) {
        if (data==null)
            return this;
        this.data = data;
        return this;
    }

    public CommonResult buider(){
        return new CommonResult(this.errCode,this.errMassage,this.data,this.count);
    }
}
