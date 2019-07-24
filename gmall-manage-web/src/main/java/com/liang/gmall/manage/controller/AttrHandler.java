package com.liang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liang.gmall.beans.PmsBaseAttrInfo;
import com.liang.gmall.beans.PmsBaseAttrValue;
import com.liang.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrHandler {

    @Reference
    private AttrService attrService;

    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){

        List<PmsBaseAttrValue> attrValues = attrService.getAttrValueList(attrId);

        return attrValues;

    }

    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        attrService.saveAttrInfo(pmsBaseAttrInfo);

        return "ok";

    }

    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrInfo(String catalog3Id){

        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.selectAttr(catalog3Id);

        return pmsBaseAttrInfos;

    }

}
