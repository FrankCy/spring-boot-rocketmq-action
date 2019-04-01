package com.frank.sbr.action.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq
 * @package: com.sb.rm.common.util、
 * @email: cy880708@163.com
 * @date: 2019/3/27 下午6:28
 * @mofified By:
 */
public class DefaultMQPushConsumerSingleton {

    private static class SingletonHolder {
        private static DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer(Constants.MQ_DEFAULT_GROUP_NAME);
    }

    private DefaultMQPushConsumerSingleton() {
    }

    public static DefaultMQPushConsumer newInstance() {
        DefaultMQPushConsumerSingleton.SingletonHolder.defaultMQPushConsumer.setNamesrvAddr(Constants.MQ_DEFAULT_ADDRESS);
        return DefaultMQPushConsumerSingleton.SingletonHolder.defaultMQPushConsumer;
    }
}
