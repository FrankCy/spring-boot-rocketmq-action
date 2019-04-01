package com.frank.sbr.action.provider.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.config、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午7:04
 * @mofified By:
 */
@Configuration
public class ProducerConfigure {

    private static final Log logger = LogFactory.getLog(ProducerConfigure.class);

    @Autowired
    private ProviderConfig providerConfig;

    /**
     * 创建普通消息发送者实例
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQProducer defaultProducer() throws MQClientException {
        logger.info(providerConfig.toString());
        logger.info("defaultProducer 正在创建---------------------------------------");
        DefaultMQProducer producer = new DefaultMQProducer(providerConfig.getGroupName());
        producer.setNamesrvAddr(providerConfig.getNamesrvAddr());
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendAsyncFailed(10);
        producer.start();
        logger.info("rocketmq producer server开启成功---------------------------------.");
        return producer;
    }


}
