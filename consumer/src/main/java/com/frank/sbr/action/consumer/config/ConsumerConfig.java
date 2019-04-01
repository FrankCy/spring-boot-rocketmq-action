package com.frank.sbr.action.consumer.config;

import com.frank.sbr.action.config.Constants;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.config、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午6:27
 * @mofified By:
 */
@Configuration
public class ConsumerConfig implements Serializable {

    private static final long serialVersionUID = 6140956105610897249L;

    private String groupName;

    private String namesrvAddr;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public ConsumerConfig() {
        this.groupName = Constants.MQ_DEFAULT_GROUP_NAME;
        this.namesrvAddr = Constants.MQ_DEFAULT_ADDRESS;
    }

    public ConsumerConfig(String groupName, String namesrvAddr) {
        this.groupName = groupName;
        this.namesrvAddr = namesrvAddr;
    }

    @Override
    public String toString() {
        return "ConsumerConfig{" +
                "groupName='" + groupName + '\'' +
                ", namesrvAddr='" + namesrvAddr + '\'' +
                '}';
    }
}
