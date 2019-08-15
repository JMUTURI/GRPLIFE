package LMSG.view.Policy;

import java.math.BigDecimal;
import java.util.Date;

import oracle.sql.DATE;

public class endorsements
{
  private String ENDR_NO;
  private String ENDR_DURATION_TYPE;
  private String earnPrdType;
  private String ENDR_STATUS;
  private String ENDR_TYPE;
  private String ENDR_PAY_METHOD;
  private String AGENT_DISPLAY;
  private String ENDR_FREQ_OF_PAYMENT;
  private String MASK_DISPLAY;
  private String CHECK_AGENT_DISPLAY;
  private String ENDR_CALC_TYPE;
  private String ENDR_PENS_TYPE;
  private String ENDR_SCHEME_TYPE;
  private String ENDR_REG_NO;
  private String ENDR_SCHEME_TRUSTEES;
  private String ENDR_NSSF_INCLUDE;
  private String ENDR_PENS_TAX_COMPLIA;
  private String ENDR_PENS_PAY_FREQ;
  private String ENDR_CONTRIBTN_TYPE;
  private String PENSTYPE;
  private String CONTRIBTYPE;
  private String NSSF_INCL;
  private String PAYFREQ;
  private String ENDR_UNIT_RATE_FORMULA;
  private String SERVICE_PROVIDER;
  private String ENDR_FACRE_RATE_TYPE;
  private boolean ENDR_FACRE_CEDING;
  private BigDecimal endr_mktr_agn_code;
  private String marketer;
  private String ENDR_FCL_CALC_TYPE;
  private String ENDR_DURATION_TERM_TYPE;
  private String endr_pens_mode;
  private BigDecimal ENDR_TOT_SA;
  private BigDecimal ENDR_TOT_PREMIUM;
  private BigDecimal ENDR_PREV_SA;
  private BigDecimal ENDR_PREV_PREM;
  private BigDecimal ENDR_ADD_REF_PREM;
  private BigDecimal ENDR_MALE_NRD;
  private BigDecimal eNDR_ADD_REF_PERC_VARIANCE;
  private BigDecimal ENDR_FEMALE_NRD;
  private BigDecimal ENDR_COMM_RATE;
  private BigDecimal ENDR_CHECKOFF_RATE;
  private BigDecimal ENDR_NOF_MEMBERS;
  private BigDecimal ENDR_INST_PREM;
  private BigDecimal ENDR_COMM_AMT;
  private BigDecimal ENDR_PENS_ESC;
  private BigDecimal ENDR_EARN_ESCALATION;
  private BigDecimal ENDR_NSSF_AMOUNT;
  private BigDecimal ENDR_GUARANT_PRD;
  private BigDecimal ENDR_EMPYER_CONTR_RATE;
  private BigDecimal ENDR_EMPYEE_CONTR_RATE;
  private BigDecimal ENDR_PENS_ADMIN_FEE;
  private BigDecimal ENDR_EMPYR_PENS_BF;
  private BigDecimal ENDR_EMPYE_PENS_BF;
  private BigDecimal ENDR_TOT_PENS_BF;
  private BigDecimal ENDR_PENS_COMM_RATE;
  private BigDecimal ENDR_FNDING_RATE;
  private BigDecimal ENDR_VAT_RATE;
  private BigDecimal ENDR_OV_COMM_RATE;
  private BigDecimal ENDR_PENS_INT_RATE;
  private Date ENDR_EFFECTIVE_DATE;
  private Date ENDR_COVER_TO_DATE;
  private Date ENDR_REG_DATE;
  private String ENDR_PENS_VAL_FREQUENCY;
  private String ENDR_COINSURANCE;
  private String ENDR_COINSURE_LEADER;
  private BigDecimal ENDR_REIN_PMAS_CODE;
  private BigDecimal ENDR_COIN_FAC_SHARE;
  private String ENDR_REIN_PMAS_SHT_DESC;
  private BigDecimal ENDR_HIST_PENS_INT_RATE;
  
  
  private BigDecimal LGA_CODE;
  private BigDecimal LGA_AGN_CODE;
  private String AGN_NAME;
  private String LGA_REMARKS;
  private Date LGA_START_DATE;
  private String LGA_VAL_FREQ;
  private BigDecimal FCL_ENDR_CODE;
  private String FCL_ENDR_POL_POLICY_NO;
  private String FCL_ENDR_NO;
  private String FCL_ENDR_TYPE;
  private Date FCL_ENDR_FCL_DATE;
  private Date ENDR_COVER_FROM_DATE;
  private String FCL_ENDR_FCL_AMT;
  private BigDecimal POL_CODE;
  private String CLIENT;
  private String POL_INCEPTION_UWYR;
  private String POL_STATUS;
  private String POL_POLICY_NO;
  private BigDecimal ENDR_CODE;
  private String ENDR_LTR_TRANS_NO;
  private Date ENDR_DATE;
  private String ENDR_POL_POLICY_NO;
  private String TRANS;
  private BigDecimal PT_ENDR_CODE;
  private String PT_ENDR_NO;
  private String PT_ENDR_POL_POLICY_NO;
  private String PT_client;
  private String PT_AgentName;
  private String PT_ENDR_STATUS;
  private Date PT_ENDR_EFFECTIVE_DATE;
  private BigDecimal PT_ENDR_LTR_TRANS_NO;
  private String FCL_CALC_TYPE;
  private BigDecimal ENDR_FCL_AMT;
  private BigDecimal ENDR_OVERRIDE_FCL_AMT;
  private String ENDR_AUTHORIZED;
  private String BTR_TRANS_TYPE;
  private BigDecimal ENDR_TA_CODE;
  private String TA_DESC;
  private BigDecimal ENDR_TOT_SCHEME_SA;
  private BigDecimal EMPYER;
  private BigDecimal EMPYEE;
  private BigDecimal TOTAL_CONTR;
  private BigDecimal endrAnnAmount;
  private String endrAnnOption;
  private String endrAnnType;
  private String endrAnnEscalation;
  private BigDecimal endrANN_INVEST_RATE;
  private BigDecimal endrANN_TERMINAL_PAYOUT_RATE;
  private BigDecimal endrANN_SCHEME_LEGAL_AGE;
  private BigDecimal endrANN_ADMIN_CHARGE;
  private BigDecimal endrANN_INVEST_INTR_RATE;
  private BigDecimal endrTOT_ANN_INVESTMENTS;
  private BigDecimal endrTOT_TERMINAL_BENEFITS;
  private String ENDR_UMBRELLA_DURATION;
  private BigDecimal ENDR_LOSS_RATIO;
  
  private boolean endr_joint_agents;
  private BigDecimal endr_agen_share;
  
  private BigDecimal endr_pmas_code; 
  private String endr_pmas_sht_desc;     
  
  private BigDecimal endr_emplyr_volu_contr; 
  private BigDecimal endr_emplye_volu_contr;
  
  private BigDecimal joi_code;
  private BigDecimal joi_agn_code;
  private String agn_name;
  private BigDecimal joi_sub_agent_share;
  
  private BigDecimal PGSUB_CODE;
  private BigDecimal PGSUB_GSUB_CODE;
  private String GSUB_DESC;
  private String PGSUB_SHT_DESC;
  private String PGSUB_DESC;
  private BigDecimal PMEMS_CODE;
  private BigDecimal total_coin_prem;
  private BigDecimal total_coin_sa;
  /*
   * LPT_CODE ,LPT_SURNAME||' '||LPT_OTHER_NAMES,
            DECODE(LPT_STATUS,'C','Chair','T','Trust','M','Member')LPT_STATUS,
             LPT_REPRESENTATION ,LPT_TEL_NO ,LPT_PIN_NO,pr,
             LPT_CERT_NO,LPT_WEF_DATE, LPT_WET_DATE,LPT_REN_DATE,LPT_ADDRESS
   */
  private BigDecimal LPT_CODE;
  private String TRUSTEE_NAME;
  private String LPT_STATUS;
  private String LPT_REPRESENTATION;
  private String LPT_TEL_NO;
  private String LPT_PIN_NO;
  private String LPT_ID_NO;
  private String LPT_CERT_NO;
  private Date LPT_WEF_DATE;
  private Date LPT_WET_DATE;
  private Date LPT_REN_DATE;
  private String LPT_ADDRESS; 
  private String LPT_PHYSICAL_ADDR;
  private String LPT_SURNAME;
  private String LPT_OTHER_NAMES;
  private String STATUS;
  private String LPT_REMOVED;
  
  private Date LPT_REMOVED_DATE;
  private String LPT_REMOVED_BY;
  private String LPT_REMOVED_ENDR_CODE;
  private Date LPT_REMOVED_WEF;
  
  private BigDecimal ENDR_AVG_ANB;
  private String ENDR_SINGLE_GROSS_RATE;
  private BigDecimal ENDR_TOT_CLAIM_PAID,ENDR_TOT_PREM_PAID;
  
