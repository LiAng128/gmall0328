package com.liang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liang.gmall.beans.PmsBaseCatalog1;
import com.liang.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.liang.gmall.service.PmsBaseCatalog1Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsBaseCatalog1ServiceImpl implements PmsBaseCatalog1Service {

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Override
    public List<PmsBaseCatalog1> selectAllCatalog1() {

        List<PmsBaseCatalog1> catalog1s = pmsBaseCatalog1Mapper.selectAll();

        return catalog1s;
    }

}
