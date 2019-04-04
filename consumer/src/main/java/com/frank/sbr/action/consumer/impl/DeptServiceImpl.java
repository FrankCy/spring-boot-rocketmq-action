package com.frank.sbr.action.consumer.impl;

import com.frank.sbr.action.consumer.mapper.DeptMapper;
import com.frank.sbr.action.consumer.service.DeptService;
import com.frank.sbr.action.po.Dept;
import com.frank.sbr.action.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.consumer.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/3 下午9:46
 * @mofified By:
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public boolean updateDept(String deptString) {
        Dept dept = JsonUtil.jsonToBean(deptString, Dept.class);
        int updateNum = deptMapper.updateByPrimaryKeySelective(dept);
        if(updateNum <= 0) {
            return false;
        }
        return true;
    }
}
