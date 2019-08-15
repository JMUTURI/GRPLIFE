package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class occupations {
  public occupations() {
  }
  private BigDecimal Gco_code;
  private String GCO_DESC;

  public void setGco_code(BigDecimal Gco_code) {
    this.Gco_code = Gco_code;
  }

  public BigDecimal getGco_code() {
    return Gco_code;
  }

  public void setGCO_DESC(String GCO_DESC) {
    this.GCO_DESC = GCO_DESC;
  }

  public String getGCO_DESC() {
    return GCO_DESC;
  }
}
