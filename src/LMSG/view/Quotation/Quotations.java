package LMSG.view.Quotation;

import java.math.BigDecimal;
import java.util.Date;

public class Quotations
{
  private boolean selected;
  private String client;
  private BigDecimal quoCode;
  private String quoNo;
  private BigDecimal quoRevNo;
  private String agnshtDesc;
  private String agnName;
  private String quoType;
  private String QUO_SAVINGS_RIDER;
  private String QUO_GRP_LIFE_RIDER;  
  private String prod_sht_desc;
  private String prod_display;
  private String branch;
  private String UWYear;
  private String Occupation;
  private String Hazard;
  private String Status;
  private Date EffectDate;
  private String FreqofPay;
  private BigDecimal PROP_CODE;
  private BigDecimal AGN_CODE;
  private String freq_of_payment_disp;
  private String lca_categ_desc;
  private BigDecimal QCVT_TOT_MEMBER_EARNINGS;
  private BigDecimal QGSUB_CODE;
  private BigDecimal QGSUB_GSUB_CODE;
  private String GSUB_DESC;
  private String QGSUB_SHT_DESC;
  private String QGSUB_DESC;
  private BigDecimal QMEMS_CODE;
  private String QUO_UMBRELLA;
  private BigDecimal CTL_FEE_AMOUNT;
  private BigDecimal CTL_AV_STUDENTS;
  private BigDecimal QCVT_TOT_ORIG_LOAN_AMT;
  private String QCVT_DISC;
  private String QCVT_AGG_PLAN;
  private BigDecimal QCVT_DISC_RATE;
  private BigDecimal QCVT_DISC_DIV_FACT;
  private BigDecimal lca_pmas_code;
  private String pmas_sht_desc;
  private String QUO_PAY_METHOD;
  private Date QUO_COVER_TO_DATE;
  private String CVT_MAIN_COVER;
  private BigDecimal QCVT_MAIN_SA_PERC;
  private String QCVT_MAIN_COVER;
  private String MAIN_COVER_DESC;
  private String QCOIN_FOLLOWER_LEADER;
  private String FOLLOWER_LEADER;
  private BigDecimal QDL_DTY_CODE;
  private BigDecimal QDL_QCVT_CODE;
  private BigDecimal QCOIN_PREMIUM;
  private BigDecimal QCOIN_SRVCE_FEE;
  private BigDecimal QCVT_LOANAMT_PER_MEM;
  private BigDecimal QCVT_LOAN_RPYMT_PRD;
  private BigDecimal QCVT_LOANINT_PER_MEM;
  private BigDecimal QCVT_SAVINGS_PER_MEM;
  private BigDecimal qcvt_pmas_code;
  private String qcvt_pmas_sht_desc;
  private BigDecimal qcvt_rate_div_fact;
  private String qcvt_use_cvr_rate;
  private String CoverRateDesc;
  private BigDecimal QCVT_AV_CVR_PER_MEMBER;
  private String quocvtShtDesc;
  private String cover_display;
  private BigDecimal quoQcvtSa;
  private BigDecimal quoButChargePrem;
  private BigDecimal QCVT_PREMIUM;
  private String quoButChargePrem2;
  private String quoDependents;
  private Integer quoMembers;
  private BigDecimal discLoadRate;
  private BigDecimal QCVT_CODE;
  private BigDecimal QCVT_CVT_CODE;
  private Integer QCVT_DISC_LOAD_DIV_FACT;
  private Double quoQcvtRate;
  private Double quoAvganb;
  private Date quoQCVTwetDate;
  private Integer quoQcvtAvgprd;
  private Double quoSaPerMember;
  private String quoUseUnitRate;
  private String QCVT_LOAD_DISC;
  private Double quoUnitRate;
  private BigDecimal QCVT_DTY_CODE;
  private String QCVT_DTY_DESCRIPTION;
  private String QCVT_AVG_EARN_PER_MEM;
  private BigDecimal QCVT_LIMIT;
  
  //Quotation Taxes
  private BigDecimal qtax_code;
  private String qtax_rate;
  private BigDecimal qtax_tax_amt;
  private String tt_desc;
  private String qtax_rate_desc;
  private String QTAX_RATE_TYPE;
  private String ptx_appl_level;
  private String cvt_desc;
  private String tax_plan;
  private BigDecimal taxPremium;
  private BigDecimal taxSa;
  private BigDecimal totaPremium;
  
  
  private String catShtDesc;
  private String catDesc;
  private String catPeriod;
  private BigDecimal lcaCode;
  private BigDecimal SCH_CODE;
  private BigDecimal QDL_CODE;
  private BigDecimal QDL_QUO_CODE;
  private BigDecimal QDL_MAX_TYPE_ALLOWED;
  private BigDecimal QDL_LIMIT_AMT;
  private String DTY_DESCRIPTION;
  private String CoverDescription;
  private String LCA_CATEG_DESC;
  private String quotProvshtDesc;
  private String quotProvDesc;
  private String quotProvEditable;
  private BigDecimal qpprCode;
  private BigDecimal QDL_MIN_AMT;
  private BigDecimal QCOIN_CODE;
  private BigDecimal QCOIN_QUO_CODE;
  private BigDecimal QCOIN_AGN_CODE;
  private String coinsurer_display;
  private String QCOIN_SHARE_PCT;
  private String QCOIN_ADMIN_FEE;
  private String QCOIN_LEAD_FOLLOW;
  private String QCOIN_COIN_LEADER_SHARE;
  private String quoMemNo;
  private String quoMemName;
  private String quoDepMemType;
  private Integer quoMemAnb;
  private String quoJointMem;
  private String quoOccupation;
  private String QMEM_LOADING_TYPE;
  private BigDecimal QMEM_DTY_CODE;
  private BigDecimal QMEM_MEM_CODE;
  private BigDecimal QMEM_CODE;
  private BigDecimal QMEM_HEIGHT;
  private BigDecimal QMEM_WEIGHT;
  private BigDecimal QMEM_WEIGHT_LOADING;
  private BigDecimal QMEM_SYSTOLIC_PR;
  private BigDecimal QMEM_DIASTOLIC_PR;
  private BigDecimal QMEM_BPRESS_LOADING;
  private BigDecimal QMEM_LOADING_RATE;
  private BigDecimal QMEM_LOADING_DIV_FACT;
  private BigDecimal QMEM_TOT_SA;
  private BigDecimal qua_code;
  private BigDecimal qua_agn_code;
  private String qua_agn_asgn;
  private String qua_authorized;
  private String qua_agn_name;
  private Integer qua_agn_share;
  private String qua_agn_leader_follower;
  private BigDecimal QEXC_CODE;
  private BigDecimal QEXC_POL_QUOT_CODE;
  private String QEXC_AUTHORISED;
  private String QEXC_DESC;
  private BigDecimal ENQ_quo_code;
  private String ENQ_quo_no;
  private String ENQ_CLIENT;
  private String ENQ_brn_name;
  private String ENQ_agn_name;
  private Date ENQ_DATE;
  private String ENQ_STATUS;
  private String QCVT_STAFF_DESC;
  private String QCVT_MULT_EARNINGS_PRD;
  private String QCVT_FCL_AMT;
  private String QCVT_OVERRIDE_FCL_AMT;
  private BigDecimal qcvt_load_age_fact;
  private BigDecimal quo_unit_rate;
  
  private BigDecimal QUO_LOSS_RATIO;
  private BigDecimal QMEM_BMI_RATE;
  //quotations Remarks:
  private BigDecimal qrmCode;
  private String qrmRemarks,qrmRemarksType,qrmRemarksBy,qrmRemarksDesc;
  private Date qrmRemarksDate;
  private String memSurname,memOtherNames,memSex;
  private Date memDOB;
  
  //Quotation FCL
  
  private BigDecimal QCVT_CODEFCL;
  private BigDecimal QCVT_CVT_CODEFCL;
  private String QCVT_STAFF_DESCFCL;
  private String QCVT_FCL_AMTFCL;
  private String QCVT_OVERRIDE_FCL_AMTFCL;
  private BigDecimal QCVT_LIMITFCL;
  private String QCVT_AGG_PLANFCL;
  //SBU and Location
  private BigDecimal SBU_CODE;
  private BigDecimal SPOKE_CODE;
  private String SPOKE;
  private BigDecimal COVERAGE_AREA_CODE;
  private String COVERAGE_AREA;
  private BigDecimal LOCATION_CODE;
  private String LOCATION;
  private String ORGANIZATION;
  
  private BigDecimal DDP_CODE;
  private String DDP_NUMBER, DDP_TRANS_TYPE;
    
  //holds the number of agents assigned to a quotation
  private Integer nofAgents;
  private String qcvtPctInbuilt,qcvtAccelerator;

  public void setClient(String client)
  {
    this.client = client;
  }

  public String getClient() {
    return this.client;
  }

  public void setQuoCode(BigDecimal quoCode) {
    this.quoCode = quoCode;
  }

