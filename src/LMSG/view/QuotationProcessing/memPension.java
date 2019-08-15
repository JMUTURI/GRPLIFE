package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.util.Date;

public class memPension {
  public memPension() {
  }
  private Date QMPNS_WEF_DATE,QMPNS_WET_DATE;
  private BigDecimal QMPNS_EARNINGS,QMPNS_EMPLOYER_CONTR,QMPNS_EMPLOYEE_CONTR,
             QMPNS_EMPLYE_VOLU_CONTR,QMPNS_TOTAL_CONTR,QMPNS_ADMIN_FEE_RATE,QMPNS_NET_ANNUAL_FUND,QMPNS_COMP_INT_RATE,
             QMPNS_ANNTY_FAC_RATE,QMPNS_PENS_ANNUM,QMPNS_EST_MAT_VAL, QMPNS_ER_EST_EMV_VAL, QMPNS_EE_EST_MAT_VAL,QMPNS_EMPLYR_REG_BAL_BF,
             QMPNS_EMPLYR_UNREG_BAL_BF,QMPNS_EMPLYE_REG_BAL_BF,
             QMPNS_EMPLYE_UNREG_BAL_BF,QMPNS_EMPLYR_REG_CONTRI_AMT,
             QMPNS_EMPLYR_UNREG_CONTRI_AMT,QMPNS_EMPLYE_REG_CONTRI_AMT,
             QMPNS_EMPLYE_UNREG_CONTRI_AMT,QMPNS_EMPLYR_LUMPSUM,
             QMPNS_ER_HIST_EST_EMV_VAL,QMPNS_EE_HIST_EST_EMV_VAL;
  private BigDecimal QMPNS_TOTAL_LIABILITY;
  private BigDecimal QMPNS_PAST_LIABILITY;
  private BigDecimal QMPNS_FUTURE_LIABILITY, QMPNS_ANN_PURCHASE_PRICE;
  private BigDecimal QMPNS_ANNUITY_AMOUNT,  QMPNS_EMPLYE_PENS_BF, QMPNS_EMPLYR_PENS_BF, QMPNS_TOT_PENS_BF;;

  public void setQMPNS_WEF_DATE(Date QMPNS_WEF_DATE) {
    this.QMPNS_WEF_DATE = QMPNS_WEF_DATE;
  }

  public Date getQMPNS_WEF_DATE() {
    return QMPNS_WEF_DATE;
  }

  public void setQMPNS_WET_DATE(Date QMPNS_WET_DATE) {
    this.QMPNS_WET_DATE = QMPNS_WET_DATE;
  }

  public Date getQMPNS_WET_DATE() {
    return QMPNS_WET_DATE;
  }

  public void setQMPNS_EARNINGS(BigDecimal QMPNS_EARNINGS) {
    this.QMPNS_EARNINGS = QMPNS_EARNINGS;
  }

  public BigDecimal getQMPNS_EARNINGS() {
    return QMPNS_EARNINGS;
  }

  public void setQMPNS_EMPLOYER_CONTR(BigDecimal QMPNS_EMPLOYER_CONTR) {
    this.QMPNS_EMPLOYER_CONTR = QMPNS_EMPLOYER_CONTR;
  }

  public BigDecimal getQMPNS_EMPLOYER_CONTR() {
    return QMPNS_EMPLOYER_CONTR;
  }

  public void setQMPNS_EMPLOYEE_CONTR(BigDecimal QMPNS_EMPLOYEE_CONTR) {
    this.QMPNS_EMPLOYEE_CONTR = QMPNS_EMPLOYEE_CONTR;
  }

  public BigDecimal getQMPNS_EMPLOYEE_CONTR() {
    return QMPNS_EMPLOYEE_CONTR;
  }

  public void setQMPNS_EMPLYE_VOLU_CONTR(BigDecimal QMPNS_EMPLYE_VOLU_CONTR) {
    this.QMPNS_EMPLYE_VOLU_CONTR = QMPNS_EMPLYE_VOLU_CONTR;
  }

