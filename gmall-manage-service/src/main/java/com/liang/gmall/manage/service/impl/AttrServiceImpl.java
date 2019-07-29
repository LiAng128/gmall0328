package com.liang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liang.gmall.beans.PmsBaseAttrInfo;
import com.liang.gmall.beans.PmsBaseAttrValue;
import com.liang.gmall.manage.mapper.AttrInfoMapper;
import com.liang.gmall.manage.mapper.AttrValueMapper;
import com.liang.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.liang.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.liang.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrInfoMapper attrInfoMapper;

    @Autowired
    private AttrValueMapper attrValueMapper;

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> selectAttr(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();

        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);

        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrInfoMapper.select(pmsBaseAttrInfo);

        for (PmsBaseAttrInfo baseAttrInfo : pmsBaseAttrInfos) {

            String baseAttrInfoId = baseAttrInfo.getId();

            PmsBaseAttrValue baseAttrValue = new PmsBaseAttrValue();

            baseAttrValue.setAttrId(baseAttrInfoId);

            List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(baseAttrValue);

            baseAttrInfo.setAttrValueList(pmsBaseAttrValues);

        }

        return pmsBaseAttrInfos;
    }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        PmsBaseAttrValue attrValue = pmsBaseAttrInfo.getAttrValueList().get(0);

        // 通过attrValue中的attrId值是否存在，判断是否是修改还是新增
        if (attrValue.getAttrId() != null){

           // 修改的操作：先删除后插入
            // 删除
            String id = pmsBaseAttrInfo.getId();

            PmsBaseAttrValue baseAttrValue = new PmsBaseAttrValue();

            baseAttrValue.setAttrId(id);

            attrValueMapper.delete(baseAttrValue);

            // 插入
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {

                pmsBaseAttrValue.setAttrId(id);

                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);

            }

        }else {

            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

            String id = pmsBaseAttrInfo.getId();

            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {

                pmsBaseAttrValue.setAttrId(id);

                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);

            }

        }
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();

        pmsBaseAttrValue.setAttrId(attrId);

        List<PmsBaseAttrValue> attrValues = attrValueMapper.select(pmsBaseAttrValue);

        return attrValues;

    }
}
