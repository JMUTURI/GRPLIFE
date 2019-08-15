package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import LMSG.view.setups.PremiumMaskItems;

public class Setup {
    public Setup() {
        super();
    }
    
  private BigDecimal SCH_CODE;
  private String SCH_SHT_DESC;
  private String SCH_DESC;
  private BigDecimal SCH_PERIOD;
  private BigDecimal SCH_LEVEL;
  private BigDecimal SLVL_NO_TERMS;
  private BigDecimal SLVL_TERM_DURATION;
  private BigDecimal SCH_FEES;
  private BigDecimal SCH_AV_STUDENTS;
  private String PROD_COMM_CVR_PARAM;
  private BigDecimal LPP_CODE;
  private String LPP_NAME;
  private String LPP_VALUE;
  
  private BigDecimal TRT_YRS_OF_SERVICE;
  private BigDecimal TRT_YRS_OF_SERVICE_FROM;
  private BigDecimal TRT_YRS_OF_SERVICE_TO;
  private String TRT_APPLICABLE_AT_CAUS;
  private BigDecimal TRT_CAUS_CODE;
  private String CAUS_DESC;
  
  private boolean selected;
  
  private String LPIT_TABLE_NAME;
  
  //SCHOOL LEVELS
  private BigDecimal SLVL_CODE;
  private String SLVL_SHT_DESC;
  private String SLVL_DESC;
  private String SLVL_PERIOD;
  
  private String PCT_SA_DEPEND_ON_LIMIT;
  private String PCT_SA_DEPEND_ON_LIMIT_DESC;
  
  private String CVT_PAY_BEN;
  private String CVT_PAY_BEN_DESC;
  
  private String GPR_SEX;
  
  private BigDecimal LPAG_CODE;
  private String LPAG_SHT_DESC;
  private String LPAG_DESC; 
  private String LPAG_TYPE;
  private BigDecimal POL_CODE;
  private String POL_POLICY_NO;
  private String CLIENT;
  private String BRN_NAME;
  private BigDecimal AGU_CODE; 
  private BigDecimal AGU_LPAG_CODE; 
  private BigDecimal AGU_USR_CODE; 
  private String USR_USERNAME; 
  private String USR_NAME;


//product Cover Provisions
private String PCPR_DEFAULT;
private String PCPR_EDIT_ALLOW;
private BigDecimal PCPR_CODE;
private BigDecimal PCPR_PROV_CODE;

//Class of Business
private BigDecimal CLA_CODE;
private String CLA_SHT_DESC;
private String CLA_DESC;
private String CLA_TYPE;

//Sequence Types
private BigDecimal LST_CODE;
private String LST_SHT_DESC;
private String LST_DESC;
private String LST_TYPE;
private String LST_TYPE_DESC;
private String LST_SEQ_NO_LEN;
private String LST_SEPARATOR;
private Date LST_WEF;
private Date LST_WET;
private String LST_TEXT;

//Sequence Templates
private BigDecimal LNT_CODE;
private String LNT_ORDER;
private String LNT_ITEM_ID;

//Product Seq Templates
private BigDecimal PST_CODE;
private BigDecimal PROD_CODE;
private String PROD_SHT_DESC;
private String PROD_DESC;

//Products
private String PROD_TYPE;

//Provisions
private BigDecimal PROV_CODE;
private String PROV_SHT_DESC;
private String PROV_DESC;
private String PROV_TYPE;
private String PROV_HIV_CLAUSE;
private String PROV_HIV_CLAUSE_DESC;


//Account Types
private BigDecimal ACT_CODE;
private String ACT_TYPE_SHT_DESC;
private String ACT_TYPE_ID;
private String ACT_ACCOUNT_TYPE; 

//Account Rates
private BigDecimal ATR_CODE;
private BigDecimal ATR_ACT_CODE;
private String ATR_SHT_DESC;
private String ATR_DESC; 
private Date ATR_WEF; 
private Date ATR_WET;
private String ATR_TYPE;
private String ATR_TYPE_DESC;

// GB/Pension Comm Rates.
private BigDecimal CRAT_CODE;
private BigDecimal CRAT_AT_CODE;
private String CRAT_AT_SHT_DESC;
private String CRAT_PROD_CODE;
private String CRAT_RANGE_FROM;
private String CRAT_RANGE_TO;
private String CRAT_RATE;
private String CRAT_RATE_DESC;
private String CRAT_DIVISION_FACTOR;
private String CRAT_PAY_FREQ;
private String CRAT_RATE_TYPE;
private String CRAT_TERM_FROM;
private String CRAT_TERM_TO;
private String CRAT_YR_NO_FROM;
private String CRAT_YR_NO_TO;
private Date CRAT_WEF_DATE; 
private Date CRAT_WET_DATE;
private BigDecimal CRAT_PCT_CODE;
private BigDecimal CRAT_ATR_CODE;
private String CRAT_ANB_FROM;
private String CRAT_ANB_TO;
private String CRAT_MATURITY_AGE;

//Commission Annualisation
private BigDecimal ACR_CODE;
private BigDecimal ACR_PROD_CODE;
private BigDecimal ACR_ACT_CODE;
private String ACR_ANN_RATE;
private String ACR_ANN_BAL_RATE;
private String ACR_ANN_ANNUALISATION_DURATION;
private String ACR_ANN_BAL_PYMT_MNTH;
private Date ACR_WEF_DATE;
private Date ACR_WET_DATE;

//ClawBack Rates
private BigDecimal CCLR_CODE;
private BigDecimal CCLR_PROD_CODE;
private BigDecimal CCLR_ACT_CODE;
private String CCLR_MNTH_FROM;
private String CCLR_MNTH_TO;
private String CCLR_CLAWBCK_RATE;
private String CCLR_CLAWBCK_RATE_TYPE;
private String CCLR_CLAWBCK_DIV_FACT;
private Date CCLR_WEF_DATE;
private Date CCLR_WET_DATE;

//Interface Pay Elements
private BigDecimal CPE_CODE;
private String CPE_PAY_ELEMENT;
private String CPE_CR;
private String CPE_DR;
private Date CPE_WEF;
private Date CPE_WET;
private String CPE_RATE;
private String CPE_RATE_DIV_FACTOR;

//Bonus Rates
private BigDecimal BRAT_CODE; 
private BigDecimal BRAT_CLA_CODE;
private BigDecimal BRAT_ACT_CODE;
private String BRAT_PERSISTENCY_FROM;
private String BRAT_PERSISTENCY_TO;
private String BRAT_MNTH_FROM;
private String BRAT_MNTH_TO;
private String BRAT_CALC_PERIOD;
private String BRAT_BONUS_RATE;
private String BRAT_BONUS_RATE_TYPE;
private String BRAT_BONUS_DIV_FACT;
private Date BRAT_WEF_DATE;
private Date BRAT_WET_DATE;

//Recovery Rates
private BigDecimal APR_CODE;
private BigDecimal APR_ACT_CODE;
private String APR_INTEREST_RATE;
private String APR_INTEREST_DIV_FAC;
private String APR_COMM_RECVRY_PECT;
private String APR_COMM_RECVRY_DIV_FAC;
private String APR_MIN_ADV_ALLOWED; 
private String APR_COMM_PAYBLE_PECT;
private String APR_COMM_PAYBLE_DIV_FAC;
private String APR_ADV_CALC_RANGE_FROM;
private String APR_ADV_CALC_RANGE_TO;
private String APR_AVER_SUM_GROSS_COMM;
private String APR_GROSS_COMM_PERIOD;
private Date WEF;
private Date WET;

//Commission Allowances
private BigDecimal CAL_CODE;
private BigDecimal CAL_ACT_CODE;
private BigDecimal CAL_CLA_CODE;
private String CAL_ALLOWANCE_TYPE; 
private String CAL_ALLOWANCE_RATE;
private String CAL_ALLOWANCE_DIV_FAC;
private String CAL_COMP_FREQ;
private Date CAL_WEF;
private Date CAL_WET;
private String CAL_RANGE_FROM;
private String CAL_RANGE_TO;
private String CAL_DESC;

//Premium Masks
private BigDecimal PMAS_CODE;
private String PMAS_SHT_DESC;
private String PMAS_DESC;
private String PMAS_DEFAULT;
private String PMAS_DEFAULT_DESC;
private String PMAS_COMMENT;
private String PMAS_RATE_TYPE;

//Parameters
private BigDecimal PARAM_CODE;
private String PARAM_NAME;
private String PARAM_VALUE;
private String PARAM_DESC;
private String PARAM_VALUE2;
private String PARAM_PROD_SPECIFIC;

//FCL Factors
private BigDecimal FCL_CODE;
private String FCL_LIVES_FROM;
private String FCL_LIVE_TO;
private String FCL_FCL_FACTOR;
private String FCL_LIMIT;
private Date FCL_WEF;
private Date FCL_WET;

//Business Transactions
private String BTR_TRANS_CODE;
private String BTR_TRANS_TYPE;
private String BTR_DEBIT_CODE;
private String BTR_CREDIT_CODE;
private String BTR_CLM_UW;

//Tax Types
private BigDecimal TT_CODE;
private String TT_SHT_DESC;
private String TT_DESC;
private String TT_TYPE;
private String TT_TYPE_DESC;
private String TT_APPLICABLE_AT_PROD;
private String TT_APPLICABLE_DESC;
private String TT_RENEWAL_ENDOS;
private String TT_RENEWAL_ENDOS_DESC;
private String TT_APPLICATION_LEVEL;
private String TT_APPLICATION_LEVEL_DESC;
private String TT_REFUND_ON_CANC;
private String TT_REFUND_ON_CANC_DESC;
private String TT_ACC_NO;
private String TT_CONTRA_ACC; 

//Tax Rates
private BigDecimal TRT_CODE;
private String TRT_RANGE_FROM;
private String TRT_RANGE_TO;
private String TRT_AGE_FROM;
private String TRT_AGE_TO;
private String TRT_RATE;
private String TRT_DIVISION_FACTOR;
private String TRT_RATE_TYPE;
private String TRT_RATE_TYPE_DESC; 
private String TRT_APPLIED_TO;
private String TRT_APPLIED_TO_DESC;
private String TRT_APPLICATION_FREQ;
private String TRT_APPLICATION_FREQ_DESC;
private String TRT_TAX_DURATION;
private String CVT_DESC;
private Date TRT_WEF_DATE;
private Date TRT_WET_DATE;
private String TRT_APPLIED_ON;
private String TRT_APPLIED_ON_DESC;

//Medical Tests
private BigDecimal MTL_CODE;
private String MTL_DESC;
private String MTL_FEES;
private Date MTL_WEF;
private Date MTL_WET;
private String MTL_VALIDITY_PRD;
private String MTL_SHT_DESC;

//Facilitators
private BigDecimal SPR_CODE;
private String SPR_SHT_DESC;
private String SPR_NAME;
private BigDecimal SPR_SPT_CODE;
private String TWN_NAME;

//Facilitator Tests
private BigDecimal FTL_CODE;
private String MEDICAL_DISPLAY;
private String FTL_FEES;
private Date FTL_WEF;
private Date FTL_WET;
private String FTL_VALIDITY_PRD;

//Life Classes/Occupations

private BigDecimal LC_CODE;
private String LC_DESC;
private String LC_SHT_DESC;
private String LC_HAZARDOUS;
private String LC_HAZAROUS_DESC;


//Product Dependants
private BigDecimal PCD_CODE;
private String PCD_DTY_DESCRIPTION;
private String PCD_PROD_DESC;
private BigDecimal PCD_PCT_CODE;
private BigDecimal DTY_CODE;
private String DTY_SHT_DESC;
private BigDecimal PCD_CVT_CODE;
private String PCD_CVT_SHT_DESC;

//Premium Rate Terms
private BigDecimal GRPT_CODE;
private String GRPT_TERM_FROM;
private String GRPT_TERM_TO;

//Premium Interest Rates
private BigDecimal GPIR_CODE;
private String GPIR_RATE_FROM;
private String GPIR_RATE_TO;

//Premium Rates
 private BigDecimal GPR_CODE;                 
 private String GPR_ANB_FROM;      
 private String GPR_ANB_TO;             
 private String GPR_RANGE_FROM;         
 private String GPR_RANGE_TO;         
 private String GPR_RATE;              
 private String GPR_ANNUAL_RATE;         
  private String GPR_SINGLE_RATE;        
  private String GPR_RATE_DESC;           
  private String GPR_DIVISION_FACTOR;     
   private String GPR_RATE_TYPE;           
  private String GPR_RATE_TYPE_DESC;       
  private String GPR_PRORATED_FULL;       
  private String GPR_MULTIPLIER_RATE;       
  private String GPR_MULTIPLIER_RATE_DESC;  
   private String GPR_MULTPLIER_DIV_FACT;    
   private String GPR_CONSTANT;            
   private String GPR_CONSTANT_DIV_FACT; 
   private String GPR_NORMAL_REFUND;       
   private String GPR_NORMAL_REFUND_DESC;  
   private Date GPR_WEF;                  
   private Date GPR_WET;    
     
    List<PremiumMaskItems> PremiumMaskItem;
    List<SchoolClassItems> SchClassItem;
    List<TreatyGroupItems> TreatyGroupItem;
    List<ProductCoverTypes> PctItem;
    private String type;
     
 //Medical Test Groups
 private BigDecimal MTG_CODE;
 private String MTG_SHT_DESC;
 private String MTG_DESC;
 private Date MTG_WEF;
 private Date MTG_WET;
 
 //Medical Test Items
 private BigDecimal MGIT_CODE;
 private BigDecimal MGIT_MTL_CODE;
 
 //Treaty Types
 private String TRT_SHT_DESC;
 private String TRT_DESC;
 private String TRT_LEVEL;
 
 //Treaty Type Groups
 private BigDecimal TRTG_CODE;
 private String TRTG_SHT_DESC;
 private String TRTG_DESC;
 
 //Treaties
 private BigDecimal TRS_CODE;
 private String TRS_SHT_DESC;
 private String TRS_NAME;
 private String TRS_TRTG_SHT_DESC;
 
 //Medical ANB
 private BigDecimal MANB_CODE;
 private String MANB_ANB_FROM;
 private String MANB_ANB_TO;
 private Date MANB_WEF; 
 private Date MANB_WET;
 
 //Medical Requirements
 private BigDecimal MREQ_CODE;
 private String MREQ_RANGE_FROM;
 private String MREQ_RANGE_TO; 
 private String MREQ_MTG_DESC;
 private Date MREQ_WEF;
 private Date MREQ_WET;

//Medical Ratings
  private BigDecimal GFM_CODE;
  private String GFM_ANB_FROM;
  private String GFM_ANB_TO;
  private String GFM_LAST_MEDICAL_DURATION;
  private String GMF_INCREASE_SA_LAST_MED_PERC;
  private String GFM_INCREASE_TYPE;
  private String GFM_INCREASE_MULT_DIV_FACT;  

//Reinsurance Rates Description
private BigDecimal ORRP_CODE;
private String ORRP_SHT_DESC;
private String ORRP_DESC;

//Reinsurance Description
private BigDecimal ORRT_CODE;
private String ORRT_ANB_FROM;
private String ORRT_ANB_TO; 
private String ORRT_RATE;
private String ORRT_DIVISION_FACTOR;
private String ORRT_RATE_TYPE; 
private String ORRT_RATE_TYPE_DESC;
private Date ORRT_WEF;
private Date ORRT_WET;

//OS Rein Rates Description
private BigDecimal RIOS_CODE;
private String RIOS_SHT_DESC;
private String RIOS_DESC;
private Date RIOS_WEF;
private Date RIOS_WET;

//OS Rein Rates
private BigDecimal RIOT_CODE;
private String RIOT_POLICY_TERM;
private String RIOT_POLICY_TERM_TO;
private String RIOT_LAPSED_TERM;
private String RIOT_LAPSED_TERM_TO;
private String RIOT_RATE;
private String RIOT_DIVISION_FACTOR;

//Credit Groups
private BigDecimal INGR_CODE;
private String INGR_SHT_DESC;
private String INGR_DESC;

//credit criterion
private BigDecimal CCR_CODE;
private String CCR_DESCRIPTION;
private BigDecimal CCR_INGR_CODE;

//intermediaries
private BigDecimal prpCode;
private String client;

//credit actions
private BigDecimal craCode;
private String CRA_CREDIT_DAYS;
private String CRA_ACTION;
private BigDecimal CRA_INGR_CODE;
private String CRA_WAIVER;
private String CRA_INGR_DESC;

//cover types
private BigDecimal CVT_CODE;
private String CVT_SHT_DESC;
private String CVT_DESCRIPTION;
private String CVT_MAIN_COVER;
private String CVT_MAIN_COVER_DESC;
private String CVT_DURATION_TYPE;
private String CVT_DURATION_TYPE_DESC;
private BigDecimal CVT_MAX_AGE;
private BigDecimal CVT_MULTIPLIER;
private BigDecimal CVT_MULT_DIV_FACT;
private String CVT_READ_FROM;
private String CVT_READ_FROM_DESC;
private String CVT_RATE_TYPE;
private String CVT_RATE_TYPE_DESC;
private String CVT_REPORT_NAME;
private String CVT_REMARKS;
private String CVT_RATES_FREQ_OF_PYMT;
private String CVT_RATES_FREQ_OF_PYMT_DESC;
private BigDecimal CVT_MAX_INST_NO,CVT_WAITING_PRD,CVT_NOTIFICATION_PRD;

//product cover types
private BigDecimal PCT_CODE;
private BigDecimal PCT_CVT_CODE,PCT_PROD_CODE;
private String PCT_CVT_DESC,PCT_CVT_SHT_DESC,PCT_FORMULAR,PCT_REFUND_FORMULAR,PCT_FORMULAR_DESC;
private String PCT_REFUND_FORMULAR_DESC;
private BigDecimal PCT_MAIN_SA_PERC,PCT_MAX_CLM_AMT,PCT_MAX_ASSUREDS,PCT_MAX_AGE,PCT_MAX_SA;
private String PCT_RATE_DEPEND_ON_CLASS,PCT_RATE_DEPEND_ON_CLASS_DESC;
private String PCT_GRP_OR_SINGLE_RATES,PCT_GRP_OR_SINGLE_RATES_DESC;
private String PCT_MANDATORY,PCT_MANDATORY_DESC;
private String PCT_ACCELERATOR,PCT_ACCELERATOR_DESC;
private String PCT_RISK;
private String PCT_INBUILT;
private String PCT_INBUILT_DESC;
private String PCT_THIRTEEN_MONTH;
private BigDecimal PCT_EM,PCT_PROFIT_MARGIN,PCT_MNGT_EXPENSES,PCT_PHCF,PCT_ADR_RATE,PCT_ADR_RATE_DIV_FACT;
private BigDecimal PCT_MED_COST,PCT_STAMP_DUTY,PCT_COMM_RATE;
private BigDecimal CVT_RETIRE_AGE;
 
//Treaty Cover Types
private BigDecimal ADD_PCT_CODE;
private BigDecimal ADD_CVT_CODE;
private String ADD_CVT_SHT_DESC;
private String ADD_CVT_DESC;

private String CVT_FIXED_SA;
private BigDecimal CVT_FIXED_SA_AMT;
private BigDecimal PCTL_CODE;
private String PCTL_NAME;

private BigDecimal  GLR_ANB_FROM,GLR_ANB_TO,GLR_CLASS,GLR_RANGE_FROM,GLR_RANGE_TO;
private BigDecimal GLR_RATE,GLR_DIV_FACT;
private String GLR_SEX;
private Date GLR_WEF,GLR_WET;
private BigDecimal GOC_CODE,GOC_CLASS;
private String GOC_CATEGORY;
private BigDecimal provl_code,provl_from,provl_to,provl_perc_payable,provl_waiting_prd;
private BigDecimal pprov_code;
private String pprov_default,pprov_editable,pprov_auto_populate,prov_desc;
//Currencies
private BigDecimal cur_code;
private String cur_symbol;
private String cur_desc;

