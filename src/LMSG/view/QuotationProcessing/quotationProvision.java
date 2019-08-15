package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class quotationProvision {
  public quotationProvision() {
  }
  private String quotProvshtDesc;
  private String quotProvDesc;
  private String quotProvEditable;
  private BigDecimal qpprCode;
  public void setQuotProvshtDesc(String quotProvshtDesc) {
    this.quotProvshtDesc = quotProvshtDesc;
  }

  public String getQuotProvshtDesc() {
    return quotProvshtDesc;
  }

  public void setQuotProvDesc(String quotProvDesc) {
    this.quotProvDesc = quotProvDesc;
  }

  public String getQuotProvDesc() {
    return quotProvDesc;
  }

  public void setQuotProvEditable(String quotProvEditable) {
    this.quotProvEditable = quotProvEditable;
  }

  public String getQuotProvEditable() {
    return quotProvEditable;
  }

  public void setQpprCode(BigDecimal qpprCode) {
    this.qpprCode = qpprCode;
  }

  public BigDecimal getQpprCode() {
    return qpprCode;
  }
}
