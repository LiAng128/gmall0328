package com.liang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liang.gmall.beans.PmsSkuInfo;
import com.liang.gmall.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class SkuHandler {

    @Reference
    private SkuService skuService;

    @RequestMapping("/saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){

        skuService.saveSkuInfo(pmsSkuInfo);

        return "ok";

    }

}
