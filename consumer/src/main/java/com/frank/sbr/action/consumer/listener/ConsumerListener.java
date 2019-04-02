package com.frank.sbr.action.consumer.listener;

import com.alibaba.fastjson.JSONObject;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        for(MessageExt msg : msgs) {
            if(msgs == null) {
                continue;
            }

            try {
                String message = new String(msg.getBody(), "utf-8");
                logger.info("第" + num + "次消息内容为：" + message);
                JSONObject jsonObject = JSONObject.parseObject(message);
                // 请求服务
                String serviceUri = jsonObject.get("serviceUri").toString();
                // 请求函数
                String invoke = jsonObject.get("invoke").toString();
                // 请求参数
                String params = jsonObject.get("params").toString();
                // 反射调用对应服务函数并传递参数
                Class serviceClass = Class.forName(serviceUri);
                Object obj = serviceClass.newInstance();
                // 调用serviceClass的invoke函数，并设置默认参数；
                Method method = serviceClass.getMethod(invoke, String.class);
                // 调用Method类的方法invoke运行invoke方法
                Object object = method.invoke(obj, params);
                logger.info("object.toString() : " + object.toString());
            } catch (UnsupportedEncodingException e) {
                logger.error("body转字符串解析失败");
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
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