  //Commission Rates
  private BigDecimal cratCode;
  private BigDecimal cratRate;
  private String cratRateDesc;
  private Date cratWefDate;
  private Date cratWetDate;
  private BigDecimal cratAtCode;
  private String cratAtShortDesc;
  private BigDecimal cratDivFactor;
  private String cratRateType;
  private BigDecimal cratRangeFrom;
  private BigDecimal cratRangeTo;
  private BigDecimal cratProdCode;
  private BigDecimal cratYrNoFrom;
  private BigDecimal cratYrNoTo;
  private BigDecimal cratTermFrom;
  private BigDecimal cratTermTo;
  private String cratPayFreq;
  private BigDecimal cratPctCode;
  private BigDecimal cratAtrCode;
  private BigDecimal cratAnbFrom;
  private BigDecimal cratAnbTo;
  private BigDecimal cratMaturityAge;
  private String cratAppliedOn;
  private BigDecimal productCode;
  private String productName;
  
  //Other Override comm rates
  private BigDecimal oocrCode;
  private BigDecimal oocrRate;
  private String oocrRateDesc;
  private BigDecimal oocrDivFactor;
  private BigDecimal oocrAtCode;
  private BigDecimal oocrApplAtCode;
  private BigDecimal oocrYrNoFrom;
  private BigDecimal oocrYrNoTo;
  private BigDecimal oocrClaCode;
  private Date oocrWefDate;
  private Date oocrWetDate;
  private String oocrApplAtName;
  
  //Budget Types
  private BigDecimal btsCode,btsUwYr;
  private String btsName,btsDesc;
  private Date btsPolEffDate;
  
  //Product Budget Types
  private BigDecimal pbgtCode,pbgtJanRenAmt,pbgtFebRenAmt,pbgtMarRenAmt,pbgtAprRenAmt,pbgtMayRenAmt,pbgtJunRenAmt,pbgtJulRenAmt,pbgtAugRenAmt,
                     pbgtSepRenAmt,pbgtOctRenAmt,pbgtNovRenAmt,pbgtDecRenAmt;
  
  private BigDecimal pbgtJanNBAmt,pbgtFebNBAmt,pbgtMarNBAmt,pbgtAprNBAmt,pbgtMayNBAmt,
                     pbgtJunNBAmt,pbgtJulNBAmt,pbgtAugNBAmt,pbgtSepNBAmt,pbgtOctNBAmt,pbgtNovNBAmt,pbgtDecNBAmt;
  
  private String gcoDesc,gocCategory,gcoShtDesc;
  private BigDecimal gocClass;
  private BigDecimal pplCode;
  private String pplDesc;
  private String exciseDuty;
    public void setCLA_CODE(BigDecimal CLA_CODE) {
        this.CLA_CODE = CLA_CODE;
    }

    public BigDecimal getCLA_CODE() {
        return CLA_CODE;
    }

    public void setCLA_SHT_DESC(String CLA_SHT_DESC) {
        this.CLA_SHT_DESC = CLA_SHT_DESC;
    }

    public String getCLA_SHT_DESC() {
        return CLA_SHT_DESC;
    }

    public void setCLA_DESC(String CLA_DESC) {
        this.CLA_DESC = CLA_DESC;
    }

    public String getCLA_DESC() {
        return CLA_DESC;
    }

    public void setCLA_TYPE(String CLA_TYPE) {
        this.CLA_TYPE = CLA_TYPE;
    }

    public String getCLA_TYPE() {
        return CLA_TYPE;
    }

    public void setLST_CODE(BigDecimal LST_CODE) {
        this.LST_CODE = LST_CODE;
    }

    public BigDecimal getLST_CODE() {
        return LST_CODE;
    }

    public void setLST_SHT_DESC(String LST_SHT_DESC) {
        this.LST_SHT_DESC = LST_SHT_DESC;
    }

    public String getLST_SHT_DESC() {
        return LST_SHT_DESC;
    }

    public void setLST_DESC(String LST_DESC) {
        this.LST_DESC = LST_DESC;
    }

    public String getLST_DESC() {
        return LST_DESC;
    }

    public void setLST_TYPE(String LST_TYPE) {
        this.LST_TYPE = LST_TYPE;
    }

    public String getLST_TYPE() {
        return LST_TYPE;
    }

    public void setLST_TYPE_DESC(String LST_TYPE_DESC) {
        this.LST_TYPE_DESC = LST_TYPE_DESC;
    }

    public String getLST_TYPE_DESC() {
        return LST_TYPE_DESC;
    }

    public void setLST_SEQ_NO_LEN(String LST_SEQ_NO_LEN) {
        this.LST_SEQ_NO_LEN = LST_SEQ_NO_LEN;
    }

    public String getLST_SEQ_NO_LEN() {
        return LST_SEQ_NO_LEN;
    }

    public void setLST_SEPARATOR(String LST_SEPARATOR) {
        this.LST_SEPARATOR = LST_SEPARATOR;
    }

    public String getLST_SEPARATOR() {
        return LST_SEPARATOR;
    }

    public void setLST_WEF(Date LST_WEF) {
        this.LST_WEF = LST_WEF;
    }

    public Date getLST_WEF() {
        return LST_WEF;
    }

    public void setLST_WET(Date LST_WET) {
        this.LST_WET = LST_WET;
    }

    public Date getLST_WET() {
        return LST_WET;
    }

    public void setLNT_CODE(BigDecimal LNT_CODE) {
        this.LNT_CODE = LNT_CODE;
    }

    public BigDecimal getLNT_CODE() {
        return LNT_CODE;
    }

    public void setLNT_ORDER(String LNT_ORDER) {
        this.LNT_ORDER = LNT_ORDER;
    }

    public String getLNT_ORDER() {
        return LNT_ORDER;
    }

    public void setLNT_ITEM_ID(String LNT_ITEM_ID) {
        this.LNT_ITEM_ID = LNT_ITEM_ID;
    }

    public String getLNT_ITEM_ID() {
        return LNT_ITEM_ID;
    }

    public void setPST_CODE(BigDecimal PST_CODE) {
        this.PST_CODE = PST_CODE;
    }

    public BigDecimal getPST_CODE() {
        return PST_CODE;
    }

    public void setPROD_CODE(BigDecimal PROD_CODE) {
        this.PROD_CODE = PROD_CODE;
    }

    public BigDecimal getPROD_CODE() {
        return PROD_CODE;
    }

    public void setPROD_SHT_DESC(String PROD_SHT_DESC) {
        this.PROD_SHT_DESC = PROD_SHT_DESC;
    }

    public String getPROD_SHT_DESC() {
        return PROD_SHT_DESC;
    }

    public void setPROD_DESC(String PROD_DESC) {
        this.PROD_DESC = PROD_DESC;
    }

    public String getPROD_DESC() {
        return PROD_DESC;
    }

    public void setPROD_TYPE(String PROD_TYPE) {
        this.PROD_TYPE = PROD_TYPE;
    }

    public String getPROD_TYPE() {
        return PROD_TYPE;
    }

    public void setACT_CODE(BigDecimal ACT_CODE) {
        this.ACT_CODE = ACT_CODE;
    }

    public BigDecimal getACT_CODE() {
        return ACT_CODE;
    }

    public void setACT_TYPE_SHT_DESC(String ACT_TYPE_SHT_DESC) {
        this.ACT_TYPE_SHT_DESC = ACT_TYPE_SHT_DESC;
    }

    public String getACT_TYPE_SHT_DESC() {
        return ACT_TYPE_SHT_DESC;
    }

    public void setACT_TYPE_ID(String ACT_TYPE_ID) {
        this.ACT_TYPE_ID = ACT_TYPE_ID;
    }

    public String getACT_TYPE_ID() {
        return ACT_TYPE_ID;
    }

    public void setACT_ACCOUNT_TYPE(String ACT_ACCOUNT_TYPE) {
        this.ACT_ACCOUNT_TYPE = ACT_ACCOUNT_TYPE;
    }

    public String getACT_ACCOUNT_TYPE() {
        return ACT_ACCOUNT_TYPE;
    }

    public void setATR_CODE(BigDecimal ATR_CODE) {
        this.ATR_CODE = ATR_CODE;
    }

    public BigDecimal getATR_CODE() {
        return ATR_CODE;
    }

    public void setATR_ACT_CODE(BigDecimal ATR_ACT_CODE) {
        this.ATR_ACT_CODE = ATR_ACT_CODE;
    }

    public BigDecimal getATR_ACT_CODE() {
        return ATR_ACT_CODE;
    }

    public void setATR_SHT_DESC(String ATR_SHT_DESC) {
        this.ATR_SHT_DESC = ATR_SHT_DESC;
    }

    public String getATR_SHT_DESC() {
        return ATR_SHT_DESC;
    }

    public void setATR_DESC(String ATR_DESC) {
        this.ATR_DESC = ATR_DESC;
    }

    public String getATR_DESC() {
        return ATR_DESC;
    }

    public void setATR_WEF(Date ATR_WEF) {
        this.ATR_WEF = ATR_WEF;
    }

    public Date getATR_WEF() {
        return ATR_WEF;
    }

    public void setATR_WET(Date ATR_WET) {
        this.ATR_WET = ATR_WET;
    }

    public Date getATR_WET() {
        return ATR_WET;
    }

    public void setATR_TYPE(String ATR_TYPE) {
        this.ATR_TYPE = ATR_TYPE;
    }

    public String getATR_TYPE() {
        return ATR_TYPE;
    }

    public void setATR_TYPE_DESC(String ATR_TYPE_DESC) {
        this.ATR_TYPE_DESC = ATR_TYPE_DESC;
    }

    public String getATR_TYPE_DESC() {
        return ATR_TYPE_DESC;
    }

    public void setCRAT_CODE(BigDecimal CRAT_CODE) {
        this.CRAT_CODE = CRAT_CODE;
    }

    public BigDecimal getCRAT_CODE() {
        return CRAT_CODE;
    }

    public void setCRAT_AT_CODE(BigDecimal CRAT_AT_CODE) {
        this.CRAT_AT_CODE = CRAT_AT_CODE;
    }

    public BigDecimal getCRAT_AT_CODE() {
        return CRAT_AT_CODE;
    }

    public void setCRAT_AT_SHT_DESC(String CRAT_AT_SHT_DESC) {
        this.CRAT_AT_SHT_DESC = CRAT_AT_SHT_DESC;
    }

    public String getCRAT_AT_SHT_DESC() {
        return CRAT_AT_SHT_DESC;
    }

    public void setCRAT_PROD_CODE(String CRAT_PROD_CODE) {
        this.CRAT_PROD_CODE = CRAT_PROD_CODE;
    }

    public String getCRAT_PROD_CODE() {
        return CRAT_PROD_CODE;
    }

    public void setCRAT_RANGE_FROM(String CRAT_RANGE_FROM) {
        this.CRAT_RANGE_FROM = CRAT_RANGE_FROM;
    }

    public String getCRAT_RANGE_FROM() {
        return CRAT_RANGE_FROM;
    }

    public void setCRAT_RANGE_TO(String CRAT_RANGE_TO) {
        this.CRAT_RANGE_TO = CRAT_RANGE_TO;
    }

    public String getCRAT_RANGE_TO() {
        return CRAT_RANGE_TO;
    }

    public void setCRAT_RATE(String CRAT_RATE) {
        this.CRAT_RATE = CRAT_RATE;
    }

    public String getCRAT_RATE() {
        return CRAT_RATE;
    }

    public void setCRAT_RATE_DESC(String CRAT_RATE_DESC) {
        this.CRAT_RATE_DESC = CRAT_RATE_DESC;
    }

    public String getCRAT_RATE_DESC() {
        return CRAT_RATE_DESC;
    }

    public void setCRAT_DIVISION_FACTOR(String CRAT_DIVISION_FACTOR) {
        this.CRAT_DIVISION_FACTOR = CRAT_DIVISION_FACTOR;
    }

    public String getCRAT_DIVISION_FACTOR() {
        return CRAT_DIVISION_FACTOR;
    }

    public void setCRAT_PAY_FREQ(String CRAT_PAY_FREQ) {
        this.CRAT_PAY_FREQ = CRAT_PAY_FREQ;
    }

    public String getCRAT_PAY_FREQ() {
        return CRAT_PAY_FREQ;
    }

    public void setCRAT_RATE_TYPE(String CRAT_RATE_TYPE) {
        this.CRAT_RATE_TYPE = CRAT_RATE_TYPE;
    }

    public String getCRAT_RATE_TYPE() {
        return CRAT_RATE_TYPE;
    }

    public void setCRAT_TERM_FROM(String CRAT_TERM_FROM) {
        this.CRAT_TERM_FROM = CRAT_TERM_FROM;
    }

    public String getCRAT_TERM_FROM() {
        return CRAT_TERM_FROM;
    }

    public void setCRAT_TERM_TO(String CRAT_TERM_TO) {
        this.CRAT_TERM_TO = CRAT_TERM_TO;
    }

    public String getCRAT_TERM_TO() {
        return CRAT_TERM_TO;
    }

    public void setCRAT_YR_NO_FROM(String CRAT_YR_NO_FROM) {
        this.CRAT_YR_NO_FROM = CRAT_YR_NO_FROM;
    }

    public String getCRAT_YR_NO_FROM() {
        return CRAT_YR_NO_FROM;
    }

    public void setCRAT_YR_NO_TO(String CRAT_YR_NO_TO) {
        this.CRAT_YR_NO_TO = CRAT_YR_NO_TO;
    }

    public String getCRAT_YR_NO_TO() {
        return CRAT_YR_NO_TO;
    }

    public void setCRAT_WEF_DATE(Date CRAT_WEF_DATE) {
        this.CRAT_WEF_DATE = CRAT_WEF_DATE;
    }

    public Date getCRAT_WEF_DATE() {
        return CRAT_WEF_DATE;
    }

    public void setCRAT_WET_DATE(Date CRAT_WET_DATE) {
        this.CRAT_WET_DATE = CRAT_WET_DATE;
    }

    public Date getCRAT_WET_DATE() {
        return CRAT_WET_DATE;
    }

    public void setCRAT_PCT_CODE(BigDecimal CRAT_PCT_CODE) {
        this.CRAT_PCT_CODE = CRAT_PCT_CODE;
    }

    public BigDecimal getCRAT_PCT_CODE() {
        return CRAT_PCT_CODE;
    }

    public void setCRAT_ATR_CODE(BigDecimal CRAT_ATR_CODE) {
        this.CRAT_ATR_CODE = CRAT_ATR_CODE;
    }

    public BigDecimal getCRAT_ATR_CODE() {
        return CRAT_ATR_CODE;
    }

    public void setCRAT_ANB_FROM(String CRAT_ANB_FROM) {
        this.CRAT_ANB_FROM = CRAT_ANB_FROM;
    }

    public String getCRAT_ANB_FROM() {
        return CRAT_ANB_FROM;
    }

    public void setCRAT_ANB_TO(String CRAT_ANB_TO) {
        this.CRAT_ANB_TO = CRAT_ANB_TO;
    }

    public String getCRAT_ANB_TO() {
        return CRAT_ANB_TO;
    }

    public void setCRAT_MATURITY_AGE(String CRAT_MATURITY_AGE) {
        this.CRAT_MATURITY_AGE = CRAT_MATURITY_AGE;
    }

    public String getCRAT_MATURITY_AGE() {
        return CRAT_MATURITY_AGE;
    }

    public void setACR_CODE(BigDecimal ACR_CODE) {
        this.ACR_CODE = ACR_CODE;
    }

    public BigDecimal getACR_CODE() {
        return ACR_CODE;
    }

    public void setACR_PROD_CODE(BigDecimal ACR_PROD_CODE) {
        this.ACR_PROD_CODE = ACR_PROD_CODE;
    }

    public BigDecimal getACR_PROD_CODE() {
        return ACR_PROD_CODE;
    }

    public void setACR_ACT_CODE(BigDecimal ACR_ACT_CODE) {
        this.ACR_ACT_CODE = ACR_ACT_CODE;
    }

    public BigDecimal getACR_ACT_CODE() {
        return ACR_ACT_CODE;
    }

    public void setACR_ANN_RATE(String ACR_ANN_RATE) {
        this.ACR_ANN_RATE = ACR_ANN_RATE;
    }

    public String getACR_ANN_RATE() {
        return ACR_ANN_RATE;
    }

    public void setACR_ANN_BAL_RATE(String ACR_ANN_BAL_RATE) {
        this.ACR_ANN_BAL_RATE = ACR_ANN_BAL_RATE;
    }

    public String getACR_ANN_BAL_RATE() {
        return ACR_ANN_BAL_RATE;
    }

    public void setACR_ANN_ANNUALISATION_DURATION(String ACR_ANN_ANNUALISATION_DURATION) {
        this.ACR_ANN_ANNUALISATION_DURATION = ACR_ANN_ANNUALISATION_DURATION;
    }

    public String getACR_ANN_ANNUALISATION_DURATION() {
        return ACR_ANN_ANNUALISATION_DURATION;
    }

    public void setACR_ANN_BAL_PYMT_MNTH(String ACR_ANN_BAL_PYMT_MNTH) {
        this.ACR_ANN_BAL_PYMT_MNTH = ACR_ANN_BAL_PYMT_MNTH;
    }

    public String getACR_ANN_BAL_PYMT_MNTH() {
        return ACR_ANN_BAL_PYMT_MNTH;
    }

    public void setACR_WEF_DATE(Date ACR_WEF_DATE) {
        this.ACR_WEF_DATE = ACR_WEF_DATE;
    }

    public Date getACR_WEF_DATE() {
        return ACR_WEF_DATE;
    }

    public void setACR_WET_DATE(Date ACR_WET_DATE) {
        this.ACR_WET_DATE = ACR_WET_DATE;
    }

    public Date getACR_WET_DATE() {
        return ACR_WET_DATE;
    }

    public void setCCLR_CODE(BigDecimal CCLR_CODE) {
        this.CCLR_CODE = CCLR_CODE;
    }

    public BigDecimal getCCLR_CODE() {
        return CCLR_CODE;
    }

    public void setCCLR_PROD_CODE(BigDecimal CCLR_PROD_CODE) {
        this.CCLR_PROD_CODE = CCLR_PROD_CODE;
    }

