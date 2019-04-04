package com.frank.sbr.action.consumer.mapper;

import com.frank.sbr.action.po.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(String did);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String did);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}