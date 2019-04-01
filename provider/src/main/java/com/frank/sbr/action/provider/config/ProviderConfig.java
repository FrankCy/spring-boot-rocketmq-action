package com.frank.sbr.action.provider.config;

import com.frank.sbr.action.config.Constants;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.config、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午7:06
 * @mofified By:
 */
@Configuration
public class ProviderConfig {

    private String namesrvAddr;

    private String groupName;

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ProviderConfig() {
        this.namesrvAddr = Constants.MQ_DEFAULT_ADDRESS;
        this.groupName = Constants.MQ_DEFAULT_GROUP_NAME;
    }

    public ProviderConfig(String namesrvAddr, String groupName) {
        this.namesrvAddr = namesrvAddr;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "ProviderConfig{" +
                "namesrvAddr='" + namesrvAddr + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
