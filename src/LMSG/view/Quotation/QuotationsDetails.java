package LMSG.view.Quotation;

import java.math.BigDecimal;


import java.util.*;


public class QuotationsDetails {
  private String client;
  private Integer quoCode;
  private String quoNo;
  private Integer quoRevNo;
  private String MARKETER;
  private String agnshtDesc,QUO_PROD_SHT_DESC,quo_pens_mode,quo_pens_type,
              QUO_PMAS_SHT_DESC, QUO_DURATION_TYPE, QUO_CALC_TYPE,QUO_STATUS,QUO_DEPENDT_COVERED,QUO_SAVINGS_RIDER,QUO_TYPE,
              QUO_FREQ_OF_PAYMENT,QUO_GRP_LIFE_RIDER,GCO_DESC,HAZARD,QUO_CLA_SHT_DESC;
  private String agnName,QUO_PENS_PAY_FREQ,QUO_CONTRIBTN_TYPE,QUO_COVER_DEPENDANTS;
  private Date QUO_DATE,QUO_EFFECTIVE_DATE, QUO_COVER_TO_DATE;
  private String BRN_NAME,QUO_FEATURES,CALC_TYPE_DESC,QUO_NOF_MEMBERS,freq_of_payment_disp,
            QUO_LETTER_OPENING_REMARKS,QUO_LETTER_CLOSING_REMARKS, QUO_FCL_CALC_TYPE ;
  private BigDecimal QUO_TOT_PREMIUM,QUO_TOT_SA,QUO_EARN_ESCALATION,
              QUO_AVG_ANB,QUO_FCL_AMT, QUO_OVERRIDE_FCL_AMT,QUO_FNDING_RATE,
              QUO_PENS_ADMIN_FEE, QUO_PENS_COMM_RATE, QUO_EMPYR_PENS_BF, QUO_EMPYE_PENS_BF, QUO_TOT_PENS_BF, 
              QUO_RETIRE_AGE, QUO_EMPYER_CONTR, QUO_EMPYEE_CONTR, QUO_VOL_CONTR, QUO_TOT_CONTR, QUO_TOT_SALARIES, QUO_EMPYER_CONTR_RATE, 
              QUO_EMPYEE_CONTR_RATE, QUO_GUARANT_PRD, quo_avg_int,QUO_EMPLOYER_VOL_CONTR, QUO_EMPLOYEE_VOL_CONTR, QUO_PENS_INT_RATE,QUO_PENS_ESC,QUO_MALE_NRD,QUO_FEMALE_NRD, PROP_CODE;
  private BigDecimal QUO_ANN_AMOUNT,QUO_AVG_EARNINGS, QUO_TOT_CLAIM_PAID, QUO_TOT_PREM_PAID,
      QUO_CLM_EXP_RATE;
  private String annType;
  private String annOption;
  private String annEscalation;
  
  private BigDecimal EMPYE_PA;
  private BigDecimal EMYR_PA;
  
  private String QUO_UMBRELLA;
  private String QUO_UMBRELLA_DURATION;
  private String QUO_UMBRELLADESC;
  
  private String QUO_PAY_METHOD;
  
  private BigDecimal QUO_ANN_INVESTMENT_RATE;
  private BigDecimal QUO_ANN_TERMINAL_PAYOUT_RATE;
  private BigDecimal QUO_ANN_ADMIN_CHARGE;
  private BigDecimal QUO_ANN_INVEST_INTR_RATE;
  private BigDecimal QUO_ANN_SCHEME_LEGAL_AGE;
  private BigDecimal QUO_ANN_INVESTMENT;
  private BigDecimal QUO_ANN_TERM_BENEFITS;
  private BigDecimal QUO_LOSS_RATIO;
  private BigDecimal QUO_UNIT_RATE;
  
  //Quotation Taxes
  
  private BigDecimal qtax_code;
  private String qtax_rate;
  private BigDecimal qtax_tax_amt;
  private String tt_desc;
  private String qtax_rate_desc;
  private String QTAX_RATE_TYPE;
  private String QUO_UNIT_RATE_FORMULA;
  private String ptx_appl_level;
  private  String cvt_desc;
  private  String tax_plan;
   
  //client claim experience at quotation
    private String PROD_DESC;
    private String LTR_CLM_NO;
    private String CLIENT;
    private String LTR_POL_POLICY_NO;
    private String MEMBER_DISP;
    private BigDecimal LTR_TRANS_NO;
    private String LTR_BTR_TRANS_CODE;
    private String CLM_CAUS_TYPE;
    private String CLM_AUTHORISED;
    private String CLAIM_STATUS;
    private BigDecimal AMT_CLAIMED;
    private BigDecimal AMT_TO_PAY;  
    private BigDecimal QUO_HIST_PENS_INT_RATE;
    private String QUO_CUR_SYMBOL,QUO_CURR_RATE_TYPE;
    private BigDecimal QUO_CUR_RATE;
    private String QUO_TENDER;
    private String QUO_PRD_TYPE;
    private BigDecimal QUO_PRP_CODE;
    private BigDecimal QUO_TENDER_PRD;
    private String QUO_ASSIGNEE_NAME,QUO_ASSIGNEE_PHY_ADDR;
    
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
    public QuotationsDetails() {
  }

