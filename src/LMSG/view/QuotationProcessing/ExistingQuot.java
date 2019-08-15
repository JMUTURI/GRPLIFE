package LMSG.view.QuotationProcessing;

import java.util.Date;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

public class ExistingQuot {
  private String client;
  private String pmascode;
  private Integer agnCode;
  private String agnname;
  private String quoNumber;
  private String branchName;
  private Double totPremium;
  private Double totSumAssured;
  private String prodShtdesc;
  private Date quoDate;
  private String quoSavingsRider;
  private String proposer;
  private String quoType;
  private String quoStatus;
  private Date quoEffectDate;
  private Integer quoAvganb;
  //private String durationType;
  private Integer quoNofmembers;
  private String depCovered;
  private String quoCalctype;
  private Double quoFclAmt;
  private Date quoCoverTo;
  private Double quoOverrideFcl;
  public static RichSelectOneChoice quotationCalcType;
  public static RichSelectOneChoice savingsRider;
  public static RichSelectOneChoice calcType;
  public static RichSelectOneChoice quotType;
  public static RichSelectOneChoice quotDurationType;
  public static RichSelectOneChoice freqOfPayment;
  public static RichSelectOneChoice quoGrpLifeRider;
  private RichSelectOneChoice quoPensionType;

  public ExistingQuot() {
  }

  public void setClient(String client) {
    this.client = client;
  }

  public String getClient() {
    return client;
  }

  public void setPmascode(String pmascode) {
    this.pmascode = pmascode;
  }

  public String getPmascode() {
    return pmascode;
  }

  public void setAgnCode(Integer agnCode) {
    this.agnCode = agnCode;
  }

  public Integer getAgnCode() {
    return agnCode;
  }

  public void setAgnname(String agnname) {
    this.agnname = agnname;
  }

  public String getAgnname() {
    return agnname;
  }

  public void setQuoNumber(String quoNumber) {
    this.quoNumber = quoNumber;
  }

  public String getQuoNumber() {
    return quoNumber;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public String getBranchName() {
    return branchName;
  }

  public void setTotPremium(Double totPremium) {
    this.totPremium = totPremium;
  }

  public Double getTotPremium() {
    return totPremium;
  }

  public void setTotSumAssured(Double totSumAssured) {
    this.totSumAssured = totSumAssured;
  }

  public Double getTotSumAssured() {
    return totSumAssured;
  }

  public void setQuoDate(Date quoDate) {
    this.quoDate = quoDate;
  }

  public Date getQuoDate() {
    return quoDate;
  }

  public void setProdShtdesc(String prodShtdesc) {
    this.prodShtdesc = prodShtdesc;
  }

  public String getProdShtdesc() {
    return prodShtdesc;
  }

  public void setProposer(String proposer) {
    this.proposer = proposer;
  }

  public String getProposer() {
    return proposer;
  }

  public void setQuoType(String quoType) {
    this.quoType = quoType;
  }

  public String getQuoType() {
    return quoType;
  }

  public void setQuoStatus(String quoStatus) {
    this.quoStatus = quoStatus;
  }

  public String getQuoStatus() {
    return quoStatus;
  }

  public void setQuoEffectDate(Date quoEffectDate) {
    this.quoEffectDate = quoEffectDate;
  }

  public Date getQuoEffectDate() {
    return quoEffectDate;
  }

  public void setQuoAvganb(Integer quoAvganb) {
    this.quoAvganb = quoAvganb;
  }

  public Integer getQuoAvganb() {
    return quoAvganb;
  }

 

  public void setQuoNofmembers(Integer quoNofmembers) {
    this.quoNofmembers = quoNofmembers;
  }

  public Integer getQuoNofmembers() {
    return quoNofmembers;
  }

  public void setQuoCalctype(String quoCalctype) {
    this.quoCalctype = quoCalctype;
  }

  public String getQuoCalctype() {
    return quoCalctype;
  }

  public void setQuotationCalcType(RichSelectOneChoice quotationCalcType) {
    this.quotationCalcType = quotationCalcType;
  }

  public RichSelectOneChoice getQuotationCalcType() {
    return quotationCalcType;
  }

  public void setDepCovered(String depCovered) {
    this.depCovered = depCovered;
  }

  public String getDepCovered() {
    return depCovered;
  }

  public void setQuoSavingsRider(String quoSavingsRider) {
    this.quoSavingsRider = quoSavingsRider;
  }

  public String getQuoSavingsRider() {
    return quoSavingsRider;
  }

  public void setSavingsRider(RichSelectOneChoice savingsRider) {
    this.savingsRider = savingsRider;
  }

  public RichSelectOneChoice getSavingsRider() {
    return savingsRider;
  }

  public void setCalcType(RichSelectOneChoice calcType) {
    this.calcType = calcType;
  }

  public RichSelectOneChoice getCalcType() {
    return calcType;
  }

  public void setQuotType(RichSelectOneChoice quotType) {
    this.quotType = quotType;
  }

  public RichSelectOneChoice getQuotType() {
    return quotType;
  }

  public void setQuotDurationType(RichSelectOneChoice quotDurationType) {
    this.quotDurationType = quotDurationType;
  }

  public RichSelectOneChoice getQuotDurationType() {
    return quotDurationType;
  }

  public void setFreqOfPayment(RichSelectOneChoice freqOfPayment) {
    this.freqOfPayment = freqOfPayment;
  }

  public RichSelectOneChoice getFreqOfPayment() {
    return freqOfPayment;
  }

  public void setQuoFclAmt(Double quoFclAmt) {
    this.quoFclAmt = quoFclAmt;
  }

  public Double getQuoFclAmt() {
    return quoFclAmt;
  }

  public void setQuoCoverTo(Date quoCoverTo) {
    this.quoCoverTo = quoCoverTo;
  }

  public Date getQuoCoverTo() {
    return quoCoverTo;
  }

  public void setQuoOverrideFcl(Double quoOverrideFcl) {
    this.quoOverrideFcl = quoOverrideFcl;
  }

  public Double getQuoOverrideFcl() {
    return quoOverrideFcl;
  }

  public void setQuoGrpLifeRider(RichSelectOneChoice quoGrpLifeRider) {
    this.quoGrpLifeRider = quoGrpLifeRider;
  }

  public RichSelectOneChoice getQuoGrpLifeRider() {
    return quoGrpLifeRider;
  }

  public void setQuoPensionType(RichSelectOneChoice quoPensionType) {
    this.quoPensionType = quoPensionType;
  }

  public RichSelectOneChoice getQuoPensionType() {
    return quoPensionType;
  }
}
