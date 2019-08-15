package LMSG.view.Accounts;

import java.math.BigDecimal;
import java.util.Date;

public class Account
{
  private String MTRAN_REF_NO;
  private Date MTRAN_DATE;
  private String MTRAN_DC;
  private String MTRAN_AMOUNT;
  private String MTRAN_COMMISSION;
  private String MTRAN_COMM_PAID;
  private String MTRAN_COMM_PAYABLE;
  private String MTRAN_BALANCE;
  private BigDecimal MTRAN_CODE;
  private String MTRAN_TRAN_TYPE;
  private String MTRAN_POL_POLCY_NO;
  private BigDecimal CCL_CODE;
  private BigDecimal emyr_reg_amount;
  private BigDecimal emye_reg_amount;
  private BigDecimal emyr_unreg_amount;
  private BigDecimal emye_unreg_amount;
  private String amount;
  private String ENDR_COINSURANCE;
  private BigDecimal mtran_rcpt_reserve_amt;
  private BigDecimal mtran_lms_receipt_pk;
  private BigDecimal pcp_code;
  private String CRA_MTRAN_ALLOC_MODE_DESC;
  private String CRA_MTRAN_ALLOC_MODE;
  private BigDecimal PCM_ENDR_CODE;
  private BigDecimal PCM_POLM_CODE;
  private boolean selected;
  private BigDecimal LPR_CODE;
  private BigDecimal LPR_AMOUNT_TO_PAY;
  private String LPR_RAISED_BY;
  private Date LPR_DATE_DONE;
  private String LPR_PAID;
  private String LPR_VOUCHER_NO;
  private String LPR_AUTHORISED_BY;
  private Date LPR_AUTHORISED_DATE;
  private String GBL_DRCR;
  private BigDecimal PROD_CODE;
  private String PROD_DESC;
  private BigDecimal BRN_CODE;
  private String BRN_NAME;
  private BigDecimal PRP_CODE;
  private String CLIENT;
  private String GBL_FREQ_OF_PAY;
  private String GBL_DURATION_TYPE;
  private Date GBL_EFFECTIVE_DATE;
  private BigDecimal AGN_CODE;
  private String AGN_NAME;
  private BigDecimal grct_code;
  private String CRA_MTRAN_REF_NO;
  private Date CRA_MTRAN_DATE;
  private String CRA_MTRAN_DC;
  private String CRA_MTRAN_AMOUNT;
  private String CRA_MTRAN_COMMISSION;
  private String CRA_MTRAN_COMM_PAID;
  private String CRA_MTRAN_COMM_PAYABLE;
  private String CRA_MTRAN_BALANCE;
  private BigDecimal CRA_MTRAN_CODE;
  private String CRA_amount;
  private String CRA_MTRAN_TRAN_TYPE;
  private String DBA_MTRAN_REF_NO;
  private Date DBA_MTRAN_DATE;
  private String DBA_MTRAN_DC;
  private String DBA_GROSS_AMOUNT;
  private String DBA_NET_AMOUNT;
  private String DBA_MTRAN_SETTLED_AMT;
  private String DBA_MTRAN_BALANCE;
  private String DBA_MTRAN_COMMISSION;
  private String DBA_MTRAN_COMM_PAID;
  private String DBA_MTRAN_COMM_PAYABLE;
  private BigDecimal DBA_MTRAN_CODE;
  private String DBA_amount;
  private String DBA_MTRAN_TRAN_TYPE;
  private String DBT_MTRAN_REF_NO;
  private Date DBT_MTRAN_DATE;
  private String DBT_MTRAN_DC;
  private String DBT_GROSS_AMOUNT;
  private String DBT_NET_AMOUNT;
  private String DBT_MTRAN_SETTLED_AMT;
  private String DBT_MTRAN_BALANCE;
  private String DBT_MTRAN_COMMISSION;
  private String DBT_MTRAN_COMM_PAID;
  private String DBT_MTRAN_COMM_PAYABLE;
  private BigDecimal DBT_MTRAN_CODE;
  private String DBT_amount;
  private String DBT_MTRAN_TRAN_TYPE;
  private String TMAP_DR_MTRAN_REF_NO;
  private BigDecimal tmap_code;
  private String TMAP_AMOUNT;
  private BigDecimal TMAP_DR_MTRAN_CODE;
  private BigDecimal PCP_CODE;
  private String AGENT_DISPLAY;
  private String PCP_AGN_UNIT_MGR;
  private String BRANCH_DISPLAY;
  private String PCP_COMM_AMT;
  private String PCP_WHDTAX_AMT;
  private String PCP_OVRIDE_COMM_AMT;
  private String PCP_OVRIDE_WHDTAX_AMT;
  private String PCP_NET_COMM;
  private String PCP_PAID;
  private BigDecimal PCM_CODE;
  private String MEM_NO;
  private String MEMBER_DISPLAY;
  private BigDecimal PCM_EARNINGS;
  private BigDecimal PCM_PREMIUM;
  private BigDecimal PCM_ALLOCATED_PREMIUM;
  private BigDecimal PCM_PAID_AMOUNT;
  private BigDecimal POL_CODE;
  private String POL_POLICY_NO;
  private String PRP_NAME;
  private BigDecimal MIP_CODE;
  private String MIP_PCM_CODE;
  private BigDecimal MIP_PCM_EARNINGS;
  private BigDecimal MIP_PCM_PREMIUM;
  private BigDecimal MIP_PCM_ALLOCATED_AMT;
  private String MIP_BATCH_NO;
  private String MIP_MEM_NO;
  private String MIP_MEMBER_NAME;
  private String MEM_NO_DISPLAY;
  private String PEN_MEMBER_DISPLAY;
  private String v_paid_er_amt;
  private String v_paid_ee_amt;
  private String v_paid_ee_vol_amt;
  private String v_paid_er_vol_amt;
  private String v_paid_ee_bf_amt;
  private String v_paid_er_bf_amt;
  private BigDecimal v_empyr_loan_repay;
  private BigDecimal v_empye_loan_repay;
  private String ALLOCATED_AMOUNT;
  private String PAID_AMOUNT;
  private String PMPNS_EARNINGS;
  private String PMPNS_EMPLOYER_CONTR;
  private String PMPNS_EMPLOYEE_CONTR;
  private BigDecimal PMPNS_CODE;
  private String DIS_ENDR_NO;
  private BigDecimal DIS_ENDR_CODE;
  private String DIS_ENDR_TRANS_TYPE;
  private String PNDP_CODE2;
  private String POLICY_NO;
  private BigDecimal AMOUNT;
  private String LOADED;
  private String LOADED_DESC;
  private String LOAD_REMARKS;
  private String LOAD_BY;
  private Date LOAD_DATE;
  private Date BAL_DATE;
  private BigDecimal GBL_CODE;
  private BigDecimal pol_code;
  private String pol_policy_no;
  private String inst_no;
  private Date opr_receipt_date;
  private BigDecimal inst_amt;
  private BigDecimal comm_rate;
  private BigDecimal comm_amt;
  private BigDecimal whdtax_rate;
  private BigDecimal whdtax_amt;
  private BigDecimal tot_comm_display;
  private String drcr;
  private String opr_receipt_no;
  private BigDecimal COP_CODE;
  private String COP_AGN_UNIT_MGR;
  private BigDecimal COP_COMM_AMT;
  private BigDecimal COP_WHDTAX_AMT;
  private BigDecimal COP_OVRIDE_COMM_AMT;
  private BigDecimal COP_OVRIDE_WHDTAX_AMT;
  private BigDecimal COP_ADVANCE_PYMT;
  private BigDecimal COP_DEDUCTIONS;
  private BigDecimal COP_BONUS_AMT;
  private BigDecimal COP_BONUS_WHDTAX_AMT;
  private BigDecimal TOTAL_AMT_DISPLAY;
  private String COP_DRCR;
  private BigDecimal LGPL_SN;
  private String LGPL_CLIENT;
  private BigDecimal LGPL_NO_MEM;
  private String LGPL_SHARE;
  private Date LGPL_COMMENC_DT;
  private Date LGPL_RENEW_DT;
  private Date LGPL_NEXT_REN_DT;
  private String LGPL_RATES;
  private BigDecimal LGPL_TOT_SA;
  private BigDecimal LGPL_TOT_PREM;
  private BigDecimal LGPL_TOT_PREM_PAID;
  private BigDecimal LGPL_OUTS_PREM;
  private String LGPL_PROD_NAME;
  private String LGPL_AGENT_NAME;
  private String LGPL_AGENT;
  private String LGPL_POL_NO;
  private String LGPL_BRANCH;
  private String LGPL_AOI;
  private String LGPL_COMM_RATE;
  private String LGPL_OV_COMM_RATE;
  private String LGPL_VAT_RATE;
  private String LGPL_DURATION;
  private String LGPL_FREQ_OF_PAY;
  private String LGPL_POL_CATEGORY;
  private BigDecimal LGPL_MULTI_EARNINGS;
  private BigDecimal LGPL_FCL;
  private BigDecimal LGPL_CODE;
  private String LGPL_REMARKS;
  private String LGPL_PENS_COMM_RATE;
  private String LGPL_PENS_PAYMENT_FREQ;
  private String LGPL_REGISTERED;
  private String LGPL_REG_NO;
  private String LGPL_PENS_TYPE;
  private String LGPL_CONTRI_TYPE;
  private BigDecimal LGPL_EMYE_CONTRI;
  private BigDecimal LGPL_EMYR_CONTRI;
  private String LGPL_MALE_NRD;
  private String LGPL_FEMALE_NRD;
  private String LGPL_GRNTD_PRD;
  private String LGPL_EARNINGS_ESC;
  private BigDecimal LGMD_SN;
  private String LGMD_SURNAME;
  private Date LGMD_DOB;
  private BigDecimal LGMD_ANB;
  private String LGMD_BASIC;
  private String LGMD_HOUSING;
  private String LGMD_TRANSPORT;
  private String LGMD_MONTH_SAL;
  private BigDecimal LGMD_TOT_EMUL;
  private BigDecimal LGMD_SA;
  private BigDecimal LGMD_PREM;
  private BigDecimal LGMD_PREM_RATE;
  private Date LGMD_DOJ;
  private Date LGMD_COVER_FROM_DATE;
  private BigDecimal LGMD_EMYR_BAL_BF;
  private BigDecimal LGMD_EMYE_BAL_BF;
  private BigDecimal LGMD_EMPYR_CONTRI;
  private BigDecimal LGMD_EMYE_CONTRI;
  private Date LGMD_LOAN_ISSUE_DATE;
  private BigDecimal LGMD_ORIG_LN_PRD;
  private BigDecimal LGMD_LOAN_INT;
  private BigDecimal LGMD_ORIG_LOAN_AMT;
  private String LGMD_CATEGORY;
  private BigDecimal LGMD_EARNINGS_PRD;
  private String LGMD_OCCUPATION;
  private String LGMD_POL_NO;
  private String LGCA_COINSURER;
  private String LGCA_COIN_SHARE;
  private String LGCA_POL_NO;
  private BigDecimal LGCA_AGN_CODE;
  private BigDecimal LGCA_CODE;
  private String LGCA_SCHEME;
  private String LGCA_CO_SHARE;
  private String LGRA_POL_NO;
  private String LGRA_MEM_NO;
  private BigDecimal LGRA_SA;
  private String LGRA_BEN_CODE;
  private String LGRA_BEN_TYPE;
  private BigDecimal LGRA_BEN_SA;
  private BigDecimal LGRA_BEN_RATE;
  private BigDecimal LGRA_BEN_PREM;
  private String LGCD_BANK_BRANCH;
  private BigDecimal LGCD_SN;
  private String LGCD_CLIENT_BANK_NAME;
  private String LGCD_OCCUPATION;
  private String LGCD_CLIENT_FAX;
  private String LGCD_AGENT_TEL;
  private String LGCD_CLIENT_TEL;
  private String LGCD_CLIENT_COUNTRY;
  private String LGCD_CLIENT_TOWN;
  private String LGCD_AGENT_ADDRESS;
  private String LGCD_CLIENT_ADDRESS;
  private String LGCD_NAME;
  private String LGCD_CLIENT_ID;
  private String LGCD_ACC_NO;
  private BigDecimal ACT_CODE;
  private String ACT_ACCOUNT_TYPE;
  private String PCP_POL_POLICY_NO;
  private String cqrRefNo;
  private String cqrNarrative;
  private String cqrFmsRemarks;
  private String crqPayee;
  private String cqrChqNo;
  private String cqrPmtVchno;
  private String cstDescription;
  private String policy_no;
  private String client;
  private BigDecimal cqrAmount;
  private Date cqrChequeDate;
  private BigDecimal prtsCode;
  private BigDecimal prtsUwYear;
  private BigDecimal prtsFiscalYear;
  private BigDecimal prtsFiscalMonth;
  private BigDecimal prtsCededPremium;
  private BigDecimal prtsReinComm;
  private BigDecimal prtsPremTax;
  private BigDecimal prtsReinPRemTax;
  private BigDecimal prtsClaimsIncurred;
  private BigDecimal prtsClaimsPaid;
  private BigDecimal prtsTrtCode;
  private BigDecimal prtsTaCode;
  private BigDecimal prtsAsCode;
  private String prodDesc;
  private BigDecimal TS_CODE;
  private BigDecimal TS_REI_CODE;
  private BigDecimal TS_TRT_CODE;
  private BigDecimal TS_TA_CODE;
  private BigDecimal TS_UW_YEAR;
  private BigDecimal TS_CUMM_CEDED_PREMIUM;
  private BigDecimal TS_CUMM_CEDED_CLAIMS;
  private BigDecimal TS_CUMM_CLAIMS_PAID;
  private BigDecimal TS_CUMM_PREM_TAX;
  private BigDecimal TS_CUMM_REIN_PREM_TAX;
  private BigDecimal TS_ENTRY_CLAIM_AMT;
  private BigDecimal TS_ENTRY_PREM_AMT;
  private BigDecimal TS_ENTRY_PORTFOLIO_LOSS;
  private BigDecimal TS_WITHDRAWAL_PREM_AMT;
  private BigDecimal TS_WITHDRAWAL_CLAIM_AMT;
  private BigDecimal TS_WITHDRAWAL_PROFIT_LOSS;
  private BigDecimal TS_MGT_EXPENSE_AMT;
  private BigDecimal TS_CUMM_REIN_COMM;
  private BigDecimal TS_FISCAL_YEAR;
  private BigDecimal TS_TRS_CODE;
  private BigDecimal TS_AS_CODE;
  private BigDecimal TS_INTEREST_TAX;
  private BigDecimal TS_INTEREST;
  private BigDecimal TS_PROFIT_COMM;
  private BigDecimal INCOME;
  private BigDecimal OUTGO;
  private BigDecimal PROFIT_LOSS;
  private String TS_TRS_SHT_DESC;
  private Date TS_TRAN_DATE;
  private BigDecimal TS_AMT_PAID;
  private String status;
  private String TS_DRCR_NO;
  private String TS_DRCR;
  private BigDecimal lmpMonthNo;
  private BigDecimal pndpTotAmt;
  private BigDecimal pndpAdminFee;
  private BigDecimal pndpVateAmt;
  private String lmpMonth;
  private boolean payTaxes;
  private String agnName;
  private BigDecimal tt_code;
  private String tt_sht_desc;
  private String tt_desc;
  private String tt_type;
  private String tt_type_desc;
  private String refNo;
  private String gtopReceiptNo;
  private String gtopDoneBy;
  private String gtopDrCr;
  private Date gtopReceiptDate;
  private BigDecimal gtopAmount;
  private boolean payRi;
  private BigDecimal crctdCode;
  private String memNo;
  private String memName;
  private String clientName;
  private BigDecimal amtPaid;
  private BigDecimal amtPayable;
  private String causDesc;
  private String coverDesc;
  private BigDecimal ccrCode;
  private BigDecimal coinAmtPaid;
  private BigDecimal coinAmtPayable;
  private String coinMemNo;
  private String coinMemName;
  private String coinCausDesc;
  private String coinCoverDesc;
  private String coinRefNo;
  private String coinAgnName;
  private String coinClient;
  private boolean coinSelect;
  private boolean riSelect;
  private String TS_VOUCHER_NO;
  private String coinPeriod;
  private String riPeriod;
  private Date cpvDateAuth;
  private Date cqrChqDispactDate;
  private BigDecimal empyr_reg_transfer;
  private BigDecimal empyr_unreg_transfer;
  private BigDecimal empye_reg_transfer;
  private BigDecimal empye_unreg_transfer;
  private BigDecimal totalChequeAmt;
  
