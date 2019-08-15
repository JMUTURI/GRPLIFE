package LMSG.view.Policy;

import java.math.BigDecimal;

import java.util.Date;

public class PremiumCard {
  public PremiumCard() {
  }
  private String POL_POLICY_NO,CLIENT,PRODUCT_DISPLAY,BRANCH_DISPLAY,POL_FREQ_OF_PAYMENT,PRP_PIN,PRP_PAYROLL_NO,
        AGENT_DISPLAY,PROD_TYPE;
      private Date POL_EFFECTIVE_DATE,POL_PAID_TO_DATE;
      private BigDecimal POL_TOT_INSTLMT,POL_PAID_INSTLMT_NO, OS_INSTALMENTS, PREM_ALLOC, PENS_ALLOC, ALL_ALLOC,
      POL_PENS_INSTLMT_PREM,POL_INSTLMT_PREM,POL_OS_INSTLMT_NO,POL_OS_PREM_BAL_AMT;
      
    private BigDecimal GGTRAN_DTLS_TRAN_CODE, GTRAN_DTLS_PENS_ALLOC, GTRAN_DTLS_PREM_ALLOC, GTRAN_DTLS_TOT_ALLOC;
    private String GRCT_RECEIPT_NO, GTRAN_POL_POLICY_FROM, GTRAN_POL_POLICY_TO, GTRAN_DTLS_STATUS,
        GTRAN_DTLS_REMARKS;
                

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

  public void setPRODUCT_DISPLAY(String PRODUCT_DISPLAY) {
    this.PRODUCT_DISPLAY = PRODUCT_DISPLAY;
  }

  public String getPRODUCT_DISPLAY() {
    return PRODUCT_DISPLAY;
  }

  public void setBRANCH_DISPLAY(String BRANCH_DISPLAY) {
    this.BRANCH_DISPLAY = BRANCH_DISPLAY;
  }

  public String getBRANCH_DISPLAY() {
    return BRANCH_DISPLAY;
  }

  public void setPOL_FREQ_OF_PAYMENT(String POL_FREQ_OF_PAYMENT) {
    this.POL_FREQ_OF_PAYMENT = POL_FREQ_OF_PAYMENT;
  }

  public String getPOL_FREQ_OF_PAYMENT() {
    return POL_FREQ_OF_PAYMENT;
  }

  public void setPRP_PIN(String PRP_PIN) {
    this.PRP_PIN = PRP_PIN;
  }

  public String getPRP_PIN() {
    return PRP_PIN;
  }

  public void setPRP_PAYROLL_NO(String PRP_PAYROLL_NO) {
    this.PRP_PAYROLL_NO = PRP_PAYROLL_NO;
  }

  public String getPRP_PAYROLL_NO() {
    return PRP_PAYROLL_NO;
  }

  public void setAGENT_DISPLAY(String AGENT_DISPLAY) {
    this.AGENT_DISPLAY = AGENT_DISPLAY;
  }

  public String getAGENT_DISPLAY() {
    return AGENT_DISPLAY;
  }

  public void setPOL_EFFECTIVE_DATE(Date POL_EFFECTIVE_DATE) {
    this.POL_EFFECTIVE_DATE = POL_EFFECTIVE_DATE;
  }

  public Date getPOL_EFFECTIVE_DATE() {
    return POL_EFFECTIVE_DATE;
  }

  public void setPOL_PAID_TO_DATE(Date POL_PAID_TO_DATE) {
    this.POL_PAID_TO_DATE = POL_PAID_TO_DATE;
  }

  public Date getPOL_PAID_TO_DATE() {
    return POL_PAID_TO_DATE;
  }

  public void setPOL_TOT_INSTLMT(BigDecimal POL_TOT_INSTLMT) {
    this.POL_TOT_INSTLMT = POL_TOT_INSTLMT;
  }

  public BigDecimal getPOL_TOT_INSTLMT() {
    return POL_TOT_INSTLMT;
  }

  public void setPOL_PAID_INSTLMT_NO(BigDecimal POL_PAID_INSTLMT_NO) {
    this.POL_PAID_INSTLMT_NO = POL_PAID_INSTLMT_NO;
  }

  public BigDecimal getPOL_PAID_INSTLMT_NO() {
    return POL_PAID_INSTLMT_NO;
  }

  public void setOS_INSTALMENTS(BigDecimal OS_INSTALMENTS) {
    this.OS_INSTALMENTS = OS_INSTALMENTS;
  }

  public BigDecimal getOS_INSTALMENTS() {
    return OS_INSTALMENTS;
  }

  public void setPOL_PENS_INSTLMT_PREM(BigDecimal POL_PENS_INSTLMT_PREM) {
    this.POL_PENS_INSTLMT_PREM = POL_PENS_INSTLMT_PREM;
  }

  public BigDecimal getPOL_PENS_INSTLMT_PREM() {
    return POL_PENS_INSTLMT_PREM;
  }

  public void setPOL_INSTLMT_PREM(BigDecimal POL_INSTLMT_PREM) {
    this.POL_INSTLMT_PREM = POL_INSTLMT_PREM;
  }

