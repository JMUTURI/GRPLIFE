package LMSG.view.Members;

import java.math.BigDecimal;

import java.util.Date;

public class members1 {
    public members1() {
    }
    //dependants

    private BigDecimal POLM_CODE;
    private String MEM_SURNAME;
    private String MEM_OTHER_NAMES;
    private Date MEM_DOB;
    private String DTY_DESCRIPTION;
    private String MEM_NO;
    private String MEM_SEX;
    private String MEM_IDENTITY_NO;
    private boolean selected;

    private BigDecimal POLME_CODE;
    private BigDecimal POLME_LGE_CODE;
    private String POLME_LGE_SHT_DESC;
    private String LGE_DESC;
    private String POLME_AUTHORISED;
    private String POLME_AUTHORISED_BY;
    private String POLME_BLOCK;
    private String POLME_REMARKS;

    private String PCM_MAIN_RIDER;

    private BigDecimal PCM_DISC_PREM;

    private BigDecimal QCM_RATE;
    private BigDecimal pmem_share_pct;
    private BigDecimal qcm_disc_prem;

    private BigDecimal QABP_CODE;
    private BigDecimal QABP_NO;
    private Date QABP_DATE_DUE;
    private BigDecimal QABP_AMOUNT;
    private String QABP_PAID;
    private String QABP_PAID_DESC;
    private Date QABP_PAID_DATE;
    private BigDecimal QABP_VOUCHER_NO;

    private BigDecimal spr_code;
    private String spr_name;
    private String pmem_rsa_pin;

    //Joint Members
    private BigDecimal J_POLM_CODE;
    private String J_MEM_SURNAME;
    private String J_MEM_OTHER_NAMES;
    private Date J_MEM_DOB;
    private String J_DTY_DESCRIPTION;
    private String J_MEM_NO;
    private String J_MEM_SEX;
    private String J_MEM_IDENTITY_NO;

    //Main Members
    private BigDecimal M_POLM_CODE;
    private String M_MEM_SURNAME;
    private String M_MEM_OTHER_NAMES;
    private Date M_MEM_DOB;
    private String M_DTY_DESCRIPTION;
    private String M_MEM_NO;
    private String M_MEM_SEX;
    private String M_MEM_IDENTITY_NO;
    private String M_fullName;

    //Cover Types
    private String CVT_DESC;
    private Date PCM_COVER_WEF_DATE;
    private Date PCM_COVER_WET_DATE;
    private BigDecimal PCM_SA;
    private String PCM_PREMIUM;
    private String PCM_ORIGINAL_LOAN_AMT;
    private String PCM_ORIG_LOAN_REPAYMENT_PRD;
    private String PCM_LOAN_INT;
    private String PCM_SAVING_AMT;
    private Date PCM_LOAN_ISSUE_DATE;
    private BigDecimal PCM_RATE;
    private BigDecimal PCM_LOAD_DISC_PREM;
    private BigDecimal PCM_ADD_REF_PREM;
    private BigDecimal PCM_PAY_PERIOD_PREMIUM;
    private BigDecimal PCM_EARNINGS;
    private BigDecimal PCM_MULT_EARNINGS_PRD;
    private BigDecimal PCM_CODE;
    private BigDecimal PCM_PCVT_CODE;
    private BigDecimal PCM_BASIC_SAL;
    private BigDecimal PCM_HOUSE_ALLOW;
    private BigDecimal PCM_TRANS_ALLOW;
    private BigDecimal PCM_OTHER_ALLOW;
    private BigDecimal PCM_PURE_RATE;
    private BigDecimal PCM_PURE_PREMIUM;
    private BigDecimal PCM_ADR_RATE;
    private BigDecimal PCM_ACCIDENTAL_PREM;


    //Quote Cover Types
    private String cover_display;
    private Date QCM_COVER_WEF_DATE, QCM_COVER_WET_DATE, QCM_LOAN_ISSUE_DATE;
    private BigDecimal QCM_SA, QCM_LOAD_DISC_PREM, QCM_PREMIUM, QCM_ORIGINAL_LOAN_AMT, QCM_ORIG_LOAN_REPAYMENT_PRD, QCM_SAVING_AMT, QCM_CODE, QCM_EARNINGS, QCM_MULT_EARNINGS_PRD, QCM_QCVT_CODE, QCM_BASIC_SAL, QCM_HOUSE_ALLOW, QCM_TRANS_ALLOW, QCM_OTHER_ALLOW;

    private String gcoDesc;
    //Member Details
    private BigDecimal MEM_POLM_CODE;
    private BigDecimal MEM_POLM_MEM_CODE;
    private String MEM_POLM_MEM_NO;
    private String MEM_MEMBER_DISPLAY;
    private Date MEM_MEM_DOB;
    private String MEM_MEM_SURNAME;
    private String MEM_MEM_OTHER_NAMES;
    private String MEM_MEM_SEX;
    private BigDecimal MEM_POLM_PCA_CODE;
    private BigDecimal MEM_POL_PRP_CODE;

    //Member Covers
    private String CVT_CVT_DESC;
    private Date CVT_PCM_COVER_WEF_DATE;
    private Date CVT_PCM_COVER_WET_DATE;
    private String CVT_PCM_SA;
    private String CVT_PCM_PREMIUM;
    private BigDecimal CVT_PCM_CODE;
    private BigDecimal CVT_PCM_PCVT_CVT_CODE;
    private BigDecimal CVT_PCM_RATE;
    private BigDecimal CVT_PCM_ENDR_CODE;
    private String CVT_PCM_EARNINGS;
    private String CVT_PCM_MULT_EARNINGS_PRD;
    private Date CVT_PCM_LOAN_ISSUE_DATE;
    private String CVT_PCM_ORIGINAL_LOAN_AMT;
    private String CVT_PCM_ORIG_LOAN_REPAYMENT_PRD;
    private String CVT_PCM_SAVING_AMT;

    //Pension Details
    private BigDecimal PMPNS_CODE;
    private String PMPNS_EARNINGS;
    private String PMPNS_EMPLYE_VOLU_TYPE;
    private String PMPNS_COMP_INT_RATE;
    private String PMPNS_EMPLOYER_CONTR;
    private String PMPNS_EMPLYE_VOLU_CONTR;
    private String PMPNS_ANNTY_FAC_RATE;
    private String PMPNS_PENS_ANNUM;
    private String PMPNS_EMPLOYEE_CONTR;
    private String PMPNS_TOTAL_CONTR;
    private String PMPNS_NET_ANNUAL_FUND;
    private String PMPNS_ADMIN_FEE_RATE;

    //Members for Export
    private BigDecimal EX_POLM_CODE;
    private BigDecimal EX_POLM_MEM_CODE;
    private String EX_POLM_MEM_NO;
    private BigDecimal EX_PCM_CODE;
    private BigDecimal EX_PCM_EARNINGS;
    private BigDecimal EX_PCM_MULT_EARNINGS_PRD;
    private String EX_MEM_SURNAME;
    private String EX_MEM_OTHER_NAMES;
    private String EX_PCA_SHT_DESC;
    private String EX_AddRemove;
    private BigDecimal EX_original_loan_amt;
    private BigDecimal EX_loan_repayment_prd;


    //member beneficiaries
    private BigDecimal qmemBenCode;
    private BigDecimal qmemBenMainMemCode;
    private String qmemBenSurname;
    private String qmemBenOtherNames;
    private String qmemBenClass;
    private String qmemBenTerm;
    private String qmemBenMemNo;
    private String classDisplay;
    private String benTerm;
    private BigDecimal feeDisplay;
    private String qmem_ben_sex;