  //SBU and Location
  private BigDecimal SBU_CODE;
  private String SBU;
  private BigDecimal SPOKE_CODE;
  private String SPOKE;
  private BigDecimal COVERAGE_AREA_CODE;
  private String COVERAGE_AREA;
  private BigDecimal LOCATION_CODE;
  private String LOCATION;
  private String ORGANIZATION;
  
  //Policy Remarks
  private BigDecimal PRM_CODE;
  private String PRM_REMARKS,PRM_REMARK_TYPE,PRM_REMARKS_BY,REMARKS_DESC;
  private Date PRM_REMARKS_DATE;
  
  public void setENDR_NO(String ENDR_NO)
  {
    this.ENDR_NO = ENDR_NO;
  }

  public String getENDR_NO() {
    return this.ENDR_NO;
  }

  public void setENDR_DURATION_TYPE(String ENDR_DURATION_TYPE) {
    this.ENDR_DURATION_TYPE = ENDR_DURATION_TYPE;
  }

  public String getENDR_DURATION_TYPE() {
    return this.ENDR_DURATION_TYPE;
  }

  public void setENDR_STATUS(String ENDR_STATUS) {
    this.ENDR_STATUS = ENDR_STATUS;
  }

  public String getENDR_STATUS() {
    return this.ENDR_STATUS;
  }

  public void setENDR_TYPE(String ENDR_TYPE) {
    this.ENDR_TYPE = ENDR_TYPE;
  }

  public String getENDR_TYPE() {
    return this.ENDR_TYPE;
  }

  public void setENDR_PAY_METHOD(String ENDR_PAY_METHOD) {
    this.ENDR_PAY_METHOD = ENDR_PAY_METHOD;
  }

  public String getENDR_PAY_METHOD() {
    return this.ENDR_PAY_METHOD;
  }

  public void setAGENT_DISPLAY(String AGENT_DISPLAY) {
    this.AGENT_DISPLAY = AGENT_DISPLAY;
  }

  public String getAGENT_DISPLAY() {
    return this.AGENT_DISPLAY;
  }

  public void setENDR_FREQ_OF_PAYMENT(String ENDR_FREQ_OF_PAYMENT) {
    this.ENDR_FREQ_OF_PAYMENT = ENDR_FREQ_OF_PAYMENT;
  }

  public String getENDR_FREQ_OF_PAYMENT() {
    return this.ENDR_FREQ_OF_PAYMENT;
  }

  public void setMASK_DISPLAY(String MASK_DISPLAY) {
    this.MASK_DISPLAY = MASK_DISPLAY;
  }

  public String getMASK_DISPLAY() {
    return this.MASK_DISPLAY;
  }

  public void setCHECK_AGENT_DISPLAY(String CHECK_AGENT_DISPLAY) {
    this.CHECK_AGENT_DISPLAY = CHECK_AGENT_DISPLAY;
  }

  public String getCHECK_AGENT_DISPLAY() {
    return this.CHECK_AGENT_DISPLAY;
  }

  public void setENDR_CALC_TYPE(String ENDR_CALC_TYPE) {
    this.ENDR_CALC_TYPE = ENDR_CALC_TYPE;
  }

  public String getENDR_CALC_TYPE() {
    return this.ENDR_CALC_TYPE;
  }

  public void setENDR_PENS_TYPE(String ENDR_PENS_TYPE) {
    this.ENDR_PENS_TYPE = ENDR_PENS_TYPE;
  }

  public String getENDR_PENS_TYPE() {
    return this.ENDR_PENS_TYPE;
  }

  public void setENDR_SCHEME_TYPE(String ENDR_SCHEME_TYPE) {
    this.ENDR_SCHEME_TYPE = ENDR_SCHEME_TYPE;
  }

  public String getENDR_SCHEME_TYPE() {
    return this.ENDR_SCHEME_TYPE;
  }

  public void setENDR_REG_NO(String ENDR_REG_NO) {
    this.ENDR_REG_NO = ENDR_REG_NO;
  }

  public String getENDR_REG_NO() {
    return this.ENDR_REG_NO;
  }

  public void setENDR_SCHEME_TRUSTEES(String ENDR_SCHEME_TRUSTEES) {
    this.ENDR_SCHEME_TRUSTEES = ENDR_SCHEME_TRUSTEES;
  }

  public String getENDR_SCHEME_TRUSTEES() {
    return this.ENDR_SCHEME_TRUSTEES;
  }

  public void setENDR_NSSF_INCLUDE(String ENDR_NSSF_INCLUDE) {
    this.ENDR_NSSF_INCLUDE = ENDR_NSSF_INCLUDE;
  }

  public String getENDR_NSSF_INCLUDE() {
    return this.ENDR_NSSF_INCLUDE;
  }

  public void setENDR_PENS_TAX_COMPLIA(String ENDR_PENS_TAX_COMPLIA) {
    this.ENDR_PENS_TAX_COMPLIA = ENDR_PENS_TAX_COMPLIA;
  }

  public String getENDR_PENS_TAX_COMPLIA() {
    return this.ENDR_PENS_TAX_COMPLIA;
  }

  public void setENDR_PENS_PAY_FREQ(String ENDR_PENS_PAY_FREQ) {
    this.ENDR_PENS_PAY_FREQ = ENDR_PENS_PAY_FREQ;
  }

  public String getENDR_PENS_PAY_FREQ() {
    return this.ENDR_PENS_PAY_FREQ;
  }

  public void setENDR_CONTRIBTN_TYPE(String ENDR_CONTRIBTN_TYPE) {
    this.ENDR_CONTRIBTN_TYPE = ENDR_CONTRIBTN_TYPE;
  }

  public String getENDR_CONTRIBTN_TYPE() {
    return this.ENDR_CONTRIBTN_TYPE;
  }

  public void setENDR_TOT_SA(BigDecimal ENDR_TOT_SA) {
    this.ENDR_TOT_SA = ENDR_TOT_SA;
  }

  public BigDecimal getENDR_TOT_SA() {
    return this.ENDR_TOT_SA;
  }

  public void setENDR_TOT_PREMIUM(BigDecimal ENDR_TOT_PREMIUM) {
    this.ENDR_TOT_PREMIUM = ENDR_TOT_PREMIUM;
  }

  public BigDecimal getENDR_TOT_PREMIUM() {
    return this.ENDR_TOT_PREMIUM;
  }

  public void setENDR_PREV_SA(BigDecimal ENDR_PREV_SA) {
    this.ENDR_PREV_SA = ENDR_PREV_SA;
  }

  public BigDecimal getENDR_PREV_SA() {
    return this.ENDR_PREV_SA;
  }

  public void setENDR_PREV_PREM(BigDecimal ENDR_PREV_PREM) {
    this.ENDR_PREV_PREM = ENDR_PREV_PREM;
  }

  public BigDecimal getENDR_PREV_PREM() {
    return this.ENDR_PREV_PREM;
  }

  public void setENDR_ADD_REF_PREM(BigDecimal ENDR_ADD_REF_PREM) {
    this.ENDR_ADD_REF_PREM = ENDR_ADD_REF_PREM;
  }

  public BigDecimal getENDR_ADD_REF_PREM() {
    return this.ENDR_ADD_REF_PREM;
  }

  public void setENDR_MALE_NRD(BigDecimal ENDR_MALE_NRD) {
    this.ENDR_MALE_NRD = ENDR_MALE_NRD;
  }

  public BigDecimal getENDR_MALE_NRD() {
    return this.ENDR_MALE_NRD;
  }

  public void setENDR_ADD_REF_PERC_VARIANCE(BigDecimal eNDR_ADD_REF_PERC_VARIANCE) {
    this.eNDR_ADD_REF_PERC_VARIANCE = eNDR_ADD_REF_PERC_VARIANCE;
  }

  public BigDecimal getENDR_ADD_REF_PERC_VARIANCE() {
    return this.eNDR_ADD_REF_PERC_VARIANCE;
  }

  public void setENDR_FEMALE_NRD(BigDecimal ENDR_FEMALE_NRD) {
    this.ENDR_FEMALE_NRD = ENDR_FEMALE_NRD;
  }

  public BigDecimal getENDR_FEMALE_NRD() {
    return this.ENDR_FEMALE_NRD;
  }

  public void setENDR_COMM_RATE(BigDecimal ENDR_COMM_RATE) {
    this.ENDR_COMM_RATE = ENDR_COMM_RATE;
  }

  public BigDecimal getENDR_COMM_RATE() {
    return this.ENDR_COMM_RATE;
  }

  public void setENDR_CHECKOFF_RATE(BigDecimal ENDR_CHECKOFF_RATE) {
    this.ENDR_CHECKOFF_RATE = ENDR_CHECKOFF_RATE;
  }

  public BigDecimal getENDR_CHECKOFF_RATE() {
    return this.ENDR_CHECKOFF_RATE;
  }

