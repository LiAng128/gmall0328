package com.liang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liang.gmall.beans.PmsBaseCatalog1;
import com.liang.gmall.beans.PmsBaseCatalog2;
import com.liang.gmall.beans.PmsBaseCatalog3;
import com.liang.gmall.service.PmsBaseCatalog1Service;
import com.liang.gmall.service.PmsBaseCatalog2Service;
import com.liang.gmall.service.PmsBaseCatalog3Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class ManageHandler {

    @Reference
    private PmsBaseCatalog1Service pmsBaseCatalog1Service;

    @Reference
    private PmsBaseCatalog2Service pmsBaseCatalog2Service;

    @Reference
    private PmsBaseCatalog3Service pmsBaseCatalog3Service;

    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> catalog1s = pmsBaseCatalog1Service.selectAllCatalog1();

        return catalog1s;
    }

    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){

        List<PmsBaseCatalog2> catalog2s = pmsBaseCatalog2Service.selectCatalog2(catalog1Id);

        return catalog2s;
    }

    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){

        List<PmsBaseCatalog3> catalog3s = pmsBaseCatalog3Service.selectCatalog3(catalog2Id);

        return catalog3s;
    }

}