  public BigDecimal getQMPNS_EMPLYE_VOLU_CONTR() {
    return QMPNS_EMPLYE_VOLU_CONTR;
  }

  public void setQMPNS_TOTAL_CONTR(BigDecimal QMPNS_TOTAL_CONTR) {
    this.QMPNS_TOTAL_CONTR = QMPNS_TOTAL_CONTR;
  }

  public BigDecimal getQMPNS_TOTAL_CONTR() {
    return QMPNS_TOTAL_CONTR;
  }

  public void setQMPNS_ADMIN_FEE_RATE(BigDecimal QMPNS_ADMIN_FEE_RATE) {
    this.QMPNS_ADMIN_FEE_RATE = QMPNS_ADMIN_FEE_RATE;
  }

  public BigDecimal getQMPNS_ADMIN_FEE_RATE() {
    return QMPNS_ADMIN_FEE_RATE;
  }

  public void setQMPNS_NET_ANNUAL_FUND(BigDecimal QMPNS_NET_ANNUAL_FUND) {
    this.QMPNS_NET_ANNUAL_FUND = QMPNS_NET_ANNUAL_FUND;
  }

  public BigDecimal getQMPNS_NET_ANNUAL_FUND() {
    return QMPNS_NET_ANNUAL_FUND;
  }

  public void setQMPNS_COMP_INT_RATE(BigDecimal QMPNS_COMP_INT_RATE) {
    this.QMPNS_COMP_INT_RATE = QMPNS_COMP_INT_RATE;
  }

  public BigDecimal getQMPNS_COMP_INT_RATE() {
    return QMPNS_COMP_INT_RATE;
  }

  public void setQMPNS_ANNTY_FAC_RATE(BigDecimal QMPNS_ANNTY_FAC_RATE) {
    this.QMPNS_ANNTY_FAC_RATE = QMPNS_ANNTY_FAC_RATE;
  }

  public BigDecimal getQMPNS_ANNTY_FAC_RATE() {
    return QMPNS_ANNTY_FAC_RATE;
  }

  public void setQMPNS_PENS_ANNUM(BigDecimal QMPNS_PENS_ANNUM) {
    this.QMPNS_PENS_ANNUM = QMPNS_PENS_ANNUM;
  }

  public BigDecimal getQMPNS_PENS_ANNUM() {
    return QMPNS_PENS_ANNUM;
  }

  public void setQMPNS_EST_MAT_VAL(BigDecimal QMPNS_EST_MAT_VAL) {
    this.QMPNS_EST_MAT_VAL = QMPNS_EST_MAT_VAL;
  }

  public BigDecimal getQMPNS_EST_MAT_VAL() {
    return QMPNS_EST_MAT_VAL;
  }

    public void setQMPNS_ER_EST_EMV_VAL(BigDecimal QMPNS_ER_EST_EMV_VAL) {
        this.QMPNS_ER_EST_EMV_VAL = QMPNS_ER_EST_EMV_VAL;
    }

    public BigDecimal getQMPNS_ER_EST_EMV_VAL() {
        return QMPNS_ER_EST_EMV_VAL;
    }

    public void setQMPNS_EE_EST_MAT_VAL(BigDecimal QMPNS_EE_EST_MAT_VAL) {
        this.QMPNS_EE_EST_MAT_VAL = QMPNS_EE_EST_MAT_VAL;
    }

    public BigDecimal getQMPNS_EE_EST_MAT_VAL() {
        return QMPNS_EE_EST_MAT_VAL;
    }

    public void setQMPNS_TOTAL_LIABILITY(BigDecimal QMPNS_TOTAL_LIABILITY) {
        this.QMPNS_TOTAL_LIABILITY = QMPNS_TOTAL_LIABILITY;
    }

    public BigDecimal getQMPNS_TOTAL_LIABILITY() {
        return QMPNS_TOTAL_LIABILITY;
    }

