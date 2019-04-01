package com.frank.sbr.action.provider.controller;

import com.frank.sbr.action.config.Constants;
import com.frank.sbr.action.provider.config.ProducerConfigure;
import com.frank.sbr.action.provider.service.SendService;
import com.frank.sbr.action.util.JsonUtil;
import com.frank.sbr.action.vo.CompanyVO;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
@RestController
public class ProviderController {

    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private SendService sendServiceImpl;

    @Autowired
    private ProducerConfigure producerConfigure;

    /**
     * @description：
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

    @ResponseBody
    @RequestMapping(value = "/sendMessage")
    public void sendMessage(CompanyVO companyVO) throws Exception {
        Message message = new Message(Constants.MQ_DEFAULT_TOPIC,
                Constants.MQ_DEFAULT_TOPIC_TAG,
                UUID.randomUUID().toString().replaceAll("-", ""),
                JsonUtil.beanToJson(companyVO).getBytes());
        // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
        //不过要注意的是这个是异步的
        producerConfigure.defaultProducer().send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                logger.info("传输成功");
                logger.info(JsonUtil.beanToJson(sendResult));
            }
            @Override
            public void onException(Throwable e) {
                logger.error("传输失败", e);
            }
        });
    }

}