    public BigDecimal getCCLR_PROD_CODE() {
        return CCLR_PROD_CODE;
    }

    public void setCCLR_ACT_CODE(BigDecimal CCLR_ACT_CODE) {
        this.CCLR_ACT_CODE = CCLR_ACT_CODE;
    }

    public BigDecimal getCCLR_ACT_CODE() {
        return CCLR_ACT_CODE;
    }

    public void setCCLR_MNTH_FROM(String CCLR_MNTH_FROM) {
        this.CCLR_MNTH_FROM = CCLR_MNTH_FROM;
    }

    public String getCCLR_MNTH_FROM() {
        return CCLR_MNTH_FROM;
    }

    public void setCCLR_MNTH_TO(String CCLR_MNTH_TO) {
        this.CCLR_MNTH_TO = CCLR_MNTH_TO;
    }

    public String getCCLR_MNTH_TO() {
        return CCLR_MNTH_TO;
    }

    public void setCCLR_CLAWBCK_RATE(String CCLR_CLAWBCK_RATE) {
        this.CCLR_CLAWBCK_RATE = CCLR_CLAWBCK_RATE;
    }

    public String getCCLR_CLAWBCK_RATE() {
        return CCLR_CLAWBCK_RATE;
    }

    public void setCCLR_CLAWBCK_RATE_TYPE(String CCLR_CLAWBCK_RATE_TYPE) {
        this.CCLR_CLAWBCK_RATE_TYPE = CCLR_CLAWBCK_RATE_TYPE;
    }

    public String getCCLR_CLAWBCK_RATE_TYPE() {
        return CCLR_CLAWBCK_RATE_TYPE;
    }

    public void setCCLR_CLAWBCK_DIV_FACT(String CCLR_CLAWBCK_DIV_FACT) {
        this.CCLR_CLAWBCK_DIV_FACT = CCLR_CLAWBCK_DIV_FACT;
    }

    public String getCCLR_CLAWBCK_DIV_FACT() {
        return CCLR_CLAWBCK_DIV_FACT;
    }

    public void setCCLR_WEF_DATE(Date CCLR_WEF_DATE) {
        this.CCLR_WEF_DATE = CCLR_WEF_DATE;
    }

    public Date getCCLR_WEF_DATE() {
        return CCLR_WEF_DATE;
    }

    public void setCCLR_WET_DATE(Date CCLR_WET_DATE) {
        this.CCLR_WET_DATE = CCLR_WET_DATE;
    }

    public Date getCCLR_WET_DATE() {
        return CCLR_WET_DATE;
    }

    public void setCPE_CODE(BigDecimal CPE_CODE) {
        this.CPE_CODE = CPE_CODE;
    }

    public BigDecimal getCPE_CODE() {
        return CPE_CODE;
    }

    public void setCPE_PAY_ELEMENT(String CPE_PAY_ELEMENT) {
        this.CPE_PAY_ELEMENT = CPE_PAY_ELEMENT;
    }

    public String getCPE_PAY_ELEMENT() {
        return CPE_PAY_ELEMENT;
    }

    public void setCPE_CR(String CPE_CR) {
        this.CPE_CR = CPE_CR;
    }

    public String getCPE_CR() {
        return CPE_CR;
    }

    public void setCPE_DR(String CPE_DR) {
        this.CPE_DR = CPE_DR;
    }

    public String getCPE_DR() {
        return CPE_DR;
    }

    public void setCPE_WEF(Date CPE_WEF) {
        this.CPE_WEF = CPE_WEF;
    }

    public Date getCPE_WEF() {
        return CPE_WEF;
    }

    public void setCPE_WET(Date CPE_WET) {
        this.CPE_WET = CPE_WET;
    }

    public Date getCPE_WET() {
        return CPE_WET;
    }

    public void setCPE_RATE(String CPE_RATE) {
        this.CPE_RATE = CPE_RATE;
    }

    public String getCPE_RATE() {
        return CPE_RATE;
    }

    public void setCPE_RATE_DIV_FACTOR(String CPE_RATE_DIV_FACTOR) {
        this.CPE_RATE_DIV_FACTOR = CPE_RATE_DIV_FACTOR;
    }

    public String getCPE_RATE_DIV_FACTOR() {
        return CPE_RATE_DIV_FACTOR;
    }

    public void setBRAT_CODE(BigDecimal BRAT_CODE) {
        this.BRAT_CODE = BRAT_CODE;
    }

    public BigDecimal getBRAT_CODE() {
        return BRAT_CODE;
    }

    public void setBRAT_CLA_CODE(BigDecimal BRAT_CLA_CODE) {
        this.BRAT_CLA_CODE = BRAT_CLA_CODE;
    }

    public BigDecimal getBRAT_CLA_CODE() {
        return BRAT_CLA_CODE;
    }

    public void setBRAT_ACT_CODE(BigDecimal BRAT_ACT_CODE) {
        this.BRAT_ACT_CODE = BRAT_ACT_CODE;
    }

    public BigDecimal getBRAT_ACT_CODE() {
        return BRAT_ACT_CODE;
    }

    public void setBRAT_PERSISTENCY_FROM(String BRAT_PERSISTENCY_FROM) {
        this.BRAT_PERSISTENCY_FROM = BRAT_PERSISTENCY_FROM;
    }

    public String getBRAT_PERSISTENCY_FROM() {
        return BRAT_PERSISTENCY_FROM;
    }

    public void setBRAT_PERSISTENCY_TO(String BRAT_PERSISTENCY_TO) {
        this.BRAT_PERSISTENCY_TO = BRAT_PERSISTENCY_TO;
    }

    public String getBRAT_PERSISTENCY_TO() {
        return BRAT_PERSISTENCY_TO;
    }

    public void setBRAT_MNTH_FROM(String BRAT_MNTH_FROM) {
        this.BRAT_MNTH_FROM = BRAT_MNTH_FROM;
    }

    public String getBRAT_MNTH_FROM() {
        return BRAT_MNTH_FROM;
    }

    public void setBRAT_MNTH_TO(String BRAT_MNTH_TO) {
        this.BRAT_MNTH_TO = BRAT_MNTH_TO;
    }

    public String getBRAT_MNTH_TO() {
        return BRAT_MNTH_TO;
    }

    public void setBRAT_CALC_PERIOD(String BRAT_CALC_PERIOD) {
        this.BRAT_CALC_PERIOD = BRAT_CALC_PERIOD;
    }

    public String getBRAT_CALC_PERIOD() {
        return BRAT_CALC_PERIOD;
    }

    public void setBRAT_BONUS_RATE(String BRAT_BONUS_RATE) {
        this.BRAT_BONUS_RATE = BRAT_BONUS_RATE;
    }

    public String getBRAT_BONUS_RATE() {
        return BRAT_BONUS_RATE;
    }

    public void setBRAT_BONUS_RATE_TYPE(String BRAT_BONUS_RATE_TYPE) {
        this.BRAT_BONUS_RATE_TYPE = BRAT_BONUS_RATE_TYPE;
    }

    public String getBRAT_BONUS_RATE_TYPE() {
        return BRAT_BONUS_RATE_TYPE;
    }

    public void setBRAT_BONUS_DIV_FACT(String BRAT_BONUS_DIV_FACT) {
        this.BRAT_BONUS_DIV_FACT = BRAT_BONUS_DIV_FACT;
    }

    public String getBRAT_BONUS_DIV_FACT() {
        return BRAT_BONUS_DIV_FACT;
    }

    public void setBRAT_WEF_DATE(Date BRAT_WEF_DATE) {
        this.BRAT_WEF_DATE = BRAT_WEF_DATE;
    }

    public Date getBRAT_WEF_DATE() {
        return BRAT_WEF_DATE;
    }

    public void setBRAT_WET_DATE(Date BRAT_WET_DATE) {
        this.BRAT_WET_DATE = BRAT_WET_DATE;
    }

    public Date getBRAT_WET_DATE() {
        return BRAT_WET_DATE;
    }

    public void setAPR_CODE(BigDecimal APR_CODE) {
        this.APR_CODE = APR_CODE;
    }

    public BigDecimal getAPR_CODE() {
        return APR_CODE;
    }

    public void setAPR_ACT_CODE(BigDecimal APR_ACT_CODE) {
        this.APR_ACT_CODE = APR_ACT_CODE;
    }

    public BigDecimal getAPR_ACT_CODE() {
        return APR_ACT_CODE;
    }

    public void setAPR_INTEREST_RATE(String APR_INTEREST_RATE) {
        this.APR_INTEREST_RATE = APR_INTEREST_RATE;
    }

    public String getAPR_INTEREST_RATE() {
        return APR_INTEREST_RATE;
    }

    public void setAPR_INTEREST_DIV_FAC(String APR_INTEREST_DIV_FAC) {
        this.APR_INTEREST_DIV_FAC = APR_INTEREST_DIV_FAC;
    }

    public String getAPR_INTEREST_DIV_FAC() {
        return APR_INTEREST_DIV_FAC;
    }

    public void setAPR_COMM_RECVRY_PECT(String APR_COMM_RECVRY_PECT) {
        this.APR_COMM_RECVRY_PECT = APR_COMM_RECVRY_PECT;
    }

    public String getAPR_COMM_RECVRY_PECT() {
        return APR_COMM_RECVRY_PECT;
    }

    public void setAPR_COMM_RECVRY_DIV_FAC(String APR_COMM_RECVRY_DIV_FAC) {
        this.APR_COMM_RECVRY_DIV_FAC = APR_COMM_RECVRY_DIV_FAC;
    }

    public String getAPR_COMM_RECVRY_DIV_FAC() {
        return APR_COMM_RECVRY_DIV_FAC;
    }

    public void setAPR_MIN_ADV_ALLOWED(String APR_MIN_ADV_ALLOWED) {
        this.APR_MIN_ADV_ALLOWED = APR_MIN_ADV_ALLOWED;
    }

    public String getAPR_MIN_ADV_ALLOWED() {
        return APR_MIN_ADV_ALLOWED;
    }

    public void setAPR_COMM_PAYBLE_PECT(String APR_COMM_PAYBLE_PECT) {
        this.APR_COMM_PAYBLE_PECT = APR_COMM_PAYBLE_PECT;
    }

    public String getAPR_COMM_PAYBLE_PECT() {
        return APR_COMM_PAYBLE_PECT;
    }

    public void setAPR_COMM_PAYBLE_DIV_FAC(String APR_COMM_PAYBLE_DIV_FAC) {
        this.APR_COMM_PAYBLE_DIV_FAC = APR_COMM_PAYBLE_DIV_FAC;
    }

    public String getAPR_COMM_PAYBLE_DIV_FAC() {
        return APR_COMM_PAYBLE_DIV_FAC;
    }

    public void setAPR_ADV_CALC_RANGE_FROM(String APR_ADV_CALC_RANGE_FROM) {
        this.APR_ADV_CALC_RANGE_FROM = APR_ADV_CALC_RANGE_FROM;
    }

    public String getAPR_ADV_CALC_RANGE_FROM() {
        return APR_ADV_CALC_RANGE_FROM;
    }

    public void setAPR_ADV_CALC_RANGE_TO(String APR_ADV_CALC_RANGE_TO) {
        this.APR_ADV_CALC_RANGE_TO = APR_ADV_CALC_RANGE_TO;
    }

    public String getAPR_ADV_CALC_RANGE_TO() {
        return APR_ADV_CALC_RANGE_TO;
    }

    public void setAPR_AVER_SUM_GROSS_COMM(String APR_AVER_SUM_GROSS_COMM) {
        this.APR_AVER_SUM_GROSS_COMM = APR_AVER_SUM_GROSS_COMM;
    }

    public String getAPR_AVER_SUM_GROSS_COMM() {
        return APR_AVER_SUM_GROSS_COMM;
    }

    public void setAPR_GROSS_COMM_PERIOD(String APR_GROSS_COMM_PERIOD) {
        this.APR_GROSS_COMM_PERIOD = APR_GROSS_COMM_PERIOD;
    }

    public String getAPR_GROSS_COMM_PERIOD() {
        return APR_GROSS_COMM_PERIOD;
    }

    public void setWEF(Date WEF) {
        this.WEF = WEF;
    }

    public Date getWEF() {
        return WEF;
    }

    public void setWET(Date WET) {
        this.WET = WET;
    }

    public Date getWET() {
        return WET;
    }

    public void setCAL_CODE(BigDecimal CAL_CODE) {
        this.CAL_CODE = CAL_CODE;
    }

    public BigDecimal getCAL_CODE() {
        return CAL_CODE;
    }

    public void setCAL_ACT_CODE(BigDecimal CAL_ACT_CODE) {
        this.CAL_ACT_CODE = CAL_ACT_CODE;
    }

    public BigDecimal getCAL_ACT_CODE() {
        return CAL_ACT_CODE;
    }

    public void setCAL_CLA_CODE(BigDecimal CAL_CLA_CODE) {
        this.CAL_CLA_CODE = CAL_CLA_CODE;
    }

    public BigDecimal getCAL_CLA_CODE() {
        return CAL_CLA_CODE;
    }

    public void setCAL_ALLOWANCE_TYPE(String CAL_ALLOWANCE_TYPE) {
        this.CAL_ALLOWANCE_TYPE = CAL_ALLOWANCE_TYPE;
    }

    public String getCAL_ALLOWANCE_TYPE() {
        return CAL_ALLOWANCE_TYPE;
    }

    public void setCAL_ALLOWANCE_RATE(String CAL_ALLOWANCE_RATE) {
        this.CAL_ALLOWANCE_RATE = CAL_ALLOWANCE_RATE;
    }

    public String getCAL_ALLOWANCE_RATE() {
        return CAL_ALLOWANCE_RATE;
    }

    public void setCAL_ALLOWANCE_DIV_FAC(String CAL_ALLOWANCE_DIV_FAC) {
        this.CAL_ALLOWANCE_DIV_FAC = CAL_ALLOWANCE_DIV_FAC;
    }

    public String getCAL_ALLOWANCE_DIV_FAC() {
        return CAL_ALLOWANCE_DIV_FAC;
    }

    public void setCAL_COMP_FREQ(String CAL_COMP_FREQ) {
        this.CAL_COMP_FREQ = CAL_COMP_FREQ;
    }

    public String getCAL_COMP_FREQ() {
        return CAL_COMP_FREQ;
    }

    public void setCAL_WEF(Date CAL_WEF) {
        this.CAL_WEF = CAL_WEF;
    }

    public Date getCAL_WEF() {
        return CAL_WEF;
    }

    public void setCAL_WET(Date CAL_WET) {
        this.CAL_WET = CAL_WET;
    }

    public Date getCAL_WET() {
        return CAL_WET;
    }

    public void setCAL_RANGE_FROM(String CAL_RANGE_FROM) {
        this.CAL_RANGE_FROM = CAL_RANGE_FROM;
    }

    public String getCAL_RANGE_FROM() {
        return CAL_RANGE_FROM;
    }

    public void setCAL_RANGE_TO(String CAL_RANGE_TO) {
        this.CAL_RANGE_TO = CAL_RANGE_TO;
    }

    public String getCAL_RANGE_TO() {
        return CAL_RANGE_TO;
    }

    public void setCAL_DESC(String CAL_DESC) {
        this.CAL_DESC = CAL_DESC;
    }

    public String getCAL_DESC() {
        return CAL_DESC;
    }

    public void setPMAS_CODE(BigDecimal PMAS_CODE) {
        this.PMAS_CODE = PMAS_CODE;
    }

    public BigDecimal getPMAS_CODE() {
        return PMAS_CODE;
    }

    public void setPMAS_SHT_DESC(String PMAS_SHT_DESC) {
        this.PMAS_SHT_DESC = PMAS_SHT_DESC;
    }

    public String getPMAS_SHT_DESC() {
        return PMAS_SHT_DESC;
    }

    public void setPMAS_DESC(String PMAS_DESC) {
        this.PMAS_DESC = PMAS_DESC;
    }

    public String getPMAS_DESC() {
        return PMAS_DESC;
    }

    public void setPMAS_DEFAULT(String PMAS_DEFAULT) {
        this.PMAS_DEFAULT = PMAS_DEFAULT;
    }

    public String getPMAS_DEFAULT() {
        return PMAS_DEFAULT;
    }

    public void setPMAS_DEFAULT_DESC(String PMAS_DEFAULT_DESC) {
        this.PMAS_DEFAULT_DESC = PMAS_DEFAULT_DESC;
    }

    public String getPMAS_DEFAULT_DESC() {
        return PMAS_DEFAULT_DESC;
    }

    public void setPMAS_COMMENT(String PMAS_COMMENT) {
        this.PMAS_COMMENT = PMAS_COMMENT;
    }

    public String getPMAS_COMMENT() {
        return PMAS_COMMENT;
    }

    public void setPARAM_CODE(BigDecimal PARAM_CODE) {
        this.PARAM_CODE = PARAM_CODE;
    }

    public BigDecimal getPARAM_CODE() {
        return PARAM_CODE;
    }

    public void setPARAM_NAME(String PARAM_NAME) {
        this.PARAM_NAME = PARAM_NAME;
    }

    public String getPARAM_NAME() {
        return PARAM_NAME;
    }

    public void setPARAM_VALUE(String PARAM_VALUE) {
        this.PARAM_VALUE = PARAM_VALUE;
    }

    public String getPARAM_VALUE() {
        return PARAM_VALUE;
    }

    public void setPARAM_DESC(String PARAM_DESC) {
        this.PARAM_DESC = PARAM_DESC;
    }

    public String getPARAM_DESC() {
        return PARAM_DESC;
    }

    public void setPARAM_VALUE2(String PARAM_VALUE2) {
        this.PARAM_VALUE2 = PARAM_VALUE2;
    }

    public String getPARAM_VALUE2() {
        return PARAM_VALUE2;
    }

    public void setPARAM_PROD_SPECIFIC(String PARAM_PROD_SPECIFIC) {
        this.PARAM_PROD_SPECIFIC = PARAM_PROD_SPECIFIC;
    }

    public String getPARAM_PROD_SPECIFIC() {
        return PARAM_PROD_SPECIFIC;
    }

    public void setFCL_CODE(BigDecimal FCL_CODE) {
        this.FCL_CODE = FCL_CODE;
    }

    public BigDecimal getFCL_CODE() {
        return FCL_CODE;
    }

    public void setFCL_LIVES_FROM(String FCL_LIVES_FROM) {
        this.FCL_LIVES_FROM = FCL_LIVES_FROM;
    }

    public String getFCL_LIVES_FROM() {
        return FCL_LIVES_FROM;
    }

    public void setFCL_LIVE_TO(String FCL_LIVE_TO) {
        this.FCL_LIVE_TO = FCL_LIVE_TO;
    }

    public String getFCL_LIVE_TO() {
        return FCL_LIVE_TO;
    }

    public void setFCL_FCL_FACTOR(String FCL_FCL_FACTOR) {
        this.FCL_FCL_FACTOR = FCL_FCL_FACTOR;
    }

