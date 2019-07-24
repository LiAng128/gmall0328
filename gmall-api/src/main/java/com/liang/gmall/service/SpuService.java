package com.liang.gmall.service;

import com.liang.gmall.beans.PmsBaseSaleAttr;
import com.liang.gmall.beans.PmsProductInfo;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> getSpuList(String catalog3Id);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();

    void saveSpuInfo(PmsProductInfo pmsProductInfo);
}
