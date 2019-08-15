package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class quotationTaxes {
  private String quoTaxDesc;
  private Double quoTaxRate;
  private Double quoTaxAmt;
  private BigDecimal quoTaxCode;
  public quotationTaxes() {
  }

  public void setQuoTaxDesc(String quoTaxDesc) {
    this.quoTaxDesc = quoTaxDesc;
  }

  public String getQuoTaxDesc() {
    return quoTaxDesc;
  }

  public void setQuoTaxRate(Double quoTaxRate) {
    this.quoTaxRate = quoTaxRate;
  }

  public Double getQuoTaxRate() {
    return quoTaxRate;
  }

  public void setQuoTaxAmt(Double quoTaxAmt) {
    this.quoTaxAmt = quoTaxAmt;
  }

  public Double getQuoTaxAmt() {
    return quoTaxAmt;
  }

    public void setQuoTaxCode(BigDecimal quoTaxCode) {
        this.quoTaxCode = quoTaxCode;
    }

    public BigDecimal getQuoTaxCode() {
        return quoTaxCode;
    }
}
