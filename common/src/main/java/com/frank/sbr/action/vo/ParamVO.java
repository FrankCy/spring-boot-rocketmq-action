package com.frank.sbr.action.vo;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.vo、
 * @email: cy880708@163.com
 * @date: 2019/4/3 下午9:35
 * @mofified By:
 */
public class ParamVO {

    /**
     * company c_name
     */
    private String cName;

    /**
     * user uName
     */
    private String uName;

    /**
     * user uAmout
     */
    private int uAmount;

    /**
     * dept dDes
     */
    private String dDes;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuAmount() {
        return uAmount;
    }

    public void setuAmount(int uAmount) {
        this.uAmount = uAmount;
    }

    public String getdDes() {
        return dDes;
    }

    public void setdDes(String dDes) {
        this.dDes = dDes;
    }

    public ParamVO() {
    }

    public ParamVO(String cName, String uName, int uAmount, String dDes) {
        this.cName = cName;
        this.uName = uName;
        this.uAmount = uAmount;
        this.dDes = dDes;
    }
}
