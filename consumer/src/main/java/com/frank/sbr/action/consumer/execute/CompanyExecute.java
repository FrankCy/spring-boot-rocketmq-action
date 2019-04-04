package com.frank.sbr.action.consumer.execute;

import com.frank.sbr.action.consumer.service.CompanyService;
import com.frank.sbr.action.consumer.service.DeptService;
import com.frank.sbr.action.consumer.service.UserService;
import com.frank.sbr.action.po.Dept;
import com.frank.sbr.action.po.User;
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

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

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

    public boolean insertData(String paramVoString) {
        boolean insertFlag = companyExecute.companyServiceImpl.insertCompany(paramVoString);
        return insertFlag;
    }

    public boolean updateCompany(String companyString) {
        boolean updateFlag = companyExecute.companyServiceImpl.updateCompany(companyString);
        return updateFlag;
    }

    public boolean updateUser(String userString) {
        boolean updateFlag = companyExecute.userService.updateUser(userString);
        return updateFlag;
    }

    public boolean updateDept(String deptString) {
        boolean updateFlag = companyExecute.deptService.updateDept(deptString);
        return updateFlag;
    }

}
