package com.frank.sbr.action.provider.impl;

import com.frank.sbr.action.provider.service.SendService;
import com.frank.sbr.action.vo.CompanyVO;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午1:59
 * @mofified By:
 */
@Service
public class SendServiceImpl implements SendService {

    public int sendSimpleMessage(CompanyVO companyVO) {
        System.out.println(companyVO.toString());
        return 0;
    }

    public int sendOrderMessage() {
        return 0;
    }

    public int sendBroadcastingMessage() {
        return 0;
    }

    public int sendScheduleMessage() {
        return 0;
    }

    public int sendBatchMessage() {
        return 0;
    }

    public int sendFilterMessage() {
        return 0;
    }

    public int sendTransactionMessage() {
        return 0;
    }

}
