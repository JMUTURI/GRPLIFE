package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class branches {
  public branches() {
  }
  private BigDecimal BRN_CODE;
  private String BRN_SHT_DESC,BRN_NAME;

  public void setBRN_CODE(BigDecimal BRN_CODE) {
    this.BRN_CODE = BRN_CODE;
  }

  public BigDecimal getBRN_CODE() {
    return BRN_CODE;
  }

  public void setBRN_SHT_DESC(String BRN_SHT_DESC) {
    this.BRN_SHT_DESC = BRN_SHT_DESC;
  }

  public String getBRN_SHT_DESC() {
    return BRN_SHT_DESC;
  }

  public void setBRN_NAME(String BRN_NAME) {
    this.BRN_NAME = BRN_NAME;
  }

  public String getBRN_NAME() {
    return BRN_NAME;
  }
}
