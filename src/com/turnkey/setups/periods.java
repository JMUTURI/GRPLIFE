package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class periods {
    public periods() {
        super();
    }
    private BigDecimal perCode;
    private String perName;
    private String perValFreq;
    private String perValFreqDesc;
    private Date perWef;
    private Date perWet;
    private BigDecimal perId;

    public void setPerCode(BigDecimal perCode) {
        this.perCode = perCode;
    }

    public BigDecimal getPerCode() {
        return perCode;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerValFreq(String perValFreq) {
        this.perValFreq = perValFreq;
    }

    public String getPerValFreq() {
        return perValFreq;
    }

    public void setPerValFreqDesc(String perValFreqDesc) {
        this.perValFreqDesc = perValFreqDesc;
    }

    public String getPerValFreqDesc() {
        return perValFreqDesc;
    }

    public void setPerWef(Date perWef) {
        this.perWef = perWef;
    }

    public Date getPerWef() {
        return perWef;
    }

    public void setPerWet(Date perWet) {
        this.perWet = perWet;
    }

    public Date getPerWet() {
        return perWet;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public BigDecimal getPerId() {
        return perId;
    }
}
