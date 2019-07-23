package com.liang.gmall.service;

import com.liang.gmall.beans.UmsMember;

import java.util.List;

public interface UmsMemberService {

    List<UmsMember> getAllUmsMember();

    UmsMember getUmsMemberById(String id);

    void addUmsMember(UmsMember umsMember);

    void deleteUmsMember(String id);

    void updateUmsMember(UmsMember umsMember);
}