    //group dependent details
    private BigDecimal pabNUmber;
    private String pabSURNAME;
    private String pabOTHERNAMES;
    private Date pabDOB;
    private BigDecimal pabANB;
    private BigDecimal pabBEN_PCT;
    private BigDecimal pabANN_PURCHASE_AMT;
    private BigDecimal pabBEN_TERMINAL_AMT;
    private Date pmem_dob;
    private BigDecimal qcm_pure_rate;
    private BigDecimal qcm_pure_premium;

    private String endType;
    private BigDecimal pcmPremium;

    //Loading per cover type
    private String PCM_LOADING_TYPE;
    private BigDecimal PCM_LOADING_RATE, PCM_LOADING_DIV_FACTOR;
    private BigDecimal totPrem;
    private BigDecimal polmLcCode;
    private String pmem_ben_type,pmem_id_no,pmem_ret_desc,pmem_comments;
    private String memPinNO,memAddress;
    private String jMemPinNO,jMemAddress;
    private String endr_no;
    private Date endr_cover_from_date;
    private Date endr_cover_to_date;
    private Date endr_authorization_date;
    private String endr_prepared_by;
    private String endr_authorized_by;
    private BigDecimal endr_code;
    private String btr_trans_type;
    private BigDecimal original_loan_amt;
    private BigDecimal orig_loan_repayment_prd;
    private Date loan_issue_date;
    
    private String pmem_phone_no,pmem_email_address;
    
    public void setPOLM_CODE(BigDecimal POLM_CODE) {
        this.POLM_CODE = POLM_CODE;
    }

    public BigDecimal getPOLM_CODE() {
        return POLM_CODE;
    }

    public void setMEM_SURNAME(String MEM_SURNAME) {
        this.MEM_SURNAME = MEM_SURNAME;
    }

    public String getMEM_SURNAME() {
        return MEM_SURNAME;
    }

    public void setMEM_OTHER_NAMES(String MEM_OTHER_NAMES) {
        this.MEM_OTHER_NAMES = MEM_OTHER_NAMES;
    }

    public String getMEM_OTHER_NAMES() {
        return MEM_OTHER_NAMES;
    }

    public void setMEM_DOB(Date MEM_DOB) {
        this.MEM_DOB = MEM_DOB;
    }

    public Date getMEM_DOB() {
        return MEM_DOB;
    }

    public void setDTY_DESCRIPTION(String DTY_DESCRIPTION) {
        this.DTY_DESCRIPTION = DTY_DESCRIPTION;
    }

    public String getDTY_DESCRIPTION() {
        return DTY_DESCRIPTION;
    }

    public void setMEM_NO(String MEM_NO) {
        this.MEM_NO = MEM_NO;
    }

    public String getMEM_NO() {
        return MEM_NO;
    }

    public void setMEM_SEX(String MEM_SEX) {
        this.MEM_SEX = MEM_SEX;
    }

    public String getMEM_SEX() {
        return MEM_SEX;
    }

    public void setMEM_IDENTITY_NO(String MEM_IDENTITY_NO) {
        this.MEM_IDENTITY_NO = MEM_IDENTITY_NO;
    }

    public String getMEM_IDENTITY_NO() {
        return MEM_IDENTITY_NO;
    }

    public void setJ_POLM_CODE(BigDecimal J_POLM_CODE) {
        this.J_POLM_CODE = J_POLM_CODE;
    }

    public BigDecimal getJ_POLM_CODE() {
        return J_POLM_CODE;
    }

    public void setJ_MEM_SURNAME(String J_MEM_SURNAME) {
        this.J_MEM_SURNAME = J_MEM_SURNAME;
    }

    public String getJ_MEM_SURNAME() {
        return J_MEM_SURNAME;
    }

    public void setJ_MEM_OTHER_NAMES(String J_MEM_OTHER_NAMES) {
        this.J_MEM_OTHER_NAMES = J_MEM_OTHER_NAMES;
    }

    public String getJ_MEM_OTHER_NAMES() {
        return J_MEM_OTHER_NAMES;
    }

    public void setJ_MEM_DOB(Date J_MEM_DOB) {
        this.J_MEM_DOB = J_MEM_DOB;
    }

    public Date getJ_MEM_DOB() {
        return J_MEM_DOB;
    }

    public void setJ_DTY_DESCRIPTION(String J_DTY_DESCRIPTION) {
        this.J_DTY_DESCRIPTION = J_DTY_DESCRIPTION;
    }

    public String getJ_DTY_DESCRIPTION() {
        return J_DTY_DESCRIPTION;
    }

    public void setJ_MEM_NO(String J_MEM_NO) {
        this.J_MEM_NO = J_MEM_NO;
    }

    public String getJ_MEM_NO() {
        return J_MEM_NO;
    }

    public void setJ_MEM_SEX(String J_MEM_SEX) {
        this.J_MEM_SEX = J_MEM_SEX;
    }

    public String getJ_MEM_SEX() {
        return J_MEM_SEX;
    }

    public void setJ_MEM_IDENTITY_NO(String J_MEM_IDENTITY_NO) {
        this.J_MEM_IDENTITY_NO = J_MEM_IDENTITY_NO;
    }

    public String getJ_MEM_IDENTITY_NO() {
        return J_MEM_IDENTITY_NO;
    }

    public void setCVT_DESC(String CVT_DESC) {
        this.CVT_DESC = CVT_DESC;
    }

    public String getCVT_DESC() {
        return CVT_DESC;
    }

    public void setPCM_COVER_WEF_DATE(Date PCM_COVER_WEF_DATE) {
        this.PCM_COVER_WEF_DATE = PCM_COVER_WEF_DATE;
    }

    public Date getPCM_COVER_WEF_DATE() {
        return PCM_COVER_WEF_DATE;
    }

    public void setPCM_COVER_WET_DATE(Date PCM_COVER_WET_DATE) {
        this.PCM_COVER_WET_DATE = PCM_COVER_WET_DATE;
    }

    public Date getPCM_COVER_WET_DATE() {
        return PCM_COVER_WET_DATE;
    }

    public void setPCM_SA(BigDecimal PCM_SA) {
        this.PCM_SA = PCM_SA;
    }

    public BigDecimal getPCM_SA() {
        return PCM_SA;
    }

    public void setPCM_PREMIUM(String PCM_PREMIUM) {
        this.PCM_PREMIUM = PCM_PREMIUM;
    }

    public String getPCM_PREMIUM() {
        return PCM_PREMIUM;
    }

    public void setPCM_ORIGINAL_LOAN_AMT(String PCM_ORIGINAL_LOAN_AMT) {
        this.PCM_ORIGINAL_LOAN_AMT = PCM_ORIGINAL_LOAN_AMT;
    }

    public String getPCM_ORIGINAL_LOAN_AMT() {
        return PCM_ORIGINAL_LOAN_AMT;
    }

