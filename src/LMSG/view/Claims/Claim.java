package LMSG.view.Claims;

import java.math.BigDecimal;
import java.util.Date;

public class Claim
{
  private String CCVT_DESC;
  private BigDecimal POLM_CODE;
  private String polm_mem_no;
  private String Client;
  private BigDecimal MEM_CODE;
  private BigDecimal POL_CODE;
  private BigDecimal CDL_LDL_CODE;
  private BigDecimal ccvt_pct_code;
  private BigDecimal PMPNS_EMPYR_RETIRE_HELD_PCT;
  private String clm_death_location;
  private String cpv_authorised;
  private String cpv_ltr_btr_trans_code;
  private String CLM_EXGRATIA;
  private String CLM_EXGRATIA_REMARKS;
  private String MEM_SURNAME;
  private String MEM_OTHER_NAMES;
  private String MEM_IDENTITY_NO;
  private Date MEM_DOB;
  private String MEM_SEX;
  private Date MEM_SCHEDULE_JOIN_DATE;
  private String CLM_PAY_TOT_COINS_AMT;
  private BigDecimal ccvt_saving_amt;
  private BigDecimal ccvt_original_loan_amt;
  private BigDecimal ccvt_orig_loan_repayment_prd;
  private String AGN_NAME;
  private BigDecimal CCR_CODE;
  private BigDecimal CCR_POLM_CODE;
  private BigDecimal CCR_PCOIN_SHARE_PCT;
  private BigDecimal CCR_PCOIN_AGN_CODE;
  private BigDecimal CCR_CLM_AMT_TO_PAY;
  private BigDecimal CCR_AMT_PAID;
  private BigDecimal CCR_BALANCE;
  private String CCR_AUTHORISED;
  private String CCR_AUTHORISED_BY;
  private String CCR_PREPARED_BY;
  private String CCR_PAID;
  private String CLM_PAY_TOT_COINS_DISP;
  private BigDecimal MPT_CODE;
  private BigDecimal MPT_MIN_AMT_ALLOWED;
  private BigDecimal MPT_MAX_AMT_ALLOWED;
  private String MPT_SHT_DESC;
  private String MPT_DESC;
  private BigDecimal TT_CODE;
  private String TT_SHT_DESC;
  private String TT_DESC;
  private String TRT_RATE_TYPE;
  private BigDecimal PPTX_CODE;
  private BigDecimal PPTX_RATE;
  private BigDecimal PPTX_TAX_AMT;
  private BigDecimal PPTX_TT_CODE;
  private String PPTX_RATE_TYPE;
  private Boolean selected;
  private BigDecimal PRP_CODE;
  private BigDecimal PRP_CLNT_CODE;
  private String PMPNS_ANN_PAY_FREQ;
  private String MEMBERNAME;
  private Date LTR_EFFECTIVE_DATE;
  private String PMPNS_PAYEE_NAME;
  private String PMPNS_PAYEE_PIN;
  private BigDecimal CAUS_CODE;
  private String CAUS_SHT_DESC;
  private String CAUS_DESC;
  private String CAUS_TYPE;
  private BigDecimal CSC_CODE;
  private BigDecimal DDC_CODE;
  private String DDC_SHT_DESC;
  private String DDC_DESC;
  private String LTR_CLM_NO;
  private String LTR_CLIENT;
  private String LTR_POL_POLICY_NO;
  private String LTR_MEMBER_DISP;
  private BigDecimal LTR_TRANS_NO;
  private String LTR_BTR_TRANS_CODE;
  private String LTR_MEM_NO;
  private String LTR_DONE_BY;
  private BigDecimal LTR_MEM_CODE;
  private String LTR_CLM_CAUS_TYPE;
  private BigDecimal LTR_POLM_CODE;
  private BigDecimal LTR_POL_CODE;
  private String CCVT_PAY_ORGANIZATION;
  private BigDecimal CFA_CODE;
  private String ACT_ACTIVITY;
  private String CFA_FEE;
  private String CFA_PAY_DATE;
  private String CFA_REMARKS;
  private String CFA_PAID;
  private String RD_DESC;
  private String MCD_RD_SHT_DESC;
  private String MCD_IS_DOC_SUBMITTED;
  private String MCD_DATE_GIVEN;
  private Date MCD_DATE_GIVEN1;
  private String MCD_DOC_NO;
  private BigDecimal MCD_CODE;
  private BigDecimal CTRTC_CODE;
  private String REI_TRT_SHT_DESC;
  private String CTRTC_RATE;
  private BigDecimal CTRCC_CODE;
  private String CTRCC_AGN_NAME;
  private String CTRCC_REI_TRT_SHT_DESC;
  private String CTRCC_CEDE_RATE;
  private String RC_CLM_NO;
  private String RC_POL_POLICY_NO;
  private String RC_MEM_DISPL;
  private BigDecimal RC_POL_CODE;
  private BigDecimal RC_CLM_POLM_CODE;
  private BigDecimal RC_CLM_MEM_CODE;
  private BigDecimal CPV_VOUCHER_NO;
  private BigDecimal CPV_AMOUNT;
  private String CPV_PAYEE;
  private String CPV_DRCR_NO;
  private String CLM_NO;
  private String CLM_STATUS;
  private String CLM_MEM_NO;
  private String CLM_MEMBER_DISPLAY;
  private String CLM_DEATH_DISABILITY_AGE;
  private Date CLM_DATE_CLAIM_REPORTED;
  private Date CLM_DATE_DEATH_ACCIDENT;
  private String CLM_CAUS_DESC;
  private String CLM_CAUS_TYPE;
  private BigDecimal CLM_CLM_DDC_CODE;
  private String CLM_DDC_DESC;
  private BigDecimal CLM_RESERVE_AMT;
  private BigDecimal CLM_RETENTION_PCT;
  private String CLM_REMARKS;
  private BigDecimal CLM_AMT_CLAIMED;
  private BigDecimal CLM_AMT_TO_PAY;
  private BigDecimal CLM_PAID_AMT;
  private BigDecimal CLM_RI_TOT_AMT;
  private BigDecimal CLM_PENS_AMT_TO_PAY;
  private BigDecimal CLM_PENS_PAID_AMT;
  private String CLM_WITHIN_SYSTEM;
  private Date CLM_DATE;
  private BigDecimal CLM_GROSS_RET_AMT;
  private BigDecimal CLM_RETETION_AMT;
  private BigDecimal CLM_RECOVERY_AMT;
  private BigDecimal CLM_RECOVERED_AMT;
  private BigDecimal CLM_OUTSTAND_PREM;
  private BigDecimal CLM_BATCH_NO;
  private String CLM_PAY_INSTALMNTS;
  private String CLM_INST_PAY_FREQ;
  private BigDecimal CLM_NOF_INST;
  private Date CLM_LOAN_ISSUE_DATE;
  private BigDecimal CLM_LOAN_INST_AMT;
  private BigDecimal CCVT_CODE;
  private String CVT_DESC;
  private String CCVT_MULT_EARNINGS_PRD;
  private BigDecimal CCVT_EARNINGS;
  private BigDecimal CCVT_SA;
  private BigDecimal CCVT_PAYABLE_AMT;
  private BigDecimal CCVT_AMT_CLAIMED;
  private BigDecimal CCVT_AMT_TO_BE_PAID;
  private BigDecimal CCVT_BUT_PAY_AMT;
  private BigDecimal CCVT_PAID_AMT;
  private String CCVT_REMARKS;
  private String CCVT_PAID;
  private String CCVT_PAYEE;
  private BigDecimal cpvVouvherNo;
  private Date cpvDate;
  private BigDecimal cpvAmount;
  private String cpvPayee;
  private String cpvTransType;
  private BigDecimal cpvLoanAmt;
  private BigDecimal cpvPremAmt;
  private String cpvStatus;
  private BigDecimal cpvPenaltyAmt;
  private BigDecimal cpvSarAmt;
  private BigDecimal cpvBoSpreadAmt;
  private String cpv_payment_mode;
  private String cpv_bbr_acc_no;
  private BigDecimal grossVoucherAmt;
  private String bankAccNo;
  private BigDecimal beneficiaryCode;
  private BigDecimal bankBranchCode;
  private String cvtDesc;
  private Date cpvdDate;
  private BigDecimal cpvdAmount;
  private String cpvMftProvider;
  private String cpvAccNo;
  private String reiTrtShtDesc;
  private BigDecimal coritdCessionRate;
  private BigDecimal coritdAmount;
  private String coriptAgenShtDesc;
  private BigDecimal coriptCessionRate;
  private BigDecimal coriptAmount;
  private BigDecimal PMPNS_EMPYR_PENS_BF;
  private BigDecimal PMPNS_EMPYE_PENS_BF;
  private BigDecimal PMPNS_TOT_PENS_BF;
  private BigDecimal PMPNS_EARNINGS;
  private BigDecimal PMPNS_EMPLOYEE_CONTR;
  private BigDecimal PMPNS_EMPLOYER_CONTR;
  private BigDecimal PMPNS_EMPLYE_VOLU_CONTR;
  private BigDecimal PMPNS_TOTAL_CONTR;
  private BigDecimal PMPNS_NET_ANNUAL_FUND;
  private BigDecimal PMPNS_COMP_INT_RATE;
  private BigDecimal PMPNS_ANNTY_FAC_RATE;
  private BigDecimal PMPNS_PENS_ANNUM;
  private BigDecimal PMPNS_EST_MAT_VAL;
  private Date PMPNS_DATE_JOINED;
  private BigDecimal PMPNS_EMPYR_BAL_BF;
  private BigDecimal PMPNS_EMPYE_BAL_BF;
  private BigDecimal PMPNS_VOL_BF;
  private Date PMPNS_WET_DATE;
  private String PMPNS_SERVICE_YRS;
  private BigDecimal PMPNS_EMPYR_YR_TOT_CONTR;
  private BigDecimal PMPNS_EMPYE_YR_TOT_CONTR;
  private BigDecimal PMPNS_PENS_INTEREST_PCT;
  private BigDecimal PMPNS_EMPYR_CUR_YR_INCOME;
  private BigDecimal PMPNS_EMPYE_CUR_YR_INCOME;
  private BigDecimal PMPNS_VESTING_PCT;
  private BigDecimal PMPNS_EMPYR_PENS_FUND;
  private BigDecimal PMPNS_GROSS_PAYABLE;
  private BigDecimal PMPNS_EMPYR_RETIRE_HELD;
  private String PMPNS_TAX_EXEMPT;
  private BigDecimal PMPNS_TAXABLE_AMT;
  private BigDecimal PMPNS_TAX_PAYABLE;
  private BigDecimal PMPNS_NET_PAYABLE;
  private String PMPNS_PAYEE;
  private BigDecimal PMPNS_RFUND_AMOUNT;
  private String PMPNS_RFUND_INTERST_RATE;
  private BigDecimal PMPNS_RFUND_INTERST_AMT;
  private BigDecimal PMPNS_RFUND_TAX_EXEMPT;
  private BigDecimal PMPNS_RFUND_TAXABLE_AMT;
  private BigDecimal PMPNS_RFUND_NET_PAYABLE;
  private BigDecimal PMPNS_CODE;
  private Date PMPNS_WEF_DATE;
  private String CPV_DISP_STATUS_DISP;
  private String CPV_DISCHARGE_STATUS;
  private BigDecimal QEXC_CODE;
  private BigDecimal QEXC_POL_QUOT_CODE;
  private String QEXC_AUTHORISED;
  private String QEXC_DESC;
  private BigDecimal ldlCode;
  private BigDecimal ldlPercentPayable;
  private String closePolicy;
  private String closePolicyDesc;
  private String ldlDesc;
  private String ldlWeeklyIndemnity;
  private BigDecimal cdlCode;
  private String ldldesc;
  private BigDecimal CDL_PERC_PAYABLE;
  private String CDL_NOF_LOSS_DAYS;
  private BigDecimal cdlClmAmt;
  private BigDecimal BPY_CODE;
  private String BPY_NAME;
  private BigDecimal BPY_AMOUNT;
  private Date BPY_PAY_DATE;
  private String BPY_PAID;
  private String BPY_PAID_DISPLAY;
  private String BPY_PAY_TERM;
  private String BPY_CLASS;
  private String BPY_VOUCHER_NO;
  private BigDecimal PCY_CODE;
  private Date PCY_PAY_DATE;
  private BigDecimal PCY_POL_CODE;
  private String PCY_POL_POLICY_NO;
  private String PCY_CLM_NO;
  private String PCY_PAID;
  private String PCY_PAYEE;
  private BigDecimal PCY_AMOUNT;
  private String PCY_VOUCHER_NO;
  private BigDecimal PCY_POLM_CODE;
  private BigDecimal PABP_CODE;
  private String PABP_NO;
  private String PAB_SURNAME;
  private String PAB_OTHERNAMES;
  private Date PABP_DATE_DUE;
  private BigDecimal PABP_AMOUNT;
  private String PABP_PAID;
  private Date PABP_PAID_DATE;
  private String PABP_VOUCHER_NO;
  private String MEM_NO_DISP;
  private String MEM_NAME_DISP;
  private Date CPV_DATE;
  private BigDecimal MCLM_CODE;
  private Date MCLM_DATE_DEATH_ACCIDENT;
  private Date MCLM_DATE_CLAIM_REPORTED;
  private BigDecimal BBR_CODE;
  private String BBR_BRANCH_NAME;
  private BigDecimal CCVT_PAY_INST;
  private BigDecimal CCVT_INT_SAVING_AMT;
  private String CCVT_CVT_OCC_BEN;
  private BigDecimal CCVT_OCC_BEN_RATE;
  private BigDecimal CLM_HOSP_DAYS;
  private String CPV_PAYEE_TEL;
  private BigDecimal cipgCode;
  private BigDecimal cipgAmount;
  private BigDecimal cipgVoucherNo;
  private String cipgPaid;
  private String cipgPayDate;
  private String cipgInstPayFreq;
  private BigDecimal CRM_CODE;
  private String CRM_REMARKS;
  private String CRM_REMARK_TYPE;
  private String CRM_REMARKS_BY;
  private Date CRM_REMARKS_DATE;
  private String REMARKS_DESC;
  private String bankBranchName;
  private Date PMPNS_DATE_EMPLOYED;
  private Date POLM_DATE_JOINED;
  private Date DOB;
  private String KRAPIN;
  private BigDecimal PMPNS_OVERRIDE_TAX_EXEMPT;
  public void setPOLM_CODE(BigDecimal POLM_CODE)
  {
    this.POLM_CODE = POLM_CODE;
  }
  
