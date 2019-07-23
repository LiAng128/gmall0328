package com.liang.gmall.service;

import com.liang.gmall.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService {

    List<UmsMemberReceiveAddress> selectReceiveAddressByMemberId(String memberId);

    void insertReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    void deleteReceiveAddressById(String id);

    void updateReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    void deleteReceiveAddressByMemberId(String memberId);

    UmsMemberReceiveAddress selectReceiveAddressById(String id);
}
