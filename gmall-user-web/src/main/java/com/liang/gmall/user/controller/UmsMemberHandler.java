package com.liang.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liang.gmal.service.UmsMemberService;
import com.liang.gmall.beans.UmsMember;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UmsMemberHandler {

    @Reference
    private UmsMemberService umsMemberService;

    @RequestMapping("/get/umsMember/by/id/{id}")
    @ResponseBody
    public UmsMember getUmsMemberById(@PathVariable String id){

        UmsMember umsMember = umsMemberService.getUmsMemberById(id);

        return umsMember;
    }

    @RequestMapping("/get/all/umsMember")
    @ResponseBody
    public List<UmsMember> getAllUmsMember() {

        List<UmsMember> umsMembers = umsMemberService.getAllUmsMember();

        return umsMembers;
    }
}