    public void setQMPNS_PAST_LIABILITY(BigDecimal QMPNS_PAST_LIABILITY) {
        this.QMPNS_PAST_LIABILITY = QMPNS_PAST_LIABILITY;
    }

    public BigDecimal getQMPNS_PAST_LIABILITY() {
        return QMPNS_PAST_LIABILITY;
    }

    public void setQMPNS_FUTURE_LIABILITY(BigDecimal QMPNS_FUTURE_LIABILITY) {
        this.QMPNS_FUTURE_LIABILITY = QMPNS_FUTURE_LIABILITY;
    }

    public BigDecimal getQMPNS_FUTURE_LIABILITY() {
        return QMPNS_FUTURE_LIABILITY;
    }

    public void setQMPNS_ANNUITY_AMOUNT(BigDecimal QMPNS_ANNUITY_AMOUNT) {
        this.QMPNS_ANNUITY_AMOUNT = QMPNS_ANNUITY_AMOUNT;
    }

    public BigDecimal getQMPNS_ANNUITY_AMOUNT() {
        return QMPNS_ANNUITY_AMOUNT;
    }

    public void setQMPNS_EMPLYE_PENS_BF(BigDecimal QMPNS_EMPLYE_PENS_BF) {
        this.QMPNS_EMPLYE_PENS_BF = QMPNS_EMPLYE_PENS_BF;
    }

    public BigDecimal getQMPNS_EMPLYE_PENS_BF() {
        return QMPNS_EMPLYE_PENS_BF;
    }

    public void setQMPNS_EMPLYR_PENS_BF(BigDecimal QMPNS_EMPLYR_PENS_BF) {
        this.QMPNS_EMPLYR_PENS_BF = QMPNS_EMPLYR_PENS_BF;
    }

    public BigDecimal getQMPNS_EMPLYR_PENS_BF() {
        return QMPNS_EMPLYR_PENS_BF;
    }

    public void setQMPNS_TOT_PENS_BF(BigDecimal QMPNS_TOT_PENS_BF) {
        this.QMPNS_TOT_PENS_BF = QMPNS_TOT_PENS_BF;
    }

    public BigDecimal getQMPNS_TOT_PENS_BF() {
        return QMPNS_TOT_PENS_BF;
    }

    public void setQMPNS_ANN_PURCHASE_PRICE(BigDecimal QMPNS_ANN_PURCHASE_PRICE) {
        this.QMPNS_ANN_PURCHASE_PRICE = QMPNS_ANN_PURCHASE_PRICE;
    }

    public BigDecimal getQMPNS_ANN_PURCHASE_PRICE() {
        return QMPNS_ANN_PURCHASE_PRICE;
    }

    public void setQMPNS_EMPLYR_REG_BAL_BF(BigDecimal QMPNS_EMPLYR_REG_BAL_BF) {
        this.QMPNS_EMPLYR_REG_BAL_BF = QMPNS_EMPLYR_REG_BAL_BF;
    }

    public BigDecimal getQMPNS_EMPLYR_REG_BAL_BF() {
        return QMPNS_EMPLYR_REG_BAL_BF;
    }

    public void setQMPNS_EMPLYR_UNREG_BAL_BF(BigDecimal QMPNS_EMPLYR_UNREG_BAL_BF) {
        this.QMPNS_EMPLYR_UNREG_BAL_BF = QMPNS_EMPLYR_UNREG_BAL_BF;
    }

    public BigDecimal getQMPNS_EMPLYR_UNREG_BAL_BF() {
        return QMPNS_EMPLYR_UNREG_BAL_BF;
    }

    public void setQMPNS_EMPLYE_REG_BAL_BF(BigDecimal QMPNS_EMPLYE_REG_BAL_BF) {
        this.QMPNS_EMPLYE_REG_BAL_BF = QMPNS_EMPLYE_REG_BAL_BF;
    }

