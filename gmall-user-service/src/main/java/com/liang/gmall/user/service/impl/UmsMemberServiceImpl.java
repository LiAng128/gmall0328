package com.liang.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liang.gmall.service.UmsMemberService;
import com.liang.gmall.beans.UmsMember;
import com.liang.gmall.user.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    public void addUmsMember(UmsMember umsMember) {

        umsMemberMapper.insert(umsMember);

    }

    @Override
    public void deleteUmsMember(String id) {

        umsMemberMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void updateUmsMember(UmsMember umsMember) {

        umsMemberMapper.updateByPrimaryKey(umsMember);

    }
}