  public BigDecimal getPOLM_CODE()
  {
    return this.POLM_CODE;
  }
  
  public void setPolm_mem_no(String polm_mem_no)
  {
    this.polm_mem_no = polm_mem_no;
  }
  
  public String getPolm_mem_no()
  {
    return this.polm_mem_no;
  }
  
  public void setClient(String Client)
  {
    this.Client = Client;
  }
  
  public String getClient()
  {
    return this.Client;
  }
  
  public void setMEM_CODE(BigDecimal MEM_CODE)
  {
    this.MEM_CODE = MEM_CODE;
  }
  
  public BigDecimal getMEM_CODE()
  {
    return this.MEM_CODE;
  }
  
  public void setCAUS_CODE(BigDecimal CAUS_CODE)
  {
    this.CAUS_CODE = CAUS_CODE;
  }
  
  public BigDecimal getCAUS_CODE()
  {
    return this.CAUS_CODE;
  }
  
  public void setCAUS_SHT_DESC(String CAUS_SHT_DESC)
  {
    this.CAUS_SHT_DESC = CAUS_SHT_DESC;
  }
  
  public String getCAUS_SHT_DESC()
  {
    return this.CAUS_SHT_DESC;
  }
  
  public void setCAUS_DESC(String CAUS_DESC)
  {
    this.CAUS_DESC = CAUS_DESC;
  }
  
  public String getCAUS_DESC()
  {
    return this.CAUS_DESC;
  }
  
  public void setCAUS_TYPE(String CAUS_TYPE)
  {
    this.CAUS_TYPE = CAUS_TYPE;
  }
  
  public String getCAUS_TYPE()
  {
    return this.CAUS_TYPE;
  }
  
  public void setCLM_NO(String CLM_NO)
  {
    this.CLM_NO = CLM_NO;
  }
  
  public String getCLM_NO()
  {
    return this.CLM_NO;
  }
  
  public void setCLM_STATUS(String CLM_STATUS)
  {
    this.CLM_STATUS = CLM_STATUS;
  }
  
  public String getCLM_STATUS()
  {
    return this.CLM_STATUS;
  }
  
  public void setCLM_MEMBER_DISPLAY(String CLM_MEMBER_DISPLAY)
  {
    this.CLM_MEMBER_DISPLAY = CLM_MEMBER_DISPLAY;
  }
  
  public String getCLM_MEMBER_DISPLAY()
  {
    return this.CLM_MEMBER_DISPLAY;
  }
  
  public void setCLM_DEATH_DISABILITY_AGE(String CLM_DEATH_DISABILITY_AGE)
  {
    this.CLM_DEATH_DISABILITY_AGE = CLM_DEATH_DISABILITY_AGE;
  }
  
  public String getCLM_DEATH_DISABILITY_AGE()
  {
    return this.CLM_DEATH_DISABILITY_AGE;
  }
  
  public void setCLM_DATE_CLAIM_REPORTED(Date CLM_DATE_CLAIM_REPORTED)
  {
    this.CLM_DATE_CLAIM_REPORTED = CLM_DATE_CLAIM_REPORTED;
  }
  
  public Date getCLM_DATE_CLAIM_REPORTED()
  {
    return this.CLM_DATE_CLAIM_REPORTED;
  }
  
  public void setCLM_DATE_DEATH_ACCIDENT(Date CLM_DATE_DEATH_ACCIDENT)
  {
    this.CLM_DATE_DEATH_ACCIDENT = CLM_DATE_DEATH_ACCIDENT;
  }
  
  public Date getCLM_DATE_DEATH_ACCIDENT()
  {
    return this.CLM_DATE_DEATH_ACCIDENT;
  }
  
  public void setCLM_CAUS_DESC(String CLM_CAUS_DESC)
  {
    this.CLM_CAUS_DESC = CLM_CAUS_DESC;
  }
  
  public String getCLM_CAUS_DESC()
  {
    return this.CLM_CAUS_DESC;
  }
  
  public void setCLM_CAUS_TYPE(String CLM_CAUS_TYPE)
  {
    this.CLM_CAUS_TYPE = CLM_CAUS_TYPE;
  }
  
  public String getCLM_CAUS_TYPE()
  {
    return this.CLM_CAUS_TYPE;
  }
  
  public void setCLM_CLM_DDC_CODE(BigDecimal CLM_CLM_DDC_CODE)
  {
    this.CLM_CLM_DDC_CODE = CLM_CLM_DDC_CODE;
  }
  
  public BigDecimal getCLM_CLM_DDC_CODE()
  {
    return this.CLM_CLM_DDC_CODE;
  }
  
  public void setCLM_DDC_DESC(String CLM_DDC_DESC)
  {
    this.CLM_DDC_DESC = CLM_DDC_DESC;
  }
  
  public String getCLM_DDC_DESC()
  {
    return this.CLM_DDC_DESC;
  }
  
  public void setCLM_RESERVE_AMT(BigDecimal CLM_RESERVE_AMT)
  {
    this.CLM_RESERVE_AMT = CLM_RESERVE_AMT;
  }
  
  public BigDecimal getCLM_RESERVE_AMT()
  {
    return this.CLM_RESERVE_AMT;
  }
  
  public void setCLM_RETENTION_PCT(BigDecimal CLM_RETENTION_PCT)
  {
    this.CLM_RETENTION_PCT = CLM_RETENTION_PCT;
  }
  
  public BigDecimal getCLM_RETENTION_PCT()
  {
    return this.CLM_RETENTION_PCT;
  }
  
  public void setCLM_REMARKS(String CLM_REMARKS)
  {
    this.CLM_REMARKS = CLM_REMARKS;
  }
  
  public String getCLM_REMARKS()
  {
    return this.CLM_REMARKS;
  }
  
  public void setCLM_AMT_CLAIMED(BigDecimal CLM_AMT_CLAIMED)
  {
    this.CLM_AMT_CLAIMED = CLM_AMT_CLAIMED;
  }
  
  public BigDecimal getCLM_AMT_CLAIMED()
  {
    return this.CLM_AMT_CLAIMED;
  }
  
  public void setCLM_AMT_TO_PAY(BigDecimal CLM_AMT_TO_PAY)
  {
    this.CLM_AMT_TO_PAY = CLM_AMT_TO_PAY;
  }
  
  public BigDecimal getCLM_AMT_TO_PAY()
  {
    return this.CLM_AMT_TO_PAY;
  }
  
  public void setCLM_PAID_AMT(BigDecimal CLM_PAID_AMT)
  {
    this.CLM_PAID_AMT = CLM_PAID_AMT;
  }
  
  public BigDecimal getCLM_PAID_AMT()
  {
    return this.CLM_PAID_AMT;
  }
  
  public void setCLM_RI_TOT_AMT(BigDecimal CLM_RI_TOT_AMT)
  {
    this.CLM_RI_TOT_AMT = CLM_RI_TOT_AMT;
  }
  
  public BigDecimal getCLM_RI_TOT_AMT()
  {
    return this.CLM_RI_TOT_AMT;
  }
  
  public void setCLM_PENS_AMT_TO_PAY(BigDecimal CLM_PENS_AMT_TO_PAY)
  {
    this.CLM_PENS_AMT_TO_PAY = CLM_PENS_AMT_TO_PAY;
  }
  
  public BigDecimal getCLM_PENS_AMT_TO_PAY()
  {
    return this.CLM_PENS_AMT_TO_PAY;
  }
  
  public void setCLM_PENS_PAID_AMT(BigDecimal CLM_PENS_PAID_AMT)
  {
    this.CLM_PENS_PAID_AMT = CLM_PENS_PAID_AMT;
  }
  
  public BigDecimal getCLM_PENS_PAID_AMT()
  {
    return this.CLM_PENS_PAID_AMT;
  }
  
  public void setCLM_WITHIN_SYSTEM(String CLM_WITHIN_SYSTEM)
  {
    this.CLM_WITHIN_SYSTEM = CLM_WITHIN_SYSTEM;
  }
  
  public String getCLM_WITHIN_SYSTEM()
  {
    return this.CLM_WITHIN_SYSTEM;
  }
  
  public void setCLM_MEM_NO(String CLM_MEM_NO)
  {
    this.CLM_MEM_NO = CLM_MEM_NO;
  }
  
  public String getCLM_MEM_NO()
  {
    return this.CLM_MEM_NO;
  }
  
  public void setCCVT_CODE(BigDecimal CCVT_CODE)
  {
    this.CCVT_CODE = CCVT_CODE;
  }
  
  public BigDecimal getCCVT_CODE()
  {
    return this.CCVT_CODE;
  }
  
  public void setCVT_DESC(String CVT_DESC)
  {
    this.CVT_DESC = CVT_DESC;
  }
  
  public String getCVT_DESC()
  {
    return this.CVT_DESC;
  }
  
  public void setCCVT_MULT_EARNINGS_PRD(String CCVT_MULT_EARNINGS_PRD)
  {
    this.CCVT_MULT_EARNINGS_PRD = CCVT_MULT_EARNINGS_PRD;
  }
  
  public String getCCVT_MULT_EARNINGS_PRD()
  {
    return this.CCVT_MULT_EARNINGS_PRD;
  }
  
  public void setCCVT_EARNINGS(BigDecimal CCVT_EARNINGS)
  {
    this.CCVT_EARNINGS = CCVT_EARNINGS;
  }
  
  public BigDecimal getCCVT_EARNINGS()
  {
    return this.CCVT_EARNINGS;
  }
  
  public void setCCVT_SA(BigDecimal CCVT_SA)
  {
    this.CCVT_SA = CCVT_SA;
  }
  
  public BigDecimal getCCVT_SA()
  {
    return this.CCVT_SA;
  }
  
  public void setCCVT_PAYABLE_AMT(BigDecimal CCVT_PAYABLE_AMT)
  {
    this.CCVT_PAYABLE_AMT = CCVT_PAYABLE_AMT;
  }
  
  public BigDecimal getCCVT_PAYABLE_AMT()
  {
    return this.CCVT_PAYABLE_AMT;
  }
  
  public void setCCVT_AMT_CLAIMED(BigDecimal CCVT_AMT_CLAIMED)
  {
    this.CCVT_AMT_CLAIMED = CCVT_AMT_CLAIMED;
  }
  
  public BigDecimal getCCVT_AMT_CLAIMED()
  {
    return this.CCVT_AMT_CLAIMED;
  }
  
  public void setCCVT_AMT_TO_BE_PAID(BigDecimal CCVT_AMT_TO_BE_PAID)
  {
    this.CCVT_AMT_TO_BE_PAID = CCVT_AMT_TO_BE_PAID;
  }
  
  public BigDecimal getCCVT_AMT_TO_BE_PAID()
  {
    return this.CCVT_AMT_TO_BE_PAID;
  }
  
