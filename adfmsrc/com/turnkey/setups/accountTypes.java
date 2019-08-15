package com.turnkey.setups;

import java.math.BigDecimal;

import javax.mail.Message;

import org.apache.commons.lang.StringUtils;


public class accountTypes {
    public accountTypes() {
        super();
    }
    public BigDecimal ACT_CODE;
    public String ACT_ACCOUNT_TYPE, ACT_TYPE_SHT_DESC;

//banks
    private BigDecimal bbrCode;
    private String bbrDescription;
    
//commission rates
    private BigDecimal atrCode;
    private String atrDesc;
    
//agents branches
    private BigDecimal brnCode;
    private String brnShtDesc;
    private String brnName;
    
//agents contacts
    private BigDecimal lacCode;
    private String lacContactTitle;
    private String lacContactPerson;
    private String lacAgnCode;
    
//new agents
    private BigDecimal agnCode;
    private String agnName;
    private String agnStatus;
    
    private String lac_telephone;
    private String lac_sex;
    private String lac_address;
    private String lac_contact_name;
    private String lac_contact_email;
    
    public void setACT_CODE(BigDecimal ACT_CODE) {
        this.ACT_CODE = ACT_CODE;
    }

    public BigDecimal getACT_CODE() {
        return ACT_CODE;
    }

    public void setACT_ACCOUNT_TYPE(String ACT_ACCOUNT_TYPE) {
        this.ACT_ACCOUNT_TYPE = ACT_ACCOUNT_TYPE;
    }

    public String getACT_ACCOUNT_TYPE() {
        return ACT_ACCOUNT_TYPE;
    }

    public void setACT_TYPE_SHT_DESC(String ACT_TYPE_SHT_DESC) {
        this.ACT_TYPE_SHT_DESC = ACT_TYPE_SHT_DESC;
    }

    public String getACT_TYPE_SHT_DESC() {
        return ACT_TYPE_SHT_DESC;
    }

    public void setBbrCode(BigDecimal bbrCode) {
        this.bbrCode = bbrCode;
    }

    public BigDecimal getBbrCode() {
        return bbrCode;
    }

    public void setBbrDescription(String bbrDescription) {
        this.bbrDescription = bbrDescription;
    }

    public String getBbrDescription() {
        return bbrDescription;
    }

    public void setAtrCode(BigDecimal atrCode) {
        this.atrCode = atrCode;
    }

    public BigDecimal getAtrCode() {
        return atrCode;
    }

    public void setAtrDesc(String atrDesc) {
        this.atrDesc = atrDesc;
    }

    public String getAtrDesc() {
        return atrDesc;
    }

    public void setBrnCode(BigDecimal brnCode) {
        this.brnCode = brnCode;
    }

    public BigDecimal getBrnCode() {
        return brnCode;
    }

    public void setBrnShtDesc(String brnShtDesc) {
        this.brnShtDesc = brnShtDesc;
    }

    public String getBrnShtDesc() {
        return brnShtDesc;
    }

    public void setBrnName(String brnName) {
        this.brnName = brnName;
    }

    public String getBrnName() {
        return brnName;
    }

    public void setLacCode(BigDecimal lacCode) {
        this.lacCode = lacCode;
    }

    public BigDecimal getLacCode() {
        return lacCode;
    }

    public void setLacContactTitle(String lacContactTitle) {
        this.lacContactTitle = lacContactTitle;
    }

    public String getLacContactTitle() {
        return lacContactTitle;
    }

    public void setLacContactPerson(String lacContactPerson) {
        this.lacContactPerson = lacContactPerson;
    }

    public String getLacContactPerson() {
        return lacContactPerson;
    }

    public void setLacAgnCode(String lacAgnCode) {
        this.lacAgnCode = lacAgnCode;
    }

    public String getLacAgnCode() {
        return lacAgnCode;
    }


    public void setAgnCode(BigDecimal agnCode) {
        this.agnCode = agnCode;
    }

    public BigDecimal getAgnCode() {
        return agnCode;
    }

    public void setAgnName(String agnName) {
        this.agnName = agnName;
    }

    public String getAgnName() {
        return agnName;
    }

    public void setAgnStatus(String agnStatus) {
        this.agnStatus = agnStatus;
    }

    public String getAgnStatus() {
        return agnStatus;
    }

    public void setLac_telephone(String lac_telephone) {
        this.lac_telephone = lac_telephone;
    }

    public String getLac_telephone() {
        return lac_telephone;
    }

    public void setLac_sex(String lac_sex) {
        this.lac_sex = lac_sex;
    }

    public String getLac_sex() {
        return lac_sex;
    }

    public void setLac_address(String lac_address) {
        this.lac_address = lac_address;
    }

    public String getLac_address() {
        return lac_address;
    }

    public void setLac_contact_name(String lac_contact_name) {
        this.lac_contact_name = lac_contact_name;
    }

    public String getLac_contact_name() {
        return lac_contact_name;
    }

    public void setLac_contact_email(String lac_contact_email) {
        this.lac_contact_email = lac_contact_email;
    }

    public String getLac_contact_email() {
        return lac_contact_email;
    }
}
