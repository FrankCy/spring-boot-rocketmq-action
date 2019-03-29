package com.frank.sbr.action.controller;

import com.frank.sbr.action.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.controller、
 * @email: cy880708@163.com
 * @date: 2019/3/29 下午4:18
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/action")
public class ActionController {

    @Autowired
    private SendMessageService sendMessageService;

    /**
     * @description：
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/3/29 下午4:19
     * @mofified By:
     */
    @ResponseBody
    @RequestMapping(value = "/sendMessage")
    public int sendMessage(String message){
//        return userService.addUser(user);
        return 1;
    }

}
