package com.frank.sbr.action.vo;

import com.frank.sbr.action.po.Company;

import java.io.Serializable;
import java.sql.Time;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.vo、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午2:01
 * @mofified By:
 */
public class CompanyVO extends Company implements Serializable {

    private static final long serialVersionUID = 3877881922852202454L;

    /**
     * 注册时间
     */
    private Time registration;

    public Time getRegistration() {
        return registration;
    }

    public void setRegistration(Time registration) {
        this.registration = registration;
    }


}