  public void setClient(String client) {
    this.client = client;
  }

  public String getClient() {
    return client;
  }

  public void setQuoCode(Integer quoCode) {
    this.quoCode = quoCode;
  }

  public Integer getQuoCode() {
    return quoCode;
  }

  public void setQuoNo(String quoNo) {
    this.quoNo = quoNo;
  }

  public String getQuoNo() {
    return quoNo;
  }

  public void setQuoRevNo(Integer quoRevNo) {
    this.quoRevNo = quoRevNo;
  }

  public Integer getQuoRevNo() {
    return quoRevNo;
  }

  public void setAgnshtDesc(String agnshtDesc) {
    this.agnshtDesc = agnshtDesc;
  }

  public String getAgnshtDesc() {
    return agnshtDesc;
  }

  public void setAgnName(String agnName) {
    this.agnName = agnName;
  }

  public String getAgnName() {
    return agnName;
  }


  public void setQUO_PROD_SHT_DESC(String QUO_PROD_SHT_DESC) {
    this.QUO_PROD_SHT_DESC = QUO_PROD_SHT_DESC;
  }

  public String getQUO_PROD_SHT_DESC() {
    return QUO_PROD_SHT_DESC;
  }

  public void setQUO_PMAS_SHT_DESC(String QUO_PMAS_SHT_DESC) {
    this.QUO_PMAS_SHT_DESC = QUO_PMAS_SHT_DESC;
  }

  public String getQUO_PMAS_SHT_DESC() {
    return QUO_PMAS_SHT_DESC;
  }

  public void setQUO_DURATION_TYPE(String QUO_DURATION_TYPE) {
    this.QUO_DURATION_TYPE = QUO_DURATION_TYPE;
  }

  public String getQUO_DURATION_TYPE() {
    return QUO_DURATION_TYPE;
  }

  public void setQUO_CALC_TYPE(String QUO_CALC_TYPE) {
    this.QUO_CALC_TYPE = QUO_CALC_TYPE;
  }

  public String getQUO_CALC_TYPE() {
    return QUO_CALC_TYPE;
  }

  public void setQUO_STATUS(String QUO_STATUS) {
    this.QUO_STATUS = QUO_STATUS;
  }

  public String getQUO_STATUS() {
    return QUO_STATUS;
  }

  public void setQUO_DEPENDT_COVERED(String QUO_DEPENDT_COVERED) {
    this.QUO_DEPENDT_COVERED = QUO_DEPENDT_COVERED;
  }

  public String getQUO_DEPENDT_COVERED() {
    return QUO_DEPENDT_COVERED;
  }

  public void setQUO_SAVINGS_RIDER(String QUO_SAVINGS_RIDER) {
    this.QUO_SAVINGS_RIDER = QUO_SAVINGS_RIDER;
  }

  public String getQUO_SAVINGS_RIDER() {
    return QUO_SAVINGS_RIDER;
  }

  public void setQUO_TYPE(String QUO_TYPE) {
    this.QUO_TYPE = QUO_TYPE;
  }

  public String getQUO_TYPE() {
    return QUO_TYPE;
  }

  public void setQUO_FREQ_OF_PAYMENT(String QUO_FREQ_OF_PAYMENT) {
    this.QUO_FREQ_OF_PAYMENT = QUO_FREQ_OF_PAYMENT;
  }

  public String getQUO_FREQ_OF_PAYMENT() {
    return QUO_FREQ_OF_PAYMENT;
  }

  public void setQUO_PENS_PAY_FREQ(String QUO_PENS_PAY_FREQ) {
    this.QUO_PENS_PAY_FREQ = QUO_PENS_PAY_FREQ;
  }

  public String getQUO_PENS_PAY_FREQ() {
    return QUO_PENS_PAY_FREQ;
  }

  public void setQUO_CONTRIBTN_TYPE(String QUO_CONTRIBTN_TYPE) {
    this.QUO_CONTRIBTN_TYPE = QUO_CONTRIBTN_TYPE;
  }

  public String getQUO_CONTRIBTN_TYPE() {
    return QUO_CONTRIBTN_TYPE;
  }

  public void setQUO_DATE(Date QUO_DATE) {
    this.QUO_DATE = QUO_DATE;
  }

  public Date getQUO_DATE() {
    return QUO_DATE;
  }