  public void setMTRAN_REF_NO(String MTRAN_REF_NO)
  {
    this.MTRAN_REF_NO = MTRAN_REF_NO;
  }
  
  public String getMTRAN_REF_NO()
  {
    return this.MTRAN_REF_NO;
  }
  
  public void setMTRAN_DATE(Date MTRAN_DATE)
  {
    this.MTRAN_DATE = MTRAN_DATE;
  }
  
  public Date getMTRAN_DATE()
  {
    return this.MTRAN_DATE;
  }
  
  public void setMTRAN_DC(String MTRAN_DC)
  {
    this.MTRAN_DC = MTRAN_DC;
  }
  
  public String getMTRAN_DC()
  {
    return this.MTRAN_DC;
  }
  
  public void setMTRAN_AMOUNT(String MTRAN_AMOUNT)
  {
    this.MTRAN_AMOUNT = MTRAN_AMOUNT;
  }
  
  public String getMTRAN_AMOUNT()
  {
    return this.MTRAN_AMOUNT;
  }
  
  public void setMTRAN_COMMISSION(String MTRAN_COMMISSION)
  {
    this.MTRAN_COMMISSION = MTRAN_COMMISSION;
  }
  
  public String getMTRAN_COMMISSION()
  {
    return this.MTRAN_COMMISSION;
  }
  
  public void setMTRAN_COMM_PAID(String MTRAN_COMM_PAID)
  {
    this.MTRAN_COMM_PAID = MTRAN_COMM_PAID;
  }
  
  public String getMTRAN_COMM_PAID()
  {
    return this.MTRAN_COMM_PAID;
  }
  
  public void setMTRAN_COMM_PAYABLE(String MTRAN_COMM_PAYABLE)
  {
    this.MTRAN_COMM_PAYABLE = MTRAN_COMM_PAYABLE;
  }
  
  public String getMTRAN_COMM_PAYABLE()
  {
    return this.MTRAN_COMM_PAYABLE;
  }
  
  public void setMTRAN_BALANCE(String MTRAN_BALANCE)
  {
    this.MTRAN_BALANCE = MTRAN_BALANCE;
  }
  
  public String getMTRAN_BALANCE()
  {
    return this.MTRAN_BALANCE;
  }
  
  public void setMTRAN_CODE(BigDecimal MTRAN_CODE)
  {
    this.MTRAN_CODE = MTRAN_CODE;
  }
  
  public BigDecimal getMTRAN_CODE()
  {
    return this.MTRAN_CODE;
  }
  
  public void setAmount(String amount)
  {
    this.amount = amount;
  }
  
  public String getAmount()
  {
    return this.amount;
  }
  
  public void setCRA_MTRAN_REF_NO(String CRA_MTRAN_REF_NO)
  {
    this.CRA_MTRAN_REF_NO = CRA_MTRAN_REF_NO;
  }
  
  public String getCRA_MTRAN_REF_NO()
  {
    return this.CRA_MTRAN_REF_NO;
  }
  
  public void setCRA_MTRAN_DATE(Date CRA_MTRAN_DATE)
  {
    this.CRA_MTRAN_DATE = CRA_MTRAN_DATE;
  }
  
  public Date getCRA_MTRAN_DATE()
  {
    return this.CRA_MTRAN_DATE;
  }
  
  public void setCRA_MTRAN_DC(String CRA_MTRAN_DC)
  {
    this.CRA_MTRAN_DC = CRA_MTRAN_DC;
  }
  
  public String getCRA_MTRAN_DC()
  {
    return this.CRA_MTRAN_DC;
  }
  
  public void setCRA_MTRAN_AMOUNT(String CRA_MTRAN_AMOUNT)
  {
    this.CRA_MTRAN_AMOUNT = CRA_MTRAN_AMOUNT;
  }
  
  public String getCRA_MTRAN_AMOUNT()
  {
    return this.CRA_MTRAN_AMOUNT;
  }
  
  public void setCRA_MTRAN_COMMISSION(String CRA_MTRAN_COMMISSION)
  {
    this.CRA_MTRAN_COMMISSION = CRA_MTRAN_COMMISSION;
  }
  
  public String getCRA_MTRAN_COMMISSION()
  {
    return this.CRA_MTRAN_COMMISSION;
  }
  
  public void setCRA_MTRAN_COMM_PAID(String CRA_MTRAN_COMM_PAID)
  {
    this.CRA_MTRAN_COMM_PAID = CRA_MTRAN_COMM_PAID;
  }
  
  public String getCRA_MTRAN_COMM_PAID()
  {
    return this.CRA_MTRAN_COMM_PAID;
  }
  
  public void setCRA_MTRAN_COMM_PAYABLE(String CRA_MTRAN_COMM_PAYABLE)
  {
    this.CRA_MTRAN_COMM_PAYABLE = CRA_MTRAN_COMM_PAYABLE;
  }
  
  public String getCRA_MTRAN_COMM_PAYABLE()
  {
    return this.CRA_MTRAN_COMM_PAYABLE;
  }
  
  public void setCRA_MTRAN_BALANCE(String CRA_MTRAN_BALANCE)
  {
    this.CRA_MTRAN_BALANCE = CRA_MTRAN_BALANCE;
  }
  
  public String getCRA_MTRAN_BALANCE()
  {
    return this.CRA_MTRAN_BALANCE;
  }
  
  public void setCRA_MTRAN_CODE(BigDecimal CRA_MTRAN_CODE)
  {
    this.CRA_MTRAN_CODE = CRA_MTRAN_CODE;
  }
  
  public BigDecimal getCRA_MTRAN_CODE()
  {
    return this.CRA_MTRAN_CODE;
  }
  
  public void setCRA_amount(String CRA_amount)
  {
    this.CRA_amount = CRA_amount;
  }
  
  public String getCRA_amount()
  {
    return this.CRA_amount;
  }
  
  public void setDBA_MTRAN_REF_NO(String DBA_MTRAN_REF_NO)
  {
    this.DBA_MTRAN_REF_NO = DBA_MTRAN_REF_NO;
  }
  
  public String getDBA_MTRAN_REF_NO()
  {
    return this.DBA_MTRAN_REF_NO;
  }
  
  public void setDBA_MTRAN_DATE(Date DBA_MTRAN_DATE)
  {
    this.DBA_MTRAN_DATE = DBA_MTRAN_DATE;
  }
  
  public Date getDBA_MTRAN_DATE()
  {
    return this.DBA_MTRAN_DATE;
  }
  
  public void setDBA_MTRAN_DC(String DBA_MTRAN_DC)
  {
    this.DBA_MTRAN_DC = DBA_MTRAN_DC;
  }
  
  public String getDBA_MTRAN_DC()
  {
    return this.DBA_MTRAN_DC;
  }
  
  public void setDBA_GROSS_AMOUNT(String DBA_GROSS_AMOUNT)
  {
    this.DBA_GROSS_AMOUNT = DBA_GROSS_AMOUNT;
  }
  
  public String getDBA_GROSS_AMOUNT()
  {
    return this.DBA_GROSS_AMOUNT;
  }
  
  public void setDBA_NET_AMOUNT(String DBA_NET_AMOUNT)
  {
    this.DBA_NET_AMOUNT = DBA_NET_AMOUNT;
  }
  
  public String getDBA_NET_AMOUNT()
  {
    return this.DBA_NET_AMOUNT;
  }
  
  public void setDBA_MTRAN_SETTLED_AMT(String DBA_MTRAN_SETTLED_AMT)
  {
    this.DBA_MTRAN_SETTLED_AMT = DBA_MTRAN_SETTLED_AMT;
  }
  
  public String getDBA_MTRAN_SETTLED_AMT()
  {
    return this.DBA_MTRAN_SETTLED_AMT;
  }
  
  public void setDBA_MTRAN_BALANCE(String DBA_MTRAN_BALANCE)
  {
    this.DBA_MTRAN_BALANCE = DBA_MTRAN_BALANCE;
  }
  
  public String getDBA_MTRAN_BALANCE()
  {
    return this.DBA_MTRAN_BALANCE;
  }
  
  public void setDBA_MTRAN_COMMISSION(String DBA_MTRAN_COMMISSION)
  {
    this.DBA_MTRAN_COMMISSION = DBA_MTRAN_COMMISSION;
  }
  
  public String getDBA_MTRAN_COMMISSION()
  {
    return this.DBA_MTRAN_COMMISSION;
  }
  
  public void setDBA_MTRAN_COMM_PAID(String DBA_MTRAN_COMM_PAID)
  {
    this.DBA_MTRAN_COMM_PAID = DBA_MTRAN_COMM_PAID;
  }
  
  public String getDBA_MTRAN_COMM_PAID()
  {
    return this.DBA_MTRAN_COMM_PAID;
  }
  
  public void setDBA_MTRAN_COMM_PAYABLE(String DBA_MTRAN_COMM_PAYABLE)
  {
    this.DBA_MTRAN_COMM_PAYABLE = DBA_MTRAN_COMM_PAYABLE;
  }
  
  public String getDBA_MTRAN_COMM_PAYABLE()
  {
    return this.DBA_MTRAN_COMM_PAYABLE;
  }
  
  public void setDBA_MTRAN_CODE(BigDecimal DBA_MTRAN_CODE)
  {
    this.DBA_MTRAN_CODE = DBA_MTRAN_CODE;
  }
  
  public BigDecimal getDBA_MTRAN_CODE()
  {
    return this.DBA_MTRAN_CODE;
  }
  
  public void setDBA_amount(String DBA_amount)
  {
    this.DBA_amount = DBA_amount;
  }
  
  public String getDBA_amount()
  {
    return this.DBA_amount;
  }
  
  public void setDBT_MTRAN_REF_NO(String DBT_MTRAN_REF_NO)
  {
    this.DBT_MTRAN_REF_NO = DBT_MTRAN_REF_NO;
  }
  
  public String getDBT_MTRAN_REF_NO()
  {
    return this.DBT_MTRAN_REF_NO;
  }
  
  public void setDBT_MTRAN_DATE(Date DBT_MTRAN_DATE)
  {
    this.DBT_MTRAN_DATE = DBT_MTRAN_DATE;
  }
  
  public Date getDBT_MTRAN_DATE()
  {
    return this.DBT_MTRAN_DATE;
  }
  
  public void setDBT_MTRAN_DC(String DBT_MTRAN_DC)
  {
    this.DBT_MTRAN_DC = DBT_MTRAN_DC;
  }
  
  public String getDBT_MTRAN_DC()
  {
    return this.DBT_MTRAN_DC;
  }
  
  public void setDBT_GROSS_AMOUNT(String DBT_GROSS_AMOUNT)
  {
    this.DBT_GROSS_AMOUNT = DBT_GROSS_AMOUNT;
  }
  
  public String getDBT_GROSS_AMOUNT()
  {
    return this.DBT_GROSS_AMOUNT;
  }
  
  public void setDBT_NET_AMOUNT(String DBT_NET_AMOUNT)
  {
    this.DBT_NET_AMOUNT = DBT_NET_AMOUNT;
  }
  
  public String getDBT_NET_AMOUNT()
  {
    return this.DBT_NET_AMOUNT;
  }
  
  public void setDBT_MTRAN_SETTLED_AMT(String DBT_MTRAN_SETTLED_AMT)
  {
    this.DBT_MTRAN_SETTLED_AMT = DBT_MTRAN_SETTLED_AMT;
  }
  
  public String getDBT_MTRAN_SETTLED_AMT()
  {
    return this.DBT_MTRAN_SETTLED_AMT;
  }
  
  public void setDBT_MTRAN_BALANCE(String DBT_MTRAN_BALANCE)
  {
    this.DBT_MTRAN_BALANCE = DBT_MTRAN_BALANCE;
  }
  
  public String getDBT_MTRAN_BALANCE()
  {
    return this.DBT_MTRAN_BALANCE;
  }
  
  public void setDBT_MTRAN_COMMISSION(String DBT_MTRAN_COMMISSION)
  {
    this.DBT_MTRAN_COMMISSION = DBT_MTRAN_COMMISSION;
  }
  
  public String getDBT_MTRAN_COMMISSION()
  {
    return this.DBT_MTRAN_COMMISSION;
  }
  
  public void setDBT_MTRAN_COMM_PAID(String DBT_MTRAN_COMM_PAID)
  {
    this.DBT_MTRAN_COMM_PAID = DBT_MTRAN_COMM_PAID;
  }
  
  public String getDBT_MTRAN_COMM_PAID()
  {
    return this.DBT_MTRAN_COMM_PAID;
  }
  
  public void setDBT_MTRAN_COMM_PAYABLE(String DBT_MTRAN_COMM_PAYABLE)
  {
    this.DBT_MTRAN_COMM_PAYABLE = DBT_MTRAN_COMM_PAYABLE;
  }
  
  public String getDBT_MTRAN_COMM_PAYABLE()
  {
    return this.DBT_MTRAN_COMM_PAYABLE;
  }
  
  public void setDBT_MTRAN_CODE(BigDecimal DBT_MTRAN_CODE)
  {
    this.DBT_MTRAN_CODE = DBT_MTRAN_CODE;
  }
  
  public BigDecimal getDBT_MTRAN_CODE()
  {
    return this.DBT_MTRAN_CODE;
  }
  