  public void setCCVT_BUT_PAY_AMT(BigDecimal CCVT_BUT_PAY_AMT)
  {
    this.CCVT_BUT_PAY_AMT = CCVT_BUT_PAY_AMT;
  }
  
  public BigDecimal getCCVT_BUT_PAY_AMT()
  {
    return this.CCVT_BUT_PAY_AMT;
  }
  
  public void setCCVT_PAID_AMT(BigDecimal CCVT_PAID_AMT)
  {
    this.CCVT_PAID_AMT = CCVT_PAID_AMT;
  }
  
  public BigDecimal getCCVT_PAID_AMT()
  {
    return this.CCVT_PAID_AMT;
  }
  
  public void setCCVT_REMARKS(String CCVT_REMARKS)
  {
    this.CCVT_REMARKS = CCVT_REMARKS;
  }
  
  public String getCCVT_REMARKS()
  {
    return this.CCVT_REMARKS;
  }
  
  public void setCCVT_PAID(String CCVT_PAID)
  {
    this.CCVT_PAID = CCVT_PAID;
  }
  
  public String getCCVT_PAID()
  {
    return this.CCVT_PAID;
  }
  
  public void setCCVT_PAYEE(String CCVT_PAYEE)
  {
    this.CCVT_PAYEE = CCVT_PAYEE;
  }
  
  public String getCCVT_PAYEE()
  {
    return this.CCVT_PAYEE;
  }
  
  public void setCSC_CODE(BigDecimal CSC_CODE)
  {
    this.CSC_CODE = CSC_CODE;
  }
  
  public BigDecimal getCSC_CODE()
  {
    return this.CSC_CODE;
  }
  
  public void setDDC_CODE(BigDecimal DDC_CODE)
  {
    this.DDC_CODE = DDC_CODE;
  }
  
  public BigDecimal getDDC_CODE()
  {
    return this.DDC_CODE;
  }
  
  public void setDDC_SHT_DESC(String DDC_SHT_DESC)
  {
    this.DDC_SHT_DESC = DDC_SHT_DESC;
  }
  
  public String getDDC_SHT_DESC()
  {
    return this.DDC_SHT_DESC;
  }
  
  public void setDDC_DESC(String DDC_DESC)
  {
    this.DDC_DESC = DDC_DESC;
  }
  
  public String getDDC_DESC()
  {
    return this.DDC_DESC;
  }
  
  public void setLTR_CLM_NO(String LTR_CLM_NO)
  {
    this.LTR_CLM_NO = LTR_CLM_NO;
  }
  
  public String getLTR_CLM_NO()
  {
    return this.LTR_CLM_NO;
  }
  
  public void setLTR_CLIENT(String LTR_CLIENT)
  {
    this.LTR_CLIENT = LTR_CLIENT;
  }
  
  public String getLTR_CLIENT()
  {
    return this.LTR_CLIENT;
  }
  
  public void setLTR_POL_POLICY_NO(String LTR_POL_POLICY_NO)
  {
    this.LTR_POL_POLICY_NO = LTR_POL_POLICY_NO;
  }
  
  public String getLTR_POL_POLICY_NO()
  {
    return this.LTR_POL_POLICY_NO;
  }
  
  public void setLTR_MEMBER_DISP(String LTR_MEMBER_DISP)
  {
    this.LTR_MEMBER_DISP = LTR_MEMBER_DISP;
  }
  
  public String getLTR_MEMBER_DISP()
  {
    return this.LTR_MEMBER_DISP;
  }
  
  public void setLTR_TRANS_NO(BigDecimal LTR_TRANS_NO)
  {
    this.LTR_TRANS_NO = LTR_TRANS_NO;
  }
  
  public BigDecimal getLTR_TRANS_NO()
  {
    return this.LTR_TRANS_NO;
  }
  
  public void setLTR_BTR_TRANS_CODE(String LTR_BTR_TRANS_CODE)
  {
    this.LTR_BTR_TRANS_CODE = LTR_BTR_TRANS_CODE;
  }
  
  public String getLTR_BTR_TRANS_CODE()
  {
    return this.LTR_BTR_TRANS_CODE;
  }
  
  public void setLTR_MEM_NO(String LTR_MEM_NO)
  {
    this.LTR_MEM_NO = LTR_MEM_NO;
  }
  
  public String getLTR_MEM_NO()
  {
    return this.LTR_MEM_NO;
  }
  
  public void setLTR_MEM_CODE(BigDecimal LTR_MEM_CODE)
  {
    this.LTR_MEM_CODE = LTR_MEM_CODE;
  }
  
  public BigDecimal getLTR_MEM_CODE()
  {
    return this.LTR_MEM_CODE;
  }
  
  public void setCFA_CODE(BigDecimal CFA_CODE)
  {
    this.CFA_CODE = CFA_CODE;
  }
  
  public BigDecimal getCFA_CODE()
  {
    return this.CFA_CODE;
  }
  
  public void setACT_ACTIVITY(String ACT_ACTIVITY)
  {
    this.ACT_ACTIVITY = ACT_ACTIVITY;
  }
  
  public String getACT_ACTIVITY()
  {
    return this.ACT_ACTIVITY;
  }
  
  public void setCFA_FEE(String CFA_FEE)
  {
    this.CFA_FEE = CFA_FEE;
  }
  
  public String getCFA_FEE()
  {
    return this.CFA_FEE;
  }
  
  public void setCFA_PAY_DATE(String CFA_PAY_DATE)
  {
    this.CFA_PAY_DATE = CFA_PAY_DATE;
  }
  
  public String getCFA_PAY_DATE()
  {
    return this.CFA_PAY_DATE;
  }
  
  public void setCFA_REMARKS(String CFA_REMARKS)
  {
    this.CFA_REMARKS = CFA_REMARKS;
  }
  
  public String getCFA_REMARKS()
  {
    return this.CFA_REMARKS;
  }
  
  public void setCFA_PAID(String CFA_PAID)
  {
    this.CFA_PAID = CFA_PAID;
  }
  
  public String getCFA_PAID()
  {
    return this.CFA_PAID;
  }
  
  public void setRD_DESC(String RD_DESC)
  {
    this.RD_DESC = RD_DESC;
  }
  
  public String getRD_DESC()
  {
    return this.RD_DESC;
  }
  
  public void setMCD_RD_SHT_DESC(String MCD_RD_SHT_DESC)
  {
    this.MCD_RD_SHT_DESC = MCD_RD_SHT_DESC;
  }
  
  public String getMCD_RD_SHT_DESC()
  {
    return this.MCD_RD_SHT_DESC;
  }
  
  public void setMCD_IS_DOC_SUBMITTED(String MCD_IS_DOC_SUBMITTED)
  {
    this.MCD_IS_DOC_SUBMITTED = MCD_IS_DOC_SUBMITTED;
  }
  
  public String getMCD_IS_DOC_SUBMITTED()
  {
    return this.MCD_IS_DOC_SUBMITTED;
  }
  
  public void setMCD_DATE_GIVEN(String MCD_DATE_GIVEN)
  {
    this.MCD_DATE_GIVEN = MCD_DATE_GIVEN;
  }
  
  public String getMCD_DATE_GIVEN()
  {
    return this.MCD_DATE_GIVEN;
  }
  
  public void setMCD_DOC_NO(String MCD_DOC_NO)
  {
    this.MCD_DOC_NO = MCD_DOC_NO;
  }
  
  public String getMCD_DOC_NO()
  {
    return this.MCD_DOC_NO;
  }
  
  public void setLTR_CLM_CAUS_TYPE(String LTR_CLM_CAUS_TYPE)
  {
    this.LTR_CLM_CAUS_TYPE = LTR_CLM_CAUS_TYPE;
  }
  
  public String getLTR_CLM_CAUS_TYPE()
  {
    return this.LTR_CLM_CAUS_TYPE;
  }
  
  public void setCTRTC_CODE(BigDecimal CTRTC_CODE)
  {
    this.CTRTC_CODE = CTRTC_CODE;
  }
  
  public BigDecimal getCTRTC_CODE()
  {
    return this.CTRTC_CODE;
  }
  
  public void setREI_TRT_SHT_DESC(String REI_TRT_SHT_DESC)
  {
    this.REI_TRT_SHT_DESC = REI_TRT_SHT_DESC;
  }
  
  public String getREI_TRT_SHT_DESC()
  {
    return this.REI_TRT_SHT_DESC;
  }
  
  public void setCTRTC_RATE(String CTRTC_RATE)
  {
    this.CTRTC_RATE = CTRTC_RATE;
  }
  
  public String getCTRTC_RATE()
  {
    return this.CTRTC_RATE;
  }
  
  public void setCTRCC_CODE(BigDecimal CTRCC_CODE)
  {
    this.CTRCC_CODE = CTRCC_CODE;
  }
  
  public BigDecimal getCTRCC_CODE()
  {
    return this.CTRCC_CODE;
  }
  
  public void setCTRCC_AGN_NAME(String CTRCC_AGN_NAME)
  {
    this.CTRCC_AGN_NAME = CTRCC_AGN_NAME;
  }
  
  public String getCTRCC_AGN_NAME()
  {
    return this.CTRCC_AGN_NAME;
  }
  
  public void setCTRCC_REI_TRT_SHT_DESC(String CTRCC_REI_TRT_SHT_DESC)
  {
    this.CTRCC_REI_TRT_SHT_DESC = CTRCC_REI_TRT_SHT_DESC;
  }
  
  public String getCTRCC_REI_TRT_SHT_DESC()
  {
    return this.CTRCC_REI_TRT_SHT_DESC;
  }
  
  public void setCTRCC_CEDE_RATE(String CTRCC_CEDE_RATE)
  {
    this.CTRCC_CEDE_RATE = CTRCC_CEDE_RATE;
  }
  
  public String getCTRCC_CEDE_RATE()
  {
    return this.CTRCC_CEDE_RATE;
  }
  
  public void setRC_CLM_NO(String RC_CLM_NO)
  {
    this.RC_CLM_NO = RC_CLM_NO;
  }
  
  public String getRC_CLM_NO()
  {
    return this.RC_CLM_NO;
  }
  
  public void setRC_POL_POLICY_NO(String RC_POL_POLICY_NO)
  {
    this.RC_POL_POLICY_NO = RC_POL_POLICY_NO;
  }
  
  public String getRC_POL_POLICY_NO()
  {
    return this.RC_POL_POLICY_NO;
  }
  
  public void setRC_MEM_DISPL(String RC_MEM_DISPL)
  {
    this.RC_MEM_DISPL = RC_MEM_DISPL;
  }
  
  public String getRC_MEM_DISPL()
  {
    return this.RC_MEM_DISPL;
  }
  
  public void setRC_POL_CODE(BigDecimal RC_POL_CODE)
  {
    this.RC_POL_CODE = RC_POL_CODE;
  }
  
  public BigDecimal getRC_POL_CODE()
  {
    return this.RC_POL_CODE;
  }
  
  public void setRC_CLM_POLM_CODE(BigDecimal RC_CLM_POLM_CODE)
  {
    this.RC_CLM_POLM_CODE = RC_CLM_POLM_CODE;
  }
  
  public BigDecimal getRC_CLM_POLM_CODE()
  {
    return this.RC_CLM_POLM_CODE;
  }
  
  public void setRC_CLM_MEM_CODE(BigDecimal RC_CLM_MEM_CODE)
  {
    this.RC_CLM_MEM_CODE = RC_CLM_MEM_CODE;
  }
  
  public BigDecimal getRC_CLM_MEM_CODE()
  {
    return this.RC_CLM_MEM_CODE;
  }
  
  public void setCPV_VOUCHER_NO(BigDecimal CPV_VOUCHER_NO)
  {
    this.CPV_VOUCHER_NO = CPV_VOUCHER_NO;
  }
  
  public BigDecimal getCPV_VOUCHER_NO()
  {
    return this.CPV_VOUCHER_NO;
  }
  
  public void setCPV_AMOUNT(BigDecimal CPV_AMOUNT)
  {
    this.CPV_AMOUNT = CPV_AMOUNT;
  }
  
  public BigDecimal getCPV_AMOUNT()
  {
    return this.CPV_AMOUNT;
  }
  
  public void setCPV_PAYEE(String CPV_PAYEE)
  {
    this.CPV_PAYEE = CPV_PAYEE;
  }
  
  public String getCPV_PAYEE()
  {
    return this.CPV_PAYEE;
  }
  
  public void setCPV_DRCR_NO(String CPV_DRCR_NO)
  {
    this.CPV_DRCR_NO = CPV_DRCR_NO;
  }
  
  public String getCPV_DRCR_NO()
  {
    return this.CPV_DRCR_NO;
  }
  
  public void setCLM_DATE(Date CLM_DATE)
  {
    this.CLM_DATE = CLM_DATE;
  }
  