  public void setQUO_EFFECTIVE_DATE(Date QUO_EFFECTIVE_DATE) {
    this.QUO_EFFECTIVE_DATE = QUO_EFFECTIVE_DATE;
  }

  public Date getQUO_EFFECTIVE_DATE() {
    return QUO_EFFECTIVE_DATE;
  }

  public void setQUO_COVER_TO_DATE(Date QUO_COVER_TO_DATE) {
    this.QUO_COVER_TO_DATE = QUO_COVER_TO_DATE;
  }

  public Date getQUO_COVER_TO_DATE() {
    return QUO_COVER_TO_DATE;
  }

  public void setBRN_NAME(String BRN_NAME) {
    this.BRN_NAME = BRN_NAME;
  }

  public String getBRN_NAME() {
    return BRN_NAME;
  }

  public void setQUO_TOT_PREMIUM(BigDecimal QUO_TOT_PREMIUM) {
    this.QUO_TOT_PREMIUM = QUO_TOT_PREMIUM;
  }

  public BigDecimal getQUO_TOT_PREMIUM() {
    return QUO_TOT_PREMIUM;
  }

  public void setQUO_TOT_SA(BigDecimal QUO_TOT_SA) {
    this.QUO_TOT_SA = QUO_TOT_SA;
  }

  public BigDecimal getQUO_TOT_SA() {
    return QUO_TOT_SA;
  }

  public void setQUO_AVG_ANB(BigDecimal QUO_AVG_ANB) {
    this.QUO_AVG_ANB = QUO_AVG_ANB;
  }

  public BigDecimal getQUO_AVG_ANB() {
    return QUO_AVG_ANB;
  }

  public void setQUO_FCL_AMT(BigDecimal QUO_FCL_AMT) {
    this.QUO_FCL_AMT = QUO_FCL_AMT;
  }

  public BigDecimal getQUO_FCL_AMT() {
    return QUO_FCL_AMT;
  }

  public void setQUO_GRP_LIFE_RIDER(String QUO_GRP_LIFE_RIDER) {
    this.QUO_GRP_LIFE_RIDER = QUO_GRP_LIFE_RIDER;
  }

  public String getQUO_GRP_LIFE_RIDER() {
    return QUO_GRP_LIFE_RIDER;
  }

  public void setQUO_OVERRIDE_FCL_AMT(BigDecimal QUO_OVERRIDE_FCL_AMT) {
    this.QUO_OVERRIDE_FCL_AMT = QUO_OVERRIDE_FCL_AMT;
  }

  public BigDecimal getQUO_OVERRIDE_FCL_AMT() {
    return QUO_OVERRIDE_FCL_AMT;
  }

  public void setQUO_PENS_ADMIN_FEE(BigDecimal QUO_PENS_ADMIN_FEE) {
    this.QUO_PENS_ADMIN_FEE = QUO_PENS_ADMIN_FEE;
  }

  public BigDecimal getQUO_PENS_ADMIN_FEE() {
    return QUO_PENS_ADMIN_FEE;
  }

  public void setQUO_PENS_COMM_RATE(BigDecimal QUO_PENS_COMM_RATE) {
    this.QUO_PENS_COMM_RATE = QUO_PENS_COMM_RATE;
  }

  public BigDecimal getQUO_PENS_COMM_RATE() {
    return QUO_PENS_COMM_RATE;
  }

  public void setQUO_EMPYR_PENS_BF(BigDecimal QUO_EMPYR_PENS_BF) {
    this.QUO_EMPYR_PENS_BF = QUO_EMPYR_PENS_BF;
  }

  public BigDecimal getQUO_EMPYR_PENS_BF() {
    return QUO_EMPYR_PENS_BF;
  }

  public void setQUO_EMPYE_PENS_BF(BigDecimal QUO_EMPYE_PENS_BF) {
    this.QUO_EMPYE_PENS_BF = QUO_EMPYE_PENS_BF;
  }

  public BigDecimal getQUO_EMPYE_PENS_BF() {
    return QUO_EMPYE_PENS_BF;
  }

  public void setQUO_TOT_PENS_BF(BigDecimal QUO_TOT_PENS_BF) {
    this.QUO_TOT_PENS_BF = QUO_TOT_PENS_BF;
  }

  public BigDecimal getQUO_TOT_PENS_BF() {
    return QUO_TOT_PENS_BF;
  }

  public void setQUO_RETIRE_AGE(BigDecimal QUO_RETIRE_AGE) {
    this.QUO_RETIRE_AGE = QUO_RETIRE_AGE;
  }

  public BigDecimal getQUO_RETIRE_AGE() {
    return QUO_RETIRE_AGE;
  }

  public void setQUO_EMPYER_CONTR(BigDecimal QUO_EMPYER_CONTR) {
    this.QUO_EMPYER_CONTR = QUO_EMPYER_CONTR;
  }

