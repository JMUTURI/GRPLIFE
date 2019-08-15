package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class prodDependents {
  public prodDependents() {
  }
  private BigDecimal DTY_CODE,max_allowed;
 private String  DTY_SHT_DESC, DTY_DESCRIPTION;

  public void setDTY_CODE(BigDecimal DTY_CODE) {
    this.DTY_CODE = DTY_CODE;
  }

  public BigDecimal getDTY_CODE() {
    return DTY_CODE;
  }

  public void setDTY_SHT_DESC(String DTY_SHT_DESC) {
    this.DTY_SHT_DESC = DTY_SHT_DESC;
  }

  public String getDTY_SHT_DESC() {
    return DTY_SHT_DESC;
  }

  public void setDTY_DESCRIPTION(String DTY_DESCRIPTION) {
    this.DTY_DESCRIPTION = DTY_DESCRIPTION;
  }

  public String getDTY_DESCRIPTION() {
    return DTY_DESCRIPTION;
  }

  public void setMax_allowed(BigDecimal max_allowed) {
    this.max_allowed = max_allowed;
  }

  public BigDecimal getMax_allowed() {
    return max_allowed;
  }
}