    public String getFCL_FCL_FACTOR() {
        return FCL_FCL_FACTOR;
    }

    public void setFCL_LIMIT(String FCL_LIMIT) {
        this.FCL_LIMIT = FCL_LIMIT;
    }

    public String getFCL_LIMIT() {
        return FCL_LIMIT;
    }

    public void setFCL_WEF(Date FCL_WEF) {
        this.FCL_WEF = FCL_WEF;
    }

    public Date getFCL_WEF() {
        return FCL_WEF;
    }

    public void setFCL_WET(Date FCL_WET) {
        this.FCL_WET = FCL_WET;
    }

    public Date getFCL_WET() {
        return FCL_WET;
    }

    public void setBTR_TRANS_CODE(String BTR_TRANS_CODE) {
        this.BTR_TRANS_CODE = BTR_TRANS_CODE;
    }

    public String getBTR_TRANS_CODE() {
        return BTR_TRANS_CODE;
    }

    public void setBTR_TRANS_TYPE(String BTR_TRANS_TYPE) {
        this.BTR_TRANS_TYPE = BTR_TRANS_TYPE;
    }

    public String getBTR_TRANS_TYPE() {
        return BTR_TRANS_TYPE;
    }

    public void setBTR_DEBIT_CODE(String BTR_DEBIT_CODE) {
        this.BTR_DEBIT_CODE = BTR_DEBIT_CODE;
    }

    public String getBTR_DEBIT_CODE() {
        return BTR_DEBIT_CODE;
    }

    public void setBTR_CREDIT_CODE(String BTR_CREDIT_CODE) {
        this.BTR_CREDIT_CODE = BTR_CREDIT_CODE;
    }

    public String getBTR_CREDIT_CODE() {
        return BTR_CREDIT_CODE;
    }

    public void setBTR_CLM_UW(String BTR_CLM_UW) {
        this.BTR_CLM_UW = BTR_CLM_UW;
    }

    public String getBTR_CLM_UW() {
        return BTR_CLM_UW;
    }

    public void setTT_CODE(BigDecimal TT_CODE) {
        this.TT_CODE = TT_CODE;
    }

    public BigDecimal getTT_CODE() {
        return TT_CODE;
    }

    public void setTT_SHT_DESC(String TT_SHT_DESC) {
        this.TT_SHT_DESC = TT_SHT_DESC;
    }

    public String getTT_SHT_DESC() {
        return TT_SHT_DESC;
    }

    public void setTT_DESC(String TT_DESC) {
        this.TT_DESC = TT_DESC;
    }

    public String getTT_DESC() {
        return TT_DESC;
    }

    public void setTT_TYPE(String TT_TYPE) {
        this.TT_TYPE = TT_TYPE;
    }

    public String getTT_TYPE() {
        return TT_TYPE;
    }

    public void setTT_TYPE_DESC(String TT_TYPE_DESC) {
        this.TT_TYPE_DESC = TT_TYPE_DESC;
    }

    public String getTT_TYPE_DESC() {
        return TT_TYPE_DESC;
    }

    public void setTT_APPLICABLE_AT_PROD(String TT_APPLICABLE_AT_PROD) {
        this.TT_APPLICABLE_AT_PROD = TT_APPLICABLE_AT_PROD;
    }

    public String getTT_APPLICABLE_AT_PROD() {
        return TT_APPLICABLE_AT_PROD;
    }

    public void setTT_APPLICABLE_DESC(String TT_APPLICABLE_DESC) {
        this.TT_APPLICABLE_DESC = TT_APPLICABLE_DESC;
    }

    public String getTT_APPLICABLE_DESC() {
        return TT_APPLICABLE_DESC;
    }

    public void setTT_RENEWAL_ENDOS(String TT_RENEWAL_ENDOS) {
        this.TT_RENEWAL_ENDOS = TT_RENEWAL_ENDOS;
    }

    public String getTT_RENEWAL_ENDOS() {
        return TT_RENEWAL_ENDOS;
    }

    public void setTT_RENEWAL_ENDOS_DESC(String TT_RENEWAL_ENDOS_DESC) {
        this.TT_RENEWAL_ENDOS_DESC = TT_RENEWAL_ENDOS_DESC;
    }

    public String getTT_RENEWAL_ENDOS_DESC() {
        return TT_RENEWAL_ENDOS_DESC;
    }

    public void setTT_APPLICATION_LEVEL(String TT_APPLICATION_LEVEL) {
        this.TT_APPLICATION_LEVEL = TT_APPLICATION_LEVEL;
    }

    public String getTT_APPLICATION_LEVEL() {
        return TT_APPLICATION_LEVEL;
    }

    public void setTT_APPLICATION_LEVEL_DESC(String TT_APPLICATION_LEVEL_DESC) {
        this.TT_APPLICATION_LEVEL_DESC = TT_APPLICATION_LEVEL_DESC;
    }

    public String getTT_APPLICATION_LEVEL_DESC() {
        return TT_APPLICATION_LEVEL_DESC;
    }

    public void setTT_REFUND_ON_CANC(String TT_REFUND_ON_CANC) {
        this.TT_REFUND_ON_CANC = TT_REFUND_ON_CANC;
    }

    public String getTT_REFUND_ON_CANC() {
        return TT_REFUND_ON_CANC;
    }

    public void setTT_REFUND_ON_CANC_DESC(String TT_REFUND_ON_CANC_DESC) {
        this.TT_REFUND_ON_CANC_DESC = TT_REFUND_ON_CANC_DESC;
    }

    public String getTT_REFUND_ON_CANC_DESC() {
        return TT_REFUND_ON_CANC_DESC;
    }

    public void setTT_ACC_NO(String TT_ACC_NO) {
        this.TT_ACC_NO = TT_ACC_NO;
    }

    public String getTT_ACC_NO() {
        return TT_ACC_NO;
    }

    public void setTT_CONTRA_ACC(String TT_CONTRA_ACC) {
        this.TT_CONTRA_ACC = TT_CONTRA_ACC;
    }

    public String getTT_CONTRA_ACC() {
        return TT_CONTRA_ACC;
    }

    public void setTRT_CODE(BigDecimal TRT_CODE) {
        this.TRT_CODE = TRT_CODE;
    }

    public BigDecimal getTRT_CODE() {
        return TRT_CODE;
    }

    public void setTRT_RANGE_FROM(String TRT_RANGE_FROM) {
        this.TRT_RANGE_FROM = TRT_RANGE_FROM;
    }

    public String getTRT_RANGE_FROM() {
        return TRT_RANGE_FROM;
    }

    public void setTRT_RANGE_TO(String TRT_RANGE_TO) {
        this.TRT_RANGE_TO = TRT_RANGE_TO;
    }

    public String getTRT_RANGE_TO() {
        return TRT_RANGE_TO;
    }

    public void setTRT_AGE_FROM(String TRT_AGE_FROM) {
        this.TRT_AGE_FROM = TRT_AGE_FROM;
    }

    public String getTRT_AGE_FROM() {
        return TRT_AGE_FROM;
    }

    public void setTRT_AGE_TO(String TRT_AGE_TO) {
        this.TRT_AGE_TO = TRT_AGE_TO;
    }

    public String getTRT_AGE_TO() {
        return TRT_AGE_TO;
    }

    public void setTRT_RATE(String TRT_RATE) {
        this.TRT_RATE = TRT_RATE;
    }

    public String getTRT_RATE() {
        return TRT_RATE;
    }

    public void setTRT_DIVISION_FACTOR(String TRT_DIVISION_FACTOR) {
        this.TRT_DIVISION_FACTOR = TRT_DIVISION_FACTOR;
    }

    public String getTRT_DIVISION_FACTOR() {
        return TRT_DIVISION_FACTOR;
    }

    public void setTRT_RATE_TYPE(String TRT_RATE_TYPE) {
        this.TRT_RATE_TYPE = TRT_RATE_TYPE;
    }

    public String getTRT_RATE_TYPE() {
        return TRT_RATE_TYPE;
    }

    public void setTRT_RATE_TYPE_DESC(String TRT_RATE_TYPE_DESC) {
        this.TRT_RATE_TYPE_DESC = TRT_RATE_TYPE_DESC;
    }

    public String getTRT_RATE_TYPE_DESC() {
        return TRT_RATE_TYPE_DESC;
    }

    public void setTRT_APPLIED_TO(String TRT_APPLIED_TO) {
        this.TRT_APPLIED_TO = TRT_APPLIED_TO;
    }

    public String getTRT_APPLIED_TO() {
        return TRT_APPLIED_TO;
    }

    public void setTRT_APPLIED_TO_DESC(String TRT_APPLIED_TO_DESC) {
        this.TRT_APPLIED_TO_DESC = TRT_APPLIED_TO_DESC;
    }

    public String getTRT_APPLIED_TO_DESC() {
        return TRT_APPLIED_TO_DESC;
    }

    public void setTRT_APPLICATION_FREQ(String TRT_APPLICATION_FREQ) {
        this.TRT_APPLICATION_FREQ = TRT_APPLICATION_FREQ;
    }

    public String getTRT_APPLICATION_FREQ() {
        return TRT_APPLICATION_FREQ;
    }

    public void setTRT_APPLICATION_FREQ_DESC(String TRT_APPLICATION_FREQ_DESC) {
        this.TRT_APPLICATION_FREQ_DESC = TRT_APPLICATION_FREQ_DESC;
    }

    public String getTRT_APPLICATION_FREQ_DESC() {
        return TRT_APPLICATION_FREQ_DESC;
    }

    public void setTRT_TAX_DURATION(String TRT_TAX_DURATION) {
        this.TRT_TAX_DURATION = TRT_TAX_DURATION;
    }

    public String getTRT_TAX_DURATION() {
        return TRT_TAX_DURATION;
    }

    public void setCVT_DESC(String CVT_DESC) {
        this.CVT_DESC = CVT_DESC;
    }

    public String getCVT_DESC() {
        return CVT_DESC;
    }

    public void setTRT_WEF_DATE(Date TRT_WEF_DATE) {
        this.TRT_WEF_DATE = TRT_WEF_DATE;
    }

    public Date getTRT_WEF_DATE() {
        return TRT_WEF_DATE;
    }

    public void setTRT_WET_DATE(Date TRT_WET_DATE) {
        this.TRT_WET_DATE = TRT_WET_DATE;
    }

    public Date getTRT_WET_DATE() {
        return TRT_WET_DATE;
    }

    public void setMTL_CODE(BigDecimal MTL_CODE) {
        this.MTL_CODE = MTL_CODE;
    }

    public BigDecimal getMTL_CODE() {
        return MTL_CODE;
    }

    public void setMTL_DESC(String MTL_DESC) {
        this.MTL_DESC = MTL_DESC;
    }

    public String getMTL_DESC() {
        return MTL_DESC;
    }

    public void setMTL_FEES(String MTL_FEES) {
        this.MTL_FEES = MTL_FEES;
    }

    public String getMTL_FEES() {
        return MTL_FEES;
    }

    public void setMTL_WEF(Date MTL_WEF) {
        this.MTL_WEF = MTL_WEF;
    }

    public Date getMTL_WEF() {
        return MTL_WEF;
    }

    public void setMTL_WET(Date MTL_WET) {
        this.MTL_WET = MTL_WET;
    }

    public Date getMTL_WET() {
        return MTL_WET;
    }

    public void setMTL_VALIDITY_PRD(String MTL_VALIDITY_PRD) {
        this.MTL_VALIDITY_PRD = MTL_VALIDITY_PRD;
    }

    public String getMTL_VALIDITY_PRD() {
        return MTL_VALIDITY_PRD;
    }

    public void setSPR_CODE(BigDecimal SPR_CODE) {
        this.SPR_CODE = SPR_CODE;
    }

    public BigDecimal getSPR_CODE() {
        return SPR_CODE;
    }

    public void setSPR_SHT_DESC(String SPR_SHT_DESC) {
        this.SPR_SHT_DESC = SPR_SHT_DESC;
    }

    public String getSPR_SHT_DESC() {
        return SPR_SHT_DESC;
    }

    public void setSPR_NAME(String SPR_NAME) {
        this.SPR_NAME = SPR_NAME;
    }

    public String getSPR_NAME() {
        return SPR_NAME;
    }

    public void setSPR_SPT_CODE(BigDecimal SPR_SPT_CODE) {
        this.SPR_SPT_CODE = SPR_SPT_CODE;
    }

    public BigDecimal getSPR_SPT_CODE() {
        return SPR_SPT_CODE;
    }

    public void setTWN_NAME(String TWN_NAME) {
        this.TWN_NAME = TWN_NAME;
    }

    public String getTWN_NAME() {
        return TWN_NAME;
    }

    public void setFTL_CODE(BigDecimal FTL_CODE) {
        this.FTL_CODE = FTL_CODE;
    }

    public BigDecimal getFTL_CODE() {
        return FTL_CODE;
    }

    public void setMEDICAL_DISPLAY(String MEDICAL_DISPLAY) {
        this.MEDICAL_DISPLAY = MEDICAL_DISPLAY;
    }

    public String getMEDICAL_DISPLAY() {
        return MEDICAL_DISPLAY;
    }

    public void setFTL_FEES(String FTL_FEES) {
        this.FTL_FEES = FTL_FEES;
    }

    public String getFTL_FEES() {
        return FTL_FEES;
    }

    public void setFTL_WEF(Date FTL_WEF) {
        this.FTL_WEF = FTL_WEF;
    }

    public Date getFTL_WEF() {
        return FTL_WEF;
    }

    public void setFTL_WET(Date FTL_WET) {
        this.FTL_WET = FTL_WET;
    }

    public Date getFTL_WET() {
        return FTL_WET;
    }

    public void setFTL_VALIDITY_PRD(String FTL_VALIDITY_PRD) {
        this.FTL_VALIDITY_PRD = FTL_VALIDITY_PRD;
    }

    public String getFTL_VALIDITY_PRD() {
        return FTL_VALIDITY_PRD;
    }

    public void setMTL_SHT_DESC(String MTL_SHT_DESC) {
        this.MTL_SHT_DESC = MTL_SHT_DESC;
    }

    public String getMTL_SHT_DESC() {
        return MTL_SHT_DESC;
    }

    public void setLC_CODE(BigDecimal LC_CODE) {
        this.LC_CODE = LC_CODE;
    }

    public BigDecimal getLC_CODE() {
        return LC_CODE;
    }

    public void setLC_DESC(String LC_DESC) {
        this.LC_DESC = LC_DESC;
    }

    public String getLC_DESC() {
        return LC_DESC;
    }

    public void setPCD_CODE(BigDecimal PCD_CODE) {
        this.PCD_CODE = PCD_CODE;
    }

    public BigDecimal getPCD_CODE() {
        return PCD_CODE;
    }

    public void setPCD_DTY_DESCRIPTION(String PCD_DTY_DESCRIPTION) {
        this.PCD_DTY_DESCRIPTION = PCD_DTY_DESCRIPTION;
    }

    public String getPCD_DTY_DESCRIPTION() {
        return PCD_DTY_DESCRIPTION;
    }

    public void setPCD_PROD_DESC(String PCD_PROD_DESC) {
        this.PCD_PROD_DESC = PCD_PROD_DESC;
    }

    public String getPCD_PROD_DESC() {
        return PCD_PROD_DESC;
    }

    public void setGRPT_CODE(BigDecimal GRPT_CODE) {
        this.GRPT_CODE = GRPT_CODE;
    }

    public BigDecimal getGRPT_CODE() {
        return GRPT_CODE;
    }

    public void setGRPT_TERM_FROM(String GRPT_TERM_FROM) {
        this.GRPT_TERM_FROM = GRPT_TERM_FROM;
    }

    public String getGRPT_TERM_FROM() {
        return GRPT_TERM_FROM;
    }

    public void setGRPT_TERM_TO(String GRPT_TERM_TO) {
        this.GRPT_TERM_TO = GRPT_TERM_TO;
    }

    public String getGRPT_TERM_TO() {
        return GRPT_TERM_TO;
    }

    public void setGPIR_CODE(BigDecimal GPIR_CODE) {
        this.GPIR_CODE = GPIR_CODE;
    }

    public BigDecimal getGPIR_CODE() {
        return GPIR_CODE;
    }

    public void setGPIR_RATE_FROM(String GPIR_RATE_FROM) {
        this.GPIR_RATE_FROM = GPIR_RATE_FROM;
    }

    public String getGPIR_RATE_FROM() {
        return GPIR_RATE_FROM;
    }

    public void setGPIR_RATE_TO(String GPIR_RATE_TO) {
        this.GPIR_RATE_TO = GPIR_RATE_TO;
    }

    public String getGPIR_RATE_TO() {
        return GPIR_RATE_TO;
    }

    public void setGPR_CODE(BigDecimal GPR_CODE) {
        this.GPR_CODE = GPR_CODE;
    }

    public BigDecimal getGPR_CODE() {
        return GPR_CODE;
    }

    public void setGPR_ANB_FROM(String GPR_ANB_FROM) {
        this.GPR_ANB_FROM = GPR_ANB_FROM;
    }

    public String getGPR_ANB_FROM() {
        return GPR_ANB_FROM;
    }

    public void setGPR_ANB_TO(String GPR_ANB_TO) {
        this.GPR_ANB_TO = GPR_ANB_TO;
    }

    public String getGPR_ANB_TO() {
        return GPR_ANB_TO;
    }

    public void setGPR_RANGE_FROM(String GPR_RANGE_FROM) {
        this.GPR_RANGE_FROM = GPR_RANGE_FROM;
    }

    public String getGPR_RANGE_FROM() {
        return GPR_RANGE_FROM;
    }

    public void setGPR_RANGE_TO(String GPR_RANGE_TO) {
        this.GPR_RANGE_TO = GPR_RANGE_TO;
    }

    public String getGPR_RANGE_TO() {
        return GPR_RANGE_TO;
    }

    public void setGPR_RATE(String GPR_RATE) {
        this.GPR_RATE = GPR_RATE;
    }

    public String getGPR_RATE() {
        return GPR_RATE;
    }

    public void setGPR_ANNUAL_RATE(String GPR_ANNUAL_RATE) {
        this.GPR_ANNUAL_RATE = GPR_ANNUAL_RATE;
    }

    public String getGPR_ANNUAL_RATE() {
        return GPR_ANNUAL_RATE;
    }

    public void setGPR_SINGLE_RATE(String GPR_SINGLE_RATE) {
        this.GPR_SINGLE_RATE = GPR_SINGLE_RATE;
    }

    public String getGPR_SINGLE_RATE() {
        return GPR_SINGLE_RATE;
    }

    public void setGPR_RATE_DESC(String GPR_RATE_DESC) {
        this.GPR_RATE_DESC = GPR_RATE_DESC;
    }

    public String getGPR_RATE_DESC() {
        return GPR_RATE_DESC;
    }

    public void setGPR_DIVISION_FACTOR(String GPR_DIVISION_FACTOR) {
        this.GPR_DIVISION_FACTOR = GPR_DIVISION_FACTOR;
    }

    public String getGPR_DIVISION_FACTOR() {
        return GPR_DIVISION_FACTOR;
    }

