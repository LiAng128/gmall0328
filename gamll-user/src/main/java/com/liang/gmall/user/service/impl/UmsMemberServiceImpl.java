package com.liang.gmall.user.service.impl;


import com.liang.gmall.user.beans.UmsMember;
import com.liang.gmall.user.mapper.UmsMemberMapper;
import com.liang.gmall.user.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public List<UmsMember> getAllUmsMember() {

        List<UmsMember> umsMembers = umsMemberMapper.selectAllUmsMember();

        return umsMembers;
    }

    @Override
    public UmsMember getUmsMemberById(String id) {

        UmsMember umsMember = new UmsMember();

        umsMember.setId(id);

        return umsMemberMapper.selectOne(umsMember);

    }
}
