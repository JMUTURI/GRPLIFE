package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class causations {
    public causations() {
        super();
    }
    private BigDecimal causCode;
    private String causShtdesc;
    private String causDesc;
    private BigDecimal causClacode;
    private String causType;
    private String causWthld_emplr_fnd;
    private String causClm_prefix;
    private String DRCR_END_NARRATIVE;
    private String DRCR_DR_COIN_NARRATIVE; 
    private String DRCR_CR_COIN_NARRATIVE;
   private String DRCR_COIN_APPORTION_NARRATIVE;
   private String RD_MATURITY_DOC;
   private String RD_MATURITY_DOC_DESC;
    
    //death disability causes
    private BigDecimal ddcCode;
    private String ddcShtDesc;
    private String ddcDesc;
    private String ddcHivDesc;
    private BigDecimal ddcWaitingPrd;
    
    //causation causes
    private BigDecimal cscCode;
    private BigDecimal cscCausCode;
    private BigDecimal cscDdcCode;
    private String cscSex;
    private BigDecimal cscMinClaimableprd;
    private String ddsDesc;
    private String ddsShtDesc;
    private String caus_wthld_emple_fnd;
    private BigDecimal caus_age_from; 
    private BigDecimal caus_age_to;
    
    //non medical claims
    private BigDecimal nmsCode;
    private BigDecimal mmsYearFrom;
    private BigDecimal nmsYearTo;
    private BigDecimal nmsRate;
    private BigDecimal nmsMaxAmt;
    private BigDecimal nmsDivFact;
    private Date nmsWef;
    private Date nmsWet;
    
    //cover type causations
    private BigDecimal cvtcCode;
    private BigDecimal cvtcCvtCode;
    private String cvtcCausShtDesc;
    private BigDecimal cvtcCauseCode;
    private BigDecimal  cvtcProdCode;
    private String cvtcProdShtDesc;
    private String cvtcCausDesc;
    private BigDecimal cvtcMinDaysClaimable,cvtcMaxDaysClaimable;
    //policy documents
    private BigDecimal rdClaCode;
    private BigDecimal rdCode;
    private String rdShtDesc;
    private String rdDesc;
    private String rdByProd;
    private String rdByProdDesc;
    private String rdPolDoc;
    private String rdPolDocDesc;
    private String rdDthClmdoc;
    private String rdDthClmdocDesc;
    private String rdDisClmDoc;
    private String rdDisClmDocDesc;
    private String rdWthrClmDoc;
    private String rdWthrClmDocDesc;
    
    //product policy documents
    private BigDecimal rdpRdCode;
    private BigDecimal rdpProdCode;
    private String productDisplay;
    
    //drcr narratives
    private BigDecimal drcrCode;
    private String btrTransCode;
    private String drNarrative;
    private String crNarrative;
    
    //disability losses
    private BigDecimal ldlCode;
    private String ldlDesc;
    private BigDecimal ldlPerc;
    private BigDecimal ldlPctCode;
    private BigDecimal ldlCvtCode;
    private BigDecimal ldlCvtcCode;
    private String ldlClosePol;
    private String ldlClosePolDesc;
    private String ldlWklIndemnity;
    private String ldlWklIndemnityDesc;
    private String ldlDivisionFactor;
    
    public void setCausCode(BigDecimal causCode) {
        this.causCode = causCode;
    }

    public BigDecimal getCausCode() {
        return causCode;
    }

    public void setCausShtdesc(String causShtdesc) {
        this.causShtdesc = causShtdesc;
    }

    public String getCausShtdesc() {
        return causShtdesc;
    }

    public void setCausDesc(String causDesc) {
        this.causDesc = causDesc;
    }

    public String getCausDesc() {
        return causDesc;
    }

    public void setCausClacode(BigDecimal causClacode) {
        this.causClacode = causClacode;
    }

    public BigDecimal getCausClacode() {
        return causClacode;
    }

    public void setCausType(String causType) {
        this.causType = causType;
    }

    public String getCausType() {
        return causType;
    }

    public void setCausWthld_emplr_fnd(String causWthld_emplr_fnd) {
        this.causWthld_emplr_fnd = causWthld_emplr_fnd;
    }

    public String getCausWthld_emplr_fnd() {
        return causWthld_emplr_fnd;
    }

    public void setCausClm_prefix(String causClm_prefix) {
        this.causClm_prefix = causClm_prefix;
    }

    public String getCausClm_prefix() {
        return causClm_prefix;
    }

    public void setDdcCode(BigDecimal ddcCode) {
        this.ddcCode = ddcCode;
    }

    public BigDecimal getDdcCode() {
        return ddcCode;
    }

    public void setDdcShtDesc(String ddcShtDesc) {
        this.ddcShtDesc = ddcShtDesc;
    }

    public String getDdcShtDesc() {
        return ddcShtDesc;
    }

    public void setDdcDesc(String ddcDesc) {
        this.ddcDesc = ddcDesc;
    }

    public String getDdcDesc() {
        return ddcDesc;
    }

    public void setDdcHivDesc(String ddcHivDesc) {
        this.ddcHivDesc = ddcHivDesc;
    }

    public String getDdcHivDesc() {
        return ddcHivDesc;
    }

    public void setDdcWaitingPrd(BigDecimal ddcWaitingPrd) {
        this.ddcWaitingPrd = ddcWaitingPrd;
    }

    public BigDecimal getDdcWaitingPrd() {
        return ddcWaitingPrd;
    }

    public void setCscCode(BigDecimal cscCode) {
        this.cscCode = cscCode;
    }

    public BigDecimal getCscCode() {
        return cscCode;
    }

    public void setCscDdcCode(BigDecimal cscDdcCode) {
        this.cscDdcCode = cscDdcCode;
    }

    public BigDecimal getCscDdcCode() {
        return cscDdcCode;
    }

    public void setCscSex(String cscSex) {
        this.cscSex = cscSex;
    }

    public String getCscSex() {
        return cscSex;
    }

    public void setCscMinClaimableprd(BigDecimal cscMinClaimableprd) {
        this.cscMinClaimableprd = cscMinClaimableprd;
    }

    public BigDecimal getCscMinClaimableprd() {
        return cscMinClaimableprd;
    }

    public void setDdsDesc(String ddsDesc) {
        this.ddsDesc = ddsDesc;
    }

    public String getDdsDesc() {
        return ddsDesc;
    }

    public void setDdsShtDesc(String ddsShtDesc) {
        this.ddsShtDesc = ddsShtDesc;
    }

    public String getDdsShtDesc() {
        return ddsShtDesc;
    }

    public void setCscCausCode(BigDecimal cscCausCode) {
        this.cscCausCode = cscCausCode;
    }

    public BigDecimal getCscCausCode() {
        return cscCausCode;
    }

    public void setNmsCode(BigDecimal nmsCode) {
        this.nmsCode = nmsCode;
    }

    public BigDecimal getNmsCode() {
        return nmsCode;
    }

    public void setMmsYearFrom(BigDecimal mmsYearFrom) {
        this.mmsYearFrom = mmsYearFrom;
    }

    public BigDecimal getMmsYearFrom() {
        return mmsYearFrom;
    }

    public void setNmsYearTo(BigDecimal nmsYearTo) {
        this.nmsYearTo = nmsYearTo;
    }

    public BigDecimal getNmsYearTo() {
        return nmsYearTo;
    }

    public void setNmsRate(BigDecimal nmsRate) {
        this.nmsRate = nmsRate;
    }

    public BigDecimal getNmsRate() {
        return nmsRate;
    }

    public void setNmsMaxAmt(BigDecimal nmsMaxAmt) {
        this.nmsMaxAmt = nmsMaxAmt;
    }

    public BigDecimal getNmsMaxAmt() {
        return nmsMaxAmt;
    }

    public void setNmsDivFact(BigDecimal nmsDivFact) {
        this.nmsDivFact = nmsDivFact;
    }

    public BigDecimal getNmsDivFact() {
        return nmsDivFact;
    }

    public void setNmsWef(Date nmsWef) {
        this.nmsWef = nmsWef;
    }

    public Date getNmsWef() {
        return nmsWef;
    }

    public void setNmsWet(Date nmsWet) {
        this.nmsWet = nmsWet;
    }

    public Date getNmsWet() {
        return nmsWet;
    }

    public void setCvtcCode(BigDecimal cvtcCode) {
        this.cvtcCode = cvtcCode;
    }

    public BigDecimal getCvtcCode() {
        return cvtcCode;
    }

    public void setCvtcCvtCode(BigDecimal cvtcCvtCode) {
        this.cvtcCvtCode = cvtcCvtCode;
    }

    public BigDecimal getCvtcCvtCode() {
        return cvtcCvtCode;
    }

    public void setCvtcCausShtDesc(String cvtcCausShtDesc) {
        this.cvtcCausShtDesc = cvtcCausShtDesc;
    }

    public String getCvtcCausShtDesc() {
        return cvtcCausShtDesc;
    }

    public void setCvtcCauseCode(BigDecimal cvtcCauseCode) {
        this.cvtcCauseCode = cvtcCauseCode;
    }

    public BigDecimal getCvtcCauseCode() {
        return cvtcCauseCode;
    }

    public void setCvtcProdCode(BigDecimal cvtcProdCode) {
        this.cvtcProdCode = cvtcProdCode;
    }

    public BigDecimal getCvtcProdCode() {
        return cvtcProdCode;
    }

    public void setCvtcProdShtDesc(String cvtcProdShtDesc) {
        this.cvtcProdShtDesc = cvtcProdShtDesc;
    }

    public String getCvtcProdShtDesc() {
        return cvtcProdShtDesc;
    }

    public void setCvtcCausDesc(String cvtcCausDesc) {
        this.cvtcCausDesc = cvtcCausDesc;
    }

    public String getCvtcCausDesc() {
        return cvtcCausDesc;
    }

    public void setRdClaCode(BigDecimal rdClaCode) {
        this.rdClaCode = rdClaCode;
    }

    public BigDecimal getRdClaCode() {
        return rdClaCode;
    }

    public void setRdCode(BigDecimal rdCode) {
        this.rdCode = rdCode;
    }

    public BigDecimal getRdCode() {
        return rdCode;
    }

    public void setRdShtDesc(String rdShtDesc) {
        this.rdShtDesc = rdShtDesc;
    }

    public String getRdShtDesc() {
        return rdShtDesc;
    }

    public void setRdDesc(String rdDesc) {
        this.rdDesc = rdDesc;
    }

    public String getRdDesc() {
        return rdDesc;
    }

    public void setRdByProd(String rdByProd) {
        this.rdByProd = rdByProd;
    }

    public String getRdByProd() {
        return rdByProd;
    }

    public void setRdByProdDesc(String rdByProdDesc) {
        this.rdByProdDesc = rdByProdDesc;
    }

    public String getRdByProdDesc() {
        return rdByProdDesc;
    }

    public void setRdPolDoc(String rdPolDoc) {
        this.rdPolDoc = rdPolDoc;
    }

    public String getRdPolDoc() {
        return rdPolDoc;
    }

    public void setRdPolDocDesc(String rdPolDocDesc) {
        this.rdPolDocDesc = rdPolDocDesc;
    }

    public String getRdPolDocDesc() {
        return rdPolDocDesc;
    }

    public void setRdDthClmdoc(String rdDthClmdoc) {
        this.rdDthClmdoc = rdDthClmdoc;
    }

    public String getRdDthClmdoc() {
        return rdDthClmdoc;
    }

    public void setRdDthClmdocDesc(String rdDthClmdocDesc) {
        this.rdDthClmdocDesc = rdDthClmdocDesc;
    }

    public String getRdDthClmdocDesc() {
        return rdDthClmdocDesc;
    }

    public void setRdDisClmDoc(String rdDisClmDoc) {
        this.rdDisClmDoc = rdDisClmDoc;
    }

    public String getRdDisClmDoc() {
        return rdDisClmDoc;
    }

    public void setRdDisClmDocDesc(String rdDisClmDocDesc) {
        this.rdDisClmDocDesc = rdDisClmDocDesc;
    }

    public String getRdDisClmDocDesc() {
        return rdDisClmDocDesc;
    }

    public void setRdWthrClmDoc(String rdWthrClmDoc) {
        this.rdWthrClmDoc = rdWthrClmDoc;
    }

    public String getRdWthrClmDoc() {
        return rdWthrClmDoc;
    }

    public void setRdWthrClmDocDesc(String rdWthrClmDocDesc) {
        this.rdWthrClmDocDesc = rdWthrClmDocDesc;
    }

    public String getRdWthrClmDocDesc() {
        return rdWthrClmDocDesc;
    }

    public void setRdpRdCode(BigDecimal rdpRdCode) {
        this.rdpRdCode = rdpRdCode;
    }

    public BigDecimal getRdpRdCode() {
        return rdpRdCode;
    }

    public void setRdpProdCode(BigDecimal rdpProdCode) {
        this.rdpProdCode = rdpProdCode;
    }

    public BigDecimal getRdpProdCode() {
        return rdpProdCode;
    }

    public void setProductDisplay(String productDisplay) {
        this.productDisplay = productDisplay;
    }

    public String getProductDisplay() {
        return productDisplay;
    }

    public void setDrcrCode(BigDecimal drcrCode) {
        this.drcrCode = drcrCode;
    }

    public BigDecimal getDrcrCode() {
        return drcrCode;
    }

    public void setBtrTransCode(String btrTransCode) {
        this.btrTransCode = btrTransCode;
    }

    public String getBtrTransCode() {
        return btrTransCode;
    }

    public void setDrNarrative(String drNarrative) {
        this.drNarrative = drNarrative;
    }

    public String getDrNarrative() {
        return drNarrative;
    }

    public void setCrNarrative(String crNarrative) {
        this.crNarrative = crNarrative;
    }

    public String getCrNarrative() {
        return crNarrative;
    }

    public void setLdlCode(BigDecimal ldlCode) {
        this.ldlCode = ldlCode;
    }

    public BigDecimal getLdlCode() {
        return ldlCode;
    }

    public void setLdlDesc(String ldlDesc) {
        this.ldlDesc = ldlDesc;
    }

    public String getLdlDesc() {
        return ldlDesc;
    }

    public void setLdlPerc(BigDecimal ldlPerc) {
        this.ldlPerc = ldlPerc;
    }

    public BigDecimal getLdlPerc() {
        return ldlPerc;
    }

    public void setLdlPctCode(BigDecimal ldlPctCode) {
        this.ldlPctCode = ldlPctCode;
    }

    public BigDecimal getLdlPctCode() {
        return ldlPctCode;
    }

    public void setLdlCvtCode(BigDecimal ldlCvtCode) {
        this.ldlCvtCode = ldlCvtCode;
    }

    public BigDecimal getLdlCvtCode() {
        return ldlCvtCode;
    }

    public void setLdlCvtcCode(BigDecimal ldlCvtcCode) {
        this.ldlCvtcCode = ldlCvtcCode;
    }

    public BigDecimal getLdlCvtcCode() {
        return ldlCvtcCode;
    }

    public void setLdlClosePol(String ldlClosePol) {
        this.ldlClosePol = ldlClosePol;
    }

    public String getLdlClosePol() {
        return ldlClosePol;
    }

    public void setLdlClosePolDesc(String ldlClosePolDesc) {
        this.ldlClosePolDesc = ldlClosePolDesc;
    }

    public String getLdlClosePolDesc() {
        return ldlClosePolDesc;
    }

    public void setLdlWklIndemnity(String ldlWklIndemnity) {
        this.ldlWklIndemnity = ldlWklIndemnity;
    }

    public String getLdlWklIndemnity() {
        return ldlWklIndemnity;
    }

    public void setLdlWklIndemnityDesc(String ldlWklIndemnityDesc) {
        this.ldlWklIndemnityDesc = ldlWklIndemnityDesc;
    }

    public String getLdlWklIndemnityDesc() {
        return ldlWklIndemnityDesc;
    }

    public void setLdlDivisionFactor(String ldlDivisionFactor) {
        this.ldlDivisionFactor = ldlDivisionFactor;
    }

    public String getLdlDivisionFactor() {
        return ldlDivisionFactor;
    }

    public void setDRCR_END_NARRATIVE(String DRCR_END_NARRATIVE) {
        this.DRCR_END_NARRATIVE = DRCR_END_NARRATIVE;
    }

    public String getDRCR_END_NARRATIVE() {
        return DRCR_END_NARRATIVE;
    }

    public void setDRCR_DR_COIN_NARRATIVE(String DRCR_DR_COIN_NARRATIVE) {
        this.DRCR_DR_COIN_NARRATIVE = DRCR_DR_COIN_NARRATIVE;
    }

    public String getDRCR_DR_COIN_NARRATIVE() {
        return DRCR_DR_COIN_NARRATIVE;
    }

    public void setDRCR_CR_COIN_NARRATIVE(String DRCR_CR_COIN_NARRATIVE) {
        this.DRCR_CR_COIN_NARRATIVE = DRCR_CR_COIN_NARRATIVE;
    }

    public String getDRCR_CR_COIN_NARRATIVE() {
        return DRCR_CR_COIN_NARRATIVE;
    }

    public void setCaus_wthld_emple_fnd(String caus_wthld_emple_fnd) {
        this.caus_wthld_emple_fnd = caus_wthld_emple_fnd;
    }

    public String getCaus_wthld_emple_fnd() {
        return caus_wthld_emple_fnd;
    }

    public void setCaus_age_from(BigDecimal caus_age_from) {
        this.caus_age_from = caus_age_from;
    }

    public BigDecimal getCaus_age_from() {
        return caus_age_from;
    }

    public void setCaus_age_to(BigDecimal caus_age_to) {
        this.caus_age_to = caus_age_to;
    }

    public BigDecimal getCaus_age_to() {
        return caus_age_to;
    }

    public void setRD_MATURITY_DOC(String RD_MATURITY_DOC) {
        this.RD_MATURITY_DOC = RD_MATURITY_DOC;
    }

    public String getRD_MATURITY_DOC() {
        return RD_MATURITY_DOC;
    }

    public void setRD_MATURITY_DOC_DESC(String RD_MATURITY_DOC_DESC) {
        this.RD_MATURITY_DOC_DESC = RD_MATURITY_DOC_DESC;
    }

    public String getRD_MATURITY_DOC_DESC() {
        return RD_MATURITY_DOC_DESC;
    }

    public void setDRCR_COIN_APPORTION_NARRATIVE(String DRCR_COIN_APPORTION_NARRATIVE) {
        this.DRCR_COIN_APPORTION_NARRATIVE = DRCR_COIN_APPORTION_NARRATIVE;
    }

    public String getDRCR_COIN_APPORTION_NARRATIVE() {
        return DRCR_COIN_APPORTION_NARRATIVE;
    }

    public void setCvtcMinDaysClaimable(BigDecimal cvtcMinDaysClaimable) {
        this.cvtcMinDaysClaimable = cvtcMinDaysClaimable;
    }

    public BigDecimal getCvtcMinDaysClaimable() {
        return cvtcMinDaysClaimable;
    }

    public void setCvtcMaxDaysClaimable(BigDecimal cvtcMaxDaysClaimable) {
        this.cvtcMaxDaysClaimable = cvtcMaxDaysClaimable;
    }

    public BigDecimal getCvtcMaxDaysClaimable() {
        return cvtcMaxDaysClaimable;
    }
}