  public Date getCLM_DATE()
  {
    return this.CLM_DATE;
  }
  
  public void setCLM_GROSS_RET_AMT(BigDecimal CLM_GROSS_RET_AMT)
  {
    this.CLM_GROSS_RET_AMT = CLM_GROSS_RET_AMT;
  }
  
  public BigDecimal getCLM_GROSS_RET_AMT()
  {
    return this.CLM_GROSS_RET_AMT;
  }
  
  public void setCLM_RETETION_AMT(BigDecimal CLM_RETETION_AMT)
  {
    this.CLM_RETETION_AMT = CLM_RETETION_AMT;
  }
  
  public BigDecimal getCLM_RETETION_AMT()
  {
    return this.CLM_RETETION_AMT;
  }
  
  public void setCLM_RECOVERY_AMT(BigDecimal CLM_RECOVERY_AMT)
  {
    this.CLM_RECOVERY_AMT = CLM_RECOVERY_AMT;
  }
  
  public BigDecimal getCLM_RECOVERY_AMT()
  {
    return this.CLM_RECOVERY_AMT;
  }
  
  public void setCLM_RECOVERED_AMT(BigDecimal CLM_RECOVERED_AMT)
  {
    this.CLM_RECOVERED_AMT = CLM_RECOVERED_AMT;
  }
  
  public BigDecimal getCLM_RECOVERED_AMT()
  {
    return this.CLM_RECOVERED_AMT;
  }
  
  public void setCpvDate(Date cpvDate)
  {
    this.cpvDate = cpvDate;
  }
  
  public Date getCpvDate()
  {
    return this.cpvDate;
  }
  
  public void setCpvAmount(BigDecimal cpvAmount)
  {
    this.cpvAmount = cpvAmount;
  }
  
  public BigDecimal getCpvAmount()
  {
    return this.cpvAmount;
  }
  
  public void setCpvPayee(String cpvPayee)
  {
    this.cpvPayee = cpvPayee;
  }
  
  public String getCpvPayee()
  {
    return this.cpvPayee;
  }
  
  public void setCpvTransType(String cpvTransType)
  {
    this.cpvTransType = cpvTransType;
  }
  
  public String getCpvTransType()
  {
    return this.cpvTransType;
  }
  
  public void setCpvLoanAmt(BigDecimal cpvLoanAmt)
  {
    this.cpvLoanAmt = cpvLoanAmt;
  }
  
  public BigDecimal getCpvLoanAmt()
  {
    return this.cpvLoanAmt;
  }
  
  public void setCpvPremAmt(BigDecimal cpvPremAmt)
  {
    this.cpvPremAmt = cpvPremAmt;
  }
  
  public BigDecimal getCpvPremAmt()
  {
    return this.cpvPremAmt;
  }
  
  public void setCpvStatus(String cpvStatus)
  {
    this.cpvStatus = cpvStatus;
  }
  
  public String getCpvStatus()
  {
    return this.cpvStatus;
  }
  
  public void setCpvPenaltyAmt(BigDecimal cpvPenaltyAmt)
  {
    this.cpvPenaltyAmt = cpvPenaltyAmt;
  }
  
  public BigDecimal getCpvPenaltyAmt()
  {
    return this.cpvPenaltyAmt;
  }
  
  public void setCpvSarAmt(BigDecimal cpvSarAmt)
  {
    this.cpvSarAmt = cpvSarAmt;
  }
  
  public BigDecimal getCpvSarAmt()
  {
    return this.cpvSarAmt;
  }
  
  public void setCpvBoSpreadAmt(BigDecimal cpvBoSpreadAmt)
  {
    this.cpvBoSpreadAmt = cpvBoSpreadAmt;
  }
  
  public BigDecimal getCpvBoSpreadAmt()
  {
    return this.cpvBoSpreadAmt;
  }
  
  public void setGrossVoucherAmt(BigDecimal grossVoucherAmt)
  {
    this.grossVoucherAmt = grossVoucherAmt;
  }
  
  public BigDecimal getGrossVoucherAmt()
  {
    return this.grossVoucherAmt;
  }
  
  public void setCpvVouvherNo(BigDecimal cpvVouvherNo)
  {
    this.cpvVouvherNo = cpvVouvherNo;
  }
  
  public BigDecimal getCpvVouvherNo()
  {
    return this.cpvVouvherNo;
  }
  
  public void setBankAccNo(String bankAccNo)
  {
    this.bankAccNo = bankAccNo;
  }
  
  public String getBankAccNo()
  {
    return this.bankAccNo;
  }
  
  public void setBeneficiaryCode(BigDecimal beneficiaryCode)
  {
    this.beneficiaryCode = beneficiaryCode;
  }
  
  public BigDecimal getBeneficiaryCode()
  {
    return this.beneficiaryCode;
  }
  
  public void setBankBranchCode(BigDecimal bankBranchCode)
  {
    this.bankBranchCode = bankBranchCode;
  }
  
  public BigDecimal getBankBranchCode()
  {
    return this.bankBranchCode;
  }
  
  public void setCvtDesc(String cvtDesc)
  {
    this.cvtDesc = cvtDesc;
  }
  
  public String getCvtDesc()
  {
    return this.cvtDesc;
  }
  
  public void setCpvdDate(Date cpvdDate)
  {
    this.cpvdDate = cpvdDate;
  }
  
  public Date getCpvdDate()
  {
    return this.cpvdDate;
  }
  
  public void setCpvdAmount(BigDecimal cpvdAmount)
  {
    this.cpvdAmount = cpvdAmount;
  }
  
  public BigDecimal getCpvdAmount()
  {
    return this.cpvdAmount;
  }
  
  public void setReiTrtShtDesc(String reiTrtShtDesc)
  {
    this.reiTrtShtDesc = reiTrtShtDesc;
  }
  
  public String getReiTrtShtDesc()
  {
    return this.reiTrtShtDesc;
  }
  
  public void setCoritdCessionRate(BigDecimal coritdCessionRate)
  {
    this.coritdCessionRate = coritdCessionRate;
  }
  
  public BigDecimal getCoritdCessionRate()
  {
    return this.coritdCessionRate;
  }
  
  public void setCoritdAmount(BigDecimal coritdAmount)
  {
    this.coritdAmount = coritdAmount;
  }
  
  public BigDecimal getCoritdAmount()
  {
    return this.coritdAmount;
  }
  
  public void setCoriptAgenShtDesc(String coriptAgenShtDesc)
  {
    this.coriptAgenShtDesc = coriptAgenShtDesc;
  }
  
  public String getCoriptAgenShtDesc()
  {
    return this.coriptAgenShtDesc;
  }
  
  public void setCoriptCessionRate(BigDecimal coriptCessionRate)
  {
    this.coriptCessionRate = coriptCessionRate;
  }
  
  public BigDecimal getCoriptCessionRate()
  {
    return this.coriptCessionRate;
  }
  
  public void setCoriptAmount(BigDecimal coriptAmount)
  {
    this.coriptAmount = coriptAmount;
  }
  
  public BigDecimal getCoriptAmount()
  {
    return this.coriptAmount;
  }
  
  public void setCLM_OUTSTAND_PREM(BigDecimal CLM_OUTSTAND_PREM)
  {
    this.CLM_OUTSTAND_PREM = CLM_OUTSTAND_PREM;
  }
  
  public BigDecimal getCLM_OUTSTAND_PREM()
  {
    return this.CLM_OUTSTAND_PREM;
  }
  
  public void setPMPNS_EMPYR_PENS_BF(BigDecimal PMPNS_EMPYR_PENS_BF)
  {
    this.PMPNS_EMPYR_PENS_BF = PMPNS_EMPYR_PENS_BF;
  }
  
  public BigDecimal getPMPNS_EMPYR_PENS_BF()
  {
    return this.PMPNS_EMPYR_PENS_BF;
  }
  
  public void setPMPNS_EMPYE_PENS_BF(BigDecimal PMPNS_EMPYE_PENS_BF)
  {
    this.PMPNS_EMPYE_PENS_BF = PMPNS_EMPYE_PENS_BF;
  }
  
  public BigDecimal getPMPNS_EMPYE_PENS_BF()
  {
    return this.PMPNS_EMPYE_PENS_BF;
  }
  
  public void setPMPNS_TOT_PENS_BF(BigDecimal PMPNS_TOT_PENS_BF)
  {
    this.PMPNS_TOT_PENS_BF = PMPNS_TOT_PENS_BF;
  }
  
  public BigDecimal getPMPNS_TOT_PENS_BF()
  {
    return this.PMPNS_TOT_PENS_BF;
  }
  
  public void setPMPNS_EARNINGS(BigDecimal PMPNS_EARNINGS)
  {
    this.PMPNS_EARNINGS = PMPNS_EARNINGS;
  }
  
  public BigDecimal getPMPNS_EARNINGS()
  {
    return this.PMPNS_EARNINGS;
  }
  
  public void setPMPNS_EMPLOYEE_CONTR(BigDecimal PMPNS_EMPLOYEE_CONTR)
  {
    this.PMPNS_EMPLOYEE_CONTR = PMPNS_EMPLOYEE_CONTR;
  }
  
  public BigDecimal getPMPNS_EMPLOYEE_CONTR()
  {
    return this.PMPNS_EMPLOYEE_CONTR;
  }
  
  public void setPMPNS_EMPLOYER_CONTR(BigDecimal PMPNS_EMPLOYER_CONTR)
  {
    this.PMPNS_EMPLOYER_CONTR = PMPNS_EMPLOYER_CONTR;
  }
  
  public BigDecimal getPMPNS_EMPLOYER_CONTR()
  {
    return this.PMPNS_EMPLOYER_CONTR;
  }
  
  public void setPMPNS_EMPLYE_VOLU_CONTR(BigDecimal PMPNS_EMPLYE_VOLU_CONTR)
  {
    this.PMPNS_EMPLYE_VOLU_CONTR = PMPNS_EMPLYE_VOLU_CONTR;
  }
  
  public BigDecimal getPMPNS_EMPLYE_VOLU_CONTR()
  {
    return this.PMPNS_EMPLYE_VOLU_CONTR;
  }
  
  public void setPMPNS_TOTAL_CONTR(BigDecimal PMPNS_TOTAL_CONTR)
  {
    this.PMPNS_TOTAL_CONTR = PMPNS_TOTAL_CONTR;
  }
  
  public BigDecimal getPMPNS_TOTAL_CONTR()
  {
    return this.PMPNS_TOTAL_CONTR;
  }
  
  public void setPMPNS_NET_ANNUAL_FUND(BigDecimal PMPNS_NET_ANNUAL_FUND)
  {
    this.PMPNS_NET_ANNUAL_FUND = PMPNS_NET_ANNUAL_FUND;
  }
  
  public BigDecimal getPMPNS_NET_ANNUAL_FUND()
  {
    return this.PMPNS_NET_ANNUAL_FUND;
  }
  
  public void setPMPNS_COMP_INT_RATE(BigDecimal PMPNS_COMP_INT_RATE)
  {
    this.PMPNS_COMP_INT_RATE = PMPNS_COMP_INT_RATE;
  }
  
  public BigDecimal getPMPNS_COMP_INT_RATE()
  {
    return this.PMPNS_COMP_INT_RATE;
  }
  
  public void setPMPNS_ANNTY_FAC_RATE(BigDecimal PMPNS_ANNTY_FAC_RATE)
  {
    this.PMPNS_ANNTY_FAC_RATE = PMPNS_ANNTY_FAC_RATE;
  }
  
  public BigDecimal getPMPNS_ANNTY_FAC_RATE()
  {
    return this.PMPNS_ANNTY_FAC_RATE;
  }
  
  public void setPMPNS_PENS_ANNUM(BigDecimal PMPNS_PENS_ANNUM)
  {
    this.PMPNS_PENS_ANNUM = PMPNS_PENS_ANNUM;
  }
  
  public BigDecimal getPMPNS_PENS_ANNUM()
  {
    return this.PMPNS_PENS_ANNUM;
  }
  
  public void setPMPNS_EST_MAT_VAL(BigDecimal PMPNS_EST_MAT_VAL)
  {
    this.PMPNS_EST_MAT_VAL = PMPNS_EST_MAT_VAL;
  }
  
  public BigDecimal getPMPNS_EST_MAT_VAL()
  {
    return this.PMPNS_EST_MAT_VAL;
  }
  
  public void setPMPNS_DATE_JOINED(Date PMPNS_DATE_JOINED)
  {
    this.PMPNS_DATE_JOINED = PMPNS_DATE_JOINED;
  }
  
  public Date getPMPNS_DATE_JOINED()
  {
    return this.PMPNS_DATE_JOINED;
  }
  