    public void setGPR_RATE_TYPE(String GPR_RATE_TYPE) {
        this.GPR_RATE_TYPE = GPR_RATE_TYPE;
    }

    public String getGPR_RATE_TYPE() {
        return GPR_RATE_TYPE;
    }

    public void setGPR_RATE_TYPE_DESC(String GPR_RATE_TYPE_DESC) {
        this.GPR_RATE_TYPE_DESC = GPR_RATE_TYPE_DESC;
    }

    public String getGPR_RATE_TYPE_DESC() {
        return GPR_RATE_TYPE_DESC;
    }

    public void setGPR_PRORATED_FULL(String GPR_PRORATED_FULL) {
        this.GPR_PRORATED_FULL = GPR_PRORATED_FULL;
    }

    public String getGPR_PRORATED_FULL() {
        return GPR_PRORATED_FULL;
    }

    public void setGPR_MULTIPLIER_RATE(String GPR_MULTIPLIER_RATE) {
        this.GPR_MULTIPLIER_RATE = GPR_MULTIPLIER_RATE;
    }

    public String getGPR_MULTIPLIER_RATE() {
        return GPR_MULTIPLIER_RATE;
    }

    public void setGPR_MULTIPLIER_RATE_DESC(String GPR_MULTIPLIER_RATE_DESC) {
        this.GPR_MULTIPLIER_RATE_DESC = GPR_MULTIPLIER_RATE_DESC;
    }

    public String getGPR_MULTIPLIER_RATE_DESC() {
        return GPR_MULTIPLIER_RATE_DESC;
    }

    public void setGPR_MULTPLIER_DIV_FACT(String GPR_MULTPLIER_DIV_FACT) {
        this.GPR_MULTPLIER_DIV_FACT = GPR_MULTPLIER_DIV_FACT;
    }

    public String getGPR_MULTPLIER_DIV_FACT() {
        return GPR_MULTPLIER_DIV_FACT;
    }

    public void setGPR_CONSTANT(String GPR_CONSTANT) {
        this.GPR_CONSTANT = GPR_CONSTANT;
    }

    public String getGPR_CONSTANT() {
        return GPR_CONSTANT;
    }

    public void setGPR_CONSTANT_DIV_FACT(String GPR_CONSTANT_DIV_FACT) {
        this.GPR_CONSTANT_DIV_FACT = GPR_CONSTANT_DIV_FACT;
    }

    public String getGPR_CONSTANT_DIV_FACT() {
        return GPR_CONSTANT_DIV_FACT;
    }

    public void setGPR_NORMAL_REFUND(String GPR_NORMAL_REFUND) {
        this.GPR_NORMAL_REFUND = GPR_NORMAL_REFUND;
    }

    public String getGPR_NORMAL_REFUND() {
        return GPR_NORMAL_REFUND;
    }

    public void setGPR_NORMAL_REFUND_DESC(String GPR_NORMAL_REFUND_DESC) {
        this.GPR_NORMAL_REFUND_DESC = GPR_NORMAL_REFUND_DESC;
    }

    public String getGPR_NORMAL_REFUND_DESC() {
        return GPR_NORMAL_REFUND_DESC;
    }

    public void setGPR_WEF(Date GPR_WEF) {
        this.GPR_WEF = GPR_WEF;
    }

    public Date getGPR_WEF() {
        return GPR_WEF;
    }

    public void setGPR_WET(Date GPR_WET) {
        this.GPR_WET = GPR_WET;
    }

    public Date getGPR_WET() {
        return GPR_WET;
    }

    public void setPCD_PCT_CODE(BigDecimal PCD_PCT_CODE) {
        this.PCD_PCT_CODE = PCD_PCT_CODE;
    }

    public BigDecimal getPCD_PCT_CODE() {
        return PCD_PCT_CODE;
    }

    public void setDTY_CODE(BigDecimal DTY_CODE) {
        this.DTY_CODE = DTY_CODE;
    }

    public BigDecimal getDTY_CODE() {
        return DTY_CODE;
    }

    public void setDTY_SHT_DESC(String DTY_SHT_DESC) {
        this.DTY_SHT_DESC = DTY_SHT_DESC;
    }

    public String getDTY_SHT_DESC() {
        return DTY_SHT_DESC;
    }

    public void setPCD_CVT_CODE(BigDecimal PCD_CVT_CODE) {
        this.PCD_CVT_CODE = PCD_CVT_CODE;
    }

    public BigDecimal getPCD_CVT_CODE() {
        return PCD_CVT_CODE;
    }

    public void setPCD_CVT_SHT_DESC(String PCD_CVT_SHT_DESC) {
        this.PCD_CVT_SHT_DESC = PCD_CVT_SHT_DESC;
    }

    public String getPCD_CVT_SHT_DESC() {
        return PCD_CVT_SHT_DESC;
    }

    public void setMTG_CODE(BigDecimal MTG_CODE) {
        this.MTG_CODE = MTG_CODE;
    }

    public BigDecimal getMTG_CODE() {
        return MTG_CODE;
    }

    public void setMTG_SHT_DESC(String MTG_SHT_DESC) {
        this.MTG_SHT_DESC = MTG_SHT_DESC;
    }

    public String getMTG_SHT_DESC() {
        return MTG_SHT_DESC;
    }

    public void setMTG_DESC(String MTG_DESC) {
        this.MTG_DESC = MTG_DESC;
    }

    public String getMTG_DESC() {
        return MTG_DESC;
    }

    public void setMTG_WEF(Date MTG_WEF) {
        this.MTG_WEF = MTG_WEF;
    }

    public Date getMTG_WEF() {
        return MTG_WEF;
    }

    public void setMTG_WET(Date MTG_WET) {
        this.MTG_WET = MTG_WET;
    }

    public Date getMTG_WET() {
        return MTG_WET;
    }

    public void setMGIT_CODE(BigDecimal MGIT_CODE) {
        this.MGIT_CODE = MGIT_CODE;
    }

    public BigDecimal getMGIT_CODE() {
        return MGIT_CODE;
    }

    public void setMGIT_MTL_CODE(BigDecimal MGIT_MTL_CODE) {
        this.MGIT_MTL_CODE = MGIT_MTL_CODE;
    }

    public BigDecimal getMGIT_MTL_CODE() {
        return MGIT_MTL_CODE;
    }

    public void setTRT_SHT_DESC(String TRT_SHT_DESC) {
        this.TRT_SHT_DESC = TRT_SHT_DESC;
    }

    public String getTRT_SHT_DESC() {
        return TRT_SHT_DESC;
    }

    public void setTRT_DESC(String TRT_DESC) {
        this.TRT_DESC = TRT_DESC;
    }

    public String getTRT_DESC() {
        return TRT_DESC;
    }

    public void setTRT_LEVEL(String TRT_LEVEL) {
        this.TRT_LEVEL = TRT_LEVEL;
    }

    public String getTRT_LEVEL() {
        return TRT_LEVEL;
    }

    public void setTRTG_CODE(BigDecimal TRTG_CODE) {
        this.TRTG_CODE = TRTG_CODE;
    }

    public BigDecimal getTRTG_CODE() {
        return TRTG_CODE;
    }

    public void setTRTG_SHT_DESC(String TRTG_SHT_DESC) {
        this.TRTG_SHT_DESC = TRTG_SHT_DESC;
    }

    public String getTRTG_SHT_DESC() {
        return TRTG_SHT_DESC;
    }

    public void setTRTG_DESC(String TRTG_DESC) {
        this.TRTG_DESC = TRTG_DESC;
    }

    public String getTRTG_DESC() {
        return TRTG_DESC;
    }

    public void setTRS_CODE(BigDecimal TRS_CODE) {
        this.TRS_CODE = TRS_CODE;
    }

    public BigDecimal getTRS_CODE() {
        return TRS_CODE;
    }

    public void setTRS_SHT_DESC(String TRS_SHT_DESC) {
        this.TRS_SHT_DESC = TRS_SHT_DESC;
    }

    public String getTRS_SHT_DESC() {
        return TRS_SHT_DESC;
    }

    public void setTRS_NAME(String TRS_NAME) {
        this.TRS_NAME = TRS_NAME;
    }

    public String getTRS_NAME() {
        return TRS_NAME;
    }

    public void setTRS_TRTG_SHT_DESC(String TRS_TRTG_SHT_DESC) {
        this.TRS_TRTG_SHT_DESC = TRS_TRTG_SHT_DESC;
    }

    public String getTRS_TRTG_SHT_DESC() {
        return TRS_TRTG_SHT_DESC;
    }

    public void setMANB_CODE(BigDecimal MANB_CODE) {
        this.MANB_CODE = MANB_CODE;
    }

    public BigDecimal getMANB_CODE() {
        return MANB_CODE;
    }

    public void setMANB_ANB_FROM(String MANB_ANB_FROM) {
        this.MANB_ANB_FROM = MANB_ANB_FROM;
    }

    public String getMANB_ANB_FROM() {
        return MANB_ANB_FROM;
    }

    public void setMANB_ANB_TO(String MANB_ANB_TO) {
        this.MANB_ANB_TO = MANB_ANB_TO;
    }

    public String getMANB_ANB_TO() {
        return MANB_ANB_TO;
    }

    public void setMANB_WEF(Date MANB_WEF) {
        this.MANB_WEF = MANB_WEF;
    }

    public Date getMANB_WEF() {
        return MANB_WEF;
    }

    public void setMANB_WET(Date MANB_WET) {
        this.MANB_WET = MANB_WET;
    }

    public Date getMANB_WET() {
        return MANB_WET;
    }

    public void setMREQ_CODE(BigDecimal MREQ_CODE) {
        this.MREQ_CODE = MREQ_CODE;
    }

    public BigDecimal getMREQ_CODE() {
        return MREQ_CODE;
    }

    public void setMREQ_RANGE_FROM(String MREQ_RANGE_FROM) {
        this.MREQ_RANGE_FROM = MREQ_RANGE_FROM;
    }

    public String getMREQ_RANGE_FROM() {
        return MREQ_RANGE_FROM;
    }

    public void setMREQ_RANGE_TO(String MREQ_RANGE_TO) {
        this.MREQ_RANGE_TO = MREQ_RANGE_TO;
    }

    public String getMREQ_RANGE_TO() {
        return MREQ_RANGE_TO;
    }

    public void setMREQ_MTG_DESC(String MREQ_MTG_DESC) {
        this.MREQ_MTG_DESC = MREQ_MTG_DESC;
    }

    public String getMREQ_MTG_DESC() {
        return MREQ_MTG_DESC;
    }

    public void setMREQ_WEF(Date MREQ_WEF) {
        this.MREQ_WEF = MREQ_WEF;
    }

    public Date getMREQ_WEF() {
        return MREQ_WEF;
    }

    public void setMREQ_WET(Date MREQ_WET) {
        this.MREQ_WET = MREQ_WET;
    }

    public Date getMREQ_WET() {
        return MREQ_WET;
    }

    public void setGFM_CODE(BigDecimal GFM_CODE) {
        this.GFM_CODE = GFM_CODE;
    }

    public BigDecimal getGFM_CODE() {
        return GFM_CODE;
    }

    public void setGFM_ANB_FROM(String GFM_ANB_FROM) {
        this.GFM_ANB_FROM = GFM_ANB_FROM;
    }

    public String getGFM_ANB_FROM() {
        return GFM_ANB_FROM;
    }

    public void setGFM_ANB_TO(String GFM_ANB_TO) {
        this.GFM_ANB_TO = GFM_ANB_TO;
    }

    public String getGFM_ANB_TO() {
        return GFM_ANB_TO;
    }

    public void setGFM_LAST_MEDICAL_DURATION(String GFM_LAST_MEDICAL_DURATION) {
        this.GFM_LAST_MEDICAL_DURATION = GFM_LAST_MEDICAL_DURATION;
    }

    public String getGFM_LAST_MEDICAL_DURATION() {
        return GFM_LAST_MEDICAL_DURATION;
    }

    public void setGMF_INCREASE_SA_LAST_MED_PERC(String GMF_INCREASE_SA_LAST_MED_PERC) {
        this.GMF_INCREASE_SA_LAST_MED_PERC = GMF_INCREASE_SA_LAST_MED_PERC;
    }

    public String getGMF_INCREASE_SA_LAST_MED_PERC() {
        return GMF_INCREASE_SA_LAST_MED_PERC;
    }

    public void setGFM_INCREASE_TYPE(String GFM_INCREASE_TYPE) {
        this.GFM_INCREASE_TYPE = GFM_INCREASE_TYPE;
    }

    public String getGFM_INCREASE_TYPE() {
        return GFM_INCREASE_TYPE;
    }

    public void setGFM_INCREASE_MULT_DIV_FACT(String GFM_INCREASE_MULT_DIV_FACT) {
        this.GFM_INCREASE_MULT_DIV_FACT = GFM_INCREASE_MULT_DIV_FACT;
    }

    public String getGFM_INCREASE_MULT_DIV_FACT() {
        return GFM_INCREASE_MULT_DIV_FACT;
    }

    public void setLC_SHT_DESC(String LC_SHT_DESC) {
        this.LC_SHT_DESC = LC_SHT_DESC;
    }

    public String getLC_SHT_DESC() {
        return LC_SHT_DESC;
    }

    public void setLC_HAZARDOUS(String LC_HAZARDOUS) {
        this.LC_HAZARDOUS = LC_HAZARDOUS;
    }

    public String getLC_HAZARDOUS() {
        return LC_HAZARDOUS;
    }

    public void setLC_HAZAROUS_DESC(String LC_HAZAROUS_DESC) {
        this.LC_HAZAROUS_DESC = LC_HAZAROUS_DESC;
    }

    public String getLC_HAZAROUS_DESC() {
        return LC_HAZAROUS_DESC;
    }

    public void setORRP_CODE(BigDecimal ORRP_CODE) {
        this.ORRP_CODE = ORRP_CODE;
    }

    public BigDecimal getORRP_CODE() {
        return ORRP_CODE;
    }

    public void setORRP_SHT_DESC(String ORRP_SHT_DESC) {
        this.ORRP_SHT_DESC = ORRP_SHT_DESC;
    }

    public String getORRP_SHT_DESC() {
        return ORRP_SHT_DESC;
    }

    public void setORRP_DESC(String ORRP_DESC) {
        this.ORRP_DESC = ORRP_DESC;
    }

    public String getORRP_DESC() {
        return ORRP_DESC;
    }

    public void setORRT_CODE(BigDecimal ORRT_CODE) {
        this.ORRT_CODE = ORRT_CODE;
    }

    public BigDecimal getORRT_CODE() {
        return ORRT_CODE;
    }

    public void setORRT_ANB_FROM(String ORRT_ANB_FROM) {
        this.ORRT_ANB_FROM = ORRT_ANB_FROM;
    }

    public String getORRT_ANB_FROM() {
        return ORRT_ANB_FROM;
    }

    public void setORRT_ANB_TO(String ORRT_ANB_TO) {
        this.ORRT_ANB_TO = ORRT_ANB_TO;
    }

    public String getORRT_ANB_TO() {
        return ORRT_ANB_TO;
    }

    public void setORRT_RATE(String ORRT_RATE) {
        this.ORRT_RATE = ORRT_RATE;
    }

    public String getORRT_RATE() {
        return ORRT_RATE;
    }

    public void setORRT_DIVISION_FACTOR(String ORRT_DIVISION_FACTOR) {
        this.ORRT_DIVISION_FACTOR = ORRT_DIVISION_FACTOR;
    }

    public String getORRT_DIVISION_FACTOR() {
        return ORRT_DIVISION_FACTOR;
    }

    public void setORRT_RATE_TYPE(String ORRT_RATE_TYPE) {
        this.ORRT_RATE_TYPE = ORRT_RATE_TYPE;
    }

    public String getORRT_RATE_TYPE() {
        return ORRT_RATE_TYPE;
    }

    public void setORRT_RATE_TYPE_DESC(String ORRT_RATE_TYPE_DESC) {
        this.ORRT_RATE_TYPE_DESC = ORRT_RATE_TYPE_DESC;
    }

    public String getORRT_RATE_TYPE_DESC() {
        return ORRT_RATE_TYPE_DESC;
    }

    public void setORRT_WEF(Date ORRT_WEF) {
        this.ORRT_WEF = ORRT_WEF;
    }

    public Date getORRT_WEF() {
        return ORRT_WEF;
    }

    public void setORRT_WET(Date ORRT_WET) {
        this.ORRT_WET = ORRT_WET;
    }

    public Date getORRT_WET() {
        return ORRT_WET;
    }

    public void setRIOS_CODE(BigDecimal RIOS_CODE) {
        this.RIOS_CODE = RIOS_CODE;
    }

    public BigDecimal getRIOS_CODE() {
        return RIOS_CODE;
    }

    public void setRIOS_SHT_DESC(String RIOS_SHT_DESC) {
        this.RIOS_SHT_DESC = RIOS_SHT_DESC;
    }

    public String getRIOS_SHT_DESC() {
        return RIOS_SHT_DESC;
    }

    public void setRIOS_DESC(String RIOS_DESC) {
        this.RIOS_DESC = RIOS_DESC;
    }

    public String getRIOS_DESC() {
        return RIOS_DESC;
    }

    public void setRIOS_WEF(Date RIOS_WEF) {
        this.RIOS_WEF = RIOS_WEF;
    }

    public Date getRIOS_WEF() {
        return RIOS_WEF;
    }

    public void setRIOS_WET(Date RIOS_WET) {
        this.RIOS_WET = RIOS_WET;
    }

    public Date getRIOS_WET() {
        return RIOS_WET;
    }

    public void setRIOT_CODE(BigDecimal RIOT_CODE) {
        this.RIOT_CODE = RIOT_CODE;
    }

    public BigDecimal getRIOT_CODE() {
        return RIOT_CODE;
    }

    public void setRIOT_POLICY_TERM(String RIOT_POLICY_TERM) {
        this.RIOT_POLICY_TERM = RIOT_POLICY_TERM;
    }

    public String getRIOT_POLICY_TERM() {
        return RIOT_POLICY_TERM;
    }

    public void setRIOT_POLICY_TERM_TO(String RIOT_POLICY_TERM_TO) {
        this.RIOT_POLICY_TERM_TO = RIOT_POLICY_TERM_TO;
    }

    public String getRIOT_POLICY_TERM_TO() {
        return RIOT_POLICY_TERM_TO;
    }

    public void setRIOT_LAPSED_TERM(String RIOT_LAPSED_TERM) {
        this.RIOT_LAPSED_TERM = RIOT_LAPSED_TERM;
    }

    public String getRIOT_LAPSED_TERM() {
        return RIOT_LAPSED_TERM;
    }

    public void setRIOT_LAPSED_TERM_TO(String RIOT_LAPSED_TERM_TO) {
        this.RIOT_LAPSED_TERM_TO = RIOT_LAPSED_TERM_TO;
    }

    public String getRIOT_LAPSED_TERM_TO() {
        return RIOT_LAPSED_TERM_TO;
    }

    public void setRIOT_RATE(String RIOT_RATE) {
        this.RIOT_RATE = RIOT_RATE;
    }