  public void setENDR_NOF_MEMBERS(BigDecimal ENDR_NOF_MEMBERS) {
    this.ENDR_NOF_MEMBERS = ENDR_NOF_MEMBERS;
  }

  public BigDecimal getENDR_NOF_MEMBERS() {
    return this.ENDR_NOF_MEMBERS;
  }

  public void setENDR_INST_PREM(BigDecimal ENDR_INST_PREM) {
    this.ENDR_INST_PREM = ENDR_INST_PREM;
  }

  public BigDecimal getENDR_INST_PREM() {
    return this.ENDR_INST_PREM;
  }

  public void setENDR_COMM_AMT(BigDecimal ENDR_COMM_AMT) {
    this.ENDR_COMM_AMT = ENDR_COMM_AMT;
  }

  public BigDecimal getENDR_COMM_AMT() {
    return this.ENDR_COMM_AMT;
  }

  public void setENDR_PENS_ESC(BigDecimal ENDR_PENS_ESC) {
    this.ENDR_PENS_ESC = ENDR_PENS_ESC;
  }

  public BigDecimal getENDR_PENS_ESC() {
    return this.ENDR_PENS_ESC;
  }

  public void setENDR_EARN_ESCALATION(BigDecimal ENDR_EARN_ESCALATION) {
    this.ENDR_EARN_ESCALATION = ENDR_EARN_ESCALATION;
  }

  public BigDecimal getENDR_EARN_ESCALATION() {
    return this.ENDR_EARN_ESCALATION;
  }

  public void setENDR_NSSF_AMOUNT(BigDecimal ENDR_NSSF_AMOUNT) {
    this.ENDR_NSSF_AMOUNT = ENDR_NSSF_AMOUNT;
  }

  public BigDecimal getENDR_NSSF_AMOUNT() {
    return this.ENDR_NSSF_AMOUNT;
  }

  public void setENDR_GUARANT_PRD(BigDecimal ENDR_GUARANT_PRD) {
    this.ENDR_GUARANT_PRD = ENDR_GUARANT_PRD;
  }

  public BigDecimal getENDR_GUARANT_PRD() {
    return this.ENDR_GUARANT_PRD;
  }

  public void setENDR_EMPYER_CONTR_RATE(BigDecimal ENDR_EMPYER_CONTR_RATE) {
    this.ENDR_EMPYER_CONTR_RATE = ENDR_EMPYER_CONTR_RATE;
  }

  public BigDecimal getENDR_EMPYER_CONTR_RATE() {
    return this.ENDR_EMPYER_CONTR_RATE;
  }

  public void setENDR_EMPYEE_CONTR_RATE(BigDecimal ENDR_EMPYEE_CONTR_RATE) {
    this.ENDR_EMPYEE_CONTR_RATE = ENDR_EMPYEE_CONTR_RATE;
  }

  public BigDecimal getENDR_EMPYEE_CONTR_RATE() {
    return this.ENDR_EMPYEE_CONTR_RATE;
  }

  public void setENDR_PENS_ADMIN_FEE(BigDecimal ENDR_PENS_ADMIN_FEE) {
    this.ENDR_PENS_ADMIN_FEE = ENDR_PENS_ADMIN_FEE;
  }

  public BigDecimal getENDR_PENS_ADMIN_FEE() {
    return this.ENDR_PENS_ADMIN_FEE;
  }

  public void setENDR_EMPYR_PENS_BF(BigDecimal ENDR_EMPYR_PENS_BF) {
    this.ENDR_EMPYR_PENS_BF = ENDR_EMPYR_PENS_BF;
  }

  public BigDecimal getENDR_EMPYR_PENS_BF() {
    return this.ENDR_EMPYR_PENS_BF;
  }

  public void setENDR_EMPYE_PENS_BF(BigDecimal ENDR_EMPYE_PENS_BF) {
    this.ENDR_EMPYE_PENS_BF = ENDR_EMPYE_PENS_BF;
  }

  public BigDecimal getENDR_EMPYE_PENS_BF() {
    return this.ENDR_EMPYE_PENS_BF;
  }

  public void setENDR_TOT_PENS_BF(BigDecimal ENDR_TOT_PENS_BF) {
    this.ENDR_TOT_PENS_BF = ENDR_TOT_PENS_BF;
  }

  public BigDecimal getENDR_TOT_PENS_BF() {
    return this.ENDR_TOT_PENS_BF;
  }

  public void setENDR_PENS_COMM_RATE(BigDecimal ENDR_PENS_COMM_RATE) {
    this.ENDR_PENS_COMM_RATE = ENDR_PENS_COMM_RATE;
  }

  public BigDecimal getENDR_PENS_COMM_RATE() {
    return this.ENDR_PENS_COMM_RATE;
  }

  public void setENDR_FNDING_RATE(BigDecimal ENDR_FNDING_RATE) {
    this.ENDR_FNDING_RATE = ENDR_FNDING_RATE;
  }

  public BigDecimal getENDR_FNDING_RATE() {
    return this.ENDR_FNDING_RATE;
  }

  public void setENDR_EFFECTIVE_DATE(Date ENDR_EFFECTIVE_DATE) {
    this.ENDR_EFFECTIVE_DATE = ENDR_EFFECTIVE_DATE;
  }

  public Date getENDR_EFFECTIVE_DATE() {
    return this.ENDR_EFFECTIVE_DATE;
  }

  public void setENDR_COVER_TO_DATE(Date ENDR_COVER_TO_DATE) {
    this.ENDR_COVER_TO_DATE = ENDR_COVER_TO_DATE;
  }

  public Date getENDR_COVER_TO_DATE() {
    return this.ENDR_COVER_TO_DATE;
  }

  public void setENDR_REG_DATE(Date ENDR_REG_DATE) {
    this.ENDR_REG_DATE = ENDR_REG_DATE;
  }

  public Date getENDR_REG_DATE() {
    return this.ENDR_REG_DATE;
  }

  public void setFCL_ENDR_CODE(BigDecimal FCL_ENDR_CODE) {
    this.FCL_ENDR_CODE = FCL_ENDR_CODE;
  }

  public BigDecimal getFCL_ENDR_CODE() {
    return this.FCL_ENDR_CODE;
  }

  public void setFCL_ENDR_POL_POLICY_NO(String FCL_ENDR_POL_POLICY_NO) {
    this.FCL_ENDR_POL_POLICY_NO = FCL_ENDR_POL_POLICY_NO;
  }

  public String getFCL_ENDR_POL_POLICY_NO() {
    return this.FCL_ENDR_POL_POLICY_NO;
  }

  public void setFCL_ENDR_NO(String FCL_ENDR_NO) {
    this.FCL_ENDR_NO = FCL_ENDR_NO;
  }

  public String getFCL_ENDR_NO() {
    return this.FCL_ENDR_NO;
  }

  public void setFCL_ENDR_TYPE(String FCL_ENDR_TYPE) {
    this.FCL_ENDR_TYPE = FCL_ENDR_TYPE;
  }

  public String getFCL_ENDR_TYPE() {
    return this.FCL_ENDR_TYPE;
  }

  public void setFCL_ENDR_FCL_DATE(Date FCL_ENDR_FCL_DATE) {
    this.FCL_ENDR_FCL_DATE = FCL_ENDR_FCL_DATE;
  }

  public Date getFCL_ENDR_FCL_DATE() {
    return this.FCL_ENDR_FCL_DATE;
  }

  public void setFCL_ENDR_FCL_AMT(String FCL_ENDR_FCL_AMT) {
    this.FCL_ENDR_FCL_AMT = FCL_ENDR_FCL_AMT;
  }

  public String getFCL_ENDR_FCL_AMT() {
    return this.FCL_ENDR_FCL_AMT;
  }

  public void setPT_ENDR_CODE(BigDecimal PT_ENDR_CODE) {
    this.PT_ENDR_CODE = PT_ENDR_CODE;
  }

  public BigDecimal getPT_ENDR_CODE() {
    return this.PT_ENDR_CODE;
  }

  public void setPT_ENDR_NO(String PT_ENDR_NO) {
    this.PT_ENDR_NO = PT_ENDR_NO;
  }

  public String getPT_ENDR_NO() {
    return this.PT_ENDR_NO;
  }

  public void setPT_ENDR_POL_POLICY_NO(String PT_ENDR_POL_POLICY_NO) {
    this.PT_ENDR_POL_POLICY_NO = PT_ENDR_POL_POLICY_NO;
  }

  public String getPT_ENDR_POL_POLICY_NO() {
    return this.PT_ENDR_POL_POLICY_NO;
  }

  public void setPT_client(String PT_client) {
    this.PT_client = PT_client;
  }

  public String getPT_client() {
    return this.PT_client;
  }

  public void setPT_AgentName(String PT_AgentName) {
    this.PT_AgentName = PT_AgentName;
  }

