package LMSG.view.Pensions;

import java.math.BigDecimal;

import java.util.Date;

public class pension {
   
   //pension Policies
    private String POL_POLICY_NO;
    private String CLIENT;
    private BigDecimal POL_CODE;
    private String POL_INCEPTION_UWYR;
    private String POL_STATUS;
    private Date POL_PAID_TO_DATE;
    private BigDecimal POL_CURRENT_ENDR_CODE;
    private String PNDP_AMT_RATE;
    private BigDecimal PNDP_TAX_AMT;
    private String PDED_DEDCT_TAX; 
    private String PDED_DEDCT_LOST_INT;
    private String PDED_EST_ACTUAL; 
    private String PDED_RT_AMT_TYPE;
    private BigDecimal PDED_NET_AMOUNT;
    
    private Date PNBALP_WEF;
    private Date PNBALP_WET;
    private BigDecimal PNBALP_CODE;
    private BigDecimal PNDP_GRCT_CODE;
    private BigDecimal pmpns_code;
    
    private BigDecimal emyr_reg_amount;
    private BigDecimal emye_reg_amount;        
    private BigDecimal emyr_unreg_amount;
    private BigDecimal emye_unreg_amount;  
    
  private BigDecimal PNBAL_SCHEME_FUND_BF;
  private BigDecimal PNBAL_TOTAL_DEDUCTIONS;
  private BigDecimal PNBAL_SCHEME_FUND;
  private BigDecimal PNBAL_EMPYR_RETIRE_HELD;
  private BigDecimal PNBAL_TOTAL_FUND_BAL;
    
  private BigDecimal PNDPI_CODE;
  private BigDecimal PNDPI_APP_INTR;
  private BigDecimal PNDPI_CF_INTR_AMT;
  private BigDecimal PNDPI_TOT_AMT;
  private BigDecimal PNDPI_PRINCIPAL;
  private Date PNDPI_WEF;
  private Date PNDPI_WET;
  private BigDecimal PNDPI_EMPYR_AMT;
  private BigDecimal PNDPI_EMPYE_AMT;
  
    
    //pension Balances
    private String PNBAL_YEAR;
    private Date PNBAL_VALUA_DATE;
    private String PNBAL_INTEREST_RATE;
    private String STATUS;
    private Date VALUE_DATE;
    private BigDecimal PNBAL_EMPYR_BAL_BF;
    private BigDecimal PNBAL_EMPYR_AMT;
    private BigDecimal PNBAL_EMPYR_VOL_AMT;
    private BigDecimal PNBAL_EMPYR_WITH_AMT;
    private BigDecimal PNBAL_EMPYR_CNTRI_INCOME;
    private BigDecimal PNBAL_EMPYR_BAL_INCOME;
    private BigDecimal PNBAL_EMPYR_BAL_CF;
    private BigDecimal PNBAL_EMPYE_BAL_BF;
    private BigDecimal PNBAL_EMPYE_AMT;
    private BigDecimal PNBAL_EMPYE_VOL_AMT;
    private BigDecimal PNBAL_EMPYE_WITH_AMT;
    private BigDecimal PNBAL_EMPYE_CNTRI_INCOME;
    private BigDecimal PNBAL_EMPYE_BAL_INCOME;
    private BigDecimal PNBAL_EMPYE_BAL_CF;
    private BigDecimal PNBAL_TOT_AMT;
    private BigDecimal WITHDRAWAL_TOT;
    private BigDecimal PNBAL_TOT_BAL_CF;
    private String PNBAL_PERIOD;
    private String PNBAL_AUTHORISED_BY;
    private Date PNBAL_AUTHORISED_DATE;
    private BigDecimal PNBALP_LPNT_CODE;
    private String LPNT_DESC;
    private BigDecimal PNBALP_ERND_EMPYR_BAL_INC;
    private BigDecimal PNBALP_ERND_EMPYE_BAL_INC;
    private BigDecimal PNBALP_ERND_EMPYR_CONTRI_INC;
    private BigDecimal PNBALP_ERND_EMPYE_CONTRI_INC;
    private BigDecimal PNMDP_EMPYR_REG_AMT;
    private BigDecimal PNMDP_EMPYE_REG_AMT;
    private BigDecimal PNMDP_EMPYR_NON_REG_AMT;
    private BigDecimal PNMDP_EMPYE_NON_REG_AMT;
    
    //Pension Deductions
    private String PDED_TT_SHT_DESC;
    private Date PDED_DATE;
    private String PDED_YEAR;
    private String PDED_MONTH;
    private String PDED_TAXABLE_AMT;
    private String PDED_RATE;
    private String PDED_TAX_AMT;
    private String PDED_AUTHORIZED;
    private String AUTHORISED;
    private String TT_DESC;
    private BigDecimal SEL_PDED_CODE;
    
    //Authorised Pension Deductions
    private String AUTH_PDED_TT_SHT_DESC;
    private Date AUTH_PDED_DATE;
    private String AUTH_PDED_YEAR;
    private String AUTH_PDED_MONTH;
    private String AUTH_PDED_TAXABLE_AMT;
    private String AUTH_PDED_RATE;
    private String AUTH_PDED_TAX_AMT;
    private String AUTH_PDED_AUTHORIZED;
    private String AUTH_AUTHORISED;
    private String AUTH_TT_DESC;
    private BigDecimal AUTH_SEL_PDED_CODE;
    
    //Pension Deposits
    private BigDecimal PNDP_CODE;
    private Date PNDP_DATE;
    private String PNDP_MNTH; 
    private String PNDP_YEAR;
    private String PNDP_AMOUNT;
    private String PNDP_WTHDL_RATE;
    private String PNDP_EMPYR_AMT;
    private String PNDP_EMPYE_AMT;
    private String PNDP_EMPYE_VOL_AMT;
    private String PNDP_EMPYR_VOL_AMT;
    private String PNDP_TOT_AMT;
    private String PNDP_REG_AMT;
    private String PNDP_NON_REG_AMT;
    private String PNDP_STATUS;
    private String PNDP_CHQ_RCPT_NO;
    private String PNDP_PAYEE;
    
