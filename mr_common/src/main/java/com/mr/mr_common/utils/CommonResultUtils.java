package com.mr.mr_common.utils;

import com.mr.mr_common.vo.CommonResult;

public class CommonResultUtils {

    //重载
    public static CommonResult getResult(int errCode,String errMassage){
        return new ResultBuilder().setErrCode(errCode).setErrMassage(errMassage).buider();
    }

    public static <T> CommonResult getResult(int errorCode,String errorMessage,int count,T data){
        return new ResultBuilder().setErrCode(errorCode).setErrMassage(errorMessage).setCount(count).setData(data).buider();
    }

    public static <T> CommonResult getResult(int errCode,String errMassage,T data){
        return new ResultBuilder().setErrCode(errCode).setErrMassage(errMassage).setData(data).buider();
    }

    public static <T> CommonResult getResult(T  data){ return new ResultBuilder().setData(data).buider();
    }
}
