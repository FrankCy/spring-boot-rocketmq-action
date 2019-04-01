package com.frank.sbr.action.provider.impl;

import com.frank.sbr.action.config.Constants;
import com.frank.sbr.action.config.DefaultMQProducerSingleton;
import com.frank.sbr.action.provider.service.SendService;
import com.frank.sbr.action.util.JsonUtil;
import com.frank.sbr.action.vo.CompanyVO;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

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

    private static final Logger logger = LoggerFactory.getLogger(SendServiceImpl.class);

    @Override
    public int sendSimpleMessage(CompanyVO companyVO) {
        // 实例化生产者，并设置组名
        MQProducer producer = DefaultMQProducerSingleton.newInstance();

        // 启动实例
        try {
            String voString = JsonUtil.beanToJson(companyVO);
            logger.info("voString : " + voString);

            producer.start();

            Message msg = new Message(Constants.MQ_DEFAULT_TOPIC,
                    Constants.MQ_DEFAULT_TOPIC_TAG,
                    UUID.randomUUID().toString().replaceAll("-", ""),
                    (voString).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);

            producer.send(msg, new SendCallback() {
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

            // 发送后关闭生产者
            producer.shutdown();

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int sendOrderMessage() {
        return 0;
    }

    @Override
    public int sendBroadcastingMessage() {
        return 0;
    }

    @Override
    public int sendScheduleMessage() {
        return 0;
    }

    @Override
    public int sendBatchMessage() {
        return 0;
    }

    @Override
    public int sendFilterMessage() {
        return 0;
    }

    @Override
    public int sendTransactionMessage() {
        return 0;
    }

}
