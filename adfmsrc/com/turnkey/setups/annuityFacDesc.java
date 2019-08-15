package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class annuityFacDesc {
    public annuityFacDesc() {
        super();
    }
    private BigDecimal ANNFD_CODE, ANNFD_INT_RATE, ANNFD_PROD_CODE;
    private String ANNFD_DESC;

//annuity factors
    private BigDecimal ANNF_CODE;
    private BigDecimal ANNF_ANNFD_CODE;
    private BigDecimal ANNF_RETIRE_AGE;
    private BigDecimal ANNF_GUAR_PRD;
    private BigDecimal ANNF_MALE_RATE;
    private BigDecimal ANNF_FEMALE_RATE;
  
    private String ATY_RETIREMENT_AGE;
    private Date ANNF_WEF;
    private Date ANNF_WET;

    //annuity rates by type
        private BigDecimal atyCode;
        private String prodDescription;
        private BigDecimal atyGuaranteePeriod;
        private String atyType;
        private String atyOption;
    
    //annuity type rates
        private BigDecimal anntrCode;
        private BigDecimal annAtycode;
        private BigDecimal anntrAnb;
        private BigDecimal anntrRate;
        private String anntrGender;
        private String anntrGenderDesc;
        
    public void setANNFD_CODE(BigDecimal ANNFD_CODE) {
        this.ANNFD_CODE = ANNFD_CODE;
    }

    public BigDecimal getANNFD_CODE() {
        return ANNFD_CODE;
    }

    public void setANNFD_INT_RATE(BigDecimal ANNFD_INT_RATE) {
        this.ANNFD_INT_RATE = ANNFD_INT_RATE;
    }

    public BigDecimal getANNFD_INT_RATE() {
        return ANNFD_INT_RATE;
    }

    public void setANNFD_PROD_CODE(BigDecimal ANNFD_PROD_CODE) {
        this.ANNFD_PROD_CODE = ANNFD_PROD_CODE;
    }

    public BigDecimal getANNFD_PROD_CODE() {
        return ANNFD_PROD_CODE;
    }

    public void setANNFD_DESC(String ANNFD_DESC) {
        this.ANNFD_DESC = ANNFD_DESC;
    }

    public String getANNFD_DESC() {
        return ANNFD_DESC;
    }

    public void setANNF_CODE(BigDecimal ANNF_CODE) {
        this.ANNF_CODE = ANNF_CODE;
    }

    public BigDecimal getANNF_CODE() {
        return ANNF_CODE;
    }

    public void setANNF_ANNFD_CODE(BigDecimal ANNF_ANNFD_CODE) {
        this.ANNF_ANNFD_CODE = ANNF_ANNFD_CODE;
    }

    public BigDecimal getANNF_ANNFD_CODE() {
        return ANNF_ANNFD_CODE;
    }

    public void setANNF_RETIRE_AGE(BigDecimal ANNF_RETIRE_AGE) {
        this.ANNF_RETIRE_AGE = ANNF_RETIRE_AGE;
    }

    public BigDecimal getANNF_RETIRE_AGE() {
        return ANNF_RETIRE_AGE;
    }

    public void setANNF_GUAR_PRD(BigDecimal ANNF_GUAR_PRD) {
        this.ANNF_GUAR_PRD = ANNF_GUAR_PRD;
    }

    public BigDecimal getANNF_GUAR_PRD() {
        return ANNF_GUAR_PRD;
    }

    public void setANNF_MALE_RATE(BigDecimal ANNF_MALE_RATE) {
        this.ANNF_MALE_RATE = ANNF_MALE_RATE;
    }

    public BigDecimal getANNF_MALE_RATE() {
        return ANNF_MALE_RATE;
    }

    public void setANNF_FEMALE_RATE(BigDecimal ANNF_FEMALE_RATE) {
        this.ANNF_FEMALE_RATE = ANNF_FEMALE_RATE;
    }

    public BigDecimal getANNF_FEMALE_RATE() {
        return ANNF_FEMALE_RATE;
    }

    public void setANNF_WEF(Date ANNF_WEF) {
        this.ANNF_WEF = ANNF_WEF;
    }

    public Date getANNF_WEF() {
        return ANNF_WEF;
    }

    public void setANNF_WET(Date ANNF_WET) {
        this.ANNF_WET = ANNF_WET;
    }

    public Date getANNF_WET() {
        return ANNF_WET;
    }

    public void setAtyCode(BigDecimal atyCode) {
        this.atyCode = atyCode;
    }

    public BigDecimal getAtyCode() {
        return atyCode;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setAtyGuaranteePeriod(BigDecimal atyGuaranteePeriod) {
        this.atyGuaranteePeriod = atyGuaranteePeriod;
    }

    public BigDecimal getAtyGuaranteePeriod() {
        return atyGuaranteePeriod;
    }

    public void setAtyType(String atyType) {
        this.atyType = atyType;
    }

    public String getAtyType() {
        return atyType;
    }

    public void setAtyOption(String atyOption) {
        this.atyOption = atyOption;
    }

    public String getAtyOption() {
        return atyOption;
    }

    public void setAnntrCode(BigDecimal anntrCode) {
        this.anntrCode = anntrCode;
    }

    public BigDecimal getAnntrCode() {
        return anntrCode;
    }

    public void setAnnAtycode(BigDecimal annAtycode) {
        this.annAtycode = annAtycode;
    }

    public BigDecimal getAnnAtycode() {
        return annAtycode;
    }

    public void setAnntrAnb(BigDecimal anntrAnb) {
        this.anntrAnb = anntrAnb;
    }

    public BigDecimal getAnntrAnb() {
        return anntrAnb;
    }

    public void setAnntrRate(BigDecimal anntrRate) {
        this.anntrRate = anntrRate;
    }

    public BigDecimal getAnntrRate() {
        return anntrRate;
    }

    public void setATY_RETIREMENT_AGE(String ATY_RETIREMENT_AGE) {
        this.ATY_RETIREMENT_AGE = ATY_RETIREMENT_AGE;
    }

    public String getATY_RETIREMENT_AGE() {
        return ATY_RETIREMENT_AGE;
    }

    public void setAnntrGender(String anntrGender) {
        this.anntrGender = anntrGender;
    }

    public String getAnntrGender() {
        return anntrGender;
    }

    public void setAnntrGenderDesc(String anntrGenderDesc) {
        this.anntrGenderDesc = anntrGenderDesc;
    }

    public String getAnntrGenderDesc() {
        return anntrGenderDesc;
    }
}
