package com.frank.sbr.action.consumer.impl;

import com.frank.sbr.action.provider.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午1:27
 * @mofified By:
 */
@Service
public class MessageServiceImpl implements MessageService {
    public int simpleMessage() {
        return 0;
    }

    public int orderMessage() {
        return 0;
    }

    public int broadcastingMessage() {
        return 0;
    }

    public int scheduleMessage() {
        return 0;
    }

    public int batchMessage() {
        return 0;
    }

    public int filterMessage() {
        return 0;
    }

    public int transactionMessage() {
        return 0;
    }
}
