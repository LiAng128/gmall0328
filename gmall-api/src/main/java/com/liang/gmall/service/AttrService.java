package com.liang.gmall.service;

import com.liang.gmall.beans.PmsBaseAttrInfo;
import com.liang.gmall.beans.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {

    List<PmsBaseAttrInfo> selectAttr(String catalog3Id);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
