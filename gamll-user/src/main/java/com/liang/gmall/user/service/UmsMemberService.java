package com.liang.gmall.user.service;

import com.liang.gmall.user.beans.UmsMember;

import java.util.List;

public interface UmsMemberService {

    List<UmsMember> getAllUmsMember();

    UmsMember getUmsMemberById(String id);
}