  public String getPT_AgentName() {
    return this.PT_AgentName;
  }

  public void setPT_ENDR_STATUS(String PT_ENDR_STATUS) {
    this.PT_ENDR_STATUS = PT_ENDR_STATUS;
  }

  public String getPT_ENDR_STATUS() {
    return this.PT_ENDR_STATUS;
  }

  public void setPT_ENDR_EFFECTIVE_DATE(Date PT_ENDR_EFFECTIVE_DATE) {
    this.PT_ENDR_EFFECTIVE_DATE = PT_ENDR_EFFECTIVE_DATE;
  }

  public Date getPT_ENDR_EFFECTIVE_DATE() {
    return this.PT_ENDR_EFFECTIVE_DATE;
  }

  public void setPT_ENDR_LTR_TRANS_NO(BigDecimal PT_ENDR_LTR_TRANS_NO) {
    this.PT_ENDR_LTR_TRANS_NO = PT_ENDR_LTR_TRANS_NO;
  }

  public BigDecimal getPT_ENDR_LTR_TRANS_NO() {
    return this.PT_ENDR_LTR_TRANS_NO;
  }

  public void setPENSTYPE(String PENSTYPE) {
    this.PENSTYPE = PENSTYPE;
  }

  public String getPENSTYPE() {
    return this.PENSTYPE;
  }

  public void setCONTRIBTYPE(String CONTRIBTYPE) {
    this.CONTRIBTYPE = CONTRIBTYPE;
  }

  public String getCONTRIBTYPE() {
    return this.CONTRIBTYPE;
  }

  public void setNSSF_INCL(String NSSF_INCL) {
    this.NSSF_INCL = NSSF_INCL;
  }

  public String getNSSF_INCL() {
    return this.NSSF_INCL;
  }

  public void setPAYFREQ(String PAYFREQ) {
    this.PAYFREQ = PAYFREQ;
  }

  public String getPAYFREQ() {
    return this.PAYFREQ;
  }

  public void setENDR_UNIT_RATE_FORMULA(String ENDR_UNIT_RATE_FORMULA) {
    this.ENDR_UNIT_RATE_FORMULA = ENDR_UNIT_RATE_FORMULA;
  }

  public String getENDR_UNIT_RATE_FORMULA() {
    return this.ENDR_UNIT_RATE_FORMULA;
  }

  public void setENDR_VAT_RATE(BigDecimal ENDR_VAT_RATE) {
    this.ENDR_VAT_RATE = ENDR_VAT_RATE;
  }

  public BigDecimal getENDR_VAT_RATE() {
    return this.ENDR_VAT_RATE;
  }

  public void setENDR_OV_COMM_RATE(BigDecimal ENDR_OV_COMM_RATE) {
    this.ENDR_OV_COMM_RATE = ENDR_OV_COMM_RATE;
  }

  public BigDecimal getENDR_OV_COMM_RATE() {
    return this.ENDR_OV_COMM_RATE;
  }

  public void setFCL_CALC_TYPE(String FCL_CALC_TYPE) {
    this.FCL_CALC_TYPE = FCL_CALC_TYPE;
  }

  public String getFCL_CALC_TYPE() {
    return this.FCL_CALC_TYPE;
  }

  public void setENDR_FCL_AMT(BigDecimal ENDR_FCL_AMT) {
    this.ENDR_FCL_AMT = ENDR_FCL_AMT;
  }

  public BigDecimal getENDR_FCL_AMT() {
    return this.ENDR_FCL_AMT;
  }

  public void setENDR_OVERRIDE_FCL_AMT(BigDecimal ENDR_OVERRIDE_FCL_AMT) {
    this.ENDR_OVERRIDE_FCL_AMT = ENDR_OVERRIDE_FCL_AMT;
  }

  public BigDecimal getENDR_OVERRIDE_FCL_AMT() {
    return this.ENDR_OVERRIDE_FCL_AMT;
  }

  public void setENDR_AUTHORIZED(String ENDR_AUTHORIZED) {
    this.ENDR_AUTHORIZED = ENDR_AUTHORIZED;
  }

  public String getENDR_AUTHORIZED() {
    return this.ENDR_AUTHORIZED;
  }

  public void setBTR_TRANS_TYPE(String BTR_TRANS_TYPE) {
    this.BTR_TRANS_TYPE = BTR_TRANS_TYPE;
  }

  public String getBTR_TRANS_TYPE() {
    return this.BTR_TRANS_TYPE;
  }

  public void setENDR_TA_CODE(BigDecimal ENDR_TA_CODE) {
    this.ENDR_TA_CODE = ENDR_TA_CODE;
  }

  public BigDecimal getENDR_TA_CODE() {
    return this.ENDR_TA_CODE;
  }

  public void setTA_DESC(String TA_DESC) {
    this.TA_DESC = TA_DESC;
  }

  public String getTA_DESC() {
    return this.TA_DESC;
  }

  public void setEMPYER(BigDecimal EMPYER) {
    this.EMPYER = EMPYER;
  }

  public BigDecimal getEMPYER() {
    return this.EMPYER;
  }

  public void setEMPYEE(BigDecimal EMPYEE) {
    this.EMPYEE = EMPYEE;
  }

  public BigDecimal getEMPYEE() {
    return this.EMPYEE;
  }

  public void setTOTAL_CONTR(BigDecimal TOTAL_CONTR) {
    this.TOTAL_CONTR = TOTAL_CONTR;
  }

  public BigDecimal getTOTAL_CONTR() {
    return this.TOTAL_CONTR;
  }

  public void setENDR_TOT_SCHEME_SA(BigDecimal ENDR_TOT_SCHEME_SA) {
    this.ENDR_TOT_SCHEME_SA = ENDR_TOT_SCHEME_SA;
  }

  public BigDecimal getENDR_TOT_SCHEME_SA() {
    return this.ENDR_TOT_SCHEME_SA;
  }

  public void setSERVICE_PROVIDER(String SERVICE_PROVIDER) {
    this.SERVICE_PROVIDER = SERVICE_PROVIDER;
  }

  public String getSERVICE_PROVIDER() {
    return this.SERVICE_PROVIDER;
  }

  public void setEndrAnnAmount(BigDecimal endrAnnAmount) {
    this.endrAnnAmount = endrAnnAmount;
  }

  public BigDecimal getEndrAnnAmount() {
    return this.endrAnnAmount;
  }

  public void setEndrAnnOption(String endrAnnOption) {
    this.endrAnnOption = endrAnnOption;
  }

  public String getEndrAnnOption() {
    return this.endrAnnOption;
  }

  public void setEndrAnnType(String endrAnnType) {
    this.endrAnnType = endrAnnType;
  }

  public String getEndrAnnType() {
    return this.endrAnnType;
  }

  public void setEndrAnnEscalation(String endrAnnEscalation) {
    this.endrAnnEscalation = endrAnnEscalation;
  }

  public String getEndrAnnEscalation() {
    return this.endrAnnEscalation;
  }

  public void setENDR_PENS_INT_RATE(BigDecimal ENDR_PENS_INT_RATE) {
    this.ENDR_PENS_INT_RATE = ENDR_PENS_INT_RATE;
  }

  public BigDecimal getENDR_PENS_INT_RATE() {
    return this.ENDR_PENS_INT_RATE;
  }

  public void setENDR_FACRE_CEDING(boolean ENDR_FACRE_CEDING) {
    this.ENDR_FACRE_CEDING = ENDR_FACRE_CEDING;
  }

  public boolean getENDR_FACRE_CEDING() {
    return this.ENDR_FACRE_CEDING;
  }

  public void setENDR_FACRE_RATE_TYPE(String ENDR_FACRE_RATE_TYPE) {
    this.ENDR_FACRE_RATE_TYPE = ENDR_FACRE_RATE_TYPE;
  }

  public String getENDR_FACRE_RATE_TYPE() {
    return this.ENDR_FACRE_RATE_TYPE;
  }

  public void setEndrANN_INVEST_RATE(BigDecimal endrANN_INVEST_RATE) {
    this.endrANN_INVEST_RATE = endrANN_INVEST_RATE;
  }

  public BigDecimal getEndrANN_INVEST_RATE() {
    return this.endrANN_INVEST_RATE;
  }

  public void setEndrANN_TERMINAL_PAYOUT_RATE(BigDecimal endrANN_TERMINAL_PAYOUT_RATE) {
    this.endrANN_TERMINAL_PAYOUT_RATE = endrANN_TERMINAL_PAYOUT_RATE;
  }

  public BigDecimal getEndrANN_TERMINAL_PAYOUT_RATE() {
    return this.endrANN_TERMINAL_PAYOUT_RATE;
  }

  public void setEndrANN_SCHEME_LEGAL_AGE(BigDecimal endrANN_SCHEME_LEGAL_AGE) {
    this.endrANN_SCHEME_LEGAL_AGE = endrANN_SCHEME_LEGAL_AGE;
  }