    public String getRIOT_RATE() {
        return RIOT_RATE;
    }

    public void setRIOT_DIVISION_FACTOR(String RIOT_DIVISION_FACTOR) {
        this.RIOT_DIVISION_FACTOR = RIOT_DIVISION_FACTOR;
    }

    public String getRIOT_DIVISION_FACTOR() {
        return RIOT_DIVISION_FACTOR;
    }

    public void setINGR_CODE(BigDecimal INGR_CODE) {
        this.INGR_CODE = INGR_CODE;
    }

    public BigDecimal getINGR_CODE() {
        return INGR_CODE;
    }

    public void setINGR_SHT_DESC(String INGR_SHT_DESC) {
        this.INGR_SHT_DESC = INGR_SHT_DESC;
    }

    public String getINGR_SHT_DESC() {
        return INGR_SHT_DESC;
    }

    public void setINGR_DESC(String INGR_DESC) {
        this.INGR_DESC = INGR_DESC;
    }

    public String getINGR_DESC() {
        return INGR_DESC;
    }

    public void setCCR_CODE(BigDecimal CCR_CODE) {
        this.CCR_CODE = CCR_CODE;
    }

    public BigDecimal getCCR_CODE() {
        return CCR_CODE;
    }

    public void setCCR_DESCRIPTION(String CCR_DESCRIPTION) {
        this.CCR_DESCRIPTION = CCR_DESCRIPTION;
    }

    public String getCCR_DESCRIPTION() {
        return CCR_DESCRIPTION;
    }

    public void setCCR_INGR_CODE(BigDecimal CCR_INGR_CODE) {
        this.CCR_INGR_CODE = CCR_INGR_CODE;
    }

    public BigDecimal getCCR_INGR_CODE() {
        return CCR_INGR_CODE;
    }

    public void setPrpCode(BigDecimal prpCode) {
        this.prpCode = prpCode;
    }