    //Member Pension Deposits
    private BigDecimal PNMDP_CODE;
    private BigDecimal PNMDP_POLM_CODE;
    private String MEM_NO_DISPLAY;
    private String MEM_NAME;
    private String PNMDP_EMPYR_AMT;
    private String PNMDP_EMPYE_AMT;
    private String PNMDP_EMPYE_VOL_AMT;
    private String PNMDP_EMPYR_VOL_AMT;
    private String PNMDP_TOT_AMT;
    private String PNMDP_REG_AMT;
    private String PNMDP_NON_REG_AMT;
    
    //distributed member amounts
    private BigDecimal pmpnsCode;
    private BigDecimal pmpnsPolmCode;
    private String memberNumber;
    private BigDecimal paidAmount;
    private BigDecimal paidErAmount;
    private BigDecimal pmpnsEarnings;
    private BigDecimal paidEeAmount;
    private BigDecimal paidErVolAmt;
    private BigDecimal paidEeVolAmt;
    private BigDecimal allocatedAmount;
    private BigDecimal earnings;
    private BigDecimal pmpnsEmpyrContr;
    private BigDecimal pmpnsEmpyeContr;
    //private String memberNumber;
    private BigDecimal PPV_VOUCHER_NO;
    private Date PPV_DATE;
    private BigDecimal PPV_AMOUNT;
    private String PPV_PAYEE;
    private String PPV_RAISE_BY;
    private String PPV_STATUS;
    private String PPV_SOURCE;
    private String PPV_CHEQUE_NO;
    private Date PPV_CHEQUE_DATE;
    

    
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

    public void setPOL_CODE(BigDecimal POL_CODE) {
        this.POL_CODE = POL_CODE;
    }

    public BigDecimal getPOL_CODE() {
        return POL_CODE;
    }

    public void setPOL_INCEPTION_UWYR(String POL_INCEPTION_UWYR) {
        this.POL_INCEPTION_UWYR = POL_INCEPTION_UWYR;
    }

    public String getPOL_INCEPTION_UWYR() {
        return POL_INCEPTION_UWYR;
    }

    public void setPOL_STATUS(String POL_STATUS) {
        this.POL_STATUS = POL_STATUS;
    }

    public String getPOL_STATUS() {
        return POL_STATUS;
    }

    public void setPOL_PAID_TO_DATE(Date POL_PAID_TO_DATE) {
        this.POL_PAID_TO_DATE = POL_PAID_TO_DATE;
    }

    public Date getPOL_PAID_TO_DATE() {
        return POL_PAID_TO_DATE;
    }

    public void setPOL_CURRENT_ENDR_CODE(BigDecimal POL_CURRENT_ENDR_CODE) {
        this.POL_CURRENT_ENDR_CODE = POL_CURRENT_ENDR_CODE;
    }

    public BigDecimal getPOL_CURRENT_ENDR_CODE() {
        return POL_CURRENT_ENDR_CODE;
    }

    public void setPNBAL_YEAR(String PNBAL_YEAR) {
        this.PNBAL_YEAR = PNBAL_YEAR;
    }

    public String getPNBAL_YEAR() {
        return PNBAL_YEAR;
    }

    public void setPNBAL_VALUA_DATE(Date PNBAL_VALUA_DATE) {
        this.PNBAL_VALUA_DATE = PNBAL_VALUA_DATE;
    }

    public Date getPNBAL_VALUA_DATE() {
        return PNBAL_VALUA_DATE;
    }

    public void setPNBAL_INTEREST_RATE(String PNBAL_INTEREST_RATE) {
        this.PNBAL_INTEREST_RATE = PNBAL_INTEREST_RATE;
    }