  public BigDecimal getQUO_EMPYER_CONTR() {
    return QUO_EMPYER_CONTR;
  }

  public void setQUO_EMPYEE_CONTR(BigDecimal QUO_EMPYEE_CONTR) {
    this.QUO_EMPYEE_CONTR = QUO_EMPYEE_CONTR;
  }

  public BigDecimal getQUO_EMPYEE_CONTR() {
    return QUO_EMPYEE_CONTR;
  }

  public void setQUO_VOL_CONTR(BigDecimal QUO_VOL_CONTR) {
    this.QUO_VOL_CONTR = QUO_VOL_CONTR;
  }

  public BigDecimal getQUO_VOL_CONTR() {
    return QUO_VOL_CONTR;
  }

  public void setQUO_TOT_CONTR(BigDecimal QUO_TOT_CONTR) {
    this.QUO_TOT_CONTR = QUO_TOT_CONTR;
  }

  public BigDecimal getQUO_TOT_CONTR() {
    return QUO_TOT_CONTR;
  }

  public void setQUO_TOT_SALARIES(BigDecimal QUO_TOT_SALARIES) {
    this.QUO_TOT_SALARIES = QUO_TOT_SALARIES;
  }

  public BigDecimal getQUO_TOT_SALARIES() {
    return QUO_TOT_SALARIES;
  }

  public void setQUO_EMPYER_CONTR_RATE(BigDecimal QUO_EMPYER_CONTR_RATE) {
    this.QUO_EMPYER_CONTR_RATE = QUO_EMPYER_CONTR_RATE;
  }

  public BigDecimal getQUO_EMPYER_CONTR_RATE() {
    return QUO_EMPYER_CONTR_RATE;
  }

  public void setQUO_EMPYEE_CONTR_RATE(BigDecimal QUO_EMPYEE_CONTR_RATE) {
    this.QUO_EMPYEE_CONTR_RATE = QUO_EMPYEE_CONTR_RATE;
  }

  public BigDecimal getQUO_EMPYEE_CONTR_RATE() {
    return QUO_EMPYEE_CONTR_RATE;
  }

  public void setQUO_GUARANT_PRD(BigDecimal QUO_GUARANT_PRD) {
    this.QUO_GUARANT_PRD = QUO_GUARANT_PRD;
  }

  public BigDecimal getQUO_GUARANT_PRD() {
    return QUO_GUARANT_PRD;
  }

  public void setQUO_EMPLOYER_VOL_CONTR(BigDecimal QUO_EMPLOYER_VOL_CONTR) {
    this.QUO_EMPLOYER_VOL_CONTR = QUO_EMPLOYER_VOL_CONTR;
  }

  public BigDecimal getQUO_EMPLOYER_VOL_CONTR() {
    return QUO_EMPLOYER_VOL_CONTR;
  }

  public void setQUO_EMPLOYEE_VOL_CONTR(BigDecimal QUO_EMPLOYEE_VOL_CONTR) {
    this.QUO_EMPLOYEE_VOL_CONTR = QUO_EMPLOYEE_VOL_CONTR;
  }

  public BigDecimal getQUO_EMPLOYEE_VOL_CONTR() {
    return QUO_EMPLOYEE_VOL_CONTR;
  }

  public void setQUO_PENS_INT_RATE(BigDecimal QUO_PENS_INT_RATE) {
    this.QUO_PENS_INT_RATE = QUO_PENS_INT_RATE;
  }

  public BigDecimal getQUO_PENS_INT_RATE() {
    return QUO_PENS_INT_RATE;
  }

  public void setQUO_PENS_ESC(BigDecimal QUO_PENS_ESC) {
    this.QUO_PENS_ESC = QUO_PENS_ESC;
  }

  public BigDecimal getQUO_PENS_ESC() {
    return QUO_PENS_ESC;
  }

  public void setGCO_DESC(String GCO_DESC) {
    this.GCO_DESC = GCO_DESC;
  }

  public String getGCO_DESC() {
    return GCO_DESC;
  }

  public void setHAZARD(String HAZARD) {
    this.HAZARD = HAZARD;
  }

  public String getHAZARD() {
    return HAZARD;
  }

  public void setQuo_avg_int(BigDecimal quo_avg_int) {
    this.quo_avg_int = quo_avg_int;
  }

  public BigDecimal getQuo_avg_int() {
    return quo_avg_int;
  }

  public void setQUO_COVER_DEPENDANTS(String QUO_COVER_DEPENDANTS) {
    this.QUO_COVER_DEPENDANTS = QUO_COVER_DEPENDANTS;
  }

  public String getQUO_COVER_DEPENDANTS() {
    return QUO_COVER_DEPENDANTS;
  }

  public void setQUO_MALE_NRD(BigDecimal QUO_MALE_NRD) {
    this.QUO_MALE_NRD = QUO_MALE_NRD;
  }

