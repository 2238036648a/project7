package com.mr.pdm.service;

import com.mr.mr_common.vo.CommonResult;

public interface ProductService {
    CommonResult findProductByTypeList();

    CommonResult findProductByTypeListSql();

    CommonResult findProductById(String pdId);

    CommonResult findProductByIdList(String pdId, Integer num);


}
