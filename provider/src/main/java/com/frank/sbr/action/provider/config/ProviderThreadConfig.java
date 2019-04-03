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
 * @date: 2019/4/2 下午6:18
 * @mofified By:
 */
@Configuration
public class ProviderThreadConfig {

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

    public ProviderThreadConfig() {
        this.namesrvAddr = Constants.MQ_DEFAULT_ADDRESS;
        this.groupName = Constants.MQ_DEFAULT_GROUP_THREAD_NAME;
    }

    public ProviderThreadConfig(String namesrvAddr, String groupName) {
        this.namesrvAddr = namesrvAddr;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "ProviderThreadConfig{" +
                "namesrvAddr='" + namesrvAddr + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