  public void setDBT_amount(String DBT_amount)
  {
    this.DBT_amount = DBT_amount;
  }
  
  public String getDBT_amount()
  {
    return this.DBT_amount;
  }
  
  public void setTMAP_DR_MTRAN_REF_NO(String TMAP_DR_MTRAN_REF_NO)
  {
    this.TMAP_DR_MTRAN_REF_NO = TMAP_DR_MTRAN_REF_NO;
  }
  
  public String getTMAP_DR_MTRAN_REF_NO()
  {
    return this.TMAP_DR_MTRAN_REF_NO;
  }
  
  public void setTmap_code(BigDecimal tmap_code)
  {
    this.tmap_code = tmap_code;
  }
  
  public BigDecimal getTmap_code()
  {
    return this.tmap_code;
  }
  
  public void setTMAP_AMOUNT(String TMAP_AMOUNT)
  {
    this.TMAP_AMOUNT = TMAP_AMOUNT;
  }
  
  public String getTMAP_AMOUNT()
  {
    return this.TMAP_AMOUNT;
  }
  
  public void setTMAP_DR_MTRAN_CODE(BigDecimal TMAP_DR_MTRAN_CODE)
  {
    this.TMAP_DR_MTRAN_CODE = TMAP_DR_MTRAN_CODE;
  }
  
  public BigDecimal getTMAP_DR_MTRAN_CODE()
  {
    return this.TMAP_DR_MTRAN_CODE;
  }
  
  public void setPCP_CODE(BigDecimal PCP_CODE)
  {
    this.PCP_CODE = PCP_CODE;
  }
  
  public BigDecimal getPCP_CODE()
  {
    return this.PCP_CODE;
  }
  
  public void setAGENT_DISPLAY(String AGENT_DISPLAY)
  {
    this.AGENT_DISPLAY = AGENT_DISPLAY;
  }
  
  public String getAGENT_DISPLAY()
  {
    return this.AGENT_DISPLAY;
  }
  
  public void setPCP_AGN_UNIT_MGR(String PCP_AGN_UNIT_MGR)
  {
    this.PCP_AGN_UNIT_MGR = PCP_AGN_UNIT_MGR;
  }
  
  public String getPCP_AGN_UNIT_MGR()
  {
    return this.PCP_AGN_UNIT_MGR;
  }
  
  public void setBRANCH_DISPLAY(String BRANCH_DISPLAY)
  {
    this.BRANCH_DISPLAY = BRANCH_DISPLAY;
  }
  
  public String getBRANCH_DISPLAY()
  {
    return this.BRANCH_DISPLAY;
  }
  
  public void setPCP_COMM_AMT(String PCP_COMM_AMT)
  {
    this.PCP_COMM_AMT = PCP_COMM_AMT;
  }
  
  public String getPCP_COMM_AMT()
  {
    return this.PCP_COMM_AMT;
  }
  
  public void setPCP_WHDTAX_AMT(String PCP_WHDTAX_AMT)
  {
    this.PCP_WHDTAX_AMT = PCP_WHDTAX_AMT;
  }
  
  public String getPCP_WHDTAX_AMT()
  {
    return this.PCP_WHDTAX_AMT;
  }
  
  public void setPCP_OVRIDE_COMM_AMT(String PCP_OVRIDE_COMM_AMT)
  {
    this.PCP_OVRIDE_COMM_AMT = PCP_OVRIDE_COMM_AMT;
  }
  
  public String getPCP_OVRIDE_COMM_AMT()
  {
    return this.PCP_OVRIDE_COMM_AMT;
  }
  
  public void setPCP_OVRIDE_WHDTAX_AMT(String PCP_OVRIDE_WHDTAX_AMT)
  {
    this.PCP_OVRIDE_WHDTAX_AMT = PCP_OVRIDE_WHDTAX_AMT;
  }
  
  public String getPCP_OVRIDE_WHDTAX_AMT()
  {
    return this.PCP_OVRIDE_WHDTAX_AMT;
  }
  
  public void setPCP_NET_COMM(String PCP_NET_COMM)
  {
    this.PCP_NET_COMM = PCP_NET_COMM;
  }
  
  public String getPCP_NET_COMM()
  {
    return this.PCP_NET_COMM;
  }
  
  public void setPCP_PAID(String PCP_PAID)
  {
    this.PCP_PAID = PCP_PAID;
  }
  
  public String getPCP_PAID()
  {
    return this.PCP_PAID;
  }
  
  public void setPOL_CODE(BigDecimal POL_CODE)
  {
    this.POL_CODE = POL_CODE;
  }
  
  public BigDecimal getPOL_CODE()
  {
    return this.POL_CODE;
  }
  
  public void setPOL_POLICY_NO(String POL_POLICY_NO)
  {
    this.POL_POLICY_NO = POL_POLICY_NO;
  }
  
  public String getPOL_POLICY_NO()
  {
    return this.POL_POLICY_NO;
  }
  
  public void setPRP_NAME(String PRP_NAME)
  {
    this.PRP_NAME = PRP_NAME;
  }
  
  public String getPRP_NAME()
  {
    return this.PRP_NAME;
  }
  
  public void setMTRAN_TRAN_TYPE(String MTRAN_TRAN_TYPE)
  {
    this.MTRAN_TRAN_TYPE = MTRAN_TRAN_TYPE;
  }
  
  public String getMTRAN_TRAN_TYPE()
  {
    return this.MTRAN_TRAN_TYPE;
  }
  
  public void setCRA_MTRAN_TRAN_TYPE(String CRA_MTRAN_TRAN_TYPE)
  {
    this.CRA_MTRAN_TRAN_TYPE = CRA_MTRAN_TRAN_TYPE;
  }
  
  public String getCRA_MTRAN_TRAN_TYPE()
  {
    return this.CRA_MTRAN_TRAN_TYPE;
  }
  
  public void setDBA_MTRAN_TRAN_TYPE(String DBA_MTRAN_TRAN_TYPE)
  {
    this.DBA_MTRAN_TRAN_TYPE = DBA_MTRAN_TRAN_TYPE;
  }
  
  public String getDBA_MTRAN_TRAN_TYPE()
  {
    return this.DBA_MTRAN_TRAN_TYPE;
  }
  
  public void setDBT_MTRAN_TRAN_TYPE(String DBT_MTRAN_TRAN_TYPE)
  {
    this.DBT_MTRAN_TRAN_TYPE = DBT_MTRAN_TRAN_TYPE;
  }
  
  public String getDBT_MTRAN_TRAN_TYPE()
  {
    return this.DBT_MTRAN_TRAN_TYPE;
  }
  
  public void setPCM_CODE(BigDecimal PCM_CODE)
  {
    this.PCM_CODE = PCM_CODE;
  }
  
  public BigDecimal getPCM_CODE()
  {
    return this.PCM_CODE;
  }
  
  public void setMEMBER_DISPLAY(String MEMBER_DISPLAY)
  {
    this.MEMBER_DISPLAY = MEMBER_DISPLAY;
  }
  
  public String getMEMBER_DISPLAY()
  {
    return this.MEMBER_DISPLAY;
  }
  
  public void setPCM_EARNINGS(BigDecimal PCM_EARNINGS)
  {
    this.PCM_EARNINGS = PCM_EARNINGS;
  }
  
  public BigDecimal getPCM_EARNINGS()
  {
    return this.PCM_EARNINGS;
  }
  
  public void setPCM_PREMIUM(BigDecimal PCM_PREMIUM)
  {
    this.PCM_PREMIUM = PCM_PREMIUM;
  }
  
  public BigDecimal getPCM_PREMIUM()
  {
    return this.PCM_PREMIUM;
  }
  
  public void setPCM_PAID_AMOUNT(BigDecimal PCM_PAID_AMOUNT)
  {
    this.PCM_PAID_AMOUNT = PCM_PAID_AMOUNT;
  }
  
  public BigDecimal getPCM_PAID_AMOUNT()
  {
    return this.PCM_PAID_AMOUNT;
  }
  
  public void setMEM_NO(String MEM_NO)
  {
    this.MEM_NO = MEM_NO;
  }
  
  public String getMEM_NO()
  {
    return this.MEM_NO;
  }
  
  public void setMIP_CODE(BigDecimal MIP_CODE)
  {
    this.MIP_CODE = MIP_CODE;
  }
  
  public BigDecimal getMIP_CODE()
  {
    return this.MIP_CODE;
  }
  
  public void setMIP_PCM_CODE(String MIP_PCM_CODE)
  {
    this.MIP_PCM_CODE = MIP_PCM_CODE;
  }
  
  public String getMIP_PCM_CODE()
  {
    return this.MIP_PCM_CODE;
  }
  
  public void setMIP_PCM_EARNINGS(BigDecimal MIP_PCM_EARNINGS)
  {
    this.MIP_PCM_EARNINGS = MIP_PCM_EARNINGS;
  }
  
  public BigDecimal getMIP_PCM_EARNINGS()
  {
    return this.MIP_PCM_EARNINGS;
  }
  
  public void setMIP_PCM_PREMIUM(BigDecimal MIP_PCM_PREMIUM)
  {
    this.MIP_PCM_PREMIUM = MIP_PCM_PREMIUM;
  }
  
  public BigDecimal getMIP_PCM_PREMIUM()
  {
    return this.MIP_PCM_PREMIUM;
  }
  
  public void setMIP_PCM_ALLOCATED_AMT(BigDecimal MIP_PCM_ALLOCATED_AMT)
  {
    this.MIP_PCM_ALLOCATED_AMT = MIP_PCM_ALLOCATED_AMT;
  }
  
  public BigDecimal getMIP_PCM_ALLOCATED_AMT()
  {
    return this.MIP_PCM_ALLOCATED_AMT;
  }
  
  public void setMIP_BATCH_NO(String MIP_BATCH_NO)
  {
    this.MIP_BATCH_NO = MIP_BATCH_NO;
  }
  
  public String getMIP_BATCH_NO()
  {
    return this.MIP_BATCH_NO;
  }
  
  public void setMIP_MEM_NO(String MIP_MEM_NO)
  {
    this.MIP_MEM_NO = MIP_MEM_NO;
  }
  
  public String getMIP_MEM_NO()
  {
    return this.MIP_MEM_NO;
  }
  
  public void setMIP_MEMBER_NAME(String MIP_MEMBER_NAME)
  {
    this.MIP_MEMBER_NAME = MIP_MEMBER_NAME;
  }
  
  public String getMIP_MEMBER_NAME()
  {
    return this.MIP_MEMBER_NAME;
  }
  
  public void setMEM_NO_DISPLAY(String MEM_NO_DISPLAY)
  {
    this.MEM_NO_DISPLAY = MEM_NO_DISPLAY;
  }
  
  public String getMEM_NO_DISPLAY()
  {
    return this.MEM_NO_DISPLAY;
  }
  
  public void setPEN_MEMBER_DISPLAY(String PEN_MEMBER_DISPLAY)
  {
    this.PEN_MEMBER_DISPLAY = PEN_MEMBER_DISPLAY;
  }
  
  public String getPEN_MEMBER_DISPLAY()
  {
    return this.PEN_MEMBER_DISPLAY;
  }
  
  public void setV_paid_er_amt(String v_paid_er_amt)
  {
    this.v_paid_er_amt = v_paid_er_amt;
  }
  
  public String getV_paid_er_amt()
  {
    return this.v_paid_er_amt;
  }
  
  public void setV_paid_ee_amt(String v_paid_ee_amt)
  {
    this.v_paid_ee_amt = v_paid_ee_amt;
  }
  
  public String getV_paid_ee_amt()
  {
    return this.v_paid_ee_amt;
  }
  
  public void setV_paid_ee_vol_amt(String v_paid_ee_vol_amt)
  {
    this.v_paid_ee_vol_amt = v_paid_ee_vol_amt;
  }
  
  public String getV_paid_ee_vol_amt()
  {
    return this.v_paid_ee_vol_amt;
  }
  
  public void setV_paid_er_vol_amt(String v_paid_er_vol_amt)
  {
    this.v_paid_er_vol_amt = v_paid_er_vol_amt;
  }
  
  public String getV_paid_er_vol_amt()
  {
    return this.v_paid_er_vol_amt;
  }
  
  public void setALLOCATED_AMOUNT(String ALLOCATED_AMOUNT)
  {
    this.ALLOCATED_AMOUNT = ALLOCATED_AMOUNT;
  }
  
  public String getALLOCATED_AMOUNT()
  {
    return this.ALLOCATED_AMOUNT;
  }
  
  public void setPAID_AMOUNT(String PAID_AMOUNT)
  {
    this.PAID_AMOUNT = PAID_AMOUNT;
  }
  
  public String getPAID_AMOUNT()
  {
    return this.PAID_AMOUNT;
  }
  
  public void setPMPNS_EARNINGS(String PMPNS_EARNINGS)
  {
    this.PMPNS_EARNINGS = PMPNS_EARNINGS;
  }
  
  public String getPMPNS_EARNINGS()
  {
    return this.PMPNS_EARNINGS;
  }
  
  public void setPMPNS_EMPLOYER_CONTR(String PMPNS_EMPLOYER_CONTR)
  {
    this.PMPNS_EMPLOYER_CONTR = PMPNS_EMPLOYER_CONTR;
  }
  
  public String getPMPNS_EMPLOYER_CONTR()
  {
    return this.PMPNS_EMPLOYER_CONTR;
  }
  
  public void setPMPNS_EMPLOYEE_CONTR(String PMPNS_EMPLOYEE_CONTR)
  {
    this.PMPNS_EMPLOYEE_CONTR = PMPNS_EMPLOYEE_CONTR;
  }
  
  public String getPMPNS_EMPLOYEE_CONTR()
  {
    return this.PMPNS_EMPLOYEE_CONTR;
  }
  
  public void setPMPNS_CODE(BigDecimal PMPNS_CODE)
  {
    this.PMPNS_CODE = PMPNS_CODE;
  }
  
  public BigDecimal getPMPNS_CODE()
  {
    return this.PMPNS_CODE;
  }
  
  public void setPCM_ALLOCATED_PREMIUM(BigDecimal PCM_ALLOCATED_PREMIUM)
  {
    this.PCM_ALLOCATED_PREMIUM = PCM_ALLOCATED_PREMIUM;
  }
  
  public BigDecimal getPCM_ALLOCATED_PREMIUM()
  {
    return this.PCM_ALLOCATED_PREMIUM;
  }
  
  public void setDIS_ENDR_NO(String DIS_ENDR_NO)
  {
    this.DIS_ENDR_NO = DIS_ENDR_NO;
  }
  
  public String getDIS_ENDR_NO()
  {
    return this.DIS_ENDR_NO;
  }
  
  public void setDIS_ENDR_CODE(BigDecimal DIS_ENDR_CODE)
  {
    this.DIS_ENDR_CODE = DIS_ENDR_CODE;
  }
  
