package com.mr.mr_common.annotation;



import com.mr.mr_common.commonenum.OperationType;
import com.mr.mr_common.commonenum.OperationUnit;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemAsp {

    // 请求详情   default 代表默认信息
    String detail() default "";
    int level() default 0;

    //请求类型
    OperationType type() default  OperationType.GETTYPE;
    //请求方法
    OperationUnit unit() default  OperationUnit.ORDER_UNIT;
}
