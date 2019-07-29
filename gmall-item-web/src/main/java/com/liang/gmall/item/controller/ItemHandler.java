package com.liang.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liang.gmall.beans.PmsProductSaleAttr;
import com.liang.gmall.beans.PmsSkuInfo;
import com.liang.gmall.beans.PmsSkuSaleAttrValue;
import com.liang.gmall.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemHandler {

    @Reference
    private SkuService skuService;

    @RequestMapping("/{skuId}.html")
    public String getSkuInfo(@PathVariable("skuId") String skuId, Model model) {

        PmsSkuInfo pmsSkuInfo = skuService.getSkuInfo(skuId);

        model.addAttribute("skuInfo", pmsSkuInfo);

        List<PmsProductSaleAttr> pmsSkuSaleAttrValues = skuService.getSpuSaleAttrListCheckBySkuId(skuId);

        model.addAttribute("spuSaleAttrListCheckBySku", pmsSkuSaleAttrValues);

        return "item";

    }
}