    public BigDecimal getPrpCode() {
        return prpCode;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setCraCode(BigDecimal craCode) {
        this.craCode = craCode;
    }

    public BigDecimal getCraCode() {
        return craCode;
    }

    public void setCRA_CREDIT_DAYS(String CRA_CREDIT_DAYS) {
        this.CRA_CREDIT_DAYS = CRA_CREDIT_DAYS;
    }

    public String getCRA_CREDIT_DAYS() {
        return CRA_CREDIT_DAYS;
    }

    public void setCRA_ACTION(String CRA_ACTION) {
        this.CRA_ACTION = CRA_ACTION;
    }

    public String getCRA_ACTION() {
        return CRA_ACTION;
    }

    public void setCRA_INGR_CODE(BigDecimal CRA_INGR_CODE) {
        this.CRA_INGR_CODE = CRA_INGR_CODE;
    }

    public BigDecimal getCRA_INGR_CODE() {
        return CRA_INGR_CODE;
    }

    public void setCRA_WAIVER(String CRA_WAIVER) {
        this.CRA_WAIVER = CRA_WAIVER;
    }

    public String getCRA_WAIVER() {
        return CRA_WAIVER;
    }

    public void setCRA_INGR_DESC(String CRA_INGR_DESC) {
        this.CRA_INGR_DESC = CRA_INGR_DESC;
    }

    public String getCRA_INGR_DESC() {
        return CRA_INGR_DESC;
    }

    public void setCVT_CODE(BigDecimal CVT_CODE) {
        this.CVT_CODE = CVT_CODE;
    }

    public BigDecimal getCVT_CODE() {
        return CVT_CODE;
    }

    public void setCVT_SHT_DESC(String CVT_SHT_DESC) {
        this.CVT_SHT_DESC = CVT_SHT_DESC;
    }

    public String getCVT_SHT_DESC() {
        return CVT_SHT_DESC;
    }

    public void setCVT_DESCRIPTION(String CVT_DESCRIPTION) {
        this.CVT_DESCRIPTION = CVT_DESCRIPTION;
    }

    public String getCVT_DESCRIPTION() {
        return CVT_DESCRIPTION;
    }

    public void setCVT_MAIN_COVER(String CVT_MAIN_COVER) {
        this.CVT_MAIN_COVER = CVT_MAIN_COVER;
    }

    public String getCVT_MAIN_COVER() {
        return CVT_MAIN_COVER;
    }

    public void setCVT_MAIN_COVER_DESC(String CVT_MAIN_COVER_DESC) {
        this.CVT_MAIN_COVER_DESC = CVT_MAIN_COVER_DESC;
    }

    public String getCVT_MAIN_COVER_DESC() {
        return CVT_MAIN_COVER_DESC;
    }

    public void setCVT_DURATION_TYPE(String CVT_DURATION_TYPE) {
        this.CVT_DURATION_TYPE = CVT_DURATION_TYPE;
    }

    public String getCVT_DURATION_TYPE() {
        return CVT_DURATION_TYPE;
    }

    public void setCVT_DURATION_TYPE_DESC(String CVT_DURATION_TYPE_DESC) {
        this.CVT_DURATION_TYPE_DESC = CVT_DURATION_TYPE_DESC;
    }

    public String getCVT_DURATION_TYPE_DESC() {
        return CVT_DURATION_TYPE_DESC;
    }

    public void setCVT_MAX_AGE(BigDecimal CVT_MAX_AGE) {
        this.CVT_MAX_AGE = CVT_MAX_AGE;
    }

    public BigDecimal getCVT_MAX_AGE() {
        return CVT_MAX_AGE;
    }

    public void setCVT_MULTIPLIER(BigDecimal CVT_MULTIPLIER) {
        this.CVT_MULTIPLIER = CVT_MULTIPLIER;
    }

    public BigDecimal getCVT_MULTIPLIER() {
        return CVT_MULTIPLIER;
    }

    public void setCVT_MULT_DIV_FACT(BigDecimal CVT_MULT_DIV_FACT) {
        this.CVT_MULT_DIV_FACT = CVT_MULT_DIV_FACT;
    }

    public BigDecimal getCVT_MULT_DIV_FACT() {
        return CVT_MULT_DIV_FACT;
    }

    public void setCVT_READ_FROM(String CVT_READ_FROM) {
        this.CVT_READ_FROM = CVT_READ_FROM;
    }

    public String getCVT_READ_FROM() {
        return CVT_READ_FROM;
    }

    public void setCVT_READ_FROM_DESC(String CVT_READ_FROM_DESC) {
        this.CVT_READ_FROM_DESC = CVT_READ_FROM_DESC;
    }

    public String getCVT_READ_FROM_DESC() {
        return CVT_READ_FROM_DESC;
    }

    public void setCVT_RATE_TYPE(String CVT_RATE_TYPE) {
        this.CVT_RATE_TYPE = CVT_RATE_TYPE;
    }

    public String getCVT_RATE_TYPE() {
        return CVT_RATE_TYPE;
    }

    public void setCVT_RATE_TYPE_DESC(String CVT_RATE_TYPE_DESC) {
        this.CVT_RATE_TYPE_DESC = CVT_RATE_TYPE_DESC;
    }

    public String getCVT_RATE_TYPE_DESC() {
        return CVT_RATE_TYPE_DESC;
    }

    public void setCVT_REPORT_NAME(String CVT_REPORT_NAME) {
        this.CVT_REPORT_NAME = CVT_REPORT_NAME;
    }

    public String getCVT_REPORT_NAME() {
        return CVT_REPORT_NAME;
    }

    public void setCVT_REMARKS(String CVT_REMARKS) {
        this.CVT_REMARKS = CVT_REMARKS;
    }

    public String getCVT_REMARKS() {
        return CVT_REMARKS;
    }

    public void setCVT_RATES_FREQ_OF_PYMT(String CVT_RATES_FREQ_OF_PYMT) {
        this.CVT_RATES_FREQ_OF_PYMT = CVT_RATES_FREQ_OF_PYMT;
    }

    public String getCVT_RATES_FREQ_OF_PYMT() {
        return CVT_RATES_FREQ_OF_PYMT;
    }

    public void setCVT_RATES_FREQ_OF_PYMT_DESC(String CVT_RATES_FREQ_OF_PYMT_DESC) {
        this.CVT_RATES_FREQ_OF_PYMT_DESC = CVT_RATES_FREQ_OF_PYMT_DESC;
    }

    public String getCVT_RATES_FREQ_OF_PYMT_DESC() {
        return CVT_RATES_FREQ_OF_PYMT_DESC;
    }

    public void setPCT_CODE(BigDecimal PCT_CODE) {
        this.PCT_CODE = PCT_CODE;
    }

    public BigDecimal getPCT_CODE() {
        return PCT_CODE;
    }

    public void setPCT_CVT_CODE(BigDecimal PCT_CVT_CODE) {
        this.PCT_CVT_CODE = PCT_CVT_CODE;
    }

    public BigDecimal getPCT_CVT_CODE() {
        return PCT_CVT_CODE;
    }

    public void setPCT_PROD_CODE(BigDecimal PCT_PROD_CODE) {
        this.PCT_PROD_CODE = PCT_PROD_CODE;
    }

    public BigDecimal getPCT_PROD_CODE() {
        return PCT_PROD_CODE;
    }

    public void setPCT_CVT_DESC(String PCT_CVT_DESC) {
        this.PCT_CVT_DESC = PCT_CVT_DESC;
    }

    public String getPCT_CVT_DESC() {
        return PCT_CVT_DESC;
    }

    public void setPCT_CVT_SHT_DESC(String PCT_CVT_SHT_DESC) {
        this.PCT_CVT_SHT_DESC = PCT_CVT_SHT_DESC;
    }

    public String getPCT_CVT_SHT_DESC() {
        return PCT_CVT_SHT_DESC;
    }

    public void setPCT_FORMULAR(String PCT_FORMULAR) {
        this.PCT_FORMULAR = PCT_FORMULAR;
    }

    public String getPCT_FORMULAR() {
        return PCT_FORMULAR;
    }

    public void setPCT_REFUND_FORMULAR(String PCT_REFUND_FORMULAR) {
        this.PCT_REFUND_FORMULAR = PCT_REFUND_FORMULAR;
    }

    public String getPCT_REFUND_FORMULAR() {
        return PCT_REFUND_FORMULAR;
    }

    public void setPCT_FORMULAR_DESC(String PCT_FORMULAR_DESC) {
        this.PCT_FORMULAR_DESC = PCT_FORMULAR_DESC;
    }

    public String getPCT_FORMULAR_DESC() {
        return PCT_FORMULAR_DESC;
    }

    public void setPCT_REFUND_FORMULAR_DESC(String PCT_REFUND_FORMULAR_DESC) {
        this.PCT_REFUND_FORMULAR_DESC = PCT_REFUND_FORMULAR_DESC;
    }

    public String getPCT_REFUND_FORMULAR_DESC() {
        return PCT_REFUND_FORMULAR_DESC;
    }

    public void setPCT_MAIN_SA_PERC(BigDecimal PCT_MAIN_SA_PERC) {
        this.PCT_MAIN_SA_PERC = PCT_MAIN_SA_PERC;
    }

    public BigDecimal getPCT_MAIN_SA_PERC() {
        return PCT_MAIN_SA_PERC;
    }

    public void setPCT_MAX_CLM_AMT(BigDecimal PCT_MAX_CLM_AMT) {
        this.PCT_MAX_CLM_AMT = PCT_MAX_CLM_AMT;
    }

    public BigDecimal getPCT_MAX_CLM_AMT() {
        return PCT_MAX_CLM_AMT;
    }

    public void setPCT_MAX_ASSUREDS(BigDecimal PCT_MAX_ASSUREDS) {
        this.PCT_MAX_ASSUREDS = PCT_MAX_ASSUREDS;
    }

    public BigDecimal getPCT_MAX_ASSUREDS() {
        return PCT_MAX_ASSUREDS;
    }

    public void setPCT_MAX_AGE(BigDecimal PCT_MAX_AGE) {
        this.PCT_MAX_AGE = PCT_MAX_AGE;
    }

    public BigDecimal getPCT_MAX_AGE() {
        return PCT_MAX_AGE;
    }

    public void setPCT_MAX_SA(BigDecimal PCT_MAX_SA) {
        this.PCT_MAX_SA = PCT_MAX_SA;
    }

    public BigDecimal getPCT_MAX_SA() {
        return PCT_MAX_SA;
    }

    public void setPCT_RATE_DEPEND_ON_CLASS(String PCT_RATE_DEPEND_ON_CLASS) {
        this.PCT_RATE_DEPEND_ON_CLASS = PCT_RATE_DEPEND_ON_CLASS;
    }

    public String getPCT_RATE_DEPEND_ON_CLASS() {
        return PCT_RATE_DEPEND_ON_CLASS;
    }

    public void setPCT_RATE_DEPEND_ON_CLASS_DESC(String PCT_RATE_DEPEND_ON_CLASS_DESC) {
        this.PCT_RATE_DEPEND_ON_CLASS_DESC = PCT_RATE_DEPEND_ON_CLASS_DESC;
    }

    public String getPCT_RATE_DEPEND_ON_CLASS_DESC() {
        return PCT_RATE_DEPEND_ON_CLASS_DESC;
    }

    public void setPCT_GRP_OR_SINGLE_RATES(String PCT_GRP_OR_SINGLE_RATES) {
        this.PCT_GRP_OR_SINGLE_RATES = PCT_GRP_OR_SINGLE_RATES;
    }

    public String getPCT_GRP_OR_SINGLE_RATES() {
        return PCT_GRP_OR_SINGLE_RATES;
    }

    public void setPCT_GRP_OR_SINGLE_RATES_DESC(String PCT_GRP_OR_SINGLE_RATES_DESC) {
        this.PCT_GRP_OR_SINGLE_RATES_DESC = PCT_GRP_OR_SINGLE_RATES_DESC;
    }

    public String getPCT_GRP_OR_SINGLE_RATES_DESC() {
        return PCT_GRP_OR_SINGLE_RATES_DESC;
    }

    public void setPCT_MANDATORY(String PCT_MANDATORY) {
        this.PCT_MANDATORY = PCT_MANDATORY;
    }

    public String getPCT_MANDATORY() {
        return PCT_MANDATORY;
    }

    public void setPCT_MANDATORY_DESC(String PCT_MANDATORY_DESC) {
        this.PCT_MANDATORY_DESC = PCT_MANDATORY_DESC;
    }

    public String getPCT_MANDATORY_DESC() {
        return PCT_MANDATORY_DESC;
    }

    public void setPCT_ACCELERATOR(String PCT_ACCELERATOR) {
        this.PCT_ACCELERATOR = PCT_ACCELERATOR;
    }

    public String getPCT_ACCELERATOR() {
        return PCT_ACCELERATOR;
    }

    public void setPCT_ACCELERATOR_DESC(String PCT_ACCELERATOR_DESC) {
        this.PCT_ACCELERATOR_DESC = PCT_ACCELERATOR_DESC;
    }

    public String getPCT_ACCELERATOR_DESC() {
        return PCT_ACCELERATOR_DESC;
    }

    public void setPCT_RISK(String PCT_RISK) {
        this.PCT_RISK = PCT_RISK;
    }

    public String getPCT_RISK() {
        return PCT_RISK;
    }

    public void setPCT_INBUILT(String PCT_INBUILT) {
        this.PCT_INBUILT = PCT_INBUILT;
    }

    public String getPCT_INBUILT() {
        return PCT_INBUILT;
    }

    public void setPCT_INBUILT_DESC(String PCT_INBUILT_DESC) {
        this.PCT_INBUILT_DESC = PCT_INBUILT_DESC;
    }

    public String getPCT_INBUILT_DESC() {
        return PCT_INBUILT_DESC;
    }

    public void setADD_PCT_CODE(BigDecimal ADD_PCT_CODE) {
        this.ADD_PCT_CODE = ADD_PCT_CODE;
    }

    public BigDecimal getADD_PCT_CODE() {
        return ADD_PCT_CODE;
    }

    public void setADD_CVT_CODE(BigDecimal ADD_CVT_CODE) {
        this.ADD_CVT_CODE = ADD_CVT_CODE;
    }

    public BigDecimal getADD_CVT_CODE() {
        return ADD_CVT_CODE;
    }

    public void setADD_CVT_SHT_DESC(String ADD_CVT_SHT_DESC) {
        this.ADD_CVT_SHT_DESC = ADD_CVT_SHT_DESC;
    }

    public String getADD_CVT_SHT_DESC() {
        return ADD_CVT_SHT_DESC;
    }

    public void setADD_CVT_DESC(String ADD_CVT_DESC) {
        this.ADD_CVT_DESC = ADD_CVT_DESC;
    }

    public String getADD_CVT_DESC() {
        return ADD_CVT_DESC;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPremiumMaskItem(List<PremiumMaskItems> PremiumMaskItem) {
        this.PremiumMaskItem = PremiumMaskItem;
    }

    public List<PremiumMaskItems> getPremiumMaskItem() {
        return PremiumMaskItem;
    }

    public void setPROV_CODE(BigDecimal PROV_CODE) {
        this.PROV_CODE = PROV_CODE;
    }

    public BigDecimal getPROV_CODE() {
        return PROV_CODE;
    }

    public void setPROV_SHT_DESC(String PROV_SHT_DESC) {
        this.PROV_SHT_DESC = PROV_SHT_DESC;
    }

    public String getPROV_SHT_DESC() {
        return PROV_SHT_DESC;
    }

    public void setPROV_DESC(String PROV_DESC) {
        this.PROV_DESC = PROV_DESC;
    }

    public String getPROV_DESC() {
        return PROV_DESC;
    }

    public void setPCPR_DEFAULT(String PCPR_DEFAULT) {
        this.PCPR_DEFAULT = PCPR_DEFAULT;
    }

    public String getPCPR_DEFAULT() {
        return PCPR_DEFAULT;
    }

    public void setPCPR_CODE(BigDecimal PCPR_CODE) {
        this.PCPR_CODE = PCPR_CODE;
    }

    public BigDecimal getPCPR_CODE() {
        return PCPR_CODE;
    }

    public void setPCPR_PROV_CODE(BigDecimal PCPR_PROV_CODE) {
        this.PCPR_PROV_CODE = PCPR_PROV_CODE;
    }

    public BigDecimal getPCPR_PROV_CODE() {
        return PCPR_PROV_CODE;
    }

    public void setPCPR_EDIT_ALLOW(String PCPR_EDIT_ALLOW) {
        this.PCPR_EDIT_ALLOW = PCPR_EDIT_ALLOW;
    }

    public String getPCPR_EDIT_ALLOW() {
        return PCPR_EDIT_ALLOW;
    }

    public void setPROV_TYPE(String PROV_TYPE) {
        this.PROV_TYPE = PROV_TYPE;
    }

    public String getPROV_TYPE() {
        return PROV_TYPE;
    }

    public void setPROV_HIV_CLAUSE(String PROV_HIV_CLAUSE) {
        this.PROV_HIV_CLAUSE = PROV_HIV_CLAUSE;
    }

    public String getPROV_HIV_CLAUSE() {
        return PROV_HIV_CLAUSE;
    }

    public void setPROV_HIV_CLAUSE_DESC(String PROV_HIV_CLAUSE_DESC) {
        this.PROV_HIV_CLAUSE_DESC = PROV_HIV_CLAUSE_DESC;
    }

    public String getPROV_HIV_CLAUSE_DESC() {
        return PROV_HIV_CLAUSE_DESC;
    }

    public void setSchClassItem(List<SchoolClassItems> SchClassItem) {
        this.SchClassItem = SchClassItem;
    }

    public List<SchoolClassItems> getSchClassItem() {
        return SchClassItem;
    }

    public void setSCH_CODE(BigDecimal SCH_CODE) {
        this.SCH_CODE = SCH_CODE;
    }

    public BigDecimal getSCH_CODE() {
        return SCH_CODE;
    }

    public void setSCH_SHT_DESC(String SCH_SHT_DESC) {
        this.SCH_SHT_DESC = SCH_SHT_DESC;
    }

    public String getSCH_SHT_DESC() {
        return SCH_SHT_DESC;
    }

    public void setSCH_DESC(String SCH_DESC) {
        this.SCH_DESC = SCH_DESC;
    }

    public String getSCH_DESC() {
        return SCH_DESC;
    }

    public void setSCH_PERIOD(BigDecimal SCH_PERIOD) {
        this.SCH_PERIOD = SCH_PERIOD;
    }

    public BigDecimal getSCH_PERIOD() {
        return SCH_PERIOD;
    }

    public void setSLVL_CODE(BigDecimal SLVL_CODE) {
        this.SLVL_CODE = SLVL_CODE;
    }

    public BigDecimal getSLVL_CODE() {
        return SLVL_CODE;
    }

    public void setSLVL_SHT_DESC(String SLVL_SHT_DESC) {
        this.SLVL_SHT_DESC = SLVL_SHT_DESC;
    }

    public String getSLVL_SHT_DESC() {
        return SLVL_SHT_DESC;
    }

    public void setSLVL_DESC(String SLVL_DESC) {
        this.SLVL_DESC = SLVL_DESC;
    }

    public String getSLVL_DESC() {
        return SLVL_DESC;
    }

    public void setSLVL_PERIOD(String SLVL_PERIOD) {
        this.SLVL_PERIOD = SLVL_PERIOD;
    }

    public String getSLVL_PERIOD() {
        return SLVL_PERIOD;
    }

    public void setSCH_LEVEL(BigDecimal SCH_LEVEL) {
        this.SCH_LEVEL = SCH_LEVEL;
    }

    public BigDecimal getSCH_LEVEL() {
        return SCH_LEVEL;
    }

    public void setTreatyGroupItem(List<TreatyGroupItems> TreatyGroupItem) {
        this.TreatyGroupItem = TreatyGroupItem;
    }

    public List<TreatyGroupItems> getTreatyGroupItem() {
        return TreatyGroupItem;
    }

    public void setSLVL_NO_TERMS(BigDecimal SLVL_NO_TERMS) {
        this.SLVL_NO_TERMS = SLVL_NO_TERMS;
    }

    public BigDecimal getSLVL_NO_TERMS() {
        return SLVL_NO_TERMS;
    }

    public void setSLVL_TERM_DURATION(BigDecimal SLVL_TERM_DURATION) {
        this.SLVL_TERM_DURATION = SLVL_TERM_DURATION;
    }

    public BigDecimal getSLVL_TERM_DURATION() {
        return SLVL_TERM_DURATION;
    }

    public void setPCT_SA_DEPEND_ON_LIMIT(String PCT_SA_DEPEND_ON_LIMIT) {
        this.PCT_SA_DEPEND_ON_LIMIT = PCT_SA_DEPEND_ON_LIMIT;
    }

    public String getPCT_SA_DEPEND_ON_LIMIT() {
        return PCT_SA_DEPEND_ON_LIMIT;
    }

    public void setPCT_SA_DEPEND_ON_LIMIT_DESC(String PCT_SA_DEPEND_ON_LIMIT_DESC) {
        this.PCT_SA_DEPEND_ON_LIMIT_DESC = PCT_SA_DEPEND_ON_LIMIT_DESC;
    }

    public String getPCT_SA_DEPEND_ON_LIMIT_DESC() {
        return PCT_SA_DEPEND_ON_LIMIT_DESC;
    }

    public void setCVT_PAY_BEN(String CVT_PAY_BEN) {
        this.CVT_PAY_BEN = CVT_PAY_BEN;
    }

    public String getCVT_PAY_BEN() {
        return CVT_PAY_BEN;
    }

    public void setCVT_PAY_BEN_DESC(String CVT_PAY_BEN_DESC) {
        this.CVT_PAY_BEN_DESC = CVT_PAY_BEN_DESC;
    }

    public String getCVT_PAY_BEN_DESC() {
        return CVT_PAY_BEN_DESC;
    }

    public void setGPR_SEX(String GPR_SEX) {
        this.GPR_SEX = GPR_SEX;
    }

    public String getGPR_SEX() {
        return GPR_SEX;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSCH_FEES(BigDecimal SCH_FEES) {
        this.SCH_FEES = SCH_FEES;
    }

    public BigDecimal getSCH_FEES() {
        return SCH_FEES;
    }

    public void setSCH_AV_STUDENTS(BigDecimal SCH_AV_STUDENTS) {
        this.SCH_AV_STUDENTS = SCH_AV_STUDENTS;
    }

    public BigDecimal getSCH_AV_STUDENTS() {
        return SCH_AV_STUDENTS;
    }

    public void setLPAG_CODE(BigDecimal LPAG_CODE) {
        this.LPAG_CODE = LPAG_CODE;
    }

    public BigDecimal getLPAG_CODE() {
        return LPAG_CODE;
    }

    public void setLPAG_SHT_DESC(String LPAG_SHT_DESC) {
        this.LPAG_SHT_DESC = LPAG_SHT_DESC;
    }

    public String getLPAG_SHT_DESC() {
        return LPAG_SHT_DESC;
    }

    public void setLPAG_DESC(String LPAG_DESC) {
        this.LPAG_DESC = LPAG_DESC;
    }

    public String getLPAG_DESC() {
        return LPAG_DESC;
    }

    public void setLPAG_TYPE(String LPAG_TYPE) {
        this.LPAG_TYPE = LPAG_TYPE;
    }

    public String getLPAG_TYPE() {
        return LPAG_TYPE;
    }

    public void setPOL_CODE(BigDecimal POL_CODE) {
        this.POL_CODE = POL_CODE;
    }

    public BigDecimal getPOL_CODE() {
        return POL_CODE;
    }

    public void setPOL_POLICY_NO(String POL_POLICY_NO) {
        this.POL_POLICY_NO = POL_POLICY_NO;
    }

    public String getPOL_POLICY_NO() {
        return POL_POLICY_NO;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT = CLIENT;
    }

    public String getCLIENT() {
        return CLIENT;
    }

    public void setBRN_NAME(String BRN_NAME) {
        this.BRN_NAME = BRN_NAME;
    }

    public String getBRN_NAME() {
        return BRN_NAME;
    }

    public void setAGU_CODE(BigDecimal AGU_CODE) {
        this.AGU_CODE = AGU_CODE;
    }

    public BigDecimal getAGU_CODE() {
        return AGU_CODE;
    }

    public void setAGU_LPAG_CODE(BigDecimal AGU_LPAG_CODE) {
        this.AGU_LPAG_CODE = AGU_LPAG_CODE;
    }

    public BigDecimal getAGU_LPAG_CODE() {
        return AGU_LPAG_CODE;
    }

    public void setAGU_USR_CODE(BigDecimal AGU_USR_CODE) {
        this.AGU_USR_CODE = AGU_USR_CODE;
    }

    public BigDecimal getAGU_USR_CODE() {
        return AGU_USR_CODE;
    }

    public void setUSR_USERNAME(String USR_USERNAME) {
        this.USR_USERNAME = USR_USERNAME;
    }

    public String getUSR_USERNAME() {
        return USR_USERNAME;
    }

    public void setUSR_NAME(String USR_NAME) {
        this.USR_NAME = USR_NAME;
    }

    public String getUSR_NAME() {
        return USR_NAME;
    }

    public void setLPIT_TABLE_NAME(String LPIT_TABLE_NAME) {
        this.LPIT_TABLE_NAME = LPIT_TABLE_NAME;
    }

    public String getLPIT_TABLE_NAME() {
        return LPIT_TABLE_NAME;
    }

    public void setTRT_YRS_OF_SERVICE(BigDecimal TRT_YRS_OF_SERVICE) {
        this.TRT_YRS_OF_SERVICE = TRT_YRS_OF_SERVICE;
    }

    public BigDecimal getTRT_YRS_OF_SERVICE() {
        return TRT_YRS_OF_SERVICE;
    }

    public void setTRT_CAUS_CODE(BigDecimal TRT_CAUS_CODE) {
        this.TRT_CAUS_CODE = TRT_CAUS_CODE;
    }

    public BigDecimal getTRT_CAUS_CODE() {
        return TRT_CAUS_CODE;
    }

    public void setCAUS_DESC(String CAUS_DESC) {
        this.CAUS_DESC = CAUS_DESC;
    }

    public String getCAUS_DESC() {
        return CAUS_DESC;
    }

    public void setTRT_YRS_OF_SERVICE_TO(BigDecimal TRT_YRS_OF_SERVICE_TO) {
        this.TRT_YRS_OF_SERVICE_TO = TRT_YRS_OF_SERVICE_TO;
    }

    public BigDecimal getTRT_YRS_OF_SERVICE_TO() {
        return TRT_YRS_OF_SERVICE_TO;
    }

    public void setTRT_YRS_OF_SERVICE_FROM(BigDecimal TRT_YRS_OF_SERVICE_FROM) {
        this.TRT_YRS_OF_SERVICE_FROM = TRT_YRS_OF_SERVICE_FROM;
    }

    public BigDecimal getTRT_YRS_OF_SERVICE_FROM() {
        return TRT_YRS_OF_SERVICE_FROM;
    }

    public void setTRT_APPLICABLE_AT_CAUS(String TRT_APPLICABLE_AT_CAUS) {
        this.TRT_APPLICABLE_AT_CAUS = TRT_APPLICABLE_AT_CAUS;
    }

    public String getTRT_APPLICABLE_AT_CAUS() {
        return TRT_APPLICABLE_AT_CAUS;
    }

   public void setPctItem(List<ProductCoverTypes> PctItem) {
        this.PctItem = PctItem;
    }

    public List<ProductCoverTypes> getPctItem() {
        return PctItem;
    }

    public void setPCT_THIRTEEN_MONTH(String PCT_THIRTEEN_MONTH) {
        this.PCT_THIRTEEN_MONTH = PCT_THIRTEEN_MONTH;
    }

    public String getPCT_THIRTEEN_MONTH() {
        return PCT_THIRTEEN_MONTH;
    }

    public void setTRT_APPLIED_ON(String TRT_APPLIED_ON) {
        this.TRT_APPLIED_ON = TRT_APPLIED_ON;
    }

    public String getTRT_APPLIED_ON() {
        return TRT_APPLIED_ON;
    }

    public void setTRT_APPLIED_ON_DESC(String TRT_APPLIED_ON_DESC) {
        this.TRT_APPLIED_ON_DESC = TRT_APPLIED_ON_DESC;
    }

    public String getTRT_APPLIED_ON_DESC() {
        return TRT_APPLIED_ON_DESC;
    }

    public void setPCT_EM(BigDecimal PCT_EM) {
        this.PCT_EM = PCT_EM;
    }

    public BigDecimal getPCT_EM() {
        return PCT_EM;
    }

    public void setPCT_PROFIT_MARGIN(BigDecimal PCT_PROFIT_MARGIN) {
        this.PCT_PROFIT_MARGIN = PCT_PROFIT_MARGIN;
    }

    public BigDecimal getPCT_PROFIT_MARGIN() {
        return PCT_PROFIT_MARGIN;
    }

    public void setPCT_MNGT_EXPENSES(BigDecimal PCT_MNGT_EXPENSES) {
        this.PCT_MNGT_EXPENSES = PCT_MNGT_EXPENSES;
    }

    public BigDecimal getPCT_MNGT_EXPENSES() {
        return PCT_MNGT_EXPENSES;
    }

    public void setPCT_PHCF(BigDecimal PCT_PHCF) {
        this.PCT_PHCF = PCT_PHCF;
    }

    public BigDecimal getPCT_PHCF() {
        return PCT_PHCF;
    }

    public void setPCT_ADR_RATE(BigDecimal PCT_ADR_RATE) {
        this.PCT_ADR_RATE = PCT_ADR_RATE;
    }

    public BigDecimal getPCT_ADR_RATE() {
        return PCT_ADR_RATE;
    }

    public void setPCT_ADR_RATE_DIV_FACT(BigDecimal PCT_ADR_RATE_DIV_FACT) {
        this.PCT_ADR_RATE_DIV_FACT = PCT_ADR_RATE_DIV_FACT;
    }

    public BigDecimal getPCT_ADR_RATE_DIV_FACT() {
        return PCT_ADR_RATE_DIV_FACT;
    }

    public void setPCT_MED_COST(BigDecimal PCT_MED_COST) {
        this.PCT_MED_COST = PCT_MED_COST;
    }

    public BigDecimal getPCT_MED_COST() {
        return PCT_MED_COST;
    }

    public void setPCT_STAMP_DUTY(BigDecimal PCT_STAMP_DUTY) {
        this.PCT_STAMP_DUTY = PCT_STAMP_DUTY;
    }

    public BigDecimal getPCT_STAMP_DUTY() {
        return PCT_STAMP_DUTY;
    }

    public void setPCT_COMM_RATE(BigDecimal PCT_COMM_RATE) {
        this.PCT_COMM_RATE = PCT_COMM_RATE;
    }

    public BigDecimal getPCT_COMM_RATE() {
        return PCT_COMM_RATE;
    }

    public void setCVT_MAX_INST_NO(BigDecimal CVT_MAX_INST_NO) {
        this.CVT_MAX_INST_NO = CVT_MAX_INST_NO;
    }

    public BigDecimal getCVT_MAX_INST_NO() {
        return CVT_MAX_INST_NO;
    }

    public void setCVT_WAITING_PRD(BigDecimal CVT_WAITING_PRD) {
        this.CVT_WAITING_PRD = CVT_WAITING_PRD;
    }

    public BigDecimal getCVT_WAITING_PRD() {
        return CVT_WAITING_PRD;
    }

    public void setCVT_RETIRE_AGE(BigDecimal CVT_RETIRE_AGE) {
        this.CVT_RETIRE_AGE = CVT_RETIRE_AGE;
    }

    public BigDecimal getCVT_RETIRE_AGE() {
        return CVT_RETIRE_AGE;
    }

    public void setPMAS_RATE_TYPE(String PMAS_RATE_TYPE) {
        this.PMAS_RATE_TYPE = PMAS_RATE_TYPE;
    }

    public String getPMAS_RATE_TYPE() {
        return PMAS_RATE_TYPE;
    }

    public void setCVT_FIXED_SA(String CVT_FIXED_SA) {
        this.CVT_FIXED_SA = CVT_FIXED_SA;
    }

    public String getCVT_FIXED_SA() {
        return CVT_FIXED_SA;
    }

    public void setCVT_FIXED_SA_AMT(BigDecimal CVT_FIXED_SA_AMT) {
        this.CVT_FIXED_SA_AMT = CVT_FIXED_SA_AMT;
    }

    public BigDecimal getCVT_FIXED_SA_AMT() {
        return CVT_FIXED_SA_AMT;
    }

    public void setPCTL_CODE(BigDecimal PCTL_CODE) {
        this.PCTL_CODE = PCTL_CODE;
    }

    public BigDecimal getPCTL_CODE() {
        return PCTL_CODE;
    }

    public void setPCTL_NAME(String PCTL_NAME) {
        this.PCTL_NAME = PCTL_NAME;
    }

    public String getPCTL_NAME() {
        return PCTL_NAME;
    }

    public void setGLR_ANB_FROM(BigDecimal GLR_ANB_FROM) {
        this.GLR_ANB_FROM = GLR_ANB_FROM;
    }

    public BigDecimal getGLR_ANB_FROM() {
        return GLR_ANB_FROM;
    }

    public void setGLR_ANB_TO(BigDecimal GLR_ANB_TO) {
        this.GLR_ANB_TO = GLR_ANB_TO;
    }

    public BigDecimal getGLR_ANB_TO() {
        return GLR_ANB_TO;
    }

    public void setGLR_CLASS(BigDecimal GLR_CLASS) {
        this.GLR_CLASS = GLR_CLASS;
    }

    public BigDecimal getGLR_CLASS() {
        return GLR_CLASS;
    }

    public void setGLR_RANGE_FROM(BigDecimal GLR_RANGE_FROM) {
        this.GLR_RANGE_FROM = GLR_RANGE_FROM;
    }

    public BigDecimal getGLR_RANGE_FROM() {
        return GLR_RANGE_FROM;
    }

    public void setGLR_RANGE_TO(BigDecimal GLR_RANGE_TO) {
        this.GLR_RANGE_TO = GLR_RANGE_TO;
    }

    public BigDecimal getGLR_RANGE_TO() {
        return GLR_RANGE_TO;
    }

    public void setGLR_RATE(BigDecimal GLR_RATE) {
        this.GLR_RATE = GLR_RATE;
    }

    public BigDecimal getGLR_RATE() {
        return GLR_RATE;
    }

    public void setGLR_DIV_FACT(BigDecimal GLR_DIV_FACT) {
        this.GLR_DIV_FACT = GLR_DIV_FACT;
    }

    public BigDecimal getGLR_DIV_FACT() {
        return GLR_DIV_FACT;
    }

    public void setGLR_SEX(String GLR_SEX) {
        this.GLR_SEX = GLR_SEX;
    }

    public String getGLR_SEX() {
        return GLR_SEX;
    }

    public void setGLR_WEF(Date GLR_WEF) {
        this.GLR_WEF = GLR_WEF;
    }

    public Date getGLR_WEF() {
        return GLR_WEF;
    }

    public void setGLR_WET(Date GLR_WET) {
        this.GLR_WET = GLR_WET;
    }

    public Date getGLR_WET() {
        return GLR_WET;
    }

    public void setGOC_CODE(BigDecimal GOC_CODE) {
        this.GOC_CODE = GOC_CODE;
    }

    public BigDecimal getGOC_CODE() {
        return GOC_CODE;
    }

    public void setGOC_CLASS(BigDecimal GOC_CLASS) {
        this.GOC_CLASS = GOC_CLASS;
    }

    public BigDecimal getGOC_CLASS() {
        return GOC_CLASS;
    }

    public void setGOC_CATEGORY(String GOC_CATEGORY) {
        this.GOC_CATEGORY = GOC_CATEGORY;
    }

    public String getGOC_CATEGORY() {
        return GOC_CATEGORY;
    }

    public void setProvl_code(BigDecimal provl_code) {
        this.provl_code = provl_code;
    }

    public BigDecimal getProvl_code() {
        return provl_code;
    }

    public void setProvl_from(BigDecimal provl_from) {
        this.provl_from = provl_from;
    }

    public BigDecimal getProvl_from() {
        return provl_from;
    }

    public void setProvl_to(BigDecimal provl_to) {
        this.provl_to = provl_to;
    }

    public BigDecimal getProvl_to() {
        return provl_to;
    }

    public void setProvl_perc_payable(BigDecimal provl_perc_payable) {
        this.provl_perc_payable = provl_perc_payable;
    }

    public BigDecimal getProvl_perc_payable() {
        return provl_perc_payable;
    }

    public void setProvl_waiting_prd(BigDecimal provl_waiting_prd) {
        this.provl_waiting_prd = provl_waiting_prd;
    }

    public BigDecimal getProvl_waiting_prd() {
        return provl_waiting_prd;
    }

    public void setPprov_code(BigDecimal pprov_code) {
        this.pprov_code = pprov_code;
    }

    public BigDecimal getPprov_code() {
        return pprov_code;
    }

    public void setPprov_default(String pprov_default) {
        this.pprov_default = pprov_default;
    }

    public String getPprov_default() {
        return pprov_default;
    }

    public void setPprov_editable(String pprov_editable) {
        this.pprov_editable = pprov_editable;
    }

    public String getPprov_editable() {
        return pprov_editable;
    }

    public void setPprov_auto_populate(String pprov_auto_populate) {
        this.pprov_auto_populate = pprov_auto_populate;
    }

    public String getPprov_auto_populate() {
        return pprov_auto_populate;
    }

    public void setProv_desc(String prov_desc) {
        this.prov_desc = prov_desc;
    }

    public String getProv_desc() {
        return prov_desc;
    }

    public void setCur_code(BigDecimal cur_code) {
        this.cur_code = cur_code;
    }

    public BigDecimal getCur_code() {
        return cur_code;
    }

    public void setCur_symbol(String cur_symbol) {
        this.cur_symbol = cur_symbol;
    }

    public String getCur_symbol() {
        return cur_symbol;
    }
    public void setCur_desc(String cur_desc) {
        this.cur_desc = cur_desc;
    }

    public String getCur_desc() {
        return cur_desc;
    }

    public void setCratCode(BigDecimal cratCode) {
        this.cratCode = cratCode;
    }

    public BigDecimal getCratCode() {
        return cratCode;
    }

    public void setCratRate(BigDecimal cratRate) {
        this.cratRate = cratRate;
    }

    public BigDecimal getCratRate() {
        return cratRate;
    }

    public void setCratRateDesc(String cratRateDesc) {
        this.cratRateDesc = cratRateDesc;
    }

    public String getCratRateDesc() {
        return cratRateDesc;
    }

    public void setCratWefDate(Date cratWefDate) {
        this.cratWefDate = cratWefDate;
    }

    public Date getCratWefDate() {
        return cratWefDate;
    }

    public void setCratWetDate(Date cratWetDate) {
        this.cratWetDate = cratWetDate;
    }

    public Date getCratWetDate() {
        return cratWetDate;
    }

    public void setCratAtCode(BigDecimal cratAtCode) {
        this.cratAtCode = cratAtCode;
    }

    public BigDecimal getCratAtCode() {
        return cratAtCode;
    }

    public void setCratAtShortDesc(String cratAtShortDesc) {
        this.cratAtShortDesc = cratAtShortDesc;
    }

    public String getCratAtShortDesc() {
        return cratAtShortDesc;
    }

    public void setCratDivFactor(BigDecimal cratDivFactor) {
        this.cratDivFactor = cratDivFactor;
    }

    public BigDecimal getCratDivFactor() {
        return cratDivFactor;
    }

    public void setCratRateType(String cratRateType) {
        this.cratRateType = cratRateType;
    }

    public String getCratRateType() {
        return cratRateType;
    }

    public void setCratRangeFrom(BigDecimal cratRangeFrom) {
        this.cratRangeFrom = cratRangeFrom;
    }

    public BigDecimal getCratRangeFrom() {
        return cratRangeFrom;
    }

    public void setCratRangeTo(BigDecimal cratRangeTo) {
        this.cratRangeTo = cratRangeTo;
    }

    public BigDecimal getCratRangeTo() {
        return cratRangeTo;
    }

    public void setCratProdCode(BigDecimal cratProdCode) {
        this.cratProdCode = cratProdCode;
    }

    public BigDecimal getCratProdCode() {
        return cratProdCode;
    }

    public void setCratYrNoFrom(BigDecimal cratYrNoFrom) {
        this.cratYrNoFrom = cratYrNoFrom;
    }

    public BigDecimal getCratYrNoFrom() {
        return cratYrNoFrom;
    }

    public void setCratYrNoTo(BigDecimal cratYrNoTo) {
        this.cratYrNoTo = cratYrNoTo;
    }

    public BigDecimal getCratYrNoTo() {
        return cratYrNoTo;
    }

    public void setCratTermFrom(BigDecimal cratTermFrom) {
        this.cratTermFrom = cratTermFrom;
    }

    public BigDecimal getCratTermFrom() {
        return cratTermFrom;
    }

    public void setCratTermTo(BigDecimal cratTermTo) {
        this.cratTermTo = cratTermTo;
    }

    public BigDecimal getCratTermTo() {
        return cratTermTo;
    }

    public void setCratPayFreq(String cratPayFreq) {
        this.cratPayFreq = cratPayFreq;
    }

    public String getCratPayFreq() {
        return cratPayFreq;
    }

    public void setCratPctCode(BigDecimal cratPctCode) {
        this.cratPctCode = cratPctCode;
    }

    public BigDecimal getCratPctCode() {
        return cratPctCode;
    }

    public void setCratAtrCode(BigDecimal cratAtrCode) {
        this.cratAtrCode = cratAtrCode;
    }

    public BigDecimal getCratAtrCode() {
        return cratAtrCode;
    }

    public void setCratAnbFrom(BigDecimal cratAnbFrom) {
        this.cratAnbFrom = cratAnbFrom;
    }

    public BigDecimal getCratAnbFrom() {
        return cratAnbFrom;
    }

    public void setCratAnbTo(BigDecimal cratAnbTo) {
        this.cratAnbTo = cratAnbTo;
    }

    public BigDecimal getCratAnbTo() {
        return cratAnbTo;
    }

    public void setCratMaturityAge(BigDecimal cratMaturityAge) {
        this.cratMaturityAge = cratMaturityAge;
    }

    public BigDecimal getCratMaturityAge() {
        return cratMaturityAge;
    }

    public void setCratAppliedOn(String cratAppliedOn) {
        this.cratAppliedOn = cratAppliedOn;
    }

    public String getCratAppliedOn() {
        return cratAppliedOn;
    }

    public void setProductCode(BigDecimal productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getProductCode() {
        return productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setOocrCode(BigDecimal oocrCode) {
        this.oocrCode = oocrCode;
    }

    public BigDecimal getOocrCode() {
        return oocrCode;
    }

    public void setOocrRate(BigDecimal oocrRate) {
        this.oocrRate = oocrRate;
    }

    public BigDecimal getOocrRate() {
        return oocrRate;
    }

    public void setOocrRateDesc(String oocrRateDesc) {
        this.oocrRateDesc = oocrRateDesc;
    }

    public String getOocrRateDesc() {
        return oocrRateDesc;
    }

    public void setOocrDivFactor(BigDecimal oocrDivFactor) {
        this.oocrDivFactor = oocrDivFactor;
    }

    public BigDecimal getOocrDivFactor() {
        return oocrDivFactor;
    }

    public void setOocrAtCode(BigDecimal oocrAtCode) {
        this.oocrAtCode = oocrAtCode;
    }

    public BigDecimal getOocrAtCode() {
        return oocrAtCode;
    }

    public void setOocrApplAtCode(BigDecimal oocrApplAtCode) {
        this.oocrApplAtCode = oocrApplAtCode;
    }

    public BigDecimal getOocrApplAtCode() {
        return oocrApplAtCode;
    }

    public void setOocrYrNoFrom(BigDecimal oocrYrNoFrom) {
        this.oocrYrNoFrom = oocrYrNoFrom;
    }

    public BigDecimal getOocrYrNoFrom() {
        return oocrYrNoFrom;
    }

    public void setOocrYrNoTo(BigDecimal oocrYrNoTo) {
        this.oocrYrNoTo = oocrYrNoTo;
    }

    public BigDecimal getOocrYrNoTo() {
        return oocrYrNoTo;
    }

    public void setOocrClaCode(BigDecimal oocrClaCode) {
        this.oocrClaCode = oocrClaCode;
    }

    public BigDecimal getOocrClaCode() {
        return oocrClaCode;
    }

    public void setOocrWefDate(Date oocrWefDate) {
        this.oocrWefDate = oocrWefDate;
    }

    public Date getOocrWefDate() {
        return oocrWefDate;
    }

    public void setOocrWetDate(Date oocrWetDate) {
        this.oocrWetDate = oocrWetDate;
    }

    public Date getOocrWetDate() {
        return oocrWetDate;
    }

    public void setOocrApplAtName(String oocrApplAtName) {
        this.oocrApplAtName = oocrApplAtName;
    }

    public String getOocrApplAtName() {
        return oocrApplAtName;
    }

    public void setBtsCode(BigDecimal btsCode) {
        this.btsCode = btsCode;
    }

    public BigDecimal getBtsCode() {
        return btsCode;
    }

    public void setBtsUwYr(BigDecimal btsUwYr) {
        this.btsUwYr = btsUwYr;
    }

    public BigDecimal getBtsUwYr() {
        return btsUwYr;
    }

    public void setBtsName(String btsName) {
        this.btsName = btsName;
    }

    public String getBtsName() {
        return btsName;
    }

    public void setBtsDesc(String btsDesc) {
        this.btsDesc = btsDesc;
    }

    public String getBtsDesc() {
        return btsDesc;
    }

    public void setBtsPolEffDate(Date btsPolEffDate) {
        this.btsPolEffDate = btsPolEffDate;
    }

    public Date getBtsPolEffDate() {
        return btsPolEffDate;
    }

    public void setPbgtJanRenAmt(BigDecimal pbgtJanRenAmt) {
        this.pbgtJanRenAmt = pbgtJanRenAmt;
    }

    public BigDecimal getPbgtJanRenAmt() {
        return pbgtJanRenAmt;
    }

    public void setPbgtFebRenAmt(BigDecimal pbgtFebRenAmt) {
        this.pbgtFebRenAmt = pbgtFebRenAmt;
    }

    public BigDecimal getPbgtFebRenAmt() {
        return pbgtFebRenAmt;
    }

    public void setPbgtMarRenAmt(BigDecimal pbgtMarRenAmt) {
        this.pbgtMarRenAmt = pbgtMarRenAmt;
    }

    public BigDecimal getPbgtMarRenAmt() {
        return pbgtMarRenAmt;
    }

    public void setPbgtAprRenAmt(BigDecimal pbgtAprRenAmt) {
        this.pbgtAprRenAmt = pbgtAprRenAmt;
    }

    public BigDecimal getPbgtAprRenAmt() {
        return pbgtAprRenAmt;
    }

    public void setPbgtMayRenAmt(BigDecimal pbgtMayRenAmt) {
        this.pbgtMayRenAmt = pbgtMayRenAmt;
    }

    public BigDecimal getPbgtMayRenAmt() {
        return pbgtMayRenAmt;
    }

    public void setPbgtJunRenAmt(BigDecimal pbgtJunRenAmt) {
        this.pbgtJunRenAmt = pbgtJunRenAmt;
    }

    public BigDecimal getPbgtJunRenAmt() {
        return pbgtJunRenAmt;
    }

    public void setPbgtJulRenAmt(BigDecimal pbgtJulRenAmt) {
        this.pbgtJulRenAmt = pbgtJulRenAmt;
    }

    public BigDecimal getPbgtJulRenAmt() {
        return pbgtJulRenAmt;
    }

    public void setPbgtAugRenAmt(BigDecimal pbgtAugRenAmt) {
        this.pbgtAugRenAmt = pbgtAugRenAmt;
    }

    public BigDecimal getPbgtAugRenAmt() {
        return pbgtAugRenAmt;
    }

    public void setPbgtSepRenAmt(BigDecimal pbgtSepRenAmt) {
        this.pbgtSepRenAmt = pbgtSepRenAmt;
    }

    public BigDecimal getPbgtSepRenAmt() {
        return pbgtSepRenAmt;
    }

    public void setPbgtOctRenAmt(BigDecimal pbgtOctRenAmt) {
        this.pbgtOctRenAmt = pbgtOctRenAmt;
    }

    public BigDecimal getPbgtOctRenAmt() {
        return pbgtOctRenAmt;
    }

    public void setPbgtNovRenAmt(BigDecimal pbgtNovRenAmt) {
        this.pbgtNovRenAmt = pbgtNovRenAmt;
    }

    public BigDecimal getPbgtNovRenAmt() {
        return pbgtNovRenAmt;
    }

    public void setPbgtDecRenAmt(BigDecimal pbgtDecRenAmt) {
        this.pbgtDecRenAmt = pbgtDecRenAmt;
    }

    public BigDecimal getPbgtDecRenAmt() {
        return pbgtDecRenAmt;
    }

    public void setPbgtJanNBAmt(BigDecimal pbgtJanNBAmt) {
        this.pbgtJanNBAmt = pbgtJanNBAmt;
    }

    public BigDecimal getPbgtJanNBAmt() {
        return pbgtJanNBAmt;
    }

    public void setPbgtFebNBAmt(BigDecimal pbgtFebNBAmt) {
        this.pbgtFebNBAmt = pbgtFebNBAmt;
    }

    public BigDecimal getPbgtFebNBAmt() {
        return pbgtFebNBAmt;
    }

    public void setPbgtMarNBAmt(BigDecimal pbgtMarNBAmt) {
        this.pbgtMarNBAmt = pbgtMarNBAmt;
    }

    public BigDecimal getPbgtMarNBAmt() {
        return pbgtMarNBAmt;
    }

    public void setPbgtAprNBAmt(BigDecimal pbgtAprNBAmt) {
        this.pbgtAprNBAmt = pbgtAprNBAmt;
    }

    public BigDecimal getPbgtAprNBAmt() {
        return pbgtAprNBAmt;
    }

    public void setPbgtMayNBAmt(BigDecimal pbgtMayNBAmt) {
        this.pbgtMayNBAmt = pbgtMayNBAmt;
    }

    public BigDecimal getPbgtMayNBAmt() {
        return pbgtMayNBAmt;
    }

    public void setPbgtJunNBAmt(BigDecimal pbgtJunNBAmt) {
        this.pbgtJunNBAmt = pbgtJunNBAmt;
    }

    public BigDecimal getPbgtJunNBAmt() {
        return pbgtJunNBAmt;
    }

    public void setPbgtJulNBAmt(BigDecimal pbgtJulNBAmt) {
        this.pbgtJulNBAmt = pbgtJulNBAmt;
    }

    public BigDecimal getPbgtJulNBAmt() {
        return pbgtJulNBAmt;
    }

    public void setPbgtAugNBAmt(BigDecimal pbgtAugNBAmt) {
        this.pbgtAugNBAmt = pbgtAugNBAmt;
    }

    public BigDecimal getPbgtAugNBAmt() {
        return pbgtAugNBAmt;
    }

    public void setPbgtSepNBAmt(BigDecimal pbgtSepNBAmt) {
        this.pbgtSepNBAmt = pbgtSepNBAmt;
    }

    public BigDecimal getPbgtSepNBAmt() {
        return pbgtSepNBAmt;
    }

    public void setPbgtOctNBAmt(BigDecimal pbgtOctNBAmt) {
        this.pbgtOctNBAmt = pbgtOctNBAmt;
    }

    public BigDecimal getPbgtOctNBAmt() {
        return pbgtOctNBAmt;
    }

    public void setPbgtNovNBAmt(BigDecimal pbgtNovNBAmt) {
        this.pbgtNovNBAmt = pbgtNovNBAmt;
    }

    public BigDecimal getPbgtNovNBAmt() {
        return pbgtNovNBAmt;
    }

    public void setPbgtDecNBAmt(BigDecimal pbgtDecNBAmt) {
        this.pbgtDecNBAmt = pbgtDecNBAmt;
    }

    public BigDecimal getPbgtDecNBAmt() {
        return pbgtDecNBAmt;
    }

    public void setPbgtCode(BigDecimal pbgtCode) {
        this.pbgtCode = pbgtCode;
    }

    public BigDecimal getPbgtCode() {
        return pbgtCode;
    }

    public void setGcoDesc(String gcoDesc) {
        this.gcoDesc = gcoDesc;
    }

    public String getGcoDesc() {
        return gcoDesc;
    }

    public void setGocCategory(String gocCategory) {
        this.gocCategory = gocCategory;
    }

    public String getGocCategory() {
        return gocCategory;
    }

    public void setGocClass(BigDecimal gocClass) {
        this.gocClass = gocClass;
    }

    public BigDecimal getGocClass() {
        return gocClass;
    }

    public void setGcoShtDesc(String gcoShtDesc) {
        this.gcoShtDesc = gcoShtDesc;
    }

    public String getGcoShtDesc() {
        return gcoShtDesc;
    }

    public void setPplCode(BigDecimal pplCode) {
        this.pplCode = pplCode;
    }

    public BigDecimal getPplCode() {
        return pplCode;
    }

    public void setPplDesc(String pplDesc) {
        this.pplDesc = pplDesc;
    }

    public String getPplDesc() {
        return pplDesc;
    }

    public void setLST_TEXT(String LST_TEXT) {
        this.LST_TEXT = LST_TEXT;
    }

    public String getLST_TEXT() {
        return LST_TEXT;
    }

    public void setCVT_NOTIFICATION_PRD(BigDecimal CVT_NOTIFICATION_PRD) {
        this.CVT_NOTIFICATION_PRD = CVT_NOTIFICATION_PRD;
    }

    public BigDecimal getCVT_NOTIFICATION_PRD() {
        return CVT_NOTIFICATION_PRD;
    }
    
    public void setPROD_COMM_CVR_PARAM(String PROD_COMM_CVR_PARAM) {
        this.PROD_COMM_CVR_PARAM = PROD_COMM_CVR_PARAM;
    }

    public String getPROD_COMM_CVR_PARAM() {
        return PROD_COMM_CVR_PARAM;
    }
    
    public void setLPP_CODE(BigDecimal LPP_CODE) {
        this.LPP_CODE = LPP_CODE;
    }

    public BigDecimal getLPP_CODE() {
        return LPP_CODE;
    }
    
    public void setLPP_NAME(String LPP_NAME) {
        this.LPP_NAME = LPP_NAME;
    }

    public String getLPP_NAME() {
        return LPP_NAME;
    }
    
    public void setLPP_VALUE(String LPP_VALUE) {
        this.LPP_VALUE = LPP_VALUE;
    }

    public String getLPP_VALUE() {
        return LPP_VALUE;
    }

    public void setExciseDuty(String exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    public String getExciseDuty() {
        return exciseDuty;
    }
}