    public BigDecimal getQMPNS_EMPLYE_REG_BAL_BF() {
        return QMPNS_EMPLYE_REG_BAL_BF;
    }

    public void setQMPNS_EMPLYE_UNREG_BAL_BF(BigDecimal QMPNS_EMPLYE_UNREG_BAL_BF) {
        this.QMPNS_EMPLYE_UNREG_BAL_BF = QMPNS_EMPLYE_UNREG_BAL_BF;
    }

    public BigDecimal getQMPNS_EMPLYE_UNREG_BAL_BF() {
        return QMPNS_EMPLYE_UNREG_BAL_BF;
    }

    public void setQMPNS_EMPLYR_REG_CONTRI_AMT(BigDecimal QMPNS_EMPLYR_REG_CONTRI_AMT) {
        this.QMPNS_EMPLYR_REG_CONTRI_AMT = QMPNS_EMPLYR_REG_CONTRI_AMT;
    }

    public BigDecimal getQMPNS_EMPLYR_REG_CONTRI_AMT() {
        return QMPNS_EMPLYR_REG_CONTRI_AMT;
    }

    public void setQMPNS_EMPLYR_UNREG_CONTRI_AMT(BigDecimal QMPNS_EMPLYR_UNREG_CONTRI_AMT) {
        this.QMPNS_EMPLYR_UNREG_CONTRI_AMT = QMPNS_EMPLYR_UNREG_CONTRI_AMT;
    }

    public BigDecimal getQMPNS_EMPLYR_UNREG_CONTRI_AMT() {
        return QMPNS_EMPLYR_UNREG_CONTRI_AMT;
    }

    public void setQMPNS_EMPLYE_REG_CONTRI_AMT(BigDecimal QMPNS_EMPLYE_REG_CONTRI_AMT) {
        this.QMPNS_EMPLYE_REG_CONTRI_AMT = QMPNS_EMPLYE_REG_CONTRI_AMT;
    }

    public BigDecimal getQMPNS_EMPLYE_REG_CONTRI_AMT() {
        return QMPNS_EMPLYE_REG_CONTRI_AMT;
    }

    public void setQMPNS_EMPLYE_UNREG_CONTRI_AMT(BigDecimal QMPNS_EMPLYE_UNREG_CONTRI_AMT) {
        this.QMPNS_EMPLYE_UNREG_CONTRI_AMT = QMPNS_EMPLYE_UNREG_CONTRI_AMT;
    }

    public BigDecimal getQMPNS_EMPLYE_UNREG_CONTRI_AMT() {
        return QMPNS_EMPLYE_UNREG_CONTRI_AMT;
    }

    public void setQMPNS_EMPLYR_LUMPSUM(BigDecimal QMPNS_EMPLYR_LUMPSUM) {
        this.QMPNS_EMPLYR_LUMPSUM = QMPNS_EMPLYR_LUMPSUM;
    }

    public BigDecimal getQMPNS_EMPLYR_LUMPSUM() {
        return QMPNS_EMPLYR_LUMPSUM;
    }

    public void setQMPNS_ER_HIST_EST_EMV_VAL(BigDecimal QMPNS_ER_HIST_EST_EMV_VAL) {
        this.QMPNS_ER_HIST_EST_EMV_VAL = QMPNS_ER_HIST_EST_EMV_VAL;
    }

    public BigDecimal getQMPNS_ER_HIST_EST_EMV_VAL() {
        return QMPNS_ER_HIST_EST_EMV_VAL;
    }

    public void setQMPNS_EE_HIST_EST_EMV_VAL(BigDecimal QMPNS_EE_HIST_EST_EMV_VAL) {
        this.QMPNS_EE_HIST_EST_EMV_VAL = QMPNS_EE_HIST_EST_EMV_VAL;
    }

    public BigDecimal getQMPNS_EE_HIST_EST_EMV_VAL() {
        return QMPNS_EE_HIST_EST_EMV_VAL;
    }
}