  public BigDecimal getDIS_ENDR_CODE()
  {
    return this.DIS_ENDR_CODE;
  }
  
  public void setDIS_ENDR_TRANS_TYPE(String DIS_ENDR_TRANS_TYPE)
  {
    this.DIS_ENDR_TRANS_TYPE = DIS_ENDR_TRANS_TYPE;
  }
  
  public String getDIS_ENDR_TRANS_TYPE()
  {
    return this.DIS_ENDR_TRANS_TYPE;
  }
  
  public void setPNDP_CODE2(String PNDP_CODE2)
  {
    this.PNDP_CODE2 = PNDP_CODE2;
  }
  
  public String getPNDP_CODE2()
  {
    return this.PNDP_CODE2;
  }
  
  public void setPOLICY_NO(String POLICY_NO)
  {
    this.POLICY_NO = POLICY_NO;
  }
  
  public String getPOLICY_NO()
  {
    return this.POLICY_NO;
  }
  
  public void setAMOUNT(BigDecimal AMOUNT)
  {
    this.AMOUNT = AMOUNT;
  }
  
  public BigDecimal getAMOUNT()
  {
    return this.AMOUNT;
  }
  
  public void setLOADED(String LOADED)
  {
    this.LOADED = LOADED;
  }
  
  public String getLOADED()
  {
    return this.LOADED;
  }
  
  public void setLOADED_DESC(String LOADED_DESC)
  {
    this.LOADED_DESC = LOADED_DESC;
  }
  
  public String getLOADED_DESC()
  {
    return this.LOADED_DESC;
  }
  
  public void setLOAD_REMARKS(String LOAD_REMARKS)
  {
    this.LOAD_REMARKS = LOAD_REMARKS;
  }
  
  public String getLOAD_REMARKS()
  {
    return this.LOAD_REMARKS;
  }
  
  public void setLOAD_BY(String LOAD_BY)
  {
    this.LOAD_BY = LOAD_BY;
  }
  
  public String getLOAD_BY()
  {
    return this.LOAD_BY;
  }
  
  public void setLOAD_DATE(Date LOAD_DATE)
  {
    this.LOAD_DATE = LOAD_DATE;
  }
  
  public Date getLOAD_DATE()
  {
    return this.LOAD_DATE;
  }
  
  public void setBAL_DATE(Date BAL_DATE)
  {
    this.BAL_DATE = BAL_DATE;
  }
  
  public Date getBAL_DATE()
  {
    return this.BAL_DATE;
  }
  
  public void setGBL_CODE(BigDecimal GBL_CODE)
  {
    this.GBL_CODE = GBL_CODE;
  }
  
  public BigDecimal getGBL_CODE()
  {
    return this.GBL_CODE;
  }
  
  public void setSelected(boolean selected)
  {
    this.selected = selected;
  }
  
  public boolean getSelected()
  {
    return this.selected;
  }
  
  public void setGBL_DRCR(String GBL_DRCR)
  {
    this.GBL_DRCR = GBL_DRCR;
  }
  
  public String getGBL_DRCR()
  {
    return this.GBL_DRCR;
  }
  
  public void setPROD_CODE(BigDecimal PROD_CODE)
  {
    this.PROD_CODE = PROD_CODE;
  }
  
  public BigDecimal getPROD_CODE()
  {
    return this.PROD_CODE;
  }
  
  public void setPROD_DESC(String PROD_DESC)
  {
    this.PROD_DESC = PROD_DESC;
  }
  
  public String getPROD_DESC()
  {
    return this.PROD_DESC;
  }
  
  public void setBRN_CODE(BigDecimal BRN_CODE)
  {
    this.BRN_CODE = BRN_CODE;
  }
  
  public BigDecimal getBRN_CODE()
  {
    return this.BRN_CODE;
  }
  
  public void setBRN_NAME(String BRN_NAME)
  {
    this.BRN_NAME = BRN_NAME;
  }
  
  public String getBRN_NAME()
  {
    return this.BRN_NAME;
  }
  
  public void setPRP_CODE(BigDecimal PRP_CODE)
  {
    this.PRP_CODE = PRP_CODE;
  }
  
  public BigDecimal getPRP_CODE()
  {
    return this.PRP_CODE;
  }
  
  public void setCLIENT(String CLIENT)
  {
    this.CLIENT = CLIENT;
  }
  
  public String getCLIENT()
  {
    return this.CLIENT;
  }
  
  public void setGBL_FREQ_OF_PAY(String GBL_FREQ_OF_PAY)
  {
    this.GBL_FREQ_OF_PAY = GBL_FREQ_OF_PAY;
  }
  
  public String getGBL_FREQ_OF_PAY()
  {
    return this.GBL_FREQ_OF_PAY;
  }
  
  public void setGBL_DURATION_TYPE(String GBL_DURATION_TYPE)
  {
    this.GBL_DURATION_TYPE = GBL_DURATION_TYPE;
  }
  
  public String getGBL_DURATION_TYPE()
  {
    return this.GBL_DURATION_TYPE;
  }
  
  public void setGBL_EFFECTIVE_DATE(Date GBL_EFFECTIVE_DATE)
  {
    this.GBL_EFFECTIVE_DATE = GBL_EFFECTIVE_DATE;
  }
  
  public Date getGBL_EFFECTIVE_DATE()
  {
    return this.GBL_EFFECTIVE_DATE;
  }
  
  public void setAGN_CODE(BigDecimal AGN_CODE)
  {
    this.AGN_CODE = AGN_CODE;
  }
  
  public BigDecimal getAGN_CODE()
  {
    return this.AGN_CODE;
  }
  
  public void setAGN_NAME(String AGN_NAME)
  {
    this.AGN_NAME = AGN_NAME;
  }
  
  public String getAGN_NAME()
  {
    return this.AGN_NAME;
  }
  
  public void setPol_code(BigDecimal pol_code)
  {
    this.pol_code = pol_code;
  }
  
  public BigDecimal getPol_code()
  {
    return this.pol_code;
  }
  
  public void setPol_policy_no(String pol_policy_no)
  {
    this.pol_policy_no = pol_policy_no;
  }
  
  public String getPol_policy_no()
  {
    return this.pol_policy_no;
  }
  
  public void setInst_no(String inst_no)
  {
    this.inst_no = inst_no;
  }
  
  public String getInst_no()
  {
    return this.inst_no;
  }
  
  public void setOpr_receipt_date(Date opr_receipt_date)
  {
    this.opr_receipt_date = opr_receipt_date;
  }
  
  public Date getOpr_receipt_date()
  {
    return this.opr_receipt_date;
  }
  
  public void setInst_amt(BigDecimal inst_amt)
  {
    this.inst_amt = inst_amt;
  }
  
  public BigDecimal getInst_amt()
  {
    return this.inst_amt;
  }
  
  public void setComm_rate(BigDecimal comm_rate)
  {
    this.comm_rate = comm_rate;
  }
  
  public BigDecimal getComm_rate()
  {
    return this.comm_rate;
  }
  
  public void setComm_amt(BigDecimal comm_amt)
  {
    this.comm_amt = comm_amt;
  }
  
  public BigDecimal getComm_amt()
  {
    return this.comm_amt;
  }
  
  public void setWhdtax_rate(BigDecimal whdtax_rate)
  {
    this.whdtax_rate = whdtax_rate;
  }
  
  public BigDecimal getWhdtax_rate()
  {
    return this.whdtax_rate;
  }
  
  public void setWhdtax_amt(BigDecimal whdtax_amt)
  {
    this.whdtax_amt = whdtax_amt;
  }
  
  public BigDecimal getWhdtax_amt()
  {
    return this.whdtax_amt;
  }
  
  public void setTot_comm_display(BigDecimal tot_comm_display)
  {
    this.tot_comm_display = tot_comm_display;
  }
  
  public BigDecimal getTot_comm_display()
  {
    return this.tot_comm_display;
  }
  
  public void setDrcr(String drcr)
  {
    this.drcr = drcr;
  }
  
  public String getDrcr()
  {
    return this.drcr;
  }
  
  public void setCOP_CODE(BigDecimal COP_CODE)
  {
    this.COP_CODE = COP_CODE;
  }
  
  public BigDecimal getCOP_CODE()
  {
    return this.COP_CODE;
  }
  
  public void setCOP_AGN_UNIT_MGR(String COP_AGN_UNIT_MGR)
  {
    this.COP_AGN_UNIT_MGR = COP_AGN_UNIT_MGR;
  }
  
  public String getCOP_AGN_UNIT_MGR()
  {
    return this.COP_AGN_UNIT_MGR;
  }
  
  public void setCOP_COMM_AMT(BigDecimal COP_COMM_AMT)
  {
    this.COP_COMM_AMT = COP_COMM_AMT;
  }
  
  public BigDecimal getCOP_COMM_AMT()
  {
    return this.COP_COMM_AMT;
  }
  
  public void setCOP_WHDTAX_AMT(BigDecimal COP_WHDTAX_AMT)
  {
    this.COP_WHDTAX_AMT = COP_WHDTAX_AMT;
  }
  
  public BigDecimal getCOP_WHDTAX_AMT()
  {
    return this.COP_WHDTAX_AMT;
  }
  
  public void setCOP_OVRIDE_COMM_AMT(BigDecimal COP_OVRIDE_COMM_AMT)
  {
    this.COP_OVRIDE_COMM_AMT = COP_OVRIDE_COMM_AMT;
  }
  
  public BigDecimal getCOP_OVRIDE_COMM_AMT()
  {
    return this.COP_OVRIDE_COMM_AMT;
  }
  
  public void setCOP_OVRIDE_WHDTAX_AMT(BigDecimal COP_OVRIDE_WHDTAX_AMT)
  {
    this.COP_OVRIDE_WHDTAX_AMT = COP_OVRIDE_WHDTAX_AMT;
  }
  
  public BigDecimal getCOP_OVRIDE_WHDTAX_AMT()
  {
    return this.COP_OVRIDE_WHDTAX_AMT;
  }
  
  public void setCOP_ADVANCE_PYMT(BigDecimal COP_ADVANCE_PYMT)
  {
    this.COP_ADVANCE_PYMT = COP_ADVANCE_PYMT;
  }
  
  public BigDecimal getCOP_ADVANCE_PYMT()
  {
    return this.COP_ADVANCE_PYMT;
  }
  
  public void setCOP_DEDUCTIONS(BigDecimal COP_DEDUCTIONS)
  {
    this.COP_DEDUCTIONS = COP_DEDUCTIONS;
  }
  
  public BigDecimal getCOP_DEDUCTIONS()
  {
    return this.COP_DEDUCTIONS;
  }
  
  public void setCOP_BONUS_AMT(BigDecimal COP_BONUS_AMT)
  {
    this.COP_BONUS_AMT = COP_BONUS_AMT;
  }
  
  public BigDecimal getCOP_BONUS_AMT()
  {
    return this.COP_BONUS_AMT;
  }
  
  public void setCOP_BONUS_WHDTAX_AMT(BigDecimal COP_BONUS_WHDTAX_AMT)
  {
    this.COP_BONUS_WHDTAX_AMT = COP_BONUS_WHDTAX_AMT;
  }
  
  public BigDecimal getCOP_BONUS_WHDTAX_AMT()
  {
    return this.COP_BONUS_WHDTAX_AMT;
  }
  
  public void setTOTAL_AMT_DISPLAY(BigDecimal TOTAL_AMT_DISPLAY)
  {
    this.TOTAL_AMT_DISPLAY = TOTAL_AMT_DISPLAY;
  }
  
  public BigDecimal getTOTAL_AMT_DISPLAY()
  {
    return this.TOTAL_AMT_DISPLAY;
  }
  
  public void setCOP_DRCR(String COP_DRCR)
  {
    this.COP_DRCR = COP_DRCR;
  }
  
  public String getCOP_DRCR()
  {
    return this.COP_DRCR;
  }
  
  public void setOpr_receipt_no(String opr_receipt_no)
  {
    this.opr_receipt_no = opr_receipt_no;
  }
  
  public String getOpr_receipt_no()
  {
    return this.opr_receipt_no;
  }
  
  public void setGrct_code(BigDecimal grct_code)
  {
    this.grct_code = grct_code;
  }
  
  public BigDecimal getGrct_code()
  {
    return this.grct_code;
  }
  
  public void setLGPL_SN(BigDecimal LGPL_SN)
  {
    this.LGPL_SN = LGPL_SN;
  }
  
  public BigDecimal getLGPL_SN()
  {
    return this.LGPL_SN;
  }
  
  public void setLGPL_CLIENT(String LGPL_CLIENT)
  {
    this.LGPL_CLIENT = LGPL_CLIENT;
  }
  
  public String getLGPL_CLIENT()
  {
    return this.LGPL_CLIENT;
  }
  
  public void setLGPL_NO_MEM(BigDecimal LGPL_NO_MEM)
  {
    this.LGPL_NO_MEM = LGPL_NO_MEM;
  }
  
  public BigDecimal getLGPL_NO_MEM()
  {
    return this.LGPL_NO_MEM;
  }
  
  public void setLGPL_SHARE(String LGPL_SHARE)
  {
    this.LGPL_SHARE = LGPL_SHARE;
  }
  
  public String getLGPL_SHARE()
  {
    return this.LGPL_SHARE;
  }
  
  public void setLGPL_COMMENC_DT(Date LGPL_COMMENC_DT)
  {
    this.LGPL_COMMENC_DT = LGPL_COMMENC_DT;
  }
  
  public Date getLGPL_COMMENC_DT()
  {
    return this.LGPL_COMMENC_DT;
  }
  
  public void setLGPL_RENEW_DT(Date LGPL_RENEW_DT)
  {
    this.LGPL_RENEW_DT = LGPL_RENEW_DT;
  }
  
  public Date getLGPL_RENEW_DT()
  {
    return this.LGPL_RENEW_DT;
  }
  
  public void setLGPL_NEXT_REN_DT(Date LGPL_NEXT_REN_DT)
  {
    this.LGPL_NEXT_REN_DT = LGPL_NEXT_REN_DT;
  }
  
  public Date getLGPL_NEXT_REN_DT()
  {
    return this.LGPL_NEXT_REN_DT;
  }
  
  public void setLGPL_RATES(String LGPL_RATES)
  {
    this.LGPL_RATES = LGPL_RATES;
  }
  
  public String getLGPL_RATES()
  {
    return this.LGPL_RATES;
  }
  
  public void setLGPL_TOT_SA(BigDecimal LGPL_TOT_SA)
  {
    this.LGPL_TOT_SA = LGPL_TOT_SA;
  }
  
  public BigDecimal getLGPL_TOT_SA()
  {
    return this.LGPL_TOT_SA;
  }
  
  public void setLGPL_TOT_PREM(BigDecimal LGPL_TOT_PREM)
  {
    this.LGPL_TOT_PREM = LGPL_TOT_PREM;
  }
  