  public BigDecimal getEndrANN_SCHEME_LEGAL_AGE() {
    return this.endrANN_SCHEME_LEGAL_AGE;
  }

  public void setEndrANN_ADMIN_CHARGE(BigDecimal endrANN_ADMIN_CHARGE) {
    this.endrANN_ADMIN_CHARGE = endrANN_ADMIN_CHARGE;
  }

  public BigDecimal getEndrANN_ADMIN_CHARGE() {
    return this.endrANN_ADMIN_CHARGE;
  }

  public void setEndrANN_INVEST_INTR_RATE(BigDecimal endrANN_INVEST_INTR_RATE) {
    this.endrANN_INVEST_INTR_RATE = endrANN_INVEST_INTR_RATE;
  }

  public BigDecimal getEndrANN_INVEST_INTR_RATE() {
    return this.endrANN_INVEST_INTR_RATE;
  }

  public void setEndrTOT_ANN_INVESTMENTS(BigDecimal endrTOT_ANN_INVESTMENTS) {
    this.endrTOT_ANN_INVESTMENTS = endrTOT_ANN_INVESTMENTS;
  }

  public BigDecimal getEndrTOT_ANN_INVESTMENTS() {
    return this.endrTOT_ANN_INVESTMENTS;
  }

  public void setEndrTOT_TERMINAL_BENEFITS(BigDecimal endrTOT_TERMINAL_BENEFITS) {
    this.endrTOT_TERMINAL_BENEFITS = endrTOT_TERMINAL_BENEFITS;
  }

  public BigDecimal getEndrTOT_TERMINAL_BENEFITS() {
    return this.endrTOT_TERMINAL_BENEFITS;
  }

  public void setPOL_CODE(BigDecimal POL_CODE) {
    this.POL_CODE = POL_CODE;
  }

  public BigDecimal getPOL_CODE() {
    return this.POL_CODE;
  }

  public void setCLIENT(String CLIENT) {
    this.CLIENT = CLIENT;
  }

  public String getCLIENT() {
    return this.CLIENT;
  }

  public void setPOL_INCEPTION_UWYR(String POL_INCEPTION_UWYR) {
    this.POL_INCEPTION_UWYR = POL_INCEPTION_UWYR;
  }

  public String getPOL_INCEPTION_UWYR() {
    return this.POL_INCEPTION_UWYR;
  }

  public void setPOL_STATUS(String POL_STATUS) {
    this.POL_STATUS = POL_STATUS;
  }

  public String getPOL_STATUS() {
    return this.POL_STATUS;
  }

  public void setPOL_POLICY_NO(String POL_POLICY_NO) {
    this.POL_POLICY_NO = POL_POLICY_NO;
  }

  public String getPOL_POLICY_NO() {
    return this.POL_POLICY_NO;
  }

  public void setENDR_CODE(BigDecimal ENDR_CODE) {
    this.ENDR_CODE = ENDR_CODE;
  }

  public BigDecimal getENDR_CODE() {
    return this.ENDR_CODE;
  }

  public void setENDR_LTR_TRANS_NO(String ENDR_LTR_TRANS_NO) {
    this.ENDR_LTR_TRANS_NO = ENDR_LTR_TRANS_NO;
  }

  public String getENDR_LTR_TRANS_NO() {
    return this.ENDR_LTR_TRANS_NO;
  }

  public void setENDR_DATE(Date ENDR_DATE) {
    this.ENDR_DATE = ENDR_DATE;
  }

  public Date getENDR_DATE() {
    return this.ENDR_DATE;
  }

  public void setENDR_POL_POLICY_NO(String ENDR_POL_POLICY_NO) {
    this.ENDR_POL_POLICY_NO = ENDR_POL_POLICY_NO;
  }

  public String getENDR_POL_POLICY_NO() {
    return this.ENDR_POL_POLICY_NO;
  }

  public void setTRANS(String TRANS) {
    this.TRANS = TRANS;
  }

  public String getTRANS() {
    return this.TRANS;
  }

  public void setENDR_PENS_VAL_FREQUENCY(String ENDR_PENS_VAL_FREQUENCY) {
    this.ENDR_PENS_VAL_FREQUENCY = ENDR_PENS_VAL_FREQUENCY;
  }

  public String getENDR_PENS_VAL_FREQUENCY() {
    return this.ENDR_PENS_VAL_FREQUENCY;
  }

  public void setENDR_COINSURANCE(String ENDR_COINSURANCE) {
    this.ENDR_COINSURANCE = ENDR_COINSURANCE;
  }

  public String getENDR_COINSURANCE() {
    return this.ENDR_COINSURANCE;
  }

  public void setENDR_COINSURE_LEADER(String ENDR_COINSURE_LEADER) {
    this.ENDR_COINSURE_LEADER = ENDR_COINSURE_LEADER;
  }

  public String getENDR_COINSURE_LEADER() {
    return this.ENDR_COINSURE_LEADER;
  }

  public void setENDR_COVER_FROM_DATE(Date ENDR_COVER_FROM_DATE) {
    this.ENDR_COVER_FROM_DATE = ENDR_COVER_FROM_DATE;
  }

  public Date getENDR_COVER_FROM_DATE() {
    return this.ENDR_COVER_FROM_DATE;
  }

  public void setENDR_REIN_PMAS_CODE(BigDecimal ENDR_REIN_PMAS_CODE) {
    this.ENDR_REIN_PMAS_CODE = ENDR_REIN_PMAS_CODE;
  }

  public BigDecimal getENDR_REIN_PMAS_CODE() {
    return this.ENDR_REIN_PMAS_CODE;
  }

  public void setENDR_REIN_PMAS_SHT_DESC(String ENDR_REIN_PMAS_SHT_DESC) {
    this.ENDR_REIN_PMAS_SHT_DESC = ENDR_REIN_PMAS_SHT_DESC;
  }

  public String getENDR_REIN_PMAS_SHT_DESC() {
    return this.ENDR_REIN_PMAS_SHT_DESC;
  }

  public void setENDR_FCL_CALC_TYPE(String ENDR_FCL_CALC_TYPE) {
    this.ENDR_FCL_CALC_TYPE = ENDR_FCL_CALC_TYPE;
  }

  public String getENDR_FCL_CALC_TYPE() {
    return this.ENDR_FCL_CALC_TYPE;
  }

  public void setENDR_DURATION_TERM_TYPE(String ENDR_DURATION_TERM_TYPE) {
    this.ENDR_DURATION_TERM_TYPE = ENDR_DURATION_TERM_TYPE;
  }

  public String getENDR_DURATION_TERM_TYPE() {
    return this.ENDR_DURATION_TERM_TYPE;
  }

  public void setLGA_CODE(BigDecimal LGA_CODE) {
    this.LGA_CODE = LGA_CODE;
  }

  public BigDecimal getLGA_CODE() {
    return this.LGA_CODE;
  }

  public void setLGA_AGN_CODE(BigDecimal LGA_AGN_CODE) {
    this.LGA_AGN_CODE = LGA_AGN_CODE;
  }

  public BigDecimal getLGA_AGN_CODE() {
    return this.LGA_AGN_CODE;
  }

  public void setAGN_NAME(String AGN_NAME) {
    this.AGN_NAME = AGN_NAME;
  }

  public String getAGN_NAME() {
    return this.AGN_NAME;
  }

  public void setLGA_REMARKS(String LGA_REMARKS) {
    this.LGA_REMARKS = LGA_REMARKS;
  }

  public String getLGA_REMARKS() {
    return this.LGA_REMARKS;
  }

  public void setEndr_pens_mode(String endr_pens_mode) {
    this.endr_pens_mode = endr_pens_mode;
  }

  public String getEndr_pens_mode() {
    return this.endr_pens_mode;
  }

  public void setENDR_COIN_FAC_SHARE(BigDecimal ENDR_COIN_FAC_SHARE) {
    this.ENDR_COIN_FAC_SHARE = ENDR_COIN_FAC_SHARE;
  }

  public BigDecimal getENDR_COIN_FAC_SHARE() {
    return this.ENDR_COIN_FAC_SHARE;
  }

  public void setLGA_START_DATE(Date LGA_START_DATE) {
    this.LGA_START_DATE = LGA_START_DATE;
  }

  public Date getLGA_START_DATE() {
    return this.LGA_START_DATE;
  }

  public void setLGA_VAL_FREQ(String LGA_VAL_FREQ) {
    this.LGA_VAL_FREQ = LGA_VAL_FREQ;
  }

  public String getLGA_VAL_FREQ() {
    return this.LGA_VAL_FREQ;
  }

  public void setEndr_mktr_agn_code(BigDecimal endr_mktr_agn_code) {
    this.endr_mktr_agn_code = endr_mktr_agn_code;
  }