  public void setPMPNS_EMPYR_BAL_BF(BigDecimal PMPNS_EMPYR_BAL_BF)
  {
    this.PMPNS_EMPYR_BAL_BF = PMPNS_EMPYR_BAL_BF;
  }
  
  public BigDecimal getPMPNS_EMPYR_BAL_BF()
  {
    return this.PMPNS_EMPYR_BAL_BF;
  }
  
  public void setPMPNS_EMPYE_BAL_BF(BigDecimal PMPNS_EMPYE_BAL_BF)
  {
    this.PMPNS_EMPYE_BAL_BF = PMPNS_EMPYE_BAL_BF;
  }
  
  public BigDecimal getPMPNS_EMPYE_BAL_BF()
  {
    return this.PMPNS_EMPYE_BAL_BF;
  }
  
  public void setPMPNS_VOL_BF(BigDecimal PMPNS_VOL_BF)
  {
    this.PMPNS_VOL_BF = PMPNS_VOL_BF;
  }
  
  public BigDecimal getPMPNS_VOL_BF()
  {
    return this.PMPNS_VOL_BF;
  }
  
  public void setPMPNS_WET_DATE(Date PMPNS_WET_DATE)
  {
    this.PMPNS_WET_DATE = PMPNS_WET_DATE;
  }
  
  public Date getPMPNS_WET_DATE()
  {
    return this.PMPNS_WET_DATE;
  }
  
  public void setPMPNS_SERVICE_YRS(String PMPNS_SERVICE_YRS)
  {
    this.PMPNS_SERVICE_YRS = PMPNS_SERVICE_YRS;
  }
  
  public String getPMPNS_SERVICE_YRS()
  {
    return this.PMPNS_SERVICE_YRS;
  }
  
  public void setPMPNS_EMPYR_YR_TOT_CONTR(BigDecimal PMPNS_EMPYR_YR_TOT_CONTR)
  {
    this.PMPNS_EMPYR_YR_TOT_CONTR = PMPNS_EMPYR_YR_TOT_CONTR;
  }
  
  public BigDecimal getPMPNS_EMPYR_YR_TOT_CONTR()
  {
    return this.PMPNS_EMPYR_YR_TOT_CONTR;
  }
  
  public void setPMPNS_EMPYE_YR_TOT_CONTR(BigDecimal PMPNS_EMPYE_YR_TOT_CONTR)
  {
    this.PMPNS_EMPYE_YR_TOT_CONTR = PMPNS_EMPYE_YR_TOT_CONTR;
  }
  
  public BigDecimal getPMPNS_EMPYE_YR_TOT_CONTR()
  {
    return this.PMPNS_EMPYE_YR_TOT_CONTR;
  }
  
  public void setPMPNS_PENS_INTEREST_PCT(BigDecimal PMPNS_PENS_INTEREST_PCT)
  {
    this.PMPNS_PENS_INTEREST_PCT = PMPNS_PENS_INTEREST_PCT;
  }
  
  public BigDecimal getPMPNS_PENS_INTEREST_PCT()
  {
    return this.PMPNS_PENS_INTEREST_PCT;
  }
  
  public void setPMPNS_EMPYR_CUR_YR_INCOME(BigDecimal PMPNS_EMPYR_CUR_YR_INCOME)
  {
    this.PMPNS_EMPYR_CUR_YR_INCOME = PMPNS_EMPYR_CUR_YR_INCOME;
  }
  
  public BigDecimal getPMPNS_EMPYR_CUR_YR_INCOME()
  {
    return this.PMPNS_EMPYR_CUR_YR_INCOME;
  }
  
  public void setPMPNS_EMPYE_CUR_YR_INCOME(BigDecimal PMPNS_EMPYE_CUR_YR_INCOME)
  {
    this.PMPNS_EMPYE_CUR_YR_INCOME = PMPNS_EMPYE_CUR_YR_INCOME;
  }
  
  public BigDecimal getPMPNS_EMPYE_CUR_YR_INCOME()
  {
    return this.PMPNS_EMPYE_CUR_YR_INCOME;
  }
  
  public void setPMPNS_VESTING_PCT(BigDecimal PMPNS_VESTING_PCT)
  {
    this.PMPNS_VESTING_PCT = PMPNS_VESTING_PCT;
  }
  
  public BigDecimal getPMPNS_VESTING_PCT()
  {
    return this.PMPNS_VESTING_PCT;
  }
  
  public void setPMPNS_EMPYR_PENS_FUND(BigDecimal PMPNS_EMPYR_PENS_FUND)
  {
    this.PMPNS_EMPYR_PENS_FUND = PMPNS_EMPYR_PENS_FUND;
  }
  
  public BigDecimal getPMPNS_EMPYR_PENS_FUND()
  {
    return this.PMPNS_EMPYR_PENS_FUND;
  }
  
  public void setPMPNS_GROSS_PAYABLE(BigDecimal PMPNS_GROSS_PAYABLE)
  {
    this.PMPNS_GROSS_PAYABLE = PMPNS_GROSS_PAYABLE;
  }
  
  public BigDecimal getPMPNS_GROSS_PAYABLE()
  {
    return this.PMPNS_GROSS_PAYABLE;
  }
  
  public void setPMPNS_EMPYR_RETIRE_HELD(BigDecimal PMPNS_EMPYR_RETIRE_HELD)
  {
    this.PMPNS_EMPYR_RETIRE_HELD = PMPNS_EMPYR_RETIRE_HELD;
  }
  
  public BigDecimal getPMPNS_EMPYR_RETIRE_HELD()
  {
    return this.PMPNS_EMPYR_RETIRE_HELD;
  }
  
  public void setPMPNS_TAX_EXEMPT(String PMPNS_TAX_EXEMPT)
  {
    this.PMPNS_TAX_EXEMPT = PMPNS_TAX_EXEMPT;
  }
  
  public String getPMPNS_TAX_EXEMPT()
  {
    return this.PMPNS_TAX_EXEMPT;
  }
  
  public void setPMPNS_TAXABLE_AMT(BigDecimal PMPNS_TAXABLE_AMT)
  {
    this.PMPNS_TAXABLE_AMT = PMPNS_TAXABLE_AMT;
  }
  
  public BigDecimal getPMPNS_TAXABLE_AMT()
  {
    return this.PMPNS_TAXABLE_AMT;
  }
  
  public void setPMPNS_TAX_PAYABLE(BigDecimal PMPNS_TAX_PAYABLE)
  {
    this.PMPNS_TAX_PAYABLE = PMPNS_TAX_PAYABLE;
  }
  
  public BigDecimal getPMPNS_TAX_PAYABLE()
  {
    return this.PMPNS_TAX_PAYABLE;
  }
  
  public void setPMPNS_NET_PAYABLE(BigDecimal PMPNS_NET_PAYABLE)
  {
    this.PMPNS_NET_PAYABLE = PMPNS_NET_PAYABLE;
  }
  
  public BigDecimal getPMPNS_NET_PAYABLE()
  {
    return this.PMPNS_NET_PAYABLE;
  }
  
  public void setPMPNS_PAYEE(String PMPNS_PAYEE)
  {
    this.PMPNS_PAYEE = PMPNS_PAYEE;
  }
  
  public String getPMPNS_PAYEE()
  {
    return this.PMPNS_PAYEE;
  }
  
  public void setPMPNS_RFUND_AMOUNT(BigDecimal PMPNS_RFUND_AMOUNT)
  {
    this.PMPNS_RFUND_AMOUNT = PMPNS_RFUND_AMOUNT;
  }
  
  public BigDecimal getPMPNS_RFUND_AMOUNT()
  {
    return this.PMPNS_RFUND_AMOUNT;
  }
  
  public void setPMPNS_RFUND_INTERST_RATE(String PMPNS_RFUND_INTERST_RATE)
  {
    this.PMPNS_RFUND_INTERST_RATE = PMPNS_RFUND_INTERST_RATE;
  }
  
  public String getPMPNS_RFUND_INTERST_RATE()
  {
    return this.PMPNS_RFUND_INTERST_RATE;
  }
  
  public void setPMPNS_RFUND_INTERST_AMT(BigDecimal PMPNS_RFUND_INTERST_AMT)
  {
    this.PMPNS_RFUND_INTERST_AMT = PMPNS_RFUND_INTERST_AMT;
  }
  
  public BigDecimal getPMPNS_RFUND_INTERST_AMT()
  {
    return this.PMPNS_RFUND_INTERST_AMT;
  }
  
  public void setPMPNS_RFUND_TAX_EXEMPT(BigDecimal PMPNS_RFUND_TAX_EXEMPT)
  {
    this.PMPNS_RFUND_TAX_EXEMPT = PMPNS_RFUND_TAX_EXEMPT;
  }
  
  public BigDecimal getPMPNS_RFUND_TAX_EXEMPT()
  {
    return this.PMPNS_RFUND_TAX_EXEMPT;
  }
  
  public void setPMPNS_RFUND_TAXABLE_AMT(BigDecimal PMPNS_RFUND_TAXABLE_AMT)
  {
    this.PMPNS_RFUND_TAXABLE_AMT = PMPNS_RFUND_TAXABLE_AMT;
  }
  
  public BigDecimal getPMPNS_RFUND_TAXABLE_AMT()
  {
    return this.PMPNS_RFUND_TAXABLE_AMT;
  }
  
  public void setPMPNS_RFUND_NET_PAYABLE(BigDecimal PMPNS_RFUND_NET_PAYABLE)
  {
    this.PMPNS_RFUND_NET_PAYABLE = PMPNS_RFUND_NET_PAYABLE;
  }
  
  public BigDecimal getPMPNS_RFUND_NET_PAYABLE()
  {
    return this.PMPNS_RFUND_NET_PAYABLE;
  }
  
  public void setPMPNS_CODE(BigDecimal PMPNS_CODE)
  {
    this.PMPNS_CODE = PMPNS_CODE;
  }
  
  public BigDecimal getPMPNS_CODE()
  {
    return this.PMPNS_CODE;
  }
  
  public void setPMPNS_WEF_DATE(Date PMPNS_WEF_DATE)
  {
    this.PMPNS_WEF_DATE = PMPNS_WEF_DATE;
  }
  
  public Date getPMPNS_WEF_DATE()
  {
    return this.PMPNS_WEF_DATE;
  }
  
  public void setLTR_POLM_CODE(BigDecimal LTR_POLM_CODE)
  {
    this.LTR_POLM_CODE = LTR_POLM_CODE;
  }
  
  public BigDecimal getLTR_POLM_CODE()
  {
    return this.LTR_POLM_CODE;
  }
  
  public void setMCD_CODE(BigDecimal MCD_CODE)
  {
    this.MCD_CODE = MCD_CODE;
  }
  
  public BigDecimal getMCD_CODE()
  {
    return this.MCD_CODE;
  }
  
  public void setCPV_DISCHARGE_STATUS(String CPV_DISCHARGE_STATUS)
  {
    this.CPV_DISCHARGE_STATUS = CPV_DISCHARGE_STATUS;
  }
  
  public String getCPV_DISCHARGE_STATUS()
  {
    return this.CPV_DISCHARGE_STATUS;
  }
  
  public void setCPV_DISP_STATUS_DISP(String CPV_DISP_STATUS_DISP)
  {
    this.CPV_DISP_STATUS_DISP = CPV_DISP_STATUS_DISP;
  }
  
  public String getCPV_DISP_STATUS_DISP()
  {
    return this.CPV_DISP_STATUS_DISP;
  }
  
  public void setQEXC_CODE(BigDecimal QEXC_CODE)
  {
    this.QEXC_CODE = QEXC_CODE;
  }
  
  public BigDecimal getQEXC_CODE()
  {
    return this.QEXC_CODE;
  }
  
  public void setQEXC_POL_QUOT_CODE(BigDecimal QEXC_POL_QUOT_CODE)
  {
    this.QEXC_POL_QUOT_CODE = QEXC_POL_QUOT_CODE;
  }
  
  public BigDecimal getQEXC_POL_QUOT_CODE()
  {
    return this.QEXC_POL_QUOT_CODE;
  }
  
  public void setQEXC_AUTHORISED(String QEXC_AUTHORISED)
  {
    this.QEXC_AUTHORISED = QEXC_AUTHORISED;
  }
  
  public String getQEXC_AUTHORISED()
  {
    return this.QEXC_AUTHORISED;
  }
  
  public void setQEXC_DESC(String QEXC_DESC)
  {
    this.QEXC_DESC = QEXC_DESC;
  }
  
  public String getQEXC_DESC()
  {
    return this.QEXC_DESC;
  }
  
  public void setLdlCode(BigDecimal ldlCode)
  {
    this.ldlCode = ldlCode;
  }
  
  public BigDecimal getLdlCode()
  {
    return this.ldlCode;
  }
  