  public BigDecimal getQUO_MALE_NRD() {
    return QUO_MALE_NRD;
  }

  public void setQUO_FEMALE_NRD(BigDecimal QUO_FEMALE_NRD) {
    this.QUO_FEMALE_NRD = QUO_FEMALE_NRD;
  }

  public BigDecimal getQUO_FEMALE_NRD() {
    return QUO_FEMALE_NRD;
  }

  public void setQUO_EARN_ESCALATION(BigDecimal QUO_EARN_ESCALATION) {
    this.QUO_EARN_ESCALATION = QUO_EARN_ESCALATION;
  }

  public BigDecimal getQUO_EARN_ESCALATION() {
    return QUO_EARN_ESCALATION;
  }

  public void setQUO_FNDING_RATE(BigDecimal QUO_FNDING_RATE) {
    this.QUO_FNDING_RATE = QUO_FNDING_RATE;
  }

  public BigDecimal getQUO_FNDING_RATE() {
    return QUO_FNDING_RATE;
  }

  public void setQUO_FEATURES(String QUO_FEATURES) {
    this.QUO_FEATURES = QUO_FEATURES;
  }

  public String getQUO_FEATURES() {
    return QUO_FEATURES;
  }

  public void setQUO_LETTER_OPENING_REMARKS(String QUO_LETTER_OPENING_REMARKS) {
    this.QUO_LETTER_OPENING_REMARKS = QUO_LETTER_OPENING_REMARKS;
  }

  public String getQUO_LETTER_OPENING_REMARKS() {
    return QUO_LETTER_OPENING_REMARKS;
  }

  public void setQUO_LETTER_CLOSING_REMARKS(String QUO_LETTER_CLOSING_REMARKS) {
    this.QUO_LETTER_CLOSING_REMARKS = QUO_LETTER_CLOSING_REMARKS;
  }

  public String getQUO_LETTER_CLOSING_REMARKS() {
    return QUO_LETTER_CLOSING_REMARKS;
  }

  public void setQUO_CLA_SHT_DESC(String QUO_CLA_SHT_DESC) {
    this.QUO_CLA_SHT_DESC = QUO_CLA_SHT_DESC;
  }

  public String getQUO_CLA_SHT_DESC() {
    return QUO_CLA_SHT_DESC;
  }

  public void setQtax_code(BigDecimal qtax_code) {
    this.qtax_code = qtax_code;
  }

  public BigDecimal getQtax_code() {
    return qtax_code;
  }

  public void setQtax_rate(String qtax_rate) {
    this.qtax_rate = qtax_rate;
  }

  public String getQtax_rate() {
    return qtax_rate;
  }

  public void setQtax_tax_amt(BigDecimal qtax_tax_amt) {
    this.qtax_tax_amt = qtax_tax_amt;
  }

  public BigDecimal getQtax_tax_amt() {
    return qtax_tax_amt;
  }

  public void setTt_desc(String tt_desc) {
    this.tt_desc = tt_desc;
  }

  public String getTt_desc() {
    return tt_desc;
  }

  public void setQtax_rate_desc(String qtax_rate_desc) {
    this.qtax_rate_desc = qtax_rate_desc;
  }

  public String getQtax_rate_desc() {
    return qtax_rate_desc;
  }

    public void setQUO_FCL_CALC_TYPE(String QUO_FCL_CALC_TYPE) {
        this.QUO_FCL_CALC_TYPE = QUO_FCL_CALC_TYPE;
    }

    public String getQUO_FCL_CALC_TYPE() {
        return QUO_FCL_CALC_TYPE;
    }

    public void setQTAX_RATE_TYPE(String QTAX_RATE_TYPE) {
        this.QTAX_RATE_TYPE = QTAX_RATE_TYPE;
    }

    public String getQTAX_RATE_TYPE() {
        return QTAX_RATE_TYPE;
    }

    public void setPROP_CODE(BigDecimal PROP_CODE) {
        this.PROP_CODE = PROP_CODE;
    }

    public BigDecimal getPROP_CODE() {
        return PROP_CODE;
    }

    public void setCALC_TYPE_DESC(String CALC_TYPE_DESC) {
        this.CALC_TYPE_DESC = CALC_TYPE_DESC;
    }

    public String getCALC_TYPE_DESC() {
        return CALC_TYPE_DESC;
    }

    public void setQUO_NOF_MEMBERS(String QUO_NOF_MEMBERS) {
        this.QUO_NOF_MEMBERS = QUO_NOF_MEMBERS;
    }

    public String getQUO_NOF_MEMBERS() {
        return QUO_NOF_MEMBERS;
    }

    public void setFreq_of_payment_disp(String freq_of_payment_disp) {
        this.freq_of_payment_disp = freq_of_payment_disp;
    }