  public BigDecimal getEndr_mktr_agn_code() {
    return this.endr_mktr_agn_code;
  }

  public void setMarketer(String marketer) {
    this.marketer = marketer;
  }

  public String getMarketer() {
    return this.marketer;
  }

    public void setEndr_emplyr_volu_contr(BigDecimal endr_emplyr_volu_contr) {
        this.endr_emplyr_volu_contr = endr_emplyr_volu_contr;
    }

    public BigDecimal getEndr_emplyr_volu_contr() {
        return endr_emplyr_volu_contr;
    }

    public void setEndr_emplye_volu_contr(BigDecimal endr_emplye_volu_contr) {
        this.endr_emplye_volu_contr = endr_emplye_volu_contr;
    }

    public BigDecimal getEndr_emplye_volu_contr() {
        return endr_emplye_volu_contr;
    }

    public void setEndr_joint_agents(boolean endr_joint_agents) {
        this.endr_joint_agents = endr_joint_agents;
    }

    public boolean getEndr_joint_agents() {
        return endr_joint_agents;
    }

    public void setEndr_agen_share(BigDecimal endr_agen_share) {
        this.endr_agen_share = endr_agen_share;
    }

    public BigDecimal getEndr_agen_share() {
        return endr_agen_share;
    }

    public void setJoi_agn_code(BigDecimal joi_agn_code) {
        this.joi_agn_code = joi_agn_code;
    }

    public BigDecimal getJoi_agn_code() {
        return joi_agn_code;
    }

    public void setAgn_name(String agn_name) {
        this.agn_name = agn_name;
    }

    public String getAgn_name() {
        return agn_name;
    }

    public void setJoi_sub_agent_share(BigDecimal joi_sub_agent_share) {
        this.joi_sub_agent_share = joi_sub_agent_share;
    }

    public BigDecimal getJoi_sub_agent_share() {
        return joi_sub_agent_share;
    }

    public void setJoi_code(BigDecimal joi_code) {
        this.joi_code = joi_code;
    }

    public BigDecimal getJoi_code() {
        return joi_code;
    }

    public void setENDR_UMBRELLA_DURATION(String ENDR_UMBRELLA_DURATION) {
        this.ENDR_UMBRELLA_DURATION = ENDR_UMBRELLA_DURATION;
    }

    public String getENDR_UMBRELLA_DURATION() {
        return ENDR_UMBRELLA_DURATION;
    }

    public void setPGSUB_CODE(BigDecimal PGSUB_CODE) {
        this.PGSUB_CODE = PGSUB_CODE;
    }

    public BigDecimal getPGSUB_CODE() {
        return PGSUB_CODE;
    }

    public void setPGSUB_GSUB_CODE(BigDecimal PGSUB_GSUB_CODE) {
        this.PGSUB_GSUB_CODE = PGSUB_GSUB_CODE;
    }

    public BigDecimal getPGSUB_GSUB_CODE() {
        return PGSUB_GSUB_CODE;
    }

    public void setGSUB_DESC(String GSUB_DESC) {
        this.GSUB_DESC = GSUB_DESC;
    }

    public String getGSUB_DESC() {
        return GSUB_DESC;
    }

    public void setPGSUB_SHT_DESC(String PGSUB_SHT_DESC) {
        this.PGSUB_SHT_DESC = PGSUB_SHT_DESC;
    }

    public String getPGSUB_SHT_DESC() {
        return PGSUB_SHT_DESC;
    }

    public void setPGSUB_DESC(String PGSUB_DESC) {
        this.PGSUB_DESC = PGSUB_DESC;
    }

    public String getPGSUB_DESC() {
        return PGSUB_DESC;
    }

    public void setPMEMS_CODE(BigDecimal PMEMS_CODE) {
        this.PMEMS_CODE = PMEMS_CODE;
    }

    public BigDecimal getPMEMS_CODE() {
        return PMEMS_CODE;
    }

    public void setEndr_pmas_code(BigDecimal endr_pmas_code) {
        this.endr_pmas_code = endr_pmas_code;
    }

    public BigDecimal getEndr_pmas_code() {
        return endr_pmas_code;
    }

    public void setEndr_pmas_sht_desc(String endr_pmas_sht_desc) {
        this.endr_pmas_sht_desc = endr_pmas_sht_desc;
    }

    public String getEndr_pmas_sht_desc() {
        return endr_pmas_sht_desc;
    }

    public void setTotal_coin_prem(BigDecimal total_coin_prem) {
        this.total_coin_prem = total_coin_prem;
    }

    public BigDecimal getTotal_coin_prem() {
        return total_coin_prem;
    }

    public void setTotal_coin_sa(BigDecimal total_coin_sa) {
        this.total_coin_sa = total_coin_sa;
    }

    public BigDecimal getTotal_coin_sa() {
        return total_coin_sa;
    }

    public String getENDR_NO1() {
        return ENDR_NO;
    }

    public String getENDR_DURATION_TYPE1() {
        return ENDR_DURATION_TYPE;
    }

    public String getENDR_STATUS1() {
        return ENDR_STATUS;
    }

    public String getENDR_TYPE1() {
        return ENDR_TYPE;
    }

    public String getENDR_PAY_METHOD1() {
        return ENDR_PAY_METHOD;
    }

    public String getAGENT_DISPLAY1() {
        return AGENT_DISPLAY;
    }

    public String getENDR_FREQ_OF_PAYMENT1() {
        return ENDR_FREQ_OF_PAYMENT;
    }

    public String getMASK_DISPLAY1() {
        return MASK_DISPLAY;
    }

    public String getCHECK_AGENT_DISPLAY1() {
        return CHECK_AGENT_DISPLAY;
    }

    public String getENDR_CALC_TYPE1() {
        return ENDR_CALC_TYPE;
    }

    public String getENDR_PENS_TYPE1() {
        return ENDR_PENS_TYPE;
    }

    public String getENDR_SCHEME_TYPE1() {
        return ENDR_SCHEME_TYPE;
    }

    public String getENDR_REG_NO1() {
        return ENDR_REG_NO;
    }

    public String getENDR_SCHEME_TRUSTEES1() {
        return ENDR_SCHEME_TRUSTEES;
    }

    public String getENDR_NSSF_INCLUDE1() {
        return ENDR_NSSF_INCLUDE;
    }

    public String getENDR_PENS_TAX_COMPLIA1() {
        return ENDR_PENS_TAX_COMPLIA;
    }

    public String getENDR_PENS_PAY_FREQ1() {
        return ENDR_PENS_PAY_FREQ;
    }

    public String getENDR_CONTRIBTN_TYPE1() {
        return ENDR_CONTRIBTN_TYPE;
    }

    public String getPENSTYPE1() {
        return PENSTYPE;
    }

    public String getCONTRIBTYPE1() {
        return CONTRIBTYPE;
    }

    public String getNSSF_INCL1() {
        return NSSF_INCL;
    }

    public String getPAYFREQ1() {
        return PAYFREQ;
    }

    public String getENDR_UNIT_RATE_FORMULA1() {
        return ENDR_UNIT_RATE_FORMULA;
    }

    public String getSERVICE_PROVIDER1() {
        return SERVICE_PROVIDER;
    }

    public String getENDR_FACRE_RATE_TYPE1() {
        return ENDR_FACRE_RATE_TYPE;
    }

    public boolean isENDR_FACRE_CEDING() {
        return ENDR_FACRE_CEDING;
    }

    public BigDecimal getEndr_mktr_agn_code1() {
        return endr_mktr_agn_code;
    }

    public String getMarketer1() {
        return marketer;
    }

    public String getENDR_FCL_CALC_TYPE1() {
        return ENDR_FCL_CALC_TYPE;
    }

    public String getENDR_DURATION_TERM_TYPE1() {
        return ENDR_DURATION_TERM_TYPE;
    }

    public String getEndr_pens_mode1() {
        return endr_pens_mode;
    }

    public BigDecimal getENDR_TOT_SA1() {
        return ENDR_TOT_SA;
    }

    public BigDecimal getENDR_TOT_PREMIUM1() {
        return ENDR_TOT_PREMIUM;
    }

    public BigDecimal getENDR_PREV_SA1() {
        return ENDR_PREV_SA;
    }

    public BigDecimal getENDR_PREV_PREM1() {
        return ENDR_PREV_PREM;
    }

    public BigDecimal getENDR_ADD_REF_PREM1() {
        return ENDR_ADD_REF_PREM;
    }

    public BigDecimal getENDR_MALE_NRD1() {
        return ENDR_MALE_NRD;
    }

    public BigDecimal getENDR_ADD_REF_PERC_VARIANCE1() {
        return eNDR_ADD_REF_PERC_VARIANCE;
    }

    public BigDecimal getENDR_FEMALE_NRD1() {
        return ENDR_FEMALE_NRD;
    }

    public BigDecimal getENDR_COMM_RATE1() {
        return ENDR_COMM_RATE;
    }

