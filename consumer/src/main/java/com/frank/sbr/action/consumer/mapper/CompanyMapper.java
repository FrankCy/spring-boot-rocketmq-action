package com.frank.sbr.action.consumer.mapper;

import com.frank.sbr.action.po.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}