    public String getFreq_of_payment_disp() {
        return freq_of_payment_disp;
    }

    public void setEMPYE_PA(BigDecimal EMPYE_PA) {
        this.EMPYE_PA = EMPYE_PA;
    }

    public BigDecimal getEMPYE_PA() {
        return EMPYE_PA;
    }

    public void setEMYR_PA(BigDecimal EMYR_PA) {
        this.EMYR_PA = EMYR_PA;
    }

    public BigDecimal getEMYR_PA() {
        return EMYR_PA;
    }

    public void setQUO_UNIT_RATE_FORMULA(String QUO_UNIT_RATE_FORMULA) {
        this.QUO_UNIT_RATE_FORMULA = QUO_UNIT_RATE_FORMULA;
    }

    public String getQUO_UNIT_RATE_FORMULA() {
        return QUO_UNIT_RATE_FORMULA;
    }

    public void setQUO_ANN_AMOUNT(BigDecimal QUO_ANN_AMOUNT) {
        this.QUO_ANN_AMOUNT = QUO_ANN_AMOUNT;
    }

    public BigDecimal getQUO_ANN_AMOUNT() {
        return QUO_ANN_AMOUNT;
    }

    public void setAnnType(String annType) {
        this.annType = annType;
    }

    public String getAnnType() {
        return annType;
    }

    public void setAnnOption(String annOption) {
        this.annOption = annOption;
    }

    public String getAnnOption() {
        return annOption;
    }

    public void setAnnEscalation(String annEscalation) {
        this.annEscalation = annEscalation;
    }

    public String getAnnEscalation() {
        return annEscalation;
    }

    public void setQUO_ANN_INVESTMENT_RATE(BigDecimal QUO_ANN_INVESTMENT_RATE) {
        this.QUO_ANN_INVESTMENT_RATE = QUO_ANN_INVESTMENT_RATE;
    }

    public BigDecimal getQUO_ANN_INVESTMENT_RATE() {
        return QUO_ANN_INVESTMENT_RATE;
    }

    public void setQUO_ANN_TERMINAL_PAYOUT_RATE(BigDecimal QUO_ANN_TERMINAL_PAYOUT_RATE) {
        this.QUO_ANN_TERMINAL_PAYOUT_RATE = QUO_ANN_TERMINAL_PAYOUT_RATE;
    }

    public BigDecimal getQUO_ANN_TERMINAL_PAYOUT_RATE() {
        return QUO_ANN_TERMINAL_PAYOUT_RATE;
    }

    public void setQUO_ANN_ADMIN_CHARGE(BigDecimal QUO_ANN_ADMIN_CHARGE) {
        this.QUO_ANN_ADMIN_CHARGE = QUO_ANN_ADMIN_CHARGE;
    }

    public BigDecimal getQUO_ANN_ADMIN_CHARGE() {
        return QUO_ANN_ADMIN_CHARGE;
    }

    public void setQUO_ANN_INVEST_INTR_RATE(BigDecimal QUO_ANN_INVEST_INTR_RATE) {
        this.QUO_ANN_INVEST_INTR_RATE = QUO_ANN_INVEST_INTR_RATE;
    }

    public BigDecimal getQUO_ANN_INVEST_INTR_RATE() {
        return QUO_ANN_INVEST_INTR_RATE;
    }

    public void setQUO_ANN_SCHEME_LEGAL_AGE(BigDecimal QUO_ANN_SCHEME_LEGAL_AGE) {
        this.QUO_ANN_SCHEME_LEGAL_AGE = QUO_ANN_SCHEME_LEGAL_AGE;
    }

    public BigDecimal getQUO_ANN_SCHEME_LEGAL_AGE() {
        return QUO_ANN_SCHEME_LEGAL_AGE;
    }

    public void setQUO_ANN_INVESTMENT(BigDecimal QUO_ANN_INVESTMENT) {
        this.QUO_ANN_INVESTMENT = QUO_ANN_INVESTMENT;
    }

    public BigDecimal getQUO_ANN_INVESTMENT() {
        return QUO_ANN_INVESTMENT;
    }

    public void setQUO_ANN_TERM_BENEFITS(BigDecimal QUO_ANN_TERM_BENEFITS) {
        this.QUO_ANN_TERM_BENEFITS = QUO_ANN_TERM_BENEFITS;
    }

    public BigDecimal getQUO_ANN_TERM_BENEFITS() {
        return QUO_ANN_TERM_BENEFITS;
    }

    public void setQUO_PAY_METHOD(String QUO_PAY_METHOD) {
        this.QUO_PAY_METHOD = QUO_PAY_METHOD;
    }

    public String getQUO_PAY_METHOD() {
        return QUO_PAY_METHOD;
    }

    public void setQuo_pens_mode(String quo_pens_mode) {
        this.quo_pens_mode = quo_pens_mode;
    }

