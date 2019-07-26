package com.liang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liang.gmall.beans.PmsBaseSaleAttr;
import com.liang.gmall.beans.PmsProductInfo;
import com.liang.gmall.service.SpuService;
import com.liang.gmall.utils.MyUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuHandler {

    @Reference
    private SpuService spuService;

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(MultipartFile file){

        String uploadImg = MyUploadUtils.uploadImg(file);

        return uploadImg;

    }

    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        spuService.saveSpuInfo(pmsProductInfo);

        return "ok";

    }

    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> getBaseSaleAttrList(){

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = spuService.getBaseSaleAttrList();

        return pmsBaseSaleAttrs;

    }

    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> getSpuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfos = spuService.getSpuList(catalog3Id);

        return pmsProductInfos;

    }

}