  public BigDecimal getLGPL_TOT_PREM()
  {
    return this.LGPL_TOT_PREM;
  }
  
  public void setLGPL_TOT_PREM_PAID(BigDecimal LGPL_TOT_PREM_PAID)
  {
    this.LGPL_TOT_PREM_PAID = LGPL_TOT_PREM_PAID;
  }
  
  public BigDecimal getLGPL_TOT_PREM_PAID()
  {
    return this.LGPL_TOT_PREM_PAID;
  }
  
  public void setLGPL_OUTS_PREM(BigDecimal LGPL_OUTS_PREM)
  {
    this.LGPL_OUTS_PREM = LGPL_OUTS_PREM;
  }
  
  public BigDecimal getLGPL_OUTS_PREM()
  {
    return this.LGPL_OUTS_PREM;
  }
  
  public void setLGPL_PROD_NAME(String LGPL_PROD_NAME)
  {
    this.LGPL_PROD_NAME = LGPL_PROD_NAME;
  }
  
  public String getLGPL_PROD_NAME()
  {
    return this.LGPL_PROD_NAME;
  }
  
  public void setLGPL_AGENT_NAME(String LGPL_AGENT_NAME)
  {
    this.LGPL_AGENT_NAME = LGPL_AGENT_NAME;
  }
  
  public String getLGPL_AGENT_NAME()
  {
    return this.LGPL_AGENT_NAME;
  }
  
  public void setLGPL_AGENT(String LGPL_AGENT)
  {
    this.LGPL_AGENT = LGPL_AGENT;
  }
  
  public String getLGPL_AGENT()
  {
    return this.LGPL_AGENT;
  }
  
  public void setLGPL_POL_NO(String LGPL_POL_NO)
  {
    this.LGPL_POL_NO = LGPL_POL_NO;
  }
  
  public String getLGPL_POL_NO()
  {
    return this.LGPL_POL_NO;
  }
  
  public void setLGPL_BRANCH(String LGPL_BRANCH)
  {
    this.LGPL_BRANCH = LGPL_BRANCH;
  }
  
  public String getLGPL_BRANCH()
  {
    return this.LGPL_BRANCH;
  }
  
  public void setLGPL_AOI(String LGPL_AOI)
  {
    this.LGPL_AOI = LGPL_AOI;
  }
  
  public String getLGPL_AOI()
  {
    return this.LGPL_AOI;
  }
  
  public void setLGPL_COMM_RATE(String LGPL_COMM_RATE)
  {
    this.LGPL_COMM_RATE = LGPL_COMM_RATE;
  }
  
  public String getLGPL_COMM_RATE()
  {
    return this.LGPL_COMM_RATE;
  }
  
  public void setLGPL_OV_COMM_RATE(String LGPL_OV_COMM_RATE)
  {
    this.LGPL_OV_COMM_RATE = LGPL_OV_COMM_RATE;
  }
  
  public String getLGPL_OV_COMM_RATE()
  {
    return this.LGPL_OV_COMM_RATE;
  }
  
  public void setLGPL_VAT_RATE(String LGPL_VAT_RATE)
  {
    this.LGPL_VAT_RATE = LGPL_VAT_RATE;
  }
  
  public String getLGPL_VAT_RATE()
  {
    return this.LGPL_VAT_RATE;
  }
  
  public void setLGPL_DURATION(String LGPL_DURATION)
  {
    this.LGPL_DURATION = LGPL_DURATION;
  }
  
  public String getLGPL_DURATION()
  {
    return this.LGPL_DURATION;
  }
  
  public void setLGPL_FREQ_OF_PAY(String LGPL_FREQ_OF_PAY)
  {
    this.LGPL_FREQ_OF_PAY = LGPL_FREQ_OF_PAY;
  }
  
  public String getLGPL_FREQ_OF_PAY()
  {
    return this.LGPL_FREQ_OF_PAY;
  }
  
  public void setLGPL_POL_CATEGORY(String LGPL_POL_CATEGORY)
  {
    this.LGPL_POL_CATEGORY = LGPL_POL_CATEGORY;
  }
  
  public String getLGPL_POL_CATEGORY()
  {
    return this.LGPL_POL_CATEGORY;
  }
  
  public void setLGPL_MULTI_EARNINGS(BigDecimal LGPL_MULTI_EARNINGS)
  {
    this.LGPL_MULTI_EARNINGS = LGPL_MULTI_EARNINGS;
  }
  
  public BigDecimal getLGPL_MULTI_EARNINGS()
  {
    return this.LGPL_MULTI_EARNINGS;
  }
  
  public void setLGPL_FCL(BigDecimal LGPL_FCL)
  {
    this.LGPL_FCL = LGPL_FCL;
  }
  
  public BigDecimal getLGPL_FCL()
  {
    return this.LGPL_FCL;
  }
  
  public void setLGPL_CODE(BigDecimal LGPL_CODE)
  {
    this.LGPL_CODE = LGPL_CODE;
  }
  
  public BigDecimal getLGPL_CODE()
  {
    return this.LGPL_CODE;
  }
  
  public void setLGPL_REMARKS(String LGPL_REMARKS)
  {
    this.LGPL_REMARKS = LGPL_REMARKS;
  }
  
  public String getLGPL_REMARKS()
  {
    return this.LGPL_REMARKS;
  }
  
  public void setLGMD_SN(BigDecimal LGMD_SN)
  {
    this.LGMD_SN = LGMD_SN;
  }
  
  public BigDecimal getLGMD_SN()
  {
    return this.LGMD_SN;
  }
  
  public void setLGMD_SURNAME(String LGMD_SURNAME)
  {
    this.LGMD_SURNAME = LGMD_SURNAME;
  }
  
  public String getLGMD_SURNAME()
  {
    return this.LGMD_SURNAME;
  }
  
  public void setLGMD_DOB(Date LGMD_DOB)
  {
    this.LGMD_DOB = LGMD_DOB;
  }
  
  public Date getLGMD_DOB()
  {
    return this.LGMD_DOB;
  }
  
  public void setLGMD_ANB(BigDecimal LGMD_ANB)
  {
    this.LGMD_ANB = LGMD_ANB;
  }
  
  public BigDecimal getLGMD_ANB()
  {
    return this.LGMD_ANB;
  }
  
  public void setLGMD_BASIC(String LGMD_BASIC)
  {
    this.LGMD_BASIC = LGMD_BASIC;
  }
  
  public String getLGMD_BASIC()
  {
    return this.LGMD_BASIC;
  }
  
  public void setLGMD_HOUSING(String LGMD_HOUSING)
  {
    this.LGMD_HOUSING = LGMD_HOUSING;
  }
  
  public String getLGMD_HOUSING()
  {
    return this.LGMD_HOUSING;
  }
  
  public void setLGMD_TRANSPORT(String LGMD_TRANSPORT)
  {
    this.LGMD_TRANSPORT = LGMD_TRANSPORT;
  }
  
  public String getLGMD_TRANSPORT()
  {
    return this.LGMD_TRANSPORT;
  }
  
  public void setLGMD_MONTH_SAL(String LGMD_MONTH_SAL)
  {
    this.LGMD_MONTH_SAL = LGMD_MONTH_SAL;
  }
  
  public String getLGMD_MONTH_SAL()
  {
    return this.LGMD_MONTH_SAL;
  }
  
  public void setLGMD_TOT_EMUL(BigDecimal LGMD_TOT_EMUL)
  {
    this.LGMD_TOT_EMUL = LGMD_TOT_EMUL;
  }
  
  public BigDecimal getLGMD_TOT_EMUL()
  {
    return this.LGMD_TOT_EMUL;
  }
  
  public void setLGMD_SA(BigDecimal LGMD_SA)
  {
    this.LGMD_SA = LGMD_SA;
  }
  
  public BigDecimal getLGMD_SA()
  {
    return this.LGMD_SA;
  }
  
  public void setLGMD_PREM(BigDecimal LGMD_PREM)
  {
    this.LGMD_PREM = LGMD_PREM;
  }
  
  public BigDecimal getLGMD_PREM()
  {
    return this.LGMD_PREM;
  }
  
  public void setLGMD_PREM_RATE(BigDecimal LGMD_PREM_RATE)
  {
    this.LGMD_PREM_RATE = LGMD_PREM_RATE;
  }
  
  public BigDecimal getLGMD_PREM_RATE()
  {
    return this.LGMD_PREM_RATE;
  }
  
  public void setLGMD_DOJ(Date LGMD_DOJ)
  {
    this.LGMD_DOJ = LGMD_DOJ;
  }
  
  public Date getLGMD_DOJ()
  {
    return this.LGMD_DOJ;
  }
  
  public void setLGMD_COVER_FROM_DATE(Date LGMD_COVER_FROM_DATE)
  {
    this.LGMD_COVER_FROM_DATE = LGMD_COVER_FROM_DATE;
  }
  
  public Date getLGMD_COVER_FROM_DATE()
  {
    return this.LGMD_COVER_FROM_DATE;
  }
  
  public void setLGCA_COINSURER(String LGCA_COINSURER)
  {
    this.LGCA_COINSURER = LGCA_COINSURER;
  }
  
  public String getLGCA_COINSURER()
  {
    return this.LGCA_COINSURER;
  }
  
  public void setLGCA_COIN_SHARE(String LGCA_COIN_SHARE)
  {
    this.LGCA_COIN_SHARE = LGCA_COIN_SHARE;
  }
  
  public String getLGCA_COIN_SHARE()
  {
    return this.LGCA_COIN_SHARE;
  }
  
  public void setLGCA_POL_NO(String LGCA_POL_NO)
  {
    this.LGCA_POL_NO = LGCA_POL_NO;
  }
  
  public String getLGCA_POL_NO()
  {
    return this.LGCA_POL_NO;
  }
  
  public void setLGCA_AGN_CODE(BigDecimal LGCA_AGN_CODE)
  {
    this.LGCA_AGN_CODE = LGCA_AGN_CODE;
  }
  
  public BigDecimal getLGCA_AGN_CODE()
  {
    return this.LGCA_AGN_CODE;
  }
  
  public void setLGCA_CODE(BigDecimal LGCA_CODE)
  {
    this.LGCA_CODE = LGCA_CODE;
  }
  
  public BigDecimal getLGCA_CODE()
  {
    return this.LGCA_CODE;
  }
  
  public void setLGRA_POL_NO(String LGRA_POL_NO)
  {
    this.LGRA_POL_NO = LGRA_POL_NO;
  }
  
  public String getLGRA_POL_NO()
  {
    return this.LGRA_POL_NO;
  }
  
  public void setLGRA_MEM_NO(String LGRA_MEM_NO)
  {
    this.LGRA_MEM_NO = LGRA_MEM_NO;
  }
  
  public String getLGRA_MEM_NO()
  {
    return this.LGRA_MEM_NO;
  }
  
  public void setLGRA_SA(BigDecimal LGRA_SA)
  {
    this.LGRA_SA = LGRA_SA;
  }
  
  public BigDecimal getLGRA_SA()
  {
    return this.LGRA_SA;
  }
  
  public void setLGRA_BEN_CODE(String LGRA_BEN_CODE)
  {
    this.LGRA_BEN_CODE = LGRA_BEN_CODE;
  }
  
  public String getLGRA_BEN_CODE()
  {
    return this.LGRA_BEN_CODE;
  }
  
  public void setLGRA_BEN_TYPE(String LGRA_BEN_TYPE)
  {
    this.LGRA_BEN_TYPE = LGRA_BEN_TYPE;
  }
  
  public String getLGRA_BEN_TYPE()
  {
    return this.LGRA_BEN_TYPE;
  }
  
  public void setLGRA_BEN_SA(BigDecimal LGRA_BEN_SA)
  {
    this.LGRA_BEN_SA = LGRA_BEN_SA;
  }
  
  public BigDecimal getLGRA_BEN_SA()
  {
    return this.LGRA_BEN_SA;
  }
  
  public void setLGRA_BEN_RATE(BigDecimal LGRA_BEN_RATE)
  {
    this.LGRA_BEN_RATE = LGRA_BEN_RATE;
  }
  
  public BigDecimal getLGRA_BEN_RATE()
  {
    return this.LGRA_BEN_RATE;
  }
  
  public void setLGRA_BEN_PREM(BigDecimal LGRA_BEN_PREM)
  {
    this.LGRA_BEN_PREM = LGRA_BEN_PREM;
  }
  
  public BigDecimal getLGRA_BEN_PREM()
  {
    return this.LGRA_BEN_PREM;
  }
  
  public void setCRA_MTRAN_ALLOC_MODE_DESC(String CRA_MTRAN_ALLOC_MODE_DESC)
  {
    this.CRA_MTRAN_ALLOC_MODE_DESC = CRA_MTRAN_ALLOC_MODE_DESC;
  }
  
  public String getCRA_MTRAN_ALLOC_MODE_DESC()
  {
    return this.CRA_MTRAN_ALLOC_MODE_DESC;
  }
  
  public void setCRA_MTRAN_ALLOC_MODE(String CRA_MTRAN_ALLOC_MODE)
  {
    this.CRA_MTRAN_ALLOC_MODE = CRA_MTRAN_ALLOC_MODE;
  }
  
  public String getCRA_MTRAN_ALLOC_MODE()
  {
    return this.CRA_MTRAN_ALLOC_MODE;
  }
  
  public void setENDR_COINSURANCE(String ENDR_COINSURANCE)
  {
    this.ENDR_COINSURANCE = ENDR_COINSURANCE;
  }
  
  public String getENDR_COINSURANCE()
  {
    return this.ENDR_COINSURANCE;
  }
  
  public void setLPR_CODE(BigDecimal LPR_CODE)
  {
    this.LPR_CODE = LPR_CODE;
  }
  
  public BigDecimal getLPR_CODE()
  {
    return this.LPR_CODE;
  }
  
  public void setLPR_AMOUNT_TO_PAY(BigDecimal LPR_AMOUNT_TO_PAY)
  {
    this.LPR_AMOUNT_TO_PAY = LPR_AMOUNT_TO_PAY;
  }
  
  public BigDecimal getLPR_AMOUNT_TO_PAY()
  {
    return this.LPR_AMOUNT_TO_PAY;
  }
  
  public void setLPR_RAISED_BY(String LPR_RAISED_BY)
  {
    this.LPR_RAISED_BY = LPR_RAISED_BY;
  }
  
  public String getLPR_RAISED_BY()
  {
    return this.LPR_RAISED_BY;
  }
  
  public void setLPR_DATE_DONE(Date LPR_DATE_DONE)
  {
    this.LPR_DATE_DONE = LPR_DATE_DONE;
  }
  
  public Date getLPR_DATE_DONE()
  {
    return this.LPR_DATE_DONE;
  }
  
  public void setLPR_PAID(String LPR_PAID)
  {
    this.LPR_PAID = LPR_PAID;
  }
  
  public String getLPR_PAID()
  {
    return this.LPR_PAID;
  }
  