  public BigDecimal getQuoCode() {
    return this.quoCode;
  }

  public void setQuoNo(String quoNo) {
    this.quoNo = quoNo;
  }

  public String getQuoNo() {
    return this.quoNo;
  }

  public void setQuoRevNo(BigDecimal quoRevNo) {
    this.quoRevNo = quoRevNo;
  }

  public BigDecimal getQuoRevNo() {
    return this.quoRevNo;
  }

  public void setAgnshtDesc(String agnshtDesc) {
    this.agnshtDesc = agnshtDesc;
  }

  public String getAgnshtDesc() {
    return this.agnshtDesc;
  }

  public void setAgnName(String agnName) {
    this.agnName = agnName;
  }

  public String getAgnName() {
    return this.agnName;
  }

  public void setQuoType(String quoType) {
    this.quoType = quoType;
  }

  public String getQuoType() {
    return this.quoType;
  }

  public void setQUO_SAVINGS_RIDER(String QUO_SAVINGS_RIDER) {
    this.QUO_SAVINGS_RIDER = QUO_SAVINGS_RIDER;
  }

  public String getQUO_SAVINGS_RIDER() {
    return this.QUO_SAVINGS_RIDER;
  }

  public void setQUO_GRP_LIFE_RIDER(String QUO_GRP_LIFE_RIDER) {
    this.QUO_GRP_LIFE_RIDER = QUO_GRP_LIFE_RIDER;
  }

  public String getQUO_GRP_LIFE_RIDER() {
    return this.QUO_GRP_LIFE_RIDER;
  }

  public void setQuocvtShtDesc(String quocvtShtDesc) {
    this.quocvtShtDesc = quocvtShtDesc;
  }

  public String getQuocvtShtDesc() {
    return this.quocvtShtDesc;
  }

  public void setCover_display(String cover_display) {
    this.cover_display = cover_display;
  }

  public String getCover_display() {
    return this.cover_display;
  }

  public void setQuoQcvtSa(BigDecimal quoQcvtSa) {
    this.quoQcvtSa = quoQcvtSa;
  }

  public BigDecimal getQuoQcvtSa() {
    return this.quoQcvtSa;
  }

  public void setQuoButChargePrem(BigDecimal quoButChargePrem) {
    this.quoButChargePrem = quoButChargePrem;
  }

  public BigDecimal getQuoButChargePrem() {
    return this.quoButChargePrem;
  }

  public void setQCVT_PREMIUM(BigDecimal QCVT_PREMIUM) {
    this.QCVT_PREMIUM = QCVT_PREMIUM;
  }

  public BigDecimal getQCVT_PREMIUM() {
    return this.QCVT_PREMIUM;
  }

  public void setQuoButChargePrem2(String quoButChargePrem2) {
    this.quoButChargePrem2 = quoButChargePrem2;
  }

  public String getQuoButChargePrem2() {
    return this.quoButChargePrem2;
  }

  public void setQuoDependents(String quoDependents) {
    this.quoDependents = quoDependents;
  }

  public String getQuoDependents() {
    return this.quoDependents;
  }

  public void setQuoMembers(Integer quoMembers) {
    this.quoMembers = quoMembers;
  }

  public Integer getQuoMembers() {
    return this.quoMembers;
  }

  public void setQCVT_CODE(BigDecimal QCVT_CODE) {
    this.QCVT_CODE = QCVT_CODE;
  }

  public BigDecimal getQCVT_CODE() {
    return this.QCVT_CODE;
  }

  public void setQCVT_CVT_CODE(BigDecimal QCVT_CVT_CODE) {
    this.QCVT_CVT_CODE = QCVT_CVT_CODE;
  }

  public BigDecimal getQCVT_CVT_CODE() {
    return this.QCVT_CVT_CODE;
  }

  public void setDiscLoadRate(BigDecimal discLoadRate) {
    this.discLoadRate = discLoadRate;
  }

  public BigDecimal getDiscLoadRate() {
    return this.discLoadRate;
  }

  public void setQCVT_DISC_LOAD_DIV_FACT(Integer QCVT_DISC_LOAD_DIV_FACT) {
    this.QCVT_DISC_LOAD_DIV_FACT = QCVT_DISC_LOAD_DIV_FACT;
  }

  public Integer getQCVT_DISC_LOAD_DIV_FACT() {
    return this.QCVT_DISC_LOAD_DIV_FACT;
  }

  public void setQuoQcvtRate(Double quoQcvtRate) {
    this.quoQcvtRate = quoQcvtRate;
  }

  public Double getQuoQcvtRate() {
    return this.quoQcvtRate;
  }

  public void setQuoAvganb(Double quoAvganb) {
    this.quoAvganb = quoAvganb;
  }

  public Double getQuoAvganb() {
    return this.quoAvganb;
  }

  public void setQuoQCVTwetDate(Date quoQCVTwetDate) {
    this.quoQCVTwetDate = quoQCVTwetDate;
  }

  public Date getQuoQCVTwetDate() {
    return this.quoQCVTwetDate;
  }

  public void setQuoQcvtAvgprd(Integer quoQcvtAvgprd) {
    this.quoQcvtAvgprd = quoQcvtAvgprd;
  }

  public Integer getQuoQcvtAvgprd() {
    return this.quoQcvtAvgprd;
  }

  public void setQuoSaPerMember(Double quoSaPerMember) {
    this.quoSaPerMember = quoSaPerMember;
  }

  public Double getQuoSaPerMember() {
    return this.quoSaPerMember;
  }

  public void setQuoUseUnitRate(String quoUseUnitRate) {
    this.quoUseUnitRate = quoUseUnitRate;
  }

  public String getQuoUseUnitRate() {
    return this.quoUseUnitRate;
  }

  public void setQCVT_LOAD_DISC(String QCVT_LOAD_DISC) {
    this.QCVT_LOAD_DISC = QCVT_LOAD_DISC;
  }

  public String getQCVT_LOAD_DISC() {
    return this.QCVT_LOAD_DISC;
  }

  public void setQuoUnitRate(Double quoUnitRate) {
    this.quoUnitRate = quoUnitRate;
  }

  public Double getQuoUnitRate() {
    return this.quoUnitRate;
  }

  public void setQtax_code(BigDecimal qtax_code) {
    this.qtax_code = qtax_code;
  }

  public BigDecimal getQtax_code() {
    return this.qtax_code;
  }

  public void setQtax_rate(String qtax_rate) {
    this.qtax_rate = qtax_rate;
  }

  public String getQtax_rate() {
    return this.qtax_rate;
  }

  public void setQtax_tax_amt(BigDecimal qtax_tax_amt) {
    this.qtax_tax_amt = qtax_tax_amt;
  }

  public BigDecimal getQtax_tax_amt() {
    return this.qtax_tax_amt;
  }

  public void setTt_desc(String tt_desc) {
    this.tt_desc = tt_desc;
  }

  public String getTt_desc() {
    return this.tt_desc;
  }

  public void setQtax_rate_desc(String qtax_rate_desc) {
    this.qtax_rate_desc = qtax_rate_desc;
  }

  public String getQtax_rate_desc() {
    return this.qtax_rate_desc;
  }

  public void setCatShtDesc(String catShtDesc) {
    this.catShtDesc = catShtDesc;
  }

  public String getCatShtDesc() {
    return this.catShtDesc;
  }

  public void setCatDesc(String catDesc) {
    this.catDesc = catDesc;
  }

  public String getCatDesc() {
    return this.catDesc;
  }

  public void setCatPeriod(String catPeriod) {
    this.catPeriod = catPeriod;
  }

  public String getCatPeriod() {
    return this.catPeriod;
  }

  public void setLcaCode(BigDecimal lcaCode) {
    this.lcaCode = lcaCode;
  }

  public BigDecimal getLcaCode() {
    return this.lcaCode;
  }

  public void setQDL_CODE(BigDecimal QDL_CODE) {
    this.QDL_CODE = QDL_CODE;
  }

  public BigDecimal getQDL_CODE() {
    return this.QDL_CODE;
  }

  public void setQDL_QUO_CODE(BigDecimal QDL_QUO_CODE) {
    this.QDL_QUO_CODE = QDL_QUO_CODE;
  }

  public BigDecimal getQDL_QUO_CODE() {
    return this.QDL_QUO_CODE;
  }

  public void setQDL_MAX_TYPE_ALLOWED(BigDecimal QDL_MAX_TYPE_ALLOWED) {
    this.QDL_MAX_TYPE_ALLOWED = QDL_MAX_TYPE_ALLOWED;
  }

  public BigDecimal getQDL_MAX_TYPE_ALLOWED() {
    return this.QDL_MAX_TYPE_ALLOWED;
  }

  public void setQDL_LIMIT_AMT(BigDecimal QDL_LIMIT_AMT) {
    this.QDL_LIMIT_AMT = QDL_LIMIT_AMT;
  }

  public BigDecimal getQDL_LIMIT_AMT() {
    return this.QDL_LIMIT_AMT;
  }

