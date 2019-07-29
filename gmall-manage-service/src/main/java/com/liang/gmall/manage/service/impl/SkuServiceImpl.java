package com.liang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liang.gmall.beans.*;
import com.liang.gmall.manage.mapper.*;
import com.liang.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        pmsSkuInfoMapper.insertSelective(pmsSkuInfo);

        String skuInfoId = pmsSkuInfo.getId();

        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();

        for (PmsSkuImage pmsSkuImage : skuImageList) {

            pmsSkuImage.setSkuId(skuInfoId);

            pmsSkuImageMapper.insertSelective(pmsSkuImage);

        }

        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();

        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {

            pmsSkuAttrValue.setSkuId(skuInfoId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);

        }

        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();

        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {

            pmsSkuSaleAttrValue.setSkuId(skuInfoId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);

        }

    }

    @Override
    public PmsSkuInfo getSkuInfo(String skuId) {

        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();

        pmsSkuInfo.setId(skuId);

        PmsSkuInfo skuInfo = pmsSkuInfoMapper.selectOne(pmsSkuInfo);

        PmsSkuImage pmsSkuImage = new PmsSkuImage();

        pmsSkuImage.setSkuId(skuId);

        List<PmsSkuImage> pmsSkuImages = pmsSkuImageMapper.select(pmsSkuImage);

        skuInfo.setSkuImageList(pmsSkuImages);


        return skuInfo;
    }

    @Override
    public List<PmsProductSaleAttr> getSpuSaleAttrListCheckBySkuId(String skuId) {

        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectByPrimaryKey(skuId);

        String productId = pmsSkuInfo.getProductId();

        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();

        pmsProductSaleAttr.setProductId(productId);

        List<PmsProductSaleAttr> productSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);

        for (PmsProductSaleAttr productSaleAttr : productSaleAttrs) {

            String saleAttrId = productSaleAttr.getSaleAttrId();

            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();

            pmsProductSaleAttrValue.setProductId(productId);
            pmsProductSaleAttrValue.setSaleAttrId(saleAttrId);

            List<PmsProductSaleAttrValue> productSaleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);

            productSaleAttr.setSpuSaleAttrValueList(productSaleAttrValues);

        }

        Map<String, List<PmsProductSaleAttrValue>> productSaleAttrsMap = new HashMap<>();

        for (PmsProductSaleAttr productSaleAttr : productSaleAttrs) {

            productSaleAttrsMap.put(productSaleAttr.getSaleAttrName(), productSaleAttr.getSpuSaleAttrValueList());

        }

        PmsSkuSaleAttrValue pmsSkuSaleAttrValue = new PmsSkuSaleAttrValue();

        pmsSkuSaleAttrValue.setSkuId(skuId);

        List<PmsSkuSaleAttrValue> skuSaleAttrValues = pmsSkuSaleAttrValueMapper.select(pmsSkuSaleAttrValue);

        for (PmsSkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValues) {

            String saleAttrName = skuSaleAttrValue.getSaleAttrName();
            String saleAttrValueName = skuSaleAttrValue.getSaleAttrValueName();

            List<PmsProductSaleAttrValue> productSaleAttrValues = productSaleAttrsMap.get(saleAttrName);

            for (PmsProductSaleAttrValue productSaleAttrValue : productSaleAttrValues) {

                if (saleAttrValueName.equals(productSaleAttrValue.getSaleAttrValueName())){

                    productSaleAttrValue.setIsChecked("1");

                } else {

                    productSaleAttrValue.setIsChecked("0");

                }

            }

        }

        for (PmsProductSaleAttr productSaleAttr : productSaleAttrs) {

            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = productSaleAttrsMap.get(productSaleAttr.getSaleAttrName());

            productSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);

        }

        return productSaleAttrs;
    }
}