    public BigDecimal getENDR_CHECKOFF_RATE1() {
        return ENDR_CHECKOFF_RATE;
    }

    public BigDecimal getENDR_NOF_MEMBERS1() {
        return ENDR_NOF_MEMBERS;
    }

    public BigDecimal getENDR_INST_PREM1() {
        return ENDR_INST_PREM;
    }

    public BigDecimal getENDR_COMM_AMT1() {
        return ENDR_COMM_AMT;
    }

    public BigDecimal getENDR_PENS_ESC1() {
        return ENDR_PENS_ESC;
    }

    public BigDecimal getENDR_EARN_ESCALATION1() {
        return ENDR_EARN_ESCALATION;
    }

    public BigDecimal getENDR_NSSF_AMOUNT1() {
        return ENDR_NSSF_AMOUNT;
    }

    public BigDecimal getENDR_GUARANT_PRD1() {
        return ENDR_GUARANT_PRD;
    }

    public BigDecimal getENDR_EMPYER_CONTR_RATE1() {
        return ENDR_EMPYER_CONTR_RATE;
    }

    public BigDecimal getENDR_EMPYEE_CONTR_RATE1() {
        return ENDR_EMPYEE_CONTR_RATE;
    }

    public BigDecimal getENDR_PENS_ADMIN_FEE1() {
        return ENDR_PENS_ADMIN_FEE;
    }

    public BigDecimal getENDR_EMPYR_PENS_BF1() {
        return ENDR_EMPYR_PENS_BF;
    }

    public BigDecimal getENDR_EMPYE_PENS_BF1() {
        return ENDR_EMPYE_PENS_BF;
    }

    public BigDecimal getENDR_TOT_PENS_BF1() {
        return ENDR_TOT_PENS_BF;
    }

    public BigDecimal getENDR_PENS_COMM_RATE1() {
        return ENDR_PENS_COMM_RATE;
    }

    public BigDecimal getENDR_FNDING_RATE1() {
        return ENDR_FNDING_RATE;
    }

    public BigDecimal getENDR_VAT_RATE1() {
        return ENDR_VAT_RATE;
    }

    public BigDecimal getENDR_OV_COMM_RATE1() {
        return ENDR_OV_COMM_RATE;
    }

    public BigDecimal getENDR_PENS_INT_RATE1() {
        return ENDR_PENS_INT_RATE;
    }

    public Date getENDR_EFFECTIVE_DATE1() {
        return ENDR_EFFECTIVE_DATE;
    }

    public Date getENDR_COVER_TO_DATE1() {
        return ENDR_COVER_TO_DATE;
    }

    public Date getENDR_REG_DATE1() {
        return ENDR_REG_DATE;
    }

    public String getENDR_PENS_VAL_FREQUENCY1() {
        return ENDR_PENS_VAL_FREQUENCY;
    }

    public String getENDR_COINSURANCE1() {
        return ENDR_COINSURANCE;
    }

    public String getENDR_COINSURE_LEADER1() {
        return ENDR_COINSURE_LEADER;
    }

    public BigDecimal getENDR_REIN_PMAS_CODE1() {
        return ENDR_REIN_PMAS_CODE;
    }

    public BigDecimal getENDR_COIN_FAC_SHARE1() {
        return ENDR_COIN_FAC_SHARE;
    }

    public String getENDR_REIN_PMAS_SHT_DESC1() {
        return ENDR_REIN_PMAS_SHT_DESC;
    }

    public BigDecimal getLGA_CODE1() {
        return LGA_CODE;
    }

    public BigDecimal getLGA_AGN_CODE1() {
        return LGA_AGN_CODE;
    }

    public String getAGN_NAME1() {
        return AGN_NAME;
    }

    public String getLGA_REMARKS1() {
        return LGA_REMARKS;
    }

    public Date getLGA_START_DATE1() {
        return LGA_START_DATE;
    }

    public String getLGA_VAL_FREQ1() {
        return LGA_VAL_FREQ;
    }

    public BigDecimal getFCL_ENDR_CODE1() {
        return FCL_ENDR_CODE;
    }

    public String getFCL_ENDR_POL_POLICY_NO1() {
        return FCL_ENDR_POL_POLICY_NO;
    }

    public String getFCL_ENDR_NO1() {
        return FCL_ENDR_NO;
    }

    public String getFCL_ENDR_TYPE1() {
        return FCL_ENDR_TYPE;
    }

    public Date getFCL_ENDR_FCL_DATE1() {
        return FCL_ENDR_FCL_DATE;
    }

    public Date getENDR_COVER_FROM_DATE1() {
        return ENDR_COVER_FROM_DATE;
    }

    public String getFCL_ENDR_FCL_AMT1() {
        return FCL_ENDR_FCL_AMT;
    }

    public BigDecimal getPOL_CODE1() {
        return POL_CODE;
    }

    public String getCLIENT1() {
        return CLIENT;
    }

    public String getPOL_INCEPTION_UWYR1() {
        return POL_INCEPTION_UWYR;
    }

    public String getPOL_STATUS1() {
        return POL_STATUS;
    }

    public String getPOL_POLICY_NO1() {
        return POL_POLICY_NO;
    }

    public BigDecimal getENDR_CODE1() {
        return ENDR_CODE;
    }

    public String getENDR_LTR_TRANS_NO1() {
        return ENDR_LTR_TRANS_NO;
    }

    public Date getENDR_DATE1() {
        return ENDR_DATE;
    }

    public String getENDR_POL_POLICY_NO1() {
        return ENDR_POL_POLICY_NO;
    }

    public String getTRANS1() {
        return TRANS;
    }

    public BigDecimal getPT_ENDR_CODE1() {
        return PT_ENDR_CODE;
    }

    public String getPT_ENDR_NO1() {
        return PT_ENDR_NO;
    }

    public String getPT_ENDR_POL_POLICY_NO1() {
        return PT_ENDR_POL_POLICY_NO;
    }

    public String getPT_client1() {
        return PT_client;
    }

    public String getPT_AgentName1() {
        return PT_AgentName;
    }

    public String getPT_ENDR_STATUS1() {
        return PT_ENDR_STATUS;
    }

    public Date getPT_ENDR_EFFECTIVE_DATE1() {
        return PT_ENDR_EFFECTIVE_DATE;
    }

    public BigDecimal getPT_ENDR_LTR_TRANS_NO1() {
        return PT_ENDR_LTR_TRANS_NO;
    }

    public String getFCL_CALC_TYPE1() {
        return FCL_CALC_TYPE;
    }

    public BigDecimal getENDR_FCL_AMT1() {
        return ENDR_FCL_AMT;
    }

    public BigDecimal getENDR_OVERRIDE_FCL_AMT1() {
        return ENDR_OVERRIDE_FCL_AMT;
    }

    public String getENDR_AUTHORIZED1() {
        return ENDR_AUTHORIZED;
    }

    public String getBTR_TRANS_TYPE1() {
        return BTR_TRANS_TYPE;
    }

    public BigDecimal getENDR_TA_CODE1() {
        return ENDR_TA_CODE;
    }

    public String getTA_DESC1() {
        return TA_DESC;
    }

    public BigDecimal getENDR_TOT_SCHEME_SA1() {
        return ENDR_TOT_SCHEME_SA;
    }

    public BigDecimal getEMPYER1() {
        return EMPYER;
    }

    public BigDecimal getEMPYEE1() {
        return EMPYEE;
    }

    public BigDecimal getTOTAL_CONTR1() {
        return TOTAL_CONTR;
    }

    public BigDecimal getEndrAnnAmount1() {
        return endrAnnAmount;
    }

    public String getEndrAnnOption1() {
        return endrAnnOption;
    }

    public String getEndrAnnType1() {
        return endrAnnType;
    }

    public String getEndrAnnEscalation1() {
        return endrAnnEscalation;
    }

    public BigDecimal getEndrANN_INVEST_RATE1() {
        return endrANN_INVEST_RATE;
    }

    public BigDecimal getEndrANN_TERMINAL_PAYOUT_RATE1() {
        return endrANN_TERMINAL_PAYOUT_RATE;
    }

    public BigDecimal getEndrANN_SCHEME_LEGAL_AGE1() {
        return endrANN_SCHEME_LEGAL_AGE;
    }

    public BigDecimal getEndrANN_ADMIN_CHARGE1() {
        return endrANN_ADMIN_CHARGE;
    }

    public BigDecimal getEndrANN_INVEST_INTR_RATE1() {
        return endrANN_INVEST_INTR_RATE;
    }

    public BigDecimal getEndrTOT_ANN_INVESTMENTS1() {
        return endrTOT_ANN_INVESTMENTS;
    }

    public BigDecimal getEndrTOT_TERMINAL_BENEFITS1() {
        return endrTOT_TERMINAL_BENEFITS;
    }