  public void setLdlPercentPayable(BigDecimal ldlPercentPayable)
  {
    this.ldlPercentPayable = ldlPercentPayable;
  }
  
  public BigDecimal getLdlPercentPayable()
  {
    return this.ldlPercentPayable;
  }
  
  public void setClosePolicy(String closePolicy)
  {
    this.closePolicy = closePolicy;
  }
  
  public String getClosePolicy()
  {
    return this.closePolicy;
  }
  
  public void setClosePolicyDesc(String closePolicyDesc)
  {
    this.closePolicyDesc = closePolicyDesc;
  }
  
  public String getClosePolicyDesc()
  {
    return this.closePolicyDesc;
  }
  
  public void setLdlDesc(String ldlDesc)
  {
    this.ldlDesc = ldlDesc;
  }
  
  public String getLdlDesc()
  {
    return this.ldlDesc;
  }
  
  public void setCdlCode(BigDecimal cdlCode)
  {
    this.cdlCode = cdlCode;
  }
  
  public BigDecimal getCdlCode()
  {
    return this.cdlCode;
  }
  
  public void setLdldesc(String ldldesc)
  {
    this.ldldesc = ldldesc;
  }
  
  public String getLdldesc()
  {
    return this.ldldesc;
  }
  
  public void setCDL_PERC_PAYABLE(BigDecimal CDL_PERC_PAYABLE)
  {
    this.CDL_PERC_PAYABLE = CDL_PERC_PAYABLE;
  }
  
  public BigDecimal getCDL_PERC_PAYABLE()
  {
    return this.CDL_PERC_PAYABLE;
  }
  
  public void setCDL_NOF_LOSS_DAYS(String CDL_NOF_LOSS_DAYS)
  {
    this.CDL_NOF_LOSS_DAYS = CDL_NOF_LOSS_DAYS;
  }
  
  public String getCDL_NOF_LOSS_DAYS()
  {
    return this.CDL_NOF_LOSS_DAYS;
  }
  
  public void setCdlClmAmt(BigDecimal cdlClmAmt)
  {
    this.cdlClmAmt = cdlClmAmt;
  }
  
  public BigDecimal getCdlClmAmt()
  {
    return this.cdlClmAmt;
  }
  
  public void setLdlWeeklyIndemnity(String ldlWeeklyIndemnity)
  {
    this.ldlWeeklyIndemnity = ldlWeeklyIndemnity;
  }
  
  public String getLdlWeeklyIndemnity()
  {
    return this.ldlWeeklyIndemnity;
  }
  
  public void setBPY_CODE(BigDecimal BPY_CODE)
  {
    this.BPY_CODE = BPY_CODE;
  }
  
  public BigDecimal getBPY_CODE()
  {
    return this.BPY_CODE;
  }
  
  public void setBPY_NAME(String BPY_NAME)
  {
    this.BPY_NAME = BPY_NAME;
  }
  
  public String getBPY_NAME()
  {
    return this.BPY_NAME;
  }
  
  public void setBPY_AMOUNT(BigDecimal BPY_AMOUNT)
  {
    this.BPY_AMOUNT = BPY_AMOUNT;
  }
  
  public BigDecimal getBPY_AMOUNT()
  {
    return this.BPY_AMOUNT;
  }
  
  public void setBPY_PAY_DATE(Date BPY_PAY_DATE)
  {
    this.BPY_PAY_DATE = BPY_PAY_DATE;
  }
  
  public Date getBPY_PAY_DATE()
  {
    return this.BPY_PAY_DATE;
  }
  
  public void setBPY_PAID(String BPY_PAID)
  {
    this.BPY_PAID = BPY_PAID;
  }
  
  public String getBPY_PAID()
  {
    return this.BPY_PAID;
  }
  
  public void setBPY_PAID_DISPLAY(String BPY_PAID_DISPLAY)
  {
    this.BPY_PAID_DISPLAY = BPY_PAID_DISPLAY;
  }
  
  public String getBPY_PAID_DISPLAY()
  {
    return this.BPY_PAID_DISPLAY;
  }
  
  public void setBPY_PAY_TERM(String BPY_PAY_TERM)
  {
    this.BPY_PAY_TERM = BPY_PAY_TERM;
  }
  
  public String getBPY_PAY_TERM()
  {
    return this.BPY_PAY_TERM;
  }
  
  public void setBPY_CLASS(String BPY_CLASS)
  {
    this.BPY_CLASS = BPY_CLASS;
  }
  
  public String getBPY_CLASS()
  {
    return this.BPY_CLASS;
  }
  
  public void setBPY_VOUCHER_NO(String BPY_VOUCHER_NO)
  {
    this.BPY_VOUCHER_NO = BPY_VOUCHER_NO;
  }
  
  public String getBPY_VOUCHER_NO()
  {
    return this.BPY_VOUCHER_NO;
  }
  
  public void setCCVT_PAY_ORGANIZATION(String CCVT_PAY_ORGANIZATION)
  {
    this.CCVT_PAY_ORGANIZATION = CCVT_PAY_ORGANIZATION;
  }
  
  public String getCCVT_PAY_ORGANIZATION()
  {
    return this.CCVT_PAY_ORGANIZATION;
  }
  
  public void setPOL_CODE(BigDecimal POL_CODE)
  {
    this.POL_CODE = POL_CODE;
  }
  
  public BigDecimal getPOL_CODE()
  {
    return this.POL_CODE;
  }
  
  public void setMEMBERNAME(String MEMBERNAME)
  {
    this.MEMBERNAME = MEMBERNAME;
  }
  
  public String getMEMBERNAME()
  {
    return this.MEMBERNAME;
  }
  
  public void setLTR_EFFECTIVE_DATE(Date LTR_EFFECTIVE_DATE)
  {
    this.LTR_EFFECTIVE_DATE = LTR_EFFECTIVE_DATE;
  }
  
  public Date getLTR_EFFECTIVE_DATE()
  {
    return this.LTR_EFFECTIVE_DATE;
  }
  
  public void setCDL_LDL_CODE(BigDecimal CDL_LDL_CODE)
  {
    this.CDL_LDL_CODE = CDL_LDL_CODE;
  }
  
  public BigDecimal getCDL_LDL_CODE()
  {
    return this.CDL_LDL_CODE;
  }
  
  public void setPMPNS_PAYEE_NAME(String PMPNS_PAYEE_NAME)
  {
    this.PMPNS_PAYEE_NAME = PMPNS_PAYEE_NAME;
  }
  
  public String getPMPNS_PAYEE_NAME()
  {
    return this.PMPNS_PAYEE_NAME;
  }
  
  public void setPMPNS_PAYEE_PIN(String PMPNS_PAYEE_PIN)
  {
    this.PMPNS_PAYEE_PIN = PMPNS_PAYEE_PIN;
  }
  
  public String getPMPNS_PAYEE_PIN()
  {
    return this.PMPNS_PAYEE_PIN;
  }
  
  public void setPCY_CODE(BigDecimal PCY_CODE)
  {
    this.PCY_CODE = PCY_CODE;
  }
  
  public BigDecimal getPCY_CODE()
  {
    return this.PCY_CODE;
  }
  
  public void setPCY_PAY_DATE(Date PCY_PAY_DATE)
  {
    this.PCY_PAY_DATE = PCY_PAY_DATE;
  }
  
  public Date getPCY_PAY_DATE()
  {
    return this.PCY_PAY_DATE;
  }
  
  public void setPCY_POL_CODE(BigDecimal PCY_POL_CODE)
  {
    this.PCY_POL_CODE = PCY_POL_CODE;
  }
  
  public BigDecimal getPCY_POL_CODE()
  {
    return this.PCY_POL_CODE;
  }
  
  public void setPCY_POL_POLICY_NO(String PCY_POL_POLICY_NO)
  {
    this.PCY_POL_POLICY_NO = PCY_POL_POLICY_NO;
  }
  
  public String getPCY_POL_POLICY_NO()
  {
    return this.PCY_POL_POLICY_NO;
  }
  
  public void setPCY_CLM_NO(String PCY_CLM_NO)
  {
    this.PCY_CLM_NO = PCY_CLM_NO;
  }
  
  public String getPCY_CLM_NO()
  {
    return this.PCY_CLM_NO;
  }
  
  public void setPCY_PAID(String PCY_PAID)
  {
    this.PCY_PAID = PCY_PAID;
  }
  
  public String getPCY_PAID()
  {
    return this.PCY_PAID;
  }
  
  public void setPCY_PAYEE(String PCY_PAYEE)
  {
    this.PCY_PAYEE = PCY_PAYEE;
  }
  
  public String getPCY_PAYEE()
  {
    return this.PCY_PAYEE;
  }
  
  public void setPCY_AMOUNT(BigDecimal PCY_AMOUNT)
  {
    this.PCY_AMOUNT = PCY_AMOUNT;
  }
  
  public BigDecimal getPCY_AMOUNT()
  {
    return this.PCY_AMOUNT;
  }
  
  public void setPCY_VOUCHER_NO(String PCY_VOUCHER_NO)
  {
    this.PCY_VOUCHER_NO = PCY_VOUCHER_NO;
  }
  
  public String getPCY_VOUCHER_NO()
  {
    return this.PCY_VOUCHER_NO;
  }
  
  public void setPCY_POLM_CODE(BigDecimal PCY_POLM_CODE)
  {
    this.PCY_POLM_CODE = PCY_POLM_CODE;
  }
  
  public BigDecimal getPCY_POLM_CODE()
  {
    return this.PCY_POLM_CODE;
  }
  
  public void setPMPNS_ANN_PAY_FREQ(String PMPNS_ANN_PAY_FREQ)
  {
    this.PMPNS_ANN_PAY_FREQ = PMPNS_ANN_PAY_FREQ;
  }
  
  public String getPMPNS_ANN_PAY_FREQ()
  {
    return this.PMPNS_ANN_PAY_FREQ;
  }
  
  public void setSelected(Boolean selected)
  {
    this.selected = selected;
  }
  
  public Boolean getSelected()
  {
    return this.selected;
  }
  
  public void setPRP_CODE(BigDecimal PRP_CODE)
  {
    this.PRP_CODE = PRP_CODE;
  }
  
  public BigDecimal getPRP_CODE()
  {
    return this.PRP_CODE;
  }
  
  public void setPRP_CLNT_CODE(BigDecimal PRP_CLNT_CODE)
  {
    this.PRP_CLNT_CODE = PRP_CLNT_CODE;
  }
  
  public BigDecimal getPRP_CLNT_CODE()
  {
    return this.PRP_CLNT_CODE;
  }
  
  public void setTT_CODE(BigDecimal TT_CODE)
  {
    this.TT_CODE = TT_CODE;
  }
  
  public BigDecimal getTT_CODE()
  {
    return this.TT_CODE;
  }
  
  public void setTT_SHT_DESC(String TT_SHT_DESC)
  {
    this.TT_SHT_DESC = TT_SHT_DESC;
  }
  
  public String getTT_SHT_DESC()
  {
    return this.TT_SHT_DESC;
  }
  
  public void setTT_DESC(String TT_DESC)
  {
    this.TT_DESC = TT_DESC;
  }
  
  public String getTT_DESC()
  {
    return this.TT_DESC;
  }
  
  public void setTRT_RATE_TYPE(String TRT_RATE_TYPE)
  {
    this.TRT_RATE_TYPE = TRT_RATE_TYPE;
  }
  
  public String getTRT_RATE_TYPE()
  {
    return this.TRT_RATE_TYPE;
  }
  
  public void setPPTX_CODE(BigDecimal PPTX_CODE)
  {
    this.PPTX_CODE = PPTX_CODE;
  }
  
  public BigDecimal getPPTX_CODE()
  {
    return this.PPTX_CODE;
  }
  
  public void setPPTX_RATE(BigDecimal PPTX_RATE)
  {
    this.PPTX_RATE = PPTX_RATE;
  }
  
  public BigDecimal getPPTX_RATE()
  {
    return this.PPTX_RATE;
  }
  
  public void setPPTX_TAX_AMT(BigDecimal PPTX_TAX_AMT)
  {
    this.PPTX_TAX_AMT = PPTX_TAX_AMT;
  }
  
  public BigDecimal getPPTX_TAX_AMT()
  {
    return this.PPTX_TAX_AMT;
  }
  
  public void setPPTX_TT_CODE(BigDecimal PPTX_TT_CODE)
  {
    this.PPTX_TT_CODE = PPTX_TT_CODE;
  }
  
  public BigDecimal getPPTX_TT_CODE()
  {
    return this.PPTX_TT_CODE;
  }
  
  public void setPPTX_RATE_TYPE(String PPTX_RATE_TYPE)
  {
    this.PPTX_RATE_TYPE = PPTX_RATE_TYPE;
  }
  
