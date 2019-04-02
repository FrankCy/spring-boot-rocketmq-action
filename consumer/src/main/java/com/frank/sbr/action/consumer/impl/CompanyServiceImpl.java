package com.frank.sbr.action.consumer.impl;

import com.frank.sbr.action.consumer.mapper.CompanyMapper;
import com.frank.sbr.action.consumer.service.CompanyService;
import com.frank.sbr.action.po.Company;
import com.frank.sbr.action.util.JsonUtil;
import com.frank.sbr.action.vo.CompanyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.consumer.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/2 下午2:05
 * @mofified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public boolean insertCompany(String companyVoString) {
        CompanyVO companyVO = JsonUtil.jsonToBean(companyVoString, CompanyVO.class);
        Company company = new Company();
        BeanUtils.copyProperties(companyVO, company);
        int insertNum = companyMapper.insertSelective(company);
        if(insertNum <= 0) {
            return false;
        }
        return true;
    }
}
