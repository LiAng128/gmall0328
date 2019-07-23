package com.liang.gmal.service;

import com.liang.gmall.beans.UmsMember;

import java.util.List;

public interface UmsMemberService {

    List<UmsMember> getAllUmsMember();

    UmsMember getUmsMemberById(String id);
}
