package com.liang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liang.gmall.beans.*;
import com.liang.gmall.manage.mapper.*;
import com.liang.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {

        PmsProductInfo pmsProductInfo = new PmsProductInfo();

        pmsProductInfo.setCatalog3Id(catalog3Id);

        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);

        return pmsProductInfos;

    }

    @Override
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrMapper.selectAll();

        return pmsBaseSaleAttrs;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {

        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        String productInfoId = pmsProductInfo.getId();

        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();

        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {

            String saleAttrId = pmsProductSaleAttr.getSaleAttrId();
            String saleAttrName = pmsProductSaleAttr.getSaleAttrName();

            PmsProductSaleAttr productSaleAttr = new PmsProductSaleAttr();

            productSaleAttr.setProductId(productInfoId);
            productSaleAttr.setSaleAttrId(saleAttrId);
            productSaleAttr.setSaleAttrName(saleAttrName);

            pmsProductSaleAttrMapper.insertSelective(productSaleAttr);

            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();

            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {

                String saleAttrValueName = pmsProductSaleAttrValue.getSaleAttrValueName();

                PmsProductSaleAttrValue saleAttrValue = new PmsProductSaleAttrValue();

                saleAttrValue.setProductId(productInfoId);
                saleAttrValue.setSaleAttrId(saleAttrId);
                saleAttrValue.setSaleAttrValueName(saleAttrValueName);

                pmsProductSaleAttrValueMapper.insertSelective(saleAttrValue);

            }

        }


        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();

        for (PmsProductImage pmsProductImage : spuImageList) {

            pmsProductImage.setProductId(productInfoId);

            pmsProductImageMapper.insertSelective(pmsProductImage);

        }

    }
}
