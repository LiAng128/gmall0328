package com.liang.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liang.gmall.beans.UmsMemberReceiveAddress;
import com.liang.gmall.service.UmsMemberReceiveAddressService;
import com.liang.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMemberReceiveAddress> selectReceiveAddressByMemberId(String memberId) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();

        umsMemberReceiveAddress.setMemberId(memberId);

        List<UmsMemberReceiveAddress> addressList = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

        return addressList;

    }

    @Override
    public void insertReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {

        umsMemberReceiveAddressMapper.insert(umsMemberReceiveAddress);

    }

    @Override
    public void deleteReceiveAddressById(String id) {

        umsMemberReceiveAddressMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void updateReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {

        umsMemberReceiveAddressMapper.updateByPrimaryKey(umsMemberReceiveAddress);

    }

    @Override
    public void deleteReceiveAddressByMemberId(String memberId) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();

        umsMemberReceiveAddress.setMemberId(memberId);

        umsMemberReceiveAddressMapper.delete(umsMemberReceiveAddress);

    }

    @Override
    public UmsMemberReceiveAddress selectReceiveAddressById(String id) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();

        umsMemberReceiveAddress.setId(id);

        UmsMemberReceiveAddress receiveAddress = umsMemberReceiveAddressMapper.selectOne(umsMemberReceiveAddress);

        return receiveAddress;

    }
}
