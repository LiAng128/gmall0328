package com.liang.gmall.service;

import com.liang.gmall.beans.PmsProductSaleAttr;
import com.liang.gmall.beans.PmsSkuInfo;

import java.util.List;

public interface SkuService {

    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuInfo(String skuId);

    List<PmsProductSaleAttr> getSpuSaleAttrListCheckBySkuId(String skuId);
}
