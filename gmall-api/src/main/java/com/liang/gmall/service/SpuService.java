package com.liang.gmall.service;

import com.liang.gmall.beans.PmsBaseSaleAttr;
import com.liang.gmall.beans.PmsProductImage;
import com.liang.gmall.beans.PmsProductInfo;
import com.liang.gmall.beans.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> getSpuList(String catalog3Id);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);
}