  public void setDTY_DESCRIPTION(String DTY_DESCRIPTION) {
    this.DTY_DESCRIPTION = DTY_DESCRIPTION;
  }

  public String getDTY_DESCRIPTION() {
    return this.DTY_DESCRIPTION;
  }

  public void setQuotProvshtDesc(String quotProvshtDesc) {
    this.quotProvshtDesc = quotProvshtDesc;
  }

  public String getQuotProvshtDesc() {
    return this.quotProvshtDesc;
  }

  public void setQuotProvDesc(String quotProvDesc) {
    this.quotProvDesc = quotProvDesc;
  }

  public String getQuotProvDesc() {
    return this.quotProvDesc;
  }

  public void setQuotProvEditable(String quotProvEditable) {
    this.quotProvEditable = quotProvEditable;
  }

  public String getQuotProvEditable() {
    return this.quotProvEditable;
  }

  public void setQpprCode(BigDecimal qpprCode) {
    this.qpprCode = qpprCode;
  }

  public BigDecimal getQpprCode() {
    return this.qpprCode;
  }

  public void setQuoMemNo(String quoMemNo) {
    this.quoMemNo = quoMemNo;
  }

  public String getQuoMemNo() {
    return this.quoMemNo;
  }

  public void setQuoMemName(String quoMemName) {
    this.quoMemName = quoMemName;
  }

  public String getQuoMemName() {
    return this.quoMemName;
  }

  public void setQuoDepMemType(String quoDepMemType) {
    this.quoDepMemType = quoDepMemType;
  }

  public String getQuoDepMemType() {
    return this.quoDepMemType;
  }

  public void setQuoMemAnb(Integer quoMemAnb) {
    this.quoMemAnb = quoMemAnb;
  }

  public Integer getQuoMemAnb() {
    return this.quoMemAnb;
  }

  public void setQuoJointMem(String quoJointMem) {
    this.quoJointMem = quoJointMem;
  }

  public String getQuoJointMem() {
    return this.quoJointMem;
  }

  public void setQuoOccupation(String quoOccupation) {
    this.quoOccupation = quoOccupation;
  }

  public String getQuoOccupation() {
    return this.quoOccupation;
  }

  public void setQMEM_LOADING_TYPE(String QMEM_LOADING_TYPE) {
    this.QMEM_LOADING_TYPE = QMEM_LOADING_TYPE;
  }

  public String getQMEM_LOADING_TYPE() {
    return this.QMEM_LOADING_TYPE;
  }

  public void setQMEM_DTY_CODE(BigDecimal QMEM_DTY_CODE) {
    this.QMEM_DTY_CODE = QMEM_DTY_CODE;
  }

  public BigDecimal getQMEM_DTY_CODE() {
    return this.QMEM_DTY_CODE;
  }

  public void setQMEM_MEM_CODE(BigDecimal QMEM_MEM_CODE) {
    this.QMEM_MEM_CODE = QMEM_MEM_CODE;
  }

  public BigDecimal getQMEM_MEM_CODE() {
    return this.QMEM_MEM_CODE;
  }

  public void setQMEM_CODE(BigDecimal QMEM_CODE) {
    this.QMEM_CODE = QMEM_CODE;
  }

  public BigDecimal getQMEM_CODE() {
    return this.QMEM_CODE;
  }

  public void setQMEM_HEIGHT(BigDecimal QMEM_HEIGHT) {
    this.QMEM_HEIGHT = QMEM_HEIGHT;
  }

  public BigDecimal getQMEM_HEIGHT() {
    return this.QMEM_HEIGHT;
  }

  public void setQMEM_WEIGHT(BigDecimal QMEM_WEIGHT) {
    this.QMEM_WEIGHT = QMEM_WEIGHT;
  }

  public BigDecimal getQMEM_WEIGHT() {
    return this.QMEM_WEIGHT;
  }

  public void setQMEM_WEIGHT_LOADING(BigDecimal QMEM_WEIGHT_LOADING) {
    this.QMEM_WEIGHT_LOADING = QMEM_WEIGHT_LOADING;
  }

  public BigDecimal getQMEM_WEIGHT_LOADING() {
    return this.QMEM_WEIGHT_LOADING;
  }

  public void setQMEM_SYSTOLIC_PR(BigDecimal QMEM_SYSTOLIC_PR) {
    this.QMEM_SYSTOLIC_PR = QMEM_SYSTOLIC_PR;
  }

  public BigDecimal getQMEM_SYSTOLIC_PR() {
    return this.QMEM_SYSTOLIC_PR;
  }

  public void setQMEM_DIASTOLIC_PR(BigDecimal QMEM_DIASTOLIC_PR) {
    this.QMEM_DIASTOLIC_PR = QMEM_DIASTOLIC_PR;
  }

  public BigDecimal getQMEM_DIASTOLIC_PR() {
    return this.QMEM_DIASTOLIC_PR;
  }

  public void setQMEM_BPRESS_LOADING(BigDecimal QMEM_BPRESS_LOADING) {
    this.QMEM_BPRESS_LOADING = QMEM_BPRESS_LOADING;
  }

  public BigDecimal getQMEM_BPRESS_LOADING() {
    return this.QMEM_BPRESS_LOADING;
  }

  public void setQMEM_LOADING_RATE(BigDecimal QMEM_LOADING_RATE) {
    this.QMEM_LOADING_RATE = QMEM_LOADING_RATE;
  }

  public BigDecimal getQMEM_LOADING_RATE() {
    return this.QMEM_LOADING_RATE;
  }

  public void setQMEM_LOADING_DIV_FACT(BigDecimal QMEM_LOADING_DIV_FACT) {
    this.QMEM_LOADING_DIV_FACT = QMEM_LOADING_DIV_FACT;
  }

  public BigDecimal getQMEM_LOADING_DIV_FACT() {
    return this.QMEM_LOADING_DIV_FACT;
  }

  public void setQMEM_TOT_SA(BigDecimal QMEM_TOT_SA) {
    this.QMEM_TOT_SA = QMEM_TOT_SA;
  }

  public BigDecimal getQMEM_TOT_SA() {
    return this.QMEM_TOT_SA;
  }

  public void setCoverDescription(String CoverDescription) {
    this.CoverDescription = CoverDescription;
  }

  public String getCoverDescription() {
    return this.CoverDescription;
  }

  public void setProd_sht_desc(String prod_sht_desc) {
    this.prod_sht_desc = prod_sht_desc;
  }

  public String getProd_sht_desc() {
    return this.prod_sht_desc;
  }

  public void setProd_display(String prod_display) {
    this.prod_display = prod_display;
  }

