package com.frank.sbr.action.po;

public class User {
    private String uid;

    private String uname;

    private Integer uamount;

    private String ucode;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getUamount() {
        return uamount;
    }

    public void setUamount(Integer uamount) {
        this.uamount = uamount;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode == null ? null : ucode.trim();
    }
}