    public String getQuo_pens_mode() {
        return quo_pens_mode;
    }

    public void setQuo_pens_type(String quo_pens_type) {
        this.quo_pens_type = quo_pens_type;
    }

    public String getQuo_pens_type() {
        return quo_pens_type;
    }

    public void setMARKETER(String MARKETER) {
        this.MARKETER = MARKETER;
    }

    public String getMARKETER() {
        return MARKETER;
    }

    public void setQUO_UMBRELLA(String QUO_UMBRELLA) {
        this.QUO_UMBRELLA = QUO_UMBRELLA;
    }

    public String getQUO_UMBRELLA() {
        return QUO_UMBRELLA;
    }

    public void setQUO_UMBRELLA_DURATION(String QUO_UMBRELLA_DURATION) {
        this.QUO_UMBRELLA_DURATION = QUO_UMBRELLA_DURATION;
    }

    public String getQUO_UMBRELLA_DURATION() {
        return QUO_UMBRELLA_DURATION;
    }

    public void setQUO_UMBRELLADESC(String QUO_UMBRELLADESC) {
        this.QUO_UMBRELLADESC = QUO_UMBRELLADESC;
    }

    public String getQUO_UMBRELLADESC() {
        return QUO_UMBRELLADESC;
    }

    public void setPROD_DESC(String PROD_DESC) {
        this.PROD_DESC = PROD_DESC;
    }

    public String getPROD_DESC() {
        return PROD_DESC;
    }

    public void setLTR_CLM_NO(String LTR_CLM_NO) {
        this.LTR_CLM_NO = LTR_CLM_NO;
    }

    public String getLTR_CLM_NO() {
        return LTR_CLM_NO;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT = CLIENT;
    }

    public String getCLIENT() {
        return CLIENT;
    }

    public void setLTR_POL_POLICY_NO(String LTR_POL_POLICY_NO) {
        this.LTR_POL_POLICY_NO = LTR_POL_POLICY_NO;
    }

    public String getLTR_POL_POLICY_NO() {
        return LTR_POL_POLICY_NO;
    }

    public void setMEMBER_DISP(String MEMBER_DISP) {
        this.MEMBER_DISP = MEMBER_DISP;
    }

    public String getMEMBER_DISP() {
        return MEMBER_DISP;
    }

    public void setLTR_TRANS_NO(BigDecimal LTR_TRANS_NO) {
        this.LTR_TRANS_NO = LTR_TRANS_NO;
    }

    public BigDecimal getLTR_TRANS_NO() {
        return LTR_TRANS_NO;
    }

    public void setLTR_BTR_TRANS_CODE(String LTR_BTR_TRANS_CODE) {
        this.LTR_BTR_TRANS_CODE = LTR_BTR_TRANS_CODE;
    }

    public String getLTR_BTR_TRANS_CODE() {
        return LTR_BTR_TRANS_CODE;
    }

    public void setCLM_CAUS_TYPE(String CLM_CAUS_TYPE) {
        this.CLM_CAUS_TYPE = CLM_CAUS_TYPE;
    }

    public String getCLM_CAUS_TYPE() {
        return CLM_CAUS_TYPE;
    }

    public void setCLM_AUTHORISED(String CLM_AUTHORISED) {
        this.CLM_AUTHORISED = CLM_AUTHORISED;
    }

    public String getCLM_AUTHORISED() {
        return CLM_AUTHORISED;
    }

    public void setCLAIM_STATUS(String CLAIM_STATUS) {
        this.CLAIM_STATUS = CLAIM_STATUS;
    }

    public String getCLAIM_STATUS() {
        return CLAIM_STATUS;
    }

    public void setAMT_CLAIMED(BigDecimal AMT_CLAIMED) {
        this.AMT_CLAIMED = AMT_CLAIMED;
    }

    public BigDecimal getAMT_CLAIMED() {
        return AMT_CLAIMED;
    }

    public void setAMT_TO_PAY(BigDecimal AMT_TO_PAY) {
        this.AMT_TO_PAY = AMT_TO_PAY;
    }

    public BigDecimal getAMT_TO_PAY() {
        return AMT_TO_PAY;
    }

    public void setCvt_desc(String cvt_desc) {
        this.cvt_desc = cvt_desc;
    }

    public String getCvt_desc() {
        return cvt_desc;
    }

    public void setPtx_appl_level(String ptx_appl_level) {
        this.ptx_appl_level = ptx_appl_level;
    }

    public String getPtx_appl_level() {
        return ptx_appl_level;
    }

    public void setQUO_LOSS_RATIO(BigDecimal QUO_LOSS_RATIO) {
        this.QUO_LOSS_RATIO = QUO_LOSS_RATIO;
    }

    public BigDecimal getQUO_LOSS_RATIO() {
        return QUO_LOSS_RATIO;
    }

