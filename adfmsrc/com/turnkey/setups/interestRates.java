package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class interestRates {
    public interestRates() {
        super();
    }
    //reinstatement rates
    private BigDecimal rirCode;
    private BigDecimal rirProdCode;
    private String     rirProdshtdesc;
    private BigDecimal rirRate;
    private Date rirWef;
    private Date rirWet;
    
  //Rate Tables...
  private BigDecimal LPNT_CODE;
  private String LPNT_DESC;
  private BigDecimal LPNT_POL_CODE;
  private String POL_POLICY_NO;
  private String LPNT_DEFAULT;

    //loan rates
    private BigDecimal lirCode;
    private BigDecimal lirProdCode;
    private String lirProdShtDesc;
    private Date lirWef;
    private Date lirWet;
    private BigDecimal lirRate;
    private BigDecimal serviceCharge;
    private BigDecimal serviceChargeDivFact;
    
    //general interest rates
    private BigDecimal lgrCode;
    private BigDecimal lgrProdCode;
    private BigDecimal lgrRate;
    private String lgrType;
    private String lgrApplicationType;
    private BigDecimal lgrDivFactor;
    private String lgrDependsonFreq;
    private Date lgrWef;
    private Date lgrWet;
    private String typeDesc;
    private String freqDesc;
    private String applicTypeDesc;
    public void setRirCode(BigDecimal rirCode) {
        this.rirCode = rirCode;
    }

    public BigDecimal getRirCode() {
        return rirCode;
    }

    public void setRirProdCode(BigDecimal rirProdCode) {
        this.rirProdCode = rirProdCode;
    }

    public BigDecimal getRirProdCode() {
        return rirProdCode;
    }

    public void setRirProdshtdesc(String rirProdshtdesc) {
        this.rirProdshtdesc = rirProdshtdesc;
    }

    public String getRirProdshtdesc() {
        return rirProdshtdesc;
    }

    public void setRirRate(BigDecimal rirRate) {
        this.rirRate = rirRate;
    }

    public BigDecimal getRirRate() {
        return rirRate;
    }

    public void setRirWef(Date rirWef) {
        this.rirWef = rirWef;
    }

    public Date getRirWef() {
        return rirWef;
    }

    public void setRirWet(Date rirWet) {
        this.rirWet = rirWet;
    }

    public Date getRirWet() {
        return rirWet;
    }

    public void setLirCode(BigDecimal lirCode) {
        this.lirCode = lirCode;
    }

    public BigDecimal getLirCode() {
        return lirCode;
    }

    public void setLirProdCode(BigDecimal lirProdCode) {
        this.lirProdCode = lirProdCode;
    }

    public BigDecimal getLirProdCode() {
        return lirProdCode;
    }

    public void setLirProdShtDesc(String lirProdShtDesc) {
        this.lirProdShtDesc = lirProdShtDesc;
    }

    public String getLirProdShtDesc() {
        return lirProdShtDesc;
    }

    public void setLirWef(Date lirWef) {
        this.lirWef = lirWef;
    }

    public Date getLirWef() {
        return lirWef;
    }

    public void setLirWet(Date lirWet) {
        this.lirWet = lirWet;
    }

    public Date getLirWet() {
        return lirWet;
    }

    public void setLirRate(BigDecimal lirRate) {
        this.lirRate = lirRate;
    }

    public BigDecimal getLirRate() {
        return lirRate;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceChargeDivFact(BigDecimal serviceChargeDivFact) {
        this.serviceChargeDivFact = serviceChargeDivFact;
    }

    public BigDecimal getServiceChargeDivFact() {
        return serviceChargeDivFact;
    }

    public void setLgrCode(BigDecimal lgrCode) {
        this.lgrCode = lgrCode;
    }

    public BigDecimal getLgrCode() {
        return lgrCode;
    }

    public void setLgrProdCode(BigDecimal lgrProdCode) {
        this.lgrProdCode = lgrProdCode;
    }

    public BigDecimal getLgrProdCode() {
        return lgrProdCode;
    }

    public void setLgrType(String lgrType) {
        this.lgrType = lgrType;
    }

    public String getLgrType() {
        return lgrType;
    }

    public void setLgrApplicationType(String lgrApplicationType) {
        this.lgrApplicationType = lgrApplicationType;
    }

    public String getLgrApplicationType() {
        return lgrApplicationType;
    }

    public void setLgrDivFactor(BigDecimal lgrDivFactor) {
        this.lgrDivFactor = lgrDivFactor;
    }

    public BigDecimal getLgrDivFactor() {
        return lgrDivFactor;
    }

    public void setLgrDependsonFreq(String lgrDependsonFreq) {
        this.lgrDependsonFreq = lgrDependsonFreq;
    }

    public String getLgrDependsonFreq() {
        return lgrDependsonFreq;
    }

    public void setLgrWef(Date lgrWef) {
        this.lgrWef = lgrWef;
    }

    public Date getLgrWef() {
        return lgrWef;
    }

    public void setLgrWet(Date lgrWet) {
        this.lgrWet = lgrWet;
    }

    public Date getLgrWet() {
        return lgrWet;
    }

    public void setLgrRate(BigDecimal lgrRate) {
        this.lgrRate = lgrRate;
    }

    public BigDecimal getLgrRate() {
        return lgrRate;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setFreqDesc(String freqDesc) {
        this.freqDesc = freqDesc;
    }

    public String getFreqDesc() {
        return freqDesc;
    }

    public void setApplicTypeDesc(String applicTypeDesc) {
        this.applicTypeDesc = applicTypeDesc;
    }

    public String getApplicTypeDesc() {
        return applicTypeDesc;
    }

    public void setLPNT_CODE(BigDecimal LPNT_CODE) {
        this.LPNT_CODE = LPNT_CODE;
    }

    public BigDecimal getLPNT_CODE() {
        return LPNT_CODE;
    }

    public void setLPNT_DESC(String LPNT_DESC) {
        this.LPNT_DESC = LPNT_DESC;
    }

    public String getLPNT_DESC() {
        return LPNT_DESC;
    }

    public void setLPNT_POL_CODE(BigDecimal LPNT_POL_CODE) {
        this.LPNT_POL_CODE = LPNT_POL_CODE;
    }

    public BigDecimal getLPNT_POL_CODE() {
        return LPNT_POL_CODE;
    }

    public void setPOL_POLICY_NO(String POL_POLICY_NO) {
        this.POL_POLICY_NO = POL_POLICY_NO;
    }

    public String getPOL_POLICY_NO() {
        return POL_POLICY_NO;
    }

    public void setLPNT_DEFAULT(String LPNT_DEFAULT) {
        this.LPNT_DEFAULT = LPNT_DEFAULT;
    }

    public String getLPNT_DEFAULT() {
        return LPNT_DEFAULT;
    }
}
