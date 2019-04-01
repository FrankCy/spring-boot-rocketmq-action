package com.frank.sbr.action.consumer.listener;

import com.frank.sbr.action.config.Constants;
import com.frank.sbr.action.consumer.config.DefaultConsumerConfigure;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.consumer.listener、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午6:12
 * @mofified By:
 */
@Configuration
public class ConsumerListener extends DefaultConsumerConfigure implements ApplicationListener<ContextRefreshedEvent> {

    private static final Log logger = LogFactory.getLog(ConsumerListener.class);

    @Override
    public ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
        int num = 1;
        logger.info("进入");
        for(MessageExt msg : msgs) {
            logger.info("第" + num + "次消息");
            try {
                String msgStr = new String(msg.getBody(), "utf-8");
                logger.info("msgStr : " + msgStr);
            } catch (UnsupportedEncodingException e) {
                logger.error("body转字符串解析失败");
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            super.listener(Constants.MQ_DEFAULT_TOPIC, Constants.MQ_DEFAULT_TOPIC_TAG);
        } catch (MQClientException e) {
            logger.error("消费者监听器启动失败", e);
        }
    }
}
