package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class pensionCostingFactors {
    public pensionCostingFactors() {
        super();
    }
    //pension costing factors
    private BigDecimal pcfsCode;
    private BigDecimal pcfsEsca;
    private BigDecimal pcfsInterest;
    private BigDecimal pcfsWithRate;
    private String pcfsRateType;
    private String pcfsRateTypeDesc;
    private BigDecimal pcfsDivFact;
    private BigDecimal peir_int_rate;
    
    //contribution factors
    private BigDecimal peirCode;
    private BigDecimal peirCntrTaxExempt;
    private BigDecimal peirTaxExempt;
    private BigDecimal peirMaxTaxExempt;
    private BigDecimal peirIntRate;
    private BigDecimal peirTaxRelief;
    private BigDecimal peirUndwConvFactor;
    private BigDecimal peirDirConvFactor;
    private String peirFactorType;
    private String peirFactorTypeDesc;
    private Date peirWef;
    private Date peirWet;
    private BigDecimal peir_empyr_lump_tax_exmpt;
    
    private BigDecimal PCOM_CODE;
    private BigDecimal PCOM_RANGE_FROM;
    private BigDecimal PCOM_RANGE_TO;
    private BigDecimal PCOM_PERC;
    
    //retirement ages
    private BigDecimal retCode;
    private BigDecimal retAge;
    private String retSex;
    private String retSexDesc;
    private BigDecimal retProdCode;
    
    //emv er rates
    private BigDecimal emverCode;
    private BigDecimal emverAnb;
    private BigDecimal emverBasicSa;
    private BigDecimal emverBasicPrem;
    private BigDecimal emverEmvValue;
    private BigDecimal emverProdCode;
    private BigDecimal emverRetCode;
    
    //emv ee rates
    private BigDecimal emveeCode;
    private BigDecimal emveeTerm;
    private BigDecimal emveeBasicPrem;
    private BigDecimal emveeBasicSa;
    private BigDecimal emveeProdCode;
    private BigDecimal emveeEmv;

    //gratuity rates
    private BigDecimal grapCode;
    private BigDecimal grapProdCode;
    private BigDecimal grapServiceYrs;
    private BigDecimal grapGratPct;
    private BigDecimal grapPensionPct;
    
  private BigDecimal PCFR_CODE;
  private BigDecimal PCFR_TERM_FROM;
  private BigDecimal PCFR_TERM_TO;
  private BigDecimal PCFR_BENE_DISC_FACT;
  private BigDecimal PCFR_CONTR_FACT;
  
  private BigDecimal PVGS_CODE; 
  private BigDecimal PVGS_YRS_FROM;
  private BigDecimal PVGS_YRS_TO; 
  private BigDecimal PVGS_EMYR_PCT_ENT; 
  private BigDecimal PVGS_EMYE_PCT_ENT; 

    public void setPcfsCode(BigDecimal pcfsCode) {
        this.pcfsCode = pcfsCode;
    }

    public BigDecimal getPcfsCode() {
        return pcfsCode;
    }

    public void setPcfsEsca(BigDecimal pcfsEsca) {
        this.pcfsEsca = pcfsEsca;
    }

    public BigDecimal getPcfsEsca() {
        return pcfsEsca;
    }

    public void setPcfsInterest(BigDecimal pcfsInterest) {
        this.pcfsInterest = pcfsInterest;
    }

    public BigDecimal getPcfsInterest() {
        return pcfsInterest;
    }

    public void setPcfsWithRate(BigDecimal pcfsWithRate) {
        this.pcfsWithRate = pcfsWithRate;
    }

    public BigDecimal getPcfsWithRate() {
        return pcfsWithRate;
    }

    public void setPcfsRateType(String pcfsRateType) {
        this.pcfsRateType = pcfsRateType;
    }

    public String getPcfsRateType() {
        return pcfsRateType;
    }

    public void setPcfsRateTypeDesc(String pcfsRateTypeDesc) {
        this.pcfsRateTypeDesc = pcfsRateTypeDesc;
    }

    public String getPcfsRateTypeDesc() {
        return pcfsRateTypeDesc;
    }

    public void setPcfsDivFact(BigDecimal pcfsDivFact) {
        this.pcfsDivFact = pcfsDivFact;
    }

    public BigDecimal getPcfsDivFact() {
        return pcfsDivFact;
    }

    public void setPeirCode(BigDecimal peirCode) {
        this.peirCode = peirCode;
    }

    public BigDecimal getPeirCode() {
        return peirCode;
    }

    public void setPeirCntrTaxExempt(BigDecimal peirCntrTaxExempt) {
        this.peirCntrTaxExempt = peirCntrTaxExempt;
    }

    public BigDecimal getPeirCntrTaxExempt() {
        return peirCntrTaxExempt;
    }

    public void setPeirTaxExempt(BigDecimal peirTaxExempt) {
        this.peirTaxExempt = peirTaxExempt;
    }

    public BigDecimal getPeirTaxExempt() {
        return peirTaxExempt;
    }

    public void setPeirMaxTaxExempt(BigDecimal peirMaxTaxExempt) {
        this.peirMaxTaxExempt = peirMaxTaxExempt;
    }

    public BigDecimal getPeirMaxTaxExempt() {
        return peirMaxTaxExempt;
    }

    public void setPeirIntRate(BigDecimal peirIntRate) {
        this.peirIntRate = peirIntRate;
    }

    public BigDecimal getPeirIntRate() {
        return peirIntRate;
    }

    public void setPeirTaxRelief(BigDecimal peirTaxRelief) {
        this.peirTaxRelief = peirTaxRelief;
    }

    public BigDecimal getPeirTaxRelief() {
        return peirTaxRelief;
    }

    public void setPeirUndwConvFactor(BigDecimal peirUndwConvFactor) {
        this.peirUndwConvFactor = peirUndwConvFactor;
    }

    public BigDecimal getPeirUndwConvFactor() {
        return peirUndwConvFactor;
    }

    public void setPeirDirConvFactor(BigDecimal peirDirConvFactor) {
        this.peirDirConvFactor = peirDirConvFactor;
    }

    public BigDecimal getPeirDirConvFactor() {
        return peirDirConvFactor;
    }

    public void setPeirFactorType(String peirFactorType) {
        this.peirFactorType = peirFactorType;
    }

    public String getPeirFactorType() {
        return peirFactorType;
    }

    public void setPeirFactorTypeDesc(String peirFactorTypeDesc) {
        this.peirFactorTypeDesc = peirFactorTypeDesc;
    }

    public String getPeirFactorTypeDesc() {
        return peirFactorTypeDesc;
    }

    public void setPeirWef(Date peirWef) {
        this.peirWef = peirWef;
    }

    public Date getPeirWef() {
        return peirWef;
    }

    public void setPeirWet(Date peirWet) {
        this.peirWet = peirWet;
    }

    public Date getPeirWet() {
        return peirWet;
    }

    public void setRetCode(BigDecimal retCode) {
        this.retCode = retCode;
    }

    public BigDecimal getRetCode() {
        return retCode;
    }

    public void setRetAge(BigDecimal retAge) {
        this.retAge = retAge;
    }

    public BigDecimal getRetAge() {
        return retAge;
    }

    public void setRetSex(String retSex) {
        this.retSex = retSex;
    }

    public String getRetSex() {
        return retSex;
    }

    public void setRetSexDesc(String retSexDesc) {
        this.retSexDesc = retSexDesc;
    }

    public String getRetSexDesc() {
        return retSexDesc;
    }

    public void setRetProdCode(BigDecimal retProdCode) {
        this.retProdCode = retProdCode;
    }

    public BigDecimal getRetProdCode() {
        return retProdCode;
    }

    public void setEmverCode(BigDecimal emverCode) {
        this.emverCode = emverCode;
    }

    public BigDecimal getEmverCode() {
        return emverCode;
    }

    public void setEmverAnb(BigDecimal emverAnb) {
        this.emverAnb = emverAnb;
    }

    public BigDecimal getEmverAnb() {
        return emverAnb;
    }

    public void setEmverBasicSa(BigDecimal emverBasicSa) {
        this.emverBasicSa = emverBasicSa;
    }

    public BigDecimal getEmverBasicSa() {
        return emverBasicSa;
    }

    public void setEmverBasicPrem(BigDecimal emverBasicPrem) {
        this.emverBasicPrem = emverBasicPrem;
    }

    public BigDecimal getEmverBasicPrem() {
        return emverBasicPrem;
    }

    public void setEmverEmvValue(BigDecimal emverEmvValue) {
        this.emverEmvValue = emverEmvValue;
    }

    public BigDecimal getEmverEmvValue() {
        return emverEmvValue;
    }

    public void setEmverProdCode(BigDecimal emverProdCode) {
        this.emverProdCode = emverProdCode;
    }

    public BigDecimal getEmverProdCode() {
        return emverProdCode;
    }

    public void setEmverRetCode(BigDecimal emverRetCode) {
        this.emverRetCode = emverRetCode;
    }

    public BigDecimal getEmverRetCode() {
        return emverRetCode;
    }

    public void setEmveeCode(BigDecimal emveeCode) {
        this.emveeCode = emveeCode;
    }

    public BigDecimal getEmveeCode() {
        return emveeCode;
    }

    public void setEmveeTerm(BigDecimal emveeTerm) {
        this.emveeTerm = emveeTerm;
    }

    public BigDecimal getEmveeTerm() {
        return emveeTerm;
    }

    public void setEmveeBasicPrem(BigDecimal emveeBasicPrem) {
        this.emveeBasicPrem = emveeBasicPrem;
    }

    public BigDecimal getEmveeBasicPrem() {
        return emveeBasicPrem;
    }

    public void setEmveeBasicSa(BigDecimal emveeBasicSa) {
        this.emveeBasicSa = emveeBasicSa;
    }

    public BigDecimal getEmveeBasicSa() {
        return emveeBasicSa;
    }

    public void setEmveeProdCode(BigDecimal emveeProdCode) {
        this.emveeProdCode = emveeProdCode;
    }

    public BigDecimal getEmveeProdCode() {
        return emveeProdCode;
    }

    public void setEmveeEmv(BigDecimal emveeEmv) {
        this.emveeEmv = emveeEmv;
    }

    public BigDecimal getEmveeEmv() {
        return emveeEmv;
    }

    public void setGrapCode(BigDecimal grapCode) {
        this.grapCode = grapCode;
    }

    public BigDecimal getGrapCode() {
        return grapCode;
    }

    public void setGrapProdCode(BigDecimal grapProdCode) {
        this.grapProdCode = grapProdCode;
    }

    public BigDecimal getGrapProdCode() {
        return grapProdCode;
    }

    public void setGrapServiceYrs(BigDecimal grapServiceYrs) {
        this.grapServiceYrs = grapServiceYrs;
    }

    public BigDecimal getGrapServiceYrs() {
        return grapServiceYrs;
    }

    public void setGrapGratPct(BigDecimal grapGratPct) {
        this.grapGratPct = grapGratPct;
    }

    public BigDecimal getGrapGratPct() {
        return grapGratPct;
    }

    public void setGrapPensionPct(BigDecimal grapPensionPct) {
        this.grapPensionPct = grapPensionPct;
    }

    public BigDecimal getGrapPensionPct() {
        return grapPensionPct;
    }

    public void setPeir_int_rate(BigDecimal peir_int_rate) {
        this.peir_int_rate = peir_int_rate;
    }

    public BigDecimal getPeir_int_rate() {
        return peir_int_rate;
    }

    public void setPCFR_CODE(BigDecimal PCFR_CODE) {
        this.PCFR_CODE = PCFR_CODE;
    }

    public BigDecimal getPCFR_CODE() {
        return PCFR_CODE;
    }

    public void setPCFR_TERM_FROM(BigDecimal PCFR_TERM_FROM) {
        this.PCFR_TERM_FROM = PCFR_TERM_FROM;
    }

    public BigDecimal getPCFR_TERM_FROM() {
        return PCFR_TERM_FROM;
    }

    public void setPCFR_TERM_TO(BigDecimal PCFR_TERM_TO) {
        this.PCFR_TERM_TO = PCFR_TERM_TO;
    }

    public BigDecimal getPCFR_TERM_TO() {
        return PCFR_TERM_TO;
    }

    public void setPCFR_BENE_DISC_FACT(BigDecimal PCFR_BENE_DISC_FACT) {
        this.PCFR_BENE_DISC_FACT = PCFR_BENE_DISC_FACT;
    }

    public BigDecimal getPCFR_BENE_DISC_FACT() {
        return PCFR_BENE_DISC_FACT;
    }

    public void setPCFR_CONTR_FACT(BigDecimal PCFR_CONTR_FACT) {
        this.PCFR_CONTR_FACT = PCFR_CONTR_FACT;
    }

    public BigDecimal getPCFR_CONTR_FACT() {
        return PCFR_CONTR_FACT;
    }

    public void setPVGS_CODE(BigDecimal PVGS_CODE) {
        this.PVGS_CODE = PVGS_CODE;
    }

    public BigDecimal getPVGS_CODE() {
        return PVGS_CODE;
    }

    public void setPVGS_YRS_FROM(BigDecimal PVGS_YRS_FROM) {
        this.PVGS_YRS_FROM = PVGS_YRS_FROM;
    }

    public BigDecimal getPVGS_YRS_FROM() {
        return PVGS_YRS_FROM;
    }

    public void setPVGS_YRS_TO(BigDecimal PVGS_YRS_TO) {
        this.PVGS_YRS_TO = PVGS_YRS_TO;
    }

    public BigDecimal getPVGS_YRS_TO() {
        return PVGS_YRS_TO;
    }

    public void setPVGS_EMYR_PCT_ENT(BigDecimal PVGS_EMYR_PCT_ENT) {
        this.PVGS_EMYR_PCT_ENT = PVGS_EMYR_PCT_ENT;
    }

    public BigDecimal getPVGS_EMYR_PCT_ENT() {
        return PVGS_EMYR_PCT_ENT;
    }

    public void setPVGS_EMYE_PCT_ENT(BigDecimal PVGS_EMYE_PCT_ENT) {
        this.PVGS_EMYE_PCT_ENT = PVGS_EMYE_PCT_ENT;
    }

    public BigDecimal getPVGS_EMYE_PCT_ENT() {
        return PVGS_EMYE_PCT_ENT;
    }

    public void setPeir_empyr_lump_tax_exmpt(BigDecimal peir_empyr_lump_tax_exmpt) {
        this.peir_empyr_lump_tax_exmpt = peir_empyr_lump_tax_exmpt;
    }

    public BigDecimal getPeir_empyr_lump_tax_exmpt() {
        return peir_empyr_lump_tax_exmpt;
    }
    
    public void setPCOM_CODE(BigDecimal PCOM_CODE) {
        this.PCOM_CODE = PCOM_CODE;
    }

    public BigDecimal getPCOM_CODE() {
        return PCOM_CODE;
    }
    
    public void setPCOM_RANGE_FROM(BigDecimal PCOM_RANGE_FROM) {
        this.PCOM_RANGE_FROM = PCOM_RANGE_FROM;
    }

    public BigDecimal getPCOM_RANGE_FROM() {
        return PCOM_RANGE_FROM;
    }
    
    public void setPCOM_RANGE_TO(BigDecimal PCOM_RANGE_TO) {
        this.PCOM_RANGE_TO = PCOM_RANGE_TO;
    }

    public BigDecimal getPCOM_RANGE_TO() {
        return PCOM_RANGE_TO;
    }
    
    public void setPCOM_PERC(BigDecimal PCOM_PERC) {
        this.PCOM_PERC = PCOM_PERC;
    }

    public BigDecimal getPCOM_PERC() {
        return PCOM_PERC;
    }
}