  public void setLPR_VOUCHER_NO(String LPR_VOUCHER_NO)
  {
    this.LPR_VOUCHER_NO = LPR_VOUCHER_NO;
  }
  
  public String getLPR_VOUCHER_NO()
  {
    return this.LPR_VOUCHER_NO;
  }
  
  public void setLPR_AUTHORISED_BY(String LPR_AUTHORISED_BY)
  {
    this.LPR_AUTHORISED_BY = LPR_AUTHORISED_BY;
  }
  
  public String getLPR_AUTHORISED_BY()
  {
    return this.LPR_AUTHORISED_BY;
  }
  
  public void setLPR_AUTHORISED_DATE(Date LPR_AUTHORISED_DATE)
  {
    this.LPR_AUTHORISED_DATE = LPR_AUTHORISED_DATE;
  }
  
  public Date getLPR_AUTHORISED_DATE()
  {
    return this.LPR_AUTHORISED_DATE;
  }
  
  public void setMtran_rcpt_reserve_amt(BigDecimal mtran_rcpt_reserve_amt)
  {
    this.mtran_rcpt_reserve_amt = mtran_rcpt_reserve_amt;
  }
  
  public BigDecimal getMtran_rcpt_reserve_amt()
  {
    return this.mtran_rcpt_reserve_amt;
  }
  
  public void setMtran_lms_receipt_pk(BigDecimal mtran_lms_receipt_pk)
  {
    this.mtran_lms_receipt_pk = mtran_lms_receipt_pk;
  }
  
  public BigDecimal getMtran_lms_receipt_pk()
  {
    return this.mtran_lms_receipt_pk;
  }
  
  public void setPcp_code(BigDecimal pcp_code)
  {
    this.pcp_code = pcp_code;
  }
  
  public BigDecimal getPcp_code()
  {
    return this.pcp_code;
  }
  
  public void setPCM_ENDR_CODE(BigDecimal PCM_ENDR_CODE)
  {
    this.PCM_ENDR_CODE = PCM_ENDR_CODE;
  }
  
  public BigDecimal getPCM_ENDR_CODE()
  {
    return this.PCM_ENDR_CODE;
  }
  
  public void setPCM_POLM_CODE(BigDecimal PCM_POLM_CODE)
  {
    this.PCM_POLM_CODE = PCM_POLM_CODE;
  }
  
  public BigDecimal getPCM_POLM_CODE()
  {
    return this.PCM_POLM_CODE;
  }
  
  public void setLGMD_EMYR_BAL_BF(BigDecimal LGMD_EMYR_BAL_BF)
  {
    this.LGMD_EMYR_BAL_BF = LGMD_EMYR_BAL_BF;
  }
  
  public BigDecimal getLGMD_EMYR_BAL_BF()
  {
    return this.LGMD_EMYR_BAL_BF;
  }
  
  public void setLGMD_EMYE_BAL_BF(BigDecimal LGMD_EMYE_BAL_BF)
  {
    this.LGMD_EMYE_BAL_BF = LGMD_EMYE_BAL_BF;
  }
  
  public BigDecimal getLGMD_EMYE_BAL_BF()
  {
    return this.LGMD_EMYE_BAL_BF;
  }
  
  public void setLGMD_EMPYR_CONTRI(BigDecimal LGMD_EMPYR_CONTRI)
  {
    this.LGMD_EMPYR_CONTRI = LGMD_EMPYR_CONTRI;
  }
  
  public BigDecimal getLGMD_EMPYR_CONTRI()
  {
    return this.LGMD_EMPYR_CONTRI;
  }
  
  public void setLGMD_EMYE_CONTRI(BigDecimal LGMD_EMYE_CONTRI)
  {
    this.LGMD_EMYE_CONTRI = LGMD_EMYE_CONTRI;
  }
  
  public BigDecimal getLGMD_EMYE_CONTRI()
  {
    return this.LGMD_EMYE_CONTRI;
  }
  
  public void setLGMD_ORIG_LN_PRD(BigDecimal LGMD_ORIG_LN_PRD)
  {
    this.LGMD_ORIG_LN_PRD = LGMD_ORIG_LN_PRD;
  }
  
  public BigDecimal getLGMD_ORIG_LN_PRD()
  {
    return this.LGMD_ORIG_LN_PRD;
  }
  
  public void setLGMD_LOAN_INT(BigDecimal LGMD_LOAN_INT)
  {
    this.LGMD_LOAN_INT = LGMD_LOAN_INT;
  }
  
  public BigDecimal getLGMD_LOAN_INT()
  {
    return this.LGMD_LOAN_INT;
  }
  
  public void setLGMD_ORIG_LOAN_AMT(BigDecimal LGMD_ORIG_LOAN_AMT)
  {
    this.LGMD_ORIG_LOAN_AMT = LGMD_ORIG_LOAN_AMT;
  }
  
  public BigDecimal getLGMD_ORIG_LOAN_AMT()
  {
    return this.LGMD_ORIG_LOAN_AMT;
  }
  
  public void setLGMD_LOAN_ISSUE_DATE(Date LGMD_LOAN_ISSUE_DATE)
  {
    this.LGMD_LOAN_ISSUE_DATE = LGMD_LOAN_ISSUE_DATE;
  }
  
  public Date getLGMD_LOAN_ISSUE_DATE()
  {
    return this.LGMD_LOAN_ISSUE_DATE;
  }
  
  public void setLGPL_PENS_COMM_RATE(String LGPL_PENS_COMM_RATE)
  {
    this.LGPL_PENS_COMM_RATE = LGPL_PENS_COMM_RATE;
  }
  
  public String getLGPL_PENS_COMM_RATE()
  {
    return this.LGPL_PENS_COMM_RATE;
  }
  
  public void setLGPL_PENS_PAYMENT_FREQ(String LGPL_PENS_PAYMENT_FREQ)
  {
    this.LGPL_PENS_PAYMENT_FREQ = LGPL_PENS_PAYMENT_FREQ;
  }
  
  public String getLGPL_PENS_PAYMENT_FREQ()
  {
    return this.LGPL_PENS_PAYMENT_FREQ;
  }
  
  public void setLGPL_REGISTERED(String LGPL_REGISTERED)
  {
    this.LGPL_REGISTERED = LGPL_REGISTERED;
  }
  
  public String getLGPL_REGISTERED()
  {
    return this.LGPL_REGISTERED;
  }
  
  public void setLGPL_REG_NO(String LGPL_REG_NO)
  {
    this.LGPL_REG_NO = LGPL_REG_NO;
  }
  
  public String getLGPL_REG_NO()
  {
    return this.LGPL_REG_NO;
  }
  
  public void setLGPL_PENS_TYPE(String LGPL_PENS_TYPE)
  {
    this.LGPL_PENS_TYPE = LGPL_PENS_TYPE;
  }
  
  public String getLGPL_PENS_TYPE()
  {
    return this.LGPL_PENS_TYPE;
  }
  
  public void setLGPL_CONTRI_TYPE(String LGPL_CONTRI_TYPE)
  {
    this.LGPL_CONTRI_TYPE = LGPL_CONTRI_TYPE;
  }
  
  public String getLGPL_CONTRI_TYPE()
  {
    return this.LGPL_CONTRI_TYPE;
  }
  
  public void setLGPL_EMYE_CONTRI(BigDecimal LGPL_EMYE_CONTRI)
  {
    this.LGPL_EMYE_CONTRI = LGPL_EMYE_CONTRI;
  }
  
  public BigDecimal getLGPL_EMYE_CONTRI()
  {
    return this.LGPL_EMYE_CONTRI;
  }
  
  public void setLGPL_EMYR_CONTRI(BigDecimal LGPL_EMYR_CONTRI)
  {
    this.LGPL_EMYR_CONTRI = LGPL_EMYR_CONTRI;
  }
  
  public BigDecimal getLGPL_EMYR_CONTRI()
  {
    return this.LGPL_EMYR_CONTRI;
  }
  
  public void setLGPL_MALE_NRD(String LGPL_MALE_NRD)
  {
    this.LGPL_MALE_NRD = LGPL_MALE_NRD;
  }
  
  public String getLGPL_MALE_NRD()
  {
    return this.LGPL_MALE_NRD;
  }
  
  public void setLGPL_FEMALE_NRD(String LGPL_FEMALE_NRD)
  {
    this.LGPL_FEMALE_NRD = LGPL_FEMALE_NRD;
  }
  
  public String getLGPL_FEMALE_NRD()
  {
    return this.LGPL_FEMALE_NRD;
  }
  
  public void setLGPL_GRNTD_PRD(String LGPL_GRNTD_PRD)
  {
    this.LGPL_GRNTD_PRD = LGPL_GRNTD_PRD;
  }
  
  public String getLGPL_GRNTD_PRD()
  {
    return this.LGPL_GRNTD_PRD;
  }
  
  public void setLGPL_EARNINGS_ESC(String LGPL_EARNINGS_ESC)
  {
    this.LGPL_EARNINGS_ESC = LGPL_EARNINGS_ESC;
  }
  
  public String getLGPL_EARNINGS_ESC()
  {
    return this.LGPL_EARNINGS_ESC;
  }
  
  public void setLGCD_BANK_BRANCH(String LGCD_BANK_BRANCH)
  {
    this.LGCD_BANK_BRANCH = LGCD_BANK_BRANCH;
  }
  
  public String getLGCD_BANK_BRANCH()
  {
    return this.LGCD_BANK_BRANCH;
  }
  
  public void setLGCD_SN(BigDecimal LGCD_SN)
  {
    this.LGCD_SN = LGCD_SN;
  }
  
  public BigDecimal getLGCD_SN()
  {
    return this.LGCD_SN;
  }
  
  public void setLGCD_CLIENT_BANK_NAME(String LGCD_CLIENT_BANK_NAME)
  {
    this.LGCD_CLIENT_BANK_NAME = LGCD_CLIENT_BANK_NAME;
  }
  
  public String getLGCD_CLIENT_BANK_NAME()
  {
    return this.LGCD_CLIENT_BANK_NAME;
  }
  
  public void setLGCD_OCCUPATION(String LGCD_OCCUPATION)
  {
    this.LGCD_OCCUPATION = LGCD_OCCUPATION;
  }
  
  public String getLGCD_OCCUPATION()
  {
    return this.LGCD_OCCUPATION;
  }
  
  public void setLGCD_CLIENT_FAX(String LGCD_CLIENT_FAX)
  {
    this.LGCD_CLIENT_FAX = LGCD_CLIENT_FAX;
  }
  
  public String getLGCD_CLIENT_FAX()
  {
    return this.LGCD_CLIENT_FAX;
  }
  
  public void setLGCD_AGENT_TEL(String LGCD_AGENT_TEL)
  {
    this.LGCD_AGENT_TEL = LGCD_AGENT_TEL;
  }
  
  public String getLGCD_AGENT_TEL()
  {
    return this.LGCD_AGENT_TEL;
  }
  
  public void setLGCD_CLIENT_TEL(String LGCD_CLIENT_TEL)
  {
    this.LGCD_CLIENT_TEL = LGCD_CLIENT_TEL;
  }
  
  public String getLGCD_CLIENT_TEL()
  {
    return this.LGCD_CLIENT_TEL;
  }
  
  public void setLGCD_CLIENT_COUNTRY(String LGCD_CLIENT_COUNTRY)
  {
    this.LGCD_CLIENT_COUNTRY = LGCD_CLIENT_COUNTRY;
  }
  
  public String getLGCD_CLIENT_COUNTRY()
  {
    return this.LGCD_CLIENT_COUNTRY;
  }
  
  public void setLGCD_CLIENT_TOWN(String LGCD_CLIENT_TOWN)
  {
    this.LGCD_CLIENT_TOWN = LGCD_CLIENT_TOWN;
  }
  
  public String getLGCD_CLIENT_TOWN()
  {
    return this.LGCD_CLIENT_TOWN;
  }
  
  public void setLGCD_AGENT_ADDRESS(String LGCD_AGENT_ADDRESS)
  {
    this.LGCD_AGENT_ADDRESS = LGCD_AGENT_ADDRESS;
  }
  
  public String getLGCD_AGENT_ADDRESS()
  {
    return this.LGCD_AGENT_ADDRESS;
  }
  
  public void setLGCD_CLIENT_ADDRESS(String LGCD_CLIENT_ADDRESS)
  {
    this.LGCD_CLIENT_ADDRESS = LGCD_CLIENT_ADDRESS;
  }
  
  public String getLGCD_CLIENT_ADDRESS()
  {
    return this.LGCD_CLIENT_ADDRESS;
  }
  
  public void setLGCD_NAME(String LGCD_NAME)
  {
    this.LGCD_NAME = LGCD_NAME;
  }
  
  public String getLGCD_NAME()
  {
    return this.LGCD_NAME;
  }
  
  public void setLGCD_CLIENT_ID(String LGCD_CLIENT_ID)
  {
    this.LGCD_CLIENT_ID = LGCD_CLIENT_ID;
  }
  
  public String getLGCD_CLIENT_ID()
  {
    return this.LGCD_CLIENT_ID;
  }
  
  public void setLGCD_ACC_NO(String LGCD_ACC_NO)
  {
    this.LGCD_ACC_NO = LGCD_ACC_NO;
  }
  
  public String getLGCD_ACC_NO()
  {
    return this.LGCD_ACC_NO;
  }
  
  public void setLGCA_SCHEME(String LGCA_SCHEME)
  {
    this.LGCA_SCHEME = LGCA_SCHEME;
  }
  
  public String getLGCA_SCHEME()
  {
    return this.LGCA_SCHEME;
  }
  
  public void setLGCA_CO_SHARE(String LGCA_CO_SHARE)
  {
    this.LGCA_CO_SHARE = LGCA_CO_SHARE;
  }
  
  public String getLGCA_CO_SHARE()
  {
    return this.LGCA_CO_SHARE;
  }
  
  public void setLGMD_CATEGORY(String LGMD_CATEGORY)
  {
    this.LGMD_CATEGORY = LGMD_CATEGORY;
  }
  
  public String getLGMD_CATEGORY()
  {
    return this.LGMD_CATEGORY;
  }
  
  public void setLGMD_EARNINGS_PRD(BigDecimal LGMD_EARNINGS_PRD)
  {
    this.LGMD_EARNINGS_PRD = LGMD_EARNINGS_PRD;
  }
  
  public BigDecimal getLGMD_EARNINGS_PRD()
  {
    return this.LGMD_EARNINGS_PRD;
  }
  
  public void setLGMD_OCCUPATION(String LGMD_OCCUPATION)
  {
    this.LGMD_OCCUPATION = LGMD_OCCUPATION;
  }
  
  public String getLGMD_OCCUPATION()
  {
    return this.LGMD_OCCUPATION;
  }
  
  public void setLGMD_POL_NO(String LGMD_POL_NO)
  {
    this.LGMD_POL_NO = LGMD_POL_NO;
  }
  
