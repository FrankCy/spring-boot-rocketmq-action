package com.frank.sbr.action.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action、
 * @email: cy880708@163.com
 * @date: 2019/3/29 下午4:07
 * @mofified By:
 */
@SpringBootApplication
@MapperScan("com.frank.sbr.action.consumer.mapper")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
