package com.mr.pdm.service.impl;

import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import com.mr.pdm.mapper.PdStorageMapper;
import com.mr.pdm.mapper.ProductMapper;
import com.mr.pdm.service.ProductService;

import com.mr.pdm.vo.ProductTypeVO;
import com.mr.pdm.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private PdStorageMapper pdStorageMapper;

    @Override
    public CommonResult findProductByTypeList() {
       List<ProductTypeVO> list =  productMapper.findProductTypeList();
       if (list == null){
           return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                   ErrorEnum.USER_CHECK.getErrMassage());
       }
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.USER_CHECK.getErrMassage(),list.size(),list);
    }

    @Override
    public CommonResult findProductByTypeListSql() {

        List<ProductVO> list = productMapper.findProductTypeListSql();
        if (list == null){
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                    ErrorEnum.USER_CHECK.getErrMassage());
        }

        //1.需要有一个标记位来记录类型
        String typeId = null;
        List<ProductTypeVO> ptList = new ArrayList<>();
        ProductTypeVO ptVO = null;
        Set<ProductVO> proSet = null;
        for (int i=0;i<list.size();i++) {
            ProductVO pro = list.get(i);
            //第一次初始化
            if (null == typeId){
                typeId = pro.getPdId();
                ptVO = new ProductTypeVO();
                ptVO.setPdTypeId(pro.getPdId());
                ptVO.setPdTypeName(pro.getPdName());
                proSet = new HashSet<>();
            }
            //2.如果循环到的类型和标记的不一致则证明开启一个新的类型列表
            if (!typeId.equals(pro.getPdId())){
                ptVO.setProductSet(proSet);
                ptList.add(ptVO);
                typeId = pro.getPdId();
                //将上一轮循环的内容设置完成后进行清空数据
                ptVO = new ProductTypeVO();
                ptVO.setPdTypeId(pro.getPdId());
                ptVO.setPdTypeName(pro.getPdName());
                proSet = new HashSet<>();
            }
            if (typeId.equals(pro.getPdId())){
                proSet.add(pro);
            }
            //最后将最后一轮的数据进行加入
            if (i==list.size()-1){
                ptVO.setProductSet(proSet);
                ptList.add(ptVO);
            }

        }

        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.USER_CHECK.getErrMassage(),ptList.size(),ptList);
    }

    @Override
    public CommonResult findProductById(String pdId) {
        ProductVO productVO =  productMapper.findProductById(pdId);
        if (productVO == null){
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                    ErrorEnum.USER_CHECK.getErrMassage());
        }
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.USER_CHECK.getErrMassage(),productVO);
    }

    @Override
    public CommonResult findProductByIdList(String pdId, Integer num) {
        ProductVO productVO =  productMapper.findProductById(pdId);
        BigDecimal pdPrice = productVO.getPdPrice();
        productVO.setNum(num);
        if (productVO == null){
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                    ErrorEnum.USER_CHECK.getErrMassage());
        }
        return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(),
                ErrorEnum.USER_CHECK.getErrMassage(),productVO);
    }
}