  public BigDecimal getPOL_INSTLMT_PREM() {
    return POL_INSTLMT_PREM;
  }

  public void setPOL_OS_INSTLMT_NO(BigDecimal POL_OS_INSTLMT_NO) {
    this.POL_OS_INSTLMT_NO = POL_OS_INSTLMT_NO;
  }

  public BigDecimal getPOL_OS_INSTLMT_NO() {
    return POL_OS_INSTLMT_NO;
  }

  public void setPOL_OS_PREM_BAL_AMT(BigDecimal POL_OS_PREM_BAL_AMT) {
    this.POL_OS_PREM_BAL_AMT = POL_OS_PREM_BAL_AMT;
  }

  public BigDecimal getPOL_OS_PREM_BAL_AMT() {
    return POL_OS_PREM_BAL_AMT;
  }

  public void setPROD_TYPE(String PROD_TYPE) {
    this.PROD_TYPE = PROD_TYPE;
  }

  public String getPROD_TYPE() {
    return PROD_TYPE;
  }

    public void setPREM_ALLOC(BigDecimal PREM_ALLOC) {
        this.PREM_ALLOC = PREM_ALLOC;
    }

    public BigDecimal getPREM_ALLOC() {
        return PREM_ALLOC;
    }

    public void setPENS_ALLOC(BigDecimal PENS_ALLOC) {
        this.PENS_ALLOC = PENS_ALLOC;
    }

    public BigDecimal getPENS_ALLOC() {
        return PENS_ALLOC;
    }

    public void setALL_ALLOC(BigDecimal ALL_ALLOC) {
        this.ALL_ALLOC = ALL_ALLOC;
    }

    public BigDecimal getALL_ALLOC() {
        return ALL_ALLOC;
    }

    public void setGGTRAN_DTLS_TRAN_CODE(BigDecimal GGTRAN_DTLS_TRAN_CODE) {
        this.GGTRAN_DTLS_TRAN_CODE = GGTRAN_DTLS_TRAN_CODE;
    }

    public BigDecimal getGGTRAN_DTLS_TRAN_CODE() {
        return GGTRAN_DTLS_TRAN_CODE;
    }

    public void setGTRAN_DTLS_PENS_ALLOC(BigDecimal GTRAN_DTLS_PENS_ALLOC) {
        this.GTRAN_DTLS_PENS_ALLOC = GTRAN_DTLS_PENS_ALLOC;
    }

    public BigDecimal getGTRAN_DTLS_PENS_ALLOC() {
        return GTRAN_DTLS_PENS_ALLOC;
    }

    public void setGTRAN_DTLS_PREM_ALLOC(BigDecimal GTRAN_DTLS_PREM_ALLOC) {
        this.GTRAN_DTLS_PREM_ALLOC = GTRAN_DTLS_PREM_ALLOC;
    }

    public BigDecimal getGTRAN_DTLS_PREM_ALLOC() {
        return GTRAN_DTLS_PREM_ALLOC;
    }

    public void setGTRAN_DTLS_TOT_ALLOC(BigDecimal GTRAN_DTLS_TOT_ALLOC) {
        this.GTRAN_DTLS_TOT_ALLOC = GTRAN_DTLS_TOT_ALLOC;
    }

    public BigDecimal getGTRAN_DTLS_TOT_ALLOC() {
        return GTRAN_DTLS_TOT_ALLOC;
    }

    public void setGRCT_RECEIPT_NO(String GRCT_RECEIPT_NO) {
        this.GRCT_RECEIPT_NO = GRCT_RECEIPT_NO;
    }

    public String getGRCT_RECEIPT_NO() {
        return GRCT_RECEIPT_NO;
    }

    public void setGTRAN_POL_POLICY_FROM(String GTRAN_POL_POLICY_FROM) {
        this.GTRAN_POL_POLICY_FROM = GTRAN_POL_POLICY_FROM;
    }

    public String getGTRAN_POL_POLICY_FROM() {
        return GTRAN_POL_POLICY_FROM;
    }

    public void setGTRAN_POL_POLICY_TO(String GTRAN_POL_POLICY_TO) {
        this.GTRAN_POL_POLICY_TO = GTRAN_POL_POLICY_TO;
    }

    public String getGTRAN_POL_POLICY_TO() {
        return GTRAN_POL_POLICY_TO;
    }

    public void setGTRAN_DTLS_STATUS(String GTRAN_DTLS_STATUS) {
        this.GTRAN_DTLS_STATUS = GTRAN_DTLS_STATUS;
    }

    public String getGTRAN_DTLS_STATUS() {
        return GTRAN_DTLS_STATUS;
    }

    public void setGTRAN_DTLS_REMARKS(String GTRAN_DTLS_REMARKS) {
        this.GTRAN_DTLS_REMARKS = GTRAN_DTLS_REMARKS;
    }

    public String getGTRAN_DTLS_REMARKS() {
        return GTRAN_DTLS_REMARKS;
    }
}
