package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class ProductSetup {
    public ProductSetup() {
        super();
    }
    private BigDecimal PROD_CODE, PROD_QUO_EXPIRY_PRD;
    private String PROD_SHT_DESC, PROD_PENS_CONTRI_LIMIT;
    private BigDecimal PROD_MIN_AGE_LIMIT_YRS,PROD_MIN_TERM_YRS;
    private String PROD_POL_CODE_FIX;
    private BigDecimal PROD_REIN_MAX_PRD_DAYS,PROD_SCH_ADJ_PERIOD,PROD_MAX_EXT_PERIOD;
    private Date PROD_DEFAULT_DOB,PROD_WEF;
    private String PROD_DEPENDT_COVERED,PROD_DEBIT_ACC_NO,PROD_EXPECTED_SCH_RECPT_DAY,PROD_EXTENTION_ALLOWED,
           PROD_GL_CONTROL_CODE,PROD_LOAN_GRACE_PRD,PROD_DESC,PROD_PAY_GRATUITY,PROD_ANNUITY_ALLOWED,PROD_PROP_CODE_FIX,
            PROD_LOAN_PRODUCT,PROD_REFUND_COMM,PROD_UNIT_RATE_APPLICABLE,PROD_GEN_POL_NO,PROD_RENEWAL_ALLOWED, PROD_FMS_RECEIPTING;
    private BigDecimal PROD_PROFIT_SHARE_RATE_PERC,PROD_ADD_REF_PREM_PERC,PROD_MAX_AGE_LIMIT_YRS;
    private String   PROD_CLM_CODE_FIX,PROD_CANC_NOTICE_DAYS,PROD_SAVINGS_COVERED,PROD_REFUND_ALLOWED,
            PROD_PARTIAL_CANCEL_ALLOWED,PROD_APPLICABLE_LAPSE_TYPE;
    private BigDecimal PROD_CLAIM_EXPIRY_PRD,PROD_EMP_FUND_PAY_PRD,PROD_MINIMUM_FCL_MEMBERS,PROD_FCL_FACTOR1,PROD_FCL_FACTOR2,PROD_GRP_RATES_MIN,PROD_MAX_TERM_YRS,PROD_MIN_EARNINGS_PRD,PROD_FCL_MAX_AMT;
    private String PROD_TYPE,PROD_OPEN_COVER,PROD_XOL_SETUP,PROD_OS_LOAN_CALC,PROD_INITIAL_SCH_ENDRSE,PROD_REMARKS,PROD_EMV_CALCULATION_TYPE,PROD_VAL_INTR_CALC_MODE,PROD_STATUS,weeklyIndemnity;

//death acceptable no
    private BigDecimal PDA_CODE;
    private BigDecimal PDA_GRP_TOT_NO;
    private BigDecimal LMS_PROD_DEATH_ACCEPTABLE;
    
   private String PROD_EARNING_PRD_TYPE, PROD_FCL_CALC_TYPE, PROD_PENS_TYPE, PROD_LOAN_GUARD, PROD_FCL_SA_FORMULA;
    
//premium fractions
    private BigDecimal PROD_MNTH_TO_QTR_FCTOR,PROD_MNTH_TO_S_ANNL_FCTOR,PROD_MNTH_TO_ANNL_FCTOR,PROD_YR_TO_MONTH_RATE,
        PROD_YR_TO_S_ANNL_RATE,PROD_YR_TO_QUATER_RATE;
    
//schedule reports
private String PROD_QUO_COSTING_SCH_RPT,PROD_QUO_SAVINGS_SCH_RPT,PROD_QUO_FE_SCH_RPT,PROD_QUO_AGGR_DTLS_RPT,
        PROD_UW_COSTING_SCH_RPT,PROD_UW_SAVING_SCH_RPT,PROD_UW_FE_SCH_RPT,PROD_UW_REFUND_SCH_RPT,PROD_POL_COSTING_SCH_RPT,
    PROD_POL_SAVING_SCH_RPT,
        PROD_POL_FE_SCH_RPT,PROD_REN_COSTING_SCH_RPT,PROD_REN_SAVING_SCH_RPT,PROD_REN_FE_SCH_RPT,PROD_QUO_AGGR_LETT;

//lapsation
private String PROD_MONTHLY_LAPSE_PRD,PROD_QUARTER_LAPSE_PRD,PROD_SEMI_A_LAPSE_PRD,PROD_ANNUALLY_LAPSE_PRD,
        PROD_LAPSE_PRD_DAYS;

//standard policy documents
private BigDecimal PSPD_CODE;
private String PSPD_TYPE,PSPD_DOC_NAME,PSPD_TYPE_DESC;
private String PROD_RATE_TYPE;
private BigDecimal PROD_MED_GRACE_PERIOD;

//exceptions definitions
private String PROD_EXC_NOT_AGE,PROD_EXC_NOT_SA;
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

    public void setPROD_MIN_AGE_LIMIT_YRS(BigDecimal PROD_MIN_AGE_LIMIT_YRS) {
        this.PROD_MIN_AGE_LIMIT_YRS = PROD_MIN_AGE_LIMIT_YRS;
    }

    public BigDecimal getPROD_MIN_AGE_LIMIT_YRS() {
        return PROD_MIN_AGE_LIMIT_YRS;
    }

    public void setPROD_MIN_TERM_YRS(BigDecimal PROD_MIN_TERM_YRS) {
        this.PROD_MIN_TERM_YRS = PROD_MIN_TERM_YRS;
    }

    public BigDecimal getPROD_MIN_TERM_YRS() {
        return PROD_MIN_TERM_YRS;
    }

    public void setPROD_POL_CODE_FIX(String PROD_POL_CODE_FIX) {
        this.PROD_POL_CODE_FIX = PROD_POL_CODE_FIX;
    }

    public String getPROD_POL_CODE_FIX() {
        return PROD_POL_CODE_FIX;
    }

    public void setPROD_REIN_MAX_PRD_DAYS(BigDecimal PROD_REIN_MAX_PRD_DAYS) {
        this.PROD_REIN_MAX_PRD_DAYS = PROD_REIN_MAX_PRD_DAYS;
    }

    public BigDecimal getPROD_REIN_MAX_PRD_DAYS() {
        return PROD_REIN_MAX_PRD_DAYS;
    }

    public void setPROD_SCH_ADJ_PERIOD(BigDecimal PROD_SCH_ADJ_PERIOD) {
        this.PROD_SCH_ADJ_PERIOD = PROD_SCH_ADJ_PERIOD;
    }

    public BigDecimal getPROD_SCH_ADJ_PERIOD() {
        return PROD_SCH_ADJ_PERIOD;
    }

    public void setPROD_MAX_EXT_PERIOD(BigDecimal PROD_MAX_EXT_PERIOD) {
        this.PROD_MAX_EXT_PERIOD = PROD_MAX_EXT_PERIOD;
    }

    public BigDecimal getPROD_MAX_EXT_PERIOD() {
        return PROD_MAX_EXT_PERIOD;
    }

    public void setPROD_DEFAULT_DOB(Date PROD_DEFAULT_DOB) {
        this.PROD_DEFAULT_DOB = PROD_DEFAULT_DOB;
    }

    public Date getPROD_DEFAULT_DOB() {
        return PROD_DEFAULT_DOB;
    }

    public void setPROD_DEPENDT_COVERED(String PROD_DEPENDT_COVERED) {
        this.PROD_DEPENDT_COVERED = PROD_DEPENDT_COVERED;
    }

    public String getPROD_DEPENDT_COVERED() {
        return PROD_DEPENDT_COVERED;
    }

    public void setPROD_DEBIT_ACC_NO(String PROD_DEBIT_ACC_NO) {
        this.PROD_DEBIT_ACC_NO = PROD_DEBIT_ACC_NO;
    }

    public String getPROD_DEBIT_ACC_NO() {
        return PROD_DEBIT_ACC_NO;
    }

    public void setPROD_EXPECTED_SCH_RECPT_DAY(String PROD_EXPECTED_SCH_RECPT_DAY) {
        this.PROD_EXPECTED_SCH_RECPT_DAY = PROD_EXPECTED_SCH_RECPT_DAY;
    }

    public String getPROD_EXPECTED_SCH_RECPT_DAY() {
        return PROD_EXPECTED_SCH_RECPT_DAY;
    }

    public void setPROD_EXTENTION_ALLOWED(String PROD_EXTENTION_ALLOWED) {
        this.PROD_EXTENTION_ALLOWED = PROD_EXTENTION_ALLOWED;
    }

    public String getPROD_EXTENTION_ALLOWED() {
        return PROD_EXTENTION_ALLOWED;
    }

    public void setPROD_GL_CONTROL_CODE(String PROD_GL_CONTROL_CODE) {
        this.PROD_GL_CONTROL_CODE = PROD_GL_CONTROL_CODE;
    }

    public String getPROD_GL_CONTROL_CODE() {
        return PROD_GL_CONTROL_CODE;
    }

    public void setPROD_LOAN_GRACE_PRD(String PROD_LOAN_GRACE_PRD) {
        this.PROD_LOAN_GRACE_PRD = PROD_LOAN_GRACE_PRD;
    }

    public String getPROD_LOAN_GRACE_PRD() {
        return PROD_LOAN_GRACE_PRD;
    }

    public void setPROD_DESC(String PROD_DESC) {
        this.PROD_DESC = PROD_DESC;
    }

    public String getPROD_DESC() {
        return PROD_DESC;
    }

    public void setPROD_PAY_GRATUITY(String PROD_PAY_GRATUITY) {
        this.PROD_PAY_GRATUITY = PROD_PAY_GRATUITY;
    }

    public String getPROD_PAY_GRATUITY() {
        return PROD_PAY_GRATUITY;
    }

    public void setPROD_ANNUITY_ALLOWED(String PROD_ANNUITY_ALLOWED) {
        this.PROD_ANNUITY_ALLOWED = PROD_ANNUITY_ALLOWED;
    }

    public String getPROD_ANNUITY_ALLOWED() {
        return PROD_ANNUITY_ALLOWED;
    }

    public void setPROD_PROP_CODE_FIX(String PROD_PROP_CODE_FIX) {
        this.PROD_PROP_CODE_FIX = PROD_PROP_CODE_FIX;
    }

    public String getPROD_PROP_CODE_FIX() {
        return PROD_PROP_CODE_FIX;
    }

    public void setPROD_LOAN_PRODUCT(String PROD_LOAN_PRODUCT) {
        this.PROD_LOAN_PRODUCT = PROD_LOAN_PRODUCT;
    }

    public String getPROD_LOAN_PRODUCT() {
        return PROD_LOAN_PRODUCT;
    }

    public void setPROD_REFUND_COMM(String PROD_REFUND_COMM) {
        this.PROD_REFUND_COMM = PROD_REFUND_COMM;
    }

    public String getPROD_REFUND_COMM() {
        return PROD_REFUND_COMM;
    }

    public void setPROD_UNIT_RATE_APPLICABLE(String PROD_UNIT_RATE_APPLICABLE) {
        this.PROD_UNIT_RATE_APPLICABLE = PROD_UNIT_RATE_APPLICABLE;
    }

    public String getPROD_UNIT_RATE_APPLICABLE() {
        return PROD_UNIT_RATE_APPLICABLE;
    }

    public void setPROD_GEN_POL_NO(String PROD_GEN_POL_NO) {
        this.PROD_GEN_POL_NO = PROD_GEN_POL_NO;
    }

    public String getPROD_GEN_POL_NO() {
        return PROD_GEN_POL_NO;
    }

    public void setPROD_RENEWAL_ALLOWED(String PROD_RENEWAL_ALLOWED) {
        this.PROD_RENEWAL_ALLOWED = PROD_RENEWAL_ALLOWED;
    }

    public String getPROD_RENEWAL_ALLOWED() {
        return PROD_RENEWAL_ALLOWED;
    }

    public void setPROD_PROFIT_SHARE_RATE_PERC(BigDecimal PROD_PROFIT_SHARE_RATE_PERC) {
        this.PROD_PROFIT_SHARE_RATE_PERC = PROD_PROFIT_SHARE_RATE_PERC;
    }

    public BigDecimal getPROD_PROFIT_SHARE_RATE_PERC() {
        return PROD_PROFIT_SHARE_RATE_PERC;
    }

    public void setPROD_ADD_REF_PREM_PERC(BigDecimal PROD_ADD_REF_PREM_PERC) {
        this.PROD_ADD_REF_PREM_PERC = PROD_ADD_REF_PREM_PERC;
    }

    public BigDecimal getPROD_ADD_REF_PREM_PERC() {
        return PROD_ADD_REF_PREM_PERC;
    }

    public void setPROD_MAX_AGE_LIMIT_YRS(BigDecimal PROD_MAX_AGE_LIMIT_YRS) {
        this.PROD_MAX_AGE_LIMIT_YRS = PROD_MAX_AGE_LIMIT_YRS;
    }

    public BigDecimal getPROD_MAX_AGE_LIMIT_YRS() {
        return PROD_MAX_AGE_LIMIT_YRS;
    }

    public void setPROD_CLM_CODE_FIX(String PROD_CLM_CODE_FIX) {
        this.PROD_CLM_CODE_FIX = PROD_CLM_CODE_FIX;
    }

    public String getPROD_CLM_CODE_FIX() {
        return PROD_CLM_CODE_FIX;
    }

    public void setPROD_CANC_NOTICE_DAYS(String PROD_CANC_NOTICE_DAYS) {
        this.PROD_CANC_NOTICE_DAYS = PROD_CANC_NOTICE_DAYS;
    }

    public String getPROD_CANC_NOTICE_DAYS() {
        return PROD_CANC_NOTICE_DAYS;
    }

    public void setPROD_SAVINGS_COVERED(String PROD_SAVINGS_COVERED) {
        this.PROD_SAVINGS_COVERED = PROD_SAVINGS_COVERED;
    }

    public String getPROD_SAVINGS_COVERED() {
        return PROD_SAVINGS_COVERED;
    }

    public void setPROD_REFUND_ALLOWED(String PROD_REFUND_ALLOWED) {
        this.PROD_REFUND_ALLOWED = PROD_REFUND_ALLOWED;
    }

    public String getPROD_REFUND_ALLOWED() {
        return PROD_REFUND_ALLOWED;
    }

    public void setPROD_PARTIAL_CANCEL_ALLOWED(String PROD_PARTIAL_CANCEL_ALLOWED) {
        this.PROD_PARTIAL_CANCEL_ALLOWED = PROD_PARTIAL_CANCEL_ALLOWED;
    }

    public String getPROD_PARTIAL_CANCEL_ALLOWED() {
        return PROD_PARTIAL_CANCEL_ALLOWED;
    }

    public void setPROD_APPLICABLE_LAPSE_TYPE(String PROD_APPLICABLE_LAPSE_TYPE) {
        this.PROD_APPLICABLE_LAPSE_TYPE = PROD_APPLICABLE_LAPSE_TYPE;
    }

    public String getPROD_APPLICABLE_LAPSE_TYPE() {
        return PROD_APPLICABLE_LAPSE_TYPE;
    }

    public void setPROD_CLAIM_EXPIRY_PRD(BigDecimal PROD_CLAIM_EXPIRY_PRD) {
        this.PROD_CLAIM_EXPIRY_PRD = PROD_CLAIM_EXPIRY_PRD;
    }

    public BigDecimal getPROD_CLAIM_EXPIRY_PRD() {
        return PROD_CLAIM_EXPIRY_PRD;
    }

    public void setPROD_EMP_FUND_PAY_PRD(BigDecimal PROD_EMP_FUND_PAY_PRD) {
        this.PROD_EMP_FUND_PAY_PRD = PROD_EMP_FUND_PAY_PRD;
    }

    public BigDecimal getPROD_EMP_FUND_PAY_PRD() {
        return PROD_EMP_FUND_PAY_PRD;
    }

    public void setPROD_MINIMUM_FCL_MEMBERS(BigDecimal PROD_MINIMUM_FCL_MEMBERS) {
        this.PROD_MINIMUM_FCL_MEMBERS = PROD_MINIMUM_FCL_MEMBERS;
    }

    public BigDecimal getPROD_MINIMUM_FCL_MEMBERS() {
        return PROD_MINIMUM_FCL_MEMBERS;
    }

    public void setPROD_FCL_FACTOR1(BigDecimal PROD_FCL_FACTOR1) {
        this.PROD_FCL_FACTOR1 = PROD_FCL_FACTOR1;
    }

    public BigDecimal getPROD_FCL_FACTOR1() {
        return PROD_FCL_FACTOR1;
    }

    public void setPROD_FCL_FACTOR2(BigDecimal PROD_FCL_FACTOR2) {
        this.PROD_FCL_FACTOR2 = PROD_FCL_FACTOR2;
    }

    public BigDecimal getPROD_FCL_FACTOR2() {
        return PROD_FCL_FACTOR2;
    }

    public void setPROD_GRP_RATES_MIN(BigDecimal PROD_GRP_RATES_MIN) {
        this.PROD_GRP_RATES_MIN = PROD_GRP_RATES_MIN;
    }

    public BigDecimal getPROD_GRP_RATES_MIN() {
        return PROD_GRP_RATES_MIN;
    }

    public void setPROD_MAX_TERM_YRS(BigDecimal PROD_MAX_TERM_YRS) {
        this.PROD_MAX_TERM_YRS = PROD_MAX_TERM_YRS;
    }

    public BigDecimal getPROD_MAX_TERM_YRS() {
        return PROD_MAX_TERM_YRS;
    }

    public void setPROD_MIN_EARNINGS_PRD(BigDecimal PROD_MIN_EARNINGS_PRD) {
        this.PROD_MIN_EARNINGS_PRD = PROD_MIN_EARNINGS_PRD;
    }

    public BigDecimal getPROD_MIN_EARNINGS_PRD() {
        return PROD_MIN_EARNINGS_PRD;
    }

    public void setPROD_FCL_MAX_AMT(BigDecimal PROD_FCL_MAX_AMT) {
        this.PROD_FCL_MAX_AMT = PROD_FCL_MAX_AMT;
    }

    public BigDecimal getPROD_FCL_MAX_AMT() {
        return PROD_FCL_MAX_AMT;
    }

    public void setPROD_TYPE(String PROD_TYPE) {
        this.PROD_TYPE = PROD_TYPE;
    }

    public String getPROD_TYPE() {
        return PROD_TYPE;
    }

    public void setPROD_OPEN_COVER(String PROD_OPEN_COVER) {
        this.PROD_OPEN_COVER = PROD_OPEN_COVER;
    }

    public String getPROD_OPEN_COVER() {
        return PROD_OPEN_COVER;
    }

    public void setPROD_XOL_SETUP(String PROD_XOL_SETUP) {
        this.PROD_XOL_SETUP = PROD_XOL_SETUP;
    }

    public String getPROD_XOL_SETUP() {
        return PROD_XOL_SETUP;
    }

    public void setPROD_OS_LOAN_CALC(String PROD_OS_LOAN_CALC) {
        this.PROD_OS_LOAN_CALC = PROD_OS_LOAN_CALC;
    }

    public String getPROD_OS_LOAN_CALC() {
        return PROD_OS_LOAN_CALC;
    }

    public void setPROD_INITIAL_SCH_ENDRSE(String PROD_INITIAL_SCH_ENDRSE) {
        this.PROD_INITIAL_SCH_ENDRSE = PROD_INITIAL_SCH_ENDRSE;
    }

    public String getPROD_INITIAL_SCH_ENDRSE() {
        return PROD_INITIAL_SCH_ENDRSE;
    }

    public void setPROD_REMARKS(String PROD_REMARKS) {
        this.PROD_REMARKS = PROD_REMARKS;
    }

    public String getPROD_REMARKS() {
        return PROD_REMARKS;
    }

    public void setPROD_EMV_CALCULATION_TYPE(String PROD_EMV_CALCULATION_TYPE) {
        this.PROD_EMV_CALCULATION_TYPE = PROD_EMV_CALCULATION_TYPE;
    }

    public String getPROD_EMV_CALCULATION_TYPE() {
        return PROD_EMV_CALCULATION_TYPE;
    }

    public void setPROD_VAL_INTR_CALC_MODE(String PROD_VAL_INTR_CALC_MODE) {
        this.PROD_VAL_INTR_CALC_MODE = PROD_VAL_INTR_CALC_MODE;
    }

    public String getPROD_VAL_INTR_CALC_MODE() {
        return PROD_VAL_INTR_CALC_MODE;
    }

    public void setPDA_CODE(BigDecimal PDA_CODE) {
        this.PDA_CODE = PDA_CODE;
    }

    public BigDecimal getPDA_CODE() {
        return PDA_CODE;
    }

    public void setPDA_GRP_TOT_NO(BigDecimal PDA_GRP_TOT_NO) {
        this.PDA_GRP_TOT_NO = PDA_GRP_TOT_NO;
    }

    public BigDecimal getPDA_GRP_TOT_NO() {
        return PDA_GRP_TOT_NO;
    }

    public void setLMS_PROD_DEATH_ACCEPTABLE(BigDecimal LMS_PROD_DEATH_ACCEPTABLE) {
        this.LMS_PROD_DEATH_ACCEPTABLE = LMS_PROD_DEATH_ACCEPTABLE;
    }

    public BigDecimal getLMS_PROD_DEATH_ACCEPTABLE() {
        return LMS_PROD_DEATH_ACCEPTABLE;
    }

    public void setPROD_MNTH_TO_QTR_FCTOR(BigDecimal PROD_MNTH_TO_QTR_FCTOR) {
        this.PROD_MNTH_TO_QTR_FCTOR = PROD_MNTH_TO_QTR_FCTOR;
    }

    public BigDecimal getPROD_MNTH_TO_QTR_FCTOR() {
        return PROD_MNTH_TO_QTR_FCTOR;
    }

    public void setPROD_MNTH_TO_S_ANNL_FCTOR(BigDecimal PROD_MNTH_TO_S_ANNL_FCTOR) {
        this.PROD_MNTH_TO_S_ANNL_FCTOR = PROD_MNTH_TO_S_ANNL_FCTOR;
    }

    public BigDecimal getPROD_MNTH_TO_S_ANNL_FCTOR() {
        return PROD_MNTH_TO_S_ANNL_FCTOR;
    }

    public void setPROD_MNTH_TO_ANNL_FCTOR(BigDecimal PROD_MNTH_TO_ANNL_FCTOR) {
        this.PROD_MNTH_TO_ANNL_FCTOR = PROD_MNTH_TO_ANNL_FCTOR;
    }

    public BigDecimal getPROD_MNTH_TO_ANNL_FCTOR() {
        return PROD_MNTH_TO_ANNL_FCTOR;
    }

    public void setPROD_YR_TO_MONTH_RATE(BigDecimal PROD_YR_TO_MONTH_RATE) {
        this.PROD_YR_TO_MONTH_RATE = PROD_YR_TO_MONTH_RATE;
    }

    public BigDecimal getPROD_YR_TO_MONTH_RATE() {
        return PROD_YR_TO_MONTH_RATE;
    }

    public void setPROD_YR_TO_S_ANNL_RATE(BigDecimal PROD_YR_TO_S_ANNL_RATE) {
        this.PROD_YR_TO_S_ANNL_RATE = PROD_YR_TO_S_ANNL_RATE;
    }

    public BigDecimal getPROD_YR_TO_S_ANNL_RATE() {
        return PROD_YR_TO_S_ANNL_RATE;
    }

    public void setPROD_YR_TO_QUATER_RATE(BigDecimal PROD_YR_TO_QUATER_RATE) {
        this.PROD_YR_TO_QUATER_RATE = PROD_YR_TO_QUATER_RATE;
    }

    public BigDecimal getPROD_YR_TO_QUATER_RATE() {
        return PROD_YR_TO_QUATER_RATE;
    }

    public void setPROD_QUO_COSTING_SCH_RPT(String PROD_QUO_COSTING_SCH_RPT) {
        this.PROD_QUO_COSTING_SCH_RPT = PROD_QUO_COSTING_SCH_RPT;
    }

    public String getPROD_QUO_COSTING_SCH_RPT() {
        return PROD_QUO_COSTING_SCH_RPT;
    }

    public void setPROD_QUO_SAVINGS_SCH_RPT(String PROD_QUO_SAVINGS_SCH_RPT) {
        this.PROD_QUO_SAVINGS_SCH_RPT = PROD_QUO_SAVINGS_SCH_RPT;
    }

    public String getPROD_QUO_SAVINGS_SCH_RPT() {
        return PROD_QUO_SAVINGS_SCH_RPT;
    }

    public void setPROD_QUO_FE_SCH_RPT(String PROD_QUO_FE_SCH_RPT) {
        this.PROD_QUO_FE_SCH_RPT = PROD_QUO_FE_SCH_RPT;
    }

    public String getPROD_QUO_FE_SCH_RPT() {
        return PROD_QUO_FE_SCH_RPT;
    }

    public void setPROD_QUO_AGGR_DTLS_RPT(String PROD_QUO_AGGR_DTLS_RPT) {
        this.PROD_QUO_AGGR_DTLS_RPT = PROD_QUO_AGGR_DTLS_RPT;
    }

    public String getPROD_QUO_AGGR_DTLS_RPT() {
        return PROD_QUO_AGGR_DTLS_RPT;
    }

    public void setPROD_UW_COSTING_SCH_RPT(String PROD_UW_COSTING_SCH_RPT) {
        this.PROD_UW_COSTING_SCH_RPT = PROD_UW_COSTING_SCH_RPT;
    }

    public String getPROD_UW_COSTING_SCH_RPT() {
        return PROD_UW_COSTING_SCH_RPT;
    }

    public void setPROD_UW_SAVING_SCH_RPT(String PROD_UW_SAVING_SCH_RPT) {
        this.PROD_UW_SAVING_SCH_RPT = PROD_UW_SAVING_SCH_RPT;
    }

    public String getPROD_UW_SAVING_SCH_RPT() {
        return PROD_UW_SAVING_SCH_RPT;
    }

    public void setPROD_UW_FE_SCH_RPT(String PROD_UW_FE_SCH_RPT) {
        this.PROD_UW_FE_SCH_RPT = PROD_UW_FE_SCH_RPT;
    }

    public String getPROD_UW_FE_SCH_RPT() {
        return PROD_UW_FE_SCH_RPT;
    }

    public void setPROD_UW_REFUND_SCH_RPT(String PROD_UW_REFUND_SCH_RPT) {
        this.PROD_UW_REFUND_SCH_RPT = PROD_UW_REFUND_SCH_RPT;
    }

    public String getPROD_UW_REFUND_SCH_RPT() {
        return PROD_UW_REFUND_SCH_RPT;
    }

    public void setPROD_POL_COSTING_SCH_RPT(String PROD_POL_COSTING_SCH_RPT) {
        this.PROD_POL_COSTING_SCH_RPT = PROD_POL_COSTING_SCH_RPT;
    }

    public String getPROD_POL_COSTING_SCH_RPT() {
        return PROD_POL_COSTING_SCH_RPT;
    }

    public void setPROD_POL_SAVING_SCH_RPT(String PROD_POL_SAVING_SCH_RPT) {
        this.PROD_POL_SAVING_SCH_RPT = PROD_POL_SAVING_SCH_RPT;
    }

    public String getPROD_POL_SAVING_SCH_RPT() {
        return PROD_POL_SAVING_SCH_RPT;
    }

    public void setPROD_POL_FE_SCH_RPT(String PROD_POL_FE_SCH_RPT) {
        this.PROD_POL_FE_SCH_RPT = PROD_POL_FE_SCH_RPT;
    }

    public String getPROD_POL_FE_SCH_RPT() {
        return PROD_POL_FE_SCH_RPT;
    }

    public void setPROD_REN_COSTING_SCH_RPT(String PROD_REN_COSTING_SCH_RPT) {
        this.PROD_REN_COSTING_SCH_RPT = PROD_REN_COSTING_SCH_RPT;
    }

    public String getPROD_REN_COSTING_SCH_RPT() {
        return PROD_REN_COSTING_SCH_RPT;
    }

    public void setPROD_REN_SAVING_SCH_RPT(String PROD_REN_SAVING_SCH_RPT) {
        this.PROD_REN_SAVING_SCH_RPT = PROD_REN_SAVING_SCH_RPT;
    }

    public String getPROD_REN_SAVING_SCH_RPT() {
        return PROD_REN_SAVING_SCH_RPT;
    }

    public void setPROD_REN_FE_SCH_RPT(String PROD_REN_FE_SCH_RPT) {
        this.PROD_REN_FE_SCH_RPT = PROD_REN_FE_SCH_RPT;
    }

    public String getPROD_REN_FE_SCH_RPT() {
        return PROD_REN_FE_SCH_RPT;
    }

    public void setPROD_MONTHLY_LAPSE_PRD(String PROD_MONTHLY_LAPSE_PRD) {
        this.PROD_MONTHLY_LAPSE_PRD = PROD_MONTHLY_LAPSE_PRD;
    }

    public String getPROD_MONTHLY_LAPSE_PRD() {
        return PROD_MONTHLY_LAPSE_PRD;
    }

    public void setPROD_QUARTER_LAPSE_PRD(String PROD_QUARTER_LAPSE_PRD) {
        this.PROD_QUARTER_LAPSE_PRD = PROD_QUARTER_LAPSE_PRD;
    }

    public String getPROD_QUARTER_LAPSE_PRD() {
        return PROD_QUARTER_LAPSE_PRD;
    }

    public void setPROD_SEMI_A_LAPSE_PRD(String PROD_SEMI_A_LAPSE_PRD) {
        this.PROD_SEMI_A_LAPSE_PRD = PROD_SEMI_A_LAPSE_PRD;
    }

    public String getPROD_SEMI_A_LAPSE_PRD() {
        return PROD_SEMI_A_LAPSE_PRD;
    }

    public void setPROD_ANNUALLY_LAPSE_PRD(String PROD_ANNUALLY_LAPSE_PRD) {
        this.PROD_ANNUALLY_LAPSE_PRD = PROD_ANNUALLY_LAPSE_PRD;
    }

    public String getPROD_ANNUALLY_LAPSE_PRD() {
        return PROD_ANNUALLY_LAPSE_PRD;
    }

    public void setPROD_LAPSE_PRD_DAYS(String PROD_LAPSE_PRD_DAYS) {
        this.PROD_LAPSE_PRD_DAYS = PROD_LAPSE_PRD_DAYS;
    }

    public String getPROD_LAPSE_PRD_DAYS() {
        return PROD_LAPSE_PRD_DAYS;
    }

    public void setPSPD_CODE(BigDecimal PSPD_CODE) {
        this.PSPD_CODE = PSPD_CODE;
    }

    public BigDecimal getPSPD_CODE() {
        return PSPD_CODE;
    }

    public void setPSPD_TYPE(String PSPD_TYPE) {
        this.PSPD_TYPE = PSPD_TYPE;
    }

    public String getPSPD_TYPE() {
        return PSPD_TYPE;
    }

    public void setPSPD_DOC_NAME(String PSPD_DOC_NAME) {
        this.PSPD_DOC_NAME = PSPD_DOC_NAME;
    }

    public String getPSPD_DOC_NAME() {
        return PSPD_DOC_NAME;
    }

    public void setPSPD_TYPE_DESC(String PSPD_TYPE_DESC) {
        this.PSPD_TYPE_DESC = PSPD_TYPE_DESC;
    }

    public String getPSPD_TYPE_DESC() {
        return PSPD_TYPE_DESC;
    }

    public void setPROD_EXC_NOT_AGE(String PROD_EXC_NOT_AGE) {
        this.PROD_EXC_NOT_AGE = PROD_EXC_NOT_AGE;
    }

    public String getPROD_EXC_NOT_AGE() {
        return PROD_EXC_NOT_AGE;
    }

    public void setPROD_EXC_NOT_SA(String PROD_EXC_NOT_SA) {
        this.PROD_EXC_NOT_SA = PROD_EXC_NOT_SA;
    }

    public String getPROD_EXC_NOT_SA() {
        return PROD_EXC_NOT_SA;
    }

    public void setPROD_WEF(Date PROD_WEF) {
        this.PROD_WEF = PROD_WEF;
    }

    public Date getPROD_WEF() {
        return PROD_WEF;
    }

    public void setPROD_STATUS(String PROD_STATUS) {
        this.PROD_STATUS = PROD_STATUS;
    }

    public String getPROD_STATUS() {
        return PROD_STATUS;
    }

    public void setWeeklyIndemnity(String weeklyIndemnity) {
        this.weeklyIndemnity = weeklyIndemnity;
    }

    public String getWeeklyIndemnity() {
        return weeklyIndemnity;
    }

    public void setPROD_EARNING_PRD_TYPE(String PROD_EARNING_PRD_TYPE) {
        this.PROD_EARNING_PRD_TYPE = PROD_EARNING_PRD_TYPE;
    }

    public String getPROD_EARNING_PRD_TYPE() {
        return PROD_EARNING_PRD_TYPE;
    }

    public void setPROD_FCL_CALC_TYPE(String PROD_FCL_CALC_TYPE) {
        this.PROD_FCL_CALC_TYPE = PROD_FCL_CALC_TYPE;
    }

    public String getPROD_FCL_CALC_TYPE() {
        return PROD_FCL_CALC_TYPE;
    }

    public void setPROD_PENS_TYPE(String PROD_PENS_TYPE) {
        this.PROD_PENS_TYPE = PROD_PENS_TYPE;
    }

    public String getPROD_PENS_TYPE() {
        return PROD_PENS_TYPE;
    }

    public void setPROD_PENS_CONTRI_LIMIT(String PROD_PENS_CONTRI_LIMIT) {
        this.PROD_PENS_CONTRI_LIMIT = PROD_PENS_CONTRI_LIMIT;
    }

    public String getPROD_PENS_CONTRI_LIMIT() {
        return PROD_PENS_CONTRI_LIMIT;
    }

    public void setPROD_LOAN_GUARD(String PROD_LOAN_GUARD) {
        this.PROD_LOAN_GUARD = PROD_LOAN_GUARD;
    }

    public String getPROD_LOAN_GUARD() {
        return PROD_LOAN_GUARD;
    }

    public void setPROD_QUO_EXPIRY_PRD(BigDecimal PROD_QUO_EXPIRY_PRD) {
        this.PROD_QUO_EXPIRY_PRD = PROD_QUO_EXPIRY_PRD;
    }

    public BigDecimal getPROD_QUO_EXPIRY_PRD() {
        return PROD_QUO_EXPIRY_PRD;
    }

    public void setPROD_FMS_RECEIPTING(String PROD_FMS_RECEIPTING) {
        this.PROD_FMS_RECEIPTING = PROD_FMS_RECEIPTING;
    }

    public String getPROD_FMS_RECEIPTING() {
        return PROD_FMS_RECEIPTING;
    }

    public void setPROD_FCL_SA_FORMULA(String PROD_FCL_SA_FORMULA) {
        this.PROD_FCL_SA_FORMULA = PROD_FCL_SA_FORMULA;
    }

    public String getPROD_FCL_SA_FORMULA() {
        return PROD_FCL_SA_FORMULA;
    }

    public void setPROD_RATE_TYPE(String PROD_RATE_TYPE) {
        this.PROD_RATE_TYPE = PROD_RATE_TYPE;
    }

    public String getPROD_RATE_TYPE() {
        return PROD_RATE_TYPE;
    }

    public void setPROD_MED_GRACE_PERIOD(BigDecimal PROD_MED_GRACE_PERIOD) {
        this.PROD_MED_GRACE_PERIOD = PROD_MED_GRACE_PERIOD;
    }

    public BigDecimal getPROD_MED_GRACE_PERIOD() {
        return PROD_MED_GRACE_PERIOD;
    }

    public void setPROD_QUO_AGGR_LETT(String PROD_QUO_AGGR_LETT) {
        this.PROD_QUO_AGGR_LETT = PROD_QUO_AGGR_LETT;
    }

    public String getPROD_QUO_AGGR_LETT() {
        return PROD_QUO_AGGR_LETT;
    }
}
