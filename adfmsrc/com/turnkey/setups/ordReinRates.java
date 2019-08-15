package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class ordReinRates {
    public ordReinRates() {
        super();
    }
    private BigDecimal orrpCode;
    private String orrpShtDesc;
    private String orrpDesc;
    private String orrpClassSpecific;
    
    //rates
    private BigDecimal orrtCode;
    private String orrtAnbFrom;
    private String orrtAnbTo;
    private BigDecimal orrtRate;
    private BigDecimal orrtDivFactor;
    private String orrtRateType;
    private Date orrtWet;
    private Date orrtWef;
    private String orrtRateTypeDesc;
    public void setOrrpCode(BigDecimal orrpCode) {
        this.orrpCode = orrpCode;
    }

    public BigDecimal getOrrpCode() {
        return orrpCode;
    }

    public void setOrrpShtDesc(String orrpShtDesc) {
        this.orrpShtDesc = orrpShtDesc;
    }

    public String getOrrpShtDesc() {
        return orrpShtDesc;
    }

    public void setOrrpDesc(String orrpDesc) {
        this.orrpDesc = orrpDesc;
    }

    public String getOrrpDesc() {
        return orrpDesc;
    }

    public void setOrrpClassSpecific(String orrpClassSpecific) {
        this.orrpClassSpecific = orrpClassSpecific;
    }

    public String getOrrpClassSpecific() {
        return orrpClassSpecific;
    }

    public void setOrrtCode(BigDecimal orrtCode) {
        this.orrtCode = orrtCode;
    }

    public BigDecimal getOrrtCode() {
        return orrtCode;
    }

    public void setOrrtAnbFrom(String orrtAnbFrom) {
        this.orrtAnbFrom = orrtAnbFrom;
    }

    public String getOrrtAnbFrom() {
        return orrtAnbFrom;
    }

    public void setOrrtAnbTo(String orrtAnbTo) {
        this.orrtAnbTo = orrtAnbTo;
    }

    public String getOrrtAnbTo() {
        return orrtAnbTo;
    }

    public void setOrrtRate(BigDecimal orrtRate) {
        this.orrtRate = orrtRate;
    }

    public BigDecimal getOrrtRate() {
        return orrtRate;
    }

    public void setOrrtDivFactor(BigDecimal orrtDivFactor) {
        this.orrtDivFactor = orrtDivFactor;
    }

    public BigDecimal getOrrtDivFactor() {
        return orrtDivFactor;
    }

    public void setOrrtRateType(String orrtRateType) {
        this.orrtRateType = orrtRateType;
    }

    public String getOrrtRateType() {
        return orrtRateType;
    }

    public void setOrrtWet(Date orrtWet) {
        this.orrtWet = orrtWet;
    }

    public Date getOrrtWet() {
        return orrtWet;
    }

    public void setOrrtWef(Date orrtWef) {
        this.orrtWef = orrtWef;
    }

    public Date getOrrtWef() {
        return orrtWef;
    }

    public void setOrrtRateTypeDesc(String orrtRateTypeDesc) {
        this.orrtRateTypeDesc = orrtRateTypeDesc;
    }

    public String getOrrtRateTypeDesc() {
        return orrtRateTypeDesc;
    }
}
