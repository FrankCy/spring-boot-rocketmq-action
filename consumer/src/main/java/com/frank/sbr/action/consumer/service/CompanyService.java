package com.frank.sbr.action.consumer.service;

import javax.annotation.PostConstruct;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.consumer.service、
 * @email: cy880708@163.com
 * @date: 2019/4/2 下午2:38
 * @mofified By:
 */
public interface CompanyService {
    @PostConstruct
    boolean insertCompany(String companyVo);

}
