package com.frank.sbr.action.po;

import java.io.Serializable;

public class Company implements Serializable {

    private static final long serialVersionUID = -3631962721268073241L;

    private Integer cId;

    private String cName;

    private String cDes;

    private String cCode;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcDes() {
        return cDes;
    }

    public void setcDes(String cDes) {
        this.cDes = cDes == null ? null : cDes.trim();
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }

    public Company() {
    }

    public Company(Integer cId, String cName, String cDes, String cCode) {
        this.cId = cId;
        this.cName = cName;
        this.cDes = cDes;
        this.cCode = cCode;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cDes='" + cDes + '\'' +
                ", cCode='" + cCode + '\'' +
                '}';
    }
}