    public void setPCM_ORIG_LOAN_REPAYMENT_PRD(String PCM_ORIG_LOAN_REPAYMENT_PRD) {
        this.PCM_ORIG_LOAN_REPAYMENT_PRD = PCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public String getPCM_ORIG_LOAN_REPAYMENT_PRD() {
        return PCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public void setPCM_LOAN_INT(String PCM_LOAN_INT) {
        this.PCM_LOAN_INT = PCM_LOAN_INT;
    }

    public String getPCM_LOAN_INT() {
        return PCM_LOAN_INT;
    }

    public void setPCM_SAVING_AMT(String PCM_SAVING_AMT) {
        this.PCM_SAVING_AMT = PCM_SAVING_AMT;
    }

    public String getPCM_SAVING_AMT() {
        return PCM_SAVING_AMT;
    }

    public void setPCM_LOAN_ISSUE_DATE(Date PCM_LOAN_ISSUE_DATE) {
        this.PCM_LOAN_ISSUE_DATE = PCM_LOAN_ISSUE_DATE;
    }

    public Date getPCM_LOAN_ISSUE_DATE() {
        return PCM_LOAN_ISSUE_DATE;
    }

    public void setM_POLM_CODE(BigDecimal M_POLM_CODE) {
        this.M_POLM_CODE = M_POLM_CODE;
    }

    public BigDecimal getM_POLM_CODE() {
        return M_POLM_CODE;
    }

    public void setM_MEM_SURNAME(String M_MEM_SURNAME) {
        this.M_MEM_SURNAME = M_MEM_SURNAME;
    }

    public String getM_MEM_SURNAME() {
        return M_MEM_SURNAME;
    }

    public void setM_MEM_OTHER_NAMES(String M_MEM_OTHER_NAMES) {
        this.M_MEM_OTHER_NAMES = M_MEM_OTHER_NAMES;
    }

    public String getM_MEM_OTHER_NAMES() {
        return M_MEM_OTHER_NAMES;
    }

    public void setM_MEM_DOB(Date M_MEM_DOB) {
        this.M_MEM_DOB = M_MEM_DOB;
    }

    public Date getM_MEM_DOB() {
        return M_MEM_DOB;
    }

    public void setM_DTY_DESCRIPTION(String M_DTY_DESCRIPTION) {
        this.M_DTY_DESCRIPTION = M_DTY_DESCRIPTION;
    }

    public String getM_DTY_DESCRIPTION() {
        return M_DTY_DESCRIPTION;
    }

    public void setM_MEM_NO(String M_MEM_NO) {
        this.M_MEM_NO = M_MEM_NO;
    }

    public String getM_MEM_NO() {
        return M_MEM_NO;
    }

    public void setM_MEM_SEX(String M_MEM_SEX) {
        this.M_MEM_SEX = M_MEM_SEX;
    }

    public String getM_MEM_SEX() {
        return M_MEM_SEX;
    }

    public void setM_MEM_IDENTITY_NO(String M_MEM_IDENTITY_NO) {
        this.M_MEM_IDENTITY_NO = M_MEM_IDENTITY_NO;
    }

    public String getM_MEM_IDENTITY_NO() {
        return M_MEM_IDENTITY_NO;
    }

    public void setM_fullName(String M_fullName) {
        this.M_fullName = M_fullName;
    }

    public String getM_fullName() {
        return M_fullName;
    }

    public void setPCM_RATE(BigDecimal PCM_RATE) {
        this.PCM_RATE = PCM_RATE;
    }

    public BigDecimal getPCM_RATE() {
        return PCM_RATE;
    }

    public void setPCM_LOAD_DISC_PREM(BigDecimal PCM_LOAD_DISC_PREM) {
        this.PCM_LOAD_DISC_PREM = PCM_LOAD_DISC_PREM;
    }

    public BigDecimal getPCM_LOAD_DISC_PREM() {
        return PCM_LOAD_DISC_PREM;
    }

    public void setPCM_ADD_REF_PREM(BigDecimal PCM_ADD_REF_PREM) {
        this.PCM_ADD_REF_PREM = PCM_ADD_REF_PREM;
    }

    public BigDecimal getPCM_ADD_REF_PREM() {
        return PCM_ADD_REF_PREM;
    }

    public void setPCM_PAY_PERIOD_PREMIUM(BigDecimal PCM_PAY_PERIOD_PREMIUM) {
        this.PCM_PAY_PERIOD_PREMIUM = PCM_PAY_PERIOD_PREMIUM;
    }

    public BigDecimal getPCM_PAY_PERIOD_PREMIUM() {
        return PCM_PAY_PERIOD_PREMIUM;
    }

    public void setPCM_EARNINGS(BigDecimal PCM_EARNINGS) {
        this.PCM_EARNINGS = PCM_EARNINGS;
    }

    public BigDecimal getPCM_EARNINGS() {
        return PCM_EARNINGS;
    }

    public void setPCM_MULT_EARNINGS_PRD(BigDecimal PCM_MULT_EARNINGS_PRD) {
        this.PCM_MULT_EARNINGS_PRD = PCM_MULT_EARNINGS_PRD;
    }

    public BigDecimal getPCM_MULT_EARNINGS_PRD() {
        return PCM_MULT_EARNINGS_PRD;
    }

    public void setCover_display(String cover_display) {
        this.cover_display = cover_display;
    }

    public String getCover_display() {
        return cover_display;
    }

    public void setQCM_COVER_WEF_DATE(Date QCM_COVER_WEF_DATE) {
        this.QCM_COVER_WEF_DATE = QCM_COVER_WEF_DATE;
    }

    public Date getQCM_COVER_WEF_DATE() {
        return QCM_COVER_WEF_DATE;
    }

    public void setQCM_COVER_WET_DATE(Date QCM_COVER_WET_DATE) {
        this.QCM_COVER_WET_DATE = QCM_COVER_WET_DATE;
    }

    public Date getQCM_COVER_WET_DATE() {
        return QCM_COVER_WET_DATE;
    }

    public void setQCM_LOAN_ISSUE_DATE(Date QCM_LOAN_ISSUE_DATE) {
        this.QCM_LOAN_ISSUE_DATE = QCM_LOAN_ISSUE_DATE;
    }

    public Date getQCM_LOAN_ISSUE_DATE() {
        return QCM_LOAN_ISSUE_DATE;
    }

    public void setQCM_SA(BigDecimal QCM_SA) {
        this.QCM_SA = QCM_SA;
    }

    public BigDecimal getQCM_SA() {
        return QCM_SA;
    }

    public void setQCM_LOAD_DISC_PREM(BigDecimal QCM_LOAD_DISC_PREM) {
        this.QCM_LOAD_DISC_PREM = QCM_LOAD_DISC_PREM;
    }

    public BigDecimal getQCM_LOAD_DISC_PREM() {
        return QCM_LOAD_DISC_PREM;
    }

    public void setQCM_PREMIUM(BigDecimal QCM_PREMIUM) {
        this.QCM_PREMIUM = QCM_PREMIUM;
    }

    public BigDecimal getQCM_PREMIUM() {
        return QCM_PREMIUM;
    }

    public void setQCM_ORIGINAL_LOAN_AMT(BigDecimal QCM_ORIGINAL_LOAN_AMT) {
        this.QCM_ORIGINAL_LOAN_AMT = QCM_ORIGINAL_LOAN_AMT;
    }

    public BigDecimal getQCM_ORIGINAL_LOAN_AMT() {
        return QCM_ORIGINAL_LOAN_AMT;
    }

    public void setQCM_ORIG_LOAN_REPAYMENT_PRD(BigDecimal QCM_ORIG_LOAN_REPAYMENT_PRD) {
        this.QCM_ORIG_LOAN_REPAYMENT_PRD = QCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public BigDecimal getQCM_ORIG_LOAN_REPAYMENT_PRD() {
        return QCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public void setQCM_SAVING_AMT(BigDecimal QCM_SAVING_AMT) {
        this.QCM_SAVING_AMT = QCM_SAVING_AMT;
    }

    public BigDecimal getQCM_SAVING_AMT() {
        return QCM_SAVING_AMT;
    }

    public void setQCM_CODE(BigDecimal QCM_CODE) {
        this.QCM_CODE = QCM_CODE;
    }

    public BigDecimal getQCM_CODE() {
        return QCM_CODE;
    }

    public void setQCM_EARNINGS(BigDecimal QCM_EARNINGS) {
        this.QCM_EARNINGS = QCM_EARNINGS;
    }

    public BigDecimal getQCM_EARNINGS() {
        return QCM_EARNINGS;
    }

    public void setQCM_MULT_EARNINGS_PRD(BigDecimal QCM_MULT_EARNINGS_PRD) {
        this.QCM_MULT_EARNINGS_PRD = QCM_MULT_EARNINGS_PRD;
    }

    public BigDecimal getQCM_MULT_EARNINGS_PRD() {
        return QCM_MULT_EARNINGS_PRD;
    }

    public void setQCM_QCVT_CODE(BigDecimal QCM_QCVT_CODE) {
        this.QCM_QCVT_CODE = QCM_QCVT_CODE;
    }

    public BigDecimal getQCM_QCVT_CODE() {
        return QCM_QCVT_CODE;
    }

    public void setPCM_CODE(BigDecimal PCM_CODE) {
        this.PCM_CODE = PCM_CODE;
    }

    public BigDecimal getPCM_CODE() {
        return PCM_CODE;
    }

    public void setPCM_PCVT_CODE(BigDecimal PCM_PCVT_CODE) {
        this.PCM_PCVT_CODE = PCM_PCVT_CODE;
    }

    public BigDecimal getPCM_PCVT_CODE() {
        return PCM_PCVT_CODE;
    }

    public void setMEM_POLM_CODE(BigDecimal MEM_POLM_CODE) {
        this.MEM_POLM_CODE = MEM_POLM_CODE;
    }

    public BigDecimal getMEM_POLM_CODE() {
        return MEM_POLM_CODE;
    }

    public void setMEM_POLM_MEM_CODE(BigDecimal MEM_POLM_MEM_CODE) {
        this.MEM_POLM_MEM_CODE = MEM_POLM_MEM_CODE;
    }

    public BigDecimal getMEM_POLM_MEM_CODE() {
        return MEM_POLM_MEM_CODE;
    }

    public void setMEM_POLM_MEM_NO(String MEM_POLM_MEM_NO) {
        this.MEM_POLM_MEM_NO = MEM_POLM_MEM_NO;
    }

    public String getMEM_POLM_MEM_NO() {
        return MEM_POLM_MEM_NO;
    }

    public void setMEM_MEMBER_DISPLAY(String MEM_MEMBER_DISPLAY) {
        this.MEM_MEMBER_DISPLAY = MEM_MEMBER_DISPLAY;
    }

    public String getMEM_MEMBER_DISPLAY() {
        return MEM_MEMBER_DISPLAY;
    }

    public void setMEM_MEM_DOB(Date MEM_MEM_DOB) {
        this.MEM_MEM_DOB = MEM_MEM_DOB;
    }

    public Date getMEM_MEM_DOB() {
        return MEM_MEM_DOB;
    }

    public void setMEM_MEM_SURNAME(String MEM_MEM_SURNAME) {
        this.MEM_MEM_SURNAME = MEM_MEM_SURNAME;
    }

    public String getMEM_MEM_SURNAME() {
        return MEM_MEM_SURNAME;
    }

    public void setMEM_MEM_OTHER_NAMES(String MEM_MEM_OTHER_NAMES) {
        this.MEM_MEM_OTHER_NAMES = MEM_MEM_OTHER_NAMES;
    }

    public String getMEM_MEM_OTHER_NAMES() {
        return MEM_MEM_OTHER_NAMES;
    }

    public void setMEM_MEM_SEX(String MEM_MEM_SEX) {
        this.MEM_MEM_SEX = MEM_MEM_SEX;
    }

    public String getMEM_MEM_SEX() {
        return MEM_MEM_SEX;
    }

    public void setMEM_POLM_PCA_CODE(BigDecimal MEM_POLM_PCA_CODE) {
        this.MEM_POLM_PCA_CODE = MEM_POLM_PCA_CODE;
    }

    public BigDecimal getMEM_POLM_PCA_CODE() {
        return MEM_POLM_PCA_CODE;
    }

    public void setMEM_POL_PRP_CODE(BigDecimal MEM_POL_PRP_CODE) {
        this.MEM_POL_PRP_CODE = MEM_POL_PRP_CODE;
    }

    public BigDecimal getMEM_POL_PRP_CODE() {
        return MEM_POL_PRP_CODE;
    }

    public void setCVT_CVT_DESC(String CVT_CVT_DESC) {
        this.CVT_CVT_DESC = CVT_CVT_DESC;
    }

    public String getCVT_CVT_DESC() {
        return CVT_CVT_DESC;
    }

    public void setCVT_PCM_COVER_WEF_DATE(Date CVT_PCM_COVER_WEF_DATE) {
        this.CVT_PCM_COVER_WEF_DATE = CVT_PCM_COVER_WEF_DATE;
    }

    public Date getCVT_PCM_COVER_WEF_DATE() {
        return CVT_PCM_COVER_WEF_DATE;
    }

    public void setCVT_PCM_COVER_WET_DATE(Date CVT_PCM_COVER_WET_DATE) {
        this.CVT_PCM_COVER_WET_DATE = CVT_PCM_COVER_WET_DATE;
    }

    public Date getCVT_PCM_COVER_WET_DATE() {
        return CVT_PCM_COVER_WET_DATE;
    }

    public void setCVT_PCM_SA(String CVT_PCM_SA) {
        this.CVT_PCM_SA = CVT_PCM_SA;
    }

    public String getCVT_PCM_SA() {
        return CVT_PCM_SA;
    }

    public void setCVT_PCM_PREMIUM(String CVT_PCM_PREMIUM) {
        this.CVT_PCM_PREMIUM = CVT_PCM_PREMIUM;
    }

    public String getCVT_PCM_PREMIUM() {
        return CVT_PCM_PREMIUM;
    }

    public void setCVT_PCM_CODE(BigDecimal CVT_PCM_CODE) {
        this.CVT_PCM_CODE = CVT_PCM_CODE;
    }

    public BigDecimal getCVT_PCM_CODE() {
        return CVT_PCM_CODE;
    }

    public void setCVT_PCM_PCVT_CVT_CODE(BigDecimal CVT_PCM_PCVT_CVT_CODE) {
        this.CVT_PCM_PCVT_CVT_CODE = CVT_PCM_PCVT_CVT_CODE;
    }

    public BigDecimal getCVT_PCM_PCVT_CVT_CODE() {
        return CVT_PCM_PCVT_CVT_CODE;
    }

    public void setCVT_PCM_RATE(BigDecimal CVT_PCM_RATE) {
        this.CVT_PCM_RATE = CVT_PCM_RATE;
    }

    public BigDecimal getCVT_PCM_RATE() {
        return CVT_PCM_RATE;
    }

    public void setCVT_PCM_ENDR_CODE(BigDecimal CVT_PCM_ENDR_CODE) {
        this.CVT_PCM_ENDR_CODE = CVT_PCM_ENDR_CODE;
    }

    public BigDecimal getCVT_PCM_ENDR_CODE() {
        return CVT_PCM_ENDR_CODE;
    }

    public void setCVT_PCM_EARNINGS(String CVT_PCM_EARNINGS) {
        this.CVT_PCM_EARNINGS = CVT_PCM_EARNINGS;
    }

    public String getCVT_PCM_EARNINGS() {
        return CVT_PCM_EARNINGS;
    }

    public void setCVT_PCM_MULT_EARNINGS_PRD(String CVT_PCM_MULT_EARNINGS_PRD) {
        this.CVT_PCM_MULT_EARNINGS_PRD = CVT_PCM_MULT_EARNINGS_PRD;
    }

    public String getCVT_PCM_MULT_EARNINGS_PRD() {
        return CVT_PCM_MULT_EARNINGS_PRD;
    }

    public void setCVT_PCM_LOAN_ISSUE_DATE(Date CVT_PCM_LOAN_ISSUE_DATE) {
        this.CVT_PCM_LOAN_ISSUE_DATE = CVT_PCM_LOAN_ISSUE_DATE;
    }

    public Date getCVT_PCM_LOAN_ISSUE_DATE() {
        return CVT_PCM_LOAN_ISSUE_DATE;
    }

    public void setCVT_PCM_ORIGINAL_LOAN_AMT(String CVT_PCM_ORIGINAL_LOAN_AMT) {
        this.CVT_PCM_ORIGINAL_LOAN_AMT = CVT_PCM_ORIGINAL_LOAN_AMT;
    }

    public String getCVT_PCM_ORIGINAL_LOAN_AMT() {
        return CVT_PCM_ORIGINAL_LOAN_AMT;
    }

    public void setCVT_PCM_ORIG_LOAN_REPAYMENT_PRD(String CVT_PCM_ORIG_LOAN_REPAYMENT_PRD) {
        this.CVT_PCM_ORIG_LOAN_REPAYMENT_PRD = CVT_PCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public String getCVT_PCM_ORIG_LOAN_REPAYMENT_PRD() {
        return CVT_PCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public void setCVT_PCM_SAVING_AMT(String CVT_PCM_SAVING_AMT) {
        this.CVT_PCM_SAVING_AMT = CVT_PCM_SAVING_AMT;
    }

    public String getCVT_PCM_SAVING_AMT() {
        return CVT_PCM_SAVING_AMT;
    }

    public void setPMPNS_CODE(BigDecimal PMPNS_CODE) {
        this.PMPNS_CODE = PMPNS_CODE;
    }

    public BigDecimal getPMPNS_CODE() {
        return PMPNS_CODE;
    }

    public void setPMPNS_EARNINGS(String PMPNS_EARNINGS) {
        this.PMPNS_EARNINGS = PMPNS_EARNINGS;
    }

    public String getPMPNS_EARNINGS() {
        return PMPNS_EARNINGS;
    }

    public void setPMPNS_EMPLYE_VOLU_TYPE(String PMPNS_EMPLYE_VOLU_TYPE) {
        this.PMPNS_EMPLYE_VOLU_TYPE = PMPNS_EMPLYE_VOLU_TYPE;
    }

    public String getPMPNS_EMPLYE_VOLU_TYPE() {
        return PMPNS_EMPLYE_VOLU_TYPE;
    }

    public void setPMPNS_COMP_INT_RATE(String PMPNS_COMP_INT_RATE) {
        this.PMPNS_COMP_INT_RATE = PMPNS_COMP_INT_RATE;
    }

    public String getPMPNS_COMP_INT_RATE() {
        return PMPNS_COMP_INT_RATE;
    }

    public void setPMPNS_EMPLOYER_CONTR(String PMPNS_EMPLOYER_CONTR) {
        this.PMPNS_EMPLOYER_CONTR = PMPNS_EMPLOYER_CONTR;
    }

    public String getPMPNS_EMPLOYER_CONTR() {
        return PMPNS_EMPLOYER_CONTR;
    }

    public void setPMPNS_EMPLYE_VOLU_CONTR(String PMPNS_EMPLYE_VOLU_CONTR) {
        this.PMPNS_EMPLYE_VOLU_CONTR = PMPNS_EMPLYE_VOLU_CONTR;
    }

    public String getPMPNS_EMPLYE_VOLU_CONTR() {
        return PMPNS_EMPLYE_VOLU_CONTR;
    }

    public void setPMPNS_ANNTY_FAC_RATE(String PMPNS_ANNTY_FAC_RATE) {
        this.PMPNS_ANNTY_FAC_RATE = PMPNS_ANNTY_FAC_RATE;
    }

    public String getPMPNS_ANNTY_FAC_RATE() {
        return PMPNS_ANNTY_FAC_RATE;
    }

    public void setPMPNS_PENS_ANNUM(String PMPNS_PENS_ANNUM) {
        this.PMPNS_PENS_ANNUM = PMPNS_PENS_ANNUM;
    }

    public String getPMPNS_PENS_ANNUM() {
        return PMPNS_PENS_ANNUM;
    }

    public void setPMPNS_EMPLOYEE_CONTR(String PMPNS_EMPLOYEE_CONTR) {
        this.PMPNS_EMPLOYEE_CONTR = PMPNS_EMPLOYEE_CONTR;
    }

    public String getPMPNS_EMPLOYEE_CONTR() {
        return PMPNS_EMPLOYEE_CONTR;
    }

    public void setPMPNS_TOTAL_CONTR(String PMPNS_TOTAL_CONTR) {
        this.PMPNS_TOTAL_CONTR = PMPNS_TOTAL_CONTR;
    }

    public String getPMPNS_TOTAL_CONTR() {
        return PMPNS_TOTAL_CONTR;
    }

    public void setPMPNS_NET_ANNUAL_FUND(String PMPNS_NET_ANNUAL_FUND) {
        this.PMPNS_NET_ANNUAL_FUND = PMPNS_NET_ANNUAL_FUND;
    }

    public String getPMPNS_NET_ANNUAL_FUND() {
        return PMPNS_NET_ANNUAL_FUND;
    }

    public void setPMPNS_ADMIN_FEE_RATE(String PMPNS_ADMIN_FEE_RATE) {
        this.PMPNS_ADMIN_FEE_RATE = PMPNS_ADMIN_FEE_RATE;
    }

    public String getPMPNS_ADMIN_FEE_RATE() {
        return PMPNS_ADMIN_FEE_RATE;
    }

    public void setEX_POLM_CODE(BigDecimal EX_POLM_CODE) {
        this.EX_POLM_CODE = EX_POLM_CODE;
    }

    public BigDecimal getEX_POLM_CODE() {
        return EX_POLM_CODE;
    }

    public void setEX_POLM_MEM_CODE(BigDecimal EX_POLM_MEM_CODE) {
        this.EX_POLM_MEM_CODE = EX_POLM_MEM_CODE;
    }

    public BigDecimal getEX_POLM_MEM_CODE() {
        return EX_POLM_MEM_CODE;
    }

    public void setEX_POLM_MEM_NO(String EX_POLM_MEM_NO) {
        this.EX_POLM_MEM_NO = EX_POLM_MEM_NO;
    }

    public String getEX_POLM_MEM_NO() {
        return EX_POLM_MEM_NO;
    }

    public void setEX_PCM_CODE(BigDecimal EX_PCM_CODE) {
        this.EX_PCM_CODE = EX_PCM_CODE;
    }

    public BigDecimal getEX_PCM_CODE() {
        return EX_PCM_CODE;
    }

    public void setEX_PCM_EARNINGS(BigDecimal EX_PCM_EARNINGS) {
        this.EX_PCM_EARNINGS = EX_PCM_EARNINGS;
    }

    public BigDecimal getEX_PCM_EARNINGS() {
        return EX_PCM_EARNINGS;
    }

    public void setEX_PCM_MULT_EARNINGS_PRD(BigDecimal EX_PCM_MULT_EARNINGS_PRD) {
        this.EX_PCM_MULT_EARNINGS_PRD = EX_PCM_MULT_EARNINGS_PRD;
    }

    public BigDecimal getEX_PCM_MULT_EARNINGS_PRD() {
        return EX_PCM_MULT_EARNINGS_PRD;
    }

    public void setEX_MEM_SURNAME(String EX_MEM_SURNAME) {
        this.EX_MEM_SURNAME = EX_MEM_SURNAME;
    }

    public String getEX_MEM_SURNAME() {
        return EX_MEM_SURNAME;
    }

    public void setEX_MEM_OTHER_NAMES(String EX_MEM_OTHER_NAMES) {
        this.EX_MEM_OTHER_NAMES = EX_MEM_OTHER_NAMES;
    }

    public String getEX_MEM_OTHER_NAMES() {
        return EX_MEM_OTHER_NAMES;
    }

    public void setEX_PCA_SHT_DESC(String EX_PCA_SHT_DESC) {
        this.EX_PCA_SHT_DESC = EX_PCA_SHT_DESC;
    }

    public String getEX_PCA_SHT_DESC() {
        return EX_PCA_SHT_DESC;
    }

    public void setEX_AddRemove(String EX_AddRemove) {
        this.EX_AddRemove = EX_AddRemove;
    }

    public String getEX_AddRemove() {
        return EX_AddRemove;
    }

    public void setQmemBenCode(BigDecimal qmemBenCode) {
        this.qmemBenCode = qmemBenCode;
    }

    public BigDecimal getQmemBenCode() {
        return qmemBenCode;
    }

    public void setQmemBenMainMemCode(BigDecimal qmemBenMainMemCode) {
        this.qmemBenMainMemCode = qmemBenMainMemCode;
    }

    public BigDecimal getQmemBenMainMemCode() {
        return qmemBenMainMemCode;
    }

    public void setQmemBenSurname(String qmemBenSurname) {
        this.qmemBenSurname = qmemBenSurname;
    }

    public String getQmemBenSurname() {
        return qmemBenSurname;
    }

    public void setQmemBenOtherNames(String qmemBenOtherNames) {
        this.qmemBenOtherNames = qmemBenOtherNames;
    }

    public String getQmemBenOtherNames() {
        return qmemBenOtherNames;
    }

    public void setQmemBenClass(String qmemBenClass) {
        this.qmemBenClass = qmemBenClass;
    }

    public String getQmemBenClass() {
        return qmemBenClass;
    }

    public void setQmemBenTerm(String qmemBenTerm) {
        this.qmemBenTerm = qmemBenTerm;
    }

    public String getQmemBenTerm() {
        return qmemBenTerm;
    }

    public void setQmemBenMemNo(String qmemBenMemNo) {
        this.qmemBenMemNo = qmemBenMemNo;
    }

    public String getQmemBenMemNo() {
        return qmemBenMemNo;
    }

    public void setClassDisplay(String classDisplay) {
        this.classDisplay = classDisplay;
    }

    public String getClassDisplay() {
        return classDisplay;
    }

    public void setBenTerm(String benTerm) {
        this.benTerm = benTerm;
    }

    public String getBenTerm() {
        return benTerm;
    }

    public void setFeeDisplay(BigDecimal feeDisplay) {
        this.feeDisplay = feeDisplay;
    }

    public BigDecimal getFeeDisplay() {
        return feeDisplay;
    }

    public void setQmem_ben_sex(String qmem_ben_sex) {
        this.qmem_ben_sex = qmem_ben_sex;
    }

    public String getQmem_ben_sex() {
        return qmem_ben_sex;
    }

    public void setPCM_BASIC_SAL(BigDecimal PCM_BASIC_SAL) {
        this.PCM_BASIC_SAL = PCM_BASIC_SAL;
    }

    public BigDecimal getPCM_BASIC_SAL() {
        return PCM_BASIC_SAL;
    }

    public void setPCM_HOUSE_ALLOW(BigDecimal PCM_HOUSE_ALLOW) {
        this.PCM_HOUSE_ALLOW = PCM_HOUSE_ALLOW;
    }

    public BigDecimal getPCM_HOUSE_ALLOW() {
        return PCM_HOUSE_ALLOW;
    }

    public void setPCM_TRANS_ALLOW(BigDecimal PCM_TRANS_ALLOW) {
        this.PCM_TRANS_ALLOW = PCM_TRANS_ALLOW;
    }

    public BigDecimal getPCM_TRANS_ALLOW() {
        return PCM_TRANS_ALLOW;
    }

    public void setPCM_OTHER_ALLOW(BigDecimal PCM_OTHER_ALLOW) {
        this.PCM_OTHER_ALLOW = PCM_OTHER_ALLOW;
    }

    public BigDecimal getPCM_OTHER_ALLOW() {
        return PCM_OTHER_ALLOW;
    }

    public void setQCM_BASIC_SAL(BigDecimal QCM_BASIC_SAL) {
        this.QCM_BASIC_SAL = QCM_BASIC_SAL;
    }

    public BigDecimal getQCM_BASIC_SAL() {
        return QCM_BASIC_SAL;
    }

    public void setQCM_HOUSE_ALLOW(BigDecimal QCM_HOUSE_ALLOW) {
        this.QCM_HOUSE_ALLOW = QCM_HOUSE_ALLOW;
    }

    public BigDecimal getQCM_HOUSE_ALLOW() {
        return QCM_HOUSE_ALLOW;
    }

    public void setQCM_TRANS_ALLOW(BigDecimal QCM_TRANS_ALLOW) {
        this.QCM_TRANS_ALLOW = QCM_TRANS_ALLOW;
    }

    public BigDecimal getQCM_TRANS_ALLOW() {
        return QCM_TRANS_ALLOW;
    }

    public void setQCM_OTHER_ALLOW(BigDecimal QCM_OTHER_ALLOW) {
        this.QCM_OTHER_ALLOW = QCM_OTHER_ALLOW;
    }

    public BigDecimal getQCM_OTHER_ALLOW() {
        return QCM_OTHER_ALLOW;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setPabNUmber(BigDecimal pabNUmber) {
        this.pabNUmber = pabNUmber;
    }

    public BigDecimal getPabNUmber() {
        return pabNUmber;
    }

    public void setPabSURNAME(String pabSURNAME) {
        this.pabSURNAME = pabSURNAME;
    }

    public String getPabSURNAME() {
        return pabSURNAME;
    }

    public void setPabOTHERNAMES(String pabOTHERNAMES) {
        this.pabOTHERNAMES = pabOTHERNAMES;
    }

    public String getPabOTHERNAMES() {
        return pabOTHERNAMES;
    }

    public void setPabDOB(Date pabDOB) {
        this.pabDOB = pabDOB;
    }

    public Date getPabDOB() {
        return pabDOB;
    }

    public void setPabANB(BigDecimal pabANB) {
        this.pabANB = pabANB;
    }

    public BigDecimal getPabANB() {
        return pabANB;
    }

    public void setPabBEN_PCT(BigDecimal pabBEN_PCT) {
        this.pabBEN_PCT = pabBEN_PCT;
    }

    public BigDecimal getPabBEN_PCT() {
        return pabBEN_PCT;
    }

    public void setPabANN_PURCHASE_AMT(BigDecimal pabANN_PURCHASE_AMT) {
        this.pabANN_PURCHASE_AMT = pabANN_PURCHASE_AMT;
    }

    public BigDecimal getPabANN_PURCHASE_AMT() {
        return pabANN_PURCHASE_AMT;
    }

    public void setPabBEN_TERMINAL_AMT(BigDecimal pabBEN_TERMINAL_AMT) {
        this.pabBEN_TERMINAL_AMT = pabBEN_TERMINAL_AMT;
    }

    public BigDecimal getPabBEN_TERMINAL_AMT() {
        return pabBEN_TERMINAL_AMT;
    }

    public void setQCM_RATE(BigDecimal QCM_RATE) {
        this.QCM_RATE = QCM_RATE;
    }

    public BigDecimal getQCM_RATE() {
        return QCM_RATE;
    }

    public void setPmem_share_pct(BigDecimal pmem_share_pct) {
        this.pmem_share_pct = pmem_share_pct;
    }

    public BigDecimal getPmem_share_pct() {
        return pmem_share_pct;
    }

    public void setQABP_CODE(BigDecimal QABP_CODE) {
        this.QABP_CODE = QABP_CODE;
    }

    public BigDecimal getQABP_CODE() {
        return QABP_CODE;
    }

    public void setQABP_NO(BigDecimal QABP_NO) {
        this.QABP_NO = QABP_NO;
    }

    public BigDecimal getQABP_NO() {
        return QABP_NO;
    }

    public void setQABP_DATE_DUE(Date QABP_DATE_DUE) {
        this.QABP_DATE_DUE = QABP_DATE_DUE;
    }

    public Date getQABP_DATE_DUE() {
        return QABP_DATE_DUE;
    }

    public void setQABP_AMOUNT(BigDecimal QABP_AMOUNT) {
        this.QABP_AMOUNT = QABP_AMOUNT;
    }

    public BigDecimal getQABP_AMOUNT() {
        return QABP_AMOUNT;
    }

    public void setQABP_PAID(String QABP_PAID) {
        this.QABP_PAID = QABP_PAID;
    }

    public String getQABP_PAID() {
        return QABP_PAID;
    }

    public void setQABP_PAID_DESC(String QABP_PAID_DESC) {
        this.QABP_PAID_DESC = QABP_PAID_DESC;
    }

    public String getQABP_PAID_DESC() {
        return QABP_PAID_DESC;
    }

    public void setQABP_PAID_DATE(Date QABP_PAID_DATE) {
        this.QABP_PAID_DATE = QABP_PAID_DATE;
    }

    public Date getQABP_PAID_DATE() {
        return QABP_PAID_DATE;
    }

    public void setQABP_VOUCHER_NO(BigDecimal QABP_VOUCHER_NO) {
        this.QABP_VOUCHER_NO = QABP_VOUCHER_NO;
    }

    public BigDecimal getQABP_VOUCHER_NO() {
        return QABP_VOUCHER_NO;
    }

    public void setSpr_code(BigDecimal spr_code) {
        this.spr_code = spr_code;
    }

    public BigDecimal getSpr_code() {
        return spr_code;
    }

    public void setSpr_name(String spr_name) {
        this.spr_name = spr_name;
    }

    public String getSpr_name() {
        return spr_name;
    }

    public void setPmem_rsa_pin(String pmem_rsa_pin) {
        this.pmem_rsa_pin = pmem_rsa_pin;
    }

    public String getPmem_rsa_pin() {
        return pmem_rsa_pin;
    }

    public void setQcm_disc_prem(BigDecimal qcm_disc_prem) {
        this.qcm_disc_prem = qcm_disc_prem;
    }

    public BigDecimal getQcm_disc_prem() {
        return qcm_disc_prem;
    }

    public void setPCM_DISC_PREM(BigDecimal PCM_DISC_PREM) {
        this.PCM_DISC_PREM = PCM_DISC_PREM;
    }

    public BigDecimal getPCM_DISC_PREM() {
        return PCM_DISC_PREM;
    }

    public void setPmem_dob(Date pmem_dob) {
        this.pmem_dob = pmem_dob;
    }

    public Date getPmem_dob() {
        return pmem_dob;
    }

    public void setPOLME_CODE(BigDecimal POLME_CODE) {
        this.POLME_CODE = POLME_CODE;
    }

    public BigDecimal getPOLME_CODE() {
        return POLME_CODE;
    }

    public void setPOLME_LGE_CODE(BigDecimal POLME_LGE_CODE) {
        this.POLME_LGE_CODE = POLME_LGE_CODE;
    }

    public BigDecimal getPOLME_LGE_CODE() {
        return POLME_LGE_CODE;
    }

    public void setPOLME_LGE_SHT_DESC(String POLME_LGE_SHT_DESC) {
        this.POLME_LGE_SHT_DESC = POLME_LGE_SHT_DESC;
    }

    public String getPOLME_LGE_SHT_DESC() {
        return POLME_LGE_SHT_DESC;
    }

    public void setLGE_DESC(String LGE_DESC) {
        this.LGE_DESC = LGE_DESC;
    }

    public String getLGE_DESC() {
        return LGE_DESC;
    }

    public void setPOLME_AUTHORISED(String POLME_AUTHORISED) {
        this.POLME_AUTHORISED = POLME_AUTHORISED;
    }

    public String getPOLME_AUTHORISED() {
        return POLME_AUTHORISED;
    }

    public void setPOLME_AUTHORISED_BY(String POLME_AUTHORISED_BY) {
        this.POLME_AUTHORISED_BY = POLME_AUTHORISED_BY;
    }

    public String getPOLME_AUTHORISED_BY() {
        return POLME_AUTHORISED_BY;
    }

    public void setPOLME_BLOCK(String POLME_BLOCK) {
        this.POLME_BLOCK = POLME_BLOCK;
    }

    public String getPOLME_BLOCK() {
        return POLME_BLOCK;
    }

    public void setEX_original_loan_amt(BigDecimal EX_original_loan_amt) {
        this.EX_original_loan_amt = EX_original_loan_amt;
    }

    public BigDecimal getEX_original_loan_amt() {
        return EX_original_loan_amt;
    }

    public void setEX_loan_repayment_prd(BigDecimal EX_loan_repayment_prd) {
        this.EX_loan_repayment_prd = EX_loan_repayment_prd;
    }

    public BigDecimal getEX_loan_repayment_prd() {
        return EX_loan_repayment_prd;
    }

    public void setPCM_MAIN_RIDER(String PCM_MAIN_RIDER) {
        this.PCM_MAIN_RIDER = PCM_MAIN_RIDER;
    }

    public String getPCM_MAIN_RIDER() {
        return PCM_MAIN_RIDER;
    }

    public void setEndType(String endType) {
        this.endType = endType;
    }

    public String getEndType() {
        return endType;
    }

    public void setPcmPremium(BigDecimal pcmPremium) {
        this.pcmPremium = pcmPremium;
    }

    public BigDecimal getPcmPremium() {
        return pcmPremium;
    }

    public void setQcm_pure_rate(BigDecimal qcm_pure_rate) {
        this.qcm_pure_rate = qcm_pure_rate;
    }

    public BigDecimal getQcm_pure_rate() {
        return qcm_pure_rate;
    }

    public void setQcm_pure_premium(BigDecimal qcm_pure_premium) {
        this.qcm_pure_premium = qcm_pure_premium;
    }

    public BigDecimal getQcm_pure_premium() {
        return qcm_pure_premium;
    }

    public void setPCM_PURE_RATE(BigDecimal PCM_PURE_RATE) {
        this.PCM_PURE_RATE = PCM_PURE_RATE;
    }

    public BigDecimal getPCM_PURE_RATE() {
        return PCM_PURE_RATE;
    }

    public void setPCM_PURE_PREMIUM(BigDecimal PCM_PURE_PREMIUM) {
        this.PCM_PURE_PREMIUM = PCM_PURE_PREMIUM;
    }

    public BigDecimal getPCM_PURE_PREMIUM() {
        return PCM_PURE_PREMIUM;
    }

    public void setPCM_ADR_RATE(BigDecimal PCM_ADR_RATE) {
        this.PCM_ADR_RATE = PCM_ADR_RATE;
    }

    public BigDecimal getPCM_ADR_RATE() {
        return PCM_ADR_RATE;
    }

    public void setPCM_ACCIDENTAL_PREM(BigDecimal PCM_ACCIDENTAL_PREM) {
        this.PCM_ACCIDENTAL_PREM = PCM_ACCIDENTAL_PREM;
    }

    public BigDecimal getPCM_ACCIDENTAL_PREM() {
        return PCM_ACCIDENTAL_PREM;
    }

    public void setPCM_LOADING_TYPE(String PCM_LOADING_TYPE) {
        this.PCM_LOADING_TYPE = PCM_LOADING_TYPE;
    }

    public String getPCM_LOADING_TYPE() {
        return PCM_LOADING_TYPE;
    }

    public void setPCM_LOADING_RATE(BigDecimal PCM_LOADING_RATE) {
        this.PCM_LOADING_RATE = PCM_LOADING_RATE;
    }

    public BigDecimal getPCM_LOADING_RATE() {
        return PCM_LOADING_RATE;
    }

    public void setPCM_LOADING_DIV_FACTOR(BigDecimal PCM_LOADING_DIV_FACTOR) {
        this.PCM_LOADING_DIV_FACTOR = PCM_LOADING_DIV_FACTOR;
    }

    public BigDecimal getPCM_LOADING_DIV_FACTOR() {
        return PCM_LOADING_DIV_FACTOR;
    }

    public void setTotPrem(BigDecimal totPrem) {
        this.totPrem = totPrem;
    }

    public BigDecimal getTotPrem() {
        return totPrem;
    }

    public void setGcoDesc(String gcoDesc) {
        this.gcoDesc = gcoDesc;
    }

    public String getGcoDesc() {
        return gcoDesc;
    }

    public void setPolmLcCode(BigDecimal polmLcCode) {
        this.polmLcCode = polmLcCode;
    }

    public BigDecimal getPolmLcCode() {
        return polmLcCode;
    }

    public void setPOLME_REMARKS(String POLME_REMARKS) {
        this.POLME_REMARKS = POLME_REMARKS;
    }

    public String getPOLME_REMARKS() {
        return POLME_REMARKS;
    }

    public void setPmem_ben_type(String pmem_ben_type) {
        this.pmem_ben_type = pmem_ben_type;
    }

    public String getPmem_ben_type() {
        return pmem_ben_type;
    }

    public void setPmem_id_no(String pmem_id_no) {
        this.pmem_id_no = pmem_id_no;
    }

    public String getPmem_id_no() {
        return pmem_id_no;
    }

    public void setPmem_ret_desc(String pmem_ret_desc) {
        this.pmem_ret_desc = pmem_ret_desc;
    }

    public String getPmem_ret_desc() {
        return pmem_ret_desc;
    }

    public void setPmem_comments(String pmem_comments) {
        this.pmem_comments = pmem_comments;
    }

    public String getPmem_comments() {
        return pmem_comments;
    }

    public void setMemPinNO(String memPinNO) {
        this.memPinNO = memPinNO;
    }

    public String getMemPinNO() {
        return memPinNO;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setJMemPinNO(String jMemPinNO) {
        this.jMemPinNO = jMemPinNO;
    }

    public String getJMemPinNO() {
        return jMemPinNO;
    }

    public void setJMemAddress(String jMemAddress) {
        this.jMemAddress = jMemAddress;
    }

    public String getJMemAddress() {
        return jMemAddress;
    }

    public void setEndr_no(String endr_no) {
        this.endr_no = endr_no;
    }

    public String getEndr_no() {
        return endr_no;
    }

    public void setEndr_cover_from_date(Date endr_cover_from_date) {
        this.endr_cover_from_date = endr_cover_from_date;
    }

    public Date getEndr_cover_from_date() {
        return endr_cover_from_date;
    }

    public void setEndr_cover_to_date(Date endr_cover_to_date) {
        this.endr_cover_to_date = endr_cover_to_date;
    }

    public Date getEndr_cover_to_date() {
        return endr_cover_to_date;
    }

    public void setEndr_authorization_date(Date endr_authorization_date) {
        this.endr_authorization_date = endr_authorization_date;
    }

    public Date getEndr_authorization_date() {
        return endr_authorization_date;
    }

    public void setEndr_prepared_by(String endr_prepared_by) {
        this.endr_prepared_by = endr_prepared_by;
    }

    public String getEndr_prepared_by() {
        return endr_prepared_by;
    }

    public void setEndr_authorized_by(String endr_authorized_by) {
        this.endr_authorized_by = endr_authorized_by;
    }

    public String getEndr_authorized_by() {
        return endr_authorized_by;
    }

    public void setEndr_code(BigDecimal endr_code) {
        this.endr_code = endr_code;
    }

    public BigDecimal getEndr_code() {
        return endr_code;
    }

    public void setBtr_trans_type(String btr_trans_type) {
        this.btr_trans_type = btr_trans_type;
    }

    public String getBtr_trans_type() {
        return btr_trans_type;
    }


    public void setOriginal_loan_amt(BigDecimal original_loan_amt) {
        this.original_loan_amt = original_loan_amt;
    }

    public BigDecimal getOriginal_loan_amt() {
        return original_loan_amt;
    }

    public void setOrig_loan_repayment_prd(BigDecimal orig_loan_repayment_prd) {
        this.orig_loan_repayment_prd = orig_loan_repayment_prd;
    }

    public BigDecimal getOrig_loan_repayment_prd() {
        return orig_loan_repayment_prd;
    }

    public void setLoan_issue_date(Date loan_issue_date) {
        this.loan_issue_date = loan_issue_date;
    }

    public Date getLoan_issue_date() {
        return loan_issue_date;
    }

    public void setPmem_phone_no(String pmem_phone_no) {
        this.pmem_phone_no = pmem_phone_no;
    }

    public String getPmem_phone_no() {
        return pmem_phone_no;
    }

    public void setPmem_email_address(String pmem_email_address) {
        this.pmem_email_address = pmem_email_address;
    }

    public String getPmem_email_address() {
        return pmem_email_address;
    }
}
