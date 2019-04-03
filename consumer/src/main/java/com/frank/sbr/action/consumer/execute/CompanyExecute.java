package com.frank.sbr.action.consumer.execute;

import com.frank.sbr.action.consumer.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.consumer.execute、
 * @email: cy880708@163.com
 * @date: 2019/4/2 下午2:37
 * @mofified By:
 */
@Component
public class CompanyExecute {

    public static CompanyExecute companyExecute;

    @Autowired
    private CompanyService companyServiceImpl;

    /**
     * 初始化当前类，添加@PostConstruct注解意思是方法调用时完成注册
     */
    @PostConstruct
    public void init() {
        companyExecute = this;
    }

    public boolean insertCompany(String companyVoString) {
        boolean insertFlag = companyExecute.companyServiceImpl.insertCompany(companyVoString);
        return insertFlag;
    }

    public boolean insertData(String companyVoString) {
        boolean insertFlag = companyExecute.companyServiceImpl.insertCompany(companyVoString);
        return insertFlag;
    }

}
