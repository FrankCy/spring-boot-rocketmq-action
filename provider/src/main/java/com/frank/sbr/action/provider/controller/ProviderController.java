package com.frank.sbr.action.provider.controller;

import com.alibaba.fastjson.JSONObject;
import com.frank.sbr.action.config.Constants;
import com.frank.sbr.action.po.Company;
import com.frank.sbr.action.po.Dept;
import com.frank.sbr.action.po.User;
import com.frank.sbr.action.provider.config.ProducerConfigure;
import com.frank.sbr.action.provider.config.ProducerThreadConfigure;
import com.frank.sbr.action.provider.service.SendService;
import com.frank.sbr.action.util.JsonUtil;
import com.frank.sbr.action.vo.CompanyVO;
import com.frank.sbr.action.vo.ParamVO;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired
    private ProducerThreadConfigure producerThreadConfigure;

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
        DefaultMQProducer producer = producerConfigure.defaultProducer();
        producer.send(message, new SendCallback() {
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
        producer.shutdown();
    }

    /**
     * @description：新增公司
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/2 下午2:18
     * @mofified By:
     */
    @ResponseBody
    @RequestMapping(value = "/insertCompany")
    public void insertCompany(CompanyVO companyVO) throws Exception {

        JSONObject jsonObject = new JSONObject();
        // 执行程序
        jsonObject.put("serviceUri", Constants.DEFAULT_SERVICE_PACKAGE+".CompanyExecute");
        // 调用的方法
        jsonObject.put("invoke", "insertCompany");
        // 传递的参数
        jsonObject.put("params", JsonUtil.beanToJson(companyVO));

        Message message = new Message(Constants.MQ_DEFAULT_TOPIC,
                Constants.MQ_DEFAULT_TOPIC_TAG,
                UUID.randomUUID().toString().replaceAll("-", ""),
                jsonObject.toJSONString().getBytes());
        // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
        // 不过要注意的是这个是异步的
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

    /**
     * @description：新增多条数据
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/2 下午2:18
     * @mofified By:
     */
    @ResponseBody
    @RequestMapping(value = "/transactionData")
    public void insertData(ParamVO paramVO) {

        try {
            DefaultMQProducer producer = producerThreadConfigure.defaultThreadProducer();
            JSONObject jsonObject = JSONObject.parseObject(JsonUtil.beanToJson(paramVO));
            String cName = jsonObject.getString("cName");
            String uName = jsonObject.getString("uName");
            String dDes = jsonObject.getString("dDes");
            int uAmount = jsonObject.getInteger("uAmount");

            Company company = new Company();
            company.setcName(cName);
            company.setcId(1);

            User user = new User();
            user.setUid("userId");
            user.setUname(uName);

            Dept dept = new Dept();
            dept.setDid("deptId");
            dept.setDdes(dDes);

            JSONObject companyJson = initJson(
                    "CompanyExecute",
                    "updateCompany",
                    JsonUtil.beanToJson(company));
            sendThreadMessage(companyJson, producer);

            JSONObject userJson = initJson(
                    "CompanyExecute",
                    "updateUser",
                    JsonUtil.beanToJson(user));
            sendThreadMessage(userJson, producer);

            JSONObject deptJson = initJson(
                    "CompanyExecute",
                    "updateDept",
                    JsonUtil.beanToJson(dept));
            sendThreadMessage(deptJson, producer);

            producer.shutdown();


        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void sendThreadMessage(JSONObject jsonObject, DefaultMQProducer producer) {

        Message message = new Message(
                Constants.MQ_DEFAULT_TOPIC,
                Constants.MQ_DEFAULT_TOPIC_TAG,
                UUID.randomUUID().toString().replaceAll("-", ""),
                jsonObject.toJSONString().getBytes()
        );

        try {
            SendResult sendResult = producer.sendMessageInTransaction(message, null);

            Thread.sleep(10);
            logger.info("sendResult : " + sendResult.toString());

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public JSONObject initJson(String serviceUri, String invoke, String params) {
        JSONObject jsonObject = new JSONObject();
        // 执行程序
        jsonObject.put("serviceUri", Constants.DEFAULT_SERVICE_PACKAGE+"."+serviceUri);
        // 调用函数
        jsonObject.put("invoke", invoke);
        // 传递参数
        jsonObject.put("params", params);
        return jsonObject;
    }


}