    public void setENDR_LOSS_RATIO(BigDecimal ENDR_LOSS_RATIO) {
        this.ENDR_LOSS_RATIO = ENDR_LOSS_RATIO;
    }

    public BigDecimal getENDR_LOSS_RATIO() {
        return ENDR_LOSS_RATIO;
    }

    public void setLPT_CODE(BigDecimal LPT_CODE) {
        this.LPT_CODE = LPT_CODE;
    }

    public BigDecimal getLPT_CODE() {
        return LPT_CODE;
    }

    public void setTRUSTEE_NAME(String TRUSTEE_NAME) {
        this.TRUSTEE_NAME = TRUSTEE_NAME;
    }

    public String getTRUSTEE_NAME() {
        return TRUSTEE_NAME;
    }

    public void setLPT_STATUS(String LPT_STATUS) {
        this.LPT_STATUS = LPT_STATUS;
    }

    public String getLPT_STATUS() {
        return LPT_STATUS;
    }

    public void setLPT_REPRESENTATION(String LPT_REPRESENTATION) {
        this.LPT_REPRESENTATION = LPT_REPRESENTATION;
    }

    public String getLPT_REPRESENTATION() {
        return LPT_REPRESENTATION;
    }

    public void setLPT_TEL_NO(String LPT_TEL_NO) {
        this.LPT_TEL_NO = LPT_TEL_NO;
    }

    public String getLPT_TEL_NO() {
        return LPT_TEL_NO;
    }

    public void setLPT_PIN_NO(String LPT_PIN_NO) {
        this.LPT_PIN_NO = LPT_PIN_NO;
    }

    public String getLPT_PIN_NO() {
        return LPT_PIN_NO;
    }

    public void setLPT_ID_NO(String LPT_ID_NO) {
        this.LPT_ID_NO = LPT_ID_NO;
    }

    public String getLPT_ID_NO() {
        return LPT_ID_NO;
    }

    public void setLPT_CERT_NO(String LPT_CERT_NO) {
        this.LPT_CERT_NO = LPT_CERT_NO;
    }

    public String getLPT_CERT_NO() {
        return LPT_CERT_NO;
    }

    public void setLPT_WEF_DATE(Date LPT_WEF_DATE) {
        this.LPT_WEF_DATE = LPT_WEF_DATE;
    }

    public Date getLPT_WEF_DATE() {
        return LPT_WEF_DATE;
    }

    public void setLPT_WET_DATE(Date LPT_WET_DATE) {
        this.LPT_WET_DATE = LPT_WET_DATE;
    }

    public Date getLPT_WET_DATE() {
        return LPT_WET_DATE;
    }

    public void setLPT_REN_DATE(Date LPT_REN_DATE) {
        this.LPT_REN_DATE = LPT_REN_DATE;
    }

    public Date getLPT_REN_DATE() {
        return LPT_REN_DATE;
    }

    public void setLPT_ADDRESS(String LPT_ADDRESS) {
        this.LPT_ADDRESS = LPT_ADDRESS;
    }

    public String getLPT_ADDRESS() {
        return LPT_ADDRESS;
    }

    public void setLPT_PHYSICAL_ADDR(String LPT_PHYSICAL_ADDR) {
        this.LPT_PHYSICAL_ADDR = LPT_PHYSICAL_ADDR;
    }

    public String getLPT_PHYSICAL_ADDR() {
        return LPT_PHYSICAL_ADDR;
    }

    public void setENDR_AVG_ANB(BigDecimal ENDR_AVG_ANB) {
        this.ENDR_AVG_ANB = ENDR_AVG_ANB;
    }

    public BigDecimal getENDR_AVG_ANB() {
        return ENDR_AVG_ANB;
    }

    public void setENDR_HIST_PENS_INT_RATE(BigDecimal ENDR_HIST_PENS_INT_RATE) {
        this.ENDR_HIST_PENS_INT_RATE = ENDR_HIST_PENS_INT_RATE;
    }

    public BigDecimal getENDR_HIST_PENS_INT_RATE() {
        return ENDR_HIST_PENS_INT_RATE;
    }

    public void setPRM_CODE(BigDecimal PRM_CODE) {
        this.PRM_CODE = PRM_CODE;
    }

    public BigDecimal getPRM_CODE() {
        return PRM_CODE;
    }

    public void setPRM_REMARKS(String PRM_REMARKS) {
        this.PRM_REMARKS = PRM_REMARKS;
    }

    public String getPRM_REMARKS() {
        return PRM_REMARKS;
    }

    public void setENDR_SINGLE_GROSS_RATE(String ENDR_SINGLE_GROSS_RATE) {
        this.ENDR_SINGLE_GROSS_RATE = ENDR_SINGLE_GROSS_RATE;
    }

    public String getENDR_SINGLE_GROSS_RATE() {
        return ENDR_SINGLE_GROSS_RATE;
    }

    public void setENDR_TOT_CLAIM_PAID(BigDecimal ENDR_TOT_CLAIM_PAID) {
        this.ENDR_TOT_CLAIM_PAID = ENDR_TOT_CLAIM_PAID;
    }

    public BigDecimal getENDR_TOT_CLAIM_PAID() {
        return ENDR_TOT_CLAIM_PAID;
    }

    public void setENDR_TOT_PREM_PAID(BigDecimal ENDR_TOT_PREM_PAID) {
        this.ENDR_TOT_PREM_PAID = ENDR_TOT_PREM_PAID;
    }

    public BigDecimal getENDR_TOT_PREM_PAID() {
        return ENDR_TOT_PREM_PAID;
    }

    public void setLPT_SURNAME(String LPT_SURNAME) {
        this.LPT_SURNAME = LPT_SURNAME;
    }

    public String getLPT_SURNAME() {
        return LPT_SURNAME;
    }

    public void setLPT_OTHER_NAMES(String LPT_OTHER_NAMES) {
        this.LPT_OTHER_NAMES = LPT_OTHER_NAMES;
    }

    public String getLPT_OTHER_NAMES() {
        return LPT_OTHER_NAMES;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setPRM_REMARK_TYPE(String PRM_REMARK_TYPE) {
        this.PRM_REMARK_TYPE = PRM_REMARK_TYPE;
    }

    public String getPRM_REMARK_TYPE() {
        return PRM_REMARK_TYPE;
    }

    public void setPRM_REMARKS_DATE(Date PRM_REMARKS_DATE) {
        this.PRM_REMARKS_DATE = PRM_REMARKS_DATE;
    }

    public Date getPRM_REMARKS_DATE() {
        return PRM_REMARKS_DATE;
    }

    public void setPRM_REMARKS_BY(String PRM_REMARKS_BY) {
        this.PRM_REMARKS_BY = PRM_REMARKS_BY;
    }

    public String getPRM_REMARKS_BY() {
        return PRM_REMARKS_BY;
    }

    public void setREMARKS_DESC(String REMARKS_DESC) {
        this.REMARKS_DESC = REMARKS_DESC;
    }

    public String getREMARKS_DESC() {
        return REMARKS_DESC;
    }


  public void setEarnPrdType(String earnPrdType) {
    this.earnPrdType = earnPrdType;
  }

  public String getEarnPrdType() {
    return earnPrdType;
  }

  public void setSBU_CODE(BigDecimal SBU_CODE) {
    this.SBU_CODE = SBU_CODE;
  }

  public BigDecimal getSBU_CODE() {
    return SBU_CODE;
  }

  public void setSBU(String SBU) {
    this.SBU = SBU;
  }

  public String getSBU() {
    return SBU;
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

  public void setLPT_REMOVED(String LPT_REMOVED) {
    this.LPT_REMOVED = LPT_REMOVED;
  }

  public String getLPT_REMOVED() {
    return LPT_REMOVED;
  }

  public void setLPT_REMOVED_DATE(Date LPT_REMOVED_DATE) {
    this.LPT_REMOVED_DATE = LPT_REMOVED_DATE;
  }

  public Date getLPT_REMOVED_DATE() {
    return LPT_REMOVED_DATE;
  }

  public void setLPT_REMOVED_BY(String LPT_REMOVED_BY) {
    this.LPT_REMOVED_BY = LPT_REMOVED_BY;
  }

  public String getLPT_REMOVED_BY() {
    return LPT_REMOVED_BY;
  }

  public void setLPT_REMOVED_ENDR_CODE(String LPT_REMOVED_ENDR_CODE) {
    this.LPT_REMOVED_ENDR_CODE = LPT_REMOVED_ENDR_CODE;
  }

  public String getLPT_REMOVED_ENDR_CODE() {
    return LPT_REMOVED_ENDR_CODE;
  }

  public void setLPT_REMOVED_WEF(Date LPT_REMOVED_WEF) {
    this.LPT_REMOVED_WEF = LPT_REMOVED_WEF;
  }

  public Date getLPT_REMOVED_WEF() {
    return LPT_REMOVED_WEF;
  }
}