  public String getLGMD_POL_NO()
  {
    return this.LGMD_POL_NO;
  }
  
  public void setACT_CODE(BigDecimal ACT_CODE)
  {
    this.ACT_CODE = ACT_CODE;
  }
  
  public BigDecimal getACT_CODE()
  {
    return this.ACT_CODE;
  }
  
  public void setACT_ACCOUNT_TYPE(String ACT_ACCOUNT_TYPE)
  {
    this.ACT_ACCOUNT_TYPE = ACT_ACCOUNT_TYPE;
  }
  
  public String getACT_ACCOUNT_TYPE()
  {
    return this.ACT_ACCOUNT_TYPE;
  }
  
  public void setMTRAN_POL_POLCY_NO(String MTRAN_POL_POLCY_NO)
  {
    this.MTRAN_POL_POLCY_NO = MTRAN_POL_POLCY_NO;
  }
  
  public String getMTRAN_POL_POLCY_NO()
  {
    return this.MTRAN_POL_POLCY_NO;
  }
  
  public void setPCP_POL_POLICY_NO(String PCP_POL_POLICY_NO)
  {
    this.PCP_POL_POLICY_NO = PCP_POL_POLICY_NO;
  }
  
  public String getPCP_POL_POLICY_NO()
  {
    return this.PCP_POL_POLICY_NO;
  }
  
  public void setV_paid_ee_bf_amt(String v_paid_ee_bf_amt)
  {
    this.v_paid_ee_bf_amt = v_paid_ee_bf_amt;
  }
  
  public String getV_paid_ee_bf_amt()
  {
    return this.v_paid_ee_bf_amt;
  }
  
  public void setV_paid_er_bf_amt(String v_paid_er_bf_amt)
  {
    this.v_paid_er_bf_amt = v_paid_er_bf_amt;
  }
  
  public String getV_paid_er_bf_amt()
  {
    return this.v_paid_er_bf_amt;
  }
  
  public void setCqrRefNo(String cqrRefNo)
  {
    this.cqrRefNo = cqrRefNo;
  }
  
  public String getCqrRefNo()
  {
    return this.cqrRefNo;
  }
  
  public void setCqrNarrative(String cqrNarrative)
  {
    this.cqrNarrative = cqrNarrative;
  }
  
  public String getCqrNarrative()
  {
    return this.cqrNarrative;
  }
  
  public void setCqrFmsRemarks(String cqrFmsRemarks)
  {
    this.cqrFmsRemarks = cqrFmsRemarks;
  }
  
  public String getCqrFmsRemarks()
  {
    return this.cqrFmsRemarks;
  }
  
  public void setCrqPayee(String crqPayee)
  {
    this.crqPayee = crqPayee;
  }
  
  public String getCrqPayee()
  {
    return this.crqPayee;
  }
  
  public void setCqrChqNo(String cqrChqNo)
  {
    this.cqrChqNo = cqrChqNo;
  }
  
  public String getCqrChqNo()
  {
    return this.cqrChqNo;
  }
  
  public void setCqrPmtVchno(String cqrPmtVchno)
  {
    this.cqrPmtVchno = cqrPmtVchno;
  }
  
  public String getCqrPmtVchno()
  {
    return this.cqrPmtVchno;
  }
  
  public void setCstDescription(String cstDescription)
  {
    this.cstDescription = cstDescription;
  }
  
  public String getCstDescription()
  {
    return this.cstDescription;
  }
  
  public void setCqrAmount(BigDecimal cqrAmount)
  {
    this.cqrAmount = cqrAmount;
  }
  
  public BigDecimal getCqrAmount()
  {
    return this.cqrAmount;
  }
  
  public void setCqrChequeDate(Date cqrChequeDate)
  {
    this.cqrChequeDate = cqrChequeDate;
  }
  
  public Date getCqrChequeDate()
  {
    return this.cqrChequeDate;
  }
  
  public void setPolicy_no(String policy_no)
  {
    this.policy_no = policy_no;
  }
  
  public String getPolicy_no()
  {
    return this.policy_no;
  }
  
  public void setClient(String client)
  {
    this.client = client;
  }
  
  public String getClient()
  {
    return this.client;
  }
  
  public void setV_empyr_loan_repay(BigDecimal v_empyr_loan_repay)
  {
    this.v_empyr_loan_repay = v_empyr_loan_repay;
  }
  
  public BigDecimal getV_empyr_loan_repay()
  {
    return this.v_empyr_loan_repay;
  }
  
  public void setV_empye_loan_repay(BigDecimal v_empye_loan_repay)
  {
    this.v_empye_loan_repay = v_empye_loan_repay;
  }
  
  public BigDecimal getV_empye_loan_repay()
  {
    return this.v_empye_loan_repay;
  }
  
  public void setCCL_CODE(BigDecimal CCL_CODE)
  {
    this.CCL_CODE = CCL_CODE;
  }
  
  public BigDecimal getCCL_CODE()
  {
    return this.CCL_CODE;
  }
  
  public void setEmyr_reg_amount(BigDecimal emyr_reg_amount)
  {
    this.emyr_reg_amount = emyr_reg_amount;
  }
  
  public BigDecimal getEmyr_reg_amount()
  {
    return this.emyr_reg_amount;
  }
  
  public void setEmye_reg_amount(BigDecimal emye_reg_amount)
  {
    this.emye_reg_amount = emye_reg_amount;
  }
  
  public BigDecimal getEmye_reg_amount()
  {
    return this.emye_reg_amount;
  }
  
  public void setEmyr_unreg_amount(BigDecimal emyr_unreg_amount)
  {
    this.emyr_unreg_amount = emyr_unreg_amount;
  }
  
  public BigDecimal getEmyr_unreg_amount()
  {
    return this.emyr_unreg_amount;
  }
  
  public void setEmye_unreg_amount(BigDecimal emye_unreg_amount)
  {
    this.emye_unreg_amount = emye_unreg_amount;
  }
  
  public BigDecimal getEmye_unreg_amount()
  {
    return this.emye_unreg_amount;
  }
  
  public void setTS_AMT_PAID(BigDecimal TS_AMT_PAID)
  {
    this.TS_AMT_PAID = TS_AMT_PAID;
  }
  
  public BigDecimal getTS_AMT_PAID()
  {
    return this.TS_AMT_PAID;
  }
  
  public void setPrtsCode(BigDecimal prtsCode)
  {
    this.prtsCode = prtsCode;
  }
  
  public BigDecimal getPrtsCode()
  {
    return this.prtsCode;
  }
  
  public void setPrtsUwYear(BigDecimal prtsUwYear)
  {
    this.prtsUwYear = prtsUwYear;
  }
  
  public BigDecimal getPrtsUwYear()
  {
    return this.prtsUwYear;
  }
  
  public void setPrtsFiscalYear(BigDecimal prtsFiscalYear)
  {
    this.prtsFiscalYear = prtsFiscalYear;
  }
  
  public BigDecimal getPrtsFiscalYear()
  {
    return this.prtsFiscalYear;
  }
  
  public void setPrtsFiscalMonth(BigDecimal prtsFiscalMonth)
  {
    this.prtsFiscalMonth = prtsFiscalMonth;
  }
  
  public BigDecimal getPrtsFiscalMonth()
  {
    return this.prtsFiscalMonth;
  }
  
  public void setPrtsCededPremium(BigDecimal prtsCededPremium)
  {
    this.prtsCededPremium = prtsCededPremium;
  }
  
  public BigDecimal getPrtsCededPremium()
  {
    return this.prtsCededPremium;
  }
  
  public void setPrtsReinComm(BigDecimal prtsReinComm)
  {
    this.prtsReinComm = prtsReinComm;
  }
  
  public BigDecimal getPrtsReinComm()
  {
    return this.prtsReinComm;
  }
  
  public void setPrtsPremTax(BigDecimal prtsPremTax)
  {
    this.prtsPremTax = prtsPremTax;
  }
  
  public BigDecimal getPrtsPremTax()
  {
    return this.prtsPremTax;
  }
  
  public void setPrtsReinPRemTax(BigDecimal prtsReinPRemTax)
  {
    this.prtsReinPRemTax = prtsReinPRemTax;
  }
  
  public BigDecimal getPrtsReinPRemTax()
  {
    return this.prtsReinPRemTax;
  }
  
  public void setPrtsClaimsIncurred(BigDecimal prtsClaimsIncurred)
  {
    this.prtsClaimsIncurred = prtsClaimsIncurred;
  }
  
  public BigDecimal getPrtsClaimsIncurred()
  {
    return this.prtsClaimsIncurred;
  }
  
  public void setPrtsClaimsPaid(BigDecimal prtsClaimsPaid)
  {
    this.prtsClaimsPaid = prtsClaimsPaid;
  }
  
  public BigDecimal getPrtsClaimsPaid()
  {
    return this.prtsClaimsPaid;
  }
  
  public void setPrtsTrtCode(BigDecimal prtsTrtCode)
  {
    this.prtsTrtCode = prtsTrtCode;
  }
  
  public BigDecimal getPrtsTrtCode()
  {
    return this.prtsTrtCode;
  }
  
  public void setPrtsTaCode(BigDecimal prtsTaCode)
  {
    this.prtsTaCode = prtsTaCode;
  }
  
  public BigDecimal getPrtsTaCode()
  {
    return this.prtsTaCode;
  }
  
  public void setPrtsAsCode(BigDecimal prtsAsCode)
  {
    this.prtsAsCode = prtsAsCode;
  }
  
  public BigDecimal getPrtsAsCode()
  {
    return this.prtsAsCode;
  }
  
  public void setProdDesc(String prodDesc)
  {
    this.prodDesc = prodDesc;
  }
  
  public String getProdDesc()
  {
    return this.prodDesc;
  }
  
  public void setTS_CODE(BigDecimal TS_CODE)
  {
    this.TS_CODE = TS_CODE;
  }
  
  public BigDecimal getTS_CODE()
  {
    return this.TS_CODE;
  }
  
  public void setTS_REI_CODE(BigDecimal TS_REI_CODE)
  {
    this.TS_REI_CODE = TS_REI_CODE;
  }
  
  public BigDecimal getTS_REI_CODE()
  {
    return this.TS_REI_CODE;
  }
  
  public void setTS_TRT_CODE(BigDecimal TS_TRT_CODE)
  {
    this.TS_TRT_CODE = TS_TRT_CODE;
  }
  
  public BigDecimal getTS_TRT_CODE()
  {
    return this.TS_TRT_CODE;
  }
  
  public void setTS_TA_CODE(BigDecimal TS_TA_CODE)
  {
    this.TS_TA_CODE = TS_TA_CODE;
  }
  
  public BigDecimal getTS_TA_CODE()
  {
    return this.TS_TA_CODE;
  }
  
  public void setTS_UW_YEAR(BigDecimal TS_UW_YEAR)
  {
    this.TS_UW_YEAR = TS_UW_YEAR;
  }
  
  public BigDecimal getTS_UW_YEAR()
  {
    return this.TS_UW_YEAR;
  }
  
  public void setTS_CUMM_CEDED_PREMIUM(BigDecimal TS_CUMM_CEDED_PREMIUM)
  {
    this.TS_CUMM_CEDED_PREMIUM = TS_CUMM_CEDED_PREMIUM;
  }
  
  public BigDecimal getTS_CUMM_CEDED_PREMIUM()
  {
    return this.TS_CUMM_CEDED_PREMIUM;
  }
  
  public void setTS_CUMM_CEDED_CLAIMS(BigDecimal TS_CUMM_CEDED_CLAIMS)
  {
    this.TS_CUMM_CEDED_CLAIMS = TS_CUMM_CEDED_CLAIMS;
  }
  
  public BigDecimal getTS_CUMM_CEDED_CLAIMS()
  {
    return this.TS_CUMM_CEDED_CLAIMS;
  }
  
  public void setTS_CUMM_CLAIMS_PAID(BigDecimal TS_CUMM_CLAIMS_PAID)
  {
    this.TS_CUMM_CLAIMS_PAID = TS_CUMM_CLAIMS_PAID;
  }
  
  public BigDecimal getTS_CUMM_CLAIMS_PAID()
  {
    return this.TS_CUMM_CLAIMS_PAID;
  }
  
  public void setTS_CUMM_PREM_TAX(BigDecimal TS_CUMM_PREM_TAX)
  {
    this.TS_CUMM_PREM_TAX = TS_CUMM_PREM_TAX;
  }
  
  public BigDecimal getTS_CUMM_PREM_TAX()
  {
    return this.TS_CUMM_PREM_TAX;
  }
  
  public void setTS_CUMM_REIN_PREM_TAX(BigDecimal TS_CUMM_REIN_PREM_TAX)
  {
    this.TS_CUMM_REIN_PREM_TAX = TS_CUMM_REIN_PREM_TAX;
  }
  
  public BigDecimal getTS_CUMM_REIN_PREM_TAX()
  {
    return this.TS_CUMM_REIN_PREM_TAX;
  }
  
  public void setTS_ENTRY_CLAIM_AMT(BigDecimal TS_ENTRY_CLAIM_AMT)
  {
    this.TS_ENTRY_CLAIM_AMT = TS_ENTRY_CLAIM_AMT;
  }
  
  public BigDecimal getTS_ENTRY_CLAIM_AMT()
  {
    return this.TS_ENTRY_CLAIM_AMT;
  }
  
  public void setTS_ENTRY_PREM_AMT(BigDecimal TS_ENTRY_PREM_AMT)
  {
    this.TS_ENTRY_PREM_AMT = TS_ENTRY_PREM_AMT;
  }
  
  public BigDecimal getTS_ENTRY_PREM_AMT()
  {
    return this.TS_ENTRY_PREM_AMT;
  }
  
  public void setTS_ENTRY_PORTFOLIO_LOSS(BigDecimal TS_ENTRY_PORTFOLIO_LOSS)
  {
    this.TS_ENTRY_PORTFOLIO_LOSS = TS_ENTRY_PORTFOLIO_LOSS;
  }
  
  public BigDecimal getTS_ENTRY_PORTFOLIO_LOSS()
  {
    return this.TS_ENTRY_PORTFOLIO_LOSS;
  }
  
  public void setTS_WITHDRAWAL_PREM_AMT(BigDecimal TS_WITHDRAWAL_PREM_AMT)
  {
    this.TS_WITHDRAWAL_PREM_AMT = TS_WITHDRAWAL_PREM_AMT;
  }
  
  public BigDecimal getTS_WITHDRAWAL_PREM_AMT()
  {
    return this.TS_WITHDRAWAL_PREM_AMT;
  }
  
  public void setTS_WITHDRAWAL_CLAIM_AMT(BigDecimal TS_WITHDRAWAL_CLAIM_AMT)
  {
    this.TS_WITHDRAWAL_CLAIM_AMT = TS_WITHDRAWAL_CLAIM_AMT;
  }
  
  public BigDecimal getTS_WITHDRAWAL_CLAIM_AMT()
  {
    return this.TS_WITHDRAWAL_CLAIM_AMT;
  }
  
