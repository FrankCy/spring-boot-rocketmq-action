package com.frank.sbr.action.consumer.impl;

import com.frank.sbr.action.consumer.mapper.UserMapper;
import com.frank.sbr.action.consumer.service.UserService;
import com.frank.sbr.action.po.User;
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
 * @date: 2019/4/3 下午9:45
 * @mofified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean updateUser(String userString) {
        User user = JsonUtil.jsonToBean(userString, User.class);
        int updateNum = userMapper.updateByPrimaryKeySelective(user);
        if(updateNum <= 0) {
            return false;
        }
        return true;
    }
}