  public String getPPTX_RATE_TYPE()
  {
    return this.PPTX_RATE_TYPE;
  }
  
  public void setPABP_CODE(BigDecimal PABP_CODE)
  {
    this.PABP_CODE = PABP_CODE;
  }
  
  public BigDecimal getPABP_CODE()
  {
    return this.PABP_CODE;
  }
  
  public void setPABP_NO(String PABP_NO)
  {
    this.PABP_NO = PABP_NO;
  }
  
  public String getPABP_NO()
  {
    return this.PABP_NO;
  }
  
  public void setPAB_SURNAME(String PAB_SURNAME)
  {
    this.PAB_SURNAME = PAB_SURNAME;
  }
  
  public String getPAB_SURNAME()
  {
    return this.PAB_SURNAME;
  }
  
  public void setPAB_OTHERNAMES(String PAB_OTHERNAMES)
  {
    this.PAB_OTHERNAMES = PAB_OTHERNAMES;
  }
  
  public String getPAB_OTHERNAMES()
  {
    return this.PAB_OTHERNAMES;
  }
  
  public void setPABP_DATE_DUE(Date PABP_DATE_DUE)
  {
    this.PABP_DATE_DUE = PABP_DATE_DUE;
  }
  
  public Date getPABP_DATE_DUE()
  {
    return this.PABP_DATE_DUE;
  }
  
  public void setPABP_AMOUNT(BigDecimal PABP_AMOUNT)
  {
    this.PABP_AMOUNT = PABP_AMOUNT;
  }
  
  public BigDecimal getPABP_AMOUNT()
  {
    return this.PABP_AMOUNT;
  }
  
  public void setPABP_PAID(String PABP_PAID)
  {
    this.PABP_PAID = PABP_PAID;
  }
  
  public String getPABP_PAID()
  {
    return this.PABP_PAID;
  }
  
  public void setPABP_PAID_DATE(Date PABP_PAID_DATE)
  {
    this.PABP_PAID_DATE = PABP_PAID_DATE;
  }
  
  public Date getPABP_PAID_DATE()
  {
    return this.PABP_PAID_DATE;
  }
  
  public void setPABP_VOUCHER_NO(String PABP_VOUCHER_NO)
  {
    this.PABP_VOUCHER_NO = PABP_VOUCHER_NO;
  }
  
  public String getPABP_VOUCHER_NO()
  {
    return this.PABP_VOUCHER_NO;
  }
  
  public void setAGN_NAME(String AGN_NAME)
  {
    this.AGN_NAME = AGN_NAME;
  }
  
  public String getAGN_NAME()
  {
    return this.AGN_NAME;
  }
  
  public void setCCR_CODE(BigDecimal CCR_CODE)
  {
    this.CCR_CODE = CCR_CODE;
  }
  
  public BigDecimal getCCR_CODE()
  {
    return this.CCR_CODE;
  }
  
  public void setCCR_POLM_CODE(BigDecimal CCR_POLM_CODE)
  {
    this.CCR_POLM_CODE = CCR_POLM_CODE;
  }
  
  public BigDecimal getCCR_POLM_CODE()
  {
    return this.CCR_POLM_CODE;
  }
  
  public void setCCR_PCOIN_SHARE_PCT(BigDecimal CCR_PCOIN_SHARE_PCT)
  {
    this.CCR_PCOIN_SHARE_PCT = CCR_PCOIN_SHARE_PCT;
  }
  
  public BigDecimal getCCR_PCOIN_SHARE_PCT()
  {
    return this.CCR_PCOIN_SHARE_PCT;
  }
  
  public void setCCR_PCOIN_AGN_CODE(BigDecimal CCR_PCOIN_AGN_CODE)
  {
    this.CCR_PCOIN_AGN_CODE = CCR_PCOIN_AGN_CODE;
  }
  
  public BigDecimal getCCR_PCOIN_AGN_CODE()
  {
    return this.CCR_PCOIN_AGN_CODE;
  }
  
  public void setCCR_CLM_AMT_TO_PAY(BigDecimal CCR_CLM_AMT_TO_PAY)
  {
    this.CCR_CLM_AMT_TO_PAY = CCR_CLM_AMT_TO_PAY;
  }
  
  public BigDecimal getCCR_CLM_AMT_TO_PAY()
  {
    return this.CCR_CLM_AMT_TO_PAY;
  }
  
  public void setCCR_AMT_PAID(BigDecimal CCR_AMT_PAID)
  {
    this.CCR_AMT_PAID = CCR_AMT_PAID;
  }
  
  public BigDecimal getCCR_AMT_PAID()
  {
    return this.CCR_AMT_PAID;
  }
  
  public void setCCR_BALANCE(BigDecimal CCR_BALANCE)
  {
    this.CCR_BALANCE = CCR_BALANCE;
  }
  
  public BigDecimal getCCR_BALANCE()
  {
    return this.CCR_BALANCE;
  }
  
  public void setCCR_AUTHORISED(String CCR_AUTHORISED)
  {
    this.CCR_AUTHORISED = CCR_AUTHORISED;
  }
  
  public String getCCR_AUTHORISED()
  {
    return this.CCR_AUTHORISED;
  }
  
  public void setCCR_AUTHORISED_BY(String CCR_AUTHORISED_BY)
  {
    this.CCR_AUTHORISED_BY = CCR_AUTHORISED_BY;
  }
  
  public String getCCR_AUTHORISED_BY()
  {
    return this.CCR_AUTHORISED_BY;
  }
  
  public void setCCR_PREPARED_BY(String CCR_PREPARED_BY)
  {
    this.CCR_PREPARED_BY = CCR_PREPARED_BY;
  }
  
  public String getCCR_PREPARED_BY()
  {
    return this.CCR_PREPARED_BY;
  }
  
  public void setCCR_PAID(String CCR_PAID)
  {
    this.CCR_PAID = CCR_PAID;
  }
  
  public String getCCR_PAID()
  {
    return this.CCR_PAID;
  }
  
  public void setCLM_PAY_TOT_COINS_AMT(String CLM_PAY_TOT_COINS_AMT)
  {
    this.CLM_PAY_TOT_COINS_AMT = CLM_PAY_TOT_COINS_AMT;
  }
  
  public String getCLM_PAY_TOT_COINS_AMT()
  {
    return this.CLM_PAY_TOT_COINS_AMT;
  }
  
  public void setCLM_PAY_TOT_COINS_DISP(String CLM_PAY_TOT_COINS_DISP)
  {
    this.CLM_PAY_TOT_COINS_DISP = CLM_PAY_TOT_COINS_DISP;
  }
  
  public String getCLM_PAY_TOT_COINS_DISP()
  {
    return this.CLM_PAY_TOT_COINS_DISP;
  }
  
  public void setCcvt_saving_amt(BigDecimal ccvt_saving_amt)
  {
    this.ccvt_saving_amt = ccvt_saving_amt;
  }
  
  public BigDecimal getCcvt_saving_amt()
  {
    return this.ccvt_saving_amt;
  }
  
  public void setCcvt_original_loan_amt(BigDecimal ccvt_original_loan_amt)
  {
    this.ccvt_original_loan_amt = ccvt_original_loan_amt;
  }
  
  public BigDecimal getCcvt_original_loan_amt()
  {
    return this.ccvt_original_loan_amt;
  }
  
  public void setCcvt_orig_loan_repayment_prd(BigDecimal ccvt_orig_loan_repayment_prd)
  {
    this.ccvt_orig_loan_repayment_prd = ccvt_orig_loan_repayment_prd;
  }
  
  public BigDecimal getCcvt_orig_loan_repayment_prd()
  {
    return this.ccvt_orig_loan_repayment_prd;
  }
  
  public void setCCVT_DESC(String CCVT_DESC)
  {
    this.CCVT_DESC = CCVT_DESC;
  }
  
  public String getCCVT_DESC()
  {
    return this.CCVT_DESC;
  }
  
  public void setMEM_SURNAME(String MEM_SURNAME)
  {
    this.MEM_SURNAME = MEM_SURNAME;
  }
  
  public String getMEM_SURNAME()
  {
    return this.MEM_SURNAME;
  }
  
  public void setMEM_OTHER_NAMES(String MEM_OTHER_NAMES)
  {
    this.MEM_OTHER_NAMES = MEM_OTHER_NAMES;
  }
  
  public String getMEM_OTHER_NAMES()
  {
    return this.MEM_OTHER_NAMES;
  }
  
  public void setMEM_IDENTITY_NO(String MEM_IDENTITY_NO)
  {
    this.MEM_IDENTITY_NO = MEM_IDENTITY_NO;
  }
  
  public String getMEM_IDENTITY_NO()
  {
    return this.MEM_IDENTITY_NO;
  }
  
  public void setMEM_DOB(Date MEM_DOB)
  {
    this.MEM_DOB = MEM_DOB;
  }
  
  public Date getMEM_DOB()
  {
    return this.MEM_DOB;
  }
  
  public void setMEM_SEX(String MEM_SEX)
  {
    this.MEM_SEX = MEM_SEX;
  }
  
  public String getMEM_SEX()
  {
    return this.MEM_SEX;
  }
  
  public void setMEM_SCHEDULE_JOIN_DATE(Date MEM_SCHEDULE_JOIN_DATE)
  {
    this.MEM_SCHEDULE_JOIN_DATE = MEM_SCHEDULE_JOIN_DATE;
  }
  
  public Date getMEM_SCHEDULE_JOIN_DATE()
  {
    return this.MEM_SCHEDULE_JOIN_DATE;
  }
  
  public void setCLM_EXGRATIA(String CLM_EXGRATIA)
  {
    this.CLM_EXGRATIA = CLM_EXGRATIA;
  }
  
  public String getCLM_EXGRATIA()
  {
    return this.CLM_EXGRATIA;
  }
  
  public void setCLM_EXGRATIA_REMARKS(String CLM_EXGRATIA_REMARKS)
  {
    this.CLM_EXGRATIA_REMARKS = CLM_EXGRATIA_REMARKS;
  }
  
  public String getCLM_EXGRATIA_REMARKS()
  {
    return this.CLM_EXGRATIA_REMARKS;
  }
  
  public void setCcvt_pct_code(BigDecimal ccvt_pct_code)
  {
    this.ccvt_pct_code = ccvt_pct_code;
  }
  
  public BigDecimal getCcvt_pct_code()
  {
    return this.ccvt_pct_code;
  }
  
  public void setClm_death_location(String clm_death_location)
  {
    this.clm_death_location = clm_death_location;
  }
  
  public String getClm_death_location()
  {
    return this.clm_death_location;
  }
  
  public void setCpv_authorised(String cpv_authorised)
  {
    this.cpv_authorised = cpv_authorised;
  }
  
  public String getCpv_authorised()
  {
    return this.cpv_authorised;
  }
  
  public void setCpv_ltr_btr_trans_code(String cpv_ltr_btr_trans_code)
  {
    this.cpv_ltr_btr_trans_code = cpv_ltr_btr_trans_code;
  }
  
  public String getCpv_ltr_btr_trans_code()
  {
    return this.cpv_ltr_btr_trans_code;
  }
  
  public void setPMPNS_EMPYR_RETIRE_HELD_PCT(BigDecimal PMPNS_EMPYR_RETIRE_HELD_PCT)
  {
    this.PMPNS_EMPYR_RETIRE_HELD_PCT = PMPNS_EMPYR_RETIRE_HELD_PCT;
  }
  
  public BigDecimal getPMPNS_EMPYR_RETIRE_HELD_PCT()
  {
    return this.PMPNS_EMPYR_RETIRE_HELD_PCT;
  }
  
  public void setLTR_DONE_BY(String LTR_DONE_BY)
  {
    this.LTR_DONE_BY = LTR_DONE_BY;
  }
  
  public String getLTR_DONE_BY()
  {
    return this.LTR_DONE_BY;
  }
  
  public void setLTR_POL_CODE(BigDecimal LTR_POL_CODE)
  {
    this.LTR_POL_CODE = LTR_POL_CODE;
  }
  
  public BigDecimal getLTR_POL_CODE()
  {
    return this.LTR_POL_CODE;
  }
  
  public void setMEM_NO_DISP(String MEM_NO_DISP)
  {
    this.MEM_NO_DISP = MEM_NO_DISP;
  }
  
  public String getMEM_NO_DISP()
  {
    return this.MEM_NO_DISP;
  }
  
  public void setMEM_NAME_DISP(String MEM_NAME_DISP)
  {
    this.MEM_NAME_DISP = MEM_NAME_DISP;
  }
  
  public String getMEM_NAME_DISP()
  {
    return this.MEM_NAME_DISP;
  }
  
  public void setCPV_DATE(Date CPV_DATE)
  {
    this.CPV_DATE = CPV_DATE;
  }
  
