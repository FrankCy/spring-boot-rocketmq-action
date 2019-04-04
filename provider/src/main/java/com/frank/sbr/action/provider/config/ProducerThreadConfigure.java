package com.frank.sbr.action.provider.config;

import com.frank.sbr.action.config.Constants;
import com.frank.sbr.action.provider.impl.TransactionListenerImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.config、
 * @email: cy880708@163.com
 * @date: 2019/4/2 下午6:16
 * @mofified By:
 */
@Configuration
public class ProducerThreadConfigure {

    private static final Log logger = LogFactory.getLog(ProducerThreadConfigure.class);

    @Autowired
    private ProviderThreadConfig providerThreadConfig;

    /**
     * 创建事务消息发送者实例
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQProducer defaultThreadProducer() throws MQClientException {

        logger.info("DefaultProducerThreadConfigure 正在创建---------------------------------------");
        logger.info(providerThreadConfig.toString());
        TransactionListener transactionListener = new TransactionListenerImpl();
        TransactionMQProducer producer = new TransactionMQProducer(providerThreadConfig.getGroupName());
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName(Constants.MQ_DEFAULT_THREAD_NAME);
                        return thread;
                    }
                }
        );

        producer.setExecutorService(executorService);
        producer.setTransactionListener(transactionListener);
        producer.start();
        logger.info("rocketmq thread producer server开启成功---------------------------------.");
        return producer;
    }
}
