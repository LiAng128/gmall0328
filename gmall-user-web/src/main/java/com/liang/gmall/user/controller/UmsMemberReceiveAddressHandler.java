package com.liang.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liang.gmall.beans.UmsMemberReceiveAddress;
import com.liang.gmall.service.UmsMemberReceiveAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UmsMemberReceiveAddressHandler {

    @Reference
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @RequestMapping("/addReceiveAddress")
    @ResponseBody
    public String addReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress) {

        umsMemberReceiveAddressService.insertReceiveAddress(umsMemberReceiveAddress);

        return "ok";
    }

    @RequestMapping("/updateReceiveAddress")
    @ResponseBody
    public String updateReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress) {

        umsMemberReceiveAddressService.updateReceiveAddress(umsMemberReceiveAddress);

        return "ok";
    }

    @RequestMapping("/removeReceiveAddressById/{id}")
    @ResponseBody
    public String removeReceiveAddressById(@PathVariable String id) {

        umsMemberReceiveAddressService.deleteReceiveAddressById(id);

        return "ok";
    }

    @RequestMapping("/removeReceiveAddressByMemberId/{memberId}")
    @ResponseBody
    public String removeReceiveAddressByMemberId(@PathVariable String memberId) {

        umsMemberReceiveAddressService.deleteReceiveAddressByMemberId(memberId);

        return "ok";
    }

    @RequestMapping("/getAllReceiveAddressByMemberId/{memberId}")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@PathVariable String memberId) {

        List<UmsMemberReceiveAddress> addressList = umsMemberReceiveAddressService.selectReceiveAddressByMemberId(memberId);

        return addressList;
    }

    @RequestMapping("/getReceiveAddressById/{id}")
    @ResponseBody
    public UmsMemberReceiveAddress getReceiveAddressById(@PathVariable String id) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = umsMemberReceiveAddressService.selectReceiveAddressById(id);

        return umsMemberReceiveAddress;
    }

}