    public void setQUO_UNIT_RATE(BigDecimal QUO_UNIT_RATE) {
        this.QUO_UNIT_RATE = QUO_UNIT_RATE;
    }

    public BigDecimal getQUO_UNIT_RATE() {
        return QUO_UNIT_RATE;
    }

    public void setQUO_HIST_PENS_INT_RATE(BigDecimal QUO_HIST_PENS_INT_RATE) {
        this.QUO_HIST_PENS_INT_RATE = QUO_HIST_PENS_INT_RATE;
    }

    public BigDecimal getQUO_HIST_PENS_INT_RATE() {
        return QUO_HIST_PENS_INT_RATE;
    }

    public void setQUO_CUR_SYMBOL(String QUO_CUR_SYMBOL) {
        this.QUO_CUR_SYMBOL = QUO_CUR_SYMBOL;
    }

    public String getQUO_CUR_SYMBOL() {
        return QUO_CUR_SYMBOL;
    }

    public void setQUO_CURR_RATE_TYPE(String QUO_CURR_RATE_TYPE) {
        this.QUO_CURR_RATE_TYPE = QUO_CURR_RATE_TYPE;
    }

    public String getQUO_CURR_RATE_TYPE() {
        return QUO_CURR_RATE_TYPE;
    }

    public void setQUO_CUR_RATE(BigDecimal QUO_CUR_RATE) {
        this.QUO_CUR_RATE = QUO_CUR_RATE;
    }

    public BigDecimal getQUO_CUR_RATE() {
        return QUO_CUR_RATE;
    }

    public void setQUO_TENDER(String QUO_TENDER) {
        this.QUO_TENDER = QUO_TENDER;
    }

    public String getQUO_TENDER() {
        return QUO_TENDER;
    }

    public void setQUO_AVG_EARNINGS(BigDecimal QUO_AVG_EARNINGS) {
        this.QUO_AVG_EARNINGS = QUO_AVG_EARNINGS;
    }

    public BigDecimal getQUO_AVG_EARNINGS() {
        return QUO_AVG_EARNINGS;
    }

    public void setQUO_TOT_CLAIM_PAID(BigDecimal QUO_TOT_CLAIM_PAID) {
        this.QUO_TOT_CLAIM_PAID = QUO_TOT_CLAIM_PAID;
    }

    public BigDecimal getQUO_TOT_CLAIM_PAID() {
        return QUO_TOT_CLAIM_PAID;
    }

    public void setQUO_TOT_PREM_PAID(BigDecimal QUO_TOT_PREM_PAID) {
        this.QUO_TOT_PREM_PAID = QUO_TOT_PREM_PAID;
    }

    public BigDecimal getQUO_TOT_PREM_PAID() {
        return QUO_TOT_PREM_PAID;
    }

    public void setQUO_PRD_TYPE(String QUO_PRD_TYPE) {
        this.QUO_PRD_TYPE = QUO_PRD_TYPE;
    }

    public String getQUO_PRD_TYPE() {
        return QUO_PRD_TYPE;
    }

    public void setQUO_CLM_EXP_RATE(BigDecimal QUO_CLM_EXP_RATE) {
        this.QUO_CLM_EXP_RATE = QUO_CLM_EXP_RATE;
    }

    public BigDecimal getQUO_CLM_EXP_RATE() {
        return QUO_CLM_EXP_RATE;
    }

    public void setQUO_PRP_CODE(BigDecimal QUO_PRP_CODE) {
        this.QUO_PRP_CODE = QUO_PRP_CODE;
    }

    public BigDecimal getQUO_PRP_CODE() {
        return QUO_PRP_CODE;
    }

    public void setQUO_TENDER_PRD(BigDecimal QUO_TENDER_PRD) {
        this.QUO_TENDER_PRD = QUO_TENDER_PRD;
    }

    public BigDecimal getQUO_TENDER_PRD() {
        return QUO_TENDER_PRD;
    }

    public void setQUO_ASSIGNEE_NAME(String QUO_ASSIGNEE_NAME) {
        this.QUO_ASSIGNEE_NAME = QUO_ASSIGNEE_NAME;
    }

    public String getQUO_ASSIGNEE_NAME() {
        return QUO_ASSIGNEE_NAME;
    }

    public void setQUO_ASSIGNEE_PHY_ADDR(String QUO_ASSIGNEE_PHY_ADDR) {
        this.QUO_ASSIGNEE_PHY_ADDR = QUO_ASSIGNEE_PHY_ADDR;
    }

    public String getQUO_ASSIGNEE_PHY_ADDR() {
        return QUO_ASSIGNEE_PHY_ADDR;
    }

    public void setTax_plan(String tax_plan) {
        this.tax_plan = tax_plan;
    }

    public String getTax_plan() {
        return tax_plan;
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
}
