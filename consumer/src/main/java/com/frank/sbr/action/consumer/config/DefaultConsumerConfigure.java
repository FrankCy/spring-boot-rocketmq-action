package com.frank.sbr.action.consumer.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.config、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午6:26
 * @mofified By:
 */
@Configuration
public abstract class DefaultConsumerConfigure {

    private static final Log logger = LogFactory.getLog(DefaultConsumerConfigure.class);

    @Autowired
    private ConsumerConfig consumerConfig;

    /**
     * @description：开启消费者监听服务
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午6:30
     * @mofified By:
     */
    public void listener(String topic, String tag) throws MQClientException {
        logger.info("开启" + topic + ":" + tag + "消费者-------------------");
        logger.info(consumerConfig.toString());

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerConfig.getGroupName());

        consumer.setNamesrvAddr(consumerConfig.getNamesrvAddr());

        consumer.subscribe(topic, tag);

        // 开启内部类实现监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                return DefaultConsumerConfigure.this.dealBody(msgs);
            }
        });

        consumer.start();

        logger.info("rocketmq启动成功---------------------------------------");

    }

    /**
     * @description：处理body的业务
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午6:30
     * @mofified By:
     */
    public abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);

}