  public Date getCPV_DATE()
  {
    return this.CPV_DATE;
  }
  
  public void setMCLM_CODE(BigDecimal MCLM_CODE)
  {
    this.MCLM_CODE = MCLM_CODE;
  }
  
  public BigDecimal getMCLM_CODE()
  {
    return this.MCLM_CODE;
  }
  
  public void setMCLM_DATE_DEATH_ACCIDENT(Date MCLM_DATE_DEATH_ACCIDENT)
  {
    this.MCLM_DATE_DEATH_ACCIDENT = MCLM_DATE_DEATH_ACCIDENT;
  }
  
  public Date getMCLM_DATE_DEATH_ACCIDENT()
  {
    return this.MCLM_DATE_DEATH_ACCIDENT;
  }
  
  public void setMCLM_DATE_CLAIM_REPORTED(Date MCLM_DATE_CLAIM_REPORTED)
  {
    this.MCLM_DATE_CLAIM_REPORTED = MCLM_DATE_CLAIM_REPORTED;
  }
  
  public Date getMCLM_DATE_CLAIM_REPORTED()
  {
    return this.MCLM_DATE_CLAIM_REPORTED;
  }
  
  public void setCLM_BATCH_NO(BigDecimal CLM_BATCH_NO)
  {
    this.CLM_BATCH_NO = CLM_BATCH_NO;
  }
  
  public BigDecimal getCLM_BATCH_NO()
  {
    return this.CLM_BATCH_NO;
  }
  
  public void setBBR_CODE(BigDecimal BBR_CODE)
  {
    this.BBR_CODE = BBR_CODE;
  }
  
  public BigDecimal getBBR_CODE()
  {
    return this.BBR_CODE;
  }
  
  public void setBBR_BRANCH_NAME(String BBR_BRANCH_NAME)
  {
    this.BBR_BRANCH_NAME = BBR_BRANCH_NAME;
  }
  
  public String getBBR_BRANCH_NAME()
  {
    return this.BBR_BRANCH_NAME;
  }
  
  public void setCpv_payment_mode(String cpv_payment_mode)
  {
    this.cpv_payment_mode = cpv_payment_mode;
  }
  
  public String getCpv_payment_mode()
  {
    return this.cpv_payment_mode;
  }
  
  public void setCpv_bbr_acc_no(String cpv_bbr_acc_no)
  {
    this.cpv_bbr_acc_no = cpv_bbr_acc_no;
  }
  
  public String getCpv_bbr_acc_no()
  {
    return this.cpv_bbr_acc_no;
  }
  
  public void setCCVT_PAY_INST(BigDecimal CCVT_PAY_INST)
  {
    this.CCVT_PAY_INST = CCVT_PAY_INST;
  }
  
  public BigDecimal getCCVT_PAY_INST()
  {
    return this.CCVT_PAY_INST;
  }
  
  public void setCCVT_INT_SAVING_AMT(BigDecimal CCVT_INT_SAVING_AMT)
  {
    this.CCVT_INT_SAVING_AMT = CCVT_INT_SAVING_AMT;
  }
  
  public BigDecimal getCCVT_INT_SAVING_AMT()
  {
    return this.CCVT_INT_SAVING_AMT;
  }
  
  public void setCCVT_CVT_OCC_BEN(String CCVT_CVT_OCC_BEN)
  {
    this.CCVT_CVT_OCC_BEN = CCVT_CVT_OCC_BEN;
  }
  
  public String getCCVT_CVT_OCC_BEN()
  {
    return this.CCVT_CVT_OCC_BEN;
  }
  
  public void setCCVT_OCC_BEN_RATE(BigDecimal CCVT_OCC_BEN_RATE)
  {
    this.CCVT_OCC_BEN_RATE = CCVT_OCC_BEN_RATE;
  }
  
  public BigDecimal getCCVT_OCC_BEN_RATE()
  {
    return this.CCVT_OCC_BEN_RATE;
  }
  
  public void setCipgCode(BigDecimal cipgCode)
  {
    this.cipgCode = cipgCode;
  }
  
  public BigDecimal getCipgCode()
  {
    return this.cipgCode;
  }
  
  public void setCipgAmount(BigDecimal cipgAmount)
  {
    this.cipgAmount = cipgAmount;
  }
  
  public BigDecimal getCipgAmount()
  {
    return this.cipgAmount;
  }
  
  public void setCipgVoucherNo(BigDecimal cipgVoucherNo)
  {
    this.cipgVoucherNo = cipgVoucherNo;
  }
  
  public BigDecimal getCipgVoucherNo()
  {
    return this.cipgVoucherNo;
  }
  
  public void setCipgPaid(String cipgPaid)
  {
    this.cipgPaid = cipgPaid;
  }
  
  public String getCipgPaid()
  {
    return this.cipgPaid;
  }
  
  public void setCipgPayDate(String cipgPayDate)
  {
    this.cipgPayDate = cipgPayDate;
  }
  
  public String getCipgPayDate()
  {
    return this.cipgPayDate;
  }
  
  public void setCipgInstPayFreq(String cipgInstPayFreq)
  {
    this.cipgInstPayFreq = cipgInstPayFreq;
  }
  
  public String getCipgInstPayFreq()
  {
    return this.cipgInstPayFreq;
  }
  
  public void setCLM_PAY_INSTALMNTS(String CLM_PAY_INSTALMNTS)
  {
    this.CLM_PAY_INSTALMNTS = CLM_PAY_INSTALMNTS;
  }
  
  public String getCLM_PAY_INSTALMNTS()
  {
    return this.CLM_PAY_INSTALMNTS;
  }
  
  public void setCLM_INST_PAY_FREQ(String CLM_INST_PAY_FREQ)
  {
    this.CLM_INST_PAY_FREQ = CLM_INST_PAY_FREQ;
  }
  
  public String getCLM_INST_PAY_FREQ()
  {
    return this.CLM_INST_PAY_FREQ;
  }
  
  public void setCLM_NOF_INST(BigDecimal CLM_NOF_INST)
  {
    this.CLM_NOF_INST = CLM_NOF_INST;
  }
  
  public BigDecimal getCLM_NOF_INST()
  {
    return this.CLM_NOF_INST;
  }
  
  public void setCLM_LOAN_ISSUE_DATE(Date CLM_LOAN_ISSUE_DATE)
  {
    this.CLM_LOAN_ISSUE_DATE = CLM_LOAN_ISSUE_DATE;
  }
  
  public Date getCLM_LOAN_ISSUE_DATE()
  {
    return this.CLM_LOAN_ISSUE_DATE;
  }
  
  public void setCLM_LOAN_INST_AMT(BigDecimal CLM_LOAN_INST_AMT)
  {
    this.CLM_LOAN_INST_AMT = CLM_LOAN_INST_AMT;
  }
  
  public BigDecimal getCLM_LOAN_INST_AMT()
  {
    return this.CLM_LOAN_INST_AMT;
  }
  
  public void setCLM_HOSP_DAYS(BigDecimal CLM_HOSP_DAYS)
  {
    this.CLM_HOSP_DAYS = CLM_HOSP_DAYS;
  }
  
  public BigDecimal getCLM_HOSP_DAYS()
  {
    return this.CLM_HOSP_DAYS;
  }
  
  public void setCRM_CODE(BigDecimal CRM_CODE)
  {
    this.CRM_CODE = CRM_CODE;
  }
  
  public BigDecimal getCRM_CODE()
  {
    return this.CRM_CODE;
  }
  
  public void setCRM_REMARKS(String CRM_REMARKS)
  {
    this.CRM_REMARKS = CRM_REMARKS;
  }
  
  public String getCRM_REMARKS()
  {
    return this.CRM_REMARKS;
  }
  
  public void setCRM_REMARK_TYPE(String CRM_REMARK_TYPE)
  {
    this.CRM_REMARK_TYPE = CRM_REMARK_TYPE;
  }
  
  public String getCRM_REMARK_TYPE()
  {
    return this.CRM_REMARK_TYPE;
  }
  
  public void setCRM_REMARKS_BY(String CRM_REMARKS_BY)
  {
    this.CRM_REMARKS_BY = CRM_REMARKS_BY;
  }
  
  public String getCRM_REMARKS_BY()
  {
    return this.CRM_REMARKS_BY;
  }
  
  public void setCRM_REMARKS_DATE(Date CRM_REMARKS_DATE)
  {
    this.CRM_REMARKS_DATE = CRM_REMARKS_DATE;
  }
  
  public Date getCRM_REMARKS_DATE()
  {
    return this.CRM_REMARKS_DATE;
  }
  
  public void setREMARKS_DESC(String REMARKS_DESC)
  {
    this.REMARKS_DESC = REMARKS_DESC;
  }
  
  public String getREMARKS_DESC()
  {
    return this.REMARKS_DESC;
  }
  
  public void setMCD_DATE_GIVEN1(Date MCD_DATE_GIVEN1)
  {
    this.MCD_DATE_GIVEN1 = MCD_DATE_GIVEN1;
  }
  
  public Date getMCD_DATE_GIVEN1()
  {
    return this.MCD_DATE_GIVEN1;
  }
  
  public void setCPV_PAYEE_TEL(String CPV_PAYEE_TEL)
  {
    this.CPV_PAYEE_TEL = CPV_PAYEE_TEL;
  }
  
  public String getCPV_PAYEE_TEL()
  {
    return this.CPV_PAYEE_TEL;
  }
  
  public void setMPT_CODE(BigDecimal MPT_CODE)
  {
    this.MPT_CODE = MPT_CODE;
  }
  
  public BigDecimal getMPT_CODE()
  {
    return this.MPT_CODE;
  }
  
  public void setMPT_MIN_AMT_ALLOWED(BigDecimal MPT_MIN_AMT_ALLOWED)
  {
    this.MPT_MIN_AMT_ALLOWED = MPT_MIN_AMT_ALLOWED;
  }
  
  public BigDecimal getMPT_MIN_AMT_ALLOWED()
  {
    return this.MPT_MIN_AMT_ALLOWED;
  }
  
  public void setMPT_MAX_AMT_ALLOWED(BigDecimal MPT_MAX_AMT_ALLOWED)
  {
    this.MPT_MAX_AMT_ALLOWED = MPT_MAX_AMT_ALLOWED;
  }
  
  public BigDecimal getMPT_MAX_AMT_ALLOWED()
  {
    return this.MPT_MAX_AMT_ALLOWED;
  }
  
  public void setMPT_SHT_DESC(String MPT_SHT_DESC)
  {
    this.MPT_SHT_DESC = MPT_SHT_DESC;
  }
  
  public String getMPT_SHT_DESC()
  {
    return this.MPT_SHT_DESC;
  }
  
  public void setMPT_DESC(String MPT_DESC)
  {
    this.MPT_DESC = MPT_DESC;
  }
  
  public String getMPT_DESC()
  {
    return this.MPT_DESC;
  }
  
  public void setCpvMftProvider(String cpvMftProvider)
  {
    this.cpvMftProvider = cpvMftProvider;
  }
  
  public String getCpvMftProvider()
  {
    return this.cpvMftProvider;
  }
  
  public void setCpvAccNo(String cpvAccNo)
  {
    this.cpvAccNo = cpvAccNo;
  }
  
  public String getCpvAccNo()
  {
    return this.cpvAccNo;
  }
  
  public void setBankBranchName(String bankBranchName)
  {
    this.bankBranchName = bankBranchName;
  }
  
  public String getBankBranchName()
  {
    return this.bankBranchName;
  }

    public void setPMPNS_DATE_EMPLOYED(Date PMPNS_DATE_EMPLOYED) {
        this.PMPNS_DATE_EMPLOYED = PMPNS_DATE_EMPLOYED;
    }

    public Date getPMPNS_DATE_EMPLOYED() {
        return PMPNS_DATE_EMPLOYED;
    }

    public void setPOLM_DATE_JOINED(Date POLM_DATE_JOINED) {
        this.POLM_DATE_JOINED = POLM_DATE_JOINED;
    }

    public Date getPOLM_DATE_JOINED() {
        return POLM_DATE_JOINED;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setKRAPIN(String KRAPIN) {
        this.KRAPIN = KRAPIN;
    }

    public String getKRAPIN() {
        return KRAPIN;
    }

    public void setPMPNS_OVERRIDE_TAX_EXEMPT(BigDecimal PMPNS_OVERRIDE_TAX_EXEMPT) {
        this.PMPNS_OVERRIDE_TAX_EXEMPT = PMPNS_OVERRIDE_TAX_EXEMPT;
    }

    public BigDecimal getPMPNS_OVERRIDE_TAX_EXEMPT() {
        return PMPNS_OVERRIDE_TAX_EXEMPT;
    }
}