  public void setTS_WITHDRAWAL_PROFIT_LOSS(BigDecimal TS_WITHDRAWAL_PROFIT_LOSS)
  {
    this.TS_WITHDRAWAL_PROFIT_LOSS = TS_WITHDRAWAL_PROFIT_LOSS;
  }
  
  public BigDecimal getTS_WITHDRAWAL_PROFIT_LOSS()
  {
    return this.TS_WITHDRAWAL_PROFIT_LOSS;
  }
  
  public void setTS_MGT_EXPENSE_AMT(BigDecimal TS_MGT_EXPENSE_AMT)
  {
    this.TS_MGT_EXPENSE_AMT = TS_MGT_EXPENSE_AMT;
  }
  
  public BigDecimal getTS_MGT_EXPENSE_AMT()
  {
    return this.TS_MGT_EXPENSE_AMT;
  }
  
  public void setTS_CUMM_REIN_COMM(BigDecimal TS_CUMM_REIN_COMM)
  {
    this.TS_CUMM_REIN_COMM = TS_CUMM_REIN_COMM;
  }
  
  public BigDecimal getTS_CUMM_REIN_COMM()
  {
    return this.TS_CUMM_REIN_COMM;
  }
  
  public void setTS_FISCAL_YEAR(BigDecimal TS_FISCAL_YEAR)
  {
    this.TS_FISCAL_YEAR = TS_FISCAL_YEAR;
  }
  
  public BigDecimal getTS_FISCAL_YEAR()
  {
    return this.TS_FISCAL_YEAR;
  }
  
  public void setTS_TRS_CODE(BigDecimal TS_TRS_CODE)
  {
    this.TS_TRS_CODE = TS_TRS_CODE;
  }
  
  public BigDecimal getTS_TRS_CODE()
  {
    return this.TS_TRS_CODE;
  }
  
  public void setTS_AS_CODE(BigDecimal TS_AS_CODE)
  {
    this.TS_AS_CODE = TS_AS_CODE;
  }
  
  public BigDecimal getTS_AS_CODE()
  {
    return this.TS_AS_CODE;
  }
  
  public void setTS_INTEREST_TAX(BigDecimal TS_INTEREST_TAX)
  {
    this.TS_INTEREST_TAX = TS_INTEREST_TAX;
  }
  
  public BigDecimal getTS_INTEREST_TAX()
  {
    return this.TS_INTEREST_TAX;
  }
  
  public void setTS_INTEREST(BigDecimal TS_INTEREST)
  {
    this.TS_INTEREST = TS_INTEREST;
  }
  
  public BigDecimal getTS_INTEREST()
  {
    return this.TS_INTEREST;
  }
  
  public void setTS_PROFIT_COMM(BigDecimal TS_PROFIT_COMM)
  {
    this.TS_PROFIT_COMM = TS_PROFIT_COMM;
  }
  
  public BigDecimal getTS_PROFIT_COMM()
  {
    return this.TS_PROFIT_COMM;
  }
  
  public void setINCOME(BigDecimal INCOME)
  {
    this.INCOME = INCOME;
  }
  
  public BigDecimal getINCOME()
  {
    return this.INCOME;
  }
  
  public void setOUTGO(BigDecimal OUTGO)
  {
    this.OUTGO = OUTGO;
  }
  
  public BigDecimal getOUTGO()
  {
    return this.OUTGO;
  }
  
  public void setPROFIT_LOSS(BigDecimal PROFIT_LOSS)
  {
    this.PROFIT_LOSS = PROFIT_LOSS;
  }
  
  public BigDecimal getPROFIT_LOSS()
  {
    return this.PROFIT_LOSS;
  }
  
  public void setTS_TRS_SHT_DESC(String TS_TRS_SHT_DESC)
  {
    this.TS_TRS_SHT_DESC = TS_TRS_SHT_DESC;
  }
  
  public String getTS_TRS_SHT_DESC()
  {
    return this.TS_TRS_SHT_DESC;
  }
  
  public void setTS_TRAN_DATE(Date TS_TRAN_DATE)
  {
    this.TS_TRAN_DATE = TS_TRAN_DATE;
  }
  
  public Date getTS_TRAN_DATE()
  {
    return this.TS_TRAN_DATE;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setTS_DRCR_NO(String TS_DRCR_NO)
  {
    this.TS_DRCR_NO = TS_DRCR_NO;
  }
  
  public String getTS_DRCR_NO()
  {
    return this.TS_DRCR_NO;
  }
  
  public void setTS_DRCR(String TS_DRCR)
  {
    this.TS_DRCR = TS_DRCR;
  }
  
  public String getTS_DRCR()
  {
    return this.TS_DRCR;
  }
  
  public void setLmpMonthNo(BigDecimal lmpMonthNo)
  {
    this.lmpMonthNo = lmpMonthNo;
  }
  
  public BigDecimal getLmpMonthNo()
  {
    return this.lmpMonthNo;
  }
  
  public void setPndpTotAmt(BigDecimal pndpTotAmt)
  {
    this.pndpTotAmt = pndpTotAmt;
  }
  
  public BigDecimal getPndpTotAmt()
  {
    return this.pndpTotAmt;
  }
  
  public void setPndpAdminFee(BigDecimal pndpAdminFee)
  {
    this.pndpAdminFee = pndpAdminFee;
  }
  
  public BigDecimal getPndpAdminFee()
  {
    return this.pndpAdminFee;
  }
  
  public void setPndpVateAmt(BigDecimal pndpVateAmt)
  {
    this.pndpVateAmt = pndpVateAmt;
  }
  
  public BigDecimal getPndpVateAmt()
  {
    return this.pndpVateAmt;
  }
  
  public void setLmpMonth(String lmpMonth)
  {
    this.lmpMonth = lmpMonth;
  }
  
  public String getLmpMonth()
  {
    return this.lmpMonth;
  }
  
  public void setPayTaxes(boolean payTaxes)
  {
    this.payTaxes = payTaxes;
  }
  
  public boolean isPayTaxes()
  {
    return this.payTaxes;
  }
  
  public void setAgnName(String agnName)
  {
    this.agnName = agnName;
  }
  
  public String getAgnName()
  {
    return this.agnName;
  }
  
  public void setTt_code(BigDecimal tt_code)
  {
    this.tt_code = tt_code;
  }
  
  public BigDecimal getTt_code()
  {
    return this.tt_code;
  }
  
  public void setTt_sht_desc(String tt_sht_desc)
  {
    this.tt_sht_desc = tt_sht_desc;
  }
  
  public String getTt_sht_desc()
  {
    return this.tt_sht_desc;
  }
  
  public void setTt_desc(String tt_desc)
  {
    this.tt_desc = tt_desc;
  }
  
  public String getTt_desc()
  {
    return this.tt_desc;
  }
  
  public void setTt_type(String tt_type)
  {
    this.tt_type = tt_type;
  }
  
  public String getTt_type()
  {
    return this.tt_type;
  }
  
  public void setTt_type_desc(String tt_type_desc)
  {
    this.tt_type_desc = tt_type_desc;
  }
  
  public String getTt_type_desc()
  {
    return this.tt_type_desc;
  }
  
  public void setRefNo(String refNo)
  {
    this.refNo = refNo;
  }
  
  public String getRefNo()
  {
    return this.refNo;
  }
  
  public void setGtopReceiptNo(String gtopReceiptNo)
  {
    this.gtopReceiptNo = gtopReceiptNo;
  }
  
  public String getGtopReceiptNo()
  {
    return this.gtopReceiptNo;
  }
  
  public void setGtopDoneBy(String gtopDoneBy)
  {
    this.gtopDoneBy = gtopDoneBy;
  }
  
  public String getGtopDoneBy()
  {
    return this.gtopDoneBy;
  }
  
  public void setGtopDrCr(String gtopDrCr)
  {
    this.gtopDrCr = gtopDrCr;
  }
  
  public String getGtopDrCr()
  {
    return this.gtopDrCr;
  }
  
  public void setGtopReceiptDate(Date gtopReceiptDate)
  {
    this.gtopReceiptDate = gtopReceiptDate;
  }
  
  public Date getGtopReceiptDate()
  {
    return this.gtopReceiptDate;
  }
  
  public void setGtopAmount(BigDecimal gtopAmount)
  {
    this.gtopAmount = gtopAmount;
  }
  
  public BigDecimal getGtopAmount()
  {
    return this.gtopAmount;
  }
  
  public void setPayRi(boolean payRi)
  {
    this.payRi = payRi;
  }
  
  public boolean isPayRi()
  {
    return this.payRi;
  }
  
  public void setCrctdCode(BigDecimal crctdCode)
  {
    this.crctdCode = crctdCode;
  }
  
  public BigDecimal getCrctdCode()
  {
    return this.crctdCode;
  }
  
  public void setMemNo(String memNo)
  {
    this.memNo = memNo;
  }
  
  public String getMemNo()
  {
    return this.memNo;
  }
  
  public void setMemName(String memName)
  {
    this.memName = memName;
  }
  
  public String getMemName()
  {
    return this.memName;
  }
  
  public void setClientName(String clientName)
  {
    this.clientName = clientName;
  }
  
  public String getClientName()
  {
    return this.clientName;
  }
  
  public void setAmtPaid(BigDecimal amtPaid)
  {
    this.amtPaid = amtPaid;
  }
  
  public BigDecimal getAmtPaid()
  {
    return this.amtPaid;
  }
  
  public void setAmtPayable(BigDecimal amtPayable)
  {
    this.amtPayable = amtPayable;
  }
  
  public BigDecimal getAmtPayable()
  {
    return this.amtPayable;
  }
  
  public void setCausDesc(String causDesc)
  {
    this.causDesc = causDesc;
  }
  
  public String getCausDesc()
  {
    return this.causDesc;
  }
  
  public void setCoverDesc(String coverDesc)
  {
    this.coverDesc = coverDesc;
  }
  
  public String getCoverDesc()
  {
    return this.coverDesc;
  }
  
  public void setCcrCode(BigDecimal ccrCode)
  {
    this.ccrCode = ccrCode;
  }
  
  public BigDecimal getCcrCode()
  {
    return this.ccrCode;
  }
  
  public void setCoinAmtPaid(BigDecimal coinAmtPaid)
  {
    this.coinAmtPaid = coinAmtPaid;
  }
  
  public BigDecimal getCoinAmtPaid()
  {
    return this.coinAmtPaid;
  }
  
  public void setCoinAmtPayable(BigDecimal coinAmtPayable)
  {
    this.coinAmtPayable = coinAmtPayable;
  }
  
  public BigDecimal getCoinAmtPayable()
  {
    return this.coinAmtPayable;
  }
  
  public void setCoinMemNo(String coinMemNo)
  {
    this.coinMemNo = coinMemNo;
  }
  
  public String getCoinMemNo()
  {
    return this.coinMemNo;
  }
  
  public void setCoinMemName(String coinMemName)
  {
    this.coinMemName = coinMemName;
  }
  
  public String getCoinMemName()
  {
    return this.coinMemName;
  }
  
  public void setCoinCausDesc(String coinCausDesc)
  {
    this.coinCausDesc = coinCausDesc;
  }
  
  public String getCoinCausDesc()
  {
    return this.coinCausDesc;
  }
  
  public void setCoinCoverDesc(String coinCoverDesc)
  {
    this.coinCoverDesc = coinCoverDesc;
  }
  
  public String getCoinCoverDesc()
  {
    return this.coinCoverDesc;
  }
  
  public void setCoinRefNo(String coinRefNo)
  {
    this.coinRefNo = coinRefNo;
  }
  
  public String getCoinRefNo()
  {
    return this.coinRefNo;
  }
  
  public void setCoinAgnName(String coinAgnName)
  {
    this.coinAgnName = coinAgnName;
  }
  
  public String getCoinAgnName()
  {
    return this.coinAgnName;
  }
  
  public void setCoinClient(String coinClient)
  {
    this.coinClient = coinClient;
  }
  
  public String getCoinClient()
  {
    return this.coinClient;
  }
  
  public void setCoinSelect(boolean coinSelect)
  {
    this.coinSelect = coinSelect;
  }
  
  public boolean isCoinSelect()
  {
    return this.coinSelect;
  }
  
  public void setRiSelect(boolean riSelect)
  {
    this.riSelect = riSelect;
  }
  
  public boolean isRiSelect()
  {
    return this.riSelect;
  }
  
  public void setTS_VOUCHER_NO(String TS_VOUCHER_NO)
  {
    this.TS_VOUCHER_NO = TS_VOUCHER_NO;
  }
  
  public String getTS_VOUCHER_NO()
  {
    return this.TS_VOUCHER_NO;
  }
  
  public void setCoinPeriod(String coinPeriod)
  {
    this.coinPeriod = coinPeriod;
  }
  
  public String getCoinPeriod()
  {
    return this.coinPeriod;
  }
  
  public void setRiPeriod(String riPeriod)
  {
    this.riPeriod = riPeriod;
  }
  
  public String getRiPeriod()
  {
    return this.riPeriod;
  }
  
  public void setCpvDateAuth(Date cpvDateAuth)
  {
    this.cpvDateAuth = cpvDateAuth;
  }
  
  public Date getCpvDateAuth()
  {
    return this.cpvDateAuth;
  }
  
  public void setCqrChqDispactDate(Date cqrChqDispactDate)
  {
    this.cqrChqDispactDate = cqrChqDispactDate;
  }
  
  public Date getCqrChqDispactDate()
  {
    return this.cqrChqDispactDate;
  }
  
  public void setEmpyr_reg_transfer(BigDecimal empyr_reg_transfer)
  {
    this.empyr_reg_transfer = empyr_reg_transfer;
  }
  
  public BigDecimal getEmpyr_reg_transfer()
  {
    return this.empyr_reg_transfer;
  }
  
  public void setEmpyr_unreg_transfer(BigDecimal empyr_unreg_transfer)
  {
    this.empyr_unreg_transfer = empyr_unreg_transfer;
  }
  
  public BigDecimal getEmpyr_unreg_transfer()
  {
    return this.empyr_unreg_transfer;
  }
  
  public void setEmpye_reg_transfer(BigDecimal empye_reg_transfer)
  {
    this.empye_reg_transfer = empye_reg_transfer;
  }
  
  public BigDecimal getEmpye_reg_transfer()
  {
    return this.empye_reg_transfer;
  }
  
  public void setEmpye_unreg_transfer(BigDecimal empye_unreg_transfer)
  {
    this.empye_unreg_transfer = empye_unreg_transfer;
  }
  
  public BigDecimal getEmpye_unreg_transfer()
  {
    return this.empye_unreg_transfer;
  }

    public void setTotalChequeAmt(BigDecimal totalChequeAmt) {
        this.totalChequeAmt = totalChequeAmt;
    }

    public BigDecimal getTotalChequeAmt() {
        return totalChequeAmt;
    }
}
