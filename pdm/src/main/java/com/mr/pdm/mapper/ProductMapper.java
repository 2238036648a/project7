package com.mr.pdm.mapper;

import com.mr.pdm.vo.ProductTypeVO;
import com.mr.pdm.vo.ProductVO;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String pdId);

    int insert(ProductVO record);

    int insertSelective(ProductVO record);

    ProductVO selectByPrimaryKey(String pdId);

    int updateByPrimaryKeySelective(ProductVO record);

    int updateByPrimaryKey(ProductVO record);

    List<ProductVO> list();

    List<ProductTypeVO> findProductTypeList();

    List<ProductTypeVO> findProductList(ProductTypeVO record);

    List<ProductVO> findProductTypeListSql();

    ProductVO findProductById(String pdId);

}