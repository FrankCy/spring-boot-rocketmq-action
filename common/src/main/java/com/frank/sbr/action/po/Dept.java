package com.frank.sbr.action.po;

public class Dept {
    private String did;

    private String ddes;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getDdes() {
        return ddes;
    }

    public void setDdes(String ddes) {
        this.ddes = ddes == null ? null : ddes.trim();
    }
}