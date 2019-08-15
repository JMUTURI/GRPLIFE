package LMSG.view.Policy;

import java.math.BigDecimal;

import java.util.Date;

public class PolicyReceipts {
  public PolicyReceipts() {
  }
  private BigDecimal GRCT_CODE;
  private String GRCT_RECEIPT_NO;
  private Date GRCT_RECEIPT_DATE;
  private String GRCT_PAY_METHOD;
  private String GRCT_CHEQUE_NO;
  private BigDecimal GRCT_AMT;
  private String GRCT_COMM_INCLUSIVE;
  private BigDecimal GRCT_GROSS_AMNT;
  private BigDecimal GRCT_PREM_PYMNT_AMT;
  private BigDecimal GRCT_PENS_PYMT_AMT;
  private BigDecimal BALANCE_AMT;
  private BigDecimal GRCT_PREM_ALLOCATE;
  private BigDecimal GRCT_PENS_ALLOCATE;
  private String grct_status;
  private String grct_drcr;
  
  private BigDecimal mem_alloc_amt;
  private BigDecimal mem_alloc_balance;

  public void setGRCT_CODE(BigDecimal GRCT_CODE) {
    this.GRCT_CODE = GRCT_CODE;
  }

  public BigDecimal getGRCT_CODE() {
    return GRCT_CODE;
  }

  public void setGRCT_RECEIPT_NO(String GRCT_RECEIPT_NO) {
    this.GRCT_RECEIPT_NO = GRCT_RECEIPT_NO;
  }

  public String getGRCT_RECEIPT_NO() {
    return GRCT_RECEIPT_NO;
  }

  public void setGRCT_RECEIPT_DATE(Date GRCT_RECEIPT_DATE) {
    this.GRCT_RECEIPT_DATE = GRCT_RECEIPT_DATE;
  }

  public Date getGRCT_RECEIPT_DATE() {
    return GRCT_RECEIPT_DATE;
  }

  public void setGRCT_PAY_METHOD(String GRCT_PAY_METHOD) {
    this.GRCT_PAY_METHOD = GRCT_PAY_METHOD;
  }

  public String getGRCT_PAY_METHOD() {
    return GRCT_PAY_METHOD;
  }

  public void setGRCT_CHEQUE_NO(String GRCT_CHEQUE_NO) {
    this.GRCT_CHEQUE_NO = GRCT_CHEQUE_NO;
  }

  public String getGRCT_CHEQUE_NO() {
    return GRCT_CHEQUE_NO;
  }

  public void setGRCT_AMT( BigDecimal GRCT_AMT) {
    this.GRCT_AMT = GRCT_AMT;
  }

  public  BigDecimal getGRCT_AMT() {
    return GRCT_AMT;
  }

  public void setGRCT_COMM_INCLUSIVE(String GRCT_COMM_INCLUSIVE) {
    this.GRCT_COMM_INCLUSIVE = GRCT_COMM_INCLUSIVE;
  }

  public String getGRCT_COMM_INCLUSIVE() {
    return GRCT_COMM_INCLUSIVE;
  }

  public void setGRCT_GROSS_AMNT(BigDecimal GRCT_GROSS_AMNT) {
    this.GRCT_GROSS_AMNT = GRCT_GROSS_AMNT;
  }

  public BigDecimal getGRCT_GROSS_AMNT() {
    return GRCT_GROSS_AMNT;
  }

  public void setGRCT_PREM_PYMNT_AMT(BigDecimal GRCT_PREM_PYMNT_AMT) {
    this.GRCT_PREM_PYMNT_AMT = GRCT_PREM_PYMNT_AMT;
  }

  public BigDecimal getGRCT_PREM_PYMNT_AMT() {
    return GRCT_PREM_PYMNT_AMT;
  }

  public void setGRCT_PENS_PYMT_AMT(BigDecimal GRCT_PENS_PYMT_AMT) {
    this.GRCT_PENS_PYMT_AMT = GRCT_PENS_PYMT_AMT;
  }

  public BigDecimal getGRCT_PENS_PYMT_AMT() {
    return GRCT_PENS_PYMT_AMT;
  }

  public void setBALANCE_AMT(BigDecimal BALANCE_AMT) {
    this.BALANCE_AMT = BALANCE_AMT;
  }

  public BigDecimal getBALANCE_AMT() {
    return BALANCE_AMT;
  }

  public void setGRCT_PREM_ALLOCATE(BigDecimal GRCT_PREM_ALLOCATE) {
    this.GRCT_PREM_ALLOCATE = GRCT_PREM_ALLOCATE;
  }

  public BigDecimal getGRCT_PREM_ALLOCATE() {
    return GRCT_PREM_ALLOCATE;
  }

  public void setGRCT_PENS_ALLOCATE(BigDecimal GRCT_PENS_ALLOCATE) {
    this.GRCT_PENS_ALLOCATE = GRCT_PENS_ALLOCATE;
  }

  public BigDecimal getGRCT_PENS_ALLOCATE() {
    return GRCT_PENS_ALLOCATE;
  }

    public void setGrct_status(String grct_status) {
        this.grct_status = grct_status;
    }

    public String getGrct_status() {
        return grct_status;
    }

    public void setGrct_drcr(String grct_drcr) {
        this.grct_drcr = grct_drcr;
    }

    public String getGrct_drcr() {
        return grct_drcr;
    }

    public void setMem_alloc_amt(BigDecimal mem_alloc_amt) {
        this.mem_alloc_amt = mem_alloc_amt;
    }

    public BigDecimal getMem_alloc_amt() {
        return mem_alloc_amt;
    }

    public void setMem_alloc_balance(BigDecimal mem_alloc_balance) {
        this.mem_alloc_balance = mem_alloc_balance;
    }

    public BigDecimal getMem_alloc_balance() {
        return mem_alloc_balance;
    }
}