    public String getPNBAL_INTEREST_RATE() {
        return PNBAL_INTEREST_RATE;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setVALUE_DATE(Date VALUE_DATE) {
        this.VALUE_DATE = VALUE_DATE;
    }

    public Date getVALUE_DATE() {
        return VALUE_DATE;
    }

    public void setPNBAL_EMPYR_BAL_BF(BigDecimal PNBAL_EMPYR_BAL_BF) {
        this.PNBAL_EMPYR_BAL_BF = PNBAL_EMPYR_BAL_BF;
    }

    public BigDecimal getPNBAL_EMPYR_BAL_BF() {
        return PNBAL_EMPYR_BAL_BF;
    }

    public void setPNBAL_EMPYR_AMT(BigDecimal PNBAL_EMPYR_AMT) {
        this.PNBAL_EMPYR_AMT = PNBAL_EMPYR_AMT;
    }

    public BigDecimal getPNBAL_EMPYR_AMT() {
        return PNBAL_EMPYR_AMT;
    }

    public void setPNBAL_EMPYR_VOL_AMT(BigDecimal PNBAL_EMPYR_VOL_AMT) {
        this.PNBAL_EMPYR_VOL_AMT = PNBAL_EMPYR_VOL_AMT;
    }

    public BigDecimal getPNBAL_EMPYR_VOL_AMT() {
        return PNBAL_EMPYR_VOL_AMT;
    }

    public void setPNBAL_EMPYR_WITH_AMT(BigDecimal PNBAL_EMPYR_WITH_AMT) {
        this.PNBAL_EMPYR_WITH_AMT = PNBAL_EMPYR_WITH_AMT;
    }

    public BigDecimal getPNBAL_EMPYR_WITH_AMT() {
        return PNBAL_EMPYR_WITH_AMT;
    }

    public void setPNBAL_EMPYR_CNTRI_INCOME(BigDecimal PNBAL_EMPYR_CNTRI_INCOME) {
        this.PNBAL_EMPYR_CNTRI_INCOME = PNBAL_EMPYR_CNTRI_INCOME;
    }

    public BigDecimal getPNBAL_EMPYR_CNTRI_INCOME() {
        return PNBAL_EMPYR_CNTRI_INCOME;
    }

    public void setPNBAL_EMPYR_BAL_INCOME(BigDecimal PNBAL_EMPYR_BAL_INCOME) {
        this.PNBAL_EMPYR_BAL_INCOME = PNBAL_EMPYR_BAL_INCOME;
    }

    public BigDecimal getPNBAL_EMPYR_BAL_INCOME() {
        return PNBAL_EMPYR_BAL_INCOME;
    }

    public void setPNBAL_EMPYR_BAL_CF(BigDecimal PNBAL_EMPYR_BAL_CF) {
        this.PNBAL_EMPYR_BAL_CF = PNBAL_EMPYR_BAL_CF;
    }

    public BigDecimal getPNBAL_EMPYR_BAL_CF() {
        return PNBAL_EMPYR_BAL_CF;
    }

    public void setPNBAL_EMPYE_BAL_BF(BigDecimal PNBAL_EMPYE_BAL_BF) {
        this.PNBAL_EMPYE_BAL_BF = PNBAL_EMPYE_BAL_BF;
    }

    public BigDecimal getPNBAL_EMPYE_BAL_BF() {
        return PNBAL_EMPYE_BAL_BF;
    }

    public void setPNBAL_EMPYE_AMT(BigDecimal PNBAL_EMPYE_AMT) {
        this.PNBAL_EMPYE_AMT = PNBAL_EMPYE_AMT;
    }

    public BigDecimal getPNBAL_EMPYE_AMT() {
        return PNBAL_EMPYE_AMT;
    }

    public void setPNBAL_EMPYE_VOL_AMT(BigDecimal PNBAL_EMPYE_VOL_AMT) {
        this.PNBAL_EMPYE_VOL_AMT = PNBAL_EMPYE_VOL_AMT;
    }

    public BigDecimal getPNBAL_EMPYE_VOL_AMT() {
        return PNBAL_EMPYE_VOL_AMT;
    }

    public void setPNBAL_EMPYE_WITH_AMT(BigDecimal PNBAL_EMPYE_WITH_AMT) {
        this.PNBAL_EMPYE_WITH_AMT = PNBAL_EMPYE_WITH_AMT;
    }

    public BigDecimal getPNBAL_EMPYE_WITH_AMT() {
        return PNBAL_EMPYE_WITH_AMT;
    }

    public void setPNBAL_EMPYE_CNTRI_INCOME(BigDecimal PNBAL_EMPYE_CNTRI_INCOME) {
        this.PNBAL_EMPYE_CNTRI_INCOME = PNBAL_EMPYE_CNTRI_INCOME;
    }

    public BigDecimal getPNBAL_EMPYE_CNTRI_INCOME() {
        return PNBAL_EMPYE_CNTRI_INCOME;
    }

    public void setPNBAL_EMPYE_BAL_INCOME(BigDecimal PNBAL_EMPYE_BAL_INCOME) {
        this.PNBAL_EMPYE_BAL_INCOME = PNBAL_EMPYE_BAL_INCOME;
    }

    public BigDecimal getPNBAL_EMPYE_BAL_INCOME() {
        return PNBAL_EMPYE_BAL_INCOME;
    }

    public void setPNBAL_EMPYE_BAL_CF(BigDecimal PNBAL_EMPYE_BAL_CF) {
        this.PNBAL_EMPYE_BAL_CF = PNBAL_EMPYE_BAL_CF;
    }

    public BigDecimal getPNBAL_EMPYE_BAL_CF() {
        return PNBAL_EMPYE_BAL_CF;
    }

    public void setPNBAL_TOT_AMT(BigDecimal PNBAL_TOT_AMT) {
        this.PNBAL_TOT_AMT = PNBAL_TOT_AMT;
    }

    public BigDecimal getPNBAL_TOT_AMT() {
        return PNBAL_TOT_AMT;
    }

    public void setWITHDRAWAL_TOT(BigDecimal WITHDRAWAL_TOT) {
        this.WITHDRAWAL_TOT = WITHDRAWAL_TOT;
    }

    public BigDecimal getWITHDRAWAL_TOT() {
        return WITHDRAWAL_TOT;
    }

    public void setPNBAL_TOT_BAL_CF(BigDecimal PNBAL_TOT_BAL_CF) {
        this.PNBAL_TOT_BAL_CF = PNBAL_TOT_BAL_CF;
    }

    public BigDecimal getPNBAL_TOT_BAL_CF() {
        return PNBAL_TOT_BAL_CF;
    }

    public void setPDED_TT_SHT_DESC(String PDED_TT_SHT_DESC) {
        this.PDED_TT_SHT_DESC = PDED_TT_SHT_DESC;
    }

    public String getPDED_TT_SHT_DESC() {
        return PDED_TT_SHT_DESC;
    }

    public void setPDED_DATE(Date PDED_DATE) {
        this.PDED_DATE = PDED_DATE;
    }

    public Date getPDED_DATE() {
        return PDED_DATE;
    }

    public void setPDED_YEAR(String PDED_YEAR) {
        this.PDED_YEAR = PDED_YEAR;
    }

    public String getPDED_YEAR() {
        return PDED_YEAR;
    }

    public void setPDED_MONTH(String PDED_MONTH) {
        this.PDED_MONTH = PDED_MONTH;
    }

    public String getPDED_MONTH() {
        return PDED_MONTH;
    }

    public void setPDED_TAXABLE_AMT(String PDED_TAXABLE_AMT) {
        this.PDED_TAXABLE_AMT = PDED_TAXABLE_AMT;
    }

    public String getPDED_TAXABLE_AMT() {
        return PDED_TAXABLE_AMT;
    }

    public void setPDED_RATE(String PDED_RATE) {
        this.PDED_RATE = PDED_RATE;
    }

    public String getPDED_RATE() {
        return PDED_RATE;
    }

    public void setPDED_TAX_AMT(String PDED_TAX_AMT) {
        this.PDED_TAX_AMT = PDED_TAX_AMT;
    }

    public String getPDED_TAX_AMT() {
        return PDED_TAX_AMT;
    }

    public void setPDED_AUTHORIZED(String PDED_AUTHORIZED) {
        this.PDED_AUTHORIZED = PDED_AUTHORIZED;
    }

    public String getPDED_AUTHORIZED() {
        return PDED_AUTHORIZED;
    }

    public void setAUTHORISED(String AUTHORISED) {
        this.AUTHORISED = AUTHORISED;
    }

    public String getAUTHORISED() {
        return AUTHORISED;
    }

    public void setTT_DESC(String TT_DESC) {
        this.TT_DESC = TT_DESC;
    }

    public String getTT_DESC() {
        return TT_DESC;
    }

    public void setSEL_PDED_CODE(BigDecimal SEL_PDED_CODE) {
        this.SEL_PDED_CODE = SEL_PDED_CODE;
    }

    public BigDecimal getSEL_PDED_CODE() {
        return SEL_PDED_CODE;
    }

    public void setAUTH_PDED_TT_SHT_DESC(String AUTH_PDED_TT_SHT_DESC) {
        this.AUTH_PDED_TT_SHT_DESC = AUTH_PDED_TT_SHT_DESC;
    }

    public String getAUTH_PDED_TT_SHT_DESC() {
        return AUTH_PDED_TT_SHT_DESC;
    }

    public void setAUTH_PDED_DATE(Date AUTH_PDED_DATE) {
        this.AUTH_PDED_DATE = AUTH_PDED_DATE;
    }

    public Date getAUTH_PDED_DATE() {
        return AUTH_PDED_DATE;
    }

    public void setAUTH_PDED_YEAR(String AUTH_PDED_YEAR) {
        this.AUTH_PDED_YEAR = AUTH_PDED_YEAR;
    }

    public String getAUTH_PDED_YEAR() {
        return AUTH_PDED_YEAR;
    }

    public void setAUTH_PDED_MONTH(String AUTH_PDED_MONTH) {
        this.AUTH_PDED_MONTH = AUTH_PDED_MONTH;
    }

    public String getAUTH_PDED_MONTH() {
        return AUTH_PDED_MONTH;
    }

    public void setAUTH_PDED_TAXABLE_AMT(String AUTH_PDED_TAXABLE_AMT) {
        this.AUTH_PDED_TAXABLE_AMT = AUTH_PDED_TAXABLE_AMT;
    }

    public String getAUTH_PDED_TAXABLE_AMT() {
        return AUTH_PDED_TAXABLE_AMT;
    }

    public void setAUTH_PDED_RATE(String AUTH_PDED_RATE) {
        this.AUTH_PDED_RATE = AUTH_PDED_RATE;
    }

    public String getAUTH_PDED_RATE() {
        return AUTH_PDED_RATE;
    }

    public void setAUTH_PDED_TAX_AMT(String AUTH_PDED_TAX_AMT) {
        this.AUTH_PDED_TAX_AMT = AUTH_PDED_TAX_AMT;
    }

    public String getAUTH_PDED_TAX_AMT() {
        return AUTH_PDED_TAX_AMT;
    }

    public void setAUTH_PDED_AUTHORIZED(String AUTH_PDED_AUTHORIZED) {
        this.AUTH_PDED_AUTHORIZED = AUTH_PDED_AUTHORIZED;
    }

    public String getAUTH_PDED_AUTHORIZED() {
        return AUTH_PDED_AUTHORIZED;
    }

    public void setAUTH_AUTHORISED(String AUTH_AUTHORISED) {
        this.AUTH_AUTHORISED = AUTH_AUTHORISED;
    }

    public String getAUTH_AUTHORISED() {
        return AUTH_AUTHORISED;
    }

    public void setAUTH_TT_DESC(String AUTH_TT_DESC) {
        this.AUTH_TT_DESC = AUTH_TT_DESC;
    }

    public String getAUTH_TT_DESC() {
        return AUTH_TT_DESC;
    }

    public void setAUTH_SEL_PDED_CODE(BigDecimal AUTH_SEL_PDED_CODE) {
        this.AUTH_SEL_PDED_CODE = AUTH_SEL_PDED_CODE;
    }

    public BigDecimal getAUTH_SEL_PDED_CODE() {
        return AUTH_SEL_PDED_CODE;
    }

    public void setPNDP_CODE(BigDecimal PNDP_CODE) {
        this.PNDP_CODE = PNDP_CODE;
    }

    public BigDecimal getPNDP_CODE() {
        return PNDP_CODE;
    }

    public void setPNDP_DATE(Date PNDP_DATE) {
        this.PNDP_DATE = PNDP_DATE;
    }

    public Date getPNDP_DATE() {
        return PNDP_DATE;
    }

    public void setPNDP_MNTH(String PNDP_MNTH) {
        this.PNDP_MNTH = PNDP_MNTH;
    }

    public String getPNDP_MNTH() {
        return PNDP_MNTH;
    }

    public void setPNDP_YEAR(String PNDP_YEAR) {
        this.PNDP_YEAR = PNDP_YEAR;
    }

    public String getPNDP_YEAR() {
        return PNDP_YEAR;
    }

    public void setPNDP_AMOUNT(String PNDP_AMOUNT) {
        this.PNDP_AMOUNT = PNDP_AMOUNT;
    }

    public String getPNDP_AMOUNT() {
        return PNDP_AMOUNT;
    }

    public void setPNDP_WTHDL_RATE(String PNDP_WTHDL_RATE) {
        this.PNDP_WTHDL_RATE = PNDP_WTHDL_RATE;
    }

    public String getPNDP_WTHDL_RATE() {
        return PNDP_WTHDL_RATE;
    }

    public void setPNDP_EMPYR_AMT(String PNDP_EMPYR_AMT) {
        this.PNDP_EMPYR_AMT = PNDP_EMPYR_AMT;
    }

    public String getPNDP_EMPYR_AMT() {
        return PNDP_EMPYR_AMT;
    }

    public void setPNDP_EMPYE_AMT(String PNDP_EMPYE_AMT) {
        this.PNDP_EMPYE_AMT = PNDP_EMPYE_AMT;
    }

    public String getPNDP_EMPYE_AMT() {
        return PNDP_EMPYE_AMT;
    }

    public void setPNDP_EMPYE_VOL_AMT(String PNDP_EMPYE_VOL_AMT) {
        this.PNDP_EMPYE_VOL_AMT = PNDP_EMPYE_VOL_AMT;
    }

    public String getPNDP_EMPYE_VOL_AMT() {
        return PNDP_EMPYE_VOL_AMT;
    }

    public void setPNDP_EMPYR_VOL_AMT(String PNDP_EMPYR_VOL_AMT) {
        this.PNDP_EMPYR_VOL_AMT = PNDP_EMPYR_VOL_AMT;
    }

    public String getPNDP_EMPYR_VOL_AMT() {
        return PNDP_EMPYR_VOL_AMT;
    }

    public void setPNDP_TOT_AMT(String PNDP_TOT_AMT) {
        this.PNDP_TOT_AMT = PNDP_TOT_AMT;
    }

    public String getPNDP_TOT_AMT() {
        return PNDP_TOT_AMT;
    }

    public void setPNDP_REG_AMT(String PNDP_REG_AMT) {
        this.PNDP_REG_AMT = PNDP_REG_AMT;
    }

    public String getPNDP_REG_AMT() {
        return PNDP_REG_AMT;
    }

    public void setPNDP_NON_REG_AMT(String PNDP_NON_REG_AMT) {
        this.PNDP_NON_REG_AMT = PNDP_NON_REG_AMT;
    }

    public String getPNDP_NON_REG_AMT() {
        return PNDP_NON_REG_AMT;
    }

    public void setPNMDP_CODE(BigDecimal PNMDP_CODE) {
        this.PNMDP_CODE = PNMDP_CODE;
    }

    public BigDecimal getPNMDP_CODE() {
        return PNMDP_CODE;
    }

    public void setPNMDP_POLM_CODE(BigDecimal PNMDP_POLM_CODE) {
        this.PNMDP_POLM_CODE = PNMDP_POLM_CODE;
    }

    public BigDecimal getPNMDP_POLM_CODE() {
        return PNMDP_POLM_CODE;
    }

    public void setMEM_NO_DISPLAY(String MEM_NO_DISPLAY) {
        this.MEM_NO_DISPLAY = MEM_NO_DISPLAY;
    }

    public String getMEM_NO_DISPLAY() {
        return MEM_NO_DISPLAY;
    }

    public void setMEM_NAME(String MEM_NAME) {
        this.MEM_NAME = MEM_NAME;
    }

    public String getMEM_NAME() {
        return MEM_NAME;
    }

    public void setPNMDP_EMPYR_AMT(String PNMDP_EMPYR_AMT) {
        this.PNMDP_EMPYR_AMT = PNMDP_EMPYR_AMT;
    }

    public String getPNMDP_EMPYR_AMT() {
        return PNMDP_EMPYR_AMT;
    }

    public void setPNMDP_EMPYE_AMT(String PNMDP_EMPYE_AMT) {
        this.PNMDP_EMPYE_AMT = PNMDP_EMPYE_AMT;
    }

    public String getPNMDP_EMPYE_AMT() {
        return PNMDP_EMPYE_AMT;
    }

    public void setPNMDP_EMPYE_VOL_AMT(String PNMDP_EMPYE_VOL_AMT) {
        this.PNMDP_EMPYE_VOL_AMT = PNMDP_EMPYE_VOL_AMT;
    }

    public String getPNMDP_EMPYE_VOL_AMT() {
        return PNMDP_EMPYE_VOL_AMT;
    }

    public void setPNMDP_EMPYR_VOL_AMT(String PNMDP_EMPYR_VOL_AMT) {
        this.PNMDP_EMPYR_VOL_AMT = PNMDP_EMPYR_VOL_AMT;
    }

    public String getPNMDP_EMPYR_VOL_AMT() {
        return PNMDP_EMPYR_VOL_AMT;
    }

    public void setPNMDP_TOT_AMT(String PNMDP_TOT_AMT) {
        this.PNMDP_TOT_AMT = PNMDP_TOT_AMT;
    }

    public String getPNMDP_TOT_AMT() {
        return PNMDP_TOT_AMT;
    }

    public void setPNDP_STATUS(String PNDP_STATUS) {
        this.PNDP_STATUS = PNDP_STATUS;
    }

    public String getPNDP_STATUS() {
        return PNDP_STATUS;
    }

    public void setPNDP_CHQ_RCPT_NO(String PNDP_CHQ_RCPT_NO) {
        this.PNDP_CHQ_RCPT_NO = PNDP_CHQ_RCPT_NO;
    }

    public String getPNDP_CHQ_RCPT_NO() {
        return PNDP_CHQ_RCPT_NO;
    }

    public void setPNMDP_REG_AMT(String PNMDP_REG_AMT) {
        this.PNMDP_REG_AMT = PNMDP_REG_AMT;
    }

    public String getPNMDP_REG_AMT() {
        return PNMDP_REG_AMT;
    }

    public void setPNMDP_NON_REG_AMT(String PNMDP_NON_REG_AMT) {
        this.PNMDP_NON_REG_AMT = PNMDP_NON_REG_AMT;
    }

    public String getPNMDP_NON_REG_AMT() {
        return PNMDP_NON_REG_AMT;
    }

    public void setPNDP_PAYEE(String PNDP_PAYEE) {
        this.PNDP_PAYEE = PNDP_PAYEE;
    }

    public String getPNDP_PAYEE() {
        return PNDP_PAYEE;
    }

    public void setPmpnsCode(BigDecimal pmpnsCode) {
        this.pmpnsCode = pmpnsCode;
    }

    public BigDecimal getPmpnsCode() {
        return pmpnsCode;
    }

    public void setPmpnsPolmCode(BigDecimal pmpnsPolmCode) {
        this.pmpnsPolmCode = pmpnsPolmCode;
    }

    public BigDecimal getPmpnsPolmCode() {
        return pmpnsPolmCode;
    }

   /* public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }*/

   /* public String getMemberNumber() {
        return memberNumber;
    }*/

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidErAmount(BigDecimal paidErAmount) {
        this.paidErAmount = paidErAmount;
    }

    public BigDecimal getPaidErAmount() {
        return paidErAmount;
    }

    public void setPmpnsEarnings(BigDecimal pmpnsEarnings) {
        this.pmpnsEarnings = pmpnsEarnings;
    }

    public BigDecimal getPmpnsEarnings() {
        return pmpnsEarnings;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setPaidEeAmount(BigDecimal paidEeAmount) {
        this.paidEeAmount = paidEeAmount;
    }

    public BigDecimal getPaidEeAmount() {
        return paidEeAmount;
    }

    public void setPaidErVolAmt(BigDecimal paidErVolAmt) {
        this.paidErVolAmt = paidErVolAmt;
    }

    public BigDecimal getPaidErVolAmt() {
        return paidErVolAmt;
    }

    public void setPaidEeVolAmt(BigDecimal paidEeVolAmt) {
        this.paidEeVolAmt = paidEeVolAmt;
    }

    public BigDecimal getPaidEeVolAmt() {
        return paidEeVolAmt;
    }

    public void setAllocatedAmount(BigDecimal allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public BigDecimal getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }

    public BigDecimal getEarnings() {
        return earnings;
    }

    public void setPmpnsEmpyrContr(BigDecimal pmpnsEmpyrContr) {
        this.pmpnsEmpyrContr = pmpnsEmpyrContr;
    }

    public BigDecimal getPmpnsEmpyrContr() {
        return pmpnsEmpyrContr;
    }

    public void setPmpnsEmpyeContr(BigDecimal pmpnsEmpyeContr) {
        this.pmpnsEmpyeContr = pmpnsEmpyeContr;
    }

    public BigDecimal getPmpnsEmpyeContr() {
        return pmpnsEmpyeContr;
    }

    public void setPNBAL_PERIOD(String PNBAL_PERIOD) {
        this.PNBAL_PERIOD = PNBAL_PERIOD;
    }

    public String getPNBAL_PERIOD() {
        return PNBAL_PERIOD;
    }

    public void setPNBAL_AUTHORISED_BY(String PNBAL_AUTHORISED_BY) {
        this.PNBAL_AUTHORISED_BY = PNBAL_AUTHORISED_BY;
    }

    public String getPNBAL_AUTHORISED_BY() {
        return PNBAL_AUTHORISED_BY;
    }

    public void setPNBAL_AUTHORISED_DATE(Date PNBAL_AUTHORISED_DATE) {
        this.PNBAL_AUTHORISED_DATE = PNBAL_AUTHORISED_DATE;
    }

    public Date getPNBAL_AUTHORISED_DATE() {
        return PNBAL_AUTHORISED_DATE;
    }

    public void setPNBALP_LPNT_CODE(BigDecimal PNBALP_LPNT_CODE) {
        this.PNBALP_LPNT_CODE = PNBALP_LPNT_CODE;
    }

    public BigDecimal getPNBALP_LPNT_CODE() {
        return PNBALP_LPNT_CODE;
    }

    public void setLPNT_DESC(String LPNT_DESC) {
        this.LPNT_DESC = LPNT_DESC;
    }

    public String getLPNT_DESC() {
        return LPNT_DESC;
    }

    public void setPNBALP_WEF(Date PNBALP_WEF) {
        this.PNBALP_WEF = PNBALP_WEF;
    }

    public Date getPNBALP_WEF() {
        return PNBALP_WEF;
    }

    public void setPNBALP_WET(Date PNBALP_WET) {
        this.PNBALP_WET = PNBALP_WET;
    }

    public Date getPNBALP_WET() {
        return PNBALP_WET;
    }

    public void setPNBALP_CODE(BigDecimal PNBALP_CODE) {
        this.PNBALP_CODE = PNBALP_CODE;
    }

    public BigDecimal getPNBALP_CODE() {
        return PNBALP_CODE;
    }

    public void setPNDP_GRCT_CODE(BigDecimal PNDP_GRCT_CODE) {
        this.PNDP_GRCT_CODE = PNDP_GRCT_CODE;
    }

    public BigDecimal getPNDP_GRCT_CODE() {
        return PNDP_GRCT_CODE;
    }

    public void setPNDPI_CODE(BigDecimal PNDPI_CODE) {
        this.PNDPI_CODE = PNDPI_CODE;
    }

    public BigDecimal getPNDPI_CODE() {
        return PNDPI_CODE;
    }

    public void setPNDPI_APP_INTR(BigDecimal PNDPI_APP_INTR) {
        this.PNDPI_APP_INTR = PNDPI_APP_INTR;
    }

    public BigDecimal getPNDPI_APP_INTR() {
        return PNDPI_APP_INTR;
    }

    public void setPNDPI_CF_INTR_AMT(BigDecimal PNDPI_CF_INTR_AMT) {
        this.PNDPI_CF_INTR_AMT = PNDPI_CF_INTR_AMT;
    }

    public BigDecimal getPNDPI_CF_INTR_AMT() {
        return PNDPI_CF_INTR_AMT;
    }

    public void setPNDPI_TOT_AMT(BigDecimal PNDPI_TOT_AMT) {
        this.PNDPI_TOT_AMT = PNDPI_TOT_AMT;
    }

    public BigDecimal getPNDPI_TOT_AMT() {
        return PNDPI_TOT_AMT;
    }

    public void setPNDPI_PRINCIPAL(BigDecimal PNDPI_PRINCIPAL) {
        this.PNDPI_PRINCIPAL = PNDPI_PRINCIPAL;
    }

    public BigDecimal getPNDPI_PRINCIPAL() {
        return PNDPI_PRINCIPAL;
    }

    public void setPNDPI_WEF(Date PNDPI_WEF) {
        this.PNDPI_WEF = PNDPI_WEF;
    }

    public Date getPNDPI_WEF() {
        return PNDPI_WEF;
    }

    public void setPNDPI_WET(Date PNDPI_WET) {
        this.PNDPI_WET = PNDPI_WET;
    }

    public Date getPNDPI_WET() {
        return PNDPI_WET;
    }

    public void setPNDPI_EMPYR_AMT(BigDecimal PNDPI_EMPYR_AMT) {
        this.PNDPI_EMPYR_AMT = PNDPI_EMPYR_AMT;
    }

    public BigDecimal getPNDPI_EMPYR_AMT() {
        return PNDPI_EMPYR_AMT;
    }

    public void setPNDPI_EMPYE_AMT(BigDecimal PNDPI_EMPYE_AMT) {
        this.PNDPI_EMPYE_AMT = PNDPI_EMPYE_AMT;
    }

    public BigDecimal getPNDPI_EMPYE_AMT() {
        return PNDPI_EMPYE_AMT;
    }

    public void setPmpns_code(BigDecimal pmpns_code) {
        this.pmpns_code = pmpns_code;
    }

    public BigDecimal getPmpns_code() {
        return pmpns_code;
    }

    public void setPNDP_AMT_RATE(String PNDP_AMT_RATE) {
        this.PNDP_AMT_RATE = PNDP_AMT_RATE;
    }

    public String getPNDP_AMT_RATE() {
        return PNDP_AMT_RATE;
    }

    public void setPNBALP_ERND_EMPYR_BAL_INC(BigDecimal PNBALP_ERND_EMPYR_BAL_INC) {
        this.PNBALP_ERND_EMPYR_BAL_INC = PNBALP_ERND_EMPYR_BAL_INC;
    }

    public BigDecimal getPNBALP_ERND_EMPYR_BAL_INC() {
        return PNBALP_ERND_EMPYR_BAL_INC;
    }

    public void setPNBALP_ERND_EMPYE_BAL_INC(BigDecimal PNBALP_ERND_EMPYE_BAL_INC) {
        this.PNBALP_ERND_EMPYE_BAL_INC = PNBALP_ERND_EMPYE_BAL_INC;
    }

    public BigDecimal getPNBALP_ERND_EMPYE_BAL_INC() {
        return PNBALP_ERND_EMPYE_BAL_INC;
    }

    public void setPNBALP_ERND_EMPYR_CONTRI_INC(BigDecimal PNBALP_ERND_EMPYR_CONTRI_INC) {
        this.PNBALP_ERND_EMPYR_CONTRI_INC = PNBALP_ERND_EMPYR_CONTRI_INC;
    }

    public BigDecimal getPNBALP_ERND_EMPYR_CONTRI_INC() {
        return PNBALP_ERND_EMPYR_CONTRI_INC;
    }

    public void setPNBALP_ERND_EMPYE_CONTRI_INC(BigDecimal PNBALP_ERND_EMPYE_CONTRI_INC) {
        this.PNBALP_ERND_EMPYE_CONTRI_INC = PNBALP_ERND_EMPYE_CONTRI_INC;
    }

    public BigDecimal getPNBALP_ERND_EMPYE_CONTRI_INC() {
        return PNBALP_ERND_EMPYE_CONTRI_INC;
    }

    public void setPNMDP_EMPYR_REG_AMT(BigDecimal PNMDP_EMPYR_REG_AMT) {
        this.PNMDP_EMPYR_REG_AMT = PNMDP_EMPYR_REG_AMT;
    }

    public BigDecimal getPNMDP_EMPYR_REG_AMT() {
        return PNMDP_EMPYR_REG_AMT;
    }

    public void setPNMDP_EMPYE_REG_AMT(BigDecimal PNMDP_EMPYE_REG_AMT) {
        this.PNMDP_EMPYE_REG_AMT = PNMDP_EMPYE_REG_AMT;
    }

    public BigDecimal getPNMDP_EMPYE_REG_AMT() {
        return PNMDP_EMPYE_REG_AMT;
    }

    public void setPNMDP_EMPYR_NON_REG_AMT(BigDecimal PNMDP_EMPYR_NON_REG_AMT) {
        this.PNMDP_EMPYR_NON_REG_AMT = PNMDP_EMPYR_NON_REG_AMT;
    }

    public BigDecimal getPNMDP_EMPYR_NON_REG_AMT() {
        return PNMDP_EMPYR_NON_REG_AMT;
    }

    public void setPNMDP_EMPYE_NON_REG_AMT(BigDecimal PNMDP_EMPYE_NON_REG_AMT) {
        this.PNMDP_EMPYE_NON_REG_AMT = PNMDP_EMPYE_NON_REG_AMT;
    }

    public BigDecimal getPNMDP_EMPYE_NON_REG_AMT() {
        return PNMDP_EMPYE_NON_REG_AMT;
    }

    public void setPNBAL_SCHEME_FUND_BF(BigDecimal PNBAL_SCHEME_FUND_BF) {
        this.PNBAL_SCHEME_FUND_BF = PNBAL_SCHEME_FUND_BF;
    }

    public BigDecimal getPNBAL_SCHEME_FUND_BF() {
        return PNBAL_SCHEME_FUND_BF;
    }

    public void setPNBAL_TOTAL_DEDUCTIONS(BigDecimal PNBAL_TOTAL_DEDUCTIONS) {
        this.PNBAL_TOTAL_DEDUCTIONS = PNBAL_TOTAL_DEDUCTIONS;
    }

    public BigDecimal getPNBAL_TOTAL_DEDUCTIONS() {
        return PNBAL_TOTAL_DEDUCTIONS;
    }

    public void setPNBAL_SCHEME_FUND(BigDecimal PNBAL_SCHEME_FUND) {
        this.PNBAL_SCHEME_FUND = PNBAL_SCHEME_FUND;
    }

    public BigDecimal getPNBAL_SCHEME_FUND() {
        return PNBAL_SCHEME_FUND;
    }

    public void setPNBAL_EMPYR_RETIRE_HELD(BigDecimal PNBAL_EMPYR_RETIRE_HELD) {
        this.PNBAL_EMPYR_RETIRE_HELD = PNBAL_EMPYR_RETIRE_HELD;
    }

    public BigDecimal getPNBAL_EMPYR_RETIRE_HELD() {
        return PNBAL_EMPYR_RETIRE_HELD;
    }

    public void setPNBAL_TOTAL_FUND_BAL(BigDecimal PNBAL_TOTAL_FUND_BAL) {
        this.PNBAL_TOTAL_FUND_BAL = PNBAL_TOTAL_FUND_BAL;
    }

    public BigDecimal getPNBAL_TOTAL_FUND_BAL() {
        return PNBAL_TOTAL_FUND_BAL;
    }

    public void setPPV_VOUCHER_NO(BigDecimal PPV_VOUCHER_NO) {
        this.PPV_VOUCHER_NO = PPV_VOUCHER_NO;
    }

    public BigDecimal getPPV_VOUCHER_NO() {
        return PPV_VOUCHER_NO;
    }

    public void setPPV_DATE(Date PPV_DATE) {
        this.PPV_DATE = PPV_DATE;
    }

    public Date getPPV_DATE() {
        return PPV_DATE;
    }

    public void setPPV_AMOUNT(BigDecimal PPV_AMOUNT) {
        this.PPV_AMOUNT = PPV_AMOUNT;
    }

    public BigDecimal getPPV_AMOUNT() {
        return PPV_AMOUNT;
    }

    public void setPPV_PAYEE(String PPV_PAYEE) {
        this.PPV_PAYEE = PPV_PAYEE;
    }

    public String getPPV_PAYEE() {
        return PPV_PAYEE;
    }

    public void setPPV_RAISE_BY(String PPV_RAISE_BY) {
        this.PPV_RAISE_BY = PPV_RAISE_BY;
    }

    public String getPPV_RAISE_BY() {
        return PPV_RAISE_BY;
    }

    public void setPPV_STATUS(String PPV_STATUS) {
        this.PPV_STATUS = PPV_STATUS;
    }

    public String getPPV_STATUS() {
        return PPV_STATUS;
    }

    public void setPPV_SOURCE(String PPV_SOURCE) {
        this.PPV_SOURCE = PPV_SOURCE;
    }

    public String getPPV_SOURCE() {
        return PPV_SOURCE;
    }

    public void setPPV_CHEQUE_NO(String PPV_CHEQUE_NO) {
        this.PPV_CHEQUE_NO = PPV_CHEQUE_NO;
    }

    public String getPPV_CHEQUE_NO() {
        return PPV_CHEQUE_NO;
    }

    public void setPPV_CHEQUE_DATE(Date PPV_CHEQUE_DATE) {
        this.PPV_CHEQUE_DATE = PPV_CHEQUE_DATE;
    }

    public Date getPPV_CHEQUE_DATE() {
        return PPV_CHEQUE_DATE;
    }

    public void setEmyr_reg_amount(BigDecimal emyr_reg_amount) {
        this.emyr_reg_amount = emyr_reg_amount;
    }

    public BigDecimal getEmyr_reg_amount() {
        return emyr_reg_amount;
    }

    public void setEmye_reg_amount(BigDecimal emye_reg_amount) {
        this.emye_reg_amount = emye_reg_amount;
    }

    public BigDecimal getEmye_reg_amount() {
        return emye_reg_amount;
    }

    public void setEmyr_unreg_amount(BigDecimal emyr_unreg_amount) {
        this.emyr_unreg_amount = emyr_unreg_amount;
    }

    public BigDecimal getEmyr_unreg_amount() {
        return emyr_unreg_amount;
    }

    public void setEmye_unreg_amount(BigDecimal emye_unreg_amount) {
        this.emye_unreg_amount = emye_unreg_amount;
    }

    public BigDecimal getEmye_unreg_amount() {
        return emye_unreg_amount;
    }

    public void setPNDP_TAX_AMT(BigDecimal PNDP_TAX_AMT) {
        this.PNDP_TAX_AMT = PNDP_TAX_AMT;
    }

    public BigDecimal getPNDP_TAX_AMT() {
        return PNDP_TAX_AMT;
    }

    public void setPDED_DEDCT_TAX(String PDED_DEDCT_TAX) {
        this.PDED_DEDCT_TAX = PDED_DEDCT_TAX;
    }

    public String getPDED_DEDCT_TAX() {
        return PDED_DEDCT_TAX;
    }

    public void setPDED_DEDCT_LOST_INT(String PDED_DEDCT_LOST_INT) {
        this.PDED_DEDCT_LOST_INT = PDED_DEDCT_LOST_INT;
    }

    public String getPDED_DEDCT_LOST_INT() {
        return PDED_DEDCT_LOST_INT;
    }

    public void setPDED_EST_ACTUAL(String PDED_EST_ACTUAL) {
        this.PDED_EST_ACTUAL = PDED_EST_ACTUAL;
    }

    public String getPDED_EST_ACTUAL() {
        return PDED_EST_ACTUAL;
    }

    public void setPDED_RT_AMT_TYPE(String PDED_RT_AMT_TYPE) {
        this.PDED_RT_AMT_TYPE = PDED_RT_AMT_TYPE;
    }

    public String getPDED_RT_AMT_TYPE() {
        return PDED_RT_AMT_TYPE;
    }

    public void setPDED_NET_AMOUNT(BigDecimal PDED_NET_AMOUNT) {
        this.PDED_NET_AMOUNT = PDED_NET_AMOUNT;
    }

    public BigDecimal getPDED_NET_AMOUNT() {
        return PDED_NET_AMOUNT;
    }
}
