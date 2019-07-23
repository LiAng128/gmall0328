package com.liang.gmall.user.mapper;


import com.liang.gmall.beans.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsMemberMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUmsMember();

}
