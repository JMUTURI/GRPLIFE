package com.turnkey.setups;

import java.math.BigDecimal;

public class relationTypes {
    public relationTypes() {
        super();
    }
    //relation types
    private BigDecimal retCode;
    private String retShtDesc;
    private String retDesc;
    private String retComments;
    private String dobRequired;
    private String dobRequiredDesc;
    
    //relation types
    private BigDecimal dtyCode;
    private String dtyShtDesc;
    private String dtyDesc;

    public void setRetCode(BigDecimal retCode) {
        this.retCode = retCode;
    }

    public BigDecimal getRetCode() {
        return retCode;
    }

    public void setRetShtDesc(String retShtDesc) {
        this.retShtDesc = retShtDesc;
    }

    public String getRetShtDesc() {
        return retShtDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetComments(String retComments) {
        this.retComments = retComments;
    }

    public String getRetComments() {
        return retComments;
    }

    public void setDobRequired(String dobRequired) {
        this.dobRequired = dobRequired;
    }

    public String getDobRequired() {
        return dobRequired;
    }

    public void setDobRequiredDesc(String dobRequiredDesc) {
        this.dobRequiredDesc = dobRequiredDesc;
    }

    public String getDobRequiredDesc() {
        return dobRequiredDesc;
    }

    public void setDtyCode(BigDecimal dtyCode) {
        this.dtyCode = dtyCode;
    }

    public BigDecimal getDtyCode() {
        return dtyCode;
    }

    public void setDtyShtDesc(String dtyShtDesc) {
        this.dtyShtDesc = dtyShtDesc;
    }

    public String getDtyShtDesc() {
        return dtyShtDesc;
    }

    public void setDtyDesc(String dtyDesc) {
        this.dtyDesc = dtyDesc;
    }

    public String getDtyDesc() {
        return dtyDesc;
    }
}
