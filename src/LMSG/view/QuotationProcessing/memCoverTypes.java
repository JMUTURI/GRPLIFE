package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.util.Date;

public class memCoverTypes {
  public memCoverTypes() {
  }
  private String cover_display;
  private Date QCM_COVER_WEF_DATE,QCM_COVER_WET_DATE,QCM_LOAN_ISSUE_DATE;
  private BigDecimal QCM_SA,QCM_LOAD_DISC_PREM,QCM_PREMIUM,QCM_ORIGINAL_LOAN_AMT,
            QCM_ORIG_LOAN_REPAYMENT_PRD,QCM_SAVING_AMT;

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
}