  public String getProd_display() {
    return this.prod_display;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public String getBranch() {
    return this.branch;
  }

  public void setUWYear(String UWYear) {
    this.UWYear = UWYear;
  }

  public String getUWYear() {
    return this.UWYear;
  }

  public void setOccupation(String Occupation) {
    this.Occupation = Occupation;
  }

  public String getOccupation() {
    return this.Occupation;
  }

  public void setHazard(String Hazard) {
    this.Hazard = Hazard;
  }

  public String getHazard() {
    return this.Hazard;
  }

  public void setStatus(String Status) {
    this.Status = Status;
  }

  public String getStatus() {
    return this.Status;
  }

  public void setEffectDate(Date EffectDate) {
    this.EffectDate = EffectDate;
  }

  public Date getEffectDate() {
    return this.EffectDate;
  }

  public void setFreqofPay(String FreqofPay) {
    this.FreqofPay = FreqofPay;
  }

  public String getFreqofPay() {
    return this.FreqofPay;
  }

  public void setQCOIN_CODE(BigDecimal QCOIN_CODE) {
    this.QCOIN_CODE = QCOIN_CODE;
  }

  public BigDecimal getQCOIN_CODE() {
    return this.QCOIN_CODE;
  }

  public void setQCOIN_QUO_CODE(BigDecimal QCOIN_QUO_CODE) {
    this.QCOIN_QUO_CODE = QCOIN_QUO_CODE;
  }

  public BigDecimal getQCOIN_QUO_CODE() {
    return this.QCOIN_QUO_CODE;
  }

  public void setQCOIN_AGN_CODE(BigDecimal QCOIN_AGN_CODE) {
    this.QCOIN_AGN_CODE = QCOIN_AGN_CODE;
  }

  public BigDecimal getQCOIN_AGN_CODE() {
    return this.QCOIN_AGN_CODE;
  }

  public void setCoinsurer_display(String coinsurer_display) {
    this.coinsurer_display = coinsurer_display;
  }

  public String getCoinsurer_display() {
    return this.coinsurer_display;
  }

  public void setQCOIN_SHARE_PCT(String QCOIN_SHARE_PCT) {
    this.QCOIN_SHARE_PCT = QCOIN_SHARE_PCT;
  }

  public String getQCOIN_SHARE_PCT() {
    return this.QCOIN_SHARE_PCT;
  }

  public void setQCOIN_ADMIN_FEE(String QCOIN_ADMIN_FEE) {
    this.QCOIN_ADMIN_FEE = QCOIN_ADMIN_FEE;
  }

  public String getQCOIN_ADMIN_FEE() {
    return this.QCOIN_ADMIN_FEE;
  }

  public void setQCOIN_LEAD_FOLLOW(String QCOIN_LEAD_FOLLOW) {
    this.QCOIN_LEAD_FOLLOW = QCOIN_LEAD_FOLLOW;
  }

  public String getQCOIN_LEAD_FOLLOW() {
    return this.QCOIN_LEAD_FOLLOW;
  }

  public void setQCOIN_COIN_LEADER_SHARE(String QCOIN_COIN_LEADER_SHARE) {
    this.QCOIN_COIN_LEADER_SHARE = QCOIN_COIN_LEADER_SHARE;
  }

  public String getQCOIN_COIN_LEADER_SHARE() {
    return this.QCOIN_COIN_LEADER_SHARE;
  }

  public void setQTAX_RATE_TYPE(String QTAX_RATE_TYPE) {
    this.QTAX_RATE_TYPE = QTAX_RATE_TYPE;
  }

  public String getQTAX_RATE_TYPE() {
    return this.QTAX_RATE_TYPE;
  }

  public void setPROP_CODE(BigDecimal PROP_CODE) {
    this.PROP_CODE = PROP_CODE;
  }

  public BigDecimal getPROP_CODE() {
    return this.PROP_CODE;
  }

  public void setAGN_CODE(BigDecimal AGN_CODE) {
    this.AGN_CODE = AGN_CODE;
  }

  public BigDecimal getAGN_CODE() {
    return this.AGN_CODE;
  }

  public void setQua_code(BigDecimal qua_code) {
    this.qua_code = qua_code;
  }

  public BigDecimal getQua_code() {
    return this.qua_code;
  }

  public void setQua_agn_code(BigDecimal qua_agn_code) {
    this.qua_agn_code = qua_agn_code;
  }

  public BigDecimal getQua_agn_code() {
    return this.qua_agn_code;
  }

  public void setQua_agn_asgn(String qua_agn_asgn) {
    this.qua_agn_asgn = qua_agn_asgn;
  }

  public String getQua_agn_asgn() {
    return this.qua_agn_asgn;
  }

  public void setQua_authorized(String qua_authorized) {
    this.qua_authorized = qua_authorized;
  }

  public String getQua_authorized() {
    return this.qua_authorized;
  }

  public void setFreq_of_payment_disp(String freq_of_payment_disp) {
    this.freq_of_payment_disp = freq_of_payment_disp;
  }

  public String getFreq_of_payment_disp() {
    return this.freq_of_payment_disp;
  }

  public void setQEXC_CODE(BigDecimal QEXC_CODE) {
    this.QEXC_CODE = QEXC_CODE;
  }

  public BigDecimal getQEXC_CODE() {
    return this.QEXC_CODE;
  }

  public void setQEXC_POL_QUOT_CODE(BigDecimal QEXC_POL_QUOT_CODE) {
    this.QEXC_POL_QUOT_CODE = QEXC_POL_QUOT_CODE;
  }

  public BigDecimal getQEXC_POL_QUOT_CODE() {
    return this.QEXC_POL_QUOT_CODE;
  }

  public void setQEXC_AUTHORISED(String QEXC_AUTHORISED) {
    this.QEXC_AUTHORISED = QEXC_AUTHORISED;
  }

  public String getQEXC_AUTHORISED() {
    return this.QEXC_AUTHORISED;
  }

  public void setQEXC_DESC(String QEXC_DESC) {
    this.QEXC_DESC = QEXC_DESC;
  }

  public String getQEXC_DESC() {
    return this.QEXC_DESC;
  }

  public void setENQ_quo_code(BigDecimal ENQ_quo_code) {
    this.ENQ_quo_code = ENQ_quo_code;
  }

  public BigDecimal getENQ_quo_code() {
    return this.ENQ_quo_code;
  }

  public void setENQ_quo_no(String ENQ_quo_no) {
    this.ENQ_quo_no = ENQ_quo_no;
  }

  public String getENQ_quo_no() {
    return this.ENQ_quo_no;
  }

  public void setENQ_CLIENT(String ENQ_CLIENT) {
    this.ENQ_CLIENT = ENQ_CLIENT;
  }

  public String getENQ_CLIENT() {
    return this.ENQ_CLIENT;
  }

  public void setENQ_brn_name(String ENQ_brn_name) {
    this.ENQ_brn_name = ENQ_brn_name;
  }

  public String getENQ_brn_name() {
    return this.ENQ_brn_name;
  }

  public void setENQ_agn_name(String ENQ_agn_name) {
    this.ENQ_agn_name = ENQ_agn_name;
  }

  public String getENQ_agn_name() {
    return this.ENQ_agn_name;
  }

  public void setENQ_DATE(Date ENQ_DATE) {
    this.ENQ_DATE = ENQ_DATE;
  }

  public Date getENQ_DATE() {
    return this.ENQ_DATE;
  }

  public void setENQ_STATUS(String ENQ_STATUS) {
    this.ENQ_STATUS = ENQ_STATUS;
  }

  public String getENQ_STATUS() {
    return this.ENQ_STATUS;
  }

  public void setQua_agn_name(String qua_agn_name) {
    this.qua_agn_name = qua_agn_name;
  }

  public String getQua_agn_name() {
    return this.qua_agn_name;
  }

  public void setQCVT_DTY_CODE(BigDecimal QCVT_DTY_CODE) {
    this.QCVT_DTY_CODE = QCVT_DTY_CODE;
  }

  public BigDecimal getQCVT_DTY_CODE() {
    return this.QCVT_DTY_CODE;
  }

  public void setQCVT_DTY_DESCRIPTION(String QCVT_DTY_DESCRIPTION) {
    this.QCVT_DTY_DESCRIPTION = QCVT_DTY_DESCRIPTION;
  }

  public String getQCVT_DTY_DESCRIPTION() {
    return this.QCVT_DTY_DESCRIPTION;
  }

  public void setQCVT_AVG_EARN_PER_MEM(String QCVT_AVG_EARN_PER_MEM) {
    this.QCVT_AVG_EARN_PER_MEM = QCVT_AVG_EARN_PER_MEM;
  }

  public String getQCVT_AVG_EARN_PER_MEM() {
    return this.QCVT_AVG_EARN_PER_MEM;
  }

  public void setQCVT_STAFF_DESC(String QCVT_STAFF_DESC) {
    this.QCVT_STAFF_DESC = QCVT_STAFF_DESC;
  }

  public String getQCVT_STAFF_DESC() {
    return this.QCVT_STAFF_DESC;
  }

  public void setQCVT_MULT_EARNINGS_PRD(String QCVT_MULT_EARNINGS_PRD) {
    this.QCVT_MULT_EARNINGS_PRD = QCVT_MULT_EARNINGS_PRD;
  }

  public String getQCVT_MULT_EARNINGS_PRD() {
    return this.QCVT_MULT_EARNINGS_PRD;
  }

  public void setLCA_CATEG_DESC(String LCA_CATEG_DESC) {
    this.LCA_CATEG_DESC = LCA_CATEG_DESC;
  }

  public String getLCA_CATEG_DESC() {
    return this.LCA_CATEG_DESC;
  }

  public void setQCVT_FCL_AMT(String QCVT_FCL_AMT) {
    this.QCVT_FCL_AMT = QCVT_FCL_AMT;
  }

  public String getQCVT_FCL_AMT() {
    return this.QCVT_FCL_AMT;
  }

  public void setQCVT_OVERRIDE_FCL_AMT(String QCVT_OVERRIDE_FCL_AMT) {
    this.QCVT_OVERRIDE_FCL_AMT = QCVT_OVERRIDE_FCL_AMT;
  }

  public String getQCVT_OVERRIDE_FCL_AMT() {
    return this.QCVT_OVERRIDE_FCL_AMT;
  }

  public void setSCH_CODE(BigDecimal SCH_CODE) {
    this.SCH_CODE = SCH_CODE;
  }

  public BigDecimal getSCH_CODE() {
    return this.SCH_CODE;
  }

  public void setCVT_MAIN_COVER(String CVT_MAIN_COVER) {
    this.CVT_MAIN_COVER = CVT_MAIN_COVER;
  }

  public String getCVT_MAIN_COVER() {
    return this.CVT_MAIN_COVER;
  }

  public void setQCVT_MAIN_SA_PERC(BigDecimal QCVT_MAIN_SA_PERC) {
    this.QCVT_MAIN_SA_PERC = QCVT_MAIN_SA_PERC;
  }

  public BigDecimal getQCVT_MAIN_SA_PERC() {
    return this.QCVT_MAIN_SA_PERC;
  }

  public void setQCVT_MAIN_COVER(String QCVT_MAIN_COVER) {
    this.QCVT_MAIN_COVER = QCVT_MAIN_COVER;
  }

  public String getQCVT_MAIN_COVER() {
    return this.QCVT_MAIN_COVER;
  }

  public void setMAIN_COVER_DESC(String MAIN_COVER_DESC) {
    this.MAIN_COVER_DESC = MAIN_COVER_DESC;
  }

  public String getMAIN_COVER_DESC() {
    return this.MAIN_COVER_DESC;
  }

  public void setQUO_PAY_METHOD(String QUO_PAY_METHOD) {
    this.QUO_PAY_METHOD = QUO_PAY_METHOD;
  }

  public String getQUO_PAY_METHOD() {
    return this.QUO_PAY_METHOD;
  }

  public void setQUO_COVER_TO_DATE(Date QUO_COVER_TO_DATE) {
    this.QUO_COVER_TO_DATE = QUO_COVER_TO_DATE;
  }

  public Date getQUO_COVER_TO_DATE() {
    return this.QUO_COVER_TO_DATE;
  }

  public void setQDL_DTY_CODE(BigDecimal QDL_DTY_CODE) {
    this.QDL_DTY_CODE = QDL_DTY_CODE;
  }

  public BigDecimal getQDL_DTY_CODE() {
    return this.QDL_DTY_CODE;
  }

  public void setQDL_QCVT_CODE(BigDecimal QDL_QCVT_CODE) {
    this.QDL_QCVT_CODE = QDL_QCVT_CODE;
  }

  public BigDecimal getQDL_QCVT_CODE() {
    return this.QDL_QCVT_CODE;
  }

  public void setQCOIN_PREMIUM(BigDecimal QCOIN_PREMIUM) {
    this.QCOIN_PREMIUM = QCOIN_PREMIUM;
  }

  public BigDecimal getQCOIN_PREMIUM() {
    return this.QCOIN_PREMIUM;
  }

  public void setQCOIN_SRVCE_FEE(BigDecimal QCOIN_SRVCE_FEE) {
    this.QCOIN_SRVCE_FEE = QCOIN_SRVCE_FEE;
  }

  public BigDecimal getQCOIN_SRVCE_FEE() {
    return this.QCOIN_SRVCE_FEE;
  }

  public void setQCOIN_FOLLOWER_LEADER(String QCOIN_FOLLOWER_LEADER) {
    this.QCOIN_FOLLOWER_LEADER = QCOIN_FOLLOWER_LEADER;
  }

  public String getQCOIN_FOLLOWER_LEADER() {
    return this.QCOIN_FOLLOWER_LEADER;
  }

  public void setFOLLOWER_LEADER(String FOLLOWER_LEADER) {
    this.FOLLOWER_LEADER = FOLLOWER_LEADER;
  }

  public String getFOLLOWER_LEADER() {
    return this.FOLLOWER_LEADER;
  }

  public void setQCVT_LOANAMT_PER_MEM(BigDecimal QCVT_LOANAMT_PER_MEM) {
    this.QCVT_LOANAMT_PER_MEM = QCVT_LOANAMT_PER_MEM;
  }

  public BigDecimal getQCVT_LOANAMT_PER_MEM() {
    return this.QCVT_LOANAMT_PER_MEM;
  }

  public void setQCVT_LOAN_RPYMT_PRD(BigDecimal QCVT_LOAN_RPYMT_PRD) {
    this.QCVT_LOAN_RPYMT_PRD = QCVT_LOAN_RPYMT_PRD;
  }

  public BigDecimal getQCVT_LOAN_RPYMT_PRD() {
    return this.QCVT_LOAN_RPYMT_PRD;
  }

  public void setQCVT_LOANINT_PER_MEM(BigDecimal QCVT_LOANINT_PER_MEM) {
    this.QCVT_LOANINT_PER_MEM = QCVT_LOANINT_PER_MEM;
  }

  public BigDecimal getQCVT_LOANINT_PER_MEM() {
    return this.QCVT_LOANINT_PER_MEM;
  }

  public void setQCVT_SAVINGS_PER_MEM(BigDecimal QCVT_SAVINGS_PER_MEM) {
    this.QCVT_SAVINGS_PER_MEM = QCVT_SAVINGS_PER_MEM;
  }

  public BigDecimal getQCVT_SAVINGS_PER_MEM() {
    return this.QCVT_SAVINGS_PER_MEM;
  }

  public void setCTL_FEE_AMOUNT(BigDecimal CTL_FEE_AMOUNT) {
    this.CTL_FEE_AMOUNT = CTL_FEE_AMOUNT;
  }

  public BigDecimal getCTL_FEE_AMOUNT() {
    return this.CTL_FEE_AMOUNT;
  }

  public void setCTL_AV_STUDENTS(BigDecimal CTL_AV_STUDENTS) {
    this.CTL_AV_STUDENTS = CTL_AV_STUDENTS;
  }

  public BigDecimal getCTL_AV_STUDENTS() {
    return this.CTL_AV_STUDENTS;
  }

  public void setQCVT_DISC(String QCVT_DISC) {
    this.QCVT_DISC = QCVT_DISC;
  }

  public String getQCVT_DISC() {
    return this.QCVT_DISC;
  }

  public void setQCVT_DISC_RATE(BigDecimal QCVT_DISC_RATE) {
    this.QCVT_DISC_RATE = QCVT_DISC_RATE;
  }

  public BigDecimal getQCVT_DISC_RATE() {
    return this.QCVT_DISC_RATE;
  }

  public void setQCVT_DISC_DIV_FACT(BigDecimal QCVT_DISC_DIV_FACT) {
    this.QCVT_DISC_DIV_FACT = QCVT_DISC_DIV_FACT;
  }

  public BigDecimal getQCVT_DISC_DIV_FACT() {
    return this.QCVT_DISC_DIV_FACT;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  public boolean getSelected() {
    return this.selected;
  }

  public void setQcvt_pmas_code(BigDecimal qcvt_pmas_code) {
    this.qcvt_pmas_code = qcvt_pmas_code;
  }

  public BigDecimal getQcvt_pmas_code() {
    return this.qcvt_pmas_code;
  }

  public void setQcvt_pmas_sht_desc(String qcvt_pmas_sht_desc) {
    this.qcvt_pmas_sht_desc = qcvt_pmas_sht_desc;
  }

  public String getQcvt_pmas_sht_desc() {
    return this.qcvt_pmas_sht_desc;
  }

  public void setQcvt_rate_div_fact(BigDecimal qcvt_rate_div_fact) {
    this.qcvt_rate_div_fact = qcvt_rate_div_fact;
  }

  public BigDecimal getQcvt_rate_div_fact() {
    return this.qcvt_rate_div_fact;
  }

  public void setQcvt_use_cvr_rate(String qcvt_use_cvr_rate) {
    this.qcvt_use_cvr_rate = qcvt_use_cvr_rate;
  }

  public String getQcvt_use_cvr_rate() {
    return this.qcvt_use_cvr_rate;
  }

  public void setCoverRateDesc(String CoverRateDesc) {
    this.CoverRateDesc = CoverRateDesc;
  }

  public String getCoverRateDesc() {
    return this.CoverRateDesc;
  }

  public void setLca_pmas_code(BigDecimal lca_pmas_code) {
    this.lca_pmas_code = lca_pmas_code;
  }

  public BigDecimal getLca_pmas_code() {
    return this.lca_pmas_code;
  }

  public void setPmas_sht_desc(String pmas_sht_desc) {
    this.pmas_sht_desc = pmas_sht_desc;
  }

  public String getPmas_sht_desc() {
    return this.pmas_sht_desc;
  }

  public void setQGSUB_CODE(BigDecimal QGSUB_CODE) {
    this.QGSUB_CODE = QGSUB_CODE;
  }

  public BigDecimal getQGSUB_CODE() {
    return this.QGSUB_CODE;
  }

  public void setQGSUB_GSUB_CODE(BigDecimal QGSUB_GSUB_CODE) {
    this.QGSUB_GSUB_CODE = QGSUB_GSUB_CODE;
  }

  public BigDecimal getQGSUB_GSUB_CODE() {
    return this.QGSUB_GSUB_CODE;
  }

  public void setGSUB_DESC(String GSUB_DESC) {
    this.GSUB_DESC = GSUB_DESC;
  }

  public String getGSUB_DESC() {
    return this.GSUB_DESC;
  }

  public void setQGSUB_SHT_DESC(String QGSUB_SHT_DESC) {
    this.QGSUB_SHT_DESC = QGSUB_SHT_DESC;
  }

  public String getQGSUB_SHT_DESC() {
    return this.QGSUB_SHT_DESC;
  }

  public void setQGSUB_DESC(String QGSUB_DESC) {
    this.QGSUB_DESC = QGSUB_DESC;
  }

  public String getQGSUB_DESC() {
    return this.QGSUB_DESC;
  }

  public void setQMEMS_CODE(BigDecimal QMEMS_CODE) {
    this.QMEMS_CODE = QMEMS_CODE;
  }

  public BigDecimal getQMEMS_CODE() {
    return this.QMEMS_CODE;
  }

  public void setQUO_UMBRELLA(String QUO_UMBRELLA) {
    this.QUO_UMBRELLA = QUO_UMBRELLA;
  }

  public String getQUO_UMBRELLA() {
    return this.QUO_UMBRELLA;
  }

  public void setQDL_MIN_AMT(BigDecimal QDL_MIN_AMT) {
    this.QDL_MIN_AMT = QDL_MIN_AMT;
  }

  public BigDecimal getQDL_MIN_AMT() {
    return this.QDL_MIN_AMT;
  }

  public void setQCVT_TOT_MEMBER_EARNINGS(BigDecimal QCVT_TOT_MEMBER_EARNINGS) {
    this.QCVT_TOT_MEMBER_EARNINGS = QCVT_TOT_MEMBER_EARNINGS;
  }

  public BigDecimal getQCVT_TOT_MEMBER_EARNINGS() {
    return this.QCVT_TOT_MEMBER_EARNINGS;
  }

  public void setQua_agn_share(Integer qua_agn_share)
  {
    this.qua_agn_share = qua_agn_share;
  }

  public Integer getQua_agn_share() {
    return this.qua_agn_share;
  }

  public void setQCVT_TOT_ORIG_LOAN_AMT(BigDecimal QCVT_TOT_ORIG_LOAN_AMT)
  {
    this.QCVT_TOT_ORIG_LOAN_AMT = QCVT_TOT_ORIG_LOAN_AMT;
  }

  public BigDecimal getQCVT_TOT_ORIG_LOAN_AMT() {
    return this.QCVT_TOT_ORIG_LOAN_AMT;
  }

  public void setQCVT_AV_CVR_PER_MEMBER(BigDecimal QCVT_AV_CVR_PER_MEMBER) {
    this.QCVT_AV_CVR_PER_MEMBER = QCVT_AV_CVR_PER_MEMBER;
  }

  public BigDecimal getQCVT_AV_CVR_PER_MEMBER() {
    return this.QCVT_AV_CVR_PER_MEMBER;
  }

  public void setLca_categ_desc(String lca_categ_desc) {
    this.lca_categ_desc = lca_categ_desc;
  }

  public String getLca_categ_desc() {
    return this.lca_categ_desc;
  }

  public void setQua_agn_leader_follower(String qua_agn_leader_follower) {
    this.qua_agn_leader_follower = qua_agn_leader_follower;
  }

  public String getQua_agn_leader_follower() {
    return this.qua_agn_leader_follower;
  }

    public boolean isSelected() {
        return selected;
    }

    public String getClient1() {
        return client;
    }

    public BigDecimal getQuoCode1() {
        return quoCode;
    }

    public String getQuoNo1() {
        return quoNo;
    }

    public BigDecimal getQuoRevNo1() {
        return quoRevNo;
    }

    public String getAgnshtDesc1() {
        return agnshtDesc;
    }

    public String getAgnName1() {
        return agnName;
    }

    public String getQuoType1() {
        return quoType;
    }

    public String getQUO_SAVINGS_RIDER1() {
        return QUO_SAVINGS_RIDER;
    }

    public String getQUO_GRP_LIFE_RIDER1() {
        return QUO_GRP_LIFE_RIDER;
    }

    public String getProd_sht_desc1() {
        return prod_sht_desc;
    }

    public String getProd_display1() {
        return prod_display;
    }

    public String getBranch1() {
        return branch;
    }

    public String getUWYear1() {
        return UWYear;
    }

    public String getOccupation1() {
        return Occupation;
    }

    public String getHazard1() {
        return Hazard;
    }

    public String getStatus1() {
        return Status;
    }

    public Date getEffectDate1() {
        return EffectDate;
    }

    public String getFreqofPay1() {
        return FreqofPay;
    }

    public BigDecimal getPROP_CODE1() {
        return PROP_CODE;
    }

    public BigDecimal getAGN_CODE1() {
        return AGN_CODE;
    }

    public String getFreq_of_payment_disp1() {
        return freq_of_payment_disp;
    }

    public String getLca_categ_desc1() {
        return lca_categ_desc;
    }

    public BigDecimal getQCVT_TOT_MEMBER_EARNINGS1() {
        return QCVT_TOT_MEMBER_EARNINGS;
    }

    public BigDecimal getQGSUB_CODE1() {
        return QGSUB_CODE;
    }

    public BigDecimal getQGSUB_GSUB_CODE1() {
        return QGSUB_GSUB_CODE;
    }

    public String getGSUB_DESC1() {
        return GSUB_DESC;
    }

    public String getQGSUB_SHT_DESC1() {
        return QGSUB_SHT_DESC;
    }

    public String getQGSUB_DESC1() {
        return QGSUB_DESC;
    }

    public BigDecimal getQMEMS_CODE1() {
        return QMEMS_CODE;
    }

    public String getQUO_UMBRELLA1() {
        return QUO_UMBRELLA;
    }

    public BigDecimal getCTL_FEE_AMOUNT1() {
        return CTL_FEE_AMOUNT;
    }

    public BigDecimal getCTL_AV_STUDENTS1() {
        return CTL_AV_STUDENTS;
    }

    public BigDecimal getQCVT_TOT_ORIG_LOAN_AMT1() {
        return QCVT_TOT_ORIG_LOAN_AMT;
    }

    public String getQCVT_DISC1() {
        return QCVT_DISC;
    }

    public BigDecimal getQCVT_DISC_RATE1() {
        return QCVT_DISC_RATE;
    }

    public BigDecimal getQCVT_DISC_DIV_FACT1() {
        return QCVT_DISC_DIV_FACT;
    }

    public BigDecimal getLca_pmas_code1() {
        return lca_pmas_code;
    }

    public String getPmas_sht_desc1() {
        return pmas_sht_desc;
    }

    public String getQUO_PAY_METHOD1() {
        return QUO_PAY_METHOD;
    }

    public Date getQUO_COVER_TO_DATE1() {
        return QUO_COVER_TO_DATE;
    }

    public String getCVT_MAIN_COVER1() {
        return CVT_MAIN_COVER;
    }

    public BigDecimal getQCVT_MAIN_SA_PERC1() {
        return QCVT_MAIN_SA_PERC;
    }

    public String getQCVT_MAIN_COVER1() {
        return QCVT_MAIN_COVER;
    }

    public String getMAIN_COVER_DESC1() {
        return MAIN_COVER_DESC;
    }

    public String getQCOIN_FOLLOWER_LEADER1() {
        return QCOIN_FOLLOWER_LEADER;
    }

    public String getFOLLOWER_LEADER1() {
        return FOLLOWER_LEADER;
    }

    public BigDecimal getQDL_DTY_CODE1() {
        return QDL_DTY_CODE;
    }

    public BigDecimal getQDL_QCVT_CODE1() {
        return QDL_QCVT_CODE;
    }

    public BigDecimal getQCOIN_PREMIUM1() {
        return QCOIN_PREMIUM;
    }

    public BigDecimal getQCOIN_SRVCE_FEE1() {
        return QCOIN_SRVCE_FEE;
    }

    public BigDecimal getQCVT_LOANAMT_PER_MEM1() {
        return QCVT_LOANAMT_PER_MEM;
    }

    public BigDecimal getQCVT_LOAN_RPYMT_PRD1() {
        return QCVT_LOAN_RPYMT_PRD;
    }

    public BigDecimal getQCVT_LOANINT_PER_MEM1() {
        return QCVT_LOANINT_PER_MEM;
    }

    public BigDecimal getQCVT_SAVINGS_PER_MEM1() {
        return QCVT_SAVINGS_PER_MEM;
    }

    public BigDecimal getQcvt_pmas_code1() {
        return qcvt_pmas_code;
    }

    public String getQcvt_pmas_sht_desc1() {
        return qcvt_pmas_sht_desc;
    }

    public BigDecimal getQcvt_rate_div_fact1() {
        return qcvt_rate_div_fact;
    }

    public String getQcvt_use_cvr_rate1() {
        return qcvt_use_cvr_rate;
    }

    public String getCoverRateDesc1() {
        return CoverRateDesc;
    }

    public BigDecimal getQCVT_AV_CVR_PER_MEMBER1() {
        return QCVT_AV_CVR_PER_MEMBER;
    }

    public String getQuocvtShtDesc1() {
        return quocvtShtDesc;
    }

    public String getCover_display1() {
        return cover_display;
    }

    public BigDecimal getQuoQcvtSa1() {
        return quoQcvtSa;
    }

    public BigDecimal getQuoButChargePrem1() {
        return quoButChargePrem;
    }

    public BigDecimal getQCVT_PREMIUM1() {
        return QCVT_PREMIUM;
    }

    public String getQuoButChargePrem21() {
        return quoButChargePrem2;
    }

    public String getQuoDependents1() {
        return quoDependents;
    }

    public Integer getQuoMembers1() {
        return quoMembers;
    }

    public BigDecimal getDiscLoadRate1() {
        return discLoadRate;
    }

    public BigDecimal getQCVT_CODE1() {
        return QCVT_CODE;
    }

    public BigDecimal getQCVT_CVT_CODE1() {
        return QCVT_CVT_CODE;
    }

    public Integer getQCVT_DISC_LOAD_DIV_FACT1() {
        return QCVT_DISC_LOAD_DIV_FACT;
    }

    public Double getQuoQcvtRate1() {
        return quoQcvtRate;
    }

    public Double getQuoAvganb1() {
        return quoAvganb;
    }

    public Date getQuoQCVTwetDate1() {
        return quoQCVTwetDate;
    }

    public Integer getQuoQcvtAvgprd1() {
        return quoQcvtAvgprd;
    }

    public Double getQuoSaPerMember1() {
        return quoSaPerMember;
    }

    public String getQuoUseUnitRate1() {
        return quoUseUnitRate;
    }

    public String getQCVT_LOAD_DISC1() {
        return QCVT_LOAD_DISC;
    }

    public Double getQuoUnitRate1() {
        return quoUnitRate;
    }

    public BigDecimal getQCVT_DTY_CODE1() {
        return QCVT_DTY_CODE;
    }

    public String getQCVT_DTY_DESCRIPTION1() {
        return QCVT_DTY_DESCRIPTION;
    }

    public String getQCVT_AVG_EARN_PER_MEM1() {
        return QCVT_AVG_EARN_PER_MEM;
    }

    public BigDecimal getQtax_code1() {
        return qtax_code;
    }

    public String getQtax_rate1() {
        return qtax_rate;
    }

    public BigDecimal getQtax_tax_amt1() {
        return qtax_tax_amt;
    }

    public String getTt_desc1() {
        return tt_desc;
    }

    public String getQtax_rate_desc1() {
        return qtax_rate_desc;
    }

    public String getQTAX_RATE_TYPE1() {
        return QTAX_RATE_TYPE;
    }

    public String getCatShtDesc1() {
        return catShtDesc;
    }

    public String getCatDesc1() {
        return catDesc;
    }

    public String getCatPeriod1() {
        return catPeriod;
    }

    public BigDecimal getLcaCode1() {
        return lcaCode;
    }

    public BigDecimal getSCH_CODE1() {
        return SCH_CODE;
    }

    public BigDecimal getQDL_CODE1() {
        return QDL_CODE;
    }

    public BigDecimal getQDL_QUO_CODE1() {
        return QDL_QUO_CODE;
    }

    public BigDecimal getQDL_MAX_TYPE_ALLOWED1() {
        return QDL_MAX_TYPE_ALLOWED;
    }

    public BigDecimal getQDL_LIMIT_AMT1() {
        return QDL_LIMIT_AMT;
    }

    public String getDTY_DESCRIPTION1() {
        return DTY_DESCRIPTION;
    }

    public String getCoverDescription1() {
        return CoverDescription;
    }

    public String getLCA_CATEG_DESC1() {
        return LCA_CATEG_DESC;
    }

    public String getQuotProvshtDesc1() {
        return quotProvshtDesc;
    }

    public String getQuotProvDesc1() {
        return quotProvDesc;
    }

    public String getQuotProvEditable1() {
        return quotProvEditable;
    }

    public BigDecimal getQpprCode1() {
        return qpprCode;
    }

    public BigDecimal getQDL_MIN_AMT1() {
        return QDL_MIN_AMT;
    }

    public BigDecimal getQCOIN_CODE1() {
        return QCOIN_CODE;
    }

    public BigDecimal getQCOIN_QUO_CODE1() {
        return QCOIN_QUO_CODE;
    }

    public BigDecimal getQCOIN_AGN_CODE1() {
        return QCOIN_AGN_CODE;
    }

    public String getCoinsurer_display1() {
        return coinsurer_display;
    }

    public String getQCOIN_SHARE_PCT1() {
        return QCOIN_SHARE_PCT;
    }

    public String getQCOIN_ADMIN_FEE1() {
        return QCOIN_ADMIN_FEE;
    }

    public String getQCOIN_LEAD_FOLLOW1() {
        return QCOIN_LEAD_FOLLOW;
    }

    public String getQCOIN_COIN_LEADER_SHARE1() {
        return QCOIN_COIN_LEADER_SHARE;
    }

    public String getQuoMemNo1() {
        return quoMemNo;
    }

    public String getQuoMemName1() {
        return quoMemName;
    }

    public String getQuoDepMemType1() {
        return quoDepMemType;
    }

    public Integer getQuoMemAnb1() {
        return quoMemAnb;
    }

    public String getQuoJointMem1() {
        return quoJointMem;
    }

    public String getQuoOccupation1() {
        return quoOccupation;
    }

    public String getQMEM_LOADING_TYPE1() {
        return QMEM_LOADING_TYPE;
    }

    public BigDecimal getQMEM_DTY_CODE1() {
        return QMEM_DTY_CODE;
    }

    public BigDecimal getQMEM_MEM_CODE1() {
        return QMEM_MEM_CODE;
    }

    public BigDecimal getQMEM_CODE1() {
        return QMEM_CODE;
    }

    public BigDecimal getQMEM_HEIGHT1() {
        return QMEM_HEIGHT;
    }

    public BigDecimal getQMEM_WEIGHT1() {
        return QMEM_WEIGHT;
    }

    public BigDecimal getQMEM_WEIGHT_LOADING1() {
        return QMEM_WEIGHT_LOADING;
    }

    public BigDecimal getQMEM_SYSTOLIC_PR1() {
        return QMEM_SYSTOLIC_PR;
    }

    public BigDecimal getQMEM_DIASTOLIC_PR1() {
        return QMEM_DIASTOLIC_PR;
    }

    public BigDecimal getQMEM_BPRESS_LOADING1() {
        return QMEM_BPRESS_LOADING;
    }

    public BigDecimal getQMEM_LOADING_RATE1() {
        return QMEM_LOADING_RATE;
    }

    public BigDecimal getQMEM_LOADING_DIV_FACT1() {
        return QMEM_LOADING_DIV_FACT;
    }

    public BigDecimal getQMEM_TOT_SA1() {
        return QMEM_TOT_SA;
    }

    public BigDecimal getQua_code1() {
        return qua_code;
    }

    public BigDecimal getQua_agn_code1() {
        return qua_agn_code;
    }

    public String getQua_agn_asgn1() {
        return qua_agn_asgn;
    }

    public String getQua_authorized1() {
        return qua_authorized;
    }

    public String getQua_agn_name1() {
        return qua_agn_name;
    }

    public Integer getQua_agn_share1() {
        return qua_agn_share;
    }

    public String getQua_agn_leader_follower1() {
        return qua_agn_leader_follower;
    }

    public BigDecimal getQEXC_CODE1() {
        return QEXC_CODE;
    }

    public BigDecimal getQEXC_POL_QUOT_CODE1() {
        return QEXC_POL_QUOT_CODE;
    }

    public String getQEXC_AUTHORISED1() {
        return QEXC_AUTHORISED;
    }

    public String getQEXC_DESC1() {
        return QEXC_DESC;
    }

    public BigDecimal getENQ_quo_code1() {
        return ENQ_quo_code;
    }

    public String getENQ_quo_no1() {
        return ENQ_quo_no;
    }

    public String getENQ_CLIENT1() {
        return ENQ_CLIENT;
    }

    public String getENQ_brn_name1() {
        return ENQ_brn_name;
    }

    public String getENQ_agn_name1() {
        return ENQ_agn_name;
    }

    public Date getENQ_DATE1() {
        return ENQ_DATE;
    }

    public String getENQ_STATUS1() {
        return ENQ_STATUS;
    }

    public String getQCVT_STAFF_DESC1() {
        return QCVT_STAFF_DESC;
    }

    public String getQCVT_MULT_EARNINGS_PRD1() {
        return QCVT_MULT_EARNINGS_PRD;
    }

    public String getQCVT_FCL_AMT1() {
        return QCVT_FCL_AMT;
    }

    public String getQCVT_OVERRIDE_FCL_AMT1() {
        return QCVT_OVERRIDE_FCL_AMT;
    }

    public void setNofAgents(Integer nofAgents) {
        this.nofAgents = nofAgents;
    }

    public Integer getNofAgents() {
        return nofAgents;
    }

    public void setPtx_appl_level(String ptx_appl_level) {
        this.ptx_appl_level = ptx_appl_level;
    }

    public String getPtx_appl_level() {
        return ptx_appl_level;
    }

    public void setCvt_desc(String cvt_desc) {
        this.cvt_desc = cvt_desc;
    }

    public String getCvt_desc() {
        return cvt_desc;
    }


    public void setQUO_LOSS_RATIO(BigDecimal QUO_LOSS_RATIO) {
        this.QUO_LOSS_RATIO = QUO_LOSS_RATIO;
    }

    public BigDecimal getQUO_LOSS_RATIO() {
        return QUO_LOSS_RATIO;
    }

    public void setQcvt_load_age_fact(BigDecimal qcvt_load_age_fact) {
        this.qcvt_load_age_fact = qcvt_load_age_fact;
    }

    public BigDecimal getQcvt_load_age_fact() {
        return qcvt_load_age_fact;
    }

    public void setQuo_unit_rate(BigDecimal quo_unit_rate) {
        this.quo_unit_rate = quo_unit_rate;
    }

    public BigDecimal getQuo_unit_rate() {
        return quo_unit_rate;
    }

    public void setQMEM_BMI_RATE(BigDecimal QMEM_BMI_RATE) {
        this.QMEM_BMI_RATE = QMEM_BMI_RATE;
    }

    public BigDecimal getQMEM_BMI_RATE() {
        return QMEM_BMI_RATE;
    }

    public void setQrmCode(BigDecimal qrmCode) {
        this.qrmCode = qrmCode;
    }

    public BigDecimal getQrmCode() {
        return qrmCode;
    }

    public void setQrmRemarks(String qrmRemarks) {
        this.qrmRemarks = qrmRemarks;
    }

    public String getQrmRemarks() {
        return qrmRemarks;
    }

    public void setQrmRemarksType(String qrmRemarksType) {
        this.qrmRemarksType = qrmRemarksType;
    }

    public String getQrmRemarksType() {
        return qrmRemarksType;
    }

    public void setQrmRemarksBy(String qrmRemarksBy) {
        this.qrmRemarksBy = qrmRemarksBy;
    }

    public String getQrmRemarksBy() {
        return qrmRemarksBy;
    }

    public void setQrmRemarksDesc(String qrmRemarksDesc) {
        this.qrmRemarksDesc = qrmRemarksDesc;
    }

    public String getQrmRemarksDesc() {
        return qrmRemarksDesc;
    }

    public void setQrmRemarksDate(Date qrmRemarksDate) {
        this.qrmRemarksDate = qrmRemarksDate;
    }

    public Date getQrmRemarksDate() {
        return qrmRemarksDate;
    }

    public void setMemSurname(String memSurname) {
        this.memSurname = memSurname;
    }

    public String getMemSurname() {
        return memSurname;
    }

    public void setMemOtherNames(String memOtherNames) {
        this.memOtherNames = memOtherNames;
    }

    public String getMemOtherNames() {
        return memOtherNames;
    }

    public void setMemSex(String memSex) {
        this.memSex = memSex;
    }

    public String getMemSex() {
        return memSex;
    }

    public void setMemDOB(Date memDOB) {
        this.memDOB = memDOB;
    }

    public Date getMemDOB() {
        return memDOB;
    }

    public void setQCVT_LIMIT(BigDecimal QCVT_LIMIT) {
        this.QCVT_LIMIT = QCVT_LIMIT;
    }

    public BigDecimal getQCVT_LIMIT() {
        return QCVT_LIMIT;
    }

    public void setQCVT_AGG_PLAN(String QCVT_AGG_PLAN) {
        this.QCVT_AGG_PLAN = QCVT_AGG_PLAN;
    }

    public String getQCVT_AGG_PLAN() {
        return QCVT_AGG_PLAN;
    }

    public void setTax_plan(String tax_plan) {
        this.tax_plan = tax_plan;
    }

    public String getTax_plan() {
        return tax_plan;
    }

    public void setTaxPremium(BigDecimal taxPremium) {
        this.taxPremium = taxPremium;
    }

    public BigDecimal getTaxPremium() {
        return taxPremium;
    }

    public void setTaxSa(BigDecimal taxSa) {
        this.taxSa = taxSa;
    }

    public BigDecimal getTaxSa() {
        return taxSa;
    }

    public void setQCVT_CODEFCL(BigDecimal QCVT_CODEFCL) {
        this.QCVT_CODEFCL = QCVT_CODEFCL;
    }

    public BigDecimal getQCVT_CODEFCL() {
        return QCVT_CODEFCL;
    }

    public void setQCVT_CVT_CODEFCL(BigDecimal QCVT_CVT_CODEFCL) {
        this.QCVT_CVT_CODEFCL = QCVT_CVT_CODEFCL;
    }

    public BigDecimal getQCVT_CVT_CODEFCL() {
        return QCVT_CVT_CODEFCL;
    }

    public void setQCVT_STAFF_DESCFCL(String QCVT_STAFF_DESCFCL) {
        this.QCVT_STAFF_DESCFCL = QCVT_STAFF_DESCFCL;
    }

    public String getQCVT_STAFF_DESCFCL() {
        return QCVT_STAFF_DESCFCL;
    }


    public void setQCVT_LIMITFCL(BigDecimal QCVT_LIMITFCL) {
        this.QCVT_LIMITFCL = QCVT_LIMITFCL;
    }

    public BigDecimal getQCVT_LIMITFCL() {
        return QCVT_LIMITFCL;
    }

    public void setQCVT_AGG_PLANFCL(String QCVT_AGG_PLANFCL) {
        this.QCVT_AGG_PLANFCL = QCVT_AGG_PLANFCL;
    }

    public String getQCVT_AGG_PLANFCL() {
        return QCVT_AGG_PLANFCL;
    }

    public void setQCVT_FCL_AMTFCL(String QCVT_FCL_AMTFCL) {
        this.QCVT_FCL_AMTFCL = QCVT_FCL_AMTFCL;
    }

    public String getQCVT_FCL_AMTFCL() {
        return QCVT_FCL_AMTFCL;
    }

    public void setQCVT_OVERRIDE_FCL_AMTFCL(String QCVT_OVERRIDE_FCL_AMTFCL) {
        this.QCVT_OVERRIDE_FCL_AMTFCL = QCVT_OVERRIDE_FCL_AMTFCL;
    }

    public String getQCVT_OVERRIDE_FCL_AMTFCL() {
        return QCVT_OVERRIDE_FCL_AMTFCL;
    }

    public void setQcvtPctInbuilt(String qcvtPctInbuilt) {
        this.qcvtPctInbuilt = qcvtPctInbuilt;
    }

    public String getQcvtPctInbuilt() {
        return qcvtPctInbuilt;
    }

    public void setQcvtAccelerator(String qcvtAccelerator) {
        this.qcvtAccelerator = qcvtAccelerator;
    }

    public String getQcvtAccelerator() {
        return qcvtAccelerator;
    }

  public void setSBU_CODE(BigDecimal SBU_CODE) {
    this.SBU_CODE = SBU_CODE;
  }

  public BigDecimal getSBU_CODE() {
    return SBU_CODE;
  }

  public void setSPOKE_CODE(BigDecimal SPOKE_CODE) {
    this.SPOKE_CODE = SPOKE_CODE;
  }

  public BigDecimal getSPOKE_CODE() {
    return SPOKE_CODE;
  }

  public void setSPOKE(String SPOKE) {
    this.SPOKE = SPOKE;
  }

  public String getSPOKE() {
    return SPOKE;
  }

  public void setCOVERAGE_AREA_CODE(BigDecimal COVERAGE_AREA_CODE) {
    this.COVERAGE_AREA_CODE = COVERAGE_AREA_CODE;
  }

  public BigDecimal getCOVERAGE_AREA_CODE() {
    return COVERAGE_AREA_CODE;
  }

  public void setCOVERAGE_AREA(String COVERAGE_AREA) {
    this.COVERAGE_AREA = COVERAGE_AREA;
  }

  public String getCOVERAGE_AREA() {
    return COVERAGE_AREA;
  }

  public void setLOCATION_CODE(BigDecimal LOCATION_CODE) {
    this.LOCATION_CODE = LOCATION_CODE;
  }

  public BigDecimal getLOCATION_CODE() {
    return LOCATION_CODE;
  }

  public void setLOCATION(String LOCATION) {
    this.LOCATION = LOCATION;
  }

  public String getLOCATION() {
    return LOCATION;
  }

  public void setORGANIZATION(String ORGANIZATION) {
    this.ORGANIZATION = ORGANIZATION;
  }

  public String getORGANIZATION() {
    return ORGANIZATION;
  }

  public void setTotaPremium(BigDecimal totaPremium) {
    this.totaPremium = totaPremium;
  }

  public BigDecimal getTotaPremium() {
    return totaPremium;
  }

    public void setDDP_CODE(BigDecimal DDP_CODE) {
        this.DDP_CODE = DDP_CODE;
    }

    public BigDecimal getDDP_CODE() {
        return DDP_CODE;
    }

    public void setDDP_NUMBER(String DDP_NUMBER) {
        this.DDP_NUMBER = DDP_NUMBER;
    }

    public String getDDP_NUMBER() {
        return DDP_NUMBER;
    }

    public void setDDP_TRANS_TYPE(String DDP_TRANS_TYPE) {
        this.DDP_TRANS_TYPE = DDP_TRANS_TYPE;
    }

    public String getDDP_TRANS_TYPE() {
        return DDP_TRANS_TYPE;
    }
}
