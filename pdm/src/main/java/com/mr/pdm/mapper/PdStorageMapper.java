package com.mr.pdm.mapper;

import com.mr.pdm.vo.ProductStorageVO;

import java.util.List;

public interface PdStorageMapper {
    List<ProductStorageVO> findStorage(String pdId);

    int updateByStorage(ProductStorageVO storage);
}
