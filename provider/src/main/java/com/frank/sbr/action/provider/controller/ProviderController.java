package com.frank.sbr.action.provider.controller;

import com.frank.sbr.action.provider.service.SendService;
import com.frank.sbr.action.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.controller、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午1:25
 * @mofified By:
 */
@Controller
public class ProviderController {


    @Autowired
    private SendService sendServiceImpl;

    /**
     * @description：新增用户信息x
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/14 下午1:52
     * @mofified By:
     */
    @ResponseBody
    @RequestMapping(value = "/sendOrderMessage")
    public int sendOrderMessage(CompanyVO companyVO){
        return sendServiceImpl.sendSimpleMessage(companyVO);
    }


}
