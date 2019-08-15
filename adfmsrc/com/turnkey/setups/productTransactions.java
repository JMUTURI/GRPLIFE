package com.turnkey.setups;

import java.math.BigDecimal;

public class productTransactions {
    public productTransactions() {
        super();
    }
    private BigDecimal trapProdCode;
    private String trapAccno;
    private String trapContraAcc;
    private String trapTrntCode;
    private String trntDesc;
    
    //transactionTypes
    private String trntCode;
    private String transactionDesc;
    private String trntGlCode;
    private String trntType;
    private String trntProdApplcb;
    private String trntConGlCode;
    private String trntLevel;
    
    //gl accounts
    private String accNumber;
    private String accName;
    
    //other products transaction codes
    private String productDesc;
    private String otherProdsGlcode;
    private String otherProdsContraGlCode;
    public void setTrapProdCode(BigDecimal trapProdCode) {
        this.trapProdCode = trapProdCode;
    }

    public BigDecimal getTrapProdCode() {
        return trapProdCode;
    }

    public void setTrapAccno(String trapAccno) {
        this.trapAccno = trapAccno;
    }

    public String getTrapAccno() {
        return trapAccno;
    }

    public void setTrapContraAcc(String trapContraAcc) {
        this.trapContraAcc = trapContraAcc;
    }

    public String getTrapContraAcc() {
        return trapContraAcc;
    }

    public void setTrapTrntCode(String trapTrntCode) {
        this.trapTrntCode = trapTrntCode;
    }

    public String getTrapTrntCode() {
        return trapTrntCode;
    }

    public void setTrntDesc(String trntDesc) {
        this.trntDesc = trntDesc;
    }

    public String getTrntDesc() {
        return trntDesc;
    }

    public void setTrntCode(String trntCode) {
        this.trntCode = trntCode;
    }

    public String getTrntCode() {
        return trntCode;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccName() {
        return accName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setOtherProdsGlcode(String otherProdsGlcode) {
        this.otherProdsGlcode = otherProdsGlcode;
    }

    public String getOtherProdsGlcode() {
        return otherProdsGlcode;
    }

    public void setOtherProdsContraGlCode(String otherProdsContraGlCode) {
        this.otherProdsContraGlCode = otherProdsContraGlCode;
    }

    public String getOtherProdsContraGlCode() {
        return otherProdsContraGlCode;
    }

    public void setTrntGlCode(String trntGlCode) {
        this.trntGlCode = trntGlCode;
    }

    public String getTrntGlCode() {
        return trntGlCode;
    }

    public void setTrntType(String trntType) {
        this.trntType = trntType;
    }

    public String getTrntType() {
        return trntType;
    }

    public void setTrntProdApplcb(String trntProdApplcb) {
        this.trntProdApplcb = trntProdApplcb;
    }

    public String getTrntProdApplcb() {
        return trntProdApplcb;
    }

    public void setTrntConGlCode(String trntConGlCode) {
        this.trntConGlCode = trntConGlCode;
    }

    public String getTrntConGlCode() {
        return trntConGlCode;
    }

    public void setTrntLevel(String trntLevel) {
        this.trntLevel = trntLevel;
    }

    public String getTrntLevel() {
        return trntLevel;
    }